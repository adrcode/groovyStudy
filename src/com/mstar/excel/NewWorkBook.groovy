/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.excel

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
/**
 *
 * @author asun
 */
class NewWorkBook {
    static void main(args){
        //########################.xls file##################
//        HSSFWorkbook wb = new HSSFWorkbook()     
//        //Add a new excel(.xls) file
//        FileOutputStream fileOut = new FileOutputStream("failedCases.xls")  
//        //Add a sheet for the excel file
//        wb.createSheet("new sheet")
//        
//        wb.write(fileOut)
//        fileOut.close()
//        
//         //########################.xlsx file##################
//         XSSFWorkbook wb2 = new XSSFWorkbook()
//         wb2.createSheet("new sheet")
//         FileOutputStream fileOut2 = new FileOutputStream("failedCases.xlsx")
//         
//        wb2.write(fileOut2)
//        fileOut2.close()

        def list = new ArrayList()   
        FileInputStream fileInput = new FileInputStream("source.xls")
        HSSFWorkbook wb = new HSSFWorkbook(fileInput)  
        wb.getSheet("Sheet1").getRow(1).each{cell ->
            list << cell.getCellType()
        }
        println list
    }
}

