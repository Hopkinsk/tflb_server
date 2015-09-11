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

        println "IDS"
        println ids

        def sw = new StringWriter()
           def b = new CSVWriter(sw, {

         
             
                "Study ID" { it.study_id } // go through and grab every study id 
              col2: "Day1_Alc" { it.day1_alc }
              col3: "Day2_Alc" { it.day2_alc }
              col4: "Day3_Alc" { it.day3_alc }
              col5: "Day4_Alc" { it.day4_alc }
              col6: "Day5_Alc" { it.day5_alc }
              col7: "Day6_Alc" { it.day6_alc }
              col8: "Day7_Alc" { it.day7_alc }
              col9: "Day8_Alc" { it.day8_alc }
              col10: "Day9_Alc" { it.day9_alc }
              col11: "Day10_Alc" { it.day10_alc }
              col12: "Day11_Alc" { it.day11_alc }
              col13: "Day12_Alc" { it.day12_alc }
              col14: "Day13_Alc" { it.day13_alc }
              col15: "Day14_Alc" { it.day14_alc }
              col16: "Day15_Alc" { it.day15_alc }
              col17: "Day16_Alc" { it.day16_alc }
              col18: "Day17_Alc" { it.day17_alc }
              col19: "Day18_Alc" { it.day18_alc }
              col20: "Day19_Alc" { it.day19_alc }
              col21: "Day20_Alc" { it.day20_alc }
              col22: "Day21_Alc" { it.day21_alc }
              col23: "Day22_Alc" { it.day22_alc }
              col24: "Day23_Alc" { it.day23_alc }
              col25: "Day24_Alc" { it.day24_alc }
              col26: "Day25_Alc" { it.day25_alc }
              col27: "Day26_Alc" { it.day26_alc }
              col28: "Day27_Alc" { it.day27_alc }
              col29: "Day28_Alc" { it.day28_alc }
              col30: "Day29_Alc" { it.day29_alc }
              col31: "Day30_Alc" { it.day30_alc }
              col32: "Day31_Alc" { it.day31_alc }
              col33: "Day32_Alc" { it.day32_alc }
              col34: "Day33_Alc" { it.day33_alc }
              col35: "Day34_Alc" { it.day34_alc }
              col36: "Day35_Alc" { it.day35_alc }
              col37: "Day36_Alc" { it.day36_alc }
              col38: "Day37_Alc" { it.day37_alc }
              col39: "Day38_Alc" { it.day38_alc }
              col40: "Day39_Alc" { it.day39_alc }
              col41: "Day40_Alc" { it.day40_alc }
              col42: "Day41_Alc" { it.day41_alc }
              col43: "Day42_Alc" { it.day42_alc }
              col44: "Day43_Alc" { it.day43_alc }
              col45: "Day44_Alc" { it.day44_alc }
              col46: "Day45_Alc" { it.day45_alc }
              col47: "Day46_Alc" { it.day46_alc }
              col48: "Day47_Alc" { it.day47_alc }
              col49: "Day48_Alc" { it.day48_alc }
              col50: "Day49_Alc" { it.day49_alc }
              col51: "Day50_Alc" { it.day50_alc }
              col52: "Day51_Alc" { it.day51_alc }
              col53: "Day52_Alc" { it.day52_alc }
              col54: "Day53_Alc" { it.day53_alc }
              col55: "Day54_Alc" { it.day54_alc }
              col56: "Day55_Alc" { it.day55_alc }
              col57: "Day56_Alc" { it.day56_alc }
              col58: "Day57_Alc" { it.day57_alc }
              col59: "Day58_Alc" { it.day58_alc }
              col60: "Day59_Alc" { it.day59_alc }
              col61: "Day60_Alc" { it.day60_alc }
              col62: "Day61_Alc" { it.day61_alc }
              col63: "Day62_Alc" { it.day62_alc }
              col64: "Day63_Alc" { it.day63_alc }
              col65: "Day64_Alc" { it.day64_alc }
              col66: "Day65_Alc" { it.day65_alc }
              col67: "Day66_Alc" { it.day66_alc }
              col68: "Day67_Alc" { it.day67_alc }
              col69: "Day68_Alc" { it.day68_alc }
              col70: "Day69_Alc" { it.day69_alc }
              col71: "Day70_Alc" { it.day70_alc }
              col72: "Day71_Alc" { it.day71_alc }
              col73: "Day72_Alc" { it.day72_alc }
              col74: "Day73_Alc" { it.day73_alc }
              col75: "Day74_Alc" { it.day74_alc }
              col76: "Day75_Alc" { it.day75_alc }
              col77: "Day76_Alc" { it.day76_alc }
              col78: "Day77_Alc" { it.day77_alc }
            "Day78_Alc" { it.day78_alc}
            "Day79_Alc" { it.day79_alc }
            "Day80_Alc" { it.day80_alc }
            "Day81_Alc" { it.day81_alc }
            "Day82_Alc" { it.day82_alc }
            "Day83_Alc" { it.day83_alc }
            "Day84_Alc" { it.day84_alc }
            "Day85_Alc" { it.day85_alc }
            "Day86_Alc" { it.day86_alc }
            "Day87_Alc" { it.day87_alc }
            "Day88_Alc" { it.day88_alc }
            "Day89_Alc" { it.day89_alc }
            "Day90_Alc" { it.day80_alc }
             "Day1_MJ" { it.day1_MJ }
             "Day2_MJ" { it.day2_MJ }
             "Day3_MJ" { it.day3_MJ }
             "Day4_MJ" { it.day4_MJ }
             "Day5_MJ" { it.day5_MJ }
             "Day6_MJ" { it.day6_MJ }
             "Day7_MJ" { it.day7_MJ }
             "Day8_MJ" { it.day8_MJ }
             "Day9_MJ" { it.day9_MJ }
             "Day10_MJ" { it.day10_MJ }
             "Day11_MJ" { it.day11_MJ }
             "Day12_MJ" { it.day12_MJ }
             "Day13_MJ" { it.day13_MJ }
             "Day14_MJ" { it.day14_MJ }
             "Day15_MJ" { it.day15_MJ }
             "Day16_MJ" { it.day16_MJ }
             "Day17_MJ" { it.day17_MJ }
             "Day18_MJ" { it.day18_MJ }
             "Day19_MJ" { it.day19_MJ }
             "Day20_MJ" { it.day20_MJ }
             "Day21_MJ" { it.day21_MJ }
             "Day22_MJ" { it.day22_MJ }
             "Day23_MJ" { it.day23_MJ }
             "Day24_MJ" { it.day24_MJ }
             "Day25_MJ" { it.day25_MJ }
             "Day26_MJ" { it.day26_MJ }
             "Day27_MJ" { it.day27_MJ }
             "Day28_MJ" { it.day28_MJ }
             "Day29_MJ" { it.day29_MJ }
             "Day30_MJ" { it.day30_MJ }
             "Day31_MJ" { it.day31_MJ }
             "Day32_MJ" { it.day32_MJ }
             "Day33_MJ" { it.day33_MJ }
             "Day34_MJ" { it.day34_MJ }
             "Day35_MJ" { it.day35_MJ }
             "Day36_MJ" { it.day36_MJ }
             "Day37_MJ" { it.day37_MJ }
             "Day38_MJ" { it.day38_MJ }
             "Day39_MJ" { it.day39_MJ }
             "Day40_MJ" { it.day40_MJ }
             "Day41_MJ" { it.day41_MJ }
             "Day42_MJ" { it.day42_MJ }
             "Day43_MJ" { it.day43_MJ }
             "Day44_MJ" { it.day44_MJ }
             "Day45_MJ" { it.day45_MJ }
             "Day46_MJ" { it.day46_MJ }
             "Day47_MJ" { it.day47_MJ }
             "Day48_MJ" { it.day48_MJ }
             "Day49_MJ" { it.day49_MJ }
             "Day50_MJ" { it.day50_MJ }
             "Day51_MJ" { it.day51_MJ }
             "Day52_MJ" { it.day52_MJ }
             "Day53_MJ" { it.day53_MJ }
             "Day54_MJ" { it.day54_MJ }
             "Day55_MJ" { it.day55_MJ }
             "Day56_MJ" { it.day56_MJ }
             "Day57_MJ" { it.day57_MJ }
             "Day58_MJ" { it.day58_MJ }
             "Day59_MJ" { it.day59_MJ }
             "Day60_MJ" { it.day60_MJ }
             "Day61_MJ" { it.day61_MJ }
             "Day62_MJ" { it.day62_MJ }
             "Day63_MJ" { it.day63_MJ }
             "Day64_MJ" { it.day64_MJ }
             "Day65_MJ" { it.day65_MJ }
             "Day66_MJ" { it.day66_MJ }
             "Day67_MJ" { it.day67_MJ }
             "Day68_MJ" { it.day68_MJ }
             "Day69_MJ" { it.day69_MJ }
             "Day70_MJ" { it.day70_MJ }
             "Day71_MJ" { it.day71_MJ }
             "Day72_MJ" { it.day72_MJ }
             "Day73_MJ" { it.day73_MJ }
             "Day74_MJ" { it.day74_MJ }
             "Day75_MJ" { it.day75_MJ }
             "Day76_MJ" { it.day76_MJ }
             "Day77_MJ" { it.day77_MJ }
             "Day78_MJ" { it.day78_MJ}
             "Day79_MJ" { it.day79_MJ }
             "Day80_MJ" { it.day80_MJ }
             "Day81_MJ" { it.day81_MJ }
             "Day82_MJ" { it.day82_MJ }
             "Day83_MJ" { it.day83_MJ }
             "Day84_MJ" { it.day84_MJ }
             "Day85_MJ" { it.day85_MJ }
             "Day86_MJ" { it.day86_MJ }
             "Day87_MJ" { it.day87_MJ }
             "Day88_MJ" { it.day88_MJ }
             "Day89_MJ" { it.day89_MJ }
             "Day90_MJ" { it.day80_MJ }              
           })


        def studyRow = [:]


        ids.each { id ->
            studyRow = [:]
            studyRow << [study_id: getStudyIdById(id)]

            def alcKey = ""
            for (def i = 1; i <91; i++) {
                alcKey = "day" + i + "_alc"

                def drinks = alcoholService.getAlcoholUseByDay(id, i)
                println "DRINSK " + drinks
                 
                studyRow << [(alcKey): drinks]
                alcKey = ""
            }


            def marKey = ""
            for (def i = 1; i <91; i++) {
                marKey  = "day" + i + "_MJ"
                def marUse = marijuanaService.getMarijuanaUseByDay(id, i)

                 
                studyRow << [(marKey): marUse]
                marKey = ""
            }

            b << studyRow
        }

        def string = b.writer.toString()


       def file = new File("/Users/khopkins/repos/tflb_server/grails-app/services/com/bch/tflb/test.csv")
       file.write(string)

        def exportedStudy = File.createTempFile("test",".csv");
        //def exportedStudy = new File("")

        exportedStudy.write(string)
       // println exportedStudy.getAbsolutePath()  
        return exportedStudy
    //   render(file: new File(absolutePath), fileName: "book.pdf")

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


    def validStudyId(studyId){

        def study = Study.findAll {
            studyId == studyId
        }  

        println "SDUY"
        println study.size()

        if(study.size() > 0){
            return false
        }

        return true
    }

}
