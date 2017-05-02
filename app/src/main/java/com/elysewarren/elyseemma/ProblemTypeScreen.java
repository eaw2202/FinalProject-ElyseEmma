package com.elysewarren.elyseemma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ProblemTypeScreen extends AppCompatActivity {

    private Button wordProblems;
    private Button arithmetic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_type_screen);

        wordProblems = (Button) findViewById(R.id.wordproblems_button);
        arithmetic = (Button) findViewById(R.id.arithmetic_button);
    }

    public void openPGScreen(View view) {
        Intent i = new Intent(this, PreGameSummary.class);
        startActivity(i);
    }
}