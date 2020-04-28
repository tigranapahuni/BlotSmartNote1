package com.narsli.blotsmartnote;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements
        ExtraButtonDialog.BottomSheetListener,
        ExtraOrderBtnDialog.BottomSheetListenerOrder,
        View.OnClickListener {
    //_____________________________________________________________________
//--------------------------- POPOXAKANNER ----------------------------
    private TextView txtView_kom1, txtView_kom2, txtView_order;
    private ImageView Img_mast;
//    private Dialog dialog;
//_____________________________________________________________________
//___________________________menu popoxakanner ________________________

    FloatingActionButton fabMain, fabOne, fabTwo, fabThree;
    Float translationY = 100f;

    OvershootInterpolator interpolator = new OvershootInterpolator();

    private static final String TAG = "MainActivity";

    Boolean isMenuOpen = false;

    //_____________________________________________________________________
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//-----------------------------------------------------
//mneu ininializacia

        initFabMenu();
//------------------
        txtView_order = findViewById(R.id.txtView_order);
        txtView_kom1 = findViewById(R.id.txtView_kom1);
        txtView_kom2 = findViewById(R.id.txtView_kom2);
        Img_mast = findViewById(R.id.Img_mast);

        // txtView_kom1.setText("kom1_kom2_miavor");
        // txtView_kom1.setText("kom1_kom2_miavor");
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
    public void onButtonClicked(String kom1_kom2_miavor) {

        txtView_kom1.setText(kom1_kom2_miavor);
        txtView_kom2.setText(kom1_kom2_miavor);
    }

    //-----------------------------------------------------------------------------
    public void order_OnButtonClicked(int mast, String order) {
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

    //-------------------------------------------------------------------------
//_________________________________________________________________________
//------------------------------- MENU  -----------------------------------
    private void initFabMenu() {
        fabMain = findViewById(R.id.fabMain);
        fabOne = findViewById(R.id.fabOne);
        fabTwo = findViewById(R.id.fabTwo);
        fabThree = findViewById(R.id.fabThree);

        fabOne.setAlpha(0f);
        fabTwo.setAlpha(0f);
        fabThree.setAlpha(0f);

        fabOne.setTranslationY(translationY);
        fabTwo.setTranslationY(translationY);
        fabThree.setTranslationY(translationY);

        fabMain.setOnClickListener(this);
        fabOne.setOnClickListener(this);
        fabTwo.setOnClickListener(this);
        fabThree.setOnClickListener(this);
    }

    private void openMenu() {
        isMenuOpen = !isMenuOpen;

        fabMain.animate().setInterpolator(interpolator).rotation(45f).setDuration(300).start();

        fabOne.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabTwo.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabThree.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();


    }

    private void closeMenu() {
        isMenuOpen = !isMenuOpen;

        fabMain.animate().setInterpolator(interpolator).rotation(0f).setDuration(300).start();

        fabOne.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabTwo.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabThree.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();

    }

    private void handleFabOne() {
        Log.i(TAG, "handleFabOne: ");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabMain:
                //  Log.i(TAG, "onClick: fab main");
                if (isMenuOpen) {
                    closeMenu();
                } else {
                    openMenu();
                }
                break;
            case R.id.fabOne:
                // Log.i(TAG, "onClick: fab one");
                handleFabOne();
                if (isMenuOpen) {
                    closeMenu();
                } else {
                    openMenu();
                }
                break;
            case R.id.fabTwo:
                //  Log.i(TAG, "onClick: fab two");
                break;
            case R.id.fabThree:
                //Log.i(TAG, "onClick: fab three");
                break;
        }

    }
//_________________________________________________________________________

}
