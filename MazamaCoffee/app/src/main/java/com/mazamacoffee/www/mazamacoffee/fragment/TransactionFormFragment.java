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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TransactionFormFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TransactionFormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransactionFormFragment extends Fragment implements TransactionForm {
    Button submitButton;
    EditText cardNumber;
    EditText cvv;
    Spinner expMonthSpinner;
    Spinner expYearSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.transaction_form_fragment, container, false);

        this.submitButton = (Button) view.findViewById(R.id.submit);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveForm(view);
            }
        });

        this.cardNumber = (EditText) view.findViewById(R.id.number);
        this.cvv = (EditText) view.findViewById(R.id.cvc);
        this.monthSpinner = (Spinner) view.findViewById(R.id.expMonth);
        this.yearSpinner = (Spinner) view.findViewById(R.id.expYear);
        this.currencySpinner = (Spinner) view.findViewById(R.id.currency);

        return view;
    }

    @Override
    public String getCardNumber() {
        return this.cardNumber.getText().toString();
    }

    @Override
    public String getCvc() {
        return this.cvc.getText().toString();
    }

    @Override
    public Integer getExpMonth() {
        return getInteger(this.monthSpinner);
    }

    @Override
    public Integer getExpYear() {
        return getInteger(this.yearSpinner);
    }

    @Override
    public String getCurrency() {
        if (currencySpinner.getSelectedItemPosition() == 0) return null;
        String selected = (String) currencySpinner.getSelectedItem();
        if (selected.equals(CURRENCY_UNSPECIFIED))
            return null;
        else
            return selected.toLowerCase();
    }

    public void saveForm(View button) {
        ((PaymentActivity)getActivity()).saveCreditCard(this);
    }
