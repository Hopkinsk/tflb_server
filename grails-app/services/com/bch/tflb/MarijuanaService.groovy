package com.bch.tflb
import grails.converters.JSON
import grails.transaction.Transactional
import com.bch.tflb.Study

import com.bch.tflb.Marijuana


@Transactional
class MarijuanaService {

    def getMarijuanaUseByDay(study_id, dayNumber){

        def used = 0; 
        def mar = Marijuana.findAll {
            study_id == study_id
            dayNumber == dayNumber
        }   
        if(mar){
            used = mar.used[0]
        }

        return used
    }
	def getMarijuanaByStudy(study_id){
		def response = []
        def marijuana = Marijuana.findAll {
            study_id == study_id
        }   
        marijuana.each(){
        	println "MARIJUANA VAL"
        	println it.used
            response += [date: it.date, dayNumber: it.dayNumber, use: convertNumberToBool(it.used), type: "marijuana" ]
        }
        return response
	}

	def convertNumberToBool(number){
		println "CONVERT TO NUM"
		println number
		if(number == 1){
			println "RETURNING TRUE"
			return true
		} else {
			return false
		}
	}
}