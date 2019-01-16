package com.example.student.kalkulator2;

public class SqrtOperation extends Operation {
    public SqrtOperation(Double firstNumber, Double secondNumber){
        super(firstNumber, null);
        operationSign = "sqrt";
        isAdvanced = true;
        isSingleOperarand = true;
    }
    public Double execute(){
        return Math.sqrt(firstNumber);
    }
}
