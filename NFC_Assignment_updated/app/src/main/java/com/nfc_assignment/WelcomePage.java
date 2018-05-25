package com.nfc_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomePage extends AppCompatActivity {

    public Button btnSignIn;
    public Button btnRegister;

    public void showSignInPage(){
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signIn = new Intent(WelcomePage.this, SignIn.class);
                startActivity(signIn);
            }
        });
    }

    public void showRegistrationPage(){
        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent register = new Intent(WelcomePage.this, Registration.class);
                startActivity(register);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        showSignInPage();
        showRegistrationPage();
    }
}
