package com.nfc_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainPage extends AppCompatActivity {

    public void register(View v){
        Intent registration = new Intent(MainPage.this, Registration.class);
        startActivity(registration);
    }

    public void delete(View v){
        Intent delete = new Intent(MainPage.this, Delete.class);
        startActivity(delete);
    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }


}
