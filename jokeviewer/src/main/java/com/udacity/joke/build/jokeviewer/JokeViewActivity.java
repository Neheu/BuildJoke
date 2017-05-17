package com.udacity.joke.build.jokeviewer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_view);
        String joke = getIntent().getStringExtra("Joke");
        TextView jokeView = (TextView) findViewById(R.id.joke);
        if (jokeView != null) {
            jokeView.setText(joke);
        }
    }


}
