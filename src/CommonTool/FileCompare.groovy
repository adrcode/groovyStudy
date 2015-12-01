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
class FileCompare {
    def sourceFile
    def destinationFile
    
    FileCompare(sourceFile, destinationFile) {
        this.sourceFile = sourceFile
        this.destinationFile = destinationFile
    }
    
    def getSourceDPs() {
        def file = new File(this.sourceFile)
        def sourceList = []
        file.eachLine("GB2312"){line ->
            sourceList << line.split(",")        
        }
        def index = sourceList[0].findIndexOf{it == 'FactId'}
        sourceList = sourceList[1..sourceList.size()-1]
        def sourceDps = []
        sourceList.each{
            sourceDps << it[index]
        }
        return sourceDps.unique()
    }
    
    def getDestDPs() {
        def file = new File(this.destinationFile)
        def destList = []
        file.eachLine{
            it = it.trim().split(/\s/)
            def dataPoint = it.find{elem ->
                elem =~ (/^(DIMCHAR|FACT)\d+.*/)
            }
            destList << dataPoint   
        }
        destList = destList.grep{it}
        return destList        
    }
    
    def compareFile() {
        def sourceList = getSourceDPs()
        def destList = getDestDPs()
        def intersect = sourceList.intersect(destList)
        def dif1 = sourceList - intersect
        def dif2 = destList - intersect
        println "The data poins included in source file but not in destination file:\n${dif1}\n"
        println "The data poins included in destination file but not in source file:\n${dif2}"
    }
    
    static void main(args) {
        def sourceFile = "D:\\DATA_API_V2\\SoapUI\\source.csv"
        def destinationFile = "D:\\2.txt"
        def compare = new FileCompare(sourceFile, destinationFile)
        def sourceList = compare.getSourceDPs()
        def destList = compare.getDestDPs()
//        println sourceList
//        println destList
        
        compare.compareFile()
    }
}

