package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Variables
     */
    private RadioGroup question_1;
    private RadioGroup question_2;
    private RadioGroup question_3;
    private RadioGroup question_4;
    private RadioGroup question_5;
    private RadioGroup question_6;
    private RadioGroup question_7;
    private RadioGroup question_8;
    private RadioGroup question_9;
    private RadioGroup question_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question_1 = (RadioGroup) findViewById(R.id.question_1);
        question_2 = (RadioGroup) findViewById(R.id.question_2);
        question_3 = (RadioGroup) findViewById(R.id.question_3);
        question_4 = (RadioGroup) findViewById(R.id.question_4);
        question_5 = (RadioGroup) findViewById(R.id.question_5);
        question_6 = (RadioGroup) findViewById(R.id.question_6);
        question_7 = (RadioGroup) findViewById(R.id.question_7);
        question_8 = (RadioGroup) findViewById(R.id.question_8);
        question_9 = (RadioGroup) findViewById(R.id.question_9);
        question_10 = (RadioGroup) findViewById(R.id.question_10);
    }

    /**
     * Submit order and display result
     */
    public void submitTest(View view) {
        int correctAnswers = 0;

        correctAnswers += answer(question_1, 1);
        correctAnswers += answer(question_2, 2);
        correctAnswers += answer(question_3, 3);
        correctAnswers += answer(question_4, 3);
        correctAnswers += answer(question_5, 2);
        correctAnswers += answer(question_6, 3);
        correctAnswers += answer(question_7, 2);
        correctAnswers += answer(question_8, 3);
        correctAnswers += answer(question_9, 2);
        correctAnswers += answer(question_10, 4);

        Log.v("", "" + correctAnswers);

        if (correctAnswers >= 7) {
            Toast.makeText(this, "Congratulations! You're passed test.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You're not passed test! Please, try again.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Reset test result. Uncheck all checked responses.
     */
    public void resetTest(View view) {
        question_1.clearCheck();
        question_2.clearCheck();
        question_3.clearCheck();
        question_4.clearCheck();
        question_5.clearCheck();
        question_6.clearCheck();
        question_7.clearCheck();
        question_8.clearCheck();
        question_9.clearCheck();
        question_10.clearCheck();

        ScrollView mainScrollView = (ScrollView)findViewById(R.id.mainScrollView);
        mainScrollView.fullScroll(ScrollView.FOCUS_UP);
    }

    /**
     * Return selected answer for question
     */
    private int answer(RadioGroup question, int correctAnswer) {
        int selectedId = question.getCheckedRadioButtonId();
        if (selectedId == -1) {
            return 0;
        }
        RadioButton button = (RadioButton) findViewById(selectedId);
        int index = question.indexOfChild(button);
        if (correctAnswer == index + 1) {
            return 1;
        } else {
            return 0;
        }
    }

}
