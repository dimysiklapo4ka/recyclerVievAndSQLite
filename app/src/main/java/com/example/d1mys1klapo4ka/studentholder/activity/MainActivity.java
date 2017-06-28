package com.example.d1mys1klapo4ka.studentholder.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.d1mys1klapo4ka.studentholder.R;
import com.example.d1mys1klapo4ka.studentholder.fragment.FragmentRecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar = (Toolbar)findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        Fragment fragment = new FragmentRecyclerView();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_activity, fragment)
                .commit();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_acrivity, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;
        switch (item.getItemId()){
            case R.id.item_add_worker:{
                intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
