package com.nfc_assignment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editTextId;
    Button  btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        myDb = new DatabaseHelper(this);

        editTextId = (EditText)findViewById(R.id.editTextId);
        btnDelete= (Button)findViewById(R.id.buttonDeleteAccount);

        DeleteData();
    }
    public void DeleteData() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                if(deletedRows > 0)
                    Toast.makeText(Delete.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Delete.this,"Data not Deleted",Toast.LENGTH_LONG).show();
            }
        });
    }

}
