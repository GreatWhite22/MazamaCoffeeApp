package com.mazamacoffee.www.mazamacoffee.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mazamacoffee.www.mazamacoffee.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void drinkClicked(View v){
        Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
        startActivity(intent);
    }

    public void foodClicked (View v) {

    }

    public void contactClicked (View v){

    }
}
