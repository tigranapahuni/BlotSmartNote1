package com.narsli.blotsmartnote;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ExtraOrderBtnDialog extends BottomSheetDialogFragment {
    Button
            btn_1, btn_2, btn_3, btn_4, btn_5, btn_6,
            btn_7, btn_8, btn_9, btn_0, btn_K, btn_x2, btn_x4;
    ImageButton
            ImgBtn_Back, ImgBtn_Ok, ImgBtn_xach, ImgBtn_sirt,
            ImgBtn_xar, ImgBtn_qiap, ImgBtn_tuz;
    Boolean kaput_banali = false,
            quansh_banali = false,
            kontr_banali = false;
    int mast_banali;
    String order = "0";

    private BottomSheetListenerOrder mListener;//mer sarqac interfeysi ekzempliar
//--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.order_extra_btns, container, false);

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
        btn_x2 = v.findViewById(R.id.Btn_x2);
        btn_x4 = v.findViewById(R.id.Btn_x4);

        ImgBtn_tuz = v.findViewById(R.id.ImgBtn_Tuz);
        ImgBtn_Back = v.findViewById(R.id.ImgBtn_Back);
        ImgBtn_Ok = v.findViewById(R.id.ImgBtn_Ok);
        ImgBtn_sirt = v.findViewById(R.id.ImgBtn_sirt);
        ImgBtn_xar = v.findViewById(R.id.ImgBtn_xar);
        ImgBtn_qiap = v.findViewById(R.id.ImgBtn_qiap);
        ImgBtn_xach = v.findViewById(R.id.ImgBtn_xach);
//------------------
        ImgBtn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia

                mListener.orderon_onButtonClicked(mast_banali, order);
                //miangamic pakel nerqevi toxi
                dismiss();
            }
        });
//---------------------------------------------------------------------
        ImgBtn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia

                if (order != "K" & order.length() == 1 & order != "0") {
                    order = order.substring(0, order.length() - 1);
                    order = "0";
                }
                if (order.length() == 2)
                    order = order.substring(0, order.length() - 1);
                mListener.orderon_onButtonClicked(mast_banali, order);
            }
        });
//---------------------------------------------------------------------
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                if (order.equals("0"))
                    order = "1";
                else if (order != "K" & order.length() > 0 & order.length() < 2)
                    order = order + "1";
                mListener.orderon_onButtonClicked(mast_banali, order);
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
                mListener.orderon_onButtonClicked(mast_banali, order);
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
                mListener.orderon_onButtonClicked(mast_banali, order);
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
                mListener.orderon_onButtonClicked(mast_banali, order);
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
                mListener.orderon_onButtonClicked(mast_banali, order);
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
                mListener.orderon_onButtonClicked(mast_banali, order);
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
                mListener.orderon_onButtonClicked(mast_banali, order);
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
                mListener.orderon_onButtonClicked(mast_banali, order);
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
                mListener.orderon_onButtonClicked(mast_banali, order);
            }
        });
//---------------------------------------------------------------------
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia

                if (order != "K" & order != "0" & order.length() == 1) {
                    order = order + "0";
                    mListener.orderon_onButtonClicked(mast_banali, order);
                }
            }
        });
//_____________________________________________________________________
        btn_K.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kaput_banali) {
                    //---------------------------------------------
                    try {
                        // int tiv= Integer.parseInt(order);
                        if (order.length() == 3)
                            order = order.substring(0, order.length() - 1);
                        else
                            order = "0";
                    } catch (ClassCastException e) {
                        throw new ClassCastException();
                    }
                    //------------------------------------
                    // order = "0";
                    btn_K.setBackgroundResource(R.color.colorBlack);
                } else {
//---------------------------------------------
                    try {
                        int tiv = Integer.parseInt(order);
                        if (tiv > 25)
                            order = order + "K";
                        else
                            order = "K";
                    } catch (ClassCastException e) {
                        throw new ClassCastException();
                    }
//------------------------------------
                    //order = "K";
                    mListener.orderon_onButtonClicked(mast_banali, order);
                    btn_K.setBackgroundResource(R.color.colorBlue);
                }
                kaput_banali = !kaput_banali;
                mListener.orderon_onButtonClicked(mast_banali, order);
            }
        });
