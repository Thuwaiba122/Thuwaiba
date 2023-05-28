package com.example.myapplication;


import static com.example.myapplication.R.id.text_view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText Username, password;
    Button insert, update, delete, view, button;
    DBHelper DB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(text_view);
        Username = findViewById(R.id.ed1);
        password = findViewById(R.id.ed2);
        insert = findViewById(R.id.insert_btn);
        update = findViewById(R.id.update_btn);
        delete = findViewById(R.id.delete_btn);
        view = findViewById(R.id.view_btn);
        button = findViewById(R.id.button);
        DB = new DBHelper(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "go to the next page", Toast.LENGTH_LONG).show();
                Intent th = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(th);

                insert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String un = Username.getText().toString();
                        String pass = password.getText().toString();


                        Boolean checkinsert_data = DB.insert_data(un, Integer.parseInt(pass));
                        if (checkinsert_data == true)
                            Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, " Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                });
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String un = Username.getText().toString();
                        String pass = password.getText().toString();

                        Boolean checkupdatedata = DB.Update_data(un, Integer.parseInt(pass));
                        if (checkupdatedata == true)
                            Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Not Updated", Toast.LENGTH_SHORT).show();
                    }
                });
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String un = Username.getText().toString();
                        Boolean checkupdelete_data = DB.delete_data(un);
                        if (checkupdelete_data == true)
                            Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Not Deleted", Toast.LENGTH_SHORT).show();
                    }
                });


                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = DB.View_data();
                        if (res.getCount() == 0) {
                            Toast.makeText(MainActivity.this, "Not Entry Exists", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Username :" + res.getString(0) + "\n");
                            buffer.append("password:" + res.getString(1) + "\n");

                        }

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setCancelable(true);
                        builder.setTitle("User Entries");
                        builder.setMessage(buffer.toString());
                        builder.show();
                    }
                });

            }

            {

            }

            ;
        });
    }}






















