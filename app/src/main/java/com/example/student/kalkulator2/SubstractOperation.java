package com.example.student.kalkulator2;

public class SubstractOperation extends Operation {
    public SubstractOperation(Double firstNumber, Double secondNumber){
        super(firstNumber, secondNumber);
    }
    public Double execute(){
        return firstNumber - secondNumber;
    }
}
