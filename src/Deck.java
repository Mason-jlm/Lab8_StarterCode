
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck{
    List<Card> cards = new ArrayList<Card>();
    public Deck(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                cards.add(new Card(rank, suit));
            }
        }

    }
    public Card draw(){
        if(cards.isEmpty()){
            return null;
        }
        return cards.remove(0);

    }
    public List<Card> draw(int n){
        List<Card> drawnCards = new ArrayList<Card>();
        while(n>0 && !cards.isEmpty()){
            drawnCards.add(cards.remove(0));
            n--;
        }
        return drawnCards;
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public int size(){
        return cards.size();
    }   
    public String toString(){
        return cards.toString();
    }
    public List<Card> getCardsByRank(Rank rank){
        List<Card> filteredCards = new ArrayList<Card>();
        for(Card card : cards){
            if(card.getRank() == rank){
                filteredCards.add(card);
            }
        }
        return filteredCards;
    }
}