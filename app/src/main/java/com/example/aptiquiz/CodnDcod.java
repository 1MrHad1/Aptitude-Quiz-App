package com.example.aptiquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class
CodnDcod extends AppCompatActivity {

    TextView cod;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codn_dcod);
        cod=findViewById(R.id.textView7);
        cod.setMovementMethod(LinkMovementMethod.getInstance());
        b1=findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CodnDcod.this,CodingProblems.class);
                startActivity(intent);
            }
        });
    }
}