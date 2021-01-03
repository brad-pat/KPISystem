package com.example.brad.mansfieldapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProcessSale extends AppCompatActivity {

   private String kpi;
   private String subkpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_sale);
        String kpii = getIntent().getStringExtra("kpi");
        kpi = kpii;
        String subkpii = getIntent().getStringExtra("subkpi");
        subkpi = subkpii;
        CardView submit = findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitSale();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        TextView title = findViewById(R.id.process_sale_text);
        TextView subkpitxt = findViewById(R.id.subkpiname);
        title.setText("Process " + kpi + " Sale:");
        subkpitxt.setText(subkpi);
    }

    private void submitSale() {
        EditText sale_data = findViewById(R.id.sale_data);
        double to_submit = Double.parseDouble(sale_data.getText().toString());
        MySQLData sql = new MySQLData(this);
        sql.execute("PROCESSSALE", kpi + ":" + subkpi + ":" + to_submit + ":" + Storage.getInstance().uid);
    }

}
