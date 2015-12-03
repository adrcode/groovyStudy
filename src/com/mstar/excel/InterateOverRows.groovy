/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.excel

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import com.mstar.excel.ResultAnalyze

/**
 *
 * @author asun
 */
class InterateOverRows {
    
    def fileTestResult
    def sourceFile
    def destFile
    
    InterateOverRows(fileTestResult, sourceFile, destFile) {
        this.fileTestResult = fileTestResult
        this.sourceFile = sourceFile
        this.destFile = destFile
    }
    
    def separateTCs(caseStatus){
        def result = new ResultAnalyze(fileTestResult)
        result.analyzeTestResult()
        def ids
        if(caseStatus == 'Fail') {
            ids = result.getFailedCases()
        } else if(caseStatus == 'Pass') {
            ids = result.getPassedCases()
        } else {
            throw new Exception("The cases status you have input is not right!")
        }
        
        FileInputStream fileInput = new FileInputStream(sourceFile)
        HSSFWorkbook swb = new HSSFWorkbook(fileInput)
        Sheet sSheet = swb.getSheetAt(0)
        def firstRow = swb.getSheetAt(0).getRow(0)
        
        FileOutputStream fo = new FileOutputStream(destFile)
        HSSFWorkbook dwb = new HSSFWorkbook()
        def dSheet= dwb.createSheet("Sheet1")
        
        //Set the headers of the new Excel file
        Row dFirstRow = dSheet.createRow(0)
        firstRow.eachWithIndex{cl, index->
            Cell cell = dFirstRow.createCell(index)
            cell.setCellValue(cl.toString())
        }
        
        //Update other the rows
        ids.each{caseNum ->
            sSheet.each{rw ->
                if(caseNum == rw.getCell(0).toString()){
                    def rowNum = dSheet.getLastRowNum() + 1
                    dSheet.createRow(rowNum)
                    def i = 0
                    def lstNum = rw.getLastCellNum()
                    def fstNum = rw.getFirstCellNum()
                    for(index in (fstNum..lstNum)) {
                        def cl = dSheet.getRow(rowNum).createCell(index)                       
                        if(rw.getCell(index) != null) {
                            cl.setCellValue(rw.getCell(index).convertCellValueToString())
                            cl.setCellType(1)                            
                        } else {
                            continue
                        }
                    }
                }                  
            }
        }
        
        dwb.write(fo)
        fo.close()  
        
    }
    
    static void main(args) {
            def pass = new InterateOverRows('result_20151201033534.txt', 'source - Copy.xls', 'passedCases.xls')
            def fail = new InterateOverRows('result_20151201033534.txt', 'source - Copy.xls', 'failedCases.xls')
            pass.separateTCs('Pass')
            fail.separateTCs('Fail')

    }
}

