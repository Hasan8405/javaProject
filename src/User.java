import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class User {
    public User (String username, String nickname, String email) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
    }
    public String username = "";
    public String password = "";
    public String nickname = "";

    public void setCoin(double coin) {
        this.coin = coin;
    }

    public double getCoin() {
        return coin;
    }

    public String email = "";
    public String[] securityQuestion = new String[3];
    public ArrayList<SpecialCard> specialCardsPlayer = new ArrayList<>();
    public ArrayList<Card> CardsPlayer = new ArrayList<>();
    public static ArrayList<HistoryGame> HistoryGame = new ArrayList<>();
    public int level = 30;

    public ArrayList<HistoryGame> getHistoryGame() {
        return HistoryGame;
    }

    public int HP = 100;
    public int XP = 0;
    private int XPlevelup=10;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXPlevelup(int XPlevelup) {
        this.XPlevelup = XPlevelup;
    }

    public int getXPlevelup() {
        return XPlevelup;
    }

    public double coin = 1000;

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

    private String Charecter;
    public int getLevel() {
        return level;
    }

    public String getNickname() {
        return nickname;
    }
}
