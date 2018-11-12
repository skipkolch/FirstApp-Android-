package com.example.user.homework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LinearActivity extends AppCompatActivity
{
    private EditText editA;
    private EditText editB;
    private EditText editC;

    private TextView resultText;

    private Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        InitialContents();
    }

    private void InitialContents()
    {
        editA = (EditText)findViewById(R.id.editTextA);
        editB = (EditText)findViewById(R.id.editTextB);
        editC = (EditText)findViewById(R.id.editTextC);

        resultText = (TextView)findViewById(R.id.result);

        AddButtonListener();
    }

    private void AddButtonListener()
    {
        calcBtn = (Button)findViewById(R.id.button);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double a = 0,b = 0,c = 0;

                if(editA.getText().length() != 0)
                    a = Double.parseDouble(editA.getText().toString());
                else
                {
                    Toast.makeText(LinearActivity.this, "Input A!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(editB.getText().length() != 0)
                    b = Double.parseDouble(editB.getText().toString());
                else
                {
                    Toast.makeText(LinearActivity.this, "Input B!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(editC.getText().length() != 0)
                    c = Double.parseDouble(editC.getText().toString());
                else
                {
                    Toast.makeText(LinearActivity.this, "Input C!", Toast.LENGTH_SHORT).show();
                    return;
                }

                resultText.setText(String.valueOf(CalcResult(a,b,c)));
            }
        });
    }

    private double CalcResult(double a,double b, double c)
    {
        return (c - b) / a;
    }
}
