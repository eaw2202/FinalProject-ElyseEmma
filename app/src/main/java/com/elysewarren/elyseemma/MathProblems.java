package com.elysewarren.elyseemma;

/**
 * Created by cmltdstudent on 5/2/17.
 */

public class MathProblems {
    public String question;
    public int answer;
    public boolean truefalse;

    public MathProblems(String question, int answer, boolean truefalse) {
        this.question = question;
        this.answer = answer;
        this.truefalse = truefalse;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public boolean isTruefalse() {
        return truefalse;
    }

    public void setTruefalse(boolean truefalse) {
        this.truefalse = truefalse;
    }

    @Override
    public String toString() {
        return "Question: " + question + "\n" +
                "Answer: " + answer + "\n";
    }
}
