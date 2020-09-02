package com.ganesha_100.apppengelola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditSouvenir extends AppCompatActivity {

    private Button btn_endrestock;
    private EditText namasouvenir, deskripsisouvenir, jumlahstock, hargaperunit;
    //private String Judul1,Judul2,Judul3,Deskripsi1,Deskripsi2,Deskripsi3,JumlahStock1,HargaperUnit1,JumlahStock2,HargaperUnit2,JumlahStock3,HargaperUnit3;
    //private String judul,deskripsi,jumlahstockavailable,hargaperunitnew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_souvenir);
        initView();
        setData();
    }
    public void initView(){
        btn_endrestock = (Button) findViewById(R.id.btn_endrestock);
        namasouvenir = (EditText) findViewById(R.id.namasouvenir);
        deskripsisouvenir = (EditText) findViewById(R.id.deskripsisouvenir);
        jumlahstock = (EditText) findViewById(R.id.jumlahstock);
        hargaperunit = (EditText) findViewById(R.id.hargaperunit);
    }

    public void setData(){
        btn_endrestock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String judul = namasouvenir.getText().toString();
                String deskripsiproduk = deskripsisouvenir.getText().toString();
                String jumlahavailable = jumlahstock.getText().toString();
                String hargaunit = hargaperunit.getText().toString();

                Intent intent = new Intent(EditSouvenir.this,NavigasiProfileRuangPublik.class);
                intent.putExtra("Judul", judul);
                intent.putExtra("Deskripsi", deskripsiproduk);
                intent.putExtra("JumlahStock", jumlahavailable);
                intent.putExtra("HargaUnit", hargaunit);
                startActivity(intent);
            }
        });
    }


//    public void setData(){
//        btn_endrestock.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent2 = new Intent(EditSouvenir.this, RestockSouvenir.class);
//                //intent2 = getIntent();
//                Judul1 = namasouvenir.getText().toString();
//                intent2.putExtra("Judul1",Judul1);
//
//                //intent2 = getIntent();
//                Judul2 = namasouvenir.getText().toString();
//                intent2.putExtra("Judul2",Judul2);
//
//                //intent2 = getIntent();
//                Judul3 = namasouvenir.getText().toString();
//                intent2.putExtra("Judul3",Judul3);
//
//                //intent2 = getIntent();
//                Deskripsi1 = deskripsisouvenir.getText().toString();
//                intent2.putExtra("Deskripsi1",Deskripsi1);
//
//                //intent2 = getIntent();
//                Deskripsi2 = deskripsisouvenir.getText().toString();
//                intent2.putExtra("Deskripsi2",Deskripsi2);
//
//                //intent2 = getIntent();
//                Deskripsi3 = deskripsisouvenir.getText().toString();
//                intent2.putExtra("Deskripsi3",Deskripsi3);
//
//                //intent2 = getIntent();
//                JumlahStock1 = jumlahstock.getText().toString();
//                intent2.putExtra("JumlahStock1",JumlahStock1);
//
//                //intent2 = getIntent();
//                JumlahStock2 = jumlahstock.getText().toString();
//                intent2.putExtra("JumlahStock2",JumlahStock2);
//
//                //intent2 = getIntent();
//                JumlahStock3 = jumlahstock.getText().toString();
//                intent2.putExtra("JumlahStock3",JumlahStock3);
//
//                //intent2 = getIntent();
//                HargaperUnit1 = hargaperunit.getText().toString();
//                intent2.putExtra("HargaperUnit1",HargaperUnit1);
//
//                //intent2 = getIntent();
//                HargaperUnit2 = hargaperunit.getText().toString();
//                intent2.putExtra("HargaperUnit2",HargaperUnit2);
//
//                //intent2 = getIntent();
//                HargaperUnit3 = hargaperunit.getText().toString();
//                intent2.putExtra("HargaperUnit3",HargaperUnit3);
//
//                startActivity(intent2);
//            }
//        });
//    }

//    public void setData(){
//        btn_endrestock.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent2 = new Intent(EditSouvenir.this, RestockSouvenir.class);
//                //intent2 = getIntent();
//                judul = namasouvenir.getText().toString();
//                intent2.putExtra("Judul",judul);
//                //intent2 = getIntent();
//                deskripsi = deskripsisouvenir.getText().toString();
//                intent2.putExtra("Deskripsi",deskripsi);
//                //intent2 = getIntent();
//                jumlahstockavailable = jumlahstock.getText().toString();
//                intent2.putExtra("JumlahStock",jumlahstockavailable);
//                //intent2 = getIntent();
//                hargaperunitnew = hargaperunit.getText().toString();
//                intent2.putExtra("HargaperUnit",hargaperunitnew);
//                startActivity(intent2);
//            }
//        });
//    }

}