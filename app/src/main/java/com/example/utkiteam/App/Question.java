package com.example.utkiteam.App;

public class Question {
    private String questionText;
    private String[] answerTexts;
    private int correctAnswerIndex;

    public Question(String questionText, String answerText1, String answerText2, String answerText3, String answerText4, int correctAnswerIndex) {
        this.questionText = questionText;
        this.answerTexts = new String[]{answerText1, answerText2, answerText3, answerText4};
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswerText(int index) {
        return answerTexts[index];
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
