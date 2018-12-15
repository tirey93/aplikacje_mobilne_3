package com.example.student.kalkulator2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

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
        inputExpression.setText(inputExpression.getText() + " " + value + " ");
        calculatorMath.setNumber();
        calculatorMath.setOperand(value);
    }
    public void buttonClearClick(View view){
        calculatorMath.clear();
        inputExpression.setText("");
        outputResult.setText("");
    }
    public void buttonEqualsClick(View view){
        calculatorMath.setNumber();
        outputResult.setText(String.format("%.2f", calculatorMath.calculate()));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
