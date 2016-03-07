/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.excel

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFRow
import com.google.common.collect.ArrayTable.Row
import javafx.scene.control.Cell
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.ss.usermodel.WorkbookFactory

/**
 *
 * @author asun
 */
class CellUpdate {
    static void main(args) throws IOException{
        def filePath = "D:\\workspace\\groovyStudy\\Example3.xlsx"
        //or def filePath = "D:\\workspace\\groovyStudy\\Example3.xls"
        
        InputStream fi = new FileInputStream(filePath)
        Workbook wb = WorkbookFactory.create(fi)
 
        Sheet sheet = wb.getSheetAt(0)
        XSSFRow row = sheet.getRow(0)
        XSSFCell cell = row.getCell(3)
        cell.setCellValue("Update cell information!")
        
        FileOutputStream fo = new FileOutputStream(filePath)
        wb.write(fo)
        fo.close()
        
    }
}

