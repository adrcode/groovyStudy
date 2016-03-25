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
class JsonSchemaCheck {
    static String SchemaFolder
    
    static JsonNode getJsonByString(String jsonStr) {
        def mapper = new ObjectMapper()
        JsonNode json = mapper.readValue(jsonStr, JsonNode.class)
        return json
    }
    
    static JsonNode getJsonByFileName(String schemaFileName) {
        def mapper = new ObjectMapper()
        JsonNode json = mapper.readValue(new File(SchemaFolder, schemaFileName), JsonNode.class)
        return json
    }
    
    public static void SetSchemaFolder(String schemaFolder) {
        this.SchemaFolder = schemaFolder.replaceAll("\\", "/")
    }
    
    static void JsonNode(String jsonStr, String schemaFileName) {
        final def translatorCfg = URITranslatorConfiguration.newBuilder()
            .setNamespace(new URI(SchemaFolder)).freeze()
        
        final def cfg = LoadingConfiguration.newBuilder()
            .setURITranslatorConfiguration(translatorCfg).freeze()
        
        final def factory = JsonSchemaFactory.newBuilder()
            .setLoadingConfiguration(cfg).freeze()
            
        def json = getJsonByString(jsonStr)
        
        def schema = factory.getJsonSchema(schemaFileName)
        
        ProcessingReport report
        report = schema.validate(json)
        
        if(!report.success) {
            throw new Exception("Schema $schemaFileName Validation failed :" +report)
        }
    }
    
    public static void main(args) {
        def filePath = "file:/C:/Users/asun/Desktop/JsonSchemaValidation_Example/"
        SchemaFolder = filePath
        def schemaFileName = "jsonSchemaFile_Example1.json"
        def jsonStr = '''
            {
            "_meta":{
                    "response_status": 200100,
                    "hint": "Books successfully returned"
            },
            "books": [{
                    "author": "Jack",
                    "id": "1000",
                    "name": "groovy",
                    "price": "30"
            },
            {
                    "author": "Jimmy",
                    "id": "1001",
                    "name": "java",
                    "price": "32"
            },
            {
                    "author": "Jimmy",
                    "id": "1002",
                    "name": "c#",
                    "price": "32"
            },
            {
                    "author": "Jimmy",
                    "id": "1003",
                    "name": "html",
                    "price": "32"
            },
            {
                    "author": "Jimmy",
                    "id": "1004",
                    "name": "english",
                    "price": "32"
            },
            {
                    "author": "Jimmy",
                    "id": "1005",
                    "name": "sport",
                    "price": "32"
            },
            {
                    "author": "Jimmy",
                    "id": "1006",
                    "name": null,
                    "price": "32"
            }
            ]
        }
        '''
        
        JsonSchemaCheck.JsonNode(jsonStr, schemaFileName)
    }
}

