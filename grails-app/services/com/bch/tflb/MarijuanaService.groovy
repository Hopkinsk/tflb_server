package com.bch.tflb
import grails.converters.JSON
import grails.transaction.Transactional
import com.bch.tflb.Study

import com.bch.tflb.Marijuana


@Transactional
class MarijuanaService {

    def saveMarijuana(json){
      def marijuanaDay = Marijuana.find {
          date == json.date
          study_id == json.study_id
      }
      if(!marijuanaDay){
          marijuanaDay = new Marijuana([
              date: json.date,
              study_id: json.study_id,
              dayNumber: json.dayNumber,
          ])
      } 

      marijuanaDay.used = json.marijuana ? 1 : 0
      marijuanaDay.save(failOnError: true)
      
      def test = Marijuana.get(marijuanaDay.id)
    }

    def deleteAllByStudy(study_id){
        def mar = Marijuana.findAll {
            study_id == study_id
        }
        mar.each { m ->
          m.delete()
        }
    }


    def handleDailyMarijuana(json){
      def days = json.days
      if(json.dailyMarijuana){
        days.each{ day ->
            saveMarijuana([
                date: day.formattedDate,
                study_id: json.study_id,
                dayNumber: day.dayNumber,
                marijuana: true
            ])
        }
      } else {
        def mj = Marijuana.findAll { used == 1 }
        if(mj){
            mj.each { m -> 
                m.delete()
            } 
        }
      }
    }

    def getMarijuana(study_id, dayNumber){
        def mar = Marijuana.findAll {
            study_id == study_id
            dayNumber == dayNumber
        }
        if(mar){
            return mar[0]
        }
        return false
    }

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
            response += [date: it.date, dayNumber: it.dayNumber, use: convertNumberToBool(it.used), type: "marijuana" ]
        }
        return response
	}

	def convertNumberToBool(number){
		if(number == 1){
			return true
		} else {
			return false
		}
	}
}