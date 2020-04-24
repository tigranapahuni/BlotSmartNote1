package com.narsli.blotsmartnote;

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
//        implements AdapterView.OnItemSelectedListener
     {
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
         private  Spinner spinner;
        private BottomSheetListener mListener;//mer sarqac interfeysi ekzempliar
//--------------------------------------------------------------------------
    private ArrayList<MastItem> mastList;
    private MastAdapter adapter;
//--------------------------------------------------------------------------
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.extra_buttons, container, false);

            initList();
            Spinner spinnerMasts = v.findViewById(R.id.spinner_masts);
            Button btn_1 = v.findViewById(R.id.blot);
            Button btn_2 = v.findViewById(R.id.terz);
//            EditText editText= v.findViewById(R.id.EditText_Order);
//------------------
           spinner = v.findViewById(R.id.spinner_order);

            ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(getContext(),
                      android.R.layout.simple_dropdown_item_1line, order);
//
            dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            spinner.setAdapter(dataAdapter);
//------------------

           adapter = new MastAdapter(getContext(), mastList);
            spinnerMasts.setAdapter(adapter);

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



            btn_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    mListener.onButtonClicked("Button 1 clicked");
                    //miangamic pakel nerqevi toxi
//                dismiss();
                }
            });
            btn_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//mer sarqac interfeysi realizacia` onButtonClicked- metodi realizacia
                    mListener.onButtonClicked("Button 2 clicked");
                    dismiss();
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
    private void initList() {
        mastList = new ArrayList<>();
        mastList.add(new MastItem( R.drawable.s_24));
        mastList.add(new MastItem( R.drawable.x_24));
        mastList.add(new MastItem( R.drawable.q_24));
        mastList.add(new MastItem( R.drawable.xar_24));
        mastList.add(new MastItem( R.drawable.t_24));
    }

}
