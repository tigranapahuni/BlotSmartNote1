package com.narsli.blotsmartnote.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.narsli.blotsmartnote.MainActivity;
import com.narsli.blotsmartnote.Model.BloteNote;
import com.narsli.blotsmartnote.R;

import java.util.ArrayList;

//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
//                   ays clasum kopit asac texi unenum xml-i ev java-i miavorum--------
//--------------------------------db-i het kapvac pah chka!!!!!!!!!!!!!!---------------
//ays clasn mer arraylistic tvyalnern dnum e RecyclerView-i mej jarangum e zavaskoy clasi
//ays clasn db-ic hanvac tvyalnern voronq cursor tip-en texadrum e listView-i amen toxi meji
//3 textview elementeri mijev
public class HashivAdapter extends RecyclerView.Adapter<HashivAdapter.HashviViewHolder> {

    private Context context;
    private ArrayList<BloteNote> bloteNotes;
    private MainActivity mainActivity;

    //---------------------------------end------------------------------------------
//---------------------- HashviViewHolder clasi avart -----------------------
//____________________________________________________________________________
    //konstruktorn e, vorin talis enq naev mainActivity-in, BloteNote clasi ArrayListn ev context
    public HashivAdapter(Context context, ArrayList<BloteNote> bloteNotes, MainActivity mainActivity) {
        this.context = context;
        this.bloteNotes = bloteNotes;
        this.mainActivity = mainActivity;
    }

    //---------------------------------------------------------------------------------
//mer koxmic stexcvac razmetken vorn menq sarqel enq (hashiv_list_item.xml -failn)
//kapum enq adapteri het, metodn stanum e viewGroup ev veradarcnum e mer sarqac HashviViewHolder-in
    @Override
    public HashviViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.hashiv_list_item, parent, false);

        return new HashviViewHolder(itemView);

    }
//-*-*-*-*-*-*-*- hajord 3 metodnern RecyclerView.Adapter clasi pereoprdelyonni metodnern en

    //-------------------------------------------------------------------------------------
/// ays metodum dnum enq RecyclerView-i  amen itemView-um  2 TextView
//mer sarqac HashviViewHolder-mej
//vortex position- RecyclerViewI-i amen itemView-i hamarn e
    @Override
    public void onBindViewHolder(@NonNull HashviViewHolder holder, final int position) {

        final BloteNote bloteNote = bloteNotes.get(position);


        holder.txtView_kom1.setText(bloteNote.getKom1());
        holder.txtView_kom2.setText(bloteNote.getKom2());

        holder.txtView_order.setText(bloteNote.getZakaz());
        holder.imageView.setImageResource(bloteNote.getImageResource());

        //---------------------
//RecyclerView view-i amen andami vra OnClick-i realizacian e
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            //kanchum enq mainActivity-i addAndEditCars() metodn, vorn irakanacnum e AlertDialog-i
//mijocov poqr dialog patuhani realizacian
            @Override
            public void onClick(View v) {

                //     mainActivity.addAndEditHashiv(true, bloteNote, position);
            }
        });

    }

    //-----------------------------------------------------------------------------------
//veradarcnum enq arrayList-i qanakn, anhrajesht e iren korekt ashxatelu hamar
    @Override
    public int getItemCount() {

        return bloteNotes.size();
    }

    //-------------------------------------------------------------------------------
//_______________________________________________________________________________
//-------------------------   nor clas e HashviViewHolder -----------------------
//stexcum enq HashviViewHolder- clasn, vorn jarangum e  zavaskoy RecyclerView.ViewHolder-ic
//HashivAdapter -i pereapredlyonni 2 metodnern el use en mer ays clasi ekzempliarn.
//mek@ myusin poxancelov nuyn ekzempliarn
//ays jarang clasn uni static metod ev menq partavor en ayn realizacnenq
    public class HashviViewHolder extends RecyclerView.ViewHolder {

        public TextView
                txtView_kom1, txtView_order, txtView_kom2;
        public ImageView imageView;

        //ushadrutyun darcu vor ays metodn, mer nor sarqac clasi HashviViewHolder-i
//construktorin trvum e yuraqanchyur RecyclerView-n, vorn ays metodi mej kochvum e itemView
        public HashviViewHolder(View view) {
            super(view);
            txtView_kom1 = view.findViewById(R.id.txtView_kom1);
            txtView_kom2 = view.findViewById(R.id.txtView_kom2);
            imageView = itemView.findViewById(R.id.Img_mast);
            txtView_order = view.findViewById(R.id.txtView_order);
        }
    }


}