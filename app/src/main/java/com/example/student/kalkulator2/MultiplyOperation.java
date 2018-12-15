package com.example.student.kalkulator2;

public class MultiplyOperation extends Operation {
    public MultiplyOperation(Double firstNumber, Double secondNumber){
        super(firstNumber, secondNumber);
    }
    public Double execute(){
        return firstNumber * secondNumber;
    }
}
