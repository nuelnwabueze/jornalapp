package com.example.android.jornalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.android.jornalapp.model.Note;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditorActivity extends AppCompatActivity {

    AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
    Note note;

    EditText title1, content1;

    public static final String Firebase_Server_URL = "https://jornal-app1.firebaseio.com/";
    Firebase firebase;

    DatabaseReference databaseReference;
    public static final String Database_Path = "Note_Database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        firebase = new Firebase(Firebase_Server_URL);
        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);
        addValidationToViews();

        title1 = findViewById(R.id.title);
        content1 = findViewById(R.id.content);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_save:
                saveNote();
                return true;

            default:
                return false;

        }
    }

    private void addValidationToViews() {

        awesomeValidation.addValidation(this, R.id.title, RegexTemplate.NOT_EMPTY, R.string.invalid_title);
        awesomeValidation.addValidation(this, R.id.content, RegexTemplate.NOT_EMPTY, R.string.invalid_content);
    }

    private void saveNote() {

        if (awesomeValidation.validate()){
            String title = title1.getText().toString().trim();
            String content = content1.getText().toString().trim();
            String date = getCurrentDate();
            note = new Note();
            note.setNoteTitle(title);
            note.setNoteContent(content);
            note.setDate(date);

            String NoteIdFromServer = databaseReference.push().getKey();

            databaseReference.child(NoteIdFromServer).setValue(note);
            goBackHome();

            // Showing Toast message after successfully data submit.
            Toast.makeText(EditorActivity.this,"Data Inserted Successfully into Firebase Database", Toast.LENGTH_LONG).show();

        }

    }

    private void goBackHome() {
        Intent intent = new Intent(EditorActivity.this, MainActivity.class);
        startActivity(intent);
    }


    public String getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy/MM/dd");
        String date = simpleDateFormat.format(calendar.getTime());
        return date;
    }
}

