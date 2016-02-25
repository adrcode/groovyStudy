/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groovystudy

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.JsonNode
import com.github.fge.jsonschema.core.exceptions.ProcessingException
import com.github.fge.jsonschema.core.report.ProcessingReport
import com.github.fge.jsonschema.main.JsonSchema
import com.github.fge.jsonschema.main.JsonSchemaFactory
import com.github.fge.jsonschema.core.load.uri.URITranslatorConfiguration
import com.github.fge.jsonschema.core.load.configuration.LoadingConfiguration

/**
 *
 * @author asun
 */
class JsonSchemaExample {
    static void main(args) {
        //Response
        def filePath = "file:/D:/DATA_API_V2/SoapUI/schema/dataapiv2/"
        def jsonStr = '''{
	"book":"1",
	"name":"sunny"
        }''' 
        def mapper = new ObjectMapper()
        JsonNode json = mapper.readValue(jsonStr, JsonNode.class)        
        
        
        def schemaFileName = "test.json"
        def traslatorCfg = URITranslatorConfiguration.newBuilder().setNamespace(new URI(filePath)).freeze()
        def cfg = LoadingConfiguration.newBuilder().setURITranslatorConfiguration(traslatorCfg).freeze()
        def factory = JsonSchemaFactory.newBuilder().setLoadingConfiguration(cfg).freeze()
        def schema = factory.getJsonSchema(schemaFileName)
        
        ProcessingReport report = schema.validate(json)      
        if(!report.success) {
            throw new Exception("Schema $schemaFileName Validation failed :" +report)
        }
       println Double.valueOf("null")
    }
  
}

