package com.example.testlabsampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener mOnClickListener
            = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            switch (v.getId()) {
                case R.id.text1:
                    intent.putExtra(DetailActivity.KEY_MESSAGE, "Item1");
                    break;
                case R.id.text2:
                    intent.putExtra(DetailActivity.KEY_MESSAGE, "Item2");
                    break;
                case R.id.text3:
                    intent.putExtra(DetailActivity.KEY_MESSAGE, "Item3");
                    break;
            }
            startActivity(intent);
        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_notifications:
                    Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
                    startActivity(intent);
                    return false;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.text1).setOnClickListener(mOnClickListener);
        findViewById(R.id.text2).setOnClickListener(mOnClickListener);
        findViewById(R.id.text3).setOnClickListener(mOnClickListener);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
