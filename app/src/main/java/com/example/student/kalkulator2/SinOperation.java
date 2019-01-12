package com.example.student.kalkulator2;

public class SinOperation extends Operation {
    public SinOperation(Double firstNumber, Double secondNumber){
        super(null, secondNumber);
        isAdvanced = true;
        operationSign = "sin";
    }
    public Double execute(){
        return Math.sin(secondNumber);
    }
}
