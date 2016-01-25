package com.bch.tflb
import com.bch.tflb.Study
import com.bch.tflb.Alcohol
import com.bch.tflb.Marijuana
import grails.converters.JSON
import org.apache.commons.io.IOUtils

class StudyController {

    def studyService
    def alcoholService
    def marijuanaService


    def list(){
        def studies = Study.findAll()
        render (status: 200, text: (studies as JSON), contentType: "application/json")
    }

    def export(params){
        if(params.containsKey("ids")){
            def ids = JSON.parse(params.ids)
            def studiesFile = studyService.export(ids)
            response.setContentType("text/csv")
            response.setHeader("Content-disposition", "attachment; filename=\"tflb_export.csv\"")
            response.outputStream << studiesFile.bytes
            response.outputStream.flush()
            response.outputStream.close()
        }   
    }

    def index(params){
        if(params.id){
            def study = studyService.getCompleteStudy(params.id)
            if(!study.error){
                render (status: 200, text: (study as JSON), contentType: "application/json")
            } else {
                render (status: 400, text: (study as JSON), contentType: "application/json")
            }
        }
        render(status: 400, contentType: "application/json")
    }

    def save(params){
        def data = request.JSON
        if(data && data.studyId){
            def validStudyId = studyService.validStudyId(data.studyId)
            if(validStudyId){   
                def study = new Study()
                study.date = data.date
                study.studyId = data.studyId 
                study.complete = 0
                study.dailyMarijuana = 0
                study.save(failonError: true)
                render (status: 200, text: (study as JSON), contentType: "application/json")
            } else {
                render (status: 400, text: "Error: Study ID already exists.", contentType: "application/json")
            }
        } else {
            render(status: 400, contentType: "application/json")
        }
    }

    def update(params){
        def json = request.JSON
        if(params.id){
            def study = Study.get(params.id)
            if(study){
                if(json.studyComplete){
                    study.complete = json.studyComplete ? 1 : 0
                    study.save(failonError: true)
                    def safetyTriggered = alcoholService.safetyTriggered(study.id)
                    render (status: 200, text: [safetyTriggered: safetyTriggered] as JSON, contentType: "application/json")
                    return
                }
            }
        }
        render(status: 400, contentType: "application/json")
    }

    def delete(params){
        if(params.id){
            def study = Study.get(params.id)
            if(study){
                marijuanaService.deleteAllByStudy(study.id)
                alcoholService.deleteAllByStudy(study.id)
                study.delete()
                render (status: 200, contentType: "application/json")
                return
            }
        }
        render(status: 400, contentType: "application/json")
    }
}
