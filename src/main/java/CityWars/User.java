package CityWars;

import java.sql.*;
import java.util.ArrayList;

public class User {
    public User (String username, String nickname, String email) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
    }
    private int id;
    public String username = "";
    public String password = "";
    public String nickname = "";
    public String email = "";
    public String[] securityQuestion = new String[3];//مانند دیتابیس شود
    public ArrayList<SpecialCard> specialCardsPlayer = new ArrayList<>();//روش فکر شود! چت جی پی تی
    public ArrayList<Card> CardsPlayer = new ArrayList<>();//روش فکر شود! چت جی پی تی
    public ArrayList<HistoryGame> historyGamePlayer = new ArrayList<>();//روش فکر شود! چت جی پی تی
    public int level = 30;//به دیتابیس اضافه شود
    public int HP = 100;
    public int XP = 0;
    private int XPlevelup=10;
    public double coin = 1000;

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<HistoryGame> getHistoryGame() {
        return historyGamePlayer;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public void setXPlevelup(int XPlevelup) {
        this.XPlevelup = XPlevelup;
    }

    public int getXPlevelup() {
        return XPlevelup;
    }
    private String Charecter;


    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public int getXP() {
        return XP;
    }

    public int getHP() {
        return HP;
    }

    public String getCharecter() {
        return Charecter;
    }

    public void setCharecter(String charecter) {
        Charecter = charecter;
    }


    public int getLevel() {
        return level;
    }

    public String getNickname() {
        return nickname;
    }
    public void setCoin(double coin) {
        this.coin = coin;
    }

    public double getCoin() {
        return coin;
    }

    // متد برای ذخیره کاربر و داده‌های مرتبط در دیتابیس
    public void saveToDatabase(Connection connection) throws SQLException {
        // ذخیره کاربر
        String query = "INSERT INTO users (username, password, nickname, email, security_question1, security_question2, security_question3, level, HP, XP, XPlevelup, coin, charecter) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, nickname);
            stmt.setString(4, email);
            stmt.setString(5, securityQuestion[0]);
            stmt.setString(6, securityQuestion[1]);
            stmt.setString(7, securityQuestion[2]);
            stmt.setInt(8, level);
            stmt.setInt(9, HP);
            stmt.setInt(10, XP);
            stmt.setInt(11, XPlevelup);
            stmt.setDouble(12, coin);
            stmt.setString(13, Charecter);
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                this.id = generatedKeys.getInt(1);
            }
        }

        // ذخیره کارت‌های خاص
        for (SpecialCard card : specialCardsPlayer) {
            card.saveToDatabase(connection, this.id);
        }

        // ذخیره کارت‌ها
        for (Card card : CardsPlayer) {
            card.saveToDatabase(connection, this.id);
        }

        // ذخیره تاریخچه بازی‌ها
        for (HistoryGame game : historyGamePlayer) {
            game.saveToDatabase(connection, this.id);
        }
    }

    // متد برای لود کردن کاربر و داده‌های مرتبط از دیتابیس
    public static User loadFromDatabase(Connection connection, String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("nickname"), rs.getString("email"));
                user.id = rs.getInt("id");
                user.password = rs.getString("password");
                user.securityQuestion[0] = rs.getString("security_question1");
                user.securityQuestion[1] = rs.getString("security_question2");
                user.securityQuestion[2] = rs.getString("security_question3");
                user.level = rs.getInt("level");
                user.HP = rs.getInt("HP");
                user.XP = rs.getInt("XP");
                user.XPlevelup = rs.getInt("XPlevelup");
                user.coin = rs.getDouble("coin");
                user.Charecter = rs.getString("charecter");

                // لود کردن کارت‌های خاص
                user.specialCardsPlayer = (ArrayList<SpecialCard>) SpecialCard.loadFromDatabase(connection, user.id);

                // لود کردن کارت‌ها
                user.CardsPlayer = (ArrayList<Card>) Card.loadFromDatabase(connection, user.id);

                // Load game history
                user.historyGamePlayer = (ArrayList<HistoryGame>) HistoryGame.loadFromDatabase(connection, user.id);


                return user;
            }
        }
        return null;
    }
}
