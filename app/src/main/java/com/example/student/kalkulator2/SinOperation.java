package com.example.student.kalkulator2;

public class SinOperation extends Operation {
    public SinOperation(Double firstNumber, Double secondNumber){
        super(firstNumber, null);
        isAdvanced = true;
        isSingleOperarand = true;
        operationSign = "sin";
    }
    public Double execute(){
        return Math.sin(firstNumber);
    }
}
