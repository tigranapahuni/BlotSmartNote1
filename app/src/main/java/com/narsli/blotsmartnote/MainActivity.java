package com.narsli.blotsmartnote;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.narsli.blotsmartnote.Adapter.HashivAdapter;
import com.narsli.blotsmartnote.Adapter.RecyclerViewAdapter;
import com.narsli.blotsmartnote.Data.HashivAppDatabase;
import com.narsli.blotsmartnote.Model.BloteNote;
import com.narsli.blotsmartnote.Model.RecyclerViewItem;

import java.util.ArrayList;

//--------------------------------------------------------------

//-------------------------------------------------------------
public class MainActivity extends AppCompatActivity implements
        ExtraButtonDialog.BottomSheetListener,
        ExtraOrderBtnDialog.BottomSheetListenerOrder,
        View.OnClickListener {
    //_____________________________________________________________________
//--------------------------- POPOXAKANNER DB-ov----------------------------
    private HashivAdapter hashivnerAdapter;
    private ArrayList<BloteNote> hashivArrayList = new ArrayList<>();
    private RecyclerView recyclerView_hashiv;
    //mer koxmic sarqac clasi ekzempliar
    private HashivAppDatabase hashivsAppDatabase;


    //--------------------------- POPOXAKANNER ----------------------------
    private TextView
            txtView_kom1, txtView_kom2, txtView_order,
            igrok1_D, igrok2_D, igrok3_D, igrok4_D;
    private ImageView Img_mast;
    byte kom1_kom2, kom1_kom2_xosacele;
    int mast;
    String order;
    private LinearLayout resultLayout;
    private TextView textView_Kom1_New, textView_Kom2_New;

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
//------------------------------ RecyvleView --------------------------

    //ays popoxakannern petq en vorpeszi razmetkai vra-i RecyclerView-ern
//    kapenq java kodi het
    private RecyclerView recyclerView;
    //adaptern nman e mosti vorn kapum e tvyalnern RecyclerView-i het
    // henc adaptern e vor RecyclerView-n listview-i nkatmamb aravelutyun e sarqum \
    // aysinqn  adaptern amboxj elemntnernn chi lcnum RecyclerView-i mej ayl miayn el
    // elementnern voronq hima user-n tesnum e ev mi qani hat harevan.
    private RecyclerView.Adapter adapter;
    //    xekavarum e elementneri dirq layout-i vra
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<RecyclerViewItem> recyclerViewItem;

    //_____________________________________________________________________
//_____________________________________________________________________
//----------------------------DB -RecyvleView Strart-------------------

    //_____________________________________________________________________
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        resultLayout = findViewById(R.id.ResultLayout);

        // createNewLineHashiv();
//_____________________________________________________________________
//_____________________________________________________________________
//------------------------------ RecyvleView --------------------------
//        mer stexcac klas-i ekzemplyar enq stexcum
        recyclerViewItem = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView_hashiv);

//
//// ays toxn petq e vor RecyclerView-n amboxj arraylistn chatni hishoxutyun ayl mi
//// masn, vor heraxosn chkaxi, tvyal depqum asum enq vor fiqsac size- uni
//        recyclerView.setHasFixedSize(true);
////        adapteri inicializaci enq anum, vorin talis enq mer
////        koxmic sarqac arrayList` recyclerViewItem-n
//        adapter = new RecyclerViewAdapter(recyclerViewItem);
////        aysex layouti pahern e, karevor che
//        layoutManager = new LinearLayoutManager(this);
////inicializaciaic heto LayoutManager-n u adapter-n texadrum enq mer recyclerView hamar
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(layoutManager);

        //_____________________________________________________________________
//_____________________________________________________________________
//----------------------------DB -RecyvleView Strart-------------------
//        recyclerView_hashiv = findViewById(R.id.recyclerView_hashiv);

