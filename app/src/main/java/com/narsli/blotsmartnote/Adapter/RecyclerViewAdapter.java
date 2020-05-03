package com.narsli.blotsmartnote.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.narsli.blotsmartnote.Model.RecyclerViewItem;
import com.narsli.blotsmartnote.R;

import java.util.ArrayList;

//ays clasn mer arraylistic tvyalnern dnum e RecyclerView-i mej jarangum e zavaskoy clasi
//ayn mec masov haskanal@ partadir che uxaki iran main-i mejic kanchenq!!

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder> {

    private ArrayList<RecyclerViewItem> arrayList;

    //construktor
    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> arrayList) {
        this.arrayList = arrayList;
    }

    //mer koxmic stexcvac rametken vorn menq sarqel enq (recicler_view_item.xml -failn)
// kapum enq adapteri het, stanum e metodn viewGroup, vorn kapum e
// recicler_view_item-layouti het
    @NonNull
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.hashiv_list_item,
                        viewGroup, false);
        RecyclerViewViewHolder recyclerViewViewHolder = new RecyclerViewViewHolder(view);
        return recyclerViewViewHolder;

    }

    /// ays metodum dnum enq amen RecyclerView-i nkarn, ev 2 textern recyclerViewViewHolder-mej
//     vortex i- RecyclerViewI-i hamarn e
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewViewHolder recyclerViewViewHolder, int i) {
        RecyclerViewItem recyclerViewItem = arrayList.get(i);

        recyclerViewViewHolder.txtView_kom1.setText(recyclerViewItem.getTxt_kom1());
        recyclerViewViewHolder.txtView_kom2.setText(recyclerViewItem.getTxt_kom2());

        recyclerViewViewHolder.imageView.setImageResource(recyclerViewItem.getImageResource());
        recyclerViewViewHolder.txtView_order.setText(recyclerViewItem.getZakaz());
    }

    //veradarcnum enq arrayList-i qanakn, anhrajesht e iren korekt ashxatelu hamar
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    //ays jarang clasn uni static metod ev menq partavor en ayn realizacnenq
    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {

        public TextView
                txtView_kom1, txtView_order, txtView_kom2;
        public ImageView imageView;

        //construktorin trvum e yuraqanchyur RecyclerView-n, vorn ays metodi mej kochvum e itemView
        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView_kom1 = itemView.findViewById(R.id.txtView_kom1);
            txtView_kom2 = itemView.findViewById(R.id.txtView_kom2);
            imageView = itemView.findViewById(R.id.Img_mast);
            txtView_order = itemView.findViewById(R.id.txtView_order);
        }
    }
}
//}

