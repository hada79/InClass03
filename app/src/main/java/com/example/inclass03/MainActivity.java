package com.example.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

    public class MainActivity extends AppCompatActivity {

        static String USER_KEY = "USER";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(MainActivity.this, DisplayActivity.class);

                    EditText name = findViewById(R.id.name);
                    EditText email = findViewById(R.id.email);
                    EditText address = findViewById(R.id.address);
                    EditText phone = findViewById(R.id.phone);
                    EditText mood = findViewById(R.id.mood);

                    if(name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || address.getText().toString().isEmpty()
                            || phone.getText().toString().isEmpty() || mood.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please fill out all fields.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    User user = new User(name.getText().toString(), email.getText().toString(), phone.getText().toString(), address.getText().toString(), mood.getText().toString());
                    i.putExtra(USER_KEY, user);

                    startActivity(i);
                }
            });

        }


    }
