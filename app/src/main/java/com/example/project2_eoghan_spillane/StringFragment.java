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
    private RecyclerView RecyclerString;
    View viewString;

    public StringFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sName = getResources().getStringArray(R.array.InstrumentsStringNames);
        sCode = getResources().getStringArray(R.array.InstrumentStringCode);
        sPrice = getResources().getStringArray(R.array.InstrumentStringPrice);

        viewString = inflater.inflate(R.layout.fragment_string, container, false);
        RecyclerString = viewString.findViewById(R.id.fragmentRecyclerString);

        MyItemAdapter myItemAdapter = new MyItemAdapter(getContext(), sName, sCode, sPrice, sImages);
        RecyclerString.setAdapter(myItemAdapter);
        RecyclerString.setLayoutManager(new LinearLayoutManager(getContext()));

        return viewString;
    }
}