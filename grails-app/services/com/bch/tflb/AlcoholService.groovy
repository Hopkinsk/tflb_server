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

    def deleteAllByStudy(study_id){
        def alc = Alcohol.findAll {
            study_id == study_id
        }
        alc.each { a ->
          a.delete()
        }
    }

    def getAlcoholUseByDay(study_id, dayNumber){

        def drinks = 0; 
        def alcohol = Alcohol.findAll {
            study_id == study_id
            dayNumber == dayNumber
        }   
        if(alcohol){
            drinks = alcohol.drinks[0]
        }

        return drinks
    }

    def safetyTriggered(study_id){
        def trigger = Alcohol.findAll {
            study_id == study_id
            drinks >= 10
        }
        if(trigger){
            return true
        } else {
            return false
        }     
    }
}