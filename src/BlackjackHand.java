import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
        public BlackjackHand(Card card1,Card card2){
            if(card1 == null || card2 == null){
                throw new NullPointerException("Card cannot be null");
            }
            cards.add(card1);
            cards.add(card2);
            value=getValue();
        }
        
       public static final int MAX_VALUE = 21;
       public List<Card> cards = new ArrayList<Card>();
       public int value;
       public int numAcesas11;
        public static Map<Rank, Integer> CARD_VALUES;
        
       static {
       
        CARD_VALUES =new HashMap<Rank, Integer>();
        CARD_VALUES.put(Rank.TWO, 2);
        CARD_VALUES.put(Rank.THREE, 3);
        CARD_VALUES.put(Rank.FOUR, 4);
        CARD_VALUES.put(Rank.FIVE, 5);
        CARD_VALUES.put(Rank.SIX, 6);
        CARD_VALUES.put(Rank.SEVEN, 7);
        CARD_VALUES.put(Rank.EIGHT, 8);
        CARD_VALUES.put(Rank.NINE, 9);
        CARD_VALUES.put(Rank.TEN, 10);
        CARD_VALUES.put(Rank.JACK, 10);
        CARD_VALUES.put(Rank.QUEEN, 10);
        CARD_VALUES.put(Rank.KING, 10);
        CARD_VALUES.put(Rank.ACE, 11);}
        public void addCard(Card card) {
            if (card == null) {
                throw new NullPointerException("Card cannot be null");
            }
            if(getValue() < MAX_VALUE){
                cards.add(card);
                value=getValue();
            }


        }
        public List<Card> getCards() {
            return new ArrayList<Card>(cards);
        }
        public static Map<Rank, Integer> getCardValues() {
            return new HashMap<Rank, Integer>(CARD_VALUES);
        }
        public int size() {
            return cards.size();
        }
        public String toString() {
            return cards.toString();
        }
        public int getValue() {
            value = 0;
            numAcesas11 = 0;
            for(Card card : cards){
                value += CARD_VALUES.get(card.getRank());
                if(card.getRank() == Rank.ACE){
                    numAcesas11++;
                }
            }
            while(value > MAX_VALUE && numAcesas11 > 0){
                value -= 10;
                numAcesas11--;
            }
            return value;
        }
    }
