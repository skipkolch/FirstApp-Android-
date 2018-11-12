package com.example.user.homework;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DayActivity extends AppCompatActivity
{
    private EditText textData;
    private TextView dayText;
    private Button calcBtn;

    private enum Days {Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday, Friday}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dayweek);
        Initialize();
    }

    private void Initialize()
    {
        textData = (EditText) findViewById(R.id.editData);
        dayText = (TextView) findViewById(R.id.textDay);

        calcBtn = (Button) findViewById(R.id.buttonDay);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Days numberDay = ResultDay(textData.getText().toString());

                dayText.setVisibility(View.VISIBLE);

                switch (numberDay)
                {
                    case Sunday: {dayText.setText("Воскресенье"); break; }
                    case Monday: {dayText.setText("Понедельник"); break; }
                    case Tuesday: {dayText.setText("Вторник"); break; }
                    case Wednesday: {dayText.setText("Среда"); break; }
                    case Thursday: {dayText.setText("Четверг"); break; }
                    case Friday: {dayText.setText("Пятница"); break; }
                    case Saturday: {dayText.setText("Суббота"); break; }
                }
            }
        });
    }

    public static String[] SplitTest(String str)
    {
        String[] splitStr = str.split("\\.");
        return splitStr;
    }


    private Days ResultDay(String datastr)
    {
        Days[] day = null;
        int i = 0;

        try
        {
            String[] array = datastr.split("\\.");
            day = Days.values();

            i = (Integer.parseInt(array[0]) + CodMounth(array[1]) + CodYear(array[2])) % 7;
        }
        catch (NumberFormatException ex)
        {
            Toast.makeText(this,"Invalid format", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }

        return day[i];
    }


    private int CodMounth(String mounth)
    {
        int mnth = Integer.parseInt(mounth);

        switch (mnth)
        {
            case 1:{ return 1; }
            case 2:{ return 4; }
            case 3:{ return 4; }
            case 4:{ return 0; }
            case 5:{ return 2; }
            case 6:{ return 5; }
            case 7:{ return 0; }
            case 8:{ return 3; }
            case 9:{ return 6; }
            case 10:{ return 1; }
            case 11:{ return 4; }
            case 12:{ return 6; }
            default: return -1;
        }
    }

    private int CodYear(String year)
    {
        int y = Integer.parseInt(year);
        return (6 + y + y/4)%7;
    }
}
