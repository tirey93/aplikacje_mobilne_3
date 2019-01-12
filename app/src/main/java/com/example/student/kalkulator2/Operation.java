package com.example.student.kalkulator2;

public abstract class Operation {
    protected String operationSign = null;
    protected Double firstNumber = null;
    protected Double secondNumber = null;
    protected boolean isAdvanced = false;
    public Operation(){}
    public Operation(Double firstNumber, Double secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }
    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }
    public String getOperationSign(){
        return operationSign;
    }

    public abstract Double execute();
}
