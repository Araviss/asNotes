package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

public class Notes extends AppCompatActivity {
    SharedPreferences setOfNotes;
    EditText notepadEditText;
    ArrayList<String> notesList = new ArrayList<>(); //Array list created to hold ListView previews
    Set<String> notesSet;
    public static final String Notes = "notesKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Intent intent = getIntent(); //Gets the intent from the other Activity
        String notesTitle = intent.getStringExtra(Intent.EXTRA_TITLE);

        TextView notesTitleTextView = (TextView) findViewById(R.id.notesTitleTextView);
        notesTitleTextView.setText(notesTitle);

        notepadEditText = (EditText) findViewById(R.id.notesTakenEditText);
        ImageButton saveButton = (ImageButton) findViewById(R.id.saveButton);

        setOfNotes = getSharedPreferences("notes", MODE_PRIVATE);

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v) { ///this is going to read set into an array add
                        String writtenNotes = notepadEditText.getText().toString();
                        SharedPreferences.Editor editor = setOfNotes.edit();

                        if(!notesList.isEmpty()){
                            notesList.add(writtenNotes);


                            editor.putStringSet("n", notesSet);
                        }
                        else{
                            notesSet.add(writtenNotes);
                            editor.putStringSet("n",notesSet);
                }
              }
        });




    }
}