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

public class TimeProblems extends AppCompatActivity {
    TextView tv;
    Button subtn;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "45 men can complete a work in 16 days. Six days after they started working, 30 more men joined them. In how many days the total work will be completed ?",
            "Thirty men take 20 days to complete a job working 9 hours a day. How many hour a day should 40 men take in 20 days to complete the job?",
            "Susan can type 10 pages in 5 minutes. Mary can type 5 pages in 10 minutes. Working together, how many pages can they type in 30 minutes?",
            "A man’s basic pay for a 40 hours’ week is Rs. 200. Overtimes is paid at 25% above the basic rate. In a certain week, he worked overtime and his total was Rs. 300. He therefore, worked for a total of (in hours):",
            "If 9 men working 7.5 hours a day can finish a piece of work in 20 days, then how many days will be taken by 12 men, working 6 hours a day to finish the work? It is being given that 2 men of latter type work as much as 3 men of the former type?",
            "Three pipes A, B and C together can fill a cistern in 6 hours. After working at it together for 2 hours, C is closed and A and B can fill the remaining part in 7 hours. The number of hours taken by C alone to fill the cistern is:",
            "Pipe A can fill a tank in 30 mins and Pipe B can fill it in 28 mins. If 3/4th of the tank is filled by Pipe B alone and then both are opened, how much time is required by both the pipes to fill the tank completely?",
            "15 men take 21 days of 8 hrs. each to do a piece of work. How many days of 6 hrs. each would it take for 21 women if 3 women do as much work as 2 men?",
            "It was calculated that 75 men could complete a piece of work in 20 days. When work was scheduled to commence, it was found necessary to send 25 men to another project. How long it will take to complete the work?",
            "It takes Mr. Karthik ‘y’ hours to complete typing a manuscript. After 2 hours, he was called away. What fractional part of the assignment was left incomplete?"
    };
    String answers[]={
            "12","6.75 hours/day","75","56","12.5","14","None of these ","30","30","(y-2)/y"

    };
    String opt[]={
            "12","8","3","5",
            "6 hours/day","7 hours/day","64 hours/day","6.75 hours/day",
            "75","20","29","76",
            "58","56","55","43",
            "22","34","30","12.5",
            "14","18","15","17",
            "4min","3min","2min","None of these",
            "30","31","32","33",
            "22","30","38","21",
            "1/y","y/2","(y-2)/y","y"
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