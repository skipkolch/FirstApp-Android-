package com.example.user.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button linearEquation;
    private Button quadraticEquation;
    private Button dayWeek;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitialButtonsListener();
    }

    private void InitialButtonsListener()
    {
        linearEquation = (Button)findViewById(R.id.Linear);

        linearEquation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goActivity(LinearActivity.class);
            }
        });


        quadraticEquation = (Button)findViewById(R.id.Quadratic);
        quadraticEquation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity(QuadraticActivity.class);
            }
        });


        dayWeek = (Button)findViewById(R.id.Days);
        dayWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActivity(DayActivity.class);
            }
        });
    }

    private void goActivity(Class nextClass)
    {
        intent = new Intent(this, nextClass);
        startActivity(intent);
    }
}
