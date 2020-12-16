package com.example.project2_eoghan_spillane;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    DatabaseHelper database;

    Button buttonSignUp;
    TextView textUsername, textPassword, textAddress;
    EditText inputUsername, inputPassword, inputAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        database = new DatabaseHelper(this);

        buttonSignUp = findViewById(R.id.buttonSignUpS);
        inputUsername = findViewById(R.id.inputUsernameS);
        inputPassword = findViewById(R.id.inputPasswordS);
        inputAddress = findViewById(R.id.inputAddressS);

        buttonSignUp.setOnClickListener(v -> {
            addNewUser();
        });
    }

    public void addNewUser(){
        boolean success = database.newUser(inputUsername.getText().toString(), inputPassword.getText().toString(), inputAddress.getText().toString());

        if(success){
            Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_LONG).show();
            Intent goHomepage = new Intent(getApplicationContext(), HomepageActivity.class);
            startActivity(goHomepage);
        }else{
            Toast.makeText(getApplicationContext(), "Error with Account Creation, Please Try Again", Toast.LENGTH_LONG).show();
        }
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