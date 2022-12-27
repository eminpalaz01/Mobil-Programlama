package com.mobilelesson.myfirstapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewJobsActivity extends AppCompatActivity {
    private ArrayList<String> idList, jobList, createTimeList, createrList;

    private MyDatabaseHelper myDb;
    private CustomAdapter customAdapter;

    private RecyclerView recyclerView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_jobs);
        recyclerView = findViewById(R.id.recyclerView);


        myDb = new MyDatabaseHelper(ViewJobsActivity.this);
        idList = new ArrayList<>();
        jobList = new ArrayList<>();
        createTimeList = new ArrayList<>();

        createrList = new ArrayList<>();
        storeDataInArrays();

        customAdapter = new CustomAdapter(ViewJobsActivity.this, idList, jobList, createTimeList, createrList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewJobsActivity.this));
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

    public void storeDataInArrays(){
        Cursor cursor = myDb.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Yapılacak bir iş yok.", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                idList.add(cursor.getString(0));
                jobList.add(cursor.getString(1));
                createTimeList.add(cursor.getString(2));
                createrList.add(cursor.getString(3));
            }

        }

    }


}
