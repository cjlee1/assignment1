package com.example.calvin.cjlee_countbook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> listItems = new ArrayList<String>();
    private ListView CounterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view)
    {
        Intent intent = new Intent(MainActivity.this, NewCounter.class);
        startActivityForResult(intent,2 );
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String mString;



        mString = "hello everyone ! how r u?";

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==2) {
            if (resultCode == RESULT_OK) {

                Bundle extras = getIntent().getExtras();

                String returnData = data.getStringExtra("keyName");
                // set text view with string
               // TextView textView = (TextView) findViewById(R.id.textView);
               // textView.setText(returnData);
                CounterList=(ListView)findViewById(R.id.CounterList);
                ArrayList<String> listItems = new ArrayList<String>();
                listItems.add(returnData);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_2, listItems);
                CounterList.setAdapter(adapter);
                adapter.notifyDataSetChanged();




            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(mString);
            }

        }
    }
}
