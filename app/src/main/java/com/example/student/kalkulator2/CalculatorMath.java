package com.example.student.kalkulator2;

public class CalculatorMath {
    //private String operand = "";
    private String buffor = "";
    private Double firstNumber = null;
    private Double secondNumber = null;
    private  Operation operation = null;

    public void setOperand(String operand) {
        if(!Character.isDigit(operand.charAt(operand.length() - 1))) {
            operation = createOperation(operand);
        }
    }
    public String getOperand(){
        if(operation != null){
            return operation.getOperationSign();
        }
        else {
            return "";
        }
    }
    public Operation getOperation(){
        return operation;
    }
    public void createNumber(String digit){
        buffor += digit;
    }
    public boolean deleteDigitFromBuffor(){
        if(buffor.length() > 0){
            buffor = buffor.substring(0, buffor.length() - 1);
            return true;
        }
        return false;
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
            if (firstNumber == null) {
                firstNumber = numberDbl;
            } else {
                secondNumber = numberDbl;
            }
        }
        buffor = "";
    }
    public boolean isAbleToCalculate(){
        if(firstNumber != null && getOperand().length() > 0){
            if(getOperation().isSingleOperarand) {
                return true;
            }
            if(secondNumber != null){
                return true;
            }
        }
        return false;
    }
    public Double getSecondNumber(){
        return secondNumber;
    }
    public Double calculate(){
        if(getOperand().length() < 1){
            return firstNumber;
        }
        else {
//            Operation operation = createOperation();
            if(operation != null){
                operation.setFirstNumber(firstNumber);
                operation.setSecondNumber(secondNumber);
                if(firstNumber != null) {
                    if(secondNumber != null || operation.isSingleOperarand) {
                        Double result = operation.execute();
                        firstNumber = result;
                        secondNumber = null;
                        //operand = "";
                        return result;
                    }
                    else{
                        return secondNumber;
                    }
                }
                else if (firstNumber != null){
                    return  firstNumber;
                }
                else{
                    return null;
                }
            }
        }
        return null;
    }
    public void clear(){
        firstNumber = null;
        secondNumber = null;
        operation = null;
    }
    private Operation createOperation(String operand){
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
        if(operand.equals("sin")){
            return new SinOperation(firstNumber, secondNumber);
        }
        return null;
    }
}
