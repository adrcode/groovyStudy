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
import org.apache.poi.hssf.usermodel.HSSFFont
import org.apache.poi.hssf.usermodel.HSSFRichTextString

import org.apache.poi.hssf.util.HSSFColor
import org.apache.poi.hssf.util.Region
import org.apache.poi.ss.usermodel.CellStyle

import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFColor
import org.apache.poi.ss.usermodel.IndexedColors


/**
 *
 * @author asun
 */
class ExcelStyle {
       static void main(args) {
            FileOutputStream fileOut = new FileOutputStream("failedCases.xls")
            HSSFWorkbook wb = new HSSFWorkbook()
            HSSFSheet sheet = wb.createSheet("Sheet1")
            HSSFRow row = sheet.createRow(0) 
            HSSFCellStyle cellStyle = wb.createCellStyle()
            HSSFFont font = wb.createFont()
            HSSFFont font2 = wb.createFont()
            
            //#########################1. Set the column width ####################
            sheet.setColumnWidth(0, 3000)      //Column: 0,  Width: 6000

            //#########################2. Set the foreground color #################### 
            cellStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index)
 //           cellStyle.setFillForegroundColor((short) 13)
            cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND)
      
            //########################3. Set the Border ##############################
            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN)
            cellStyle.setBottomBorderColor(HSSFColor.RED.index)
            
            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN)
            cellStyle.setLeftBorderColor(HSSFColor.RED.index)
            
            cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN)
            cellStyle.setRightBorderColor(HSSFColor.RED.index)
            
            cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN)
            cellStyle.setTopBorderColor(HSSFColor.RED.index)
            
            //######################4. Set to Alignment  and set vertical Alignment#########
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER)
            cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER)

            //#######################5. Set the Font###########################
            font.setFontName("黑体")
            font.setFontHeightInPoints((short) 15)    //set the font size
            
            font2.setFontName("仿宋_GB2312")
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD)
            font2.setFontHeightInPoints((short) 12)
            cellStyle.setFont(font2)
        
            //#########################6. 自动换行 ####################
            cellStyle.setWrapText(true)
            
            //#########################7. 合并单元格 ####################
            Region region = new Region(0, (short) 0, 0, (short) 6)
            sheet.addMergedRegion(region)
            
            //#########################8. 设置行高 ####################
            row.setHeight((short) 400)
        
            
            HSSFCell cell = row.createCell(0)
            cell.setCellStyle(cellStyle)
            cell.setCellValue("Hello world!")
            
            
            HSSFRow row2 = sheet.createRow(1)
            HSSFCell cell2 = row2.createCell(0)
            
            //#########################9. HSSFRichTextString ####################
            HSSFFont ftRed = wb.createFont()
            ftRed.setColor(HSSFColor.RED.index)
            ftRed.setStrikeout(true)
            HSSFFont ftBlue = wb.createFont()
            ftBlue.setColor(HSSFColor.BLUE.index)            
            
            HSSFRichTextString textString = new HSSFRichTextString("first,second")
            textString.applyFont(0, 4, ftRed)
            textString.applyFont(6, 11, ftBlue)
            cell2.setCellValue(textString)
    
            wb.write(fileOut)
            
       }
}

