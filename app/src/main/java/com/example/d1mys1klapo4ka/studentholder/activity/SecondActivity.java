package com.example.d1mys1klapo4ka.studentholder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.d1mys1klapo4ka.studentholder.R;
import com.example.d1mys1klapo4ka.studentholder.model.Models;
import com.example.d1mys1klapo4ka.studentholder.sqLite.CreateSQLite;
import com.example.d1mys1klapo4ka.studentholder.sqLite.DataBaseHandler;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by dev on 5/16/17.
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btAdd;
    private EditText etName;
    private EditText etSecondName;
    private EditText etBDay;
    private EditText etId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        etName = (EditText) findViewById(R.id.et_name);
        etSecondName = (EditText) findViewById(R.id.et_second_name);
        etBDay = (EditText) findViewById(R.id.et_b_day);
        etBDay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etId = (EditText) findViewById(R.id.et_id);

        btAdd = (Button) findViewById(R.id.button);
        btAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button: {

                if (isValidDate(etBDay.getText().toString())) {

                    CreateSQLite db = new CreateSQLite(this);
                    db.addModels(new Models(Integer.parseInt(etId.getText().toString()), etName.getText().toString(), etSecondName.getText().toString(),
                            etBDay.getText().toString()));
                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                break;

            }
        }
    }

    boolean isValidDate (String inputValue) {
        Calendar cal = new GregorianCalendar();
        cal.setLenient (false);
        cal.clear ();
        // Разобрать строку на три составляющие (день, месяц, год)
        try {
            int d = Integer.parseInt (inputValue.substring (0, 2));
            int m = Integer.parseInt (inputValue.substring (3, 5));
            int y = Integer.parseInt (inputValue.substring (6, 10));
            cal.set (y, m - 1, d);
            java.util.Date dt = cal.getTime ();
            return true;
        }
        catch (NumberFormatException nfe) {

            Toast.makeText(this,"Введите дату в формате dd.mm.yyyy",Toast.LENGTH_SHORT).show();
            return false;
        }
        catch (IllegalArgumentException iae) {

            Toast.makeText(this,"Введите дату в формате dd.mm.yyyy",Toast.LENGTH_SHORT).show();
            return false;
        }
        catch (Exception e){
            Toast.makeText(this,"Введите дату в формате dd.mm.yyyy",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
