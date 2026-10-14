
import java.util.Objects;

public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        if (rank == null || suit == null) {
            throw new NullPointerException("Rank or Suit cannot be null");
        }
        this.rank = rank;
        this.suit = suit;
    }
    public Rank getRank() {
        return rank;
    }
    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card card2) {
        if(this.rank==Rank.ACE && card2.getRank()==Rank.TWO){
            return -1;
        }
        if(this.rank==Rank.TWO && card2.getRank()==Rank.ACE){
            return 1;
        }
        if(this.rank.compareTo(card2.getRank())==0){
            return this.suit.compareTo(card2.getSuit());
        }
        return this.rank.compareTo(card2.getRank());
    }
    public String toString() {
        return rank.toString() + suit.toString();
    }
    public boolean equals(Object obj) {
        if(obj instanceof Card){
            Card card2 = (Card)obj;
            return this.rank.equals(card2.getRank()) && this.suit.equals(card2.getSuit());
        }
        return false;
    }
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
    
}