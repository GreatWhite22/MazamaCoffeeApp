package com.mazamacoffee.www.mazamacoffee.activity;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.mazamacoffee.www.mazamacoffee.R;

import java.util.ArrayList;

public class ShoppingCartActivity extends ListActivity {
    EditText et;
    ArrayList<String> cartItems = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText);

        ArrayList<String> cartItems = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cartItems);
        setListAdapter(adapter);
    }
}

