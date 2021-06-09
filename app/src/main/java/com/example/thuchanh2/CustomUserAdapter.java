package com.example.thuchanh2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomUserAdapter extends BaseAdapter {
    Context ctx;
    int layoutitem;
    ArrayList<User> arrayList;


    //

    public CustomUserAdapter(Context ctx, int layoutitem, ArrayList<User> arrayList) {
        this.ctx = ctx;
        this.layoutitem = layoutitem;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(ctx).inflate(layoutitem, viewGroup, false);
        TextView txtId = view.findViewById(R.id.tv_id);
        TextView txtEmail = view.findViewById(R.id.tv_email);
        TextView txtPassoword = view.findViewById(R.id.tv_password);


        txtId.setText(arrayList.get(i).getId());
        txtEmail.setText(arrayList.get(i).getEmail());
        txtPassoword.setText(arrayList.get(i).getPassword());
        return view;

    }
}

