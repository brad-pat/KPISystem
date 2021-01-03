package com.example.brad.mansfieldapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class StoreTracker extends AppCompatActivity {

    private String timescale;

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.store_tracker);
         String time = getIntent().getStringExtra("timescale");
         timescale = time;
        ImageView refresh = findViewById(R.id.refreshbutton);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = new MainActivity();
            }
        });
        assignMap();
        for(int i = 0; i < 12; i ++) {
            showItem(i, false);
        }
        List<KPI> kpis = Storage.getInstance().kpi_list;
        for(int i = 0; i < kpis.size(); i++) {
            KPI kpi = kpis.get(i);
            String name = kpi.getName();
            MySQLData sql = new MySQLData(this);
            try {
                String result = sql.execute("STOREPERFORMANCEKPI", "difference:"+name+":"+timescale+":STORE").get();
                String display = result.split("=")[1];
                showItem(i, true);
                setCardData(i, name, display);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private HashMap<Integer, CardView> cards = new HashMap<>();
    private HashMap<Integer, TextView> titles = new HashMap<>();
    private HashMap<Integer, TextView> dones = new HashMap<>();

    private void setCardData(int i, String title, String done) {
        titles.get(i).setText(title);
        dones.get(i).setText(done);
    }

    private void showItem(int i, boolean show) {
        if(show == false) {
            cards.get(i).setVisibility(View.INVISIBLE);
        }
        else {
            cards.get(i).setVisibility(View.VISIBLE);
        }
    }

    private void assignMap() {
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

        TextView bar0details = findViewById(R.id.bar0details);
        TextView bar1details = findViewById(R.id.bar1details);
        TextView bar2details = findViewById(R.id.bar2details);
        TextView bar3details = findViewById(R.id.bar3details);
        TextView bar4details = findViewById(R.id.bar4details);
        TextView bar5details = findViewById(R.id.bar5details);
        TextView bar6details = findViewById(R.id.bar6details);
        TextView bar7details = findViewById(R.id.bar7details);
        TextView bar8details = findViewById(R.id.bar8details);
        TextView bar9details = findViewById(R.id.bar9details);
        TextView bar10details = findViewById(R.id.bar10details);
        TextView bar11details = findViewById(R.id.bar11details);
        dones.put(0, bar0details);
        dones.put(1, bar1details);
        dones.put(2, bar2details);
        dones.put(3, bar3details);
        dones.put(4, bar4details);
        dones.put(5, bar5details);
        dones.put(6, bar6details);
        dones.put(7, bar7details);
        dones.put(8, bar8details);
        dones.put(9, bar9details);
        dones.put(10, bar10details);
        dones.put(11, bar11details);
    }

}
