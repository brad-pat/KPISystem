package com.example.brad.mansfieldapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.List;

public class TimescaleSelection extends AppCompatActivity {

    private HashMap<String, CardView> cards = new HashMap<>();

    private void setupemployeescreen() {
        List<String> timestoshow = Storage.getInstance().employee_times;
        for(String s : timestoshow) {
            cards.get(s).setVisibility(View.VISIBLE);
        }
    }

    private void setupstorescreen() {
        List<String> timestoshow = Storage.getInstance().store_times;
        for(String s : timestoshow) {
            cards.get(s).setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.timescale_selection);
        final String type = getIntent().getStringExtra("type");
        CardView daily = findViewById(R.id.daily_button);
        CardView weekly = findViewById(R.id.weekly_button);
        CardView monthly = findViewById(R.id.monthly_button);
        CardView quarterly = findViewById(R.id.quarter_button);
        CardView halfly = findViewById(R.id.halfly_button);
        CardView yearly = findViewById(R.id.yearly_button);
        cards.put("daily", daily);
        cards.put("weekly", weekly);
        cards.put("monthly", monthly);
        cards.put("quarterly", quarterly);
        cards.put("halfly", halfly);
        cards.put("yearly", yearly);
        daily.setVisibility(View.INVISIBLE);
        weekly.setVisibility(View.INVISIBLE);
        monthly.setVisibility(View.INVISIBLE);
        quarterly.setVisibility(View.INVISIBLE);
        halfly.setVisibility(View.INVISIBLE);
        yearly.setVisibility(View.INVISIBLE);
            if(type.equalsIgnoreCase("employee")) {
                setupemployeescreen();
            } else {
                setupstorescreen();
            }
        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equalsIgnoreCase("employee")) {
                    Intent intent = new Intent(getApplicationContext(), PersonalTracker.class);
                    intent.putExtra("timescale", "daily");
                    startActivity(intent);
                } else {
                    StoreTracker tracker = new StoreTracker();
                    Intent intent = new Intent(getApplicationContext(), StoreTracker.class);
                    intent.putExtra("timescale", "daily");
                    startActivity(intent);
                }
            }
        });
        weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equalsIgnoreCase("employee")) {
                    Intent intent = new Intent(getApplicationContext(), PersonalTracker.class);
                    intent.putExtra("timescale", "weekly");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), StoreTracker.class);
                    intent.putExtra("timescale", "weekly");
                    startActivity(intent);
                }
            }
        });
        monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equalsIgnoreCase("employee")) {
                    Intent intent = new Intent(getApplicationContext(), PersonalTracker.class);
                    intent.putExtra("timescale", "monthly");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), StoreTracker.class);
                    intent.putExtra("timescale", "monthly");
                    startActivity(intent);
                }
            }
        });
        quarterly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equalsIgnoreCase("employee")) {
                    Intent intent = new Intent(getApplicationContext(), PersonalTracker.class);
                    intent.putExtra("timescale", "quarterly");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), StoreTracker.class);
                    intent.putExtra("timescale", "quarterly");
                    startActivity(intent);
                }
            }
        });
        halfly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equalsIgnoreCase("employee")) {
                    Intent intent = new Intent(getApplicationContext(), PersonalTracker.class);
                    intent.putExtra("timescale", "halfly");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), StoreTracker.class);
                    intent.putExtra("timescale", "halfly");
                    startActivity(intent);
                }
            }
        });
        yearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equalsIgnoreCase("employee")) {
                    Intent intent = new Intent(getApplicationContext(), PersonalTracker.class);
                    intent.putExtra("timescale", "yearly");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), StoreTracker.class);
                    intent.putExtra("timescale", "yearly");
                    startActivity(intent);
                }
            }
        });
    }
}
