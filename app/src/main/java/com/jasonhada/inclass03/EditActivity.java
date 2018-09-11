package com.jasonhada.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    private EditText edit;
    private TextView typeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        if (getIntent() != null && getIntent().getExtras() != null) {
            String value = getIntent().getExtras().getString(DisplayActivity.VALUE_KEY);
            String type = getIntent().getExtras().getString(DisplayActivity.TYPE_KEY);

            edit = (EditText) findViewById(R.id.changeAttribute);
            edit.setText(value);

            typeTV = (TextView) findViewById(R.id.editAttribute);
            typeTV.setText(type);

            findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String value = edit.getText().toString();
                    if (value == null || value.length() == 0) {
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
}
