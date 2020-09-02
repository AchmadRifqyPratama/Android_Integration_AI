package com.ganesha_100.apppengelola;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigasiProfileRuangPublik extends AppCompatActivity {

    private Button restocksouvenir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigasi_profile_ruang_publik);

        //// < bottom navigation >
        // inisialisasi dan assign variabel
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Atur navigasi/halaman, yang sedang dipilih
        /* id disesuaikan dg id tombol yg digunakan utk menuju ke navigasi/halaman ini */
        bottomNavigationView.setSelectedItemId(R.id.profil);

        // gunain ItemSelectedListener
        /* 1. setiap case perlu di sesuaikan dg isi aplikasi
        2. setiap .class dalam startActivity perlu di sesuaikan dg isi aplikasi
        3. case dengan kembalian hanya return true , digunakan pada id tombol halaman ini,
        case lainnya menggunakan start activity dan override*/
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , NavigasiHome.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profil:
                        return true;
                    case R.id.datapengunjung:
                        startActivity(new Intent(getApplicationContext()
                                , NavigasiDataPengunjung.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        initView();
        setData();
        //// </ bottom navgiation >
    }

    private void initView() {
        restocksouvenir = (Button) findViewById(R.id.restocksouvenir);
    }

    private void setData() {
        restocksouvenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavigasiProfileRuangPublik.this,RestockSouvenir.class);
                startActivity(intent);
            }
        });
    }
}
