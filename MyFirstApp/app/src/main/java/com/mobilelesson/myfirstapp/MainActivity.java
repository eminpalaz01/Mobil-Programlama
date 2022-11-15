package com.mobilelesson.myfirstapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll;

    private TextView t;
    private TextView t1;
    private EditText et;
    private EditText et1;
    private Button b;


    private Toast toastMessage;
    private Context context = this;

    private String ad, soyad;


// Bu projede activity_main.xml dosyası kullanılmadan sadece java ile nesneler ile layout oluşturuldu.
    // not: Alttaki yorum satırları ogrenirkenki calısmalarım
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ll=new LinearLayout(this);
        et=new EditText(this);
        et1=new EditText(this);
        t1=new TextView(this);
        t=new TextView(this);
        b=new Button(this);


        LinearLayout.LayoutParams boyutlar=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(boyutlar);


        LinearLayout.LayoutParams boyut=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        et.setLayoutParams(boyut);
        et1.setLayoutParams(boyut);
        t1.setLayoutParams(boyut);
        t.setLayoutParams(boyut);
        b.setLayoutParams(boyut);


        ll.setOrientation(LinearLayout.VERTICAL);


        t.setText(" AD:");
        t1.setText(" SOYAD:");
        b.setText("Click");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ad = et.getText().toString();
               soyad = et1.getText().toString();

                if (!TextUtils.isEmpty(ad) && !TextUtils.isEmpty(soyad)){
                    Toast.makeText(context,"Hoşgeldiniz " + ad +" "+soyad+".",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(context,R.string.ad_ve_soyadınızı_kontrol_ediniz,Toast.LENGTH_LONG).show();
                }
            }
        });

        ll.addView(t);
        ll.addView(et);
        ll.addView(t1);
        ll.addView(et1);
        ll.addView(b);



        setContentView(ll);

//        setContentView(R.layout.activity_main);
//
//
//
        // Burası açılıcak
//        txtSonuc = findViewById(R.id.textSonuc);
//        birinciGelen = findViewById(R.id.editText1);
//        ikinciGelen = findViewById(R.id.editText2);


        //  editText.setHint("Buraya yazacan");
        //  btn.setEnabled(false); tıklanabilirlik
        //  btn.setOnLongClickListener();
        //  editText.setBackgroundColor(Color.BLACK);

        // Fragmentlarda bu şekilde kullan
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String message = editText.getText().toString();
//                if (!TextUtils.isEmpty(message)) {
//                    txtMessage.setText(message);
//                } else {
//                    txtMessage.setText("Boş olamaz");
//                }
//
//            }
//        });

    }



//    public void btnHesaplaClick(View v) {
//        birinciSayi = birinciGelen.getText().toString();
//        ikinciSayi = ikinciGelen.getText().toString();
//
//
//        if (!TextUtils.isEmpty(birinciSayi) && !TextUtils.isEmpty(ikinciSayi)) {
//            s1 = Double.parseDouble(birinciSayi);
//            s2 = Double.parseDouble((ikinciSayi));
//            hesapla = new Hesapla(s1, s2);
//
//            switch (v.getId()) {
//                case R.id.btnTopla:
//                    sonuc = hesapla.topla();
//                    break;
//
//                case R.id.btnFark:
//                    sonuc = hesapla.fark();
//                    break;
//
//                case R.id.btnCarp:
//                    sonuc = hesapla.carp();
//                    break;
//
//                case R.id.btnBol:
//                    sonuc = hesapla.bol();
//                    break;
//
//            }
//
//
//            txtSonuc.setText("SONUÇ: " + Double.toString(sonuc));
//
//        } else {
//            txtSonuc.setText(R.string.bos_deger_girilemez);
//        }
//
//    }
//
//    public void btnHelloClick(View v){
//        ad = birinciGelen.getText().toString();
//        soyad = ikinciGelen.getText().toString();
//
//        if (!TextUtils.isEmpty(ad) && !TextUtils.isEmpty(soyad)){
//        Toast.makeText(context,"Hoşgeldiniz " + ad +" "+soyad+".",Toast.LENGTH_SHORT).show();
//
//        }else{
//        Toast.makeText(context,R.string.ad_ve_soyadınızı_kontrol_ediniz,Toast.LENGTH_SHORT).show();
//        }
//    }

//     Design kısmından click eventine bu metodun adını yazıp bunu kullanabilirsin
//     yukarıdakine alternatif olarak ama fragment larda üstteki gibi.bunu fragment da kullanma
//      public void btnClick(View view)
//     {
//         txtMessage.setText("btnClick fonksiyonu çalıştı.");
//     }
}