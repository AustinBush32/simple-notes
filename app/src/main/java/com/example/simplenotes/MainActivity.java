package com.example.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    EditText note;
    Button add;
    LinearLayout notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note = findViewById(R.id.note);
        add = findViewById(R.id.add);
        add.setOnClickListener(onClick());
        notes = findViewById(R.id.notes);
    }

    private OnClickListener onClick() {
        return new OnClickListener() {

            @Override
            public void onClick(View v) {
                notes.addView(createNewTextView(note.getText().toString()));
            }
        };
    }

    private EditText createNewTextView(String text) {
        final LayoutParams lparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        final EditText newNote = new EditText(this);
        newNote.setLayoutParams(lparams);
        newNote.setText(text);
        newNote.setPadding(20, 50, 20, 50);
        return newNote;
    }
}
