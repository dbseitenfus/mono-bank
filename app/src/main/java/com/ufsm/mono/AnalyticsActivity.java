package com.ufsm.mono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AnalyticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);
    }

    public void bottomMenuClickAnalyticsActivity(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.button1AnalyticsActivity:
                intent = new Intent(this, MainActivity.class);
                break;
            case R.id.button3AnalyticsActivity:
                intent = new Intent(this, CardActivity.class);
                break;
            case R.id.button4AnalyticsActivity:
                intent = new Intent(this, ProfileActivity.class);
                break;
            default:
                return;
        }

        startActivity(intent);
    }
}