//----------------------------------------DB-------------------------------------------------
//----------------------------------@ndamen@ ays toxov db linum e----------------------------
//-----------------------------------------------------------------------------------------
//inicializacia enq anum mer  koxmic sarqac clasi ekzempliar
//talis enq mer koxmic sarqac clasn CarsAppDatabase, ev talis enq voch db-in anun`
// "CarsDB", voch te mek table-i
//        hashivsAppDatabase = Room.databaseBuilder(getApplicationContext(),
//                HashivAppDatabase.class, "CarsDB")
//                .build();
////-----------------------------------------------------------------------------------------
////-----------------------------------------------------------------------------------------
////-----------------------------------------------------------------------------------------
////-----------------------------------------------------------------------------------------
////stexcum enq nor objekt` mer nerqim ev private clasi, arajin dimumn e mer kodum background
//// potokin (AsyncTask), vortex stanum enq bolor tvyalnern db-ic ev cuyc talis ekranin
//        new GetAllHashivnerAsyncTask().execute();
////-----------------------------------------------------------------------------
//        hashivnerAdapter = new HashivAdapter(this, hashivArrayList, MainActivity.this);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView_hashiv.setLayoutManager(mLayoutManager);
//        recyclerView_hashiv.setItemAnimator(new DefaultItemAnimator());
//        recyclerView_hashiv.setAdapter(hashivnerAdapter);
////----------------------------DB -RecyvleView End----------------------
////_____________________________________________________________________
////-----------------------------------------------------
////--------------------------------------------------------------------------
//    }
//    //-------------------------------------------------------------------------------------------
////-----------------------------------------------------------------------------------------
////-----------------------ays metodum e  texi unenum AlertDialog-i mijocov add, edit ev
//// delete-i realizacian
//    public void addAndEditHashiv(final boolean isUpdate, final BloteNote bloteNote, final int position){
//        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
////layout_add_car.xml-i 1-textview-n ev 2 EditText-ern darnalu en dialogBox-i razmetken
//        View view = layoutInflaterAndroid.inflate(R.layout.layout_add_car, null);
//
//        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(MainActivity.this);
//        alertDialogBuilderUserInput.setView(view);
//
//
//       // createCar(nameEditText.getText().toString(), priceEditText.getText().toString());
//
//
//        TextView newCarTitle = view.findViewById(R.id.newCarTitle);
//        final EditText nameEditText = view.findViewById(R.id.nameEditText);
//        final EditText priceEditText = view.findViewById(R.id.priceEditText);
////vernagri @ntrutyun te vorn e linleu vernagirn
//        newCarTitle.setText(!isUpdate ? "Add Car" : "Edit Car");
////-----------------------------------------------------------------
//        if (isUpdate && bloteNote != null) {
//            nameEditText.setText(bloteNote.getKom2());
//            priceEditText.setText(bloteNote.getKom2());
//        }
//
//        alertDialogBuilderUserInput
//                .setCancelable(false)
//                .setPositiveButton(isUpdate ? "Update" : "Save", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialogBox, int id) {
//
//                    }
//                })//negativ button-i sexman realizacian
//                .setNegativeButton(isUpdate ? "Delete" : "Cancel",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialogBox, int id) {
//                                //kam jnjel
//                                if (isUpdate) {
//
//                                    deleteHashiv(bloteNote, position);
//                                } else {
//                                    //dialogBox-n cancel anel
//                                    dialogBox.cancel();
//
//                                }
//
//                            }
//                        });
//
////kanchum ev cuyc enq talis alertDialog-n
//        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
//        alertDialog.show();
////et alertDialog-i positiv knokpan e sexmvel
//        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
//            @Override//positiv knopkai sexman realizacian
//            public void onClick(View v) {
////ete datark e nameEditText-n
//                if (TextUtils.isEmpty(nameEditText.getText().toString())) {
//                    Toast.makeText(MainActivity.this, "Enter bloteNote name!", Toast.LENGTH_SHORT).show();
//                    return;
////ete datark e priceEditText-n
//                } else if (TextUtils.isEmpty(priceEditText.getText().toString())) {
//                    Toast.makeText(MainActivity.this, "Enter bloteNote price!", Toast.LENGTH_SHORT).show();
//                    return;
//                } else { //h.d. pakel dialogn
//                    alertDialog.dismiss();
//                }
//                //---
////voroshum e updateCar() in te createCar() kanchi
//                if (isUpdate && bloteNote != null) {
//
//                    updateHashiv(nameEditText.getText().toString(), priceEditText.getText().toString(), position);
//                } else {
//                    createHashiv(nameEditText.getText().toString(), priceEditText.getText().toString(), position);
////                    createHashiv(nameEditText.getText().toString(), priceEditText.getText().toString());
//                }
//            }
//        });
//    }
//    //------------------------------------------------------------------------------------------
//    private void deleteHashiv(BloteNote bloteNote, int position){
//
//        hashivArrayList.remove(position);
//
//        new DeleteHashivAsyncTask().execute(bloteNote);
//
//    }
//
//    private void updateHashiv(String kom1, String kom2, int position){
//
//        BloteNote bloteNote = hashivArrayList.get(position);
//
//        bloteNote.setKom1(kom1);
//        bloteNote.setKom2(kom2);
//
//        new UpdateHashivAsyncTask().execute(bloteNote);
//
//        hashivArrayList.set(position, bloteNote);
//
//
//    }
//    //-------------------------------stecxel nor tox db-i table-um---------------------------
////    private void createHashiv(String kom1, String kom2){
//    private void createHashiv(String kom1, String kom2, int position){
//
////kanchum enq (zugaher patokum ashxatox) CreateCarAsyncTask clasin, vorin talis enq
//// nor stexcac BlotNote clasi ekzempliar, id chenq poxancum (ayn avtomat e), miayn name ev price
//        new CreateHashivAsyncTask().execute(new BloteNote(0, kom1, kom2, "0"));
//
//    }
//    //---------------------------------------------------------------------------------
////---------------------------------------------------------------------------------
////---------------------- background potoki realizacia -----------------------------
////  stexcum enq mer nerqin clas, vorn jarangum e AsyncTask-ic, vorn voch mi parametr chi
////  veradarcnum (<Void, Void, Void> <Params, Progress, Result>) ete petq lini xaxerum, ays
////    3 -ov karox enq Userin cuyc tal progressbari mijocov progrress-n talov, kam verjum result-i
////    mijocov ardyunq cuyc talov.
////    ayn kanchvum e onCreate()-metodum
//    private class GetAllHashivnerAsyncTask extends AsyncTask<Void, Void, Void> {
//
//        // zugaher potoki (background potokum)  anhrajesht amboxch gorcoxutyunn texi e unenum ays metodum
//        @Override
//        protected Void doInBackground(Void... voids) {
////zugaher potokum amboxch infon kardum enq db-ic ev pahum arrayList-i mej
//            hashivArrayList.addAll(hashivsAppDatabase.getHashivDAO().getAllHashivner());
//            return null;
//        }
//
//        //sa AsyncTask-i verjin result metodn e, vorn kanchvum e doInBackground-ic heto,
//// men use ayn nra hamar, qani vor mez anhrajesht e db-i het avarteluc heto miayn infon
//// artacel  recicleView view-i vra
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
////asum enq adapterin vor texi e unecel tvyalneri popoxutyun vorpeszi
//// recicleView view-n obnovlyatca lini
//            hashivnerAdapter.notifyDataSetChanged();
//        }
//    }
//
//    //-----------------------------------------------------------------------------
////---------------------- background potoki realizacia nor tvyal db-um grelu jamanak,
////    vortex potokin tlis enq mutqayin tvyal car tipi clasi ekzempliar,
////    ays clasn kanchvum e CreateCar() metodum
//    private class CreateHashivAsyncTask extends AsyncTask<BloteNote, Void, Void> {
//
//
//        @Override
//        protected Void doInBackground(BloteNote... blot_hashiv) {
////            HashivAdapter
//           // final BloteNote bloteNote = blot_hashiv.get(position);
//
//            long id = hashivsAppDatabase.getHashivDAO().addHashiv(
//                    blot_hashiv[0]  );
//
//            BloteNote blotHashiv = hashivsAppDatabase.getHashivDAO().getHashiv(id);
//
//            if (blotHashiv != null) {
//
//                hashivArrayList.add(0, blotHashiv);
//
//
//            }
//            return null;
//        }
////sa AsyncTask-i verjin result metodn e, vorn kanchvum e doInBackground-ic heto,
//// men use ayn nra hamar, qani vor mez anhrajesht e db-i het avarteluc heto miayn infon
//// artacel  recicleView view-i vra
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
////asum enq adapterin vor texi e unecel tvyalneri popoxutyun vorpeszi
//// recicleView view-n obnovlyatca lini
//            hashivnerAdapter.notifyDataSetChanged();
//        }
//    }
//    //nmanakerp tes verevi clasneri komentn
////---------------------------------------------------------------------------------------
//    private class UpdateHashivAsyncTask extends AsyncTask<BloteNote, Void, Void> {
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//
//            hashivnerAdapter.notifyDataSetChanged();
//        }
//        //sa AsyncTask-i verjin result metodn e, vorn kanchvum e doInBackground-ic heto,
//// men use ayn nra hamar, qani vor mez anhrajesht e db-i het avarteluc heto miayn infon
//// artacel  recicleView view-i vra
//        @Override
//        protected Void doInBackground(BloteNote... blot_hashiv) {
////asum enq adapterin vor texi e unecel tvyalneri popoxutyun vorpeszi
//// recicleView view-n obnovlyatca lini
//            hashivsAppDatabase.getHashivDAO().updateHashiv(blot_hashiv[0]);
//
//            return null;
//        }
//    }
//    //nmanakerp tes verevi clasneri komentn
////----------------------------------------------------------------------------------
//    private class DeleteHashivAsyncTask extends AsyncTask<BloteNote, Void, Void> {
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//
//            hashivnerAdapter.notifyDataSetChanged();
//        }
////sa AsyncTask-i verjin result metodn e, vorn kanchvum e doInBackground-ic heto,
//// men use ayn nra hamar, qani vor mez anhrajesht e db-i het avarteluc heto miayn infon
//// artacel  recicleView view-i vra
//        @Override
//        protected Void doInBackground(BloteNote... blot_hashiv) {
////asum enq adapterin vor texi e unecel tvyalneri popoxutyun vorpeszi
//// recicleView view-n obnovlyatca lini
//            hashivsAppDatabase.getHashivDAO().deleteHashiv(blot_hashiv[0]);
//
//            return null;
//        }
    }

    //-------------------------------------------------------------------------
