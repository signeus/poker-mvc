package com.apps.kev.pokermvc.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.kev.pokermvc.R;

import logic.interfaces.INgCalculate;
import logic.NgCalculate;
import models.Messages;
import models.PokerStats;
import models.ResultStat;

public class MainActivity extends AppCompatActivity {

    //Declaración de objetos EditText
    EditText etSB; //Declaracion de un objeto EditText llamado etSB
    EditText etBB; //Declaracion de un objeto EditText llamado etBB
    EditText etAN; //Declaracion de un objeto EditText llamado etAN
    Button btnCAL;  //Declaracion de un objeto Button llamado btnCAL

    //Declaración de objetos TextView
    TextView tvSB;
    TextView tvBB;
    TextView tvAN;
    TextView tvST;
    TextView tvPL;
    TextView tvLO;

    PokerStats stats = new PokerStats();

    EditText etST; //Declaracion de un objeto EditText llamado etST
    EditText etPL; //Declaracion de un objeto EditText llamado etPL
    EditText etLO; //Declaracion de un objeto EditText llamado etLO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText
        etSB = (EditText) findViewById(R.id.edtSmallBlind);
        etBB = (EditText)findViewById(R.id.edtBigBlind);
        etAN = (EditText)findViewById(R.id.edtAnte);
        etST = (EditText)findViewById(R.id.edtStack);
        etPL = (EditText)findViewById(R.id.edtPlayers);
        etLO = (EditText)findViewById(R.id.edtLeftOpponents);

        //TextView
        tvSB = (TextView) findViewById(R.id.txvSmallBlind);
        tvBB = (TextView)findViewById(R.id.txvBigBlind);
        tvAN = (TextView)findViewById(R.id.txvAnte);
        tvST = (TextView)findViewById(R.id.txvStack);
        tvPL = (TextView)findViewById(R.id.txvPlayers);
        tvLO = (TextView)findViewById(R.id.txvLeftOpponents);

        //Buttons
        btnCAL = (Button) findViewById(R.id.btnCalculate);

        etSB.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if((etBB != null && !"".equals(etBB.getText().toString())) && (etSB != null && "".equals(etSB.getText().toString())))
                {
                    etSB.setText(String.valueOf(Integer.parseInt(etBB.getText().toString()) / 2));
                    //return true;
                }
                return false;
            }
        });
        etBB.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if((etSB != null && !"".equals(etSB.getText().toString())) && (etBB != null && "".equals(etBB.getText().toString())))
                {
                    etBB.setText(String.valueOf(Integer.parseInt(etSB.getText().toString()) * 2));
                    //return true;
                }
                return false;
            }
        });

        etPL.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    if(etPL != null && !"".equals(etPL.getText().toString())) {
                        stats.setPlayers(0);
                        if (!(etPL.getText().toString().matches(getString(R.string.numberInteger)))) {
                            etPL.setText("");
                            Toast.makeText(getApplicationContext(), getString(R.string.NotIntegerNumber), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        int players = Integer.parseInt(etPL.getText().toString());
                        if(players > 10)
                        {
                            etPL.setText("");
                            Toast.makeText(getApplicationContext(), getString(R.string.TooManyPlayers), Toast.LENGTH_LONG).show();
                            return;
                        }
                        //The number of players is correct
                        stats.setPlayers(players);
                    }
                }
            }
        });

        etLO.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    if(etLO != null && !"".equals(etLO.getText().toString())) {
                        stats.setPlayers(0);
                        TextView txvPL = (TextView) findViewById(R.id.txvPlayers);
                        TextView txvLO = (TextView) findViewById(R.id.txvLeftOpponents);
                        if (!(etLO.getText().toString().matches(getString(R.string.numberInteger)))) {
                            etLO.setText("");
                            Toast.makeText(getApplicationContext(), getString(R.string.NotIntegerNumber), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (etPL != null && !(etPL.getText().toString().matches(getString(R.string.numberInteger)))) {
                            Messages msg = new Messages();
                            String[] fields = {txvPL.getText().toString()};
                            Toast.makeText(getApplicationContext(),
                                    msg.messageError(fields,"IsRequired",getApplicationContext()),
                                    Toast.LENGTH_LONG).show();
                            return;
                        }
                        int players = Integer.parseInt(etPL.getText().toString());
                        int leftOpponents = Integer.parseInt(etLO.getText().toString());
                        if(leftOpponents > (players - 1))
                        {
                            etLO.setText("");
                            Messages msg = new Messages();
                            String[] fields = {txvLO.getText().toString(), txvPL.getText().toString()};
                            Toast.makeText(getApplicationContext(),
                                    msg.messageError(fields,"LowerThan",getApplicationContext()),
                                    Toast.LENGTH_LONG).show();
                            return;
                        }
                        //The number of players is correct
                        stats.setLeftOpponents(leftOpponents);
                    }
                }
            }
        });


        btnCAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                try{
                   String smallBlind = etSB.getText().toString();
                    if(!(smallBlind.matches(getString(R.string.numberInteger)))){
                        Messages msg = new Messages();
                        String[] fields = {tvSB.getText().toString()};
                        Toast.makeText(getApplicationContext(),
                                msg.messageError(fields,"IsRequired",getApplicationContext()),
                                Toast.LENGTH_LONG).show();
                        return;
                    }
                    stats.setSmallBlind(Integer.parseInt(smallBlind));
                    String bigBlind = etBB.getText().toString();
                    if(!bigBlind.matches(getString(R.string.numberInteger))){
                        Messages msg = new Messages();
                        String[] fields = {tvBB.getText().toString()};
                        Toast.makeText(getApplicationContext(),
                                msg.messageError(fields,"IsRequired",getApplicationContext()),
                                Toast.LENGTH_LONG).show();
                        return;
                    }
                    stats.setBigBlind(Integer.parseInt(bigBlind));

                    String ante = etAN.getText().toString();
                    if(!"".equals(ante))
                        stats.setAnte(Integer.parseInt(ante));

                    String stack = etST.getText().toString();
                    if(!stack.matches(getString(R.string.numberInteger))) {
                        Messages msg = new Messages();
                        String[] fields = {tvST.getText().toString()};
                        Toast.makeText(getApplicationContext(),
                                msg.messageError(fields, "IsRequired", getApplicationContext()),
                                Toast.LENGTH_LONG).show();
                        return;
                    }
                    stats.setStack(Integer.parseInt(stack));

                    String players = etPL.getText().toString();
                    if(!players.matches(getString(R.string.numberInteger))){
                        Messages msg = new Messages();
                        String[] fields = {tvPL.getText().toString()};
                        Toast.makeText(getApplicationContext(),
                                msg.messageError(fields,"IsRequired",getApplicationContext()),
                                Toast.LENGTH_LONG).show();
                        return;
                    }
                    stats.setPlayers(Integer.parseInt(players));

                    String leftOpponent = etLO.getText().toString();
                    if(!leftOpponent.matches(getString(R.string.numberInteger))){
                        Messages msg = new Messages();
                        String[] fields = {tvLO.getText().toString()};
                        Toast.makeText(getApplicationContext(),
                                msg.messageError(fields,"IsRequired",getApplicationContext()),
                                Toast.LENGTH_LONG).show();
                        return;
                    }
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
                    Messages msg = new Messages();
                    Toast.makeText(getApplicationContext(),
                            msg.messageError(null, msg.getErrorSomethingIsHasFailed() ,getApplicationContext()),
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
