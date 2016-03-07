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

/**
 *
 * @author asun
 */
class CreateCellXLS {
    public static void main(args) throws IOException {
        def filePath = "D:\\workspace\\groovyStudy\\Example1.xls"
      
        HSSFWorkbook wb = new HSSFWorkbook()    //创建EXCEL文件
        
        HSSFSheet sheet = wb.createSheet("Test")   //创建工作表      
        HSSFRow row = sheet.createRow(0)       //创建行
        HSSFCell cell = row.createCell(0)   //创建行的单元
        cell.setCellValue("Emma")           //设置单元格内容
        row.createCell(1).setCellValue(false)
        row.createCell(2).setCellValue(new Date())
        row.createCell(3).setCellValue(12.22)
    
        FileOutputStream out = new FileOutputStream(filePath)
        wb.write(out)
        out.close()  //关闭文件流
    }
}

