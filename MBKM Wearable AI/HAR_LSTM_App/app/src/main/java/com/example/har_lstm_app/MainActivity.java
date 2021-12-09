package com.example.har_lstm_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        //this will start python

        //now create python instance
        Python py = Python.getInstance();
        //now create python object
        final PyObject pyobj = py.getModule("helloworld"); //give python script name

//        //now call the function
//        PyObject obj = pyobj.callAttr("main");
//
//        //now set returned text to textview
//        textView.setText(obj.toString());

        int K=8*25;
        int DK=2*25;
        int i=0;
        int fin=0;
        int n=247151;

        while(fin < n - DK){

            int ind = i*DK;
            fin = ind+K;

            //now call the function
            PyObject obj = pyobj.callAttr("main", fin, ind, i);

            //now set returned text to textview
            textView.setText(obj.toString());

            i++;

        }
    }
}