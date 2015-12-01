/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CommonTool

/**
 *
 * @author asun
 */
class FilterOutDps {
    static void main(args) {
        def file = new File("D:\\2.txt")
        def line
        def dps = new ArrayList()
        file.eachLine{
             line = it.split(/\s+/)
             dps << line.grep{(it =~ /DIMCHAR\d+/) || (it =~ /FACT\d+/)}
        }

        println dps.flatten()
        println dps.flatten().size()
    }
}

