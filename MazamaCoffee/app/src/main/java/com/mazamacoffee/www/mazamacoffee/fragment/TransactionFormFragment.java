package com.mazamacoffee.www.mazamacoffee.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.mazamacoffee.www.mazamacoffee.R;
import com.mazamacoffee.www.mazamacoffee.TransactionForm;
import com.mazamacoffee.www.mazamacoffee.activity.TransactionActivity;

public class TransactionFormFragment extends Fragment implements TransactionForm {
    Button submitButton;
    EditText cardNumber;
    EditText cvv;
    Spinner expMonthSpinner;
    Spinner expYearSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction_form, container, false);

        this.submitButton = (Button) view.findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm(view);
            }
        });

        this.cardNumber = (EditText) view.findViewById(R.id.cardNumber);
        this.cvv = (EditText) view.findViewById(R.id.cvv);
        this.expMonthSpinner = (Spinner) view.findViewById(R.id.expMonth);
        this.expYearSpinner = (Spinner) view.findViewById(R.id.expYear);

        return view;
    }

    @Override
    public String getCardNumber() {
        return this.cardNumber.getText().toString();
    }

    @Override
    public String getCvv() {
        return this.cvv.getText().toString();
    }

    @Override
    public Integer getExpMonth() {
        return getInteger(this.expMonthSpinner);
    }

    @Override
    public Integer getExpYear() {
        return getInteger(this.expYearSpinner);
    }

    public void submitForm(View button) {
        ((TransactionActivity)getActivity()).transactionSubmit(this);
    }

    private Integer getInteger(Spinner spinner) {
        try {
            return Integer.parseInt(spinner.getSelectedItem().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

