package com.example.project2_eoghan_spillane;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class basketAdapter extends RecyclerView.Adapter<basketAdapter.MyViewHolder> {

    ArrayList<Integer> prices;
    ArrayList<String> names;
    Context context;
    DatabaseHelper database;

    public basketAdapter(Context ct, ArrayList<String> Names, ArrayList<Integer> Prices){
        prices = Prices;
        names = Names;
        context = ct;
    }

    @NonNull
    @Override
    public basketAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.basket_row, parent, false);

        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull basketAdapter.MyViewHolder holder, int position) {
        holder.name.setText(names.get(position));
        holder.price.setText(prices.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return prices.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, price;
        Button delete;
        DatabaseHelper databaseHelper = new DatabaseHelper(context);

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.basketItemName);
            price = itemView.findViewById(R.id.basketItemPrice);
            delete = itemView.findViewById(R.id.basketItemDelete);

            delete.setOnClickListener(v -> {
                databaseHelper.deleteItem(name.getText().toString());
                BasketActivity.getInstance().refreshList();
                Toast.makeText(context, "Item Deleted", Toast.LENGTH_LONG).show();
            });
        }

    }
}
