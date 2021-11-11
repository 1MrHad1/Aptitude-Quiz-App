package com.example.aptiquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

    Button b7,b8,b10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b7=findViewById(R.id.bt7);
        b8=findViewById(R.id.bt8);
        b10=findViewById(R.id.bt10);


        b7.setAlpha(0f);
        b7.setTranslationY(50);
        b7.animate().alpha(1f).translationYBy(-50).setDuration(1500);

        b8.setAlpha(0f);
        b8.setTranslationY(50);
        b8.animate().alpha(1f).translationYBy(-50).setDuration(1500);

        b10.setAlpha(0f);
        b10.setTranslationY(50);
        b10.animate().alpha(1f).translationYBy(-50).setDuration(1500);


        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,CodnDcod.class);
                startActivity(intent);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,BloodR.class);
                startActivity(intent);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this,clock.class);
                startActivity(intent);
            }
        });
    }
}