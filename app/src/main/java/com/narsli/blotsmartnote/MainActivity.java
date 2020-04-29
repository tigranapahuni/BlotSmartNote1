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
    private TextView
            txtView_kom1, txtView_kom2, txtView_order,
            igrok1_D, igrok2_D, igrok3_D, igrok4_D;
    private ImageView Img_mast;
    byte kom1_kom2, kom1_kom2_xosacele;
    int mast;
    String order;

//_____________________________________________________________________
//___________________________menu popoxakanner ________________________

    FloatingActionButton fabMain, fabOne, fabTwo, fabThree, fabFour;
    TextView fabTextNg, fabTextEng, fabTextTheme, fabTextShare;
    Float translationY = 100f;

    OvershootInterpolator interpolator = new OvershootInterpolator();

    private static final String TAG = "MainActivity";

    Boolean isMenuOpen = false;
    private TextView txtView_Team1, txtView_Team2, txtView_zakaz;
    boolean team1Team2_Zakaz_banali = true;//true=bacel zakazn, false bacel team1 or team2
    int igrok_ochered = 1;


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


        txtView_Team1 = findViewById(R.id.txtView_Team1);
        txtView_Team2 = findViewById(R.id.txtView_Team2);
        txtView_zakaz = findViewById(R.id.txtView_zakaz);

        igrok1_D = findViewById(R.id.igrok1_D);
        igrok2_D = findViewById(R.id.igrok2_D);
        igrok3_D = findViewById(R.id.igrok3_D);
        igrok4_D = findViewById(R.id.igrok4_D);
//--------------------------------------------------------------------------
        igrok2_D.setVisibility(View.INVISIBLE);
        igrok3_D.setVisibility(View.INVISIBLE);
        igrok4_D.setVisibility(View.INVISIBLE);
//--------------------------------------------------------------------------
    }

    //--------------------------------------------------------------------
    // interfeysi metodi pereopreedlyactia
    @Override
    public void onButtonClicked(String kom1_kom2_miavor) {
        if (kom1_kom2 == 1)
            txtView_kom1.setText(kom1_kom2_miavor);
        else
            txtView_kom2.setText(kom1_kom2_miavor);
    }

    //-----------------------------------------------------------------------------
//ays metodn mianum e useri order-n uzeluc heto(zakaz knopkai vra sexmeluc heto)
    public void order_OnButtonClicked(byte kom1_kom2_xosacele, int mast, String order) {
        this.kom1_kom2_xosacele = kom1_kom2_xosacele;
        this.mast = mast;//tvysl oyini mastn e
        this.order = order;//tvyal oyini xosacac tivn e
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
//ays metodn mianum e useri Team1-n sexmeluc heto
    public void open_extra_buttons_Team1(View view) {
        kom1_kom2 = 1;
//activity-ic dialog info poxancelu hamar e
        //        //mer sarqac interfeysi ekzempliar
        ExtraButtonDialog bottomSheet = new ExtraButtonDialog(kom1_kom2, mast, order);
        bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
        if (igrok_ochered == 4)
            igrok_ochered = 1;
        else
            igrok_ochered++;
    }

    //------------------------------------------------------------------------------
//ays metodn mianum e useri Team2-n sexmeluc heto
    public void open_extra_buttons_Team2(View view) {
        kom1_kom2 = 2;
//activity-ic dialog info poxancelu hamar e
        //        //mer sarqac interfeysi ekzempliar
        ExtraButtonDialog bottomSheet = new ExtraButtonDialog(kom1_kom2, mast, order);
        bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");

        if (igrok_ochered == 4)
            igrok_ochered = 1;
        else
            igrok_ochered++;
    }

    //------------------------------------------------------------
    public void open_extra_Order_buttons(View view) {

        try {
            ExtraOrderBtnDialog bottomSheet = new ExtraOrderBtnDialog();
            bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
        } catch (ClassCastException e) {
            throw new ClassCastException();
        }
//        txtView_Team1, txtView_Team2,txtView_zakaz
        if (team1Team2_Zakaz_banali == true)//
        {
            txtView_zakaz.setBackgroundResource(R.color.colorBlack);
            txtView_Team1.setBackgroundResource(R.color.colorRed);
            txtView_Team2.setBackgroundResource(R.color.colorRed);
//            anjatum enq useri hamar zakazi hnaravorutyunn
//            txtView_zakaz.setFocusable(false);
//            txtView_zakaz.setEnabled(false);

            txtView_Team1.setFocusable(true);
            txtView_Team1.setEnabled(true);

            txtView_Team2.setFocusable(true);
            txtView_Team2.setEnabled(true);
            team1Team2_Zakaz_banali = !team1Team2_Zakaz_banali;

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
        fabFour = findViewById(R.id.fabFour);
        fabTextNg = findViewById(R.id.fabTextNg);
        fabTextEng = findViewById(R.id.fabTextEng);
        fabTextTheme = findViewById(R.id.fabTextTheme);
        fabTextShare = findViewById(R.id.fabTextShare);







        fabOne.setAlpha(0f);
        fabTwo.setAlpha(0f);
        fabThree.setAlpha(0f);
        fabFour.setAlpha(0f);
        fabTextNg.setAlpha(0f);
        fabTextEng.setAlpha(0f);
        fabTextTheme.setAlpha(0f);
        fabTextShare.setAlpha(0f);


        fabOne.setTranslationY(translationY);
        fabTwo.setTranslationY(translationY);
        fabThree.setTranslationY(translationY);
        fabFour.setTranslationY(translationY);
        fabTextNg.setTranslationY(translationY);
        fabTextEng.setTranslationY(translationY);
        fabTextTheme.setTranslationY(translationY);
        fabTextShare.setTranslationY(translationY);

        fabMain.setOnClickListener(this);
        fabOne.setOnClickListener(this);
        fabTwo.setOnClickListener(this);
        fabThree.setOnClickListener(this);
        fabFour.setOnClickListener(this);
        fabTextNg.setOnClickListener(this);
        fabTextEng.setOnClickListener(this);
        fabTextTheme.setOnClickListener(this);
        fabTextShare.setOnClickListener(this);
    }

    private void openMenu() {
        isMenuOpen = !isMenuOpen;

        fabMain.animate().setInterpolator(interpolator).rotation(45f).setDuration(300).start();

        fabOne.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabTwo.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabThree.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabFour.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabTextNg.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabTextEng.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabTextTheme.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        fabTextShare.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();


    }

    private void closeMenu() {
        isMenuOpen = !isMenuOpen;

        fabMain.animate().setInterpolator(interpolator).rotation(0f).setDuration(300).start();

        fabOne.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabTwo.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabThree.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabFour.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabTextNg.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabTextEng.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabTextTheme.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        fabTextShare.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();


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
            case R.id.fabFour:
                //Log.i(TAG, "onClick: fab four");
                break;
            case R.id.fabTextNg:
                //Log.i(TAG, "onClick: fab four");
                break;
            case R.id.fabTextEng:
                //Log.i(TAG, "onClick: fab four");
                break;
            case R.id.fabTextTheme:
                //Log.i(TAG, "onClick: fab four");
                break;
            case R.id.fabTextShare:
                //Log.i(TAG, "onClick: fab four");
                break;
        }

    }

//_________________________________________________________________________

}
