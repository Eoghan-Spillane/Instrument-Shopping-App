package com.example.project2_eoghan_spillane;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {

    //This is here so that the basketAdapter is able to call the refreshList() function
    //This means that the items disappear as they are deleted.
    @SuppressLint("StaticFieldLeak")
    private static BasketActivity instance;


    DatabaseHelper database;
    ArrayList<ArrayList<String>> Items;
    Button checkout;
    TextView totalPriceText;
    RecyclerView list;
    Integer totalPriceForPayment = 0;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        totalPriceText = findViewById(R.id.basketTextTotal);
        database = new DatabaseHelper(this);
        list = findViewById(R.id.basketRecycler);
        checkout = findViewById(R.id.basketButtonCheckout);

        checkout.setOnClickListener(v -> {
            Intent goPayment = new Intent(getApplicationContext(), payment.class);
            goPayment.putExtra("price", getTotalPriceForPayment().toString());
            startActivity(goPayment);
        });

        refreshList();
        instance = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.basket_menu, menu);

        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.optionBasketLoginSignup:
                Intent goLoginSignup = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goLoginSignup);
                return true;
            case R.id.optionBasketHomepage:
                Intent goHomepage = new Intent(getApplicationContext(), HomepageActivity.class);
                startActivity(goHomepage);
                return true;
            case R.id.optionBasketBasket:
                refreshList();
                return true;
            case R.id.optionBasketEmptyBasket:
                database.clearBasket();
                refreshList();
                Toast.makeText(this, "Emptied Basket", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public Integer getTotalPrice(ArrayList<Integer> prices){
        Integer totalPrice = 0;
        for(Integer d : prices){
            totalPrice += d;
        }

        return totalPrice;
    }

    public void refreshList(){
        ArrayList<String> names = new ArrayList<String>(); //Stores the Item Names
        ArrayList<Integer> prices = new ArrayList<Integer>(); //Stores the Item Prices
        Items = (ArrayList<ArrayList<String>>) database.getBasket();
        try {
            for(int counter = 0; counter < Items.size(); counter++){
                names.add(Items.get(counter).get(0));
                prices.add(Integer.parseInt(Items.get(counter).get(1)));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        //totalPriceText.setText(getTotalPrice(prices));
        totalPriceForPayment = getTotalPrice(prices);
        String totalprice = getTotalPrice(prices).toString();
        totalPriceText.setText(totalprice);



        basketAdapter basketAdapter = new basketAdapter(this, names, prices);
        list.setAdapter(basketAdapter);
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    public static BasketActivity getInstance(){
        return instance;
    }

    public Integer getTotalPriceForPayment(){
        return totalPriceForPayment;
    }

}