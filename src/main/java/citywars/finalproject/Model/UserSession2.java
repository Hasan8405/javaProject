package citywars.finalproject.Model;

import citywars.finalproject.service.DatabaseManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UserSession2 {
    private static UserSession2 instance;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private ArrayList<Card> CardPlayer2 = new ArrayList<>();
    private ArrayList<SpecialCard>specialCardsPlayer2=new ArrayList<>();

    private String character="";
    private int Hp=100;
    private int level = 30;//به دیتابیس اضافه شود
    private int XP = 0;
    private int XPlevelup=10;
    private double coin = 1000;

    public void setXPlevelup(int XPlevelup) {
        this.XPlevelup = XPlevelup;
    }

    public void setCoin(double coin) {
        this.coin = coin;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCoin() {
        return coin;
    }

    public int getXPlevelup() {
        return XPlevelup;
    }

    public int getXP() {
        return XP;
    }

    public int getLevel() {
        return level;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public int getHp() {
        return Hp;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    // دیگر متغیرها
    private DatabaseManager databaseManager;

    private UserSession2() {
        this.databaseManager = new DatabaseManager();
    }
    public static UserSession2 getInstance() {
        if (instance == null) {
            instance = new UserSession2();
        }
        return instance;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setUsername_updateDB(String username) {
        String currentUsername = this.username;
        this.username = username;
        // Update in the database
        databaseManager.updateUserField(currentUsername, "username" , username);
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPassword_updateDB(String password) {
        this.password = password;
        // Update in the database
        databaseManager.updateUserField(username, "password" , password);
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setNickname_updateDB(String nickname) {
        this.nickname = nickname;
        // Update in the database
        databaseManager.updateUserField(username, "nickname" , nickname);
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEmail_updateDB(String email) {
        this.email = email;
        // Update in the database
        databaseManager.updateUserField(username, "email" , email);
    }
    public void logout() {
        this.username = null;
        this.password = null;
        this.nickname = null;
        this.email = null;
    }

    public ArrayList<SpecialCard> getSpecialCardsPlayer2() {
        return specialCardsPlayer2;
    }

    public void fillCard() {
        ArrayList<String>Namecard=new ArrayList<>();
        for (int i = 0; i < Card.cards.size(); i++) {
            Namecard.add(Card.cards.get(i).getName());
        }
        for (int i = 0; i < SpecialCard.specialCards.size(); i++) {
            Namecard.add(SpecialCard.specialCards.get(i).getNameCard());
        }
        Set<String> selectedItems = new HashSet<>();
        Random random = new Random();
        while (selectedItems.size() < 20) {
            int randomIndex = random.nextInt(Namecard.size());
            selectedItems.add(Namecard.get(randomIndex));
        }
        for (String item : selectedItems) {
            if (Card.CheckName(item)) {
                Card rand=Card.returnCardbyName(item);
                Card card = new Card(rand.getName(), rand.getCardAttack(), rand.getDuration(), rand.getPlayerDamage()
                        , rand.getUpgradeLevel(), rand.getUpgradeCost(), rand.getPrice(), rand.getCharec());
                CardPlayer2.add(card);
            }
            if (SpecialCard.Checkname(item)) {
                SpecialCard rand=SpecialCard.returnSpecialbyName(item);
                SpecialCard scard =new SpecialCard(rand.getNameCard(),rand.getPrice());
                specialCardsPlayer2.add(scard);
            }
        }








        /////////////////////////

    }


    public ArrayList<Card> getCardPlayer2() {
        return CardPlayer2;
    }
}
