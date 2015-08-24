package com.bch.tflb
import grails.converters.JSON
import grails.transaction.Transactional
import com.bch.tflb.Study

import com.bch.tflb.Alcohol


@Transactional
class AlcoholService {

	def getAlcoholByStudy(study_id){
		def response = []
        def alcohol = Alcohol.findAll {
            study_id == study_id
        }   
        alcohol.each(){
            response += [date: it.date, dayNumber: it.dayNumber, drinks: it.drinks, type: "alcohol" ]
        }
        return response
	}
}