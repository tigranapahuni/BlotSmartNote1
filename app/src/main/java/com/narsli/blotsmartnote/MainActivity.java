package com.narsli.blotsmartnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements
        ExtraButtonDialog.BottomSheetListener,
        ExtraOrderBtnDialog.BottomSheetListenerOrder {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//------------------


    }

    //--------------------------------------------------------------------
    // interfeysi metodi pereopreedlyactia
    @Override
    public void onButtonClicked(String text) {

        //mTextView.setText(text);
    }

    //_____________________________________________________________________

    //------------------------------------------------------------
    public void open_extra_buttons(View view) {

//activity-ic dialog info poxancelu hamar e
        //        //mer sarqac interfeysi ekzempliar
            ExtraButtonDialog bottomSheet = new ExtraButtonDialog();
            bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");

    }

    public void open_extra_Order_buttons(View view) {
        ExtraOrderBtnDialog bottomSheet = new ExtraOrderBtnDialog();
        bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
    }
}
