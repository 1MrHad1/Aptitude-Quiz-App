package com.example.aptiquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimeAndWork extends AppCompatActivity {
    TextView t1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_and_work);
        t1=findViewById(R.id.tv12);
        t1.setMovementMethod(LinkMovementMethod.getInstance());
        b1=findViewById(R.id.btn11);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent =new Intent(TimeAndWork.this,TimeProblems.class);
            startActivity(intent);
            }
        });

    }
}