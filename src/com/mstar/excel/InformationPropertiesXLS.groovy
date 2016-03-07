/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.excel

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook

import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hpsf.DocumentSummaryInformation
import org.apache.poi.hpsf.SummaryInformation
import org.apache.poi.hssf.usermodel.HSSFCell

/**
 *
 * @author asun
 */
class InformationPropertiesXLS {
    static void main(args) throws IOException{
        def filePath = "D:\\workspace\\groovyStudy\\Example2.xls"
      
        Workbook wb = new HSSFWorkbook()    //创建EXCEL文件
        
        HSSFSheet sheet = wb.createSheet("Test")   //创建工作表      
        HSSFRow row = sheet.createRow(0)       //创建行
        HSSFCell cell = row.createCell(0)   //创建行的单元
        cell.setCellValue("Emma")           //设置单元格内容
        row.createCell(1).setCellValue(false)
        row.createCell(2).setCellValue(new Date())
        row.createCell(3).setCellValue(12.22)
        
        wb.createInformationProperties()  //创建文档信息
        DocumentSummaryInformation dsi = wb.getDocumentSummaryInformation()  //摘要信息
        dsi.setCategory("类别：Excel文件")   //类别
        dsi.setManager("Manager: Adrian")   //管理者
        dsi.setCompany("Company：Mstar")
        
        SummaryInformation si = wb.getSummaryInformation()  //摘要信息
        si.setSubject("主题：--")
        si.setTitle("标题：测试文档")
        si.setAuthor("作者：Adrian")
        si.setComments("备注：POI测试文档")
        
        FileOutputStream out = new FileOutputStream(filePath)
        wb.write(out)
        out.close()  //关闭文件流        
    }
	
}

