package com.example.utkiteam.App;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.utkiteam.R;

import java.util.ArrayList;

public class Instuction_test_1 extends Fragment {
    private TextView questionTextView;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private TextView testV;
    private Button submitButton;
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;
    private ArrayList<Question> questions = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_instuction_test_1, container, false);

        questionTextView = view.findViewById(R.id.question_text_view);
        radioGroup = view.findViewById(R.id.radio_group);
        radioButton1 = view.findViewById(R.id.radio_button_1);
        radioButton2 = view.findViewById(R.id.radio_button_2);
        radioButton3 = view.findViewById(R.id.radio_button_3);
        radioButton4 = view.findViewById(R.id.radio_button_4);
        submitButton = view.findViewById(R.id.submit_button);
        testV = view.findViewById(R.id.test_view);
        questions.add(new Question("What is the capital of France?", "Paris", "London", "Berlin", "Madrid", 0));
        questions.add(new Question("What is the largest country in the world?", "Russia", "China", "United States", "Canada", 0));
        questions.add(new Question("What is the currency of Japan?", "Yen", "Dollar", "Euro", "Pound", 0));

        showQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedAnswerIndex = radioGroup.getCheckedRadioButtonId();
                if (selectedAnswerIndex != -1) {
                    RadioButton selectedAnswer = view.findViewById(selectedAnswerIndex);
                    int answerIndex = radioGroup.indexOfChild(selectedAnswer);
                    if (answerIndex == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                        correctAnswers++;
                    }
                    currentQuestionIndex++;
                    if (currentQuestionIndex < questions.size()) {
                        showQuestion();
                    } else {
                        showResult();
                    }
                }
            }
        });
        return view;
    }

    private void showQuestion() {
        Question question = questions.get(currentQuestionIndex);
        questionTextView.setText(question.getQuestionText());
        radioButton1.setText(question.getAnswerText(0));
        radioButton2.setText(question.getAnswerText(1));
        radioButton3.setText(question.getAnswerText(2));
        radioButton4.setText(question.getAnswerText(3));
        testV.setText(question.getAnswerText(0));
        radioGroup.clearCheck();
    }

    private void showResult() {
        String resultText = "You answered " + correctAnswers + " out of " + questions.size() + " questions correctly.";
        questionTextView.setText(resultText);
        radioButton1.setEnabled(false);
        radioButton2.setEnabled(false);
        radioButton3.setEnabled(false);
        radioButton4.setEnabled(false);
        submitButton.setEnabled(false);
    }
}
