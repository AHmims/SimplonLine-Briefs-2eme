package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //
        Button btn = (Button) findViewById(R.id.button_second);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //
        Intent intent = getIntent();
        ((TextView) findViewById(R.id.textView7)).setText(intent.getStringExtra("nom"));
        ((TextView) findViewById(R.id.textView8)).setText(intent.getStringExtra("prenom"));
        ((TextView) findViewById(R.id.textView9)).setText(intent.getStringExtra("age"));
        ((TextView) findViewById(R.id.textView10)).setText(intent.getStringExtra("email"));
    }
}