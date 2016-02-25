/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.file

/**
 *
 * @author asun
 */
class SeparateLogOfFailedTCs {
    /**
     * **The log file of the test cases: Compare API response with Direct
     * Separate the failed TCs from the result log file.
    */
    static void main(args) {
        def path = "D:\\DATA_API_V2\\SoapUI\\log\\fasttrackEQsource\\"
        def logFile = "result_20151214062657.txt"
        def logFailed = "result_failed.txt"
        
        def sourceFile = new File(path + logFile)
        def failedTCs = new File(path + logFailed)
        if(failedTCs.exists()) {failedTCs.delete()}
        
        sourceFile.eachLine{line ->
            def lst = line.tokenize("\\|")
            if(lst[0] != 'id' && lst[1] == 'Fail') {
                failedTCs.append(line + "\n")
            }
        }
        
    }
}

