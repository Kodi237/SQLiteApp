package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editKey;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.nameText);
        editKey = (EditText)findViewById(R.id.keyText);
        btnAddData = (Button)findViewById(R.id.saveBT);

        AddData();
    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       boolean isInserted = myDb.insertData(editName.getText().toString(), editKey.getText().toString());

                       if (isInserted = true)
                           Toast.makeText(MainActivity.this, "Dodano do bazy", Toast.LENGTH_LONG).show();
                       else
                           Toast.makeText(MainActivity.this, "Nie dodano do bazy", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
