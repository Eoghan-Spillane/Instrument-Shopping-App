package com.example.project2_eoghan_spillane;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class StringFragment extends Fragment {
    //String Instrument
    String sName[], sCode[], sPrice[];
    int sImages[] = {R.drawable.sviolin, R.drawable.spiano, R.drawable.shurdygurdy, R.drawable.sguitar, R.drawable.scello};
    RecyclerView RecyclerString;

    private View listItemsView;

    public StringFragment(RecyclerView f) {
        RecyclerString = f;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listItemsView = inflater.inflate(R.layout.fragment_string, container, false);

        // String Fragment
        sName = getResources().getStringArray(R.array.InstrumentsStringNames);
        sCode = getResources().getStringArray(R.array.InstrumentStringCode);
        sPrice = getResources().getStringArray(R.array.InstrumentStringPrice);


        MyStringAdapter myStringAdapter = new MyStringAdapter(getContext(), sName, sCode, sPrice, sImages);
        RecyclerString.setAdapter(myStringAdapter);
        RecyclerString.setLayoutManager(new LinearLayoutManager(getContext()));


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}