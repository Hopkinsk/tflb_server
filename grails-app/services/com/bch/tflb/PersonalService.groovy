package com.bch.tflb
import grails.converters.JSON
import grails.transaction.Transactional
import com.bch.tflb.Study

import com.bch.tflb.Personal


@Transactional
class PersonalService {

	def getPersonalByStudy(study_id){
		def response = []
        def personal = Personal.findAll {
            study_id == study_id
        }   
        personal.each(){
            response += [id: it.id, date: it.date, dayNumber: it.dayNumber, title: it.title, type: "personal" ]
        }
        return response
	}
}