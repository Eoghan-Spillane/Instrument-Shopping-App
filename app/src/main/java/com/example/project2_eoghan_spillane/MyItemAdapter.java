package com.example.project2_eoghan_spillane;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.MyStringViewHolder> {

    String Names[], Codes[], Prices[];
    int Images[];
    Context context;
    Button button;
    DatabaseHelper database;

    public MyItemAdapter(Context ct, String names[], String codes[], String prices[], int images[]){
        context = ct;
        Names = names;
        Codes = codes;
        Prices = prices;
        Images = images;
    }

    @NonNull
    @Override
    public MyStringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
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
        Button button;
        DatabaseHelper database = new DatabaseHelper(context);

        public MyStringViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textInstumentName);
            code = itemView.findViewById(R.id.textInstrumentCode);
            price = itemView.findViewById(R.id.textInstrumentPrice);
            image = itemView.findViewById(R.id.textInstrumentImage);
            button = itemView.findViewById(R.id.textInstrumentBuy);

            button.setOnClickListener(v -> {
                printTitle();
                boolean success = AddItem(name.getText().toString(), code.getText().toString(), price.getText().toString());

                if(success){
                    Toast.makeText(context, "Item Added", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context, "Error With Adding Item", Toast.LENGTH_LONG).show();
                }
            });
        }

        public void printTitle(){
            System.out.println(name.getText());
        }

        public boolean AddItem(String name, String code, String price){
            if(database.addItem(name, code, price)){
                return true;
            }else{
                return false;
            }
        }
    }

}
