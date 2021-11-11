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

public class AvgProblems extends AppCompatActivity {
    TextView tv;
    Button subtn;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "The mean temperature of Monday to Wednesday was 37°C and of Tuesday to Thursday was 34°\u200BC, if the temperature on Thursday was 4/5th that of Monday, then what was the temperature on Thursday?",
            "There are 5 packages. The weight of 1st package is 500 kg and the weight of the 2nd package is 50% higher than the weight of 3rd package whose weight is 45% higher than the 1st package weight. The fourth package at 360 kgs is 60% lighter than the fifth package. Find the average weight of all the five packages.",
            "The average number of visitors to a library in the first 4 days of a week was 58. The average for the 2nd, 3rd, 4th and 5th days was 60. If the number of visitors on the 1st and 5th days were in the ratio 7 ∶ 8 then what is the number of visitors on the 5th day of the library?",
            "Pradeep gave Rs.A for buying every 10 items and Rs.B for buying every extra item. If he bought 10 items on Monday 13 items on Tuesday, 12 items on Wednesday, 11 items on Thursday and 12 items on Friday then what is his average daily spending in rupees for the five days?",
            "In an exam, Amit, Sachin, Kriti, Sandeep and Ravi scored an average of 39 marks. Sandeep scored 7 marks more than Ravi. Ravi scored 9 fewer than Amit. Sachin scored as many as Sandeep and Ravi scored. Sachin and Kriti scored 110 marks. If Amit scores 32 marks then how many marks did Kriti score?",
            "The average weight of 21 boys was recorded as 64 kgs. If the weight of the teacher was added, the average increased by one kg. What was the teachers’ weight?",
            "The average of four consecutive numbers A, B, C and D respectively is 49.5. What is the product of B & D?",
            "In a class of 150 students, 40% of the students got 45 marks on average and 46 % of the students got 60 marks on average. The average marks for the total class are 55. Find the average marks secured by the rest of the students.",
            "In a class, there are 20 boys whose average age is decreased by 2 months, when one boy aged 18 years is replaced by a new boy. The age of the new boy is :",
            "In June a baseball team that played 60 games had won 30% of its game played. After a phenomenal winning streak this team raised its average to 50% .How many games must the team have won in a row to attain this average?"
    };
    String answers[]={
        "36°C","714.5Kg","64","A+8B/5","57 marks","86Kgs","2499","67.14","14 years 8 months","24"

    };
    String opt[]={
            "36.5°C","35°C","36°C","37°C",
            "728.8Kg","725.9Kg","714.5Kg","716.69Kg",
            "18","64","58","69",
            "6A+8B","10A+8B/5","A+8B/5","6A+9B",
            "53 marks","23 marks","57 marks","33 marks",
            "86Kgs","60Kgs","75Kgs","51Kgs",
            "2499","2352","4969","7576",
            "45.5","67.14","62.3","68.9",
            "15 years","13 years","14 years 8 months","8 years",
            "12","32","24","18",

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