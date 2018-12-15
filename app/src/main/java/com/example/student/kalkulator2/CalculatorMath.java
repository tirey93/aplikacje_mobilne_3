package com.example.student.kalkulator2;

public class CalculatorMath {
    private String operand = "";
    private String buffor = "";
    private double firstNumber;
    private double secondNumber;

    public void setOperand(String operand) {
        this.operand = operand;
    }
    public void createNumber(String digit){
        buffor += digit;
    }
    public void setNumber() {
        double numberDbl = 0.0;
        try{
            numberDbl = Double.parseDouble(buffor);
        }
        catch (Exception ex){ }
        if(operand.length() < 1 && firstNumber == 0.0){
            firstNumber = numberDbl;
        }
        else {
            secondNumber = numberDbl;
        }
        buffor = "";
    }
    public double calculate(){
        if(operand.length() < 1){
            return firstNumber;
        }
        else {
            Operation operation = createOperation();
            if(operation != null){
                double result = operation.execute();
                firstNumber = result;
                secondNumber = 0.0;
                operand = "";
                return result;
            }
        }
        return 0.0;
    }
    public void clear(){
        firstNumber = 0.0;
        secondNumber = 0.0;
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
        return null;
    }
}
