package com.nfc_assignment;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    String userName, password, storedPassword;
    public Button btnSignIn;
    public EditText editUserName, editPassword;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        myDb = new DatabaseHelper(this);
        myDb = myDb.open();

        btnSignIn = (Button)findViewById(R.id.buttonSignIn);


        //showWelcomeCarerPage();
    }

    public void signIn(View V)
    {


// get the Refferences of views
        final EditText editTextUserName=(EditText)findViewById(R.id.editTextUserName);
        final EditText editTextPassword=(EditText)findViewById(R.id.editTextPassword);

        Button btnSignIn=(Button)findViewById(R.id.buttonSignIn);

// Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
// get The User name and Password
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

// fetch the Password form database for respective user name
                String storedPassword=myDb.getSingleEntry(userName);

// check if the Stored password matches with Password entered by user
                if(password.equals(storedPassword))
                {
                    Intent registration = new Intent(SignIn.this, MainPage.class);
                    startActivity(registration);
                }
                else
                {
                    Toast.makeText(SignIn.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

    }



    /*public void showWelcomeCarerPage(){
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSignIn = (Button)findViewById(R.id.buttonSignIn);
                editTextUserName=(EditText)findViewById(R.id.editTextUserName);
                editTextPassword=(EditText)findViewById(R.id.editTextPassword);

                userName=editTextUserName.getText().toString();
                password=editTextPassword.getText().toString();
                storedPassword = myDb.getSingleEntry(userName);


                if(password.equals(storedPassword))
                {
                    //Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    //dialog.dismiss();
                    Intent signIn = new Intent(SignIn.this, WelcomeCarrer.class);
                    startActivity(signIn);

                }
                else
                {
                    Toast.makeText(SignIn.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }*/




}

