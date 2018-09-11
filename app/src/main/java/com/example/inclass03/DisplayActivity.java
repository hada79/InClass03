package com.example.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    public static final int REQ_CODE = 100;
    public static final int REQ_CODE_NAME = 101;
    public static final int REQ_CODE_EMAIL = 102;
    public static final int REQ_CODE_ADDRESS = 103;
    public static final int REQ_CODE_PHONE = 104;
    public static final int REQ_CODE_MOOD = 105;
    public static final String VALUE_KEY = "value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        if(getIntent() != null && getIntent().getExtras() != null) {
            User user = (User) getIntent().getExtras().getSerializable(MainActivity.USER_KEY);

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
                Log.d("demo", "onClick: ");
                TextView name = findViewById(R.id.displayName);
                Log.d("demo", "onClick: ");

                Intent i = new Intent("com.example.inclass03.action.VIEW");
                i.addCategory(Intent.CATEGORY_DEFAULT);
                i.putExtra(VALUE_KEY, name.getText().toString());
                startActivityForResult(i, REQ_CODE_NAME);
                //startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int  requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            if(resultCode == REQ_CODE_NAME) {
                TextView value = findViewById(R.id.displayName);
                value.setText(data.getExtras().getString(VALUE_KEY));
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "No value received.", Toast.LENGTH_SHORT).show();
        }
    }
}
