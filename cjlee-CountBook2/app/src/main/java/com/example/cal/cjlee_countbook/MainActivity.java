package com.example.cal.cjlee_countbook;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {
/**    ListView CounterList;
    Button EnterButton;
    EditText EditText1;
    EditText Comment;
    EditText initialval;
    EditText CurVal;
    EditText Date1;
**/
    List<CounterListItem>counterList = new ArrayList<CounterListItem>();
    CustomAdapter cAdpt;
    Button EnterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //popList();

         final EditText edit1 = (EditText)findViewById(R.id.editText);
        // final EditText edit2 = (EditText)findViewById(R.id.editText2);
         final EditText edit3 = (EditText)findViewById(R.id.editText3);
         final EditText edit4 = (EditText)findViewById(R.id.editText4);
         final EditText edit5 = (EditText)findViewById(R.id.editText5);

        ListView lv = (ListView)findViewById(R.id.CounterList1);
        EnterButton = (Button)findViewById(R.id.button1);

        cAdpt= new CustomAdapter(counterList,this);
        lv.setAdapter(cAdpt);
       /** CounterList = (ListView) findViewById(R.id.CounterList1);
        EnterButton = (Button)findViewById(R.id.button1);
        EditText1 = (EditText)findViewById(R.id.editText);
        Comment = (EditText)findViewById(R.id.editText5);

        CounterListItem countitem;
        final ArrayList<CounterListItem> countitems =new ArrayList<CounterListItem>();

        String CounterName =EditText1.getText().toString();
        final List<String> itemList = new ArrayList<String>(Arrays.asList(CounterName));

        //edittext onclick listener for input validation\

       final ArrayAdapter<String> adapter = new ArrayAdapter<String> (MainActivity.this, android.R.layout.simple_list_item_1, itemList);

        CounterList.setAdapter(new CustomAdapter(this, countitems));
       CounterList.setAdapter(new CustomAdapter());**/

        edit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit3.getError() ==null){
                    Log.d("hi3",edit3.getText().toString());

                }
                edit3.setError("Enter a positive initial value");

            }
        });


        EnterButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            /**
                counterList.add(EditText1.getText().toString());

                CustomAdapter.notifyDataSetChanged();
            **/
            // TODO: fix the error where the app crashes when nothing is enter or a string is entered into the number values
            if(     edit3.getText().toString()==""){
                edit3.setError("Enter a positive initial value");

            }

            if(edit1.getText().toString().trim() == ""|| edit3.getText().toString().trim()==""||edit4.getText().toString().trim()=="" ){
                edit1.setError("Enter a name");
                edit3.setError("Enter a positive initial value");
                edit4.setError("Enter a positive current value");
                Log.d("hi",edit1.getText().toString());
            }
            //get the necessary information for the counter from the user
            String countName = edit1.getText().toString();
            //String countDate = edit2.getText().toString()
            Number initVal=Integer.parseInt(edit3.getText().toString());
            Number curVal = Integer.parseInt(edit4.getText().toString());
           String Comment1 = edit5.getText().toString();
            DateFormat counterDate = new SimpleDateFormat("yyyy-MM-dd");
            Calendar date = Calendar.getInstance();
            String today= counterDate.format(date.getTime());




            counterList.add(new CounterListItem(countName,today,initVal,curVal,Comment1));

            cAdpt.notifyDataSetChanged();


        }
        });
    }
    private void popList(){
        counterList.add(new CounterListItem("counter1","1990-08-22",1,2,"first"));
    }
}
