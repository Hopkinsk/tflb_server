package com.bch.tflb
import com.bch.tflb.Study
import com.bch.tflb.Alcohol
import com.bch.tflb.Marijuana
import grails.converters.JSON


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
            def study = new Study()
            study.date = data.date
            study.studyId = data.studyId 
            study.complete = 0
            study.safetyTriggered = 0

            study.save(failonError: true)
            println "STUDY"
            println study
            render (status: 200, text: (study as JSON), contentType: "application/json")
        } else {
            println "here"
            render(status: 400, contentType: "application/json")
        }
    }

    def delete(params){
        if(params.id){
            def study = Study.get(params.id)



            if(study){
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
