import java.util.ArrayList;

public class Char {
    public ArrayList<Card> Cards = new ArrayList<>();
    private String Name ;

    public String getName() {
        return Name;
    }

    public Char(String name) {
        Name = name;
    }

    public ArrayList<Card> getCards() {
        return Cards;
    }

    public void setCards(ArrayList<Card> cards) {
        Cards = cards;
    }

    public static Char returnCharByName(String Name){
        for (Char char1 : Main.carecter){
            if (char1.getName().equals(Name)) {
                return char1;
            }
        }
        return null;
    }

}
