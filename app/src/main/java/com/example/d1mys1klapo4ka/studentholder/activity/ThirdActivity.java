package com.example.d1mys1klapo4ka.studentholder.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.d1mys1klapo4ka.studentholder.R;

/**
 * Created by d1mys1klapo4ka on 27.06.2017.
 */

public class ThirdActivity extends AppCompatActivity {

    TextView name;
    TextView secondName;
    TextView birhday;
    TextView id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        name = (TextView) findViewById(R.id.tv_full_name);
        secondName = (TextView) findViewById(R.id.tv_full_second_name);
        birhday = (TextView) findViewById(R.id.tv_full_b_day);
        id = (TextView) findViewById(R.id.tv_full_id);

        dataInfo();
    }

    private void dataInfo() {
        name.setText(getIntent().getStringExtra("name").toString());
        secondName.setText(getIntent().getStringExtra("secondName").toString());
        birhday.setText(getIntent().getStringExtra("Birhday").toString());
        id.setText(""+getIntent().getIntExtra("id", 0));
    }
}
