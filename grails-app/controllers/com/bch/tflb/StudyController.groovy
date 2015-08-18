package com.bch.tflb
import com.bch.tflb.Study
import com.bch.tflb.Alcohol
import com.bch.tflb.Marijuana
import grails.converters.JSON


class StudyController {

	/*
	input study id —> saves study (params: studyId)
url: “study/create"
— now there is a Entities.currentStudy
— create row in study table for new study participant 
— render that new entry 	

	*/
    def studyService

    def create(params) { 
    	println "CREATE"
    	def data = request.JSON
    	println data
    	if(data){
    		def study = new Study()
    		study.studyId = data.studyId 
    		study.save(failonError: true)
            studyService.initialize(study.studyId)
    		//TODO: if error, render and display error
            render (status: 200, text: (study as JSON), contentType: "application/json")
    	}
    }
    def monitor(params) { 
        println "monitor"
        if(studyService.monitor()){
            println "STUDY ONGOING"
        } 

        render(status: 200, text: ("ongoing"), contentType: "application/json")

    }

/*
    def update(params){



    }

save: 
url: “study/update” 
params: {
id,
studyId,
marijuana: [


]
alcohol: {

}

}


if params.marijuana and params.alcohol 
— iterate collection. check if entry exists. if yes, update. else, create new row. 

return complete study instance or just return the updated entries? 
*/

}
