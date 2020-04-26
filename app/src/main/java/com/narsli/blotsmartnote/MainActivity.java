package com.narsli.blotsmartnote;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements
        ExtraButtonDialog.BottomSheetListener,
        ExtraOrderBtnDialog.BottomSheetListenerOrder {
    private TextView txtView_order;
    private ImageView Img_mast;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//------------------
        txtView_order = findViewById(R.id.txtView_order);
        Img_mast = findViewById(R.id.Img_mast);
////--------------------------------------------------------------------------
//        //dialog
//        dialog=new Dialog(this);//stexcum enq dialog
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//anjatum enq vernagirn
//        dialog.setContentView(R.layout.chors_tuxt_dialog);//kpcnum enq razmetkain(maketin)
//        //dialog-i foni hetevn lini tapancik
//        // dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////asum enq dialogi mej inch ka et chaperov el lini dilaogn
////         dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
////                 WindowManager.LayoutParams.MATCH_PARENT);
//        dialog.setCancelable(false);//nazad knopkan anjatum enq
//
//
////        layout=findViewById(R.id.layout);
//
////-------------------------------------------------------------------------


    }

    //    public void aaa(View view) {
//        dialog.show();
//    }
//
//    public void as(View view) {
//        dialog.dismiss();
//    }
    //--------------------------------------------------------------------
    // interfeysi metodi pereopreedlyactia
    @Override
    public void onButtonClicked(String text) {

        //mTextView.setText(text);
    }

    public void orderon_onButtonClicked(int mast, String order) {
        txtView_order.setText(order);
        switch (mast) {
            case 0:
                Img_mast.setImageResource(R.drawable.x_24);
                break;
            case 1:
                Img_mast.setImageResource(R.drawable.s_24);
                break;
            case 2:
                Img_mast.setImageResource(R.drawable.xar_24);
                break;
            case 3:
                Img_mast.setImageResource(R.drawable.q_24);
                break;
            default:
                Img_mast.setImageResource(R.drawable.t_24);
                break;
        }
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

        try {
            ExtraOrderBtnDialog bottomSheet = new ExtraOrderBtnDialog();
            bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
        } catch (ClassCastException e) {
            throw new ClassCastException();
        }

    }
}