//----------------------------DB -RecyvleView End----------------------
//-------------------------------------------------------------------------
//
//
//    private void createNewLineHashiv() {
////                resultLayout.removeAllViews();
//      //  LinearLayout layoutLine = new LinearLayout(resultLayout.getContext());
//        LinearLayout layoutLine = new LinearLayout(this);
//        layoutLine.setOrientation(LinearLayout.HORIZONTAL);
//
//       textView_Kom1_New = new TextView(this);
//        textView_Kom1_New.setTextSize(15);
//        textView_Kom1_New.setTextColor(getResources().getColor(R.color.colorBlack));
//        textView_Kom1_New.setText("Lusin");
//
//        LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        leftMarginParams.leftMargin = 50;
//        leftMarginParams.gravity = Gravity.RIGHT;
//
//
////        android:layout_width="0dp"
////        android:layout_height="45dp"
////        android:layout_weight="33"
////        android:gravity="center"
////        android:hint="0"
//
//        textView_Kom2_New = new TextView(this);
//        textView_Kom2_New.setTextSize(15);
//        textView_Kom2_New.setTextColor(getResources().getColor(R.color.colorBlack));
//        textView_Kom2_New.setText("arev");
//
//        LinearLayout.LayoutParams buttonParams =
//                new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.WRAP_CONTENT,
//                        LinearLayout.LayoutParams.WRAP_CONTENT);
//       // buttonParams.gravity = Gravity.CENTER_HORIZONTAL;
//
//       layoutLine.addView(textView_Kom1_New, buttonParams);
//        layoutLine.addView(textView_Kom2_New, leftMarginParams);
//
//
//        LinearLayout.LayoutParams buttonParams1 =
//                new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
//
//
//        resultLayout.addView(layoutLine, buttonParams1 );
//        //setContentView(layoutLine);
//    }
//--------------------------------------------------------------------
    // interfeysi metodi pereopreedlyactia
    @Override
    public void onButtonClicked(String taracMiavor_Kom1_2, String kom1_2_miavor_avtomat_hashvac) {
//    public void onButtonClicked(String kom1_kom2_miavor, ) {
        if (kom1_kom2 == 1) {
            txtView_kom1.setText(taracMiavor_Kom1_2);
            txtView_kom2.setText(kom1_2_miavor_avtomat_hashvac);
        } else {
            txtView_kom1.setText(kom1_2_miavor_avtomat_hashvac);
            txtView_kom2.setText(taracMiavor_Kom1_2);
        }

    }

    //-----------------------------------------------------------------------------
