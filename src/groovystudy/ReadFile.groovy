/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groovystudy

/**
 *
 * @author asun
 */
class ReadFile {
	static void main(args) {
            def filePath = "D:\\DATA_API_V2\\SoapUI\\log\\result_20151130082051.txt"
            def file = new File(filePath)
            file.eachLine{line ->
                if(line =~ /.*\|Fail\|.*/) {
                    println line
                }
                
            }
        }
}

