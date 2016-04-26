package models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

/**
 * Created by Kev on 25/04/2016.
 */
public class PowerNumbers {
    private int numCards;

    public PowerNumbers(int numCards){
        this.numCards = numCards;
    }
    public PowerNumbers(){
        this.numCards = 13;
    }


    /*
    private Dictionary<Hand, String> powerNumberDictionary = new Dictionary<Hand, String>() {
        @Override
        public Enumeration<String> elements() {
            //Column
            for (int i = 1; i==numCards; i++){
                //Row
                for(int j = 1; j==numCards; j++){
                    Hand actualHand = new Hand(new Card(i),new Card(j),)
                    powerNumberDictionary.put(new Hand(new Card(i),new Card(j)),)
                }
            }
        }

        @Override
        public String get(Object key) {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Enumeration<Hand> keys() {
            return null;
        }

        @Override
        public String put(Hand key, String value) {
            return null;
        }

        @Override
        public String remove(Object key) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    };
    */
}