//ays metodn mianum e useri order-n uzeluc heto(zakaz knopkai vra sexmeluc heto)
    public void order_OnButtonClicked(byte kom1_kom2_xosacele, int mast, String order) {
        this.kom1_kom2_xosacele = kom1_kom2_xosacele;
        this.mast = mast;//tvysl oyini mastn e
        this.order = order;//tvyal oyini xosacac tivn e


        //createHashiv(nameEditText.getText().toString(), priceEditText.getText().toString());
//        txtView_order.setText(order);
        switch (mast) {
            case 0:
                //new CreateHashivAsyncTask().execute(new BloteNote(0, "0", "0",R.drawable.x_24, order));
                //     String txt_kom1, String txt_kom2, int imageResource,String zakaz
                recyclerViewItem.add(new RecyclerViewItem("0", "0",
                        R.drawable.x_24, order));
                // Img_mast.setImageResource(R.drawable.x_24);
                break;
            case 1:
                recyclerViewItem.add(new RecyclerViewItem("0", "0",
                        R.drawable.s_24, order));
                //  new CreateHashivAsyncTask().execute(new BloteNote(0, "0", "0",R.drawable.s_24, order));

                //    Img_mast.setImageResource(R.drawable.s_24);
                break;
            case 2:
                recyclerViewItem.add(new RecyclerViewItem("0", "0",
                        R.drawable.xar_24, order));
                //     new CreateHashivAsyncTask().execute(new BloteNote(0, "0", "0",R.drawable.xar_24, order));

                //    Img_mast.setImageResource(R.drawable.xar_24);
                break;
            case 3:
                recyclerViewItem.add(new RecyclerViewItem("0", "0",
                        R.drawable.q_24, order));
                //   new CreateHashivAsyncTask().execute(new BloteNote(0, "0", "0",R.drawable.q_24, order));

                //  Img_mast.setImageResource(R.drawable.q_24);
                break;
            default:
                recyclerViewItem.add(new RecyclerViewItem("0", "0",
                        R.drawable.t_24, order));
                //   new CreateHashivAsyncTask().execute(new BloteNote(0, "0", "0",R.drawable.t_24, order));

                // Img_mast.setImageResource(R.drawable.t_24);
                break;
        }

// ays toxn petq e vor RecyclerView-n amboxj arraylistn chatni hishoxutyun ayl mi
// masn, vor heraxosn chkaxi, tvyal depqum asum enq vor fiqsac size- uni
        recyclerView.setHasFixedSize(true);
//        adapteri inicializaci enq anum, vorin talis enq mer
//        koxmic sarqac arrayList` recyclerViewItem-n
        adapter = new RecyclerViewAdapter(recyclerViewItem);
//        aysex layouti pahern e, karevor che
        layoutManager = new LinearLayoutManager(this);
//inicializaciaic heto LayoutManager-n u adapter-n texadrum enq mer recyclerView hamar
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
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


//        addAndEditHashiv(false, null, -1);

        try {
            ExtraOrderBtnDialog bottomSheet = new ExtraOrderBtnDialog();
            bottomSheet.show(getSupportFragmentManager(), "exampleBottomSheet");
        } catch (ClassCastException e) {
            throw new ClassCastException();
        }

        //  addAndEditCars(false, null, -1);
////        txtView_Team1, txtView_Team2, txtView_zakaz
//        if (team1Team2_Zakaz_banali == true)//
//        {
//            txtView_zakaz.setBackgroundResource(R.color.colorBlack);
//            txtView_Team1.setBackgroundResource(R.color.colorRed);
//            txtView_Team2.setBackgroundResource(R.color.colorRed);
////            anjatum enq useri hamar zakazi hnaravorutyunn
//
////            txtView_Team1.setFocusable(true);
////            txtView_Team1.setEnabled(true);
////
////            txtView_Team2.setFocusable(true);
////            txtView_Team2.setEnabled(true);
//            team1Team2_Zakaz_banali = !team1Team2_Zakaz_banali;
//
//        }

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
