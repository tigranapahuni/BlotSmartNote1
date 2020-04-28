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
                 btn_7, btn_8, btn_9, btn_0, btn_K;
         private Dialog dialog;
         private ImageView imgBtn_Back, imgBtn_Ok;
         TextView txtView_Extra;
         String order = "0";
         private BottomSheetListener mListener;//mer sarqac interfeysi ekzempliar
//--------------------------------------------------------------------------

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
            btn_K = v.findViewById(R.id.Btn_K);

            imgBtn_Back = v.findViewById(R.id.ImgBtn_Back);
            txtView_Extra = v.findViewById(R.id.TxtViw_Extra);
            imgBtn_Ok = v.findViewById(R.id.ImgBtn_Ok);
//------------------
            imgBtn_Ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    mListener.onButtonClicked(order);

                    //miangamic pakel nerqevi toxi
                    dismiss();

                }
            });
//---------------------------------------------------------------------
            imgBtn_Back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia

                    if (order != "K" & order.length() == 1 & order != "0") {
                        order = order.substring(0, order.length() - 1);
                        order = "0";
                    }
                    if (order.length() == 2)
                        order = order.substring(0, order.length() - 1);
                    mListener.onButtonClicked(order);
                }
            });
//---------------------------------------------------------------------
            btn_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "1";
                    else if (order != "K" & order.length() < 4)
                        order = order + "1";
                    Log.d("arev", order);
                    mListener.onButtonClicked(order);
                }
            });
//------------------------------------------------------------------
            btn_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "2";
                    else if (order != "K" & order.length() > 0 & order.length() < 2)
                        order = order + "2";
                    mListener.onButtonClicked(order);
                }
            });
            //---------------------------------------------------------------------
            btn_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "3";
                    else if (order != "K" & order.length() > 0 & order.length() < 2)
                        order = order + "3";
                    mListener.onButtonClicked(order);
                }
            });//---------------------------------------------------------------------
            btn_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "4";
                    else if (order != "K" & order.length() > 0 & order.length() < 2)
                        order = order + "4";
                    mListener.onButtonClicked(order);
                }
            });//---------------------------------------------------------------------
            btn_5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "5";
                    else if (order != "K" & order.length() > 0 & order.length() < 2)
                        order = order + "5";
                    mListener.onButtonClicked(order);
                }
            });//---------------------------------------------------------------------
            btn_6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "6";
                    else if (order != "K" & order.length() > 0 & order.length() < 2)
                        order = order + "6";
                    mListener.onButtonClicked(order);
                }
            });//---------------------------------------------------------------------
            btn_7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "7";
                    else if (order != "K" & order.length() > 0 & order.length() < 2)
                        order = order + "7";
                    mListener.onButtonClicked(order);
                }
            });//---------------------------------------------------------------------
            btn_8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "8";
                    else if (order != "K" & order.length() > 0 & order.length() < 2)
                        order = order + "8";
                    mListener.onButtonClicked(order);
                }
            });//---------------------------------------------------------------------
            btn_9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    if (order.equals("0"))
                        order = "9";
                    else if (order != "K" & order.length() > 0 & order.length() < 2)
                        order = order + "9";
                    mListener.onButtonClicked(order);
                }
            });
//---------------------------------------------------------------------
            btn_0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia

                    if (order != "K" & order != "0" & order.length() == 1) {
                        order = order + "0";
                        mListener.onButtonClicked(order);
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
