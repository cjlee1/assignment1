package com.example.calvin.cjlee_countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewCounter extends AppCompatActivity {
    /* public static final String Counter_name = "com.examplecjlee-countbook.MESSAGE"; */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_counter);
    }
    public void SendCounterData(View view){

        //get counter name
        EditText editText = (EditText) findViewById(R.id.editText);
        String CounterName =editText.getText().toString();

        //get counter date
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String c_date =editText2.getText().toString();

        //get initial value
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        String initial_val =editText4.getText().toString();
        //get current value
        EditText editText5 = (EditText) findViewById(R.id.editText5);
        String current_val =editText5.getText().toString();

        //get text in comments
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String comments =editText3.getText().toString();


        Intent intent =  new Intent();
        intent.putExtra("CounterName",CounterName);
        intent.putExtra("Date",c_date);
        intent.putExtra("InitialVal",initial_val);
        intent.putExtra("CurrentVal",current_val);
        intent.putExtra("Comment",comments);
        setResult(RESULT_OK, intent);
        finish();

    }
}
