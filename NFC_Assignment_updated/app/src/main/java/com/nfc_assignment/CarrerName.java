package com.nfc_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CarrerName extends AppCompatActivity {

    public Button btnTim, btnTam;

    public void showCarerPage1(){
        btnTim = (Button)findViewById(R.id.btnTim);
        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signIn = new Intent(CarrerName.this, Logout.class);
                startActivity(signIn);
            }
        });
    }

    public void showCarerPage2(){
        btnTam = (Button)findViewById(R.id.btnTam);
        btnTam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signIn = new Intent(CarrerName.this, Logout.class);
                startActivity(signIn);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrer_name);
        showCarerPage1();
        showCarerPage2();

        //TextView enterValue = (TextView)findViewById(R.id.text);
        //enterValue.setText(WelcomeCarer.)
    }
}
