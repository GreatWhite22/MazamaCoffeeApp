package com.mazamacoffee.www.mazamacoffee.activity;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import com.devmarvel.creditcardentry.library.CreditCard;
import com.devmarvel.creditcardentry.library.CreditCardForm;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.mazamacoffee.www.mazamacoffee.R;
import com.mazamacoffee.www.mazamacoffee.TokenList;
import com.mazamacoffee.www.mazamacoffee.dialog.ErrorDialogFragment;

public class TransactionActivity extends FragmentActivity {

    public static final String PUBLISHABLE_KEY = "pk_test_irEAw0mlXyAIwo6XFQRlBpOi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        CreditCardForm form = new CreditCardForm(this);
    }

    public void transactionSubmit(CreditCard checkCard) {
        Card card = new Card(checkCard.getCardNumber(),
                checkCard.getExpMonth(),
                checkCard.getExpYear(),
                checkCard.getSecurityCode());
        Boolean validate = card.validateCard();
        if (validate) {
            new Stripe().createToken(
                    card,
                    PUBLISHABLE_KEY,
                    new TokenCallback() {
                        public void onSuccess(Token token) {
                            getTokenList().addToList(token);
                        }
                        public void onError(Exception error) {
                            handleError(error.getLocalizedMessage());
                        }
                    });

        } else if (!card.validateNumber()) {
            handleError("The card number that you entered is invalid");
        } else if (!card.validateExpiryDate()) {
            handleError("The expiration date that you entered is invalid");
        } else if (!card.validateCVC()) {
            handleError("The CVC code that you entered is invalid");
        } else {
            handleError("The card details that you entered are invalid");
        }
    }

    private void handleError(String error) {
        DialogFragment fragment = ErrorDialogFragment.newInstance(R.string.validationErrors, error);
        fragment.show(getSupportFragmentManager(), "error");
    }

    private TokenList getTokenList() {
        return (TokenList)(getSupportFragmentManager().findFragmentById(R.id.token_list));
    }
}