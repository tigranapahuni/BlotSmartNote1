package com.narsli.blotsmartnote;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

//sarqum enq dialog vorn kpnum e mer razmetka failin
//nerqevi knopkan` BottomSheetDialogFragment-interfeysov e realizacvum
    public class ExtraButtonDialog extends BottomSheetDialogFragment
     {

         private Dialog dialog;
         private BottomSheetListener mListener;//mer sarqac interfeysi ekzempliar
//--------------------------------------------------------------------------

         //--------------------------------------------------------------------------
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.extra_buttons, container, false);


            //--------------------------------------------------------------------------
            //dialog
            dialog = new Dialog(getContext());//stexcum enq dialog
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//anjatum enq vernagirn
            dialog.setContentView(R.layout.chors_tuxt_dialog);//kpcnum enq razmetkain(maketin)
            //dialog-i foni hetevn lini tapancik
            // dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//asum enq dialogi mej inch ka et chaperov el lini dilaogn
//         dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
//                 WindowManager.LayoutParams.MATCH_PARENT);
            dialog.setCancelable(false);//nazad knopkan anjatum enq


//        layout=findViewById(R.id.layout);

//-------------------------------------------------------------------------


            Button btn_1 = v.findViewById(R.id.Btn_1);
            Button btn_2 = v.findViewById(R.id.Btn_2);
//            EditText editText= v.findViewById(R.id.EditText_Order);
//------------------

            btn_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    dialog.show();
                    mListener.onButtonClicked("Button 1 clicked");
                    //miangamic pakel nerqevi toxi
//                dismiss();
                }
            });
            btn_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    dialog.dismiss();
                    mListener.onButtonClicked("Button 2 clicked");
                    //dismiss();
                }
            });

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
        public interface BottomSheetListener {
            void onButtonClicked(String text);
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

//         public void dialog_show(View view) {
//             dialog.show();
//         }
//
//         public void dialog_closed(View view) {
//             dialog.dismiss();
//         }
     }
