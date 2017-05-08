package com.example.sagar.moviesuccesspredictor;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 *
 * Created by Sagar on 5/8/2017.
 */

public class ShowResult extends AppCompatActivity{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_result);
        String s = getIntent().getStringExtra("prediction");

    }
}
