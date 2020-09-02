package com.ganesha_100.apppengelola;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NavigasiDataPengunjung extends AppCompatActivity {

    ExpandableListView expandableListView ;
    List<String> listGroup;
    HashMap<String, List<String>> listItem;
    MainAdapter adapter;

    private static final String TAG = "NavigasiDataPengunjung";
    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigasi_data_pengunjung);

        // < bar chart >
        BarChart barChart = findViewById(R.id.barChart);
        ArrayList<BarEntry> visitor = new ArrayList<>();
        visitor.add(new BarEntry(35 , 120));
        visitor.add(new BarEntry(36 , 870));
        visitor.add(new BarEntry(37 , 420));
        visitor.add(new BarEntry(38 , 20));

        BarDataSet barDataSet = new BarDataSet(visitor, "Pengunjung");

        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Grafik Pengunjung");
        barChart.animateY(2000);
        // </ bar chart >


        // < pie chart >
        PieChart pieChart = findViewById(R.id.pieChart);
        ArrayList<PieEntry> day = new ArrayList<>();
        day.add(new PieEntry(1000, "Senin"));
        day.add(new PieEntry(800, "Selasa"));
        day.add(new PieEntry(950, "Rabu"));
        day.add(new PieEntry(700, "Kamis"));
        day.add(new PieEntry(1200, "Jumat"));
        day.add(new PieEntry(1550, "Sabtu"));
        day.add(new PieEntry(1800, "Minggu"));

        PieDataSet pieDataSet = new PieDataSet(day, "Hari");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Jumlah Pengunjung Per Hari");
        pieChart.animate();
        // </ pie chart >


        // < line chart >
        mChart = (LineChart) findViewById(R.id.lineChart);

//        mChart.setOnChartGestureListener(NavigasiDataPengunjung.this);
//        mChart.setOnChartValueSelectedListener(NavigasiDataPengunjung.this);

        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();

        yValues.add(new Entry(8, 20 ));
        yValues.add(new Entry(9, 50 ));
        yValues.add(new Entry(10, 180 ));
        yValues.add(new Entry(11, 350 ));
        yValues.add(new Entry(12, 460 ));
        yValues.add(new Entry(13, 740 ));
        yValues.add(new Entry(14, 980 ));
        yValues.add(new Entry(15, 260 ));
        yValues.add(new Entry(16, 10 ));

        LineDataSet set1 = new LineDataSet(yValues , "Jumlah Pengunjung");
        set1.setFillAlpha(110);

        set1.setColor(Color.MAGENTA);
        set1.setLineWidth(3f);
        set1.setValueTextSize(20f);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        mChart.setData(data);




        //// < Expandable list view>
        // 1st
        expandableListView = findViewById(R.id.expandable_listview);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this , listGroup , listItem);
        expandableListView.setAdapter(adapter);
        initListData();


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                final String selected = (String) adapter.getChild(groupPosition , childPosition);

                Intent intent ;

                switch (selected){
                    case "Pengunjung 1":
                        intent = new Intent(NavigasiDataPengunjung.this , HalamanDetailProfil.class );
                        startActivity(intent);
                        break;
                    case "Pengunjung 2":
                        intent = new Intent(NavigasiDataPengunjung.this , HalamanDetailProfil.class );
                        startActivity(intent);
                        break;
                    case "Pengunjung 3":
                        intent = new Intent(NavigasiDataPengunjung.this , HalamanDetailProfil.class );
                        startActivity(intent);
                        break;
                    case "Pengunjung 4":
                        intent = new Intent(NavigasiDataPengunjung.this , HalamanDetailProfil.class );
                        startActivity(intent);
                        break;
                    case "Pengunjung 5":
                        intent = new Intent(NavigasiDataPengunjung.this , HalamanDetailProfil.class );
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        //// < bottom navigation >
        // inisialisasi dan assign variabel
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Atur navigasi/halaman, yang sedang dipilih
        /* id disesuaikan dg id tombol yg digunakan utk menuju ke navigasi/halaman ini */
        bottomNavigationView.setSelectedItemId(R.id.datapengunjung);

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
                        startActivity(new Intent(getApplicationContext()
                                , NavigasiProfileRuangPublik.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.datapengunjung:
                        return true;
                }
                return false;
            }
        });
        //// </ bottom navgiation >
    }

    private void initListData(){
        listGroup.add(getString(R.string.group1));
        listGroup.add(getString(R.string.group2));
        listGroup.add(getString(R.string.group3));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group1);
        for (String item : array){
            list1.add(item);
        }

        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group2);
        for (String item : array){
            list2.add(item);
        }

        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group3);
        for (String item : array){
            list3.add(item);
        }

        listItem.put(listGroup.get(0) , list1);
        listItem.put(listGroup.get(1) , list2);
        listItem.put(listGroup.get(2) , list3);
        adapter.notifyDataSetChanged();
    }
}
