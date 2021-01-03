package com.example.brad.mansfieldapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView sale_button = findViewById(R.id.process_sale);
        CardView personal_tracker = findViewById(R.id.personal_tracker);
        CardView store_tracker = findViewById(R.id.store_tracker);
        sale_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KPISelection.class);
                startActivity(intent);
            }
        });
        personal_tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), TimescaleSelection.class);
                intent.putExtra("type", "employee");
                startActivity(intent);
            }
        });
        store_tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), TimescaleSelection.class);
                intent.putExtra("type", "store");
                startActivity(intent);
            }
        });
        TextView welcome = findViewById(R.id.welcometxt);
        welcome.setText("Welcome, " + Storage.getInstance().uname);
        MySQLData sql = new MySQLData(this);
        sql.execute("FETCHKPIS", "");
        getEmployeeMonitorTimes();
        getStoreMonitorTimes();
    }

    public void setUpKPIs(String kpi_string) {
        String[] kpis = kpi_string.split("ZZZQQQ");
        for(String kpi : kpis) {
            Log.w("HELLO:", kpi);
            String[] kpi_details = kpi.trim().split("QPQPQ");
            String name = kpi_details[0];
            int value = Integer.parseInt(kpi_details[1]);
            String type = kpi_details[2];
            ArrayList<SubKPI> temp = new ArrayList<>();
            String[] subkpis = kpi_details[3].split("@@@");
            for(String subkpi : subkpis) {
                String[] subkpi_details = subkpi.split("ZQZ");
                String subkpiname = subkpi_details[0];
                String subkpitype = subkpi_details[1];
                String maths = subkpi_details[2];
                boolean show = Boolean.parseBoolean(subkpi_details[3]);
                SubKPI subKPI = new SubKPI(subkpiname, name, subkpitype, show, maths);
                temp.add(subKPI);
            }
            KPI new_kpi = new KPI(name, value, type, temp);
            Storage.getInstance().kpi_list.add(new_kpi);
        }
    }

    private void getEmployeeMonitorTimes() {
        List<String> store_times = Storage.getInstance().employee_times;
        if(store_times.isEmpty()) {
            MySQLData sql = new MySQLData(this);
            sql.execute("EMPLOYEETIMESCALES", "");
        }
    }

    private void getStoreMonitorTimes() {
        List<String> store_times = Storage.getInstance().store_times;
        if(store_times.isEmpty()) {
            MySQLData sql = new MySQLData(this);
            sql.execute("STORETIMESCALES", "");
        }
    }

    private void firstTimeDialog() {
        Intent intent = new Intent(getApplicationContext(), LoginScreen.class);
        startActivity(intent);
    }
}
