package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton addNotesButton = (ImageButton) findViewById (R.id.addNotesButton);
        addNotesButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DialogFragment newFragment = new DialogNoteTitle(); //Creates object from CUSTOM dialog view
                newFragment.show(getSupportFragmentManager(),"box");

                //Dialog box pops up asking for title to next view
                //Opens up the next view afterwards

            }
            });
    }


}