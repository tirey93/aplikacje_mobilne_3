package com.example.student.kalkulator2;

public class CalculatorMath {
    private String operand = "";
    private String buffor = "";
    private Double firstNumber = null;
    private Double secondNumber = null;

    public void setOperand(String operand) {
        this.operand = operand;
    }
    public void createNumber(String digit){
        buffor += digit;
    }
    public void setNumber() {
        Double numberDbl = null;
        try{
            numberDbl = Double.parseDouble(buffor);
        }
        catch (Exception ex){
            buffor = "";
            return;
        }
        if(firstNumber == null || secondNumber == null) {
            if (operand.length() < 1 && firstNumber == null) {
                firstNumber = numberDbl;
            } else {
                secondNumber = numberDbl;
            }
        }
        buffor = "";
    }
    public boolean isAbleToCalculate(){
        if(firstNumber != null && secondNumber != null && operand.length() > 0){
            return true;
        }
        return false;
    }
    public Double getSecondNumber(){
        return secondNumber;
    }
    public Double calculate(){
        if(operand.length() < 1){
            return firstNumber;
        }
        else {
            Operation operation = createOperation();
            if(operation != null){
                Double result = operation.execute();
                firstNumber = result;
                secondNumber = null;
                //operand = "";
                return result;
            }
        }
        return null;
    }
    public void clear(){
        firstNumber = null;
        secondNumber = null;
        operand = "";
    }
    private Operation createOperation(){
        if(operand.equals("+")){
            return new AddingOperation(firstNumber, secondNumber);
        }
        if(operand.equals("-")){
            return new SubstractOperation(firstNumber, secondNumber);
        }
        if(operand.equals("*")){
            return new MultiplyOperation(firstNumber, secondNumber);
        }
        if(operand.equals("/")){
            return new DivideOperation(firstNumber, secondNumber);
        }
        return null;
    }
}
