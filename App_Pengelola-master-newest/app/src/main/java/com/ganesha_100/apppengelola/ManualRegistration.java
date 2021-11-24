package com.ganesha_100.apppengelola;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

public class ManualRegistration extends AppCompatActivity {

    private Button btn_endregistermanual;
    CalendarView calendarView;
    TextView tanggalpesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_registration);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        tanggalpesan = (TextView) findViewById(R.id.tanggalpesan);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i2 + "/" + (i1 + 1) + "/" + i;
                tanggalpesan.setText(date);
            }
        });

        btn_endregistermanual = (Button) findViewById(R.id.pesantempat_manual);
        btn_endregistermanual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManualRegistration.this, NavigasiDataPengunjung.class);
                startActivity(intent);
            }
        });

    }



}