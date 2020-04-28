package com.narsli.blotsmartnote;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

//sarqum enq dialog vorn kpnum e mer razmetka failin
//nerqevi knopkan` BottomSheetDialogFragment-interfeysov e realizacvum
    public class ExtraButtonDialog extends BottomSheetDialogFragment
     {
         private Button
                 btn_1, btn_2, btn_3, btn_4, btn_5, btn_6,
                 btn_7, btn_8, btn_9, btn_0, btn_K, btn_tk;
         CheckBox chckBx_tuz, chckBx_valet,
                 chckBx_9, chckBx_BLot;
         ImageButton imgbtn_terz_minus, imgbtn_terz_plus;
         EditText editTxt_taracMiavor;
         Boolean kaput_banali = false, tak_banali = false;
         private Dialog dialog;
         private ImageView imgBtn_Back, imgBtn_Ok;
         TextView txtView_Extra, txtView_terz_Qanak,
                 txtViw_Extra, txtView_combination,
                 txtViw_ArdyunqMiavor;
         String order = "0", combination, tarac_itog;
         //         byte kom1_kom2;
         private BottomSheetListener mListener;//mer sarqac interfeysi ekzempliar
//--------------------------------------------------------------------------
//konstruktor
//public  ExtraButtonDialog(byte kom1_kom2)
//{
//    this.kom1_kom2=kom1_kom2;
//}
         //--------------------------------------------------------------------------
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.extra_buttons, container, false);
//----------------------
            //inicializacia
            btn_1 = v.findViewById(R.id.Btn_1);
            btn_2 = v.findViewById(R.id.Btn_2);
            btn_3 = v.findViewById(R.id.Btn_3);
            btn_4 = v.findViewById(R.id.Btn_4);
            btn_5 = v.findViewById(R.id.Btn_5);
            btn_6 = v.findViewById(R.id.Btn_6);
            btn_7 = v.findViewById(R.id.Btn_7);
            btn_8 = v.findViewById(R.id.Btn_8);
            btn_9 = v.findViewById(R.id.Btn_9);
            btn_0 = v.findViewById(R.id.Btn_0);
            btn_K = v.findViewById(R.id.Btn_KP);
            btn_tk = v.findViewById(R.id.Btn_tk);

            imgBtn_Back = v.findViewById(R.id.ImgBtn_Back);
            txtView_Extra = v.findViewById(R.id.TxtViw_Extra);
            imgBtn_Ok = v.findViewById(R.id.ImgBtn_Ok);

            txtView_terz_Qanak = v.findViewById(R.id.txtView_terz_Qanak);
            txtViw_Extra = v.findViewById(R.id.TxtViw_Extra);
            txtView_combination = v.findViewById(R.id.txtView_combination);
            txtViw_ArdyunqMiavor = v.findViewById(R.id.txtViw_ArdyunqMiavor);

            chckBx_tuz = v.findViewById(R.id.chckBx_tuz);
            chckBx_valet = v.findViewById(R.id.chckBx_valet);
            chckBx_9 = v.findViewById(R.id.chckBx_9);

            chckBx_BLot = v.findViewById(R.id.chckBx_BLot);

            imgbtn_terz_minus = v.findViewById(R.id.Imgbtn_terz_minus);
            imgbtn_terz_plus = v.findViewById(R.id.Imgbtn_terz_plus);
            editTxt_taracMiavor = v.findViewById(R.id.editTxt_taracMiavor);
//-------------------------------------------------------------------------------
            btn_tk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (tak_banali) {
                        //---------------------------------------------
                        btn_tk.setBackgroundResource(R.color.colorBlack);
                        btn_K.setBackgroundResource(R.color.colorBlack);
                        order = "0";
                        kaput_banali = false;
                    } else {
//---------------------------------------------
                        order = "Tk";
                        btn_tk.setBackgroundResource(R.color.colorGray);
                        btn_K.setBackgroundResource(R.color.colorBlack);
                        kaput_banali = false;
                    }
                    tak_banali = !tak_banali;
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }

            });
//------------------------------------------------------------------
//-------------------------------------------------------------------------------
            btn_K.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (kaput_banali) {
                        //---------------------------------------------
                        btn_K.setBackgroundResource(R.color.colorBlack);
                        btn_tk.setBackgroundResource(R.color.colorBlack);
                        order = "0";
                        tak_banali = false;
                    } else {
//---------------------------------------------
                        order = "K";
                        btn_K.setBackgroundResource(R.color.colorBlue);
                        btn_tk.setBackgroundResource(R.color.colorBlack);
                        tak_banali = false;
                    }
                    kaput_banali = !kaput_banali;
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }

            });
