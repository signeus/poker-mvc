package com.apps.kev.pokermvc.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.kev.pokermvc.R;

import logic.interfaces.INgCalculate;
import logic.NgCalculate;
import models.PokerStats;
import models.ResultStat;

public class MainActivity extends AppCompatActivity {

    EditText etSB; //Declaracion de un objeto EditText llamado etSB
    EditText etBB; //Declaracion de un objeto EditText llamado etBB
    EditText etAN; //Declaracion de un objeto EditText llamado etAN
    Button btnCAL;  //Declaracion de un objeto Button llamado btnCAL
    PokerStats stats = new PokerStats();


    EditText etST; //Declaracion de un objeto EditText llamado etST
    EditText etPL; //Declaracion de un objeto EditText llamado etPL
    EditText etLO; //Declaracion de un objeto EditText llamado etLO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSB = (EditText) findViewById(R.id.edtSmallBlind);
        etBB = (EditText)findViewById(R.id.edtBigBlind);
        etAN = (EditText)findViewById(R.id.edtAnte);
        etST = (EditText)findViewById(R.id.edtStack);
        etPL = (EditText)findViewById(R.id.edtPlayers);
        etLO = (EditText)findViewById(R.id.edtLeftOpponents);
        btnCAL = (Button) findViewById(R.id.btnCalculate);

        btnCAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                try{
                   String smallBlind = etSB.getText().toString();
                    if(!"".equals(smallBlind))
                        stats.setSmallBlind(Integer.parseInt(smallBlind));
                    String bigBlind = etBB.getText().toString();
                    if(!"".equals(bigBlind))
                        stats.setBigBlind(Integer.parseInt(bigBlind));
                    String ante = etAN.getText().toString();
                    if(!"".equals(ante))
                        stats.setAnte(Integer.parseInt(ante));
                    String stack = etST.getText().toString();
                    if(!"".equals(stack))
                        stats.setStack(Integer.parseInt(stack));
                    String players = etPL.getText().toString();
                    if(!"".equals(players))
                        stats.setPlayers(Integer.parseInt(players));
                    String leftOpponent = etLO.getText().toString();
                    if(!"".equals(leftOpponent))
                        stats.setLeftOpponents(Integer.parseInt(leftOpponent));
                    INgCalculate iNgCalculate = new NgCalculate();
                    ResultStat resultStat = iNgCalculate.calculate(stats);
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("CPR", resultStat.getCPR());
                    intent.putExtra("CSI", resultStat.getCSI());
                    intent.putExtra("PN", resultStat.getPN());
                    startActivity(intent);
                }catch(Exception ex)
                {
                    Toast.makeText(getApplicationContext(), "Petó!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
