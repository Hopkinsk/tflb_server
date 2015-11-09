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
              col2: "Alc1" { it.day1_alc }
              col3: "Alc2" { it.day2_alc }
              col4: "Alc3" { it.day3_alc }
              col5: "Alc4" { it.day4_alc }
              col6: "Alc5" { it.day5_alc }
              col7: "Alc6" { it.day6_alc }
              col8: "Alc7" { it.day7_alc }
              col9: "Alc8" { it.day8_alc }
              col10: "Alc9" { it.day9_alc }
              col11: "Alc10" { it.day10_alc }
              col12: "Alc11" { it.day11_alc }
              col13: "Alc12" { it.day12_alc }
              col14: "Alc13" { it.day13_alc }
              col15: "Alc14" { it.day14_alc }
              col16: "Alc15" { it.day15_alc }
              col17: "Alc16" { it.day16_alc }
              col18: "Alc17" { it.day17_alc }
              col19: "Alc18" { it.day18_alc }
              col20: "Alc19" { it.day19_alc }
              col21: "Alc20" { it.day20_alc }
              col22: "Alc21" { it.day21_alc }
              col23: "Alc22" { it.day22_alc }
              col24: "Alc23" { it.day23_alc }
              col25: "Alc24" { it.day24_alc }
              col26: "Alc25" { it.day25_alc }
              col27: "Alc26" { it.day26_alc }
              col28: "Alc27" { it.day27_alc }
              col29: "Alc28" { it.day28_alc }
              col30: "Alc29" { it.day29_alc }
              col31: "Alc30" { it.day30_alc }
              col32: "Alc31" { it.day31_alc }
              col33: "Alc32" { it.day32_alc }
              col34: "Alc33" { it.day33_alc }
              col35: "Alc34" { it.day34_alc }
              col36: "Alc35" { it.day35_alc }
              col37: "Alc36" { it.day36_alc }
              col38: "Alc37" { it.day37_alc }
              col39: "Alc38" { it.day38_alc }
              col40: "Alc39" { it.day39_alc }
              col41: "Alc40" { it.day40_alc }
              col42: "Alc41" { it.day41_alc }
              col43: "Alc42" { it.day42_alc }
              col44: "Alc43" { it.day43_alc }
              col45: "Alc44" { it.day44_alc }
              col46: "Alc45" { it.day45_alc }
              col47: "Alc46" { it.day46_alc }
              col48: "Alc47" { it.day47_alc }
              col49: "Alc48" { it.day48_alc }
              col50: "Alc49" { it.day49_alc }
              col51: "Alc50" { it.day50_alc }
              col52: "Alc51" { it.day51_alc }
              col53: "Alc52" { it.day52_alc }
              col54: "Alc53" { it.day53_alc }
              col55: "Alc54" { it.day54_alc }
              col56: "Alc55" { it.day55_alc }
              col57: "Alc56" { it.day56_alc }
              col58: "Alc57" { it.day57_alc }
              col59: "Alc58" { it.day58_alc }
              col60: "Alc59" { it.day59_alc }
              col61: "Alc60" { it.day60_alc }
              col62: "Alc61" { it.day61_alc }
              col63: "Alc62" { it.day62_alc }
              col64: "Alc63" { it.day63_alc }
              col65: "Alc64" { it.day64_alc }
              col66: "Alc65" { it.day65_alc }
              col67: "Alc66" { it.day66_alc }
              col68: "Alc67" { it.day67_alc }
              col69: "Alc68" { it.day68_alc }
              col70: "Alc69" { it.day69_alc }
              col71: "Alc70" { it.day70_alc }
              col72: "Alc71" { it.day71_alc }
              col73: "Alc72" { it.day72_alc }
              col74: "Alc73" { it.day73_alc }
              col75: "Alc74" { it.day74_alc }
              col76: "Alc75" { it.day75_alc }
              col77: "Alc76" { it.day76_alc }
              col78: "Alc77" { it.day77_alc }
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
               // println "DRINSK " + drinks
                 
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


      // def file = new File("/Users/khopkins/repos/tflb_server/grails-app/services/com/bch/tflb/test.csv")
       //file.write(string)

        def exportedStudy = File.createTempFile("test",".csv");

        exportedStudy.write(string)
        return exportedStudy
        //return string
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
        def study = Study.findByStudyId(studyId, [lock: true])//Study.get(id)
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
