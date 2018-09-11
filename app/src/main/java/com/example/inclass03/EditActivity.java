package com.example.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    private EditText edit = (EditText) findViewById(R.id.changeAttribute);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //EditText edit = (EditText) findViewById(R.id.changeAttribute);

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = edit.getText().toString();
                if(value == null || value.length() == 0) {
                    setResult(RESULT_CANCELED);
                } else {
                    Intent i = new Intent();
                    i.putExtra(DisplayActivity.VALUE_KEY, value);
                    setResult(RESULT_OK, i);
                }
                finish();
            }
        });
    }
}
