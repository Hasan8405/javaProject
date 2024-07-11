package CityWars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    // متد برای ذخیره کارت خاص در دیتابیس
    public void saveToDatabase(Connection connection, int userId) throws SQLException {
        String query = "INSERT INTO special_cards (user_id, name, price, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, NameCard);
            stmt.setString(3, Price);
            stmt.setString(4, Description);
            stmt.executeUpdate();
        }
    }

    // متد برای لود کردن کارت خاص از دیتابیس
    public static List<SpecialCard> loadFromDatabase(Connection connection, int userId) throws SQLException {
        String query = "SELECT * FROM special_cards WHERE user_id = ?";
        List<SpecialCard> specialCards = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SpecialCard card = new SpecialCard(rs.getString("name"), rs.getString("price"));
                card.Description = rs.getString("description");
                specialCards.add(card);
            }
        }
        return specialCards;
    }
}


