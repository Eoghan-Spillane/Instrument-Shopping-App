package com.example.project2_eoghan_spillane;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class payment extends AppCompatActivity {

    TextView totalPrice;
    Button submit;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        submit = findViewById(R.id.paymentButton);
        totalPrice = findViewById(R.id.paymentTotalText);
        databaseHelper = new DatabaseHelper(this);
        Intent intent = getIntent();


        submit.setOnClickListener(v -> {
            Toast.makeText(this, "Congrats Your Item is on the Way", Toast.LENGTH_LONG).show();
            Intent goHomepage = new Intent(getApplicationContext(), HomepageActivity.class);
            startActivity(goHomepage);
        });

        totalPrice.setText(intent.getStringExtra("price"));
    }
}