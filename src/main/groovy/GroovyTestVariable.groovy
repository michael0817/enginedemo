package scripts.groovy

String varExecute(Map map){
    def payCodeEnum = ["1101","1102","1103"];
    def transCode = map.get("transCode");
    if(payCodeEnum.contains(transCode)){
        return "pay";
    }else{
        return "other";
    }
}

//执行方法
varExecute(map);

