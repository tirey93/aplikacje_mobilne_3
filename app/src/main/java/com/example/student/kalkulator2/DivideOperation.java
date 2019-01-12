package com.example.student.kalkulator2;

public class DivideOperation extends Operation {
    public DivideOperation(Double firstNumber, Double secondNumber){
        super(firstNumber, secondNumber);
        operationSign = "/";
    }
    public Double execute(){
        return firstNumber / secondNumber;
    }
}
