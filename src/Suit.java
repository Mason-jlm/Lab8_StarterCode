
public enum Suit {

CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private final String value;
    Suit(String value){
        this.value = value;
    }
    public String toString(){
        return value;
    }
}
