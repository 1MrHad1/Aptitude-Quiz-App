package com.example.aptiquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Average extends AppCompatActivity {
    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average);
        t1=findViewById(R.id.textView15);
        b1=findViewById(R.id.button);
        t1.setMovementMethod(LinkMovementMethod.getInstance());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Average.this,AvgProblems.class);
                startActivity(intent);
            }
        });

    }
}