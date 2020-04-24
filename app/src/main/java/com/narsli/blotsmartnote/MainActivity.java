package com.narsli.blotsmartnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        ExtraButtonDialog.BottomSheetListener {
    private ArrayList<MastItem> mastList;
    private MastAdapter adapter;
    boolean banali_extraBtn = true;

        Integer order[] = {
                8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19,20,
                21, 22, 23, 24, 25, 26, 27, 28, 29,30,
                31, 32, 33, 34, 35, 36, 37, 38, 39,40,
                41, 42, 43, 44, 45, 46, 47, 48, 49,50,
                51, 52, 53, 54, 55, 56, 57, 58, 59,60,
                61, 62, 63, 64, 65, 66, 67, 68, 69,70,
                71, 72, 73, 74, 75, 76, 77, 78, 79,80,
                81
        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//inicializacia
//      extra Button xml-i elementneri inicializaica
        Button btn_1_ExtraBtn = findViewById(R.id.btn_1);
//-----------------------------------------------------------------
        initList();
        Spinner spinnerMasts = findViewById(R.id.spinner_masts);
//-----------------------------------------------------------------
        adapter = new MastAdapter(this, mastList);
        spinnerMasts.setAdapter(adapter);

      Spinner  spinner = findViewById(R.id.spinner_order);

        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, order);
//
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
//------------------
        spinnerMasts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    //--------------------------------------------------------------------
    // interfeysi metodi pereopreedlyactia
    @Override
    public void onButtonClicked(String text) {

        //mTextView.setText(text);
    }

    //_____________________________________________________________________
    private void initList() {
        mastList = new ArrayList<>();
        mastList.add(new MastItem(R.drawable.s_24));
        mastList.add(new MastItem(R.drawable.x_24));
        mastList.add(new MastItem(R.drawable.q_24));
        mastList.add(new MastItem(R.drawable.xar_24));
        mastList.add(new MastItem(R.drawable.t_24));
    }

    //------------------------------------------------------------
    public void open_extra_buttons(View view) {

//activity-ic dialog info poxancelu hamar e
        //        //mer sarqac interfeysi ekzempliar
            ExtraButtonDialog bottomSheet = new ExtraButtonDialog();
            bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");

    }

}
