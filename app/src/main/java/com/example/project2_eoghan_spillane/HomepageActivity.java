package com.example.project2_eoghan_spillane;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomepageActivity extends AppCompatActivity {

//    //String Instrument
//    String sName[], sCode[], sPrice[];
//    int sImages[] = {R.drawable.sviolin, R.drawable.spiano, R.drawable.shurdygurdy, R.drawable.sguitar, R.drawable.scello};
//    RecyclerView RecyclerString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Fragment stringFragment = new StringFragment(findViewById(R.id.fragmentRecyclerString));



        // Tabs Layout and Fragments
        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem tabString = findViewById(R.id.InstrumentsString);
        TabItem tabPercussion = findViewById(R.id.InstrumentsPercussion);
        TabItem tabWind = findViewById(R.id.InstrumentsWind);
        ViewPager viewPager = findViewById(R.id.viewPager);

        //This allows the page to be swiped left and right to change the tab
        @SuppressLint("CutPasteId") PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), findViewById(R.id.fragmentRecyclerString));

        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        // String Fragment
//        RecyclerString = findViewById(R.id.fragmentRecyclerString);
//        sName = getResources().getStringArray(R.array.InstrumentsStringNames);
//        sCode = getResources().getStringArray(R.array.InstrumentStringCode);
//        sPrice = getResources().getStringArray(R.array.InstrumentStringPrice);
//        MyStringAdapter myStringAdapter = new MyStringAdapter(this, sName, sCode, sPrice, sImages);
//        RecyclerString.setAdapter(myStringAdapter);
//        RecyclerString.setLayoutManager(new LinearLayoutManager(this));
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