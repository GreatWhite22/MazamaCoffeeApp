package com.mazamacoffee.www.mazamacoffee.fragment;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mazamacoffee.www.mazamacoffee.R;

/**
 * Created by akshar on 5/31/16.
 */
public class DrinkListFragment extends ListFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_drink_list, container, false);
        //Create an array of string to be data source of the ListFragment
        String[] drinkTypes = {"Coffee", "Soda", "Latte" };
        //Create ArrayAdapter object to wrap the data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.fragment_drink,R.id.textdrink, drinkTypes);
        //Bind adapter to the ListFragment
        setListAdapter(adapter);
        //Retain the ListFragment instance across Activity re-creation
        setRetainInstance(true);
        return rootView;
    }

    //Handle Item click event
    @Override
    public void onListItemClick(ListView l, View view, int position, long id){
        ViewGroup viewg = (ViewGroup)view;
        TextView tv = (TextView)viewg.findViewById(R.id.textdrink);
        Toast.makeText(getActivity(),tv.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
