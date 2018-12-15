package com.example.student.kalkulator2;

public abstract class Operation {
    protected double firstNumber;
    protected  double secondNumber;
    public Operation(){}
    public Operation(double firstNumber, double secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }
    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public abstract Double execute();
}
