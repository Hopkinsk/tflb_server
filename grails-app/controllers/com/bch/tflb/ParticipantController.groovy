package com.bch.tflb
import com.bch.tflb.Study
import grails.converters.JSON
import org.grails.plugins.csv.CSVWriter

class ParticipantController {

    def index() {
    	/*
    	def test = new Study()
    	test.study_id = 123
    	test.test = "test"
    	test.save();
    	*/
    	def test = Study.findAll()
    	println test as JSON


    	def sw = new StringWriter()
   		def b = new CSVWriter(sw, {
      		col1 { it.val1 }
      		col2:"foo" { it.val2 }
   		})
   		b << [val1: 'a', val2: 'b']
   		b << [val1: 'c', val2: 'd']


   		println b
   		render( contentType: 'text/csv', text: b);
		//new File("test.csv").eachCsvLine { tokens ->

       //}
      // render(file: )

    }
}
