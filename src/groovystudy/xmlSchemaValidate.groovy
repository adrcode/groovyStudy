/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groovystudy

import java.io.File
import java.io.InputStream
import javax.xml.transform.Source
import javax.xml.transform.stream.StreamSource
import java.io.ByteArrayInputStream

import javax.xml.validation.SchemaFactory
import javax.xml.validation.Schema
import javax.xml.validation.Validator
import org.xml.sax.SAXException


/**
 *
 * @author asun
 */
class xmlSchemaValidate {
    static final String SCHEMALANG = "http://www.w3.org/2001/XMLSchema"
    
     def boolean schemaFileCheck(String xmlPath, String xsdPath) {
         boolean flag = false
         try {           
            SchemaFactory factory = SchemaFactory.newInstance(SCHEMALANG)
            File xsdFile = new File(xsdPath)
             
            Schema xmlSchema = factory.newSchema(xsdFile)
            Validator check = xmlSchema.newValidator()
            Source source = new StreamSource(new File(xmlPath))
            
            try {
                check.validate(source)
                flag = true
            } catch(SAXException ex) {
                println ex.getMessage()
            }           
         } catch(Exception e) {
             println e.getMessage()
         }
        return flag
    }   
    
    
    def boolean schemaStrCheck(String xmlStr, String xsdPath) {
         boolean flag = false
         try {           
            SchemaFactory factory = SchemaFactory.newInstance(SCHEMALANG)
            File xsdFile = new File(xsdPath)
             
            Schema xmlSchema = factory.newSchema(xsdFile)
            Validator check = xmlSchema.newValidator()
            
            InputStream is = new ByteArrayInputStream(xmlStr.getBytes())
            Source source = new StreamSource(is)
            
            try {
                check.validate(source)
                flag = true
            } catch(SAXException ex) {
                println ex.getMessage()
            }           
         } catch(Exception e) {
             println e.getMessage()
         }
        return flag
    }  
    
    
    public static void main(args) {
        def xmlPath = "D:\\Automated\\XML_Schema\\custom\\custom.xml"
        def xsdPath = "D:\\Automated\\XML_Schema\\custom\\custom.xsd"
        println new xmlSchemaValidate().schemaFileCheck(xmlPath, xsdPath)
       
//        def xmlStr = '''<?xml version = "1.0"?><greeting>Hello World!</greeting>'''
//        println new xmlSchemaValidate().schemaStrCheck(xmlStr, xsdPath)
        
    }
}

