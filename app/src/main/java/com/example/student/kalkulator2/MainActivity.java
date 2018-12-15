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
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    private Queue<String> values = new LinkedList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void buttonNumberClick(View view){
        String value = ((Button) view).getText().toString();
        Toast.makeText(MainActivity.this, ((Button) view).getText().toString(),
                Toast.LENGTH_LONG).show();
        values.add(value);
    }
    public void buttonFunctionClick(View view){
        String value = ((Button) view).getText().toString();
        Toast.makeText(MainActivity.this, value + " func",
                Toast.LENGTH_LONG).show();
        values.add(value);
    }
    public void buttonEqualsClick(View view){
        Toast.makeText(MainActivity.this, values.toString(),
                Toast.LENGTH_LONG).show();
        int buffer = 0;
        String lastOperand = "";
        for(String v : values){
            int number = 0;
            try{
                number = Integer.parseInt(v);
            }
            catch (Exception ex){
                if(v == "+"){
                    lastOperand = v;
                }
            }
            if(number != 0){
                buffer += number;
            }
            lastOperand = "";
        }
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
