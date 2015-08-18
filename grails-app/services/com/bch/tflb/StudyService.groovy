package com.bch.tflb
import grails.converters.JSON
import grails.transaction.Transactional

@Transactional
class StudyService {

	private Int currentStudyId

    def initialize(studyId) {
    	println "CURR STUDY"
    	println currentStudyId
    	currentStudyId = studyId
    }

    def isStudyOngoing(){

    	println "monitoring"
    	if(currentStudyId){
    		return true
    	}
    	return false
    }

}