//------------------------------------------------------------------
//---------------------------------------------
//        try {
//            int tiv= Integer.parseInt(order);
//            if (tiv>25)
//                order =order+ "K";
//            else
//                order= "K";
//        } catch (ClassCastException e) {
//            throw new ClassCastException();
//        }
//------------------------------------
        btn_x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (order != "0" & Integer.parseInt(order) > 7) {
                    if (quansh_banali) {
                        btn_x2.setTextColor(getResources().getColor(R.color.coloryellownew));
                        btn_x4.setTextColor(getResources().getColor(R.color.coloryellownew));
                        kontr_banali = false;
                    } else if (quansh_banali == false | kontr_banali == true) {
                        btn_x2.setTextColor(getResources().getColor(R.color.colorRed));
                        btn_x4.setTextColor(getResources().getColor(R.color.coloryellownew));
                        kontr_banali = false;
                        if (order != null)
                            order = order + "x2";
                    }
                    quansh_banali = !quansh_banali;
                }
            }
        });
//------------------------------------------------------------------
        btn_x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (order != "0" & Integer.parseInt(order) > 7) {
                    if (kontr_banali) {
                        btn_x2.setTextColor(getResources().getColor(R.color.coloryellownew));
                        btn_x4.setTextColor(getResources().getColor(R.color.coloryellownew));
                        quansh_banali = false;
                    } else {
                        quansh_banali = false;
                        if (order != null)
                            order = order + "x4";
                        btn_x4.setTextColor(getResources().getColor(R.color.colorRed));
                        btn_x2.setTextColor(getResources().getColor(R.color.coloryellownew));
                    }
                    kontr_banali = !kontr_banali;
                }
            }
        });
//------------------------------------------------------------------
        ImgBtn_tuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgBtn_tuz.setBackgroundResource(R.color.coloryellowstrong);
                ImgBtn_xach.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_xar.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_sirt.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_qiap.setBackgroundResource(R.color.coloryellownew);

                mast_banali = 4;
                mListener.orderon_onButtonClicked(mast_banali, order);
            }
        });
//------------------------------------------------------------------
        ImgBtn_xach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mast_banali = 0;
                mListener.orderon_onButtonClicked(mast_banali, order);

                ImgBtn_xach.setBackgroundResource(R.color.coloryellowstrong);
                ImgBtn_tuz.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_xar.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_sirt.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_qiap.setBackgroundResource(R.color.coloryellownew);
            }
        });
//------------------------------------------------------------------
        ImgBtn_xar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mast_banali = 2;
                mListener.orderon_onButtonClicked(mast_banali, order);

                ImgBtn_xar.setBackgroundResource(R.color.coloryellowstrong);
                ImgBtn_xach.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_tuz.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_sirt.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_qiap.setBackgroundResource(R.color.coloryellownew);
            }
        });
//------------------------------------------------------------------
        ImgBtn_sirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mast_banali = 1;
                mListener.orderon_onButtonClicked(mast_banali, order);

                ImgBtn_sirt.setBackgroundResource(R.color.coloryellowstrong);
                ImgBtn_xar.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_xach.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_tuz.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_qiap.setBackgroundResource(R.color.coloryellownew);
            }
        });
//------------------------------------------------------------------
        ImgBtn_qiap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mast_banali = 3;
                mListener.orderon_onButtonClicked(mast_banali, order);

                ImgBtn_qiap.setBackgroundResource(R.color.coloryellowstrong);
                ImgBtn_xar.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_xach.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_tuz.setBackgroundResource(R.color.coloryellownew);
                ImgBtn_sirt.setBackgroundResource(R.color.coloryellownew);
            }
        });
//------------------------------------------------------------------
//------------------------------------------------------------------
//        btn_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
//                mListener.onButtonClicked("Button 2 clicked");
//                dismiss();
//            }
//        });

        return v;
    }

    //-----------------------------------------------------------
//         @Override
//         public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//             String text = parent.getItemAtPosition(position).toString();
//             Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
//         }
//
//         @Override
//         public void onNothingSelected(AdapterView<?> parent) {
//
//         }
//-----------------------------------------------------------
    //------------------------------------------------------
    public interface BottomSheetListenerOrder {
        void orderon_onButtonClicked(int mast, String order);
    }

    //----------------------------------------------------------
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (BottomSheetListenerOrder) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement BottomSheetListener");
        }
    }

//_____________________________________________________________________
}