//------------------------------------------------------------------

//_______________________________________________________________________________
            imgBtn_Ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mListener.onButtonClicked(order);
                    //miangamic pakel nerqevi toxi
                    dismiss();

                }
            });
//---------------------------------------------------------------------
//
//            if (order != "K" & order.length() == 1 & order != "0") {
//                order = order.substring(0, order.length() - 1);
//                order = "0";
//            }
//            if (order.length() == 2)
//                order = order.substring(0, order.length() - 1);
//            mListener.order_OnButtonClicked(mast_banali, order);


            imgBtn_Back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia

                    if (order != "Tk" & order != "K" & order.length() == 1 & order != "0") {
                        order = order.substring(0, order.length() - 1);
                        order = "0";
                    }
                    if (order != "Tk" & order.length() > 1)
                        order = order.substring(0, order.length() - 1);
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }
            });
//---------------------------------------------------------------------
            btn_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "1";
                    else if (order != "Tk" & order != "K" & order.length() < 3)
                        order = order + "1";
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }
            });
//------------------------------------------------------------------
            btn_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "2";
                    else if (order != "Tk" & order != "K" & order.length() < 3)
                        order = order + "2";
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }
            });
            //---------------------------------------------------------------------
            btn_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "3";
                    else if (order != "Tk" & order != "K" & order.length() < 3)
                        order = order + "3";
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }
            });//---------------------------------------------------------------------
            btn_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "4";
                    else if (order != "Tk" & order != "K" & order.length() < 3)
                        order = order + "4";
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }
            });//---------------------------------------------------------------------
            btn_5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "5";
                    else if (order != "Tk" & order != "K" & order.length() < 3)
                        order = order + "5";
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }
            });//---------------------------------------------------------------------
            btn_6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "6";
                    else if (order != "Tk" & order != "K" & order.length() < 3)
                        order = order + "6";
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }
            });//---------------------------------------------------------------------
            btn_7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "7";
                    else if (order != "Tk" & order != "K" & order.length() < 3)
                        order = order + "7";
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }
            });//---------------------------------------------------------------------
            btn_8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "8";
                    else if (order != "Tk" & order != "K" & order.length() < 3)
                        order = order + "8";
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }
            });//---------------------------------------------------------------------
            btn_9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "9";
                    else if (order != "Tk" & order != "K" & order.length() < 3)
                        order = order + "9";
                    mListener.onButtonClicked(order);
                    editTxt_taracMiavor.setText(order);
                }
            });
//---------------------------------------------------------------------
            btn_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia

                    if (order != "Tk" & order != "K" & order != "0" & order.length() < 3) {
                        order = order + "0";
                        mListener.onButtonClicked(order);
                        editTxt_taracMiavor.setText(order);
                    }
                }
            });
//_____________________________________________________________________

//--------------------------------------------------------------------------
//----------------------------------dialog activity(4 tuxtn)----------------
            dialog = new Dialog(getContext());//stexcum enq dialog
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//anjatum enq vernagirn
            dialog.setContentView(R.layout.chors_tuxt_dialog);//kpcnum enq razmetkain(maketin)
            //dialog-i foni hetevn lini tapancik
            // dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//asum enq dialogi mej inch ka et chaperov el lini dilaogn
//         dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
//                 WindowManager.LayoutParams.MATCH_PARENT);
            dialog.setCancelable(false);//nazad knopkan anjatum enq
//-------------------------------------------------------------------------
//------------------
            txtView_Extra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    dialog.show();
                    //mListener.onButtonClicked(or);
                    //miangamic pakel nerqevi toxi
//                dismiss();
                }
            });

            return v;
        }
//-----------------------------------------------------------
//------------------------------------------------------
        public interface BottomSheetListener {
    void onButtonClicked(String order);
        }
//----------------------------------------------------------
        @Override
        public void onAttach(Context context) {
            super.onAttach(context);

            try {
                mListener = (BottomSheetListener) context;
            } catch (ClassCastException e) {
                throw new ClassCastException(context.toString()
                        + " must implement BottomSheetListener");
            }
        }

         //_____________________________________________________________________
     }
