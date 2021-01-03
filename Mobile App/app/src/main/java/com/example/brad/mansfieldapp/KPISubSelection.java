package com.example.brad.mansfieldapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KPISubSelection extends AppCompatActivity {

    private String kpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kpi_selection);
        String test = getIntent().getStringExtra("kpi");
        kpi = test;
        setupHashMaps();
        for(int i = 0; i < 12; i++) {
            showItem(i, false);
        }
        setup();
    }

    private void setup() {
        KPI kp = Storage.getInstance().getKPIByName(kpi);
        ArrayList<SubKPI> kpis = kp.getSubkpis();
        for(int i = 0; i < kpis.size(); i++) {
            SubKPI subkpi = kpis.get(i);
            String name = subkpi.getName();
            showItem(i, true);
            setCardData(i, name);
            CardView card = cards.get(i);
            final String subkpitext = titles.get(i).getText().toString();
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), ProcessSale.class);
                    intent.putExtra("kpi", kpi);
                    intent.putExtra("subkpi", subkpitext);
                    startActivity(intent);
                }
            });
        }
    }

    private HashMap<Integer, CardView> cards = new HashMap<>();
    private HashMap<Integer, TextView> titles = new HashMap<>();

    private void setCardData(int i, String title) {
        titles.get(i).setText(title);
    }

    private void showItem(int i, boolean show) {
        if(show == false) {
            cards.get(i).setVisibility(View.INVISIBLE);
        }
        else {
            cards.get(i).setVisibility(View.VISIBLE);
        }
    }

    private void setupHashMaps() {
        CardView bar0 = findViewById(R.id.bar0);
        CardView bar1 = findViewById(R.id.bar1);
        CardView bar2 = findViewById(R.id.bar2);
        CardView bar3 = findViewById(R.id.bar3);
        CardView bar4 = findViewById(R.id.bar4);
        CardView bar5 = findViewById(R.id.bar5);
        CardView bar6 = findViewById(R.id.bar6);
        CardView bar7 = findViewById(R.id.bar7);
        CardView bar8 = findViewById(R.id.bar8);
        CardView bar9 = findViewById(R.id.bar9);
        CardView bar10 = findViewById(R.id.bar10);
        CardView bar11 = findViewById(R.id.bar11);
        cards.put(0, bar0);
        cards.put(1, bar1);
        cards.put(2, bar2);
        cards.put(3, bar3);
        cards.put(4, bar4);
        cards.put(5, bar5);
        cards.put(6, bar6);
        cards.put(7, bar7);
        cards.put(8, bar8);
        cards.put(9, bar9);
        cards.put(10, bar10);
        cards.put(11, bar11);
        //cards.put(0, bar0);

        TextView bar0title = findViewById(R.id.bar0title);
        TextView bar1title = findViewById(R.id.bar1title);
        TextView bar2title = findViewById(R.id.bar2title);
        TextView bar3title = findViewById(R.id.bar3title);
        TextView bar4title = findViewById(R.id.bar4title);
        TextView bar5title = findViewById(R.id.bar5title);
        TextView bar6title = findViewById(R.id.bar6title);
        TextView bar7title = findViewById(R.id.bar7title);
        TextView bar8title = findViewById(R.id.bar8title);
        TextView bar9title = findViewById(R.id.bar9title);
        TextView bar10title = findViewById(R.id.bar10title);
        TextView bar11title = findViewById(R.id.bar11title);
        titles.put(0, bar0title);
        titles.put(1, bar1title);
        titles.put(2, bar2title);
        titles.put(3, bar3title);
        titles.put(4, bar4title);
        titles.put(5, bar5title);
        titles.put(6, bar6title);
        titles.put(7, bar7title);
        titles.put(8, bar8title);
        titles.put(9, bar9title);
        titles.put(10, bar10title);
        titles.put(11, bar11title);
    }

}
