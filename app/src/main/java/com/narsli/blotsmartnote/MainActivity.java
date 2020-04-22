package com.narsli.blotsmartnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MastItem> mastList;
//    private MastAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();
        Spinner spinnerCountries = findViewById(R.id.spinner_masts);

//        adapter = new MastAdapter(this, mastList);
//        spinnerCountries.setAdapter(adapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MastItem clickedItem = (MastItem) parent.getItemAtPosition(position);
             //   Toast.makeText(MainActivity.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
//_____________________________________________________________________
    private void initList() {
        mastList = new ArrayList<>();
        mastList.add(new MastItem( R.drawable.s_24));
        mastList.add(new MastItem( R.drawable.x_24));
        mastList.add(new MastItem( R.drawable.q_24));
        mastList.add(new MastItem( R.drawable.t_24));
        mastList.add(new MastItem( R.drawable.xar_24));
    }
}
