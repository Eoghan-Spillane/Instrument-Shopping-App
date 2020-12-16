package com.example.project2_eoghan_spillane;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BasketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.optionLoginSignup:
                Intent goLoginSignup = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goLoginSignup);
                return true;
            case R.id.optionHomepage:
                Intent goHomepage = new Intent(getApplicationContext(), HomepageActivity.class);
                startActivity(goHomepage);
                return true;
            case R.id.optionBasket:
                Intent goBasket = new Intent(getApplicationContext(), BasketActivity.class);
                startActivity(goBasket);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}