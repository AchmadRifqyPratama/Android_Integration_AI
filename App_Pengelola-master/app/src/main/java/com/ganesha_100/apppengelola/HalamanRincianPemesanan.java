package com.ganesha_100.apppengelola;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import id.co.telkom.iot.AntaresHTTPAPI;
import id.co.telkom.iot.AntaresResponse;

public class HalamanRincianPemesanan extends AppCompatActivity implements AntaresHTTPAPI.OnResponseListener, View.OnClickListener {

    Button tolakpesanan, terimapesanan;

    private String TAG = "ANTARES-API";
    private AntaresHTTPAPI antaresAPIHTTP;
    private String dataDevice;
    String jumlah_pengunjung = "3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_rincian_pemesanan);

        tolakpesanan = findViewById(R.id.pl_rp_tolakpesanan);
        tolakpesanan.setOnClickListener(this);

        // --- Inisialisasi UI yang digunakan di aplikasi --- //
        terimapesanan = (Button) findViewById(R.id.pl_rp_terimapesanan);

        // --- Inisialisasi API Antares --- //
        //antaresAPIHTTP = AntaresHTTPAPI.getInstance();
        antaresAPIHTTP = new AntaresHTTPAPI();
        antaresAPIHTTP.addListener(this);

//        terimapesanan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String string_baru = String.format("{\\\"%1$s Pengunjung\\\"}", jumlah_pengunjung);
//                antaresAPIHTTP.storeDataofDevice(1,
//                        "7ff45cdf40062326:e176a49bb4d95deb",
//                        "SmartDrone20",
//                        "TesDevice",
//                        string_baru);
//
//            }
//        });

        terimapesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                antaresAPIHTTP.storeDataofDevice(1,
                        "7ff45cdf40062326:e176a49bb4d95deb",
                        "SmartDrone20",
                        "TesDevice",
                        "{\\\"175 Pengunjung\\\"}");

            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(HalamanRincianPemesanan.this , "Pesanan Ditolak" , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(AntaresResponse antaresResponse) {

    }
}
