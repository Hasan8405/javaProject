package CityWars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    // متد برای ذخیره کارت در دیتابیس
    public void saveToDatabase(Connection connection, int userId) throws SQLException {
        String query = "INSERT INTO cards (user_id, name, card_attack, duration, player_damage, upgrade_level, upgrade_cost, price, charec) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, Name);
            stmt.setString(3, CardAttack);
            stmt.setString(4, Duration);
            stmt.setString(5, PlayerDamage);
            stmt.setString(6, UpgradeLevel);
            stmt.setString(7, UpgradeCost);
            stmt.setString(8, price);
            stmt.setString(9, charec);
            stmt.executeUpdate();
        }
    }

    // متد برای لود کردن کارت از دیتابیس
    public static List<Card> loadFromDatabase(Connection connection, int userId) throws SQLException {
        String query = "SELECT * FROM cards WHERE user_id = ?";
        List<Card> cards = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Card card = new Card(rs.getString("name"), rs.getString("card_attack"), rs.getString("duration"), rs.getString("player_damage"), rs.getString("upgrade_level"), rs.getString("upgrade_cost"), rs.getString("price"), rs.getString("charec"));
                cards.add(card);
            }
        }
        return cards;
    }

}
