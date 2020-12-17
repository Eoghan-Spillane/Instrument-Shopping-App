package com.example.project2_eoghan_spillane;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PercussionFragment extends Fragment {

    //Percussion Instruments
    String pName[], pCode[], pPrice[];
    int pImages[] = {R.drawable.ptrianlge, R.drawable.pmaracas, R.drawable.pdrums, R.drawable.pbox, R.drawable.pbongo};

    private RecyclerView RecyclerPercussion;
    View viewPercussion;

    public PercussionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        pName = getResources().getStringArray(R.array.InstrumentPercussionNames);
        pCode = getResources().getStringArray(R.array.InstrumentPercussionCode);
        pPrice = getResources().getStringArray(R.array.InstrumentPercussionPrice);

        viewPercussion = inflater.inflate(R.layout.fragment_percussion, container, false);
        RecyclerPercussion = viewPercussion.findViewById(R.id.fragmentRecylerPercussion);

        MyItemAdapter myItemAdapter = new MyItemAdapter(getContext(), pName, pCode, pPrice, pImages);
        RecyclerPercussion.setAdapter(myItemAdapter);
        RecyclerPercussion.setLayoutManager(new LinearLayoutManager(getContext()));

        return viewPercussion;
    }
}