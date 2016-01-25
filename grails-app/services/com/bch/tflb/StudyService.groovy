package com.bch.tflb
import grails.converters.JSON
import grails.transaction.Transactional
import com.bch.tflb.Study
import com.bch.tflb.Alcohol
import com.bch.tflb.Marijuana
import com.bch.tflb.Personal
import org.grails.plugins.csv.*


@Transactional
class StudyService {

    def marijuanaService
    def alcoholService
    def personalService

    def export(ids){
        def sw = new StringWriter()
        def b = new CSVWriter(sw, {    
              "Study ID" { it.study_id }
              "Alc1" { it.day1_alc }
              "Alc2" { it.day2_alc }
              "Alc3" { it.day3_alc }
              "Alc4" { it.day4_alc }
              "Alc5" { it.day5_alc }
              "Alc6" { it.day6_alc }
              "Alc7" { it.day7_alc }
              "Alc8" { it.day8_alc }
              "Alc9" { it.day9_alc }
              "Alc10" { it.day10_alc }
              "Alc11" { it.day11_alc }
              "Alc12" { it.day12_alc }
              "Alc13" { it.day13_alc }
              "Alc14" { it.day14_alc }
              "Alc15" { it.day15_alc }
              "Alc16" { it.day16_alc }
              "Alc17" { it.day17_alc }
              "Alc18" { it.day18_alc }
              "Alc19" { it.day19_alc }
              "Alc20" { it.day20_alc }
              "Alc21" { it.day21_alc }
              "Alc22" { it.day22_alc }
              "Alc23" { it.day23_alc }
              "Alc24" { it.day24_alc }
              "Alc25" { it.day25_alc }
              "Alc26" { it.day26_alc }
              "Alc27" { it.day27_alc }
              "Alc28" { it.day28_alc }
              "Alc29" { it.day29_alc }
              "Alc30" { it.day30_alc }
              "Alc31" { it.day31_alc }
              "Alc32" { it.day32_alc }
              "Alc33" { it.day33_alc }
              "Alc34" { it.day34_alc }
              "Alc35" { it.day35_alc }
              "Alc36" { it.day36_alc }
              "Alc37" { it.day37_alc }
              "Alc38" { it.day38_alc }
              "Alc39" { it.day39_alc }
              "Alc40" { it.day40_alc }
              "Alc41" { it.day41_alc }
              "Alc42" { it.day42_alc }
              "Alc43" { it.day43_alc }
              "Alc44" { it.day44_alc }
              "Alc45" { it.day45_alc }
              "Alc46" { it.day46_alc }
              "Alc47" { it.day47_alc }
              "Alc48" { it.day48_alc }
              "Alc49" { it.day49_alc }
              "Alc50" { it.day50_alc }
              "Alc51" { it.day51_alc }
              "Alc52" { it.day52_alc }
              "Alc53" { it.day53_alc }
              "Alc54" { it.day54_alc }
              "Alc55" { it.day55_alc }
              "Alc56" { it.day56_alc }
              "Alc57" { it.day57_alc }
              "Alc58" { it.day58_alc }
              "Alc59" { it.day59_alc }
              "Alc60" { it.day60_alc }
              "Alc61" { it.day61_alc }
              "Alc62" { it.day62_alc }
              "Alc63" { it.day63_alc }
              "Alc64" { it.day64_alc }
              "Alc65" { it.day65_alc }
              "Alc66" { it.day66_alc }
              "Alc67" { it.day67_alc }
              "Alc68" { it.day68_alc }
              "Alc69" { it.day69_alc }
              "Alc70" { it.day70_alc }
              "Alc71" { it.day71_alc }
              "Alc72" { it.day72_alc }
              "Alc73" { it.day73_alc }
              "Alc74" { it.day74_alc }
              "Alc75" { it.day75_alc }
              "Alc76" { it.day76_alc }
              "Alc77" { it.day77_alc }
              "Alc78" { it.day78_alc}
              "Alc79" { it.day79_alc }
              "Alc80" { it.day80_alc }
              "Alc81" { it.day81_alc }
              "Alc82" { it.day82_alc }
              "Alc83" { it.day83_alc }
              "Alc84" { it.day84_alc }
              "Alc85" { it.day85_alc }
              "Alc86" { it.day86_alc }
              "Alc87" { it.day87_alc }
              "Alc88" { it.day88_alc }
              "Alc89" { it.day89_alc }
              "Alc90" { it.day80_alc }
               "Mj1" { it.day1 }
               "Mj2" { it.day2 }
               "Mj3" { it.day3 }
               "Mj4" { it.day4 }
               "Mj5" { it.day5 }
               "Mj6" { it.day6 }
               "Mj7" { it.day7 }
               "Mj8" { it.day8 }
               "Mj9" { it.day9 }
               "Mj10" { it.day10 }
               "Mj11" { it.day11 }
               "Mj12" { it.day12 }
               "Mj13" { it.day13 }
               "Mj14" { it.day14 }
               "Mj15" { it.day15 }
               "Mj16" { it.day16 }
               "Mj17" { it.day17 }
               "Mj18" { it.day18 }
               "Mj19" { it.day19 }
               "Mj20" { it.day20 }
               "Mj21" { it.day21 }
               "Mj22" { it.day22 }
               "Mj23" { it.day23 }
               "Mj24" { it.day24 }
               "Mj25" { it.day25 }
               "Mj26" { it.day26 }
               "Mj27" { it.day27 }
               "Mj28" { it.day28 }
               "Mj29" { it.day29 }
               "Mj30" { it.day30 }
               "Mj31" { it.day31 }
               "Mj32" { it.day32 }
               "Mj33" { it.day33 }
               "Mj34" { it.day34 }
               "Mj35" { it.day35 }
               "Mj36" { it.day36 }
               "Mj37" { it.day37 }
               "Mj38" { it.day38 }
               "Mj39" { it.day39 }
               "Mj40" { it.day40 }
               "Mj41" { it.day41 }
               "Mj42" { it.day42 }
               "Mj43" { it.day43 }
               "Mj44" { it.day44 }
               "Mj45" { it.day45 }
               "Mj46" { it.day46 }
               "Mj47" { it.day47 }
               "Mj48" { it.day48 }
               "Mj49" { it.day49 }
               "Mj50" { it.day50 }
               "Mj51" { it.day51 }
               "Mj52" { it.day52 }
               "Mj53" { it.day53 }
               "Mj54" { it.day54 }
               "Mj55" { it.day55 }
               "Mj56" { it.day56 }
               "Mj57" { it.day57 }
               "Mj58" { it.day58 }
               "Mj59" { it.day59 }
               "Mj60" { it.day60 }
               "Mj61" { it.day61 }
               "Mj62" { it.day62 }
               "Mj63" { it.day63 }
               "Mj64" { it.day64 }
               "Mj65" { it.day65 }
               "Mj66" { it.day66 }
               "Mj67" { it.day67 }
               "Mj68" { it.day68 }
               "Mj69" { it.day69 }
               "Mj70" { it.day70 }
               "Mj71" { it.day71 }
               "Mj72" { it.day72 }
               "Mj73" { it.day73 }
               "Mj74" { it.day74 }
               "Mj75" { it.day75 }
               "Mj76" { it.day76 }
               "Mj77" { it.day77 }
               "Mj78" { it.day78}
               "Mj79" { it.day79 }
               "Mj80" { it.day80 }
               "Mj81" { it.day81 }
               "Mj82" { it.day82 }
               "Mj83" { it.day83 }
               "Mj84" { it.day84 }
               "Mj85" { it.day85 }
               "Mj86" { it.day86 }
               "Mj87" { it.day87 }
               "Mj88" { it.day88 }
               "Mj89" { it.day89 }
               "Mj90" { it.day80 }              
           })

        def studyRow = [:]
        ids.each { id ->
            studyRow = [:]
            studyRow << [study_id: getStudyIdById(id)]
            def alcKey = ""
            for (def i = 1; i <91; i++) {
                alcKey = "day" + i + "_alc"
                def drinks = alcoholService.getAlcoholUseByDay(id, i)                 
                studyRow << [(alcKey): drinks]
                alcKey = ""
            }

            def marKey = ""
            for (def i = 1; i <91; i++) {
                marKey  = "day" + i
                def marUse = marijuanaService.getMarijuanaUseByDay(id, i)
                studyRow << [(marKey): marUse]
                marKey = ""
            }
            b << studyRow
        }

        def string = b.writer.toString()
        def exportedStudy = File.createTempFile("exportedStudy",".csv");
        exportedStudy.write(string)
        return exportedStudy
    }

