package com.example.android.farhanputrariantono_1202150098_si3902;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void NameList (View view){
        Intent x = new Intent(getApplicationContext() MainActivity.this, Home.class);
        startActivity(x);
    }

    public void ImageList (View view){
        Intent y = new Intent(getApplicationContext MainActivity.this, Gambar.class);
        startActivity(y);
    }



}
