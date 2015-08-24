package com.bch.tflb
import com.bch.tflb.Study
import com.bch.tflb.Alcohol
import com.bch.tflb.Marijuana
import grails.converters.JSON


class StudyController {

    def studyService


    def index(params){
        println "STUDY SHOW"
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
            study.studyId = data.studyId 
            study.save(failonError: true)
            println "STUDY"
            println study
            render (status: 200, text: (study as JSON), contentType: "application/json")
        } else {
            println "here"
            render(status: 400, contentType: "application/json")
        }
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
