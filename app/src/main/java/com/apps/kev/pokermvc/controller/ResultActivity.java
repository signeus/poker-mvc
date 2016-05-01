package com.apps.kev.pokermvc.controller;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;

import com.apps.kev.pokermvc.R;

import models.PowerNumberTable;
import models.ResultStat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int CPRvalue = getIntent().getIntExtra("CPR", 0);
        double CSIvalue = getIntent().getDoubleExtra("CSI", 0);
        double PNvalue = getIntent().getDoubleExtra("PN", 0);
        ResultStat resultStat = new ResultStat(CPRvalue, CSIvalue, PNvalue);
        EditText CPR = (EditText) findViewById(R.id.edtCPR);
            CPR.setText(String.valueOf(CPRvalue));
        EditText CSI = (EditText) findViewById(R.id.edtCSI);
            CSI.setText(String.valueOf(CSIvalue));
        EditText PN = (EditText) findViewById(R.id.edtPN);
            PN.setText(String.valueOf(PNvalue));


        TableLayout tableLayout = (TableLayout)findViewById(R.id.tblPowerNumbers);
        Context contextApp = getApplicationContext();
        PowerNumberTable tableNumber = new PowerNumberTable(tableLayout, contextApp, resultStat);
        tableLayout = tableNumber.getTableView();
    }
}
