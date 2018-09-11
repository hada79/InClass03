package com.jasonhada.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    public static final int REQ_CODE_NAME = 100;
    public static final int REQ_CODE_PHONE = 101;
    public static final int REQ_CODE_EMAIL = 102;
    public static final int REQ_CODE_ADDRESS = 103;
    public static final int REQ_CODE_MOOD = 104;

    public static final String VALUE_KEY = "value";
    public static final String TYPE_KEY = "type";

    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        if(getIntent() != null && getIntent().getExtras() != null) {
            user = (User) getIntent().getExtras().getSerializable(MainActivity.USER_KEY);

            TextView nameTv = findViewById(R.id.displayName);
            nameTv.setText(user.name);

            TextView emailTv = findViewById(R.id.displayEmail);
            emailTv.setText(user.email);

            TextView phoneTv = findViewById(R.id.displayPhone);
            phoneTv.setText(user.phone);

            TextView addressTv = findViewById(R.id.displayAddress);
            addressTv.setText(user.address);

            TextView moodTv = findViewById(R.id.displayMood);
            moodTv.setText(user.mood);
        }

        findViewById(R.id.editName).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.jasonhada.inclass03.action.VIEW");
                i.addCategory(Intent.CATEGORY_DEFAULT);
                i.putExtra(VALUE_KEY, user.name);
                i.putExtra(TYPE_KEY, "Edit Name");
                startActivityForResult(i, REQ_CODE_NAME);
            }
        });

        findViewById(R.id.editEmail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.jasonhada.inclass03.action.VIEW");
                i.addCategory(Intent.CATEGORY_DEFAULT);
                i.putExtra(VALUE_KEY, user.email);
                i.putExtra(TYPE_KEY, "Edit Email");
                startActivityForResult(i, REQ_CODE_EMAIL);
            }
        });

        findViewById(R.id.editPhone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.jasonhada.inclass03.action.VIEW");
                i.addCategory(Intent.CATEGORY_DEFAULT);
                i.putExtra(VALUE_KEY, user.phone);
                i.putExtra(TYPE_KEY, "Edit Phone");
                startActivityForResult(i, REQ_CODE_PHONE);
            }
        });

        findViewById(R.id.editAddress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.jasonhada.inclass03.action.VIEW");
                i.addCategory(Intent.CATEGORY_DEFAULT);
                i.putExtra(VALUE_KEY, user.address);
                i.putExtra(TYPE_KEY, "Edit Address");
                startActivityForResult(i, REQ_CODE_ADDRESS);
            }
        });

        findViewById(R.id.editMood).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.jasonhada.inclass03.action.VIEW");
                i.addCategory(Intent.CATEGORY_DEFAULT);
                i.putExtra(VALUE_KEY, user.mood);
                i.putExtra(TYPE_KEY, "Edit Mood");
                startActivityForResult(i, REQ_CODE_MOOD);
            }
        });
    }

    @Override
    protected void onActivityResult(int  requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            if(requestCode == REQ_CODE_NAME) {
                TextView value = findViewById(R.id.displayName);
                value.setText(data.getExtras().getString(VALUE_KEY));
            } else if(requestCode == REQ_CODE_ADDRESS) {
                TextView value = findViewById(R.id.displayAddress);
                value.setText(data.getExtras().getString(VALUE_KEY));
            } else if(requestCode == REQ_CODE_EMAIL) {
                TextView value = findViewById(R.id.displayEmail);
                value.setText(data.getExtras().getString(VALUE_KEY));
            } else if(requestCode == REQ_CODE_PHONE) {
                TextView value = findViewById(R.id.displayPhone);
                value.setText(data.getExtras().getString(VALUE_KEY));
            } else if(requestCode == REQ_CODE_MOOD) {
                TextView value = findViewById(R.id.displayMood);
                value.setText(data.getExtras().getString(VALUE_KEY));
            }
        } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "No value received.", Toast.LENGTH_SHORT).show();
        }
    }
}

