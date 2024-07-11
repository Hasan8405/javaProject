import java.util.ArrayList;

public class Card {
    private String Name;
    private String CardAttack;
    private String Duration;
    private String PlayerDamage;
    private String UpgradeLevel;
    private String UpgradeCost;
    private String price;
    private String charec;


    public String getPrice() {
        return price;
    }

    public String getCharec() {
        return charec;
    }

    //     static ArrayList<Card>cards=new ArrayList<>();
    public Card(String Name,String CardAttack,String Duration,String PlayerDamage, String UpgradeLevel, String UpgradeCost,String price,String charec) {
        this.Name = Name;
        this.CardAttack=CardAttack;
        this.Duration=Duration;
        this.charec=charec;
        this.PlayerDamage=PlayerDamage;
        this.UpgradeLevel=UpgradeLevel;
        this.UpgradeCost=UpgradeCost;
//        cards.add(this);
    this.price=price;
    }

    public String getName() {
        return Name;
    }

    public static Boolean CheckName(String name){
        for (Card card:Main.cards){
            if (card.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static Card returnCardbyName(String name){
        for (Card card:Main.cards){
            if (card.getName().equals(name)) {
                return card;
            }
        }
        return null;
    }


    public void setUpgradeCost(String upgradeCost) {
        UpgradeCost = upgradeCost;
    }

    public void setUpgradeLevel(String upgradeLevel) {
        UpgradeLevel = upgradeLevel;
    }

    public void setPlayerDamage(String playerDamage) {
        PlayerDamage = playerDamage;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public void setCardAttack(String cardAttack) {
        CardAttack = cardAttack;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUpgradeCost() {
        return UpgradeCost;
    }

    public String getUpgradeLevel() {
        return UpgradeLevel;
    }

    public String getPlayerDamage() {
        return PlayerDamage;
    }

    public String getDuration() {
        return Duration;
    }

    public String getCardAttack() {
        return CardAttack;
    }

    public static void NameCard(){
        for (int i = 0; i < Main.cards.size(); i++) {
            System.out.println(i+1+"- "+Main.cards.get(i).getName());
        }
    }




}
