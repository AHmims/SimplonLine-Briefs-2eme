package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.renderscript.RenderScript;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddItem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddItem extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddItem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddItem.
     */
    // TODO: Rename and change types and number of parameters
    public static AddItem newInstance(String param1, String param2) {
        AddItem fragment = new AddItem();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DbManager dbManager = new DbManager(getActivity());
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_add_item, container, false);

        ((EditText) root.findViewById(R.id.editTextTextId)).setEnabled(false);

        int id = requireArguments().getInt("id");
        String nom = requireArguments().getString("nom");
        String prenom = requireArguments().getString("prenom");
        String email = requireArguments().getString("email");

        List<Candidat> candidats = dbManager.getAll();

        ((EditText) root.findViewById(R.id.editTextTextId)).setText(id != 0 ? id + "" : candidats.isEmpty() ? "1" : candidats.get(candidats.size() - 1).getId() + 1 + "");
        ((EditText) root.findViewById(R.id.editTextTextNom)).setText(nom != null ? nom : "");
        ((EditText) root.findViewById(R.id.editTextTextPrenom)).setText(prenom != null ? prenom : "");
        ((EditText) root.findViewById(R.id.editTextTextEmail)).setText(email != null ? email : "");

        boolean isAdd = nom == null || nom.equals("");
        if (!isAdd) {
            ((Button) root.findViewById(R.id.action)).setText("Modifier");
        }

        root.findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragStat.ADD_FRAG = false;
                container.removeView(root);
            }
        });

        root.findViewById(R.id.action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Candidat candidat = new Candidat();
                candidat.setId(Integer.parseInt(((EditText) root.findViewById(R.id.editTextTextId)).getText().toString()));
                candidat.setNom(((EditText) root.findViewById(R.id.editTextTextNom)).getText().toString());
                candidat.setPrenom(((EditText) root.findViewById(R.id.editTextTextPrenom)).getText().toString());
                candidat.setEmail(((EditText) root.findViewById(R.id.editTextTextEmail)).getText().toString());

                if (isAdd) {
                    dbManager.insert(candidat);
                } else {
                    dbManager.update(candidat);
                }

                Log.println(Log.DEBUG, "data", dbManager.getAll().size() + "");
            }
        });

        return root;
    }
}