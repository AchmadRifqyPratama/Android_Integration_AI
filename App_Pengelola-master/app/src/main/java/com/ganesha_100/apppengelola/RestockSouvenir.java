package com.ganesha_100.apppengelola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RestockSouvenir extends AppCompatActivity {

    private Button edit_souvenir, edit2_souvenir, edit3_souvenir, hapus_souvenir, hapus2_souvenir, hapus3_souvenir, tambah_souvenir;
    private TextView txtJudul1,txtJudul2,txtJudul3,txtDeskripsi1,txtDeskripsi2,txtDeskripsi3,txtjmlstockdisplay1,txtjmlstockdisplay2,txtjmlstockdisplay3;
    //private String judul1,judul2,judul3,deskripsi1,deskripsi2,deskripsi3,jmlstockdisplay1,jmlstockdisplay2,jmlstockdisplay3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock_souvenir);
        initView();
        setData();
    }

    private void initView() {
        txtJudul1 = (TextView) findViewById(R.id.judul1);
        txtJudul2 = (TextView) findViewById(R.id.judul2);
        txtJudul3 = (TextView) findViewById(R.id.judul3);
        txtDeskripsi1 = (TextView) findViewById(R.id.deskripsi1);
        txtDeskripsi2 = (TextView) findViewById(R.id.deskripsi2);
        txtDeskripsi3 = (TextView) findViewById(R.id.deskripsi3);
        txtjmlstockdisplay1 = (TextView) findViewById(R.id.jmlstockdisplay);
        txtjmlstockdisplay2 = (TextView) findViewById(R.id.jmlstockdisplay2);
        txtjmlstockdisplay3 = (TextView) findViewById(R.id.jmlstockdisplay3);
        edit_souvenir = (Button) findViewById(R.id.edit_item);
        edit2_souvenir = (Button) findViewById(R.id.edit2_item);
        edit3_souvenir = (Button) findViewById(R.id.edit3_item);
        hapus_souvenir = (Button) findViewById(R.id.hapus_item);
        hapus2_souvenir = (Button) findViewById(R.id.hapus2_item);
        hapus3_souvenir = (Button) findViewById(R.id.hapus3_item);
        tambah_souvenir = (Button) findViewById(R.id.tambah_souvenir);
    }

    private void setData() {
        edit_souvenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(RestockSouvenir.this,EditSouvenir.class);
//                //intent1 = getIntent();
                String judul1 = getIntent().getStringExtra("Judul");
                txtJudul1.setText(judul1);
//                //intent1 = getIntent();
                String deskripsi1 = getIntent().getStringExtra("Deskripsi");
                txtDeskripsi1.setText(deskripsi1);
//                //intent1 = getIntent();

                String jmlstockdisplay1 = getIntent().getStringExtra("JumlahStock");
                txtjmlstockdisplay1.setText(jmlstockdisplay1);
                startActivity(intent1);
            }
        });
        edit2_souvenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(RestockSouvenir.this,EditSouvenir.class);
                //intent2 = getIntent();
                String judul2 = getIntent().getStringExtra("Judul");
                txtJudul2.setText(judul2);
                //intent2 = getIntent();
                String deskripsi2 = getIntent().getStringExtra("Deskripsi");
                txtDeskripsi2.setText(deskripsi2);
                //intent2 = getIntent();
                String jmlstockdisplay2 = getIntent().getStringExtra("JumlahStock");
                txtjmlstockdisplay2.setText(jmlstockdisplay2);
                startActivity(intent2);
            }
        });
        edit3_souvenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(RestockSouvenir.this,EditSouvenir.class);
                //intent3 = getIntent();
                String judul3 = getIntent().getStringExtra("Judul");
                txtJudul3.setText(judul3);
                //intent3 = getIntent();
                String deskripsi3 = getIntent().getStringExtra("Deskripsi");
                txtDeskripsi3.setText(deskripsi3);
                //intent3 = getIntent();
                String jmlstockdisplay3 = getIntent().getStringExtra("JumlahStock");
                txtjmlstockdisplay3.setText(jmlstockdisplay3);
                startActivity(intent3);
            }
        });
        hapus_souvenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestockSouvenir.this, "Produk Berhasil Dihapus" , Toast.LENGTH_LONG).show();
            }
        });
        hapus2_souvenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestockSouvenir.this, "Produk Berhasil Dihapus" , Toast.LENGTH_LONG).show();
            }
        });
        hapus3_souvenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestockSouvenir.this, "Produk Berhasil Dihapus" , Toast.LENGTH_LONG).show();
            }
        });
        tambah_souvenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RestockSouvenir.this,EditSouvenir.class);
                startActivity(intent);
            }
        });
    }

//    public void setData2(){
//
//        Intent intent = getIntent();
//        judul1 = intent.getStringExtra("Judul1");
//        txtJudul1.setText(judul1);
//        intent = getIntent();
//        judul2 = intent.getStringExtra("Judul2");
//        txtJudul2.setText(judul2);
//        intent = getIntent();
//        judul3 = intent.getStringExtra("Judul3");
//        txtJudul3.setText(judul3);
//        intent = getIntent();
//        deskripsi1 = intent.getStringExtra("Deskripsi1");
//        txtDeskripsi1.setText(deskripsi1);
//        intent = getIntent();
//        deskripsi2 = intent.getStringExtra("Deskripsi2");
//        txtDeskripsi2.setText(deskripsi2);
//        intent = getIntent();
//        deskripsi3 = intent.getStringExtra("Deskripsi3");
//        txtDeskripsi3.setText(deskripsi3);
//        intent = getIntent();
//        jmlstockdisplay1 = intent.getStringExtra("JumlahStock1");
//        txtjmlstockdisplay1.setText(jmlstockdisplay1);
//        intent = getIntent();
//        jmlstockdisplay2 = intent.getStringExtra("JumlahStock2");
//        txtjmlstockdisplay2.setText(jmlstockdisplay2);
//        intent = getIntent();
//        jmlstockdisplay3 = intent.getStringExtra("JumlahStock3");
//        txtjmlstockdisplay3.setText(jmlstockdisplay3);
//    }

}