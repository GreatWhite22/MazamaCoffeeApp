package com.mazamacoffee.www.mazamacoffee.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.devmarvel.creditcardentry.library.CreditCard;
import com.devmarvel.creditcardentry.library.CreditCardForm;
import com.mazamacoffee.www.mazamacoffee.R;
import com.mazamacoffee.www.mazamacoffee.activity.TransactionActivity;

public class TransactionFormFragment extends Fragment {
    Button submitButton;
    EditText number;
    private CreditCardForm form;
    private LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction_form, container, false);
        linearLayout = (LinearLayout) getView().findViewById(R.id.layer);
        form = new CreditCardForm(this.getActivity());
        linearLayout.addView(form);
        submitButton = (Button) getView().findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (form.isCreditCardValid()) {
                    CreditCard card = form.getCreditCard();
                    submitForm(card);
                } else {
                    //Alert card invalid
                }
            }
        });
       /* this.submitButton = (Button) view.findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm(view);
            }
        });*/

        number = (EditText) view.findViewById(R.id.phoneNumber);
        number.addTextChangedListener(new PhoneNumberFormattingTextWatcher() {
            private boolean numberAdded = true;
            private boolean deletion = false;
            private int cursor;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                cursor = s.length() - number.getSelectionStart();
                if (count > after) {
                    deletion = true;
                } else {
                    deletion = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String phoneNumber = s.toString();
                phoneNumber = phoneNumber.replaceAll("[^\\d]", "");
                if (numberAdded) {
                    if (phoneNumber.length() >= 6 && !deletion) {
                        numberAdded = false;
                        phoneNumber = "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
                        number.setText(phoneNumber);
                        number.setSelection(number.getText().length() - cursor);
                    } else if (phoneNumber.length() >= 3 && !deletion) {
                        numberAdded = false;
                        phoneNumber = "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3);
                        number.setText(phoneNumber);
                        number.setSelection(number.getText().length() - cursor);
                    }
                } else {
                    numberAdded = true;
                }
            }
        });
        return view;
    }

    public void submitForm(CreditCard card) {
        ((TransactionActivity) getActivity()).transactionSubmit(card);
    }
}

