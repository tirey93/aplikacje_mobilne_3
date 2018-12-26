package com.example.student.kalkulator2;

public class SinOperation extends Operation {
    public SinOperation(Double firstNumber, Double secondNumber){
        super(null, secondNumber);
    }
    public Double execute(){
        return Math.sin(secondNumber);
    }
}
