package com.xumx.engine.enginedemo.service;

import java.util.Map;

public interface RuleEngine {
    public Object run(String ruleName, Map context);
}
