package com.example.project2_eoghan_spillane;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {

    DatabaseHelper database;
    ArrayList<ArrayList<String>> Items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        database = new DatabaseHelper(this);

        Items = (ArrayList<ArrayList<String>>) database.getBasket();
        try {
            System.out.println(Items.get(2).get(0));
            System.out.println(Items.get(2).get(1));
        }catch (Exception e){
            System.out.println("No Items");
        }


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
                Intent goBasket = new Intent(getApplicationContext(), BasketActivity.class);
                startActivity(goBasket);
                return true;
            case R.id.optionBasketEmptyBasket:
                database.clearBasket();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}