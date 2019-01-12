package com.example.student.kalkulator2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView outputResult = null;
    private TextView inputExpression = null;
    private  CalculatorMath calculatorMath = new CalculatorMath();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        outputResult = (TextView) findViewById(R.id.outputResult);
        inputExpression = (TextView) findViewById(R.id.inputExpression);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
    public void buttonNumberClick(View view){
        String value = ((Button) view).getText().toString();
//        Toast.makeText(MainActivity.this, ((Button) view).getText().toString(),
//                Toast.LENGTH_LONG).show();
        inputExpression.setText(inputExpression.getText() + value);
        calculatorMath.createNumber(value);
    }
    public void buttonFunctionClick(View view){
        String value = ((Button) view).getText().toString();
//        Toast.makeText(MainActivity.this, value + " func",
//                Toast.LENGTH_LONG).show();


        String textToInsert = "";
        if(inputExpression.getText().length() > 0) {
            if (
                    Character.isDigit(inputExpression.getText().charAt(inputExpression.getText().length() - 1))
                    || inputExpression.getText().charAt(inputExpression.getText().length() - 1) == ')') {
                if(value.equals("c")){
                   if(calculatorMath.deleteDigitFromBuffor()){
                       inputExpression.setText
                               (inputExpression.getText().subSequence(0, inputExpression.getText().length() - 1));
                       return;
                   }
                }
                textToInsert = inputExpression.getText() + " " + value + " ";
                calculatorMath.setNumber();
                if (calculatorMath.isAbleToCalculate()) {
                    buttonEqualsClick(null);
                }
                calculatorMath.setOperand(value);
            }
        }
        Operation operation = calculatorMath.getOperation();
        if(operation != null) {
            if (operation.isAdvanced) {
                textToInsert = inputExpression.getText() + " " + value + "(";
                calculatorMath.setOperand(value);
            }
        }
        inputExpression.setText(textToInsert);
    }
    public void buttonClearClick(View view){
        calculatorMath.clear();
        inputExpression.setText("");
        outputResult.setText("");
    }
    public void buttonEqualsClick(View view){
        calculatorMath.setNumber();
        Double result = calculatorMath.calculate();
        if(result != null) {
            outputResult.setText(String.format("%.2f", result));
            if(calculatorMath.getOperand().equals("sin")){
                inputExpression.setText(inputExpression.getText() + ")");
            }
        }
    }
    public  void buttonExitClick(View view){
        System.exit(0);
    }
    public void buttonInfoClick(View view){
        Toast.makeText(MainActivity.this, "Autor: Damian Pytkowski \nIndeks: 202280\nOpis: Kalkulator do prostych obliczeń.",
                Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.aboutSetting) {
            buttonInfoClick(null);
            return true;
        }
        if( id == R.id.exitSetting){
            buttonExitClick(null);
            return true;
        }
        if( id == R.id.modeSetting){
            Button cButton = (Button)findViewById(R.id.buttonCSin);
            if(item.getTitle().equals("Tryb rozszerzony")) {
                item.setTitle("Tryb podstawowy");
                cButton.setText("sin");
            }
            else{
                item.setTitle("Tryb rozszerzony");
                cButton.setText("c");
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
