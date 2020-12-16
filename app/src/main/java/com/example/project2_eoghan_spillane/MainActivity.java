package com.example.project2_eoghan_spillane;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.loginPageButton);
        signup = findViewById(R.id.signupPageButton);

        login.setOnClickListener( v -> {
            Intent goLogin = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(goLogin);
        });

        signup.setOnClickListener( v -> {
            Intent goSignup = new Intent(getApplicationContext(), SignupActivity.class);
            startActivity(goSignup);
        });

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