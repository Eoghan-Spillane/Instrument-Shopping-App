package com.example.project2_eoghan_spillane;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyStringAdapter extends RecyclerView.Adapter<MyStringAdapter.MyStringViewHolder> {

    String Names[], Codes[], Prices[];
    int Images[];
    Context context;

    public MyStringAdapter(Context ct, String names[], String codes[], String prices[], int images[]){
        context = ct;
        Names = names;
        Codes = codes;
        Prices = prices;
        Images = images;
    }

    @NonNull
    @Override
    public MyStringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.my_row, parent, false);

        return new MyStringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyStringViewHolder holder, int position) {
        holder.name.setText(Names[position]);
        holder.code.setText(Codes[position]);
        holder.price.setText(Prices[position]);
        holder.image.setImageResource(Images[position]);
    }

    @Override
    public int getItemCount() {
        return Names.length;
    }

    public class MyStringViewHolder extends RecyclerView.ViewHolder{
        TextView name, code, price;
        ImageView image;

        public MyStringViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textInstumentName);
            code = itemView.findViewById(R.id.textInstrumentCode);
            price = itemView.findViewById(R.id.textInstrumentPrice);
            image = itemView.findViewById(R.id.textInstrumentImage);
        }
    }

}
