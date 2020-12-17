package com.example.project2_eoghan_spillane;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WindFragment extends Fragment {

    // Wind Instruments
    String wName[], wCode[], wPrice[];
    int wImages[] = {R.drawable.wsaxophone, R.drawable.wpanflute, R.drawable.wharmonica, R.drawable.wflute, R.drawable.waccordion};

    private RecyclerView RecyclerWind;
    View viewWind;

    public WindFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        wName = getResources().getStringArray(R.array.InstrumentWindName);
        wCode = getResources().getStringArray(R.array.InstrumentWindCode);
        wPrice = getResources().getStringArray(R.array.InstrumentWindPrice);

        viewWind =  inflater.inflate(R.layout.fragment_wind, container, false);
        RecyclerWind = viewWind.findViewById(R.id.fragmentRecylerWind);

        MyItemAdapter myItemAdapter = new MyItemAdapter(getContext(), wName, wCode, wPrice, wImages);
        RecyclerWind.setAdapter(myItemAdapter);
        RecyclerWind.setLayoutManager(new LinearLayoutManager(getContext()));

        return viewWind;
    }
}