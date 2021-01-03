package com.example.brad.mansfieldapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        CardView login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valid = assignData();
                if(valid == true) {

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    //Some Error message goes here
                }
            }
        });
    }

    private boolean assignData() {
        EditText company_name = findViewById(R.id.company_name);
        EditText user_id = findViewById(R.id.email_box);
        EditText pi = findViewById(R.id.pi_address);
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        Storage.getInstance().pi_ip = pi.getText().toString();
        MySQLData sql = new MySQLData(this);
        try {
            String login = sql.execute("LOGINCHECK", user_id.getText().toString() + ":" + company_name.getText().toString()).get();
            String status = login.split("=")[1].split(":")[0];
            if(status.equalsIgnoreCase("VALID")) {
                Storage.getInstance().uname = login.split("=")[1].split(":")[1];
                Storage.getInstance().uid = user_id.getText().toString();
                return true;
            }
            else {
                return false;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
