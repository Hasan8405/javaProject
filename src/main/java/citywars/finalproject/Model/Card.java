package citywars.finalproject.Model;

import java.util.ArrayList;

public class Card {
    private String Name;
    private int CardAttack;
    private int Duration;
    private int PlayerDamage;
    private int UpgradeLevel;
    private int UpgradeCost;
    private int price;
    private String charec;
    public static ArrayList<Card>cards=new ArrayList<>();

    public int getCardAttack() {
        return CardAttack;
    }

    public String getCharec() {
        return charec;
    }

    public int getPrice() {
        return price;
    }

    public int getUpgradeCost() {
        return UpgradeCost;
    }

    public int getUpgradeLevel() {
        return UpgradeLevel;
    }

    public int getPlayerDamage() {
        return PlayerDamage;
    }

    public int getDuration() {
        return Duration;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public Card(String Name, int CardAttack, int Duration, int PlayerDamage, int UpgradeLevel, int UpgradeCost, int price, String charec) {
        this.Name = Name;
        this.CardAttack=CardAttack;
        this.Duration=Duration;
        this.charec=charec;
        this.PlayerDamage=PlayerDamage;
        this.UpgradeLevel=UpgradeLevel;
        this.UpgradeCost=UpgradeCost;
        this.price=price;
    }



    public static Boolean CheckName(String name){
        for (Card card:cards){
            if (card.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static Card returnCardbyName(String name){
        for (Card card:cards){
            if (card.getName().equals(name)) {
                return card;
            }
        }
        return null;
    }
}
