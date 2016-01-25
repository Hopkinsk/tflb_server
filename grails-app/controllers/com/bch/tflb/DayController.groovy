package com.bch.tflb
import com.bch.tflb.Study
import com.bch.tflb.Alcohol
import com.bch.tflb.Marijuana
import grails.converters.JSON


class DayController {

    def studyService

    def save(params){
    	def json = request.JSON
    	if(json.study_id && studyService.studyExists(json.study_id)){
    		studyService.updateStudyDay(json)
    		render (status: 200, contentType: "application/json")
    	} else {
    		render(status: 400, contentType: "application/json")
    	}
    }

    def update(params){
    	def json = request.JSON
    	if(json.study_id && studyService.studyExists(json.study_id)){
    		studyService.updateStudyDay(json)
    		render (status: 200, contentType: "application/json")
    	} else {
    		render(status: 400, contentType: "application/json")
    	}
    }
}