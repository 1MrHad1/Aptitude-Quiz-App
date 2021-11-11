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

public class PercentProblems extends AppCompatActivity {
    TextView tv;
    Button subtn;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                            "What will come in place of question mark (?) in the following question ?\n" +
                                    "\n" +
                                    "38% of 4500 - 25% of ? = 1640",
                            "If an item costs Rs.3 in 1999 and Rs.203 in 2000.What is the % increase in price?",
                            "In a school there are 1000 students in the year 1999. The number of students increased by 20% in the year 2000. And it is increased by 15% in the year 2001. But it is decreased by 20% in 2002. Then what is the strength in 2002?",
                            "If x/y = 4 and y is not '0' what % of x is 2x - y",
                            "In a fair, the entrance ticket for Kids was Rs.16 and Rs.20 for adults. Every year, adult's ticket cost increases 25% more than kid’s ticket increase rate. The rate of increase of ticket rate for Kids is 25%. What will be the difference of their ticket cost after 2 years?",
                            "An exhibition was conducted for 4 weeks. The number of tickets sold in 2nd work week was increased by 20% and increased by 16% in the 3rd work week but decreased by 20% in the 4th work week. Find the number of tickets sold in the beginning, if 1392 tickets were sold in the last week.",
                            "The cost of two varieties of paint is Rs.3969 per 2 kg and Rs.1369 per 2 kg respectively. After how many years will the value of both paint be the same, if variety1 depreciates at 26% per annum and variety2 appreciates at 26% per annum?",
                            "In 1988, a kg of paper was sold at Rs25/-. If the paper rate increases at 1.5% more than the inflation rate which is 6.5% a year, then what will be the cost of a kg of paper after 2 years?",
                            "If 70% of a number is subtracted from itself it reduces to 81.what is two fifth of that no.?"
    };
    String answers[]={

                "280","None of these","1104","75","175%","Rs.20","1250","2","29.16","108"
    };
    String opt[]={
            "260","270","280","290",
            "200/3%","200/6%","100%","None of these",
            "1200","1300","1050","1104",
            "75","70","80","85",
            "160%","175%","200%","225%",
            "Rs.16","Rs.15","Rs.20","Rs.18",
            "1750","1550","1250","1000",
            "3","2","4","1",
            "28.8","28","29.16","29",
            "88","99","108","116",
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