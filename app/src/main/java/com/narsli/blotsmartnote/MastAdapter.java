package com.narsli.blotsmartnote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MastAdapter extends ArrayAdapter<MastItem> {

     public MastAdapter(Context context, ArrayList<MastItem> mastList) {
            super(context, 0, mastList);
        }
    @NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
        }

@Override
public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
        }

        private View initView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(
                        R.layout.mast_spinner_row, parent, false
                );
            }

            ImageView imageViewmast = convertView.findViewById(R.id.image_view_mast);

            MastItem currentItem = getItem(position);

            if (currentItem != null) {
                imageViewmast.setImageResource(currentItem.getMastImage());
            }

            return convertView;
        }
    }
