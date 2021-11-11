package com.example.aptiquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aptiquiz.MainActivity;
import com.example.aptiquiz.R;

public class CodingProblems extends AppCompatActivity {
    TextView tv;
    Button subtn;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "If MANSON is coded as 5 and BELIEVED is coded as 7, what will be coded for NEGOTIABLE?",
            "If DDMUQZM is coded as CENTRAL then UZMHKDE can be coded as.....",
            "In a certain code language if “TRAIN” is coded as UTDMS, then how will you code “GRASS”?",
            "If in a certain code “RANGE” is coded as 12345 and “RANDOM” is coded as 123678. Then the code for the word “MANGO” would be?",
            "If “PROMPT” is coded as QSPLOS, then “PLAYER” should be?",
            "If West is called as North-East, North-East as East, East is called as South-West, South-West is called as North, North is called as North-West, North-West as South and South is called as South-East, then pole star in which direction?",
            "In a certain code language, 'no more food' is written as 'ta ka da' and 'more than that' is written as 'sa pa ka'. How is 'that' written in that code language?",
            "In a certain code SHOULDER is written as VPITQDCK. How is MORNINGS written in that code?",
            "In a certain code GUEST is written as 53@$2 and MEAN is written as 6@4#. How is SAME written in that code?",
            "vIf '+' means '-'; '-' means '+' and 'x' means ' -'; then 20 - 16 + 4 x 3 - 2 = ?"
    };
    String answers[]={

            "9","TANGLED","HTDWX","82347","QMBXDQ","North-West","sa or pa","OSPNRFMH","$46@","31"
    };
    String opt[]={
            "7","9","2","90",
            "RTYRYT","RFDETV","TANGLED","TANLEDG",
            "HTCWW","HTDWW","HTDXX","HTDWX",
            "83456","765676","82347","85678",
            "QMBZFS","QMBXDQ","TYGHGF","HYIIH",
            "North-West","East","West","North",
            "sa or pa","pa","ka","sa",
            "OESDFVG","OSDPYUH","UGUYYYUT","OSPNRFMH",
            "4$6@","$28@","$29@","$46@",
            "88","99","31","16",
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
                    Intent in = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

    }
}