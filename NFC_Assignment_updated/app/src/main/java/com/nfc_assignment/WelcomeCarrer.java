package com.nfc_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeCarrer extends AppCompatActivity {

    public Button btnChooseCarer;

    public void showCarerPage(){
        btnChooseCarer = (Button)findViewById(R.id.btnChooseCarer);
        btnChooseCarer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signIn = new Intent(WelcomeCarrer.this, CarrerName.class);
                startActivity(signIn);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_carrer);
        showCarerPage();

    }
}
