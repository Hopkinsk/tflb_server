package com.bch.tflb
import com.bch.tflb.Study
import com.bch.tflb.Alcohol
import com.bch.tflb.Marijuana
import grails.converters.JSON
import org.apache.commons.io.IOUtils

class StudyController {

    def studyService
    def alcoholService
    def marijuanaService


    def list(){
        def studies = Study.findAll()
        println studies
        println studies as JSON
        studies.each { study ->
            println study as JSON

        }
/*
        def studies = Study.find().collect {

            [
               // id: it.id,

               // studyId: it.study_id,
                complete: it.complete,
                safetyTriggered: it.safety_triggered,
                date: it.dateCreated
            ]
        }
*/
        render (status: 200, text: (studies as JSON), contentType: "application/json")

    }


    //POST /study/export
    def export(params){
        println "PARAMS"
        println params

/*
        File file = File.createTempFile("temp",".txt")
        file.write("hello world!")
        response.setHeader "Content-disposition", "attachment; filename=\"${file.name}\""
        response.contentType = 'text-plain'
        response.outputStream << file.text
        response.outputStream.flush()

  */
        if(params.containsKey("ids")){

            def ids = JSON.parse(params.ids)

            println "IDS"
            println ids.getClass().name
            def studiesFile = studyService.export(ids)


            render(status: 200, text: studiesFile, contentType: "text/csv")

/*
            if(ids){
                def studiesFile = studyService.export(ids)
          
                InputStream contentStream
                try {

                    response.setHeader("Content-Type", "application/octet-stream") 
                    response.setHeader("Content-disposition", "attachment; filename=test.csv")
                    //response.setHeader("Content-Length", studiesFile.length() )
                    
                    response.outputStream << studiesFile.bytes// //studiesFile.newInputStream()
                    response.outputStream.flush()
                    response.outputStream.close()
                    
                    return

                }  catch (e){ 
                    println "ERROR" + e.message
                  //  IOUtils.closeQuietly(contentStream)
                }

            }
            */
        }
      
    }

    def index(params){
        if(params.id){
            studyService.getCompleteStudy(params.id)
            render (status: 200, text: (studyService.getCompleteStudy(params.id) as JSON), contentType: "application/json")
        }
        render(status: 400, contentType: "application/json")
    }

    def save(params){
        println "SAVE STUDY "
        def data = request.JSON
        println "DATA"
        println data
        println "params"
        println params

        
        if(data && data.studyId){

            def validStudyId = studyService.validStudyId(data.studyId)
            if(validStudyId){   
                def study = new Study()
                study.date = data.date
                study.studyId = data.studyId 
                study.complete = 0
                study.dailyMarijuana = 0
                study.save(failonError: true)
                render (status: 200, text: (study as JSON), contentType: "application/json")

            } else {
                render (status: 400, text: "Error: Study ID already exists.", contentType: "application/json")
            }
        } else {
            render(status: 400, contentType: "application/json")
        }
    }

    def update(params){
        def json = request.JSON
        if(params.id){
            def study = Study.get(params.id)
            if(study){
                if(json.studyComplete){
                    study.complete = json.studyComplete ? 1 : 0
                    study.save(failonError: true)
                    def safetyTriggered = alcoholService.safetyTriggered(study.id)
                    render (status: 200, text: [safetyTriggered: safetyTriggered] as JSON, contentType: "application/json")
                    return
                }
            }
        }
        render(status: 400, contentType: "application/json")

    }

    def delete(params){
        if(params.id){
            def study = Study.get(params.id)
            if(study){
                marijuanaService.deleteAllByStudy(study.id)
                alcoholService.deleteAllByStudy(study.id)
                study.delete()
                render (status: 200, contentType: "application/json")
                return
            }
        }
        render(status: 400, contentType: "application/json")

    }
/*
    def safetyTriggered(params){
        if(params.id){
            def study = Study.get(params.id)
            if(study){
                def safetyTriggered = alcoholService.safetyTriggered(study.id)
                render (status: 200, text: [safetyTriggered: safetyTriggered] as JSON, contentType: "application/json")
                return
            }
        }
        render(status: 400, contentType: "application/json")
    }
*/

}
