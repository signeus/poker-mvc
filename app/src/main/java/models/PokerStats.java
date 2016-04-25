package models;

/**
 * Created by Kev on 20/04/2016.
 */
public class PokerStats {
    private int smallBlind;
    private int bigBlind;
    private int ante;
    private int stack;
    private int players;
    private int leftOpponents;

    public PokerStats()
    {
        this.smallBlind = 0;
        this.bigBlind = 0;
        this.ante = 0;
        this.stack = 0;
        this.players = 0;
        this.leftOpponents = 0;
    }

    public PokerStats(int smallBlind, int bigBlind, int ante, int stack, int players, int leftOpponents){
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
        this.ante = ante;
        this.stack = stack;
        this.players = players;
        this.leftOpponents = leftOpponents;
    }
    public int getSmallBlind(){
        return smallBlind;
    }
    public int getBigBlind(){
        return bigBlind;
    }
    public int getAnte(){
        return ante;
    }
    public int getStack(){
        return stack;
    }
    public int getPlayers(){
        return players;
    }
    public int getLeftOpponents(){
        return leftOpponents;
    }
    public void setSmallBlind(int smallBlind){
        this.smallBlind = smallBlind;
    }
    public void setBigBlind(int bigBlind){
        this.bigBlind = bigBlind;
    }
    public void setAnte(int ante){
        this.ante = ante;
    }
    public void setStack(int stack){
        this.stack = stack;
    }
    public void setPlayers (int players){
        this.players = players;
    }
    public void setLeftOpponents(int leftOpponents){
        this.leftOpponents = leftOpponents;
    }
}
