package com.example.notesapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;
public class DialogNoteTitle extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());// get activity gets context of current Activity
        LayoutInflater inflater = requireActivity().getLayoutInflater();
       final View view = inflater.inflate(R.layout.customtitledialog,null);
        builder.setView(view);
        final EditText noteTitle = (EditText) view.findViewById(R.id.notesTitleEditText);
                builder.setPositiveButton(R.string.continue_bttn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent shareIntent = new Intent(DialogNoteTitle.this.getContext(), Notes.class);
                        shareIntent.putExtra(android.content.Intent.EXTRA_TITLE, noteTitle.getText().toString());
                        getContext().startActivity(shareIntent);
                    }
                });
        return builder.create();
    }
}
