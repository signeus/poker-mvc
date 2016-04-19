package com.apps.kev.pokermvc.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.apps.kev.pokermvc.R;

public class MainActivity extends AppCompatActivity {

    EditText etSB; //Declaracion de un objeto EditText llamado etSB
    EditText etBB; //Declaracion de un objeto EditText llamado etBB
    EditText etAN; //Declaracion de un objeto EditText llamado etAN
    Button btnCAL;  //Declaracion de un objeto Button llamado btnCAL
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSB = (EditText) findViewById(R.id.edtSmallBlind);
        etBB = (EditText)findViewById(R.id.edtBigBlind);
        etAN = (EditText)findViewById(R.id.edtAnte);
        btnCAL = (Button) findViewById(R.id.btnCalculate);

        btnCAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });
    }
    private void Calculate()
    {
        //int smallBlind = findViewById(R.id.edtSmallBlind);
    }
}
