package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Button btn = (Button) findViewById(R.id.button_first);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra("nom", isValid(findViewById(R.id.editTextTextNom), "nom"));
                    intent.putExtra("prenom", isValid(findViewById(R.id.editTextTextPrenom), "prenom"));
                    intent.putExtra("age", isValid(findViewById(R.id.editTextTextAge), "age"));
                    intent.putExtra("email", isValid(findViewById(R.id.editTextTextEmail), "email"));
                    intent.setType("text/plain");
                    // Try to invoke the intent.
                    startActivity(intent);
                } catch (Exception e) {
                    // Define what your app should do if no activity can handle the intent.
                    (Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG)).show();
                    Log.println(Log.ERROR, "bad", e.getLocalizedMessage());
                }
            }
        });
    }

    /**
     *
     */

    private String isValid(EditText input, String choix) throws Exception {
        String value = input.getText().toString();
        if (value.length() == 0)
            throw new Exception("Input can't be empty");
        if (choix == "age") {
            try {
                int age = Integer.parseInt(value);
                if (age <= 0)
                    throw new Exception("Age should be bigger than 0");
            } catch (NumberFormatException e) {
                throw new Exception("Age should be a number");
            }
        }
        return value;
    }
}