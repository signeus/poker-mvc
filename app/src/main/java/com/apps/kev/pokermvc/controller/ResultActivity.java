package com.apps.kev.pokermvc.controller;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.apps.kev.pokermvc.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int CPRvalue = getIntent().getIntExtra("CPR", 0);
        double CSIvalue = getIntent().getDoubleExtra("CSI", 0);
        double PNvalue = getIntent().getDoubleExtra("PN", 0);
        EditText CPR = (EditText) findViewById(R.id.edtCPR);
            CPR.setText(String.valueOf(CPRvalue));
        EditText CSI = (EditText) findViewById(R.id.edtCSI);
            CSI.setText(String.valueOf(CSIvalue));
        EditText PN = (EditText) findViewById(R.id.edtPN);
            PN.setText(String.valueOf(PNvalue));
    }
}
