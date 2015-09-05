package com.bch.tflb
import com.bch.tflb.Personal
import grails.converters.JSON

class EventController {

    def save(params) {

    	def json = request.JSON

        def event = new Personal()
        event.date = json.date
        event.study_id = json.study_id
        event.title = json.title
        event.dayNumber = 0
        event.save(flush: true)
        render (status: 200, text: (event as JSON), contentType: "application/json")

     }

     def delete(params){
     	if(params.id){
     		def event = Personal.get(params.id)
     		if(event){
     			event.delete()
     			render (status: 200, contentType: "application/json")
     			return
     		}
     	}

     	render(status: 400, contentType: "application/json")

     }
}
