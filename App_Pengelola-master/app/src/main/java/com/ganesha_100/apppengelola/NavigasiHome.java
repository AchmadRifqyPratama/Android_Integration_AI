package com.ganesha_100.apppengelola;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import id.co.telkom.iot.AntaresHTTPAPI;
import id.co.telkom.iot.AntaresResponse;

public class NavigasiHome extends AppCompatActivity implements AntaresHTTPAPI.OnResponseListener {

    ListView listView;

    Button btn_refresh;

    private TextView txtDataPackage;
    private String TAG = "ANTARES-API";
    private AntaresHTTPAPI antaresAPIHTTP;
    private String dataDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigasi_home);


        // --- Inisialisasi UI yang digunakan di aplikasi --- //
        btn_refresh = (Button) findViewById(R.id.pl_nh_refresh);
        txtDataPackage = (TextView) findViewById(R.id.txtDataPackage);

        // --- Inisialisasi API Antares --- //
        //antaresAPIHTTP = AntaresHTTPAPI.getInstance();
        antaresAPIHTTP = new AntaresHTTPAPI();
        antaresAPIHTTP.addListener(this);

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                antaresAPIHTTP.getLatestDataofDevice(
                        "7ff45cdf40062326:e176a49bb4d95deb",
                        "SmartDrone20",
                        "TesDevice");
            }
        });

        //// < Listview >
        // 1st step
        listView = (ListView) findViewById(R.id.listView);

        //2nd step , inisialisasi array
        ArrayList<String> arrayList = new ArrayList<>();

        // 3rd step, buat list nya
        arrayList.add("Pemesan 1");
        arrayList.add("Pemesan 2");
        arrayList.add("Pemesan 3");

        // 4th step
        ArrayAdapter arrayAdapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 , arrayList);
        listView.setAdapter(arrayAdapter);
        //// </ Listview >

        final Intent[] intent = new Intent[1];
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    intent[0] = new Intent(NavigasiHome.this , HalamanRincianPemesanan.class );
                    startActivity(intent[0]);
                }
                if (position == 1){
                    intent[0] = new Intent(NavigasiHome.this , HalamanRincianPemesanan.class );
                    startActivity(intent[0]);
                }
                if (position == 2){
                    intent[0] = new Intent(NavigasiHome.this , HalamanRincianPemesanan.class );
                    startActivity(intent[0]);
                }
            }
        });


        //// < bottom navigation >
        // inisialisasi dan assign variabel
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Atur navigasi/halaman, yang sedang dipilih
        /* id disesuaikan dg id tombol yg digunakan utk menuju ke navigasi/halaman ini */
        bottomNavigationView.setSelectedItemId(R.id.home);

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
                        return true;
                    case R.id.profil:
                        startActivity(new Intent(getApplicationContext()
                                , NavigasiProfileRuangPublik.class));
                        overridePendingTransition(0, 0);
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
        //// </ bottom navgiation >
    }

    @Override
    public void onResponse(AntaresResponse antaresResponse) {
        // --- Cetak hasil yang didapat dari ANTARES ke System Log --- //
        //Log.d(TAG,antaresResponse.toString());
        Log.d(TAG,Integer.toString(antaresResponse.getRequestCode()));
        if(antaresResponse.getRequestCode()==0){
            try {
                JSONObject body = new JSONObject(antaresResponse.getBody());
                dataDevice = body.getJSONObject("m2m:cin").getString("con");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtDataPackage.setText(dataDevice);
                    }
                });
                Log.d(TAG,dataDevice);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
