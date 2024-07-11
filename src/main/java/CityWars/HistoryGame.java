package CityWars;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryGame {

private String NameHarif;
private String awards;
private String LoseWin;
private LocalDateTime time;
private String levelHarif;

    public String getLevelHarif() {
        return levelHarif;
    }


    public String getLoseWin() {
        return LoseWin;
    }
    public LocalDateTime getTime() {
        return time;
    }

    public String getAwards() {
        return awards;
    }


    public String getNameHarif() {
        return NameHarif;
    }

    public HistoryGame(String nameHarif, LocalDateTime time, String award, String LoseWin, String levelHarif) {
        this.NameHarif = nameHarif;
        this.time = time;
        this.awards=award;
        this.LoseWin=LoseWin;
        this.levelHarif=levelHarif;
    }

    // متد برای ذخیره تاریخچه بازی در دیتابیس
    public void saveToDatabase(Connection connection, int userId) throws SQLException {
        String query = "INSERT INTO history_games (user_id, name_harif, awards, lose_win, time, level_harif) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, NameHarif);
            stmt.setString(3, awards);
            stmt.setString(4, LoseWin);
            stmt.setTimestamp(5, Timestamp.valueOf(time));
            stmt.setString(6, levelHarif);
            stmt.executeUpdate();
        }
    }

    // متد برای لود کردن تاریخچه بازی از دیتابیس
    public static List<HistoryGame> loadFromDatabase(Connection connection, int userId) throws SQLException {
        String query = "SELECT * FROM history_games WHERE user_id = ?";
        List<HistoryGame> historyGames = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                HistoryGame game = new HistoryGame(rs.getString("name_harif"), rs.getTimestamp("time").toLocalDateTime(), rs.getString("awards"), rs.getString("lose_win"), rs.getString("level_harif"));
                historyGames.add(game);
            }
        }
        return historyGames;
    }
}
