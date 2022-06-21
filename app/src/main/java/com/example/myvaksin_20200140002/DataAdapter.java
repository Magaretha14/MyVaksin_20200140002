package com.example.myvaksin_20200140002;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.myvaksin_20200140002.MainActivity;
import com.example.myvaksin_20200140002.R;
import com.example.myvaksin_20200140002.database.dbVaksin;
import com.example.myvaksin_20200140002.database.DataVaksin;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.VaksinViewHolder> {
    private ArrayList<DataVaksin> listData;
    private Context control;

    public DataAdapter(ArrayList<DataVaksin> listData) {
        this.listData = listData;
    }

    @Override
    public DataAdapter.VaksinViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.list_item_vaksin,parent,false);
        control = parent.getContext();
        return new VaksinViewHolder(view);
    }

    @Override
    public void onBindViewHolder( DataAdapter.VaksinViewHolder holder, int position) {
        String nik,nm,ttl,tglv,alt,na;

        na = listData.get(position).getNa();
        nik = listData.get(position).getNIK();
        nm = listData.get(position).getNama();
        ttl = listData.get(position).getTtl();
        tglv = listData.get(position).getTglv();
        alt = listData.get(position).getAlamat();
        dbVaksin db = new dbVaksin(control);

        holder.namaTxt.setTextColor(Color.BLUE);
        holder.namaTxt.setTextSize(30);
        holder.namaTxt.setText(nm);
        holder.tglvTxt.setText(tglv);


        holder.cardku.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(control, holder.cardku);
                popupMenu.inflate(R.menu.popupmenu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            //Popup untuk melihat detail data
                            case R.id.mndetail:
                                Intent i = new Intent (control, ProfileActivity.class);
                                i.putExtra("na",na);
                                i.putExtra("NIK",nik);
                                i.putExtra("Nama",nm);
                                i.putExtra("Ttl",ttl);
                                i.putExtra("Tglv",tglv);
                                i.putExtra("Alamat",alt);
                                control.startActivity(i);
                                break;
                                //Popup untuk mengedit data
                            case R.id.mnedit:
                                Intent j = new Intent (control, edit_data_vaksin.class);
                                j.putExtra("na",na);
                                j.putExtra("NIK",nik);
                                j.putExtra("Nama",nm);
                                j.putExtra("Ttl",ttl);
                                j.putExtra("Tglv",tglv);
                                j.putExtra("Alamat",alt);
                                control.startActivity(j);
                                break;
                                //Popup untuk menghapus data
                            case R.id.mnHapus:
                                HashMap<String,String> values = new HashMap<>();
                                values.put("na",na);
                                db.DeleteData(values);
                                Intent h = new Intent(control, DaftarData.class);
                                control.startActivity(h);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return (listData != null)?listData.size() : 0;
    }

    public class VaksinViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView namaTxt,tglvTxt;
        public VaksinViewHolder(View view) {
            super(view);
            cardku = (CardView) itemView.findViewById(R.id.kartuku);
            namaTxt = (TextView) view.findViewById(R.id.textNama);
            tglvTxt = (TextView) view.findViewById(R.id.textTanggalVaksin);
        }
    }
}
