package com.xumx.engine.enginedemo.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xumx.engine.enginedemo.service.RuleEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/engine/groovy")
public class GroovyEngineController {

    @Autowired
    RuleEngine groovyEngine;

    @RequestMapping(value="/ruleExecute/{arg}",method= RequestMethod.GET)
    public Object ruleExecute(@PathVariable String arg){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map m = mapper.readValue(arg, Map.class);
            return "决策判断："+groovyEngine.run("GroovyTestRule.groovy",m);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value="/varExecute/{arg}",method= RequestMethod.GET)
    public Object varExecute(@PathVariable String arg){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map m = mapper.readValue(arg, Map.class);
            return "变量加工："+groovyEngine.run("GroovyTestVariable.groovy",m);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
