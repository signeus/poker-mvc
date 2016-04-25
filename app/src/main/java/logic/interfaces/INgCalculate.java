package logic.interfaces;

import models.PokerStats;
import models.ResultStat;

/**
 * Created by Kev on 24/04/2016.
 */
public interface INgCalculate {
    public boolean isLogicalBlind(int small, int big);
    public ResultStat calculate (PokerStats stats);
}
