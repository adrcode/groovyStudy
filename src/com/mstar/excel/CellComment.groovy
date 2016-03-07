/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.excel

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.ClientAnchor
import org.apache.poi.ss.usermodel.Comment
import org.apache.poi.ss.usermodel.CreationHelper
import org.apache.poi.ss.usermodel.Drawing
import org.apache.poi.ss.usermodel.RichTextString
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFCell

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFCell

/**
 *
 * @author asun
 */
class CellComment {
    public static void main(args) throws IOException{
        /**
         * document: http://poi.apache.org/apidocs/index.html
         * 
         * A comment is a rich text note that is attached to & associated with a cell, separate 
         * from other cell content. Comment content is stored separate from the cell, and is displayed 
         * in a drawing object (like a text box) that is separate from, but associated with, a cell
        */
       
        def filePath = "D:\\workspace\\groovyStudy\\Example3.xlsx"
        
        Workbook wb = new XSSFWorkbook(); //or new HSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Test")   //创建工作表
        XSSFRow row = sheet.createRow(0)     //创建行
        XSSFCell cell = row.createCell(0)
        cell.setCellValue("Emma")
        row.createCell(1).setCellValue(true)
        row.createCell(2).setCellValue(new Date())
        row.createCell(3).setCellValue(1.11)
        
        // When the comment box is visible, have it show in a 1x3 space
        CreationHelper factory = wb.getCreationHelper()
        ClientAnchor anchor = factory.createClientAnchor()
        Drawing drawing = sheet.createDrawingPatriarch()
        
        // Create the comment and set the text+author
        Comment comment = drawing.createCellComment(anchor)
        RichTextString str = factory.createRichTextString("Hello, World!")
        comment.setString(str)
        comment.setAuthor("Apache POI")
        
        // Assign the comment to the cell
        cell.setCellComment(comment)
        
        FileOutputStream out = new FileOutputStream(filePath)
        wb.write(out)
        wb.close()
    }
}

