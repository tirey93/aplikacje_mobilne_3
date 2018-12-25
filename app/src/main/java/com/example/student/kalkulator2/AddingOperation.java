package com.example.student.kalkulator2;

public class AddingOperation extends Operation {
    public AddingOperation(Double firstNumber, Double secondNumber){
        super(firstNumber, secondNumber);
    }
    public Double execute(){
        return firstNumber + secondNumber;
    }
}
