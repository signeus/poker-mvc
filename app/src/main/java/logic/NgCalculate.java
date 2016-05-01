package logic;

import logic.interfaces.INgCalculate;
import models.PokerStats;
import models.ResultStat;

/**
 * Created by Kev on 24/04/2016.
 */
public class NgCalculate implements INgCalculate {
    public ResultStat calculate(PokerStats stat)
    {
        ResultStat resultStat = new ResultStat();
        int smallBlind = stat.getSmallBlind();
        int bigBlind = stat.getBigBlind();
        //Logical Blind
        if(isLogicalBlind(smallBlind, bigBlind)) {
            //Calculating CPR
            //Without Ante
            if (stat.getAnte() == 0) {
                resultStat.setCPR(smallBlind + bigBlind);
            }
            //With Ante
            if(stat.getAnte() != 0){
                resultStat.setCPR(smallBlind + bigBlind + (stat.getPlayers() * stat.getAnte()) );
            }

            //Calculating CSI
            resultStat.setCSI(stat.getStack() / resultStat.getCPR());

            //Calculating PN
            double number1 = stat.getLeftOpponents() * resultStat.getCSI();
            double oneFifth = smallBlind / 5;
            if(stat.getAnte() > oneFifth && stat.getPlayers() > 8){
                number1 -= ((number1*5)/100);
            }
            resultStat.setPN(number1);
        }
        return resultStat;
    }
    //@Override
    //public boolean isLogicalBlind(int small, int big)
    //{
    //    return (small*2 == big);
    //}
    @Override
    public boolean isLogicalBlind(int small, int big)
    {
        return (small <= big);
    }
}
