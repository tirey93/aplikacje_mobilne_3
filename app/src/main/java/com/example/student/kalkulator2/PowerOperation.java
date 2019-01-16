package com.example.student.kalkulator2;

public class PowerOperation extends Operation {
    public PowerOperation(Double firstNumber, Double secondNumber){
        super(firstNumber, secondNumber);
        operationSign = "^";
    }
    public Double execute(){
        return Math.pow(firstNumber, secondNumber);
    }
}
