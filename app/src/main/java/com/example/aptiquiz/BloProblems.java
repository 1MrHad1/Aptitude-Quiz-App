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

public class BloProblems extends AppCompatActivity {
    TextView tv;
    Button subtn;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
    "If Anand is the brother of Bimala; Bimala is the sister of Chetan; and Chetan is the father of D, how D is related to Anand?",
            "Karan's father's brother's daughter's husband's mother-in-law is related to Karan as",
            "Aman, a man shows his friend a woman sitting in a park and says that she is the daughter of my paternal grandfather’s only son. How is that woman related to Aman?",
            "A is the son of C; C and Q are sisters; Z is the mother of Q and P is the son of Z. Which of the following statements is true?",
            "Amrit told to Anand in front of a photo that “He is the son of my father's son”. Find who is in the picture if Amrit have no brothers and sisters.",
            "One person has no siblings and says, “the guy in the photo is the only son of my father‘s son”. What is the relation of the guy to the person?",
            "A man was standing before a painting of a boy. He says \"Brothers and sisters I have none. The person's father is my father's son\". (I love poems). How is the person in the painting related to this man?",
            "A man shows his friend a woman sitting in a park and says that she is the daughter of my grandmother's only son. What is the relation between the two?",
            "D is brother of K, M is sister of K. R is father of D and S is mother of M. How is K related to R?",
            "Mary's father's brother is Andrews. Andrews’s daughter's son is Sunil. Andrews’s Brother’s name is Sam. Who is Sam to Sunil?"
    };
    String answers[]={

            "Cannot be Determined","Aunt","Sister","P is brother of C","Amrit's Son","Son","Son","Either B or C","Son or Daughter","Maternal Grand Uncle"
    };
    String opt[]={
            "Brother","Niece","Sister","Cannot be Determined",
            "Mother","Brother","Aunt","Sister",
            "Father","Mother","Sister","Niece",
            "A is Daddy of B","P is brother of C","A is son of Z","P is father of A",
            "Amrith's Brother","Amrith's Son","Amrith's Father","Amrith Himself",
            "Son","Mother","Father","Brother",
            "Grand-Father","Daughter","Baby","Son",
            "Either B or C","Sister","Cousin","Daughter",
            "Son","Daughter","Baby","Son or Daughter",
            "Maternal Grand Father","Father","Mother","Maternal Grand Uncle",
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