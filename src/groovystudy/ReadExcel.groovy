/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groovystudy

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.xssf.usermodel.XSSFCell

/**
 *
 * @author asun
 */
class ReadExcel {
	static void main(args) {
            def fileUrl = "D:\\DATA_API_V2\\SoapUI\\source - Copy.xls"
            FileInputStream is = new FileInputStream(fileUrl)  
            HSSFWorkbook workbook = new HSSFWorkbook(is)  
            def sheet = workbook.getSheet("Sheet1")
            sheet.eachWithIndex{row, index ->
                println row.append(',')
//                row.each{cell ->
//                   println  cell
//                }
            }
        }
}

