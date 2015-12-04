/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.excel

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFCellStyle

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFCell


/**
 *
 * @author asun
 */
class NewWorkBook {
    static void main(args){
        //########################.xls file##################
        HSSFWorkbook wb = new HSSFWorkbook()     
        FileOutputStream fileOut = new FileOutputStream("failedCases.xls")  
       
        HSSFSheet sheet1 = wb.createSheet("new sheet")      //Add a Sheet for the excel file
        HSSFRow row1 = sheet1.createRow(0)              //Add a Row
        HSSFCell cell1 = row1.createCell(0)             //Add a Cell    
        cell1.setCellValue("Test")      //Set the value
        
        wb.write(fileOut)
        fileOut.close()
        
         //########################.xlsx file##################
         FileOutputStream fileOut2 = new FileOutputStream("failedCases.xlsx")
         XSSFWorkbook wb2 = new XSSFWorkbook()
         XSSFSheet sheet2 = wb2.createSheet("new sheet")           //Add a Sheet for the excel file
         XSSFRow row2 = sheet2.createRow(0)              //Add a Row
         XSSFCell cell2 = row2.createCell(0)             //Add a Cell 
         cell2.setCellValue("Test")                     //Set the value
         
        wb2.write(fileOut2)
        fileOut2.close()
    }
}
