package com.example.notelist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutNotes;
    EditText editText;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor ShPEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutNotes = findViewById(R.id.layoutNotes);
        editText = findViewById(R.id.editText);

        sharedPreferences = getSharedPreferences("NoteList1_0", MODE_PRIVATE);
        ShPEditor = sharedPreferences.edit();

        loadNotes();
    }

    //todo Load last notes
    public void loadNotes(){

    }

    //todo add TextView to layoutNotes(linearLayout)
    public void addNote(View view) {
        Log.d(" NoteListLog ","ChildCount: " + layoutNotes.getChildCount());
        Log.d(" NoteListLog ","ChildCount: " + layoutNotes.getChildAt(0));
        ShPEditor.putString("key","val");
        ShPEditor.apply();

        addToLaout();
    }

    //add TextView to Linear Layout
    public void addToLaout(){
        layoutNotes.addView(
            new TextViewBuilder(this)
                    .setTextB(editText.getText().toString())
                    .setTextSizeB(20.5f)
                    .setOnClickListenerB(new View.OnClickListener() {
                        @Override
                        public void onClick(final View noteView) {
                            Snackbar snackbar = Snackbar.make(layoutNotes,"seriusly?",Snackbar.LENGTH_SHORT).setAction("Yep!", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    layoutNotes.removeView(noteView);
                                }
                            });
                            snackbar.show();
                        }
                    })
        );

/*
        TextView tv = new TextView(this);
        tv.setText(editText.getText().toString());
        tv.setTextSize(20.5f);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutNotes.removeView(v);
            }
        });

        layoutNotes.addView(tv);
 */
    }
}

class TextViewBuilder extends androidx.appcompat.widget.AppCompatTextView{
    public TextViewBuilder(Context context) {
        super(context);
    }

    public TextViewBuilder setTextB(CharSequence text) {
        super.setText(text);
        return this;
    }

    public TextViewBuilder setTextSizeB(float size) {
        super.setTextSize(size);
        return this;
    }

    public TextViewBuilder setOnClickListenerB(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
        return this;
    }

    public TextViewBuilder setLineHeightB(int lineHeight) {
        super.setLineHeight(lineHeight);
        return this;
    }
}