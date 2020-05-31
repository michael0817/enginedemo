package com.xumx.engine.enginedemo.service;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class GroovyEngine implements RuleEngine{

    @Override
    public Object run(String ruleName, Map context){
        try {
            GroovyScriptEngine engine = new GroovyScriptEngine("src/main/groovy");
            Binding binding1 = new Binding();
//            Object result1 = engine.run("GroovyTestRule.groovy", binding1);
//            if(null!=result1) {
//                System.out.println(result1);
//            }
//
//            System.out.println("===================================");

            Binding binding2 = new Binding();
            // arg 和 参数同名
            binding2.setVariable("map", context);
            Object result2 = engine.run(ruleName, binding2);
            System.out.println(result2);
            return result2;
        } catch (IOException | ResourceException | ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }
}
