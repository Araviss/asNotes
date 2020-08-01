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

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Notes extends AppCompatActivity {
    SharedPreferences setOfNotes;
    EditText notepadEditText;
    Set<String> notesSet = new LinkedHashSet<>();

    String SET_KEY = "n";
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
                        JSONArray jsonArray; //= new JSONArray(notesSet);

                        if(!notesSet.isEmpty()){ //creating a JSONArray because it stores values as text and they are able to remain as ordered
                            notesSet.add(writtenNotes);
                            jsonArray =new JSONArray(notesSet);//convert set into JSON
                            Set<String> s = setOfNotes.getString(SET_KEY);// get the set

                            editor.putString(SET_KEY, jsonArray.toString());
                        }
                        else{
                            notesSet.add(writtenNotes);
                            jsonArray = new JSONArray(notesSet);
                            editor.putString(SET_KEY,jsonArray.toString());
                }
                        editor.commit();
              }
        });




    }

}