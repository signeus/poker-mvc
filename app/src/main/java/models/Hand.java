package models;

/**
 * Created by Kev on 25/04/2016.
 */
public class Hand {
    private Card leftCard;
    private Card rightCard;

    public Hand(Card leftCard, Card rightCard){
        this.leftCard = leftCard;
        this.rightCard = rightCard;
    }
    public Card getRightCard(){
        return rightCard;
    }
    public Card getLeftCard(){
        return leftCard;
    }
    public void setRightCard(Card rightCard){
        this.rightCard = rightCard;
    }
    public void setLeftCard(Card leftCard){
        this.leftCard = leftCard;
    }
}
