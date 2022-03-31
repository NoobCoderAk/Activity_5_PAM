package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    Context mContext;

    //deklarasi variable dengan jenis data layout inflater
    LayoutInflater inflater;

    //deklarasi variable dengan jenis data arrayList
    private ArrayList<ClassNama> arrayList;

    //membuat konstruktor LIstViewadapter
    public ListViewAdapter(Context context){
        //memberi nilai mContext dengan context
        mContext = context;

        //mengatur layoutflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //memberikan nilai arraylist dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //menambahkan semua element ke arraylist
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }

    @Override
    public int getCount() {
        return Home_Activity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Home_Activity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variable dengan jenis data viewholer
        final ViewHolder holder;

        //membuat kondisi apakah view null atau tidak
        if (view == null){

            //membuat objek view holder
            holder = new ViewHolder();

            //mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview,null);

            //set id untuk textview
            holder.name = (TextView) view.findViewById((R.id.tvnama_item));

            //menyimpan data dalam tampil tanpa menggunakan struktur dta lain
            view.setTag(holder);
        }

        else{
            //mengatur holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder) view.getTag();
        }
        // set item ke TextViews
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getNama());

        //mengamnbil nilai ke variable view
        return view;
    }
}


