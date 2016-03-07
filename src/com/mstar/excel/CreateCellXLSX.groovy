/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.excel


import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFCell

/**
 *
 * @author asun
 */
class CreateCellXLSX {
    static void main(args) throws IOException {
        def filePath = "D:\\workspace\\groovyStudy\\Example1.xlsx"
        
        XSSFWorkbook wb = new XSSFWorkbook()   //创建EXCEL
        XSSFSheet sheet = wb.createSheet("Test")   //创建工作表
        XSSFRow row = sheet.createRow(0)     //创建行
        XSSFCell cell = row.createCell(0)
        cell.setCellValue("Emma")
        row.createCell(1).setCellValue(true)
        row.createCell(2).setCellValue(new Date())
        row.createCell(3).setCellValue(1.11)
        
        FileOutputStream fo = new FileOutputStream(filePath)
        wb.write(fo)
        fo.close()
        
    }
}

