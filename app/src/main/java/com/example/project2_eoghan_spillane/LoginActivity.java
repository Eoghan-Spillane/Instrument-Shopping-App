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

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper database;

    Button signIn;
    TextView textUsername, textPassword;
    EditText inputUsername, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = new DatabaseHelper(this);

        signIn = findViewById(R.id.buttonLogin);

        inputPassword = findViewById(R.id.inputPasswordL);
        inputUsername = findViewById(R.id.inputUsernameL);

        signIn.setOnClickListener(v -> {
            checkPassword();
        });
    }

    public void checkPassword(){
        if(database.checkPassword(inputUsername.getText().toString(), inputPassword.getText().toString())){
            Toast.makeText(getApplicationContext(), "Successful Login", Toast.LENGTH_LONG).show();
            Intent goHomepage = new Intent(getApplicationContext(), HomepageActivity.class);
            startActivity(goHomepage);
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Password/Username", Toast.LENGTH_LONG).show();
            inputPassword.setText("");
            inputUsername.setText("");
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