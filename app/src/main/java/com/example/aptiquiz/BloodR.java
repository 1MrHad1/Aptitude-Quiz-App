package com.example.aptiquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BloodR extends AppCompatActivity {

    TextView blo;
    Button b01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_r);
        blo=findViewById(R.id.textView6);
        blo.setMovementMethod(LinkMovementMethod.getInstance());
        b01=findViewById(R.id.button5);
        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BloodR.this,BloProblems.class);
                startActivity(intent);
            }
        });
    }
}