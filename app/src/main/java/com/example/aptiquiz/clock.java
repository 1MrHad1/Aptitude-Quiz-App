package com.example.aptiquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class clock extends AppCompatActivity {

    TextView cal;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        cal=findViewById(R.id.textView11);
        cal.setMovementMethod(LinkMovementMethod.getInstance());
        b1=findViewById(R.id.btnn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(clock.this,clockProblems.class);
                startActivity(intent);
            }
        });
    }
}