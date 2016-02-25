/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groovystudy;

/**
 *
 * @author asun
 */
import java.io.ByteArrayInputStream;  
import java.io.File;  
import java.io.InputStream;  
  
import javax.xml.transform.Source;  
import javax.xml.transform.stream.StreamSource;  
import javax.xml.validation.Schema;  
import javax.xml.validation.SchemaFactory;  
import javax.xml.validation.Validator;  
  
import org.apache.log4j.Logger;  
import org.xml.sax.SAXException;  
  
/** 
 * @desc    xml验证 
 * @author  zhangh 
 * @date    2013-5-13 上午11:12:55 
 * 
 */  
public class XmlValidateUtil {  
      
    private static final Logger logger = Logger.getLogger(XmlValidateUtil.class);  
  
    private static final String SCHEMALANG = "http://www.w3.org/2001/XMLSchema";  
  
    /** 
     * Schema校验xml文件 
     * @param xmlPath xml字符串 
     * @param xsdPath xsd文件路径 
     * @return xml文件是否符合xsd定义的规则 
     */  
    public static boolean xmlStringValidate(String xmlStr, String xsdPath) {  
        boolean flag = false;  
        try {  
            SchemaFactory factory = SchemaFactory.newInstance(SCHEMALANG);  
            File schemaLocation = new File(xsdPath);  
            Schema schema = factory.newSchema(schemaLocation);  
            Validator validator = schema.newValidator();  
            InputStream is = new ByteArrayInputStream(xmlStr.getBytes());  
            Source source = new StreamSource(is);  
            try {  
                validator.validate(source);  
                flag = true;  
            } catch (SAXException ex) {  
                logger.info(ex.getMessage());  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return flag;  
    }  
      
    /** 
     * Schema校验xml文件 
     * @param xmlPath xml文件路径 
     * @param xsdPath xsd文件路径 
     * @return xml文件是否符合xsd定义的规则 
     */  
    public static boolean xmlFileValidate(String xmlPath, String xsdPath) {  
        boolean flag = false;  
        try {  
            SchemaFactory factory = SchemaFactory.newInstance(SCHEMALANG);  
            File schemaLocation = new File(xsdPath);  
            Schema schema = factory.newSchema(schemaLocation);  
            Validator validator = schema.newValidator();  
            Source source = new StreamSource(xmlPath);  
  
            try {  
                validator.validate(source);  
                flag = true;  
            } catch (SAXException ex) {  
                logger.info(ex.getMessage());  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return flag;  
    }  
    
    public static void main(String[] args) {
        String xsdPath = "demo.xsd";
        String tranData = '''<B2CReq> </B2CReq>'''
        XmlValidateUtil.xmlStringValidate(tranData, xsdPath);
    }
}  
