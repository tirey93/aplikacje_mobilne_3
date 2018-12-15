package com.example.student.kalkulator2;

public class AddingOperation extends Operation {
    public AddingOperation(double firstNumber, double secondNumber){
        super(firstNumber, secondNumber);
    }
    public Double execute(){
        return firstNumber + secondNumber;
    }
}
