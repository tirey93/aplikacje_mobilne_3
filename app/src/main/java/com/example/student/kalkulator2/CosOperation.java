package com.example.student.kalkulator2;

public class CosOperation extends Operation {
    public CosOperation(Double firstNumber, Double secondNumber){
        super(firstNumber, null);
        isAdvanced = true;
        isSingleOperarand = true;
        operationSign = "cos";
    }
    public Double execute(){
        return Math.cos(firstNumber);
    }
}
