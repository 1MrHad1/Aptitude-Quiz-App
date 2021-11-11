package com.example.aptiquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class clockProblems extends AppCompatActivity {
    TextView tv;
    Button subtn;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                "Can you find out what day of the week was January 12, 1979?",
            "A watch gains 12 seconds every 3 hours, what time will it show at 10 A.M. on Tuesday if the watch is set right at 3 A.M. on Sunday?",
            "For each hour a watch is going slow by 30 seconds. Now the time is 8 a.m., when the clock is set right. What will be the time in watch when the actual time is 8 p.m.?",
            "My flight takes off at 2 AM from a place at 18N 10E and landed 10 Hrs. later at a place with coordinates 36N 70W. What is the local time when my plane landed?",
            "January 1, 2005 was Saturday. What day of the week lies on Jan. 1, 2006?",
            "It was Monday on Jan 1, 2007. What was the day of the week Jan 1, 2011?",
            "What is the angle between the two hands of a clock when time is 8:30?",
            "If the Valentine’s Day in 2005 falls on Monday, then on which day will the Valentine’s Day fall in 2010?",
            "A clock is so placed that at 12 noon its minute hand points towards north-east. In which direction does its hour hand point at 1.30 p.m?",
            "At 6'O clock, clock ticks 6 times. The time between first and last tick was 30sec. How much time it takes at 12'O clock?"
    };
    String answers[]={

            "Friday","10 hrs 3 minutes 40 seconds","7:54 PM","6:40 AM","Sunday","Saturday","75","Sunday","East","66 Seconds"
    };
    String opt[]={
            "Monday","Friday","Wednesday","Tuesday",
            "10 hrs 2 minutes","10 hrs","10 hrs 3 minutes 40 seconds","6 hrs 9 minutes",
            "7:00 PM","7:52 PM","7:48","7:54 PM",
            "6 PM","6 AM","6:40 AM","5 PM",
            "Thursday","Friday","Saturday","Sunday",
            "Monday","Friday","Saturday","Sunday",
            "50","65","75","69",
            "Monday","Sunday","Tuesday","Friday",
            "West","South","East","North",
            "66 Seconds","62 Seconds","65 Seconds","69 Seconds"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percent_problems);

        final TextView score=(TextView)findViewById(R.id.textView4);
        subtn=(Button)findViewById(R.id.btnn);
        tv=(TextView) findViewById(R.id.tvque1);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        subtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

    }
}