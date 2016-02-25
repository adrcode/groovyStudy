/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groovystudy

import groovy.json.*
import java.text.*
import java.util.Calendar
import groovy.xml.*  

import java.text.DateFormat
import java.text.SimpleDateFormat

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.codehaus.groovy.control.CompilerConfiguration

import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFCell

import static org.junit.Assert.*

/**
 *
 * @author asun
 */
class Test {
    static void main(args){
//	def builder = new JsonBuilder()
//        builder.person{
//            name 'lily'
//            sex 'girl'
//            address(
//                contry: 'China',
//                city: 'ShenZhen'
//            )
//        }
//        println builder.toPrettyString()
        
//        def lists = ["DIMCHAR156","PERFORMANCEID"]
//        def index = lists.findIndexOf{it =~ /^DIMCHAR\d+/}
//        println index
//        assert "acb".equalsIgnoreCase("ACB")
//        boolean required = true
//        println required == true
//        
//        def a = [1,2,3]
////        for(i in 1..6) {
//          (1..6).each{
//            for(b in a){
//                if(b == 2) break
//                println b
//            }
//        }
//        
//        def date = "2015-10-11"
//        def format = new SimpleDateFormat("MM")
//        def rs = format.format(format.parse(date))
//        println rs
//        
//        def arr = [264,469,825,932,935,938,941,943,946,948,950,952,957,964,972,973,974,975,1077,1082,1090,1098,1102,1106,1114,1118,1122,1130,1134,1138,1146,1150,1166,1170,1174,1178,1182,1190,1198,1222,1226,1358,1364]
//        println arr.size()
//
//        def test = 111.toInteger()
//        def b = new HashSet(test)
////        assert test == b
//        Number[] cc = 1
//        println cc.class
//        def aa = new HashSet()
//        switch(aa) {
//            case Integer:
//                println "integer"
//                break
//            case String:
//                println "string"
//                break
//            case HashSet:
//                println "hashSet"
//                break
//        }
//        def source = ["TC000009","TC000015","TC000016","TC000017","TC000018","TC000020","TC000021","TC000023","TC000024","TC000025","TC000028","TC000064","TC000066","TC000068","TC000069","TC000070","TC000071","TC000074","TC000075","TC000076","TC000079","TC000082","TC000083","TC000084","TC000085","TC000086","TC000089","TC000094","TC000095","TC000096","TC000097","TC000098","TC0000100","TC0000110","TC0000116","TC0000117","TC0000118","TC0000120","TC0000127","TC0000128","TC0000129","TC0000133","TC0000134","TC0000135","TC0000136","TC0000137","TC0000139","TC0000142","TC0000143","TC0000144","TC0000145","TC0000146","TC0000147","TC0000148","TC0000149","TC0000150","TC0000151","TC0000152","TC0000153","TC0000154","TC0000155","TC0000156","TC0000167","TC0000172","TC0000173","TC0000178","TC0000179","TC0000180","TC0000181","TC0000182","TC0000183","TC0000184","TC0000185","TC0000187","TC0000188","TC0000193","TC0000198","TC0000207","TC0000221","TC0000222","TC0000244","TC0000245","TC0000246","TC0000247","TC0000249","TC0000251","TC0000259","TC0000260","TC0000266","TC0000274","TC0000283","TC0000286","TC0000290","TC0000291","TC0000292","TC0000313","TC0000316","TC0000319","TC0000320","TC0000321","TC0000322","TC0000325","TC0000327","TC0000328","TC0000341","TC0000345","TC0000348","TC0000355","TC0000358","TC0000360","TC0000367","TC0000368","TC0000369","TC0000370","TC0000371","TC0000372","TC0000373","TC0000374","TC0000375","TC0000376","TC0000377","TC0000378","TC0000379","TC0000380","TC0000381","TC0000382","TC0000387","TC0000388","TC0000389","TC0000400","TC0000401","TC0000402","TC0000403","TC0000404","TC0000405","TC0000406","TC0000407","TC0000413","TC0000416","TC0000420","TC0000421","TC0000422","TC0000423","TC0000424","TC0000425","TC0000426","TC0000427","TC0000429","TC0000430","TC0000433","TC0000434"]
//        def dest = ["TC000001","TC000002","TC000003","TC000004","TC000005","TC000006","TC000007","TC000008","TC000010","TC000011","TC000012","TC000013","TC000014","TC000019","TC000022","TC000026","TC000027","TC000029","TC000030","TC000031","TC000032","TC000033","TC000034","TC000035","TC000036","TC000037","TC000038","TC000039","TC000040","TC000041","TC000042","TC000043","TC000044","TC000045","TC000046","TC000047","TC000048","TC000049","TC000050","TC000051","TC000052","TC000053","TC000054","TC000055","TC000056","TC000057","TC000058","TC000059","TC000060","TC000061","TC000062","TC000063","TC000065","TC000067","TC000072","TC000073","TC000077","TC000078","TC000080","TC000081","TC000087","TC000088","TC000090","TC000091","TC000092","TC000093","TC000099","TC0000101","TC0000102","TC0000103","TC0000104","TC0000105","TC0000106","TC0000107","TC0000108","TC0000109","TC0000111","TC0000112","TC0000113","TC0000114","TC0000115","TC0000119","TC0000121","TC0000122","TC0000123","TC0000124","TC0000125","TC0000126","TC0000130","TC0000131","TC0000132","TC0000138","TC0000140","TC0000141","TC0000150","TC0000157","TC0000158","TC0000159","TC0000160","TC0000161","TC0000162","TC0000163","TC0000164","TC0000165","TC0000166","TC0000168","TC0000169","TC0000170","TC0000171","TC0000174","TC0000175","TC0000176","TC0000177","TC0000186","TC0000189","TC0000190","TC0000191","TC0000192","TC0000194","TC0000195","TC0000196","TC0000197","TC0000199","TC0000200","TC0000201","TC0000202","TC0000203","TC0000204","TC0000205","TC0000206","TC0000208","TC0000209","TC0000210","TC0000211","TC0000212","TC0000213","TC0000214","TC0000215","TC0000216","TC0000217","TC0000218","TC0000219","TC0000220","TC0000223","TC0000224","TC0000225","TC0000226","TC0000227","TC0000228","TC0000229","TC0000230","TC0000231","TC0000232","TC0000233","TC0000234","TC0000235","TC0000236","TC0000237","TC0000238","TC0000239","TC0000240","TC0000241","TC0000242","TC0000243","TC0000248","TC0000250","TC0000252","TC0000253","TC0000254","TC0000255","TC0000256","TC0000257","TC0000258","TC0000261","TC0000262","TC0000263","TC0000264","TC0000265","TC0000267","TC0000268","TC0000269","TC0000270","TC0000271","TC0000272","TC0000273","TC0000275","TC0000276","TC0000277","TC0000278","TC0000279","TC0000280","TC0000281","TC0000282","TC0000284","TC0000285","TC0000287","TC0000288","TC0000289","TC0000293","TC0000294","TC0000295","TC0000296","TC0000297","TC0000298","TC0000299","TC0000300","TC0000301","TC0000302","TC0000303","TC0000304","TC0000305","TC0000306","TC0000307","TC0000308","TC0000309","TC0000310","TC0000311","TC0000312","TC0000314","TC0000315","TC0000317","TC0000318","TC0000319","TC0000323","TC0000324","TC0000326","TC0000329","TC0000330","TC0000331","TC0000332","TC0000333","TC0000334","TC0000335","TC0000336","TC0000337","TC0000338","TC0000339","TC0000340","TC0000342","TC0000343","TC0000344","TC0000346","TC0000347","TC0000349","TC0000350","TC0000351","TC0000352","TC0000353","TC0000354","TC0000356","TC0000357","TC0000359","TC0000361","TC0000362","TC0000363","TC0000364","TC0000365","TC0000366","TC0000383","TC0000384","TC0000385","TC0000386","TC0000390","TC0000391","TC0000392","TC0000393","TC0000394","TC0000395","TC0000396","TC0000397","TC0000398","TC0000399","TC0000408","TC0000409","TC0000410","TC0000411","TC0000412","TC0000414","TC0000415","TC0000417","TC0000418","TC0000419","TC0000428","TC0000431","TC0000432","TC0000435","TC0000436","TC0000437","TC0000438","TC0000439"]
//        
//        dest.each{
//            if(source.contains(it))
//                println it
//        }
//        
//        def file = new File('temp.txt')
//        def arr = new ArrayList()
//        file.each{line ->
//            arr << '\'' + line + '\''
//        }
//        println arr

//        def testNM = 'TC00000'
//        for(i in 1..406) {
//            println testNM + i
//        }

//        def dataStr = "2015-12-09 00:00:00.0"
//        println dataStr ==~ /^[0-9]{4}-[0-9]{2}-[0-9]{2}.*/
//        SimpleDateFormat format1
//        switch(dataStr) {
//            case ~/^[0-9]{4}-[0-9]{2}-[0-9]{2}.*/:
//                println "format 1"
//                break
//            case ~/^[0-1][0-9]-[0-3][0-9]-[0-9]{4}/:
//                println "format 2"
//                break
//            default:
//                println "failed"
//        } 
//        println dataStr ==~ /^[0-9]{4}-[0-9]{2}-[0-9]{2}.*/ 
//        def dataStr2 = "20150308"
//        def dateFormat = new SimpleDateFormat("yyyyMMdd")
//        println dateFormat.format(dateFormat.parse(dataStr2))

//          def file1 = "D:\\DATA_API_V2\\SoapUI\\fasttrackEQsource.xls"
//          def file2 = "D:\\DATA_API_V2\\SoapUI\\equitySourcing.xls"
//          FileInputStream fileIn = new FileInputStream(file1)
//          HSSFWorkbook wb = new HSSFWorkbook(fileIn)
//          HSSFSheet sheet = wb.getSheet("Sheet1")
//          def arr = new ArrayList()
//          sheet.each{row ->
//              arr <<  row.getCell(5)
//          }
//          arr[1..<arr.size()]
//          fileIn.close()
//          
//          FileInputStream fileIn2 = new FileInputStream(file2)  
//          HSSFWorkbook wb2 = new HSSFWorkbook(fileIn2)
//          HSSFSheet sheet2 = wb2.getSheet("Sheet1")
//          arr[1..<arr.size()].each{id ->
//              println id
//              def tag = false
//              for(row in sheet2) {
////                  println row.getCell(5).toString()
//                  if(id.toString() == row.getCell(5).toString()) {
//                      tag = true
//                      println row.getCell(3)
//                      break
//                  }
//              }
//              if(!tag)  println "Not Found"
//          }
//           def sourceIds = ["0P0000UZTV","0P0001523T","0P00002VK5","0P00013ML5","0P0000ZJWJ","0P0000WA1F","0P00015GHY","0P000034R7","0P000034C4","0P00013BII","0P00003B05","0P0000JYNA","0P00002SOX","0P00002SIH","0P000101ZY","0P000036DM","0P00003BF8","0P0000P0NU","0P0000P0NS","0P0000P0NC"]
//           def a = [1,2]
//           def b = [1,3]
//           println new HashSet(a + b)
//           
//        def avg = 13.399178422017533
//        def count = 9
//        def sum = 0
//        def arr = [17.72966266864293,15.338337069387741,4.499312160940461,25.00396544846959,6.020227996133931,5.7656044013769,17.85402590219651,12.44148037473436,15.939989776275375]
//        for(i in arr) {
//            sum += (Double)(i - avg)*(i - avg)
//        }
//        println Math.sqrt(sum / 8)
//        
//        def total = 0
//        arr.each{
//            total += it
//        }
//        println total/9
//        
//
//        def cc = '1'.tokenize(",")
//        println cc
//        
//        def test = new ArrayList()
//        test = [1,2,9]
//        test.eachWithIndex{i,j ->
//            println i
//            println j
//        }

        def a = "Open-End Fund::Anclassified".tokenize("::")
        println a.sort()
//        a.eachWithIndex{value, index ->
//            println value
//            println index     
//        }

        def xmlStr = '''<Results>
        <ResultSet fetchSize="128">
            <Row rowNumber="1">
                <ID>F00000M8DC</ID>
                <SRA01>1</SRA01>
                </Row>
            </ResultSet>
         </Results>
         '''    
        def xml = new XmlSlurper().parseText(xmlStr)
        def xml2 = new XmlParser().parseText(xmlStr)
//        println xml2.ResultSet.Row[0].children()
        xml.ResultSet.Row[0].children().each{println it}
        4.times{i ->
            println i
        }
        
       def t = "null,1,null,2"
       println new HashSet(t.tokenize(','))
        
//        def groovyClasspath = "D:\\DATA_API_V2\\SoapUI\\ScriptLib\\com\\mstar\\dataapi\\qa\\util"
//        String[] roots = [groovyClasspath]
//        def engine = new GroovyScriptEngine(roots)
//        def testGroovyGen = engine.loadScriptByName('Test.groovy')
//        def testGroovyGen2 = engine.loadScriptByName('Test2.groovy')
//        def testGroovy = testGroovyGen.newInstance()
//        def testGroovy2 = testGroovyGen2.newInstance()
//        println testGroovy.testInfo()
//        println testGroovy2.testInfo()
        
        try {
            def pStr = "abc"
            def pDouble = Double.valueOf(pStr)
        } catch(NumberFormatException e) {
            println "11111111"
        }
        
        def expected = null
        def nullValues = ["",null,"null"]
        def result = nullValues.contains(expected)
        println result
        
        def test1 = [""]
        println test1.grep{it}.size()
    }
    
}
