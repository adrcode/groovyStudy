/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groovystudy

import com.sun.javafx.collections.transformation.Matcher
import groovy.xml.*
import javax.swing.text.Document

/**
 *
 * @author asun
 */
class xmlTest {
	static void main(args){
            def path_dataChoice = "C:\\Program Files (x86)\\Morningstar\\Direct\\WWWRoot\\Config\\Data_Choices.xml"
            def path_idMapping = "C:\\Program Files (x86)\\Morningstar\\Direct\\WWWRoot\\Config\\DataIdMapping.xml"
            def dpId = 'AA0D9'
        
            def xml = new XmlParser()
            def xmlChoice = xml.parse(path_dataChoice)
            def xmlIdMapping = xml.parse(path_idMapping)
            
            def test = new xmlTest()
            def op = test.getOpFromIdMapping(path_idMapping, dpId)
            println op
            println test.parseToApiValue(path_dataChoice, op, "9")
            
//            xmlChoice.combo.each{cob ->
//                cob.option.each{op ->
//                    println op.attribute("text")
//                }
//                
//            }
//            
//              xmlIdMapping.f.each{f ->
//                  println f.attribute("i")
////                  f.each{s ->
////                      println s.attribute("op")
////                  }
//              }  
         
        }
        
        def getOpFromIdMapping(file, dpId) {
            def option = null
            def xml = new XmlParser()
            def xmlIdMapping = xml.parse(file)   
            for(f in xmlIdMapping) {
                def id = f.attribute("i")
                if(id == dpId) {
                    option = f.getAt("s")[0].attribute("val")
                    return option
                }
            }
            if(option == null)
                throw new Exception("Could not find the data point id in file DataIdMapping.xml !")
        }

        def parseToApiValue(file, option, directRes) {            
            def xml = new XmlParser()
            def xmlChoice = xml.parse(file)
            for(comb in xmlChoice) {
                if(comb.attribute("id") == option) {
                    println comb
                    for(op in comb.option) {
                        if(op.attribute("value") == directRes) {
                            return op.attribute("text")
                        } else {
                            return null
                        }
                    }
                }
            }
        }
        
        
}

