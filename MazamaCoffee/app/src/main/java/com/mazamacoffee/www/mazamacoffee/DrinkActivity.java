package com.mazamacoffee.www.mazamacoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DrinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
    }

    public void Options (View v){
        Intent intent = new Intent(DrinkActivity.this,TransactionActivity.class);
        startActivity(intent);
    }
}
