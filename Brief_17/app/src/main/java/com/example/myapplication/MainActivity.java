package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbManager dbManager = new DbManager(this);

        ((ListView) findViewById(R.id.listView)).setAdapter(new CustomAdapter(dbManager.getAll(), this));

        BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Candidat candidat = (Candidat) intent.getSerializableExtra("candidat");
                Bundle args = new Bundle();

                args.putInt("id", candidat.getId());
                args.putString("nom", candidat.getNom());
                args.putString("prenom", candidat.getPrenom());
                args.putString("email", candidat.getEmail());

                AddItem frag = new AddItem();
                frag.setArguments(args);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, frag, null).commit();
            }
        };

        this.registerReceiver(mBroadcastReceiver, new IntentFilter("call.fragment_add_item.switch"));

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!FragStat.ADD_FRAG) {
                    Bundle bundle = new Bundle();
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                            .add(R.id.fragmentContainerView, AddItem.class, bundle).commit();
                    FragStat.ADD_FRAG = true;
                }
            }
        });
    }
}