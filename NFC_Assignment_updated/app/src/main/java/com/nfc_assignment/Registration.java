package com.nfc_assignment;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Registration extends ActionBarActivity {
    DatabaseHelper myDb;
    EditText editName,editSurname,editMarks ,editTextId, editCarer, editPassword, editConfirmPassword;
    Button btnAddData, btnviewAll, btnDelete;
    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editTextName);
        editSurname = (EditText)findViewById(R.id.editTextSurname);
        editMarks = (EditText)findViewById(R.id.editTextAge);
        editTextId = (EditText)findViewById(R.id.editTextId);
        editCarer = (EditText)findViewById(R.id.editTextCarer);
        editPassword = (EditText)findViewById(R.id.editPassword);
        editConfirmPassword = (EditText)findViewById(R.id.editConfirmPassword);

        btnAddData = (Button)findViewById(R.id.buttonCreateAccount);
        btnviewAll = (Button)findViewById(R.id.buttonViewAccount);
        //btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnDelete= (Button)findViewById(R.id.buttonDeleteAccount);
        AddData();
        //viewAll();
        //DeleteData();
    }
    public void DeleteData() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                if(deletedRows > 0)
                    Toast.makeText(Registration.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Registration.this,"Data not Deleted",Toast.LENGTH_LONG).show();
            }
        });
    }

    public  void AddData() {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editName.getText().toString();
                String password = editPassword.getText().toString();
                String confirmPassword = editConfirmPassword.getText().toString();



                // check if any of the fields are vaccant
                if (userName.equals("") || password.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Field Vacant", Toast.LENGTH_LONG).show();
                    return;
                }
// check if both password matches
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                } else {
// Save the Data in Database
                    boolean isInserted = myDb.insertData(editName.getText().toString(),
                            editSurname.getText().toString(),
                            editMarks.getText().toString(), editCarer.getText().toString(), editPassword.getText().toString());
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                }


                /*if(isInserted == true)
                    Toast.makeText(Registration.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Registration.this,"Data not Inserted",Toast.LENGTH_LONG).show();*/
            }
        });
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("Name :"+ res.getString(1)+"\n");
                    buffer.append("Surname :"+ res.getString(2)+"\n");
                    buffer.append("Age :"+ res.getString(3)+"\n");
                    buffer.append("Carer :"+ res.getString(4)+"\n\n");
                }

                // Show all data
                showMessage("Data",buffer.toString());
            }
        });
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

        public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editName.getText().toString(),
                                editSurname.getText().toString(),editMarks.getText().toString(), editCarer.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(Registration.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Registration.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }*/
}

