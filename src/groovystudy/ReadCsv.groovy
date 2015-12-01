/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groovystudy

import console.*

/**
 *
 * @author asun
 */
class ReadCsv {
    static void main(args) {
//        def fileStr = new File("D:\\tool\\api2direct\\api2direct\\sourceCopy.csv").text
//        assert fileStr instanceof String
//        println fileStr
//        
//        fileStr.eachLine{line ->
//            println line.split(",")
//        }
        def fileStr = new File("D:\\DATA_API_V2\\SoapUI\\log\\result_20151120150439.txt")
        fileStr.eachLine{line ->
            if(line.contains("Pass"))
                println line
        }
        
    }
}

