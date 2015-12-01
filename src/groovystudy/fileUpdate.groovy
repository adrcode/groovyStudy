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
class fileUpdate {
    static void main(args) {
        def path = "D:\\DATA_API_V2\\soapui\\DataContent-functional-tests\\New folder"
        def dir = new File(path)
//        def file = new File(path + "\\StrategicBetaDataPoints_XIUSA000KQ.xml")
//            def fileText = file.text
//            println fileText.contains("assertEquals(\"The STRATEGICBETA is not right!\", expectSTRATEGICBETA,STRATEGICBETA)")
//            fileText = fileText.replace("assertEquals(\"The STRATEGICBETA is not right!\", expectSTRATEGICBETA,STRATEGICBETA)","compare.compareValues(expectSTRATEGICBETA, STRATEGICBETA)")
//            fileText = fileText.replace("assertEquals(\"The STRATEGICBETAATTRIBUTES is not right!\", expectedSTRATEGICBETAGROUP,STRATEGICBETAGROUP)","compare.compareValues(expectedSTRATEGICBETAGROUP, STRATEGICBETAGROUP)")
//            fileText = fileText.replace("assertEquals(\"The STRATEGICBETAATTRIBUTES is not right!\", expectSTRATEGICBETAATTRIBUTES,STRATEGICBETAATTRIBUTES)","compare.compareValues(expectSTRATEGICBETAATTRIBUTES, STRATEGICBETAATTRIBUTES)")
//            fileText = fileText.replace("def expectSTRATEGICBETAGROUP = context.expand('')","")
//            fileText = fileText.replace(")[0]",")")
//            file.write(fileText)    
        dir.eachFileMatch(~/.*\.xml/){file ->
//            println file.name
            def fileText = file.text
//            fileText = fileText.replaceAll("import com.mstar.dataapi.qa.JsonHelper","import com.mstar.dataapi.qa.JsonHelper\nimport com.mstar.dataapi.qa.util.SecuritiesRICEV\nimport com.mstar.dataapi.qa.util.Compare")
//            fileText = fileText.replaceAll("json = jsonHelper.ParseText()","json = jsonHelper.ParseText()\ndef data = new SecuritiesRICEV()\ndef compare = new Compare")
            fileText = fileText.replaceAll("def compare = new Compare()","def compare = new Compare()\n\ndef actualValue = data.getDataValues_V(json, dataPointNM, performanceId)")
//            fileText = fileText.replace("assertEquals(\"The STRATEGICBETA is not right!\", expectSTRATEGICBETA,STRATEGICBETA)","compare.compareValues(expectSTRATEGICBETA, STRATEGICBETA)")
//            fileText = fileText.replace("assertEquals(\"The STRATEGICBETAATTRIBUTES is not right!\", expectedSTRATEGICBETAGROUP,STRATEGICBETAGROUP)","compare.compareValues(expectedSTRATEGICBETAGROUP, STRATEGICBETAGROUP)")
//            fileText = fileText.replace("assertEquals(\"The STRATEGICBETAATTRIBUTES is not right!\", expectSTRATEGICBETAATTRIBUTES,STRATEGICBETAATTRIBUTES)","compare.compareValues(expectSTRATEGICBETAATTRIBUTES, STRATEGICBETAATTRIBUTES)")
//            fileText = fileText.replace("def expectSTRATEGICBETAGROUP = context.expand('')","")
//            fileText = fileText.replace(")[0]",")")
            file.write(fileText)            
        }

    }
}

