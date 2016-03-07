/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.excel

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.hpsf.DocumentSummaryInformation
import org.apache.poi.hpsf.SummaryInformation
import org.apache.poi.xssf.usermodel.XSSFCell

import org.apache.poi.POIXMLProperties
import org.apache.poi.POIXMLProperties.CoreProperties
import org.apache.poi.POIXMLProperties.ExtendedProperties



/**
 *
 * @author asun
 */
class InformationPropertiesXLSX {
    static void main(args) throws IOException {
        def filePath = "D:\\workspace\\groovyStudy\\Example2.xlsx"
        
        Workbook wb = new XSSFWorkbook()   //创建EXCEL
        XSSFSheet sheet = wb.createSheet("Test")   //创建工作表
        XSSFRow row = sheet.createRow(0)     //创建行
        XSSFCell cell = row.createCell(0)
        cell.setCellValue("Emma")
        row.createCell(1).setCellValue(true)
        row.createCell(2).setCellValue(new Date())
        row.createCell(3).setCellValue(1.11)
        
        POIXMLProperties props = wb.getProperties()
        CoreProperties corp = props.getCoreProperties()

        corp.setCategory("类别:Excel文件")
        corp.setContentStatus("状态：--")
        corp.setContentType("类型：--")
        corp.setTitle("标题：--")
        corp.setSubjectProperty("主题:--")
        corp.setDescription("描述：--")
        corp.setCreator("作者：--")
        
        FileOutputStream fo = new FileOutputStream(filePath)
        wb.write(fo)
        fo.close()        
    }
}

