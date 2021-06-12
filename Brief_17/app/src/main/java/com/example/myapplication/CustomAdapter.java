package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class CustomAdapter extends BaseAdapter implements ListAdapter {
    private List<Candidat> list = new ArrayList<>();
    private Context context;

    public CustomAdapter(List<Candidat> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Candidat getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DbManager dbManager = new DbManager(parent.getContext());
        View view = convertView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = inflater.inflate(R.layout.row_layout, null);
        }

        //
        TextView id = (TextView) view.findViewById(R.id.canId);
        TextView name = (TextView) view.findViewById(R.id.canName);
        TextView email = (TextView) view.findViewById(R.id.canEmail);

        Candidat candidat = list.get(position);

        id.setText(candidat.getId() + "");
        name.setText(String.format("%s %s", candidat.getNom(), candidat.getPrenom()));
        email.setText(candidat.getEmail());

        //
        Button editBtn = (Button) view.findViewById(R.id.edit);
        Button deleteBtn = (Button) view.findViewById(R.id.delete);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFrag(list.get(position));
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbManager.delete(list.get(position));
                list.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    //
    //
    private void resetFrag(Candidat candidat) {
        Intent intent = new Intent("call.fragment_add_item.switch");
        intent.putExtra("candidat", candidat);
        context.sendBroadcast(intent);
    }
}
