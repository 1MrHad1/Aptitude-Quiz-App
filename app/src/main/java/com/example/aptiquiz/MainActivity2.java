package com.example.aptiquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);

        b1.setAlpha(0f);
        b1.setTranslationY(50);
        b1.animate().alpha(1f).translationYBy(-50).setDuration(1500);

        b2.setAlpha(0f);
        b2.setTranslationY(50);
        b2.animate().alpha(1f).translationYBy(-50).setDuration(1500);

        b3.setAlpha(0f);
        b3.setTranslationY(50);
        b3.animate().alpha(1f).translationYBy(-50).setDuration(1500);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,TimeAndWork.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,Percentage.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,Average.class);
                startActivity(intent);
            }
        });
    }

}