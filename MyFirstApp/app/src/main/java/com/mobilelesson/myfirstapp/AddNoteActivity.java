package com.mobilelesson.myfirstapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;

public class AddNoteActivity extends AppCompatActivity {

    private Button btnAddNote;
    private EditText inputAddNote;

    private MyDatabaseHelper myDb;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        btnAddNote = findViewById(R.id.btnAddNote);
        inputAddNote = findViewById(R.id.inputAddNote);

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToDB();
                Intent intent = new Intent(getBaseContext(), ViewJobsActivity.class);
                startActivity(intent);
            }
        });


    }

    public void addToDB(){

        String input = inputAddNote.getText().toString();
        Calendar calendar = Calendar.getInstance();
        String currentTime = DateFormat.getDateInstance().format(calendar.getTime());

        myDb = new MyDatabaseHelper(AddNoteActivity.this);
        myDb.addJob(input,currentTime,"Kullanıcı");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_page:
                Intent intent = new Intent(getBaseContext(), ViewJobsActivity.class);
                startActivity(intent);
                return true;
            case R.id.add_note:
                Intent intent1 = new Intent(getBaseContext(), AddNoteActivity.class);
                startActivity(intent1);
                return true;
            case R.id.delete_note:
                Intent intent2 = new Intent(getBaseContext(), DeleteNoteActivity.class);
                startActivity(intent2);
                return true;
            case R.id.exit_app:
                Intent intent3 = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
