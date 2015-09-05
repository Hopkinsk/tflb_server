package com.bch.tflb
import grails.converters.JSON
import grails.transaction.Transactional
import com.bch.tflb.Study
import com.bch.tflb.Alcohol
import com.bch.tflb.Marijuana
import com.bch.tflb.Personal

@Transactional
class StudyService {

    def marijuanaService
    def alcoholService
    def personalService

    def studyExists(id){
        if(Study.get(id)){
            return true
        } else {
            return false
        }

    }
    def downloadStudy(id){
        println "download study!"

    }

    def getCompleteStudy(id){
        def study = Study.get(id)
        def response = [:]
        if(study){
            response.id = study.id
            response.studyId = study.studyId
            //response.status = study.status
            response.marijuana = marijuanaService.getMarijuanaByStudy(id)
            response.alcohol = alcoholService.getAlcoholByStudy(id)
            response.personal = personalService.getPersonalByStudy(id)
            //response.safetyFlag = study.safetyFlag
        } else {
            response.error = "Study $id does not exist."
        }
        return response
    }

    def updateStudyDay(json){
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



        
        println "JSON MAR"
        println json.marijuana
        marijuanaDay.used = json.marijuana ? 1 : 0
        println "USE"
        println marijuanaDay.used
        marijuanaDay.save(failOnError: true)
        println marijuanaDay.used
        println marijuanaDay.errors
        println marijuanaDay.id
        def test = Marijuana.get(marijuanaDay.id)
        println "TEST USED" 
        println test.used

        println marijuanaService.getMarijuanaByStudy(test.study_id)


        def alcoholDay = Alcohol.find {
            date == json.date
            study_id == json.study_id
        }
        if(!alcoholDay){
            alcoholDay  = new Alcohol([
                date: json.date,
                study_id: json.study_id,
                dayNumber: json.dayNumber,
            ])
        } 
        alcoholDay.drinks = json.drinks
        alcoholDay.save()


/*

        if(!personalDay){
            personalDay = new Personal([
                date: json.date,
                study_id: json.study_id,
                dayNumber: json.dayNumber,
            ])
        }
*/
       // personalDay.title = json.title
        //personalDay.save()
        return 
    }


}
