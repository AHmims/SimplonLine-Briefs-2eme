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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        CustomAdapter adapter = new CustomAdapter(dbManager.getAll(), this);

        ((ListView) findViewById(R.id.listView)).setAdapter(adapter);

        BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle args = new Bundle();

                Candidat candidat = (Candidat) intent.getSerializableExtra("candidat");

                args.putInt("id", candidat.getId());
                args.putString("nom", candidat.getNom());
                args.putString("prenom", candidat.getPrenom());
                args.putString("email", candidat.getEmail());

                if (!FragStat.ADD_FRAG && !FragStat.EDIT_FRAG) {
                    showFrag(AddItem.class, args);
                } else {
                    switchFrag(new AddItem(), args);
                }

                FragStat.ADD_FRAG = false;
                FragStat.EDIT_FRAG = true;
            }
        };

        this.registerReceiver(mBroadcastReceiver, new IntentFilter("call.fragment_add_item.switch"));

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();

                if (!FragStat.ADD_FRAG && !FragStat.EDIT_FRAG) {
                    showFrag(AddItem.class,args);
                } else {
                    switchFrag(new AddItem(),args);
                }

                FragStat.ADD_FRAG = true;
                FragStat.EDIT_FRAG = false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_add:
                Log.d(TAG, "onOptionsItemSelected: REFRESH");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //
    private void showFrag(Class fragClass, Bundle args) {
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .add(R.id.fragmentContainerView, fragClass, args).commit();
    }

    private void switchFrag(Fragment fragment, Bundle args) {
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
    }
}