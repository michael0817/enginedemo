package scripts.groovy

String ruleExecute(Map map){
    def result = true;
    def condResults = [];

    map.each {k,v->
        def matchResult = String.valueOf(v).compareTo("A")==0;
        result = result && matchResult;
        def condResult = ["var":k,"valueA":v,"valueB":"A","matchResult":matchResult];
        condResults.add(condResult);
    }
    def output = ["result":result,"condResults":condResults];
    return output;
}

//执行方法
ruleExecute(map);