    def getStudyIdById(id){
        def study = Study.get(id);
        if(study){
            return study.studyId
        }
        return false
    }

    def studyExists(id){
        if(Study.get(id)){
            return true
        } else {
            return false
        }
    }

    def getCompleteStudy(studyId){
        def study = Study.findByStudyId(studyId, [lock: true])
        def response = [:]
        if(study){
            response.id = study.id
            response.studyId = study.studyId
            response.dailyMarijuana = convertNumberToBool(study.dailyMarijuana)
            response.complete = convertNumberToBool(study.complete)
            response.date = study.date
            response.marijuana = marijuanaService.getMarijuanaByStudy(study.id)
            response.alcohol = alcoholService.getAlcoholByStudy(study.id)
            response.personal = personalService.getPersonalByStudy(study.id)
            response.safetyTriggered = alcoholService.safetyTriggered(study.id)
        } else {
            response.error = "Study $studyId does not exist."
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

    def updateStudyDay(json){
        if(json.has("dailyMarijuana")){
            def study = Study.findById(json.study_id, [lock: true])
            def daily = json.dailyMarijuana ? 1 : 0
            study.dailyMarijuana = daily
            study.save()
            marijuanaService.handleDailyMarijuana(json)
        } else {
          marijuanaService.saveMarijuana(json)
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
        }
    }

    def validStudyId(studyId){
        def study = Study.findAll {
            studyId == studyId
        }  
        if(study.size() > 0){
            return false
        }
        return true
    }
}
