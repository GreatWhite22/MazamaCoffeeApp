package com.mazamacoffee.www.mazamacoffee.activity;


import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.mazamacoffee.www.mazamacoffee.R;
import com.mazamacoffee.www.mazamacoffee.TransactionForm;
import com.stripe.android.*;
import com.stripe.android.model.Card;
import com.stripe.android.Stripe.*;
import com.stripe.android.model.Token;
import com.stripe.exception.AuthenticationException;

public class TransactionActivity extends FragmentActivity {
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

    public void transactionSubmit(TransactionForm form) {

        Card card = new Card(
                form.getCardNumber(),
                form.getExpMonth(),
                form.getExpYear(),
                form.getCvv());
        if(!card.validateCard()){
            //throw exception
        }
        /*Stripe stripe = new Stripe("pk_test_irEAw0mlXyAIwo6XFQRlBpOi");
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
        );*/
    }
}
