/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groovystudy

import groovy.xml.*
/**
 *
 * @author asun
 */
class XmlBuilder {
     
	static void main(args){
            def xml = new XmlParser().parse("C:\\Program Files (x86)\\Morningstar\\Direct\\WWWRoot\\Config\\Data_Choices.xml")
            def count = 0
            xml.combo.each{
                it.option.each{op ->
                    if(op.attribute("text") == "No")
                        count++
                        println op.attribute("text")
                }
            }
            println count
//            MarkupBuilder.langs{
//               
//            }
        }
}

