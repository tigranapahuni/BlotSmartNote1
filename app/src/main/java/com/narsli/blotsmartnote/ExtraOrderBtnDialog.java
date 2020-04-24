package com.narsli.blotsmartnote;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ExtraOrderBtnDialog extends BottomSheetDialogFragment {

    private BottomSheetListenerOrder mListener;//mer sarqac interfeysi ekzempliar
//--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.order_extra_btns, container, false);

        Button btn_1 = v.findViewById(R.id.Btn_terz_minus);
        Button btn_2 = v.findViewById(R.id.Btn_terz_minus);
//            EditText editText= v.findViewById(R.id.EditText_Order);
//------------------

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
    public interface BottomSheetListenerOrder {
        void onButtonClicked(String text);
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

