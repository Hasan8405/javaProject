package citywars.finalproject.Model;

import java.util.ArrayList;

public class SpecialCard {

    private String NameCard;
    private String Price;

    public String getPrice() {
        return Price;
    }

    public String getNameCard() {
        return NameCard;
    }

    private String Description;
    private int duration;
    public static ArrayList<SpecialCard>specialCards=new ArrayList<>();
    public SpecialCard(String NameCard,String Price) {
        this.NameCard=NameCard;
        this.Price=Price;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static Boolean Checkname(String name){
        for (SpecialCard card:specialCards){
            if (card.getNameCard().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static SpecialCard returnSpecialbyName(String name){
        for (SpecialCard card:specialCards){
            if (card.getNameCard().equals(name)) {
                return card;
            }
        }
        return null;
    }
}
