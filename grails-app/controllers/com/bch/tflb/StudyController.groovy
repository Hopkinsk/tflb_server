package com.bch.tflb
import com.bch.tflb.Study
import com.bch.tflb.Alcohol
import com.bch.tflb.Marijuana
import grails.converters.JSON
import org.apache.commons.io.IOUtils

class StudyController {

    def studyService

    def list(){
        println "LIST STUDIES"
        def studies = Study.findAll()
        println studies
        println studies as JSON
        studies.each { study ->
            println study as JSON

        }
/*
        def studies = Study.find().collect {

            [
               // id: it.id,

               // studyId: it.study_id,
                complete: it.complete,
                safetyTriggered: it.safety_triggered,
                date: it.dateCreated
            ]
        }
*/
        render (status: 200, text: (studies as JSON), contentType: "application/json")

    }


    //POST /study/export
    def export(params){
        println "PARAMS"
        println params
        if(params.containsKey("ids")){

            def ids = JSON.parse(params.ids)

            println "IDS"
            println ids.getClass().name

            if(ids){
                def studiesFile = studyService.export(ids)
                InputStream contentStream
                try {
                    response.setHeader "Content-disposition", "attachment;filename=test.csv"
                    response.setHeader("Content-Length", studiesFile.length().toString())
                    response.setContentType('text/csv');
                    response.setHeader("Content-Type", "text/csv") 
                    contentStream = studiesFile.newInputStream()
                    response.outputStream << contentStream
                    response.outputStream.flush()
                   // webRequest.renderView = false

                } finally {
                    IOUtils.closeQuietly(contentStream)
                }

            }
        }
    }

    def index(params){
        if(params.id){
            studyService.getCompleteStudy(params.id)
            render (status: 200, text: (studyService.getCompleteStudy(params.id) as JSON), contentType: "application/json")
        }
        render(status: 400, contentType: "application/json")
    }

    def save(params){
        println "SAVE STUDY "
        def data = request.JSON
        println "DATA"
        println data

        
        if(data && data.studyId){

            def validStudyId = studyService.validStudyId(data.studyId)
            if(validStudyId){   
            println "GOING" 
                def study = new Study()
                study.date = data.date
                study.studyId = data.studyId 
                study.complete = 0
                study.safetyTriggered = 0
                study.save(failonError: true)
                render (status: 200, text: (study as JSON), contentType: "application/json")

            } else {
                render (status: 400, text: "Error: Study ID already exists.", contentType: "application/json")
            }
        } else {
            render(status: 400, contentType: "application/json")
        }
    }

    def delete(params){
        if(params.id){
            def study = Study.get(params.id)



            if(study){
                //TODO
                //def studyId =
                //def marijuana = Marijuana.findByStudyId()
                study.delete()
                render (status: 200, contentType: "application/json")
                return
            }
        }
        render(status: 400, contentType: "application/json")

    }
/*
    def create(params) { 
        def data = request.JSON
    	if(data && data.studyId){
    		def study = new Study()
    		study.studyId = data.studyId 
    		study.save(failonError: true)
            render (status: 200, text: (study as JSON), contentType: "application/json")
    	} else {
            render(status: 400, contentType: "application/json")
        }
    }
*/


}
