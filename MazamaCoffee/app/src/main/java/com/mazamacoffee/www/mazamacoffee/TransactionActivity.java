package com.mazamacoffee.www.mazamacoffee;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.stripe.android.*;
import com.stripe.android.model.Card;

public class TransactionActivity extends AppCompatActivity {
    private EditText cardNumber;
    private EditText month;
    private EditText year;
    private EditText cvv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    private void transactionSubmit(View v) {
        cardNumber = (EditText) findViewById(R.id.cardNumber);
        month = (EditText) findViewById(R.id.month);
        year = (EditText) findViewById(R.id.year);
        cvv = (EditText) findViewById(R.id.cvv);

        Card card = new Card(cardNumber.getText().toString(),
                Integer.parseInt(month.getText().toString()),
                Integer.parseInt(year.getText().toString()),
                cvv.getText().toString());
        if(!card.validateCard()){
            //throw exception
        }
        Stripe stripe = new Stripe("pk_test_6pRNASCoBOKtIshFeQd4XMUh");
        stripe.createToken(
                card,
                new TokenCallback() {
                    public void onSuccess(Token token) {
                        // Send token to your server
                    }
                    public void onError(Exception error) {
                        // Show localized error message
                        Toast.makeText(getContext(),
                                error.getLocalizedString(getContext()),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        )
    }
}
