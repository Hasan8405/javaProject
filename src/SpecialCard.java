import java.util.ArrayList;

public class SpecialCard {

    private String NameCard;
    private String Price;
    private String Description;

    public void setDescription(String description) {
        Description = description;
    }

    public String getDescription() {
        return Description;
    }

    public String getPrice() {
        return Price;
    }

    public String getNameCard() {
        return NameCard;
    }

    //    ArrayList<SpecialCard>specialCards=new ArrayList<>();
    public SpecialCard(String NameCard,String Price) {
        this.NameCard=NameCard;
        this.Price=Price;
//        specialCards.add(this);
    }
    public static Boolean Checkname(String name){
        for (SpecialCard card:Main.specialCards){
            if (card.getNameCard().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static SpecialCard returnSpecialbyName(String name){
        for (SpecialCard card:Main.specialCards){
            if (card.getNameCard().equals(name)) {
             return card;
            }
        }
        return null;
    }
}
