package com.ufsm.mono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
    }

    public void bottomMenuClickCardActivity(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.button1CardActivity:
                intent = new Intent(this, MainActivity.class);
                break;
            case R.id.button2CardActivity:
                intent = new Intent(this, AnalyticsActivity.class);
                break;
            case R.id.button4CardActivity:
                intent = new Intent(this, ProfileActivity.class);
                break;
            default:
                return;
        }

        startActivity(intent);
    }
}