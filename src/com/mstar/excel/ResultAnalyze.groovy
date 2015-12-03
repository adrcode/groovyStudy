/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.excel

/**
 *
 * @author asun
 */
class ResultAnalyze {
    def filePath
    def failedCases
    def passedCases
    
    ResultAnalyze(filePath) {
        this.filePath = filePath
        this.failedCases = new ArrayList()
        this.passedCases = new ArrayList()
    }
    
    def analyzeTestResult() {
        File file = new File(this.filePath)
        file.each{line ->
            def lineArr = line.split("\\|")
            if(lineArr[1] == "Fail") {
                this.failedCases << lineArr[0]
            } else if(lineArr[1] == "Pass") {
                this.passedCases << lineArr[0]
            } else {
                throw new Exception("The cases status is not right!")
            }
        }
    }
    
    def getFailedCases() {
        return this.failedCases
    }
    
    def getPassedCases() {
        return this.passedCases
    }
    
    static void main(args) {
        def filePath = "result_20151201033534.txt"
        def rstAnalyze = new ResultAnalyze(filePath)
        rstAnalyze.analyzeTestResult()
        println rstAnalyze.getFailedCases()
        println rstAnalyze.getPassedCases()
    }
}

