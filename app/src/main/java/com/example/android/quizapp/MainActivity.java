package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
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

    private CheckBox question_11_1;
    private CheckBox question_11_2;
    private CheckBox question_11_3;
    private CheckBox question_11_4;

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

        question_11_1 = (CheckBox) findViewById(R.id.question_11_answer_1);
        question_11_2 = (CheckBox) findViewById(R.id.question_11_answer_2);
        question_11_3 = (CheckBox) findViewById(R.id.question_11_answer_3);
        question_11_4 = (CheckBox) findViewById(R.id.question_11_answer_4);
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

        int question_11_answers = 0;
        question_11_answers += answer(question_11_1, true);
        question_11_answers += answer(question_11_2, true);
        question_11_answers += answer(question_11_3, true);
        question_11_answers += answer(question_11_4, false);

        if (question_11_answers == 3) {
            correctAnswers += 1;
        } else if (correctAnswers > 0) {
            correctAnswers -= 1;
        }

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

    /**
     * Return result for selected questions
     */
    private int answer(CheckBox question, boolean correctAnswer) {
        int selectedId = question.getId();
        if (selectedId == -1) {
            return 0;
        }
        CheckBox checkbox = (CheckBox) findViewById(selectedId);
        if (checkbox.isChecked() == true) {
            return 1;
        } else {
            return 0;
        }
    }

}
