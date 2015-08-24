package com.bch.tflb
import com.bch.tflb.Study
import com.bch.tflb.Alcohol
import com.bch.tflb.Marijuana
import grails.converters.JSON


class DayController {

	    /*
	{
	    "study_id":1,
	    "date": "2015-08-10",
	    "dayNumber": 5,
	    "marijuana": true,
	    "drinks" : 4
	}
    */
    def studyService

    def save(params){
    	println "SAVE CONTROLLER!"
    	def json = request.JSON
    	println "json"
    	println json

    	
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