package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Notes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Intent intent = getIntent(); //Gets the intent from the other Activity
        String notesTitle = intent.getStringExtra(Intent.EXTRA_TITLE);

        TextView notesTitleTextView = (TextView) findViewById(R.id.notesTitleTextView);
        notesTitleTextView.setText(notesTitle);
        EditText notepadEditText = (EditText) findViewById(R.id.notesTakenEditText);



    }
}