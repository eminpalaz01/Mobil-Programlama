package com.mobilelesson.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout ll;

    private TextView t,t1;
    private EditText et;
    private EditText et1;
    private Button b;


    private Toast toastMessage;
    private Context context = this;

    private String ad, sifre;
    private String userName,userPassword;

    private SQLiteDatabase database;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.main_activity_layout);
        et = findViewById(R.id.et);
        et1 =findViewById(R.id.et1);
        t1 = findViewById(R.id.t1);
        t =  findViewById(R.id.t);

        b =  findViewById(R.id.b);




        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               ad = et.getText().toString();
               sifre = et1.getText().toString();
               userName = getText(R.string.user_name).toString();
               userPassword = getText(R.string.user_password).toString();


               // equals ile kontrol yapıldı
                   if((ad.equals(userName)) && (sifre.equals(userPassword))) {
                      Toast.makeText(context,"Hoşgeldiniz " + ad +".",Toast.LENGTH_LONG).show();

                      Intent intent = new Intent(getBaseContext(), ViewJobsActivity.class);
                      startActivity(intent);
                   }else{
                      Toast.makeText(context,R.string.ad_ve_sifrenizi_kontrol_ediniz,Toast.LENGTH_LONG).show();
                   }
            }
        });

    }

}