import java.security.interfaces.DSAKey;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.*;
public class Main {
    private static User loginedUser;
    private static User loginedUser1;
    public static boolean add = true;
    public static int tedadcard = 1;
    public static int tedadSpecialCard = 1;
    public static boolean edit = true;
    public static boolean delete = true;
    public static boolean buy = true;
    public static boolean NumberEntered ;
    public static boolean editfield = true;
   public static ArrayList<SpecialCard>specialCards=new ArrayList<>();
   public static ArrayList<Card>cards=new ArrayList<>();
    public static ArrayList<Char>carecter=new ArrayList<>();

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
/////////////////////////////////////////Cards\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
       createSpell();
       createCharecter();
////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        String PassWordAdmin = "Admin";
        menu[] currentMenu = {menu.Start_Menu};
        menu[] currentMenu1 = {menu.Start_Menu};
        int failCount = 0;
        long banStartTime = 0;
        long banDuration = 0;
            String createUser = "^\\s*user\\s+create\\s+-u\\s+(.*?)\\s+-p\\s+(.*?)\\s+(.*?)?\\s*-email\\s+(.*?)\\s+-n\\s+(.*?)\\s*$";
            String loginRegex = "^\\s*user\\s+login\\s+-u\\s+(.*)\\s+-p\\s+(.*)\\s*$";
            String forgotPassRegex = "^\\s*Forgot\\s+my\\s+password\\s+-u\\s+(.*)\\s*$";
            String logoutRegex = "^\\s*log\\s+out\\s*$";
            String ShowInfoRegex = "^\\s*Show\\s+information\\s*$";
            String ChangeUsernameRegex = "^\\s*Profile\\s+change\\s+-u\\s+(.*)\\s*$";
            String ChangeNicknameRegex = "^\\s*Profile\\s+change\\s+-n\\s+(.*)\\s*$";
            String ChangePassRegex = "^\\s*profile\\s+change\\s+password\\s+-o\\s+(.*)\\s+-n\\s+(.*)\\s*$";
            String ChangeEmailRegex = "^\\s*profile\\s+change\\s+-e\\s+(.*)\\s*$";
            String MainMenu = "^Enter the Main Menu$";
            String GameModeregex = "^Enter to start game$";
            String TwoPlayerregex = "^Enter to the TwoPlayer Game Mode$";
            String BettingMode = "^Enter to the Betting Game Mode$";
            String SingleMode = "^Enter to the Single Game Mode$";
            String ClanMode = "^Enter to the Clan Game Mode$";
            String ViewCards = "^Enter to the ViewCards$";
            String HistoryGame = "^Enter to the History of Games$";
            String StoreMenu = "^Enter to the Store$";
            String LoginAdmin = "^-login admin (?<AdminPass>.+)$";
            String AddCard = "Add Card";
            String EditingCard = "Editing Card";
            String DeleteCard = "Delete Card";
            String ViewPlayer = "View Player";
            String logoutadmin = "log out Admin";
            String BackMenuMain = "Back the Menu Main";
            boolean run = true;
            boolean addcard = true;
        while (run) {
            String entry = input.nextLine();
            Matcher createUserMatcher = setMatcher(entry, createUser);
            Matcher loginMatcher = setMatcher(entry, loginRegex);
            Matcher logoutMatcher = setMatcher(entry, logoutRegex);
            Matcher forgotMatcher = setMatcher(entry, forgotPassRegex);
            Matcher ShowInfoMatcher = setMatcher(entry, ShowInfoRegex);
            Matcher ChangeUsernameMatcher = setMatcher(entry, ChangeUsernameRegex);
            Matcher ChangeNicknameMatcher = setMatcher(entry, ChangeNicknameRegex);
            Matcher ChangePasswordMatcher = setMatcher(entry, ChangePassRegex);
            Matcher ChangeEmailMatcher = setMatcher(entry, ChangeEmailRegex);
            Matcher MainMenuMatcher = setMatcher(entry, MainMenu);
            Matcher GameModeMatcher = setMatcher(entry, GameModeregex);
            Matcher TwoPlayerMatcher = setMatcher(entry, TwoPlayerregex);
            Matcher BettingMatcher = setMatcher(entry, BettingMode);
            Matcher SingleMatcher = setMatcher(entry, SingleMode);
            Matcher ClanMatcher = setMatcher(entry, ClanMode);
            Matcher ViewCardMatcher = setMatcher(entry, ViewCards);
            Matcher HistoryGamesMatcher = setMatcher(entry, HistoryGame);
            Matcher StoreMatcher = setMatcher(entry, StoreMenu);
            Matcher LoginAdminMatcher = setMatcher(entry, LoginAdmin);
            Matcher AddCard1 = setMatcher(entry, AddCard);
            Matcher EditingCardMatcher = setMatcher(entry, EditingCard);
            Matcher DeleteCardMatcher=setMatcher(entry,DeleteCard);
            Matcher ViewPlayerMatcher=setMatcher(entry,ViewPlayer);
            Matcher logoutadminMatcher=setMatcher(entry,logoutadmin);
            Matcher BackMenuMainMatcher=setMatcher(entry,BackMenuMain);
            if (System.currentTimeMillis() < banStartTime + banDuration) {
                long elapsed = System.currentTimeMillis() - banStartTime;
                long remaining = banDuration - elapsed;
                System.out.println("Try again in " + remaining / 1000 + " seconds");
                continue;
            }
            if (currentMenu[0] == menu.Start_Menu) {
                if (createUserMatcher.matches()) SignupUser(createUserMatcher, input, users, currentMenu);
                if (loginMatcher.matches()) {
                    String username = loginMatcher.group(1);
                    String password = loginMatcher.group(2);
                    if (!exist(users, a -> a.username.equals(username))) System.out.println("Username doesn’t exist!");
                    else {
                        loginedUser = find(users, a -> a.username.equals(username));
                        if (!loginedUser.password.equals(password)) {
                            System.out.println("Password and Username don't match!");
                            failCount++;
                            banDuration = 5000L * failCount;
                            banStartTime = System.currentTimeMillis();

                            System.out.format("Try again in %d seconds\n", banDuration / 1000);
                        } else {
                            failCount = 0;
                            System.out.println("user logged in successfully!");
                            currentMenu[0] = menu.Login_Menu;
                            // دسترسی کامل به thisUser
                            // ادامه برنامه ...
                        }
                    }

                }
                if (forgotMatcher.matches()) {
                    String user = forgotMatcher.group(1);
                    if (!exist(users, a -> a.username.equals(user))) System.out.println("The user not found.");
                    else {
                        User thisUser = find(users, a -> a.username.equals(user));
                        System.out.print("Please answer all of the security questions : \n" +
                                "• 1-What is your father’s name ?\n" +
                                "• 2-What is your favourite color ?\n" +
                                "• 3-What was the name of your first pet?\n");
                        String[] answers = {"", "", ""};

                        while (answers[0].isEmpty() || answers[1].isEmpty() || answers[2].isEmpty()) {
                            String answer = input.nextLine();
                            String answerRegex = "^\\s*question\\s+pick\\s+-q\\s+(.*)\\s+-a\\s+(.*)\\s+-c\\s+(.*)\\s*$";
                            Pattern answerPattern = Pattern.compile(answerRegex);
                            Matcher answerMatcher = answerPattern.matcher(answer);

                            if (answerMatcher.matches()) {
                                int questionNum = Integer.parseInt(answerMatcher.group(1));
                                String Answer = answerMatcher.group(2);
                                String confirmAnswer = answerMatcher.group(3);
                                if (questionNum > 3 || questionNum < 1) System.out.println("Invalid question number");
                                else if (!Answer.equals(confirmAnswer))
                                    System.out.println("Please check your answer again!");
                                else {
                                    System.out.format("Question %d answered!\n", questionNum);

                                    answers[questionNum - 1] = Answer;
                                }
                            }
                        }
                        if (answers[0].equals(thisUser.securityQuestion[0]) && answers[1].equals(thisUser.securityQuestion[1]) && answers[2].equals(thisUser.securityQuestion[2])) {
                            boolean getPass = true;
                            while (getPass) {
                                System.out.println("Enter your new password: ");
                                String newPass = input.nextLine();
                                String checkPass1 = "^.{8,}$";
                                String checkPass2 = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d\\s])[^\\s]*$";
                                Matcher passMatcher = setMatcher(newPass, checkPass1);
                                Matcher passMatcher2 = setMatcher(newPass, checkPass2);
                                if (!passMatcher.matches())
                                    System.out.println("The password must have at least 8 characters");
                                else if (!passMatcher2.matches())
                                    System.out.print("The password must have at least:\n" +
                                            "- A small letter\n" +
                                            "- A capital letter\n" +
                                            "- A number\n" +
                                            "- One character except numbers and letters\n");
                                else {
                                    getPass = false;
                                    thisUser.password = newPass;
                                    System.out.println("Your password changed successfully!");
                                }
                            }
                        } else System.out.println("Wrong Answers!");
                    }


                }
            }
            if (currentMenu[0] == menu.Login_Menu) {
                if (logoutMatcher.matches()) {
                    currentMenu[0] = menu.Start_Menu;
                    System.out.println("Loged out successfully!");
                }
                if (ShowInfoMatcher.matches()) ShowUserInfo(loginedUser);
                if (ChangeUsernameMatcher.matches()) ChangeUsername(loginedUser, users, ChangeUsernameMatcher.group(1));
                if (ChangeNicknameMatcher.matches()) ChangeNickname(loginedUser, ChangeNicknameMatcher.group(1));
                if (ChangePasswordMatcher.matches())
                    ChangePass(loginedUser, ChangePasswordMatcher.group(1), ChangePasswordMatcher.group(2), input);
                if (ChangeEmailMatcher.matches()) ChangeEmail(loginedUser, ChangeEmailMatcher.group(1));
                if (MainMenuMatcher.matches()) {
                    currentMenu[0] = menu.Main_Menu;
                    System.out.println("you have entered the main menu");
                }
            }
            if (currentMenu[0] == menu.Main_Menu) {
                if (NumberEntered) {
                   starterpack(loginedUser);
                }
                if (GameModeMatcher.matches()) {
                    currentMenu[0] = menu.Mode_Menu;
                    System.out.println("You have started the game!");
                    System.out.println("you have entered the Menu Modes....");
                }
                if (ViewCardMatcher.matches()) {
                    currentMenu[0] = menu.ViewCards_Menu;
                    System.out.println("you have entered the Menu View Cards");
                }
                if (HistoryGamesMatcher.matches()) {
                    currentMenu[0] = menu.HistoryGames_Menu;
                    System.out.println("you have entered the Menu History of Games");
                }
                if (StoreMatcher.matches()) {
                    currentMenu[0] = menu.Stor_Menu;
                    System.out.println("you have entered the Menu Store");
                }
            }
            if (BackMenuMainMatcher.matches()) {
                currentMenu[0]=menu.Main_Menu;
                System.out.println("you are enter Main Menu !");
            }
/////////////////////////////////////////////ModeMenu\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
            if (currentMenu[0] == menu.Mode_Menu) {
                if (TwoPlayerMatcher.matches()) {
                    currentMenu[0] = menu.TwoPlayerMode;
                    System.out.println("you have entered the TwoMode!");
                }
                if (BettingMatcher.matches()) {
                    currentMenu[0] = menu.BettingMode;
                    System.out.println("you have entered the BettingMode!");
                }
            }
            //////////////////////////////////////////////////////////////////////
            if (currentMenu[0] == menu.TwoPlayerMode) {
                currentMenu[0]=menu.LoginforGame_Menu;
                System.out.println("please login the second Player !");
            }
            if (currentMenu[0]==menu.LoginforGame_Menu) {
                if (loginMatcher.matches()) {
                    String username = loginMatcher.group(1);
                    String password = loginMatcher.group(2);
                    if (!exist(users, a -> a.username.equals(username))) System.out.println("Username doesn’t exist!");
                    else {
                        loginedUser1 = find(users, a -> a.username.equals(username));
                        if (!loginedUser1.password.equals(password)) {
                            System.out.println("Password and Username don't match!");
                            failCount++;
                            banDuration = 5000L * failCount;
                            banStartTime = System.currentTimeMillis();

                            System.out.format("Try again in %d seconds\n", banDuration / 1000);
                        } else {
                            failCount = 0;
                            System.out.println("user logged in successfully for game!");
                            currentMenu[0] = menu.GameTowPlayetMode_Menu;
                            if (loginedUser1.CardsPlayer.size()==0&&loginedUser1.specialCardsPlayer.size()==0) {
                                starterpack(loginedUser1);
                                System.out.println();
                            }
                            System.out.println("you are start game");
                            // دسترسی کامل به thisUser
                            // ادامه برنامه ...
                        }
                    }
                }
                if (forgotMatcher.matches()) {
                    String user = forgotMatcher.group(1);
                    if (!exist(users, a -> a.username.equals(user))) System.out.println("The user not found.");
                    else {
                        User thisUser = find(users, a -> a.username.equals(user));
                        System.out.print("Please answer all of the security questions : \n" +
                                "• 1-What is your father’s name ?\n" +
                                "• 2-What is your favourite color ?\n" +
                                "• 3-What was the name of your first pet?\n");
                        String[] answers = {"", "", ""};

                        while (answers[0].isEmpty() || answers[1].isEmpty() || answers[2].isEmpty()) {
                            String answer = input.nextLine();
                            String answerRegex = "^\\s*question\\s+pick\\s+-q\\s+(.*)\\s+-a\\s+(.*)\\s+-c\\s+(.*)\\s*$";
                            Pattern answerPattern = Pattern.compile(answerRegex);
                            Matcher answerMatcher = answerPattern.matcher(answer);

                            if (answerMatcher.matches()) {
                                int questionNum = Integer.parseInt(answerMatcher.group(1));
                                String Answer = answerMatcher.group(2);
                                String confirmAnswer = answerMatcher.group(3);
                                if (questionNum > 3 || questionNum < 1) System.out.println("Invalid question number");
                                else if (!Answer.equals(confirmAnswer))
                                    System.out.println("Please check your answer again!");
                                else {
                                    System.out.format("Question %d answered!\n", questionNum);

                                    answers[questionNum - 1] = Answer;
                                }
                            }
                        }
                        if (answers[0].equals(thisUser.securityQuestion[0]) && answers[1].equals(thisUser.securityQuestion[1]) && answers[2].equals(thisUser.securityQuestion[2])) {
                            boolean getPass = true;
                            while (getPass) {
                                System.out.println("Enter your new password: ");
                                String newPass = input.nextLine();
                                String checkPass1 = "^.{8,}$";
                                String checkPass2 = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d\\s])[^\\s]*$";
                                Matcher passMatcher = setMatcher(newPass, checkPass1);
                                Matcher passMatcher2 = setMatcher(newPass, checkPass2);
                                if (!passMatcher.matches())
                                    System.out.println("The password must have at least 8 characters");
                                else if (!passMatcher2.matches())
                                    System.out.print("The password must have at least:\n" +
                                            "- A small letter\n" +
                                            "- A capital letter\n" +
                                            "- A number\n" +
                                            "- One character except numbers and letters\n");
                                else {
                                    getPass = false;
                                    thisUser.password = newPass;
                                    System.out.println("Your password changed successfully!");
                                }
                            }
                        } else System.out.println("Wrong Answers!");
                    }


                }
            }
            if (currentMenu[0]==menu.GameTowPlayetMode_Menu) {
                for (int i = 0; i < carecter.size(); i++) {
                    System.out.println((i+1)+" - "+carecter.get(i).getName());
                }
                GameTowPlayer.SelectCharacter(loginedUser,"first",input);
                GameTowPlayer.SelectCharacter(loginedUser1,"second",input);
                System.out.println("start fight !");
                ///////////////////////////////////again
                ////////////////////////////////////////nobat\\\\\\\\\\\\\\\\\\\\
                boolean play1 = false;
                boolean play2=false;
                int randomStartGame=(int)(Math.random()*3)+1;
                if (randomStartGame==1||randomStartGame==2) {
                   play1=true;
                   play2=false;
                }
                if (randomStartGame==3) {
                    play2=true;
                    play1=false;
                }
                int HpPlayer1=loginedUser.getHP();
                int HpPlayer2=loginedUser1.getHP();
                ////////////////////////////////////////////////Map
                int rund=1;
                //////////////////////////////////////////
                while (true) {
                    System.out.println("Rund : "+rund);
                    ++rund;
                    String [][] MapGame=new String[21][2];
                    int [][] CardLocation=new int[21][2];
                    int CardLoca=0;
                    int[][]Damageplayer=new int[21][2];
                    int[][]attack=new int[21][2];
                    for (int i = 0; i <21 ; i++) {
                        for (int j = 0; j < 2; j++) {
                            MapGame[i][j] = "";
                            Damageplayer[i][j]=0;
                            attack[i][j]=0;
                            CardLocation[i][j]=-1;
                        }
                    }
                    int randomNumplayer1 = (int) (Math.random() * 21) ;
                    int randomNum1player2 = (int) (Math.random() * 21) ;
                    MapGame[randomNumplayer1][0]="#";
                    MapGame[randomNum1player2][1]="#";
                    /////////////////////////////////////////player1
                    ArrayList<String>Namecard=new ArrayList<>();
                    String[]CardsPlayer1=new String[6];
                    int[]CardsAttackPlayer1=new int[6];
                    int[]CardsDamagePlayer1=new int[6];
                    for (int i = 0; i < 6; i++) {
                        CardsPlayer1[i]="";
                    }
                    for (int i = 0; i < loginedUser.CardsPlayer.size(); i++) {
                        Namecard.add(loginedUser.CardsPlayer.get(i).getName());
                    }
                    for (int i = 0; i < loginedUser.specialCardsPlayer.size(); i++) {
                        Namecard.add(loginedUser.specialCardsPlayer.get(i).getNameCard());
                    }
                    Set<String> selectedItems = new HashSet<>();
                    Random random = new Random();
                    while (selectedItems.size() < 5) {
                        int randomIndex = random.nextInt(Namecard.size());
                        selectedItems.add(Namecard.get(randomIndex));
                    }
                    int x=0;
                    for (String item : selectedItems) {
                        CardsPlayer1[x]=item;
                        if (Card.CheckName(item)) {
                            CardsAttackPlayer1[x]=Integer.parseInt(Card.returnCardbyName(item).getCardAttack());
                            CardsDamagePlayer1[x]=Integer.parseInt(Card.returnCardbyName(item).getPlayerDamage());
                        }
                        if (SpecialCard.Checkname(item)) {
                            CardsAttackPlayer1[x]=0;
                            CardsDamagePlayer1[x]=0;
                        }
                        ++x;
                    }
                    /////////////////////////////////////////player2
                    ArrayList<String>Namecard1=new ArrayList<>();
                    String[]CardsPlayer2=new String[6];
                    int[]CardsAttackPlayer2=new int[6];
                    int[]CardsDamagePlayer2=new int[6];
                    for (int i = 0; i < 6; i++) {
                        CardsPlayer2[i]="";
                    }
                    for (int i = 0; i < loginedUser1.CardsPlayer.size(); i++) {
                        Namecard1.add(loginedUser1.CardsPlayer.get(i).getName());
                    }
                    for (int i = 0; i < loginedUser1.specialCardsPlayer.size(); i++) {
                        Namecard1.add(loginedUser1.specialCardsPlayer.get(i).getNameCard());
                    }
                    Set<String> selectedItems1 = new HashSet<>();
                    Random random1 = new Random();
                    while (selectedItems1.size() < 5) {
                        int randomIndex1 = random1.nextInt(Namecard1.size());
                        selectedItems1.add(Namecard1.get(randomIndex1));
                    }
                    int x1=0;
                    for (String item : selectedItems1) {
                        CardsPlayer2[x1]=item;
                        if (Card.CheckName(item)) {
                            CardsAttackPlayer2[x1]=Integer.parseInt(Card.returnCardbyName(item).getCardAttack());
                            CardsDamagePlayer2[x1]=Integer.parseInt(Card.returnCardbyName(item).getPlayerDamage());
                        }
                        if (SpecialCard.Checkname(item)) {
                            CardsAttackPlayer2[x1]=0;
                            CardsDamagePlayer2[x1]=0;
                        }
                        ++x1;
                    }
                    //////////////////////////////////////////again
                    int numRand1=4;
                    int numRand2=4;
                    int CardsCopy6player1=0;
                    int CardsCopy6player2=0;
                    int HiddenCardPlayer2=0;
                    int HiddenCardPlayer1=0;
                    int timeHiddenplayer1=0;
                    int timeHiddenplayer2=0;
/////////////////////////////////////////////////////////////////
                    int Player1Damage=0;
                    int Player2Damage=0;
                    ////////////////////////////////////////////////////////////////////////
                    System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "rand 1", "rand 2");
                    System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", numRand1, numRand2);
                    System.out.println();
                    System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", "1-", "2-");
                    System.out.println();
                    for (int i = 0; i < 21; i++) {
                        String CardPlayer1 = "";
                        String CardPlayer2 = "";
                        String CardFeaturePlayer1 = "";
                        String CardFeaturePlayer2 = "";
                        String tab = "";
                        if (i >= 0 && i <= 8) {
                            tab = "    ";
                        }
                        if (i > 8) {
                            tab = "     ";
                        }
                        String HP1 = "";
                        String HP2 = "";
                        String Nameplayer1 = "";
                        String Nameplayer2 = "";
                        if (i == 8) {
                            CardPlayer1 = "1- " + CardsPlayer1[0];
                            CardPlayer2 = "1- " + CardsPlayer2[0];
                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[0],CardsAttackPlayer1[0],CardsDamagePlayer1[0]);
                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[0],CardsAttackPlayer2[0],CardsDamagePlayer2[0]);
                        }
                        if (i == 9) {
                            CardPlayer1 = "2- " + CardsPlayer1[1];
                            CardPlayer2 = "2- " + CardsPlayer2[1];
                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[1],CardsAttackPlayer1[1],CardsDamagePlayer1[1]);
                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[1],CardsAttackPlayer2[1],CardsDamagePlayer2[1]);
                        }
                        if (i == 10) {
                            CardPlayer1 = "3- " + CardsPlayer1[2];
                            CardPlayer2 = "3- " + CardsPlayer2[2];
                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[2],CardsAttackPlayer1[2],CardsDamagePlayer1[2]);
                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[2],CardsAttackPlayer2[2],CardsDamagePlayer2[2]);
                            Nameplayer1 = "gamer 1 :" + loginedUser.getCharecter();
                            Nameplayer2 = "gamer 2 :" + loginedUser1.getCharecter();
                            HP1 = "Hp player1 :" + HpPlayer1;
                            HP2 = "Hp player2 :" + HpPlayer2;
                        }
                        if (i == 11) {
                            CardPlayer1 = "4- " + CardsPlayer1[3];
                            CardPlayer2 = "4- " + CardsPlayer2[3];
                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[3],CardsAttackPlayer1[3],CardsDamagePlayer1[3]);
                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[3],CardsAttackPlayer2[3],CardsDamagePlayer2[3]);
                        }
                        if (i == 12) {
                            CardPlayer1 = "5- " + CardsPlayer1[4];
                            CardPlayer2 = "5- " + CardsPlayer2[4];
                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[4],CardsAttackPlayer1[4],CardsDamagePlayer1[4]);
                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[4],CardsAttackPlayer2[4],CardsDamagePlayer2[4]);
                        }
                        if (i == 13&&CardsCopy6player1==1) {
                            CardPlayer1 = "6- " + CardsPlayer1[5];
//                            CardPlayer2 = "6- " + CardsPlayer2[4];
                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[5],CardsAttackPlayer1[5],CardsDamagePlayer1[5]);
//                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[4],CardsAttackPlayer2[4],CardsDamagePlayer2[4]);
                        }
                        if (i == 13&&CardsCopy6player2==1) {
                            CardPlayer2 = "6- " + CardsPlayer2[5];
                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[5],CardsAttackPlayer2[5],CardsDamagePlayer2[5]);
                        }
                        if (HiddenCardPlayer1==1) {
                            String[]space=CardPlayer1.split(" ");
                            CardPlayer1=space[0];
                            CardFeaturePlayer1="";
                        }
                        if (HiddenCardPlayer2==1) {
                            String[]space=CardPlayer2.split(" ");
                            CardPlayer2=space[0];
                            CardFeaturePlayer2="";
                        }

                        System.out.printf("%-20s %-25s %-25s %-25s %-30s %-30s%n", Nameplayer1, CardPlayer1, (i + 1) + "-  " + MapGame[i][0], MapGame[i][1], CardPlayer2, Nameplayer2);
                        Nameplayer1 = "";
                        Nameplayer2 = "";
                        CardPlayer1 = "";
                        CardPlayer2 = "";
                        System.out.printf("%-20s %-25s %-25s %-25s %-30s %-30s", HP1, "   " + CardFeaturePlayer1, tab + GameTowPlayer.getCardFeauture1(MapGame[i][0], attack[i][0],Damageplayer[i][0]) ,
                                GameTowPlayer.getCardFeauture1(MapGame[i][1],attack[i][1],Damageplayer[i][1]), "   " + CardFeaturePlayer2, HP2);
                        System.out.println();
                        System.out.println();
                    }
                    System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "player damage 1", "player damage 2");
                    System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", Player1Damage, Player2Damage);
                    System.out.println();
                    /////////////////////////////////
                    ArrayList<Integer>cardShecanPlayer1=new ArrayList<>();
                    ArrayList<Integer>cardShecanPlayer2=new ArrayList<>();
                    while (true) {
                        if (numRand1 == 0 && numRand2 == 0) {
                            break;
                        }
                        if (play1 && !play2) {
                            System.out.println("placing card player 1 or select");
                        }
                        if (!play1 && play2) {
                            System.out.println("placing card player 2 or select");
                        }
                        if (numRand2==timeHiddenplayer2-1) {
                            HiddenCardPlayer2=0;
                        }
                        if (numRand1==timeHiddenplayer1-1) {
                            HiddenCardPlayer1=0;
                        }
                        String vorody = input.nextLine();
                        String regex1 = "-Select card number (?<number>.+) player (?<player>.+)";
                        Matcher regexVorody = setMatcher(vorody, regex1);
                        String regex = "Placing card number (?<num>.+) in block (?<location>.+)";
                        Matcher regexAns = setMatcher(vorody, regex);
                        if (regexVorody.matches()) {
                            String Cardnum = regexVorody.group("number");
                            String gamer = regexVorody.group("player");
                            if (!Cardnum.equals("1") && !Cardnum.equals("2") && !Cardnum.equals("3") && !Cardnum.equals("4") && !Cardnum.equals("5")) {
                                System.out.println("please enter a number between 1 and 5 !");
                            } else if (!gamer.equals("1") && !gamer.equals("2")) {
                                System.out.println("please enter number between 1 and 2 !");
                            } else {
                                if (gamer.equals("1")) {
                                    String Name = CardsPlayer1[Integer.parseInt(Cardnum) - 1];
                                    if (Card.CheckName(CardsPlayer1[Integer.parseInt(Cardnum) - 1])) {
                                        System.out.println("Name Card : " + Name);
                                        System.out.println("Duration Card : " + Card.returnCardbyName(Name).getDuration());
                                        System.out.println("Attack Card : " + Card.returnCardbyName(Name).getCardAttack());
                                        System.out.println("Player Damage Card : " + Card.returnCardbyName(Name).getPlayerDamage());
                                        System.out.println("Character Card : " + Card.returnCardbyName(Name).getCharec());
                                    }
                                    if (SpecialCard.Checkname(CardsPlayer1[Integer.parseInt(Cardnum) - 1])) {
                                        System.out.println("Name Card : " + SpecialCard.returnSpecialbyName(Name).getNameCard());
                                        System.out.println("Description :" + SpecialCard.returnSpecialbyName(Name).getDescription());
                                    }
                                }
                                if (gamer.equals("2")) {
                                    String Name = CardsPlayer2[Integer.parseInt(Cardnum) - 1];
                                    if (Card.CheckName(CardsPlayer2[Integer.parseInt(Cardnum) - 1])) {
                                        System.out.println("Name Card : " + Name);
                                        System.out.println("Duration Card : " + Card.returnCardbyName(Name).getDuration());
                                        System.out.println("Attack Card : " + Card.returnCardbyName(Name).getCardAttack());
                                        System.out.println("Player Damage Card : " + Card.returnCardbyName(Name).getPlayerDamage());
                                        System.out.println("Character Card : " + Card.returnCardbyName(Name).getCharec());
                                    }
                                    if (SpecialCard.Checkname(CardsPlayer2[Integer.parseInt(Cardnum) - 1])) {
                                        System.out.println("Name Card : " + SpecialCard.returnSpecialbyName(Name).getNameCard());
                                        System.out.println("Description :" + SpecialCard.returnSpecialbyName(Name).getDescription());
                                    }
                                }
                            }
                        }
                        if (regexAns.matches()) {
                            String num = regexAns.group("num");
                            if (play1) {
                                String lenght = regexAns.group("location");
                                System.out.println(lenght);
                                if (!num.equals("1") && !num.equals("2") && !num.equals("3") && !num.equals("4") && !num.equals("5") && (!num.equals("6") || CardsCopy6player1 == 0)) {
                                    System.out.println("please enter a number between 1 and 5 !");
                                } else if (!lenght.equals("1") && !lenght.equals("2") && !lenght.equals("3") && !lenght.equals("4") && !lenght.equals("5")&&
                                        !lenght.equals("6") && !lenght.equals("7") && !lenght.equals("8") && !lenght.equals("9") && !lenght.equals("10")&&
                                        !lenght.equals("11") && !lenght.equals("12") && !lenght.equals("13") && !lenght.equals("14") && !lenght.equals("15")&&
                                        !lenght.equals("20") && !lenght.equals("19") && !lenght.equals("18") && !lenght.equals("17") && !lenght.equals("16") && !lenght.equals("21")
                                ) {
                                    System.out.println("please enter a number between 1 and 21");
                                } else {
                                    if (Card.CheckName(CardsPlayer1[Integer.parseInt(num) - 1])) {
                                        if (Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer1).getDuration()) + Integer.parseInt(lenght) > 22) {
                                            System.out.println("you can not place this card in this location1 !");
                                        } else if (GameTowPlayer.CheckTheSelectCardplayer1(num, lenght, CardsPlayer1, MapGame)) {
                                            System.out.println("you can not place this card in this location2 !");
                                        } else {
                                            int x2 = Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer1).getDuration()) + Integer.parseInt(lenght) - 1;
                                            for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
                                                MapGame[i][0] = GameTowPlayer.getCardWithName(num, CardsPlayer1).getName();
                                                attack[i][0] = CardsAttackPlayer1[Integer.parseInt(num) - 1];
                                                CardLocation[i][0] = CardLoca;
                                            }
                                            ++CardLoca;
                                            if (Integer.parseInt(num)!=3&&CardsPlayer1[5].equals("")) {
                                                int q=GameTowPlayer.CharChargetScore(Card.returnCardbyName(CardsPlayer1[Integer.parseInt(num)-1]).getCharec(),Card.returnCardbyName(CardsPlayer1[2]).getCharec(),Integer.parseInt(Card.returnCardbyName(CardsPlayer1[2]).getDuration()));
                                                CardsDamagePlayer1[2]+=q;
                                            }
                                            //////////////////////////////////////
//                                         player damage
                                            for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
                                                if (loginedUser.getCharecter().equals(Card.returnCardbyName(MapGame[i][0]).getCharec())) {
                                                    if (MapGame[i][1] == "" || MapGame[i][1] == "#") {
                                                        MapGame[i][0]=CardsPlayer1[Integer.parseInt(num)-1];
                                                        attack[i][0]=CardsAttackPlayer1[Integer.parseInt(num)-1];
                                                        double e=(CardsDamagePlayer1[Integer.parseInt(num) - 1])/Integer.parseInt(Card.returnCardbyName(CardsPlayer1[Integer.parseInt(num)-1]).getDuration());
                                                        Damageplayer[i][0] = (int)e+1;
                                                        Player1Damage += Damageplayer[i][0];
                                                    } else {
                                                        MapGame[i][0]=CardsPlayer1[Integer.parseInt(num)-1];
                                                        attack[i][0]=CardsAttackPlayer1[Integer.parseInt(num)-1];
                                                        ////////////////Card
                                                        if (Card.CheckName(MapGame[i][1])) {
                                                            if (attack[i][1] > attack[i][0]) {
                                                                attack[i][0] = 0;
                                                            }
                                                           else if (attack[i][1] < attack[i][0]) {
                                                                double e=CardsDamagePlayer1[Integer.parseInt(num) - 1]/Integer.parseInt(Card.returnCardbyName(CardsPlayer1[Integer.parseInt(num)-1]).getDuration());
                                                                Damageplayer[i][0] = (int)e+1;
                                                                Player1Damage += Damageplayer[i][0];
                                                                Player2Damage -= Damageplayer[i][1];
                                                                attack[i][1] = 0;
                                                            }
                                                          else  if (attack[i][1] == attack[i][0]) {
                                                                Player2Damage -= Damageplayer[i][1];
//                                                                Damageplayer[i][1] = 0;
//                                                                Damageplayer[i][0] = 0;
                                                                attack[i][1] = 0;
                                                                attack[i][0] = 0;
                                                            }
                                                            //////////Special Card
                                                            else {
                                                                MapGame[i][0]=CardsPlayer1[Integer.parseInt(num)-1];
                                                                if (MapGame[i][1].equals("shield")) {
//                                                                    Damageplayer[i][0] = 0;
                                                                    attack[i][0]=0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (MapGame[i][1] == "" || MapGame[i][1] == "#") {
                                                        MapGame[i][0]=CardsPlayer1[Integer.parseInt(num)-1];
                                                        attack[i][0]=CardsAttackPlayer1[Integer.parseInt(num)-1];
                                                        double e=CardsDamagePlayer1[Integer.parseInt(num) - 1]/Integer.parseInt(Card.returnCardbyName(CardsPlayer1[Integer.parseInt(num)-1]).getDuration());
                                                        Damageplayer[i][0] = (int)e;
                                                        Player1Damage += Damageplayer[i][0];
                                                    } else {
                                                        //////////////card
                                                        MapGame[i][0]=CardsPlayer1[Integer.parseInt(num)-1];
                                                        attack[i][0]=CardsAttackPlayer1[Integer.parseInt(num)-1];
                                                        if (Card.CheckName(MapGame[i][1])) {
                                                            if (attack[i][1] > attack[i][0]) {
                                                                attack[i][0] = 0;
                                                            }
                                                            else if (attack[i][1] < attack[i][0]) {
                                                                double e=CardsDamagePlayer1[Integer.parseInt(num) - 1]/Integer.parseInt(Card.returnCardbyName(CardsPlayer1[Integer.parseInt(num)-1]).getDuration());
                                                                Damageplayer[i][0] = (int)e;
                                                                Player1Damage += Damageplayer[i][0];
                                                                Player2Damage -= Damageplayer[i][1];
                                                                attack[i][1] = 0;
                                                            }
                                                           else  if (attack[i][1] == attack[i][0]) {
                                                                Player2Damage -= Damageplayer[i][1];
                                                                attack[i][0]=0;
                                                                attack[i][1]=0;
                                                           }
                                                        }
                                                        ///////////////////////special card
                                                        else {
                                                            MapGame[i][0]=CardsPlayer1[Integer.parseInt(num)-1];
                                                            if (MapGame[i][1].equals("shield")) {
                                                                attack[i][0] = 0;
                                                            }
                                                        }

                                                    }

                                                }
                                            }
                                            ///////////////////////////////////////////////////////////
                                            Random random2 = new Random();
                                            String cardRand = "";
                                            int randomIndex3 = random2.nextInt(Namecard.size());
                                            cardRand = Namecard.get(randomIndex3);
                                            CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                            if (Card.CheckName(cardRand)) {
                                                CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                            }
                                            if (SpecialCard.Checkname(cardRand)) {
                                                CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                            }
                                            ////////////////////////////////////////////////
                                            --numRand1;
                                            play1 = false;
                                            play2 = true;
                                        }
                                    }
                                    ///////////////////////////////SpeciaCard
                                    else if (SpecialCard.Checkname(CardsPlayer1[Integer.parseInt(num) - 1])) {
                                        if (GameTowPlayer.CheckTheSelectSpecialCard(lenght, MapGame)) {
                                            System.out.println("you can not place this special card in this location !");
                                        } else {
                                            if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("healing")) {
                                                MapGame[Integer.parseInt(lenght) - 1][0] = "healing";
                                                CardLocation[Integer.parseInt(lenght) - 1][0] = CardLoca;
                                                ++CardLoca;
                                                attack[Integer.parseInt(lenght) - 1][0] = 0;
                                                Damageplayer[Integer.parseInt(lenght) - 1][0] = 0;
                                                Random random5 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random5.nextInt(Namecard.size());
                                                cardRand = Namecard.get(randomIndex3);
                                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                }
                                                ////////////////////////////////////////////////
//                                                /loginedUser.setHP(loginedUser.getHP() + 15);
                                                HpPlayer1+=15;
                                                --numRand1;
                                                play1 = false;
                                                play2 = true;
                                            }
                                            else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("repairman")) {
                                                Random random6 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random6.nextInt(Namecard.size());
                                                cardRand = Namecard.get(randomIndex3);
                                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                }
                                                ////////////////////////////////////////////////
                                                MapGame[randomNumplayer1][0] = "";
                                                --numRand1;
                                                play1 = false;
                                                play2 = true;
                                            }
                                            else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("roundReducer")) {
                                                Random random7 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random7.nextInt(Namecard.size());
                                                cardRand = Namecard.get(randomIndex3);
                                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                }
                                                /////////////////////////////////////////////////
                                                --numRand1;
                                                --numRand1;
                                                --numRand2;
                                                play1 = false;
                                                play2 = true;
                                            }
                                            else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("shield")) {
                                                MapGame[Integer.parseInt(lenght) - 1][0] = "shield";
                                                attack[Integer.parseInt(lenght) - 1][0] = 0;
                                                Damageplayer[Integer.parseInt(lenght) - 1][0] = 0;
                                                CardLocation[Integer.parseInt(lenght) - 1][0] = CardLoca;
                                                ++CardLoca;
                                                Random random9 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random9.nextInt(Namecard.size());
                                                cardRand = Namecard.get(randomIndex3);
                                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand1;
                                                play1 = false;
                                                play2 = true;
                                                ////////////////////////////////////////////////
                                                if (MapGame[Integer.parseInt(lenght) - 1][1] == "" || MapGame[Integer.parseInt(lenght) - 1][1] == "#") {
                                                } else if (MapGame[Integer.parseInt(lenght) - 1][1] != "") {
                                                    if (SpecialCard.Checkname(MapGame[Integer.parseInt(lenght) - 1][1])) {
                                                    } else if (Card.CheckName(MapGame[Integer.parseInt(lenght) - 1][1])) {
                                                        Player2Damage -= Damageplayer[Integer.parseInt(lenght) - 1][1];
//                                                        Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
                                                        attack[Integer.parseInt(lenght) - 1][1] = 0;
                                                    }
                                                }

                                            }
                                            else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("HoleLocationModifier")) {
                                                MapGame[Integer.parseInt(lenght) - 1][0] = "HoleLocationModifier";
                                                attack[Integer.parseInt(lenght) - 1][0] = 0;
                                                Damageplayer[Integer.parseInt(lenght) - 1][0] = 0;
                                                CardLocation[Integer.parseInt(lenght) - 1][0] = CardLoca;
                                                ++CardLoca;
                                                MapGame[randomNumplayer1][0] = "";
                                                MapGame[randomNum1player2][1] = "";
                                                while (true) {
                                                    int randomplayer1 = (int) (Math.random() * 21);
                                                    if (MapGame[randomplayer1][0] == "") {
                                                        MapGame[randomplayer1][0] = "#";
                                                        randomNumplayer1 = randomplayer1;
                                                        break;
                                                    }
                                                }
                                                while (true) {
                                                    int randomplayer2 = (int) (Math.random() * 21);
                                                    if (MapGame[randomplayer2][0] == "") {
                                                        MapGame[randomplayer2][0] = "#";
                                                        randomNum1player2 = randomplayer2;
                                                        break;
                                                    }
                                                }
                                                Random random0 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random0.nextInt(Namecard.size());
                                                cardRand = Namecard.get(randomIndex3);
                                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand1;
                                                play1 = false;
                                                play2 = true;
                                            }
                                            else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("CardWeakner")) {
                                                ArrayList<Integer> rend = new ArrayList<>();
                                                ArrayList<Integer> Weakner = new ArrayList<>();
                                                for (int i = 0; i < 5; i++) {
                                                    if (Card.CheckName(CardsPlayer2[i])) {
                                                        Weakner.add(i);
                                                    }
                                                }
                                                if (Weakner.size() > 1) {
                                                    Random random21 = new Random();
                                                    while (rend.size() < 2) {
                                                        int randomIndex = random21.nextInt(Weakner.size());
                                                        rend.add(Weakner.get(randomIndex));
                                                    }
                                                    CardsAttackPlayer2[rend.get(0)] -= 3;
                                                    CardsDamagePlayer2[rend.get(1)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer2[rend.get(1)]).getDuration());
                                                }
                                                if (Weakner.size() == 1) {
                                                    Random random31 = new Random();
                                                    int randomIndex = random31.nextInt(2);
                                                    if (randomIndex == 0) {
                                                        CardsAttackPlayer2[Weakner.get(0)] -= 3;
                                                    }
                                                    if (randomIndex == 1) {
                                                        CardsDamagePlayer2[Weakner.get(0)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer2[rend.get(1)]).getDuration());
                                                    }
                                                }
                                                if (Weakner.size() == 0) {
                                                }
                                                Random random03 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random03.nextInt(Namecard.size());
                                                cardRand = Namecard.get(randomIndex3);
                                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand1;
                                                play1 = false;
                                                play2 = true;
                                            }
                                            else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("PowerBosster")) {
                                                Random random03 = new Random();
                                                int randomIndex3 = random03.nextInt(CardLoca);

                                                for (int i = 0; i < 21; i++) {
                                                    if (CardLocation[i][0] == randomIndex3) {
                                                        Damageplayer[i][0] += 3;
                                                        Player1Damage += 3;
                                                    }
                                                }
                                                Random random04 = new Random();
                                                String cardRand = "";
                                                int randomIndex4 = random04.nextInt(Namecard.size());
                                                cardRand = Namecard.get(randomIndex4);
                                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand1;
                                                play1 = false;
                                                play2 = true;
                                            }
                                            else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("Copycard")) {
                                                String copy = "";
                                                while (true) {
                                                    System.out.println("please enter the desired Card number for the copy !");
                                                    String NUM = input.nextLine();
                                                    if (!NUM.equals("1") && !NUM.equals("2") && !NUM.equals("3") && !NUM.equals("4") && !NUM.equals("5")) {
                                                        System.out.println("please enter a number between 1 and 5 !");
                                                    } else {
                                                        copy = NUM;
                                                        break;
                                                    }
                                                }
                                                CardsPlayer1[5] = CardsPlayer1[Integer.parseInt(copy) - 1];
                                                CardsAttackPlayer1[5] = CardsAttackPlayer1[Integer.parseInt(copy) - 1];
                                                CardsDamagePlayer1[5] = CardsDamagePlayer1[Integer.parseInt(copy) - 1];
                                                CardsCopy6player1 = 1;

                                                Random random04 = new Random();
                                                String cardRand = "";
                                                int randomIndex4 = random04.nextInt(Namecard.size());
                                                cardRand = Namecard.get(randomIndex4);
                                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand1;
                                                play1 = false;
                                                play2 = true;
                                            }
                                            else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("RemoveCard")) {
                                                if (CardsCopy6player1 == 1) {
                                                    System.out.println("you can not use this Card");
                                                    continue;
                                                } else {
                                                    Random random2 = new Random();
                                                    int cin = random2.nextInt(5);
                                                    CardsPlayer1[5] = CardsPlayer2[cin];
                                                    CardsAttackPlayer1[5] = CardsAttackPlayer2[cin];
                                                    CardsDamagePlayer1[5] = CardsDamagePlayer2[cin];
                                                    CardsCopy6player1 = 1;
                                                    CardsPlayer2[cin] = "";
                                                    CardsAttackPlayer2[cin] = 0;
                                                    CardsDamagePlayer2[cin] = 0;
                                                }
                                                /////////////////////////
                                                Random random05 = new Random();
                                                String cardRand = "";
                                                int randomIndex4 = random05.nextInt(Namecard.size());
                                                cardRand = Namecard.get(randomIndex4);
                                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand1;
                                                play1 = false;
                                                play2 = true;
                                            }
                                            else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("HiddenCard")) {
                                                HiddenCardPlayer2 = 1;
                                                String a = CardsPlayer2[0];
                                                String b = CardsPlayer2[1];
                                                String c = CardsPlayer2[2];
                                                String d = CardsPlayer2[3];
                                                String e = CardsPlayer2[4];
                                                CardsPlayer2[0] = d;
                                                CardsPlayer2[1] = c;
                                                CardsPlayer2[2] = b;
                                                CardsPlayer2[3] = e;
                                                CardsPlayer2[4] = a;
                                                timeHiddenplayer2 = numRand2;
                                                Random random05 = new Random();
                                                String cardRand = "";
                                                int randomIndex4 = random05.nextInt(Namecard.size());
                                                cardRand = Namecard.get(randomIndex4);
                                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand1;
                                                play1 = false;
                                                play2 = true;
                                            }
                                        }
                                    }
                                }
                            }
                           else if (play2) {
//                                    System.out.println("please select player 2 desired card and specify its location !");
//                                    String num = regexAns.group("num");
                                String lenght = regexAns.group("location");
                                if (!num.equals("1") && !num.equals("2") && !num.equals("3") && !num.equals("4") && !num.equals("5") && (!num.equals("6") || CardsCopy6player2 == 0)) {
                                    System.out.println("please enter a number between 1 and 5 !");
                                } else if (!lenght.equals("1") && !lenght.equals("2") && !lenght.equals("3") && !lenght.equals("4") && !lenght.equals("5")&&
                                        !lenght.equals("6") && !lenght.equals("7") && !lenght.equals("8") && !lenght.equals("9") && !lenght.equals("10")&&
                                        !lenght.equals("11") && !lenght.equals("12") && !lenght.equals("13") && !lenght.equals("14") && !lenght.equals("15")&&
                                        !lenght.equals("20") && !lenght.equals("19") && !lenght.equals("18") && !lenght.equals("17") && !lenght.equals("16") && !lenght.equals("21")
                                ) {
                                    System.out.println("please enter a number between 1 and 21");
                                } else {
                                    if (Card.CheckName(CardsPlayer2[Integer.parseInt(num) - 1])) {
                                        if (Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer2).getDuration()) + Integer.parseInt(lenght) > 22) {
                                            System.out.println("you can not place this card in this location3 !");
                                        } else if (GameTowPlayer.CheckTheSelectCardplayer2(num, lenght, CardsPlayer2, MapGame)) {
                                            System.out.println("you can not place this card in this location4 !");
                                        } else {
                                            int x2 = Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer2).getDuration()) + Integer.parseInt(lenght) - 1;
                                            for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
                                                MapGame[i][1] = GameTowPlayer.getCardWithName(num, CardsPlayer2).getName();
                                                attack[i][1] = CardsAttackPlayer2[Integer.parseInt(num) - 1];
                                                CardLocation[i][1] = CardLoca;
                                            }
                                            ++CardLoca;
                                            if (Integer.parseInt(num)!=3&&CardsPlayer2[5].equals("")) {
                                                int q=GameTowPlayer.CharChargetScore(Card.returnCardbyName(CardsPlayer2[Integer.parseInt(num)-1]).getCharec(),Card.returnCardbyName(CardsPlayer2[2]).getCharec(),Integer.parseInt(Card.returnCardbyName(CardsPlayer2[2]).getDuration()));
                                                CardsDamagePlayer2[2]+=q;
                                            }
                                            //////////////////////////////////////
//                                         player damage
                                            for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
                                                if (loginedUser1.getCharecter().equals(Card.returnCardbyName(MapGame[i][1]).getCharec())) {
                                                    if (MapGame[i][0] == "" || MapGame[i][0] == "#") {
                                                        MapGame[i][1]=CardsPlayer2[Integer.parseInt(num)-1];
                                                        attack[i][1]=CardsAttackPlayer2[Integer.parseInt(num)-1];
                                                        double e=CardsDamagePlayer2[Integer.parseInt(num) - 1]/Integer.parseInt(Card.returnCardbyName(CardsPlayer2[Integer.parseInt(num)-1]).getDuration());
                                                        Damageplayer[i][1] = (int)e+1;
                                                        Player2Damage += Damageplayer[i][1];
                                                    } else {
                                                        MapGame[i][1]=CardsPlayer2[Integer.parseInt(num)-1];
                                                        attack[i][1]=CardsAttackPlayer2[Integer.parseInt(num)-1];
                                                        ////////////////Card
                                                        if (Card.CheckName(MapGame[i][0])) {
                                                            if (attack[i][0] > attack[i][1]) {
                                                                attack[i][1] = 0;
                                                            }
                                                            else if (attack[i][0] < attack[i][1]) {
                                                                double e=CardsDamagePlayer2[Integer.parseInt(num) - 1]/Integer.parseInt(Card.returnCardbyName(CardsPlayer2[Integer.parseInt(num)-1]).getDuration());
                                                                Damageplayer[i][1] = (int)e+1;
                                                                Player2Damage += Damageplayer[i][1];
                                                                Player1Damage -= Damageplayer[i][0];
                                                                attack[i][0] = 0;
                                                            }
                                                            else if (attack[i][1] == attack[i][0]) {
                                                                Player1Damage -= Damageplayer[i][0];
                                                                attack[i][1] = 0;
                                                                attack[i][0] = 0;
                                                            }
                                                            //////////Special Card
                                                            else {
                                                                MapGame[i][1]=CardsPlayer1[Integer.parseInt(num)-1];
                                                                attack[i][1]=CardsAttackPlayer2[Integer.parseInt(num)-1];
                                                                if (MapGame[i][0].equals("shield")) {
                                                                    attack[i][1] = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (MapGame[i][0] == "" || MapGame[i][0] == "#") {
                                                        MapGame[i][1]=CardsPlayer2[Integer.parseInt(num)-1];
                                                        attack[i][1]=CardsAttackPlayer2[Integer.parseInt(num)-1];
                                                        double e=CardsDamagePlayer2[Integer.parseInt(num) - 1]/Integer.parseInt(Card.returnCardbyName(CardsPlayer2[Integer.parseInt(num)-1]).getDuration());
                                                        Damageplayer[i][1] = (int)e;
                                                        Player2Damage += Damageplayer[i][1];
                                                    } else {
                                                        MapGame[i][1]=CardsPlayer2[Integer.parseInt(num)-1];
                                                        attack[i][1]=CardsAttackPlayer2[Integer.parseInt(num)-1];
                                                        //////////////card
                                                        if (Card.CheckName(MapGame[i][0])) {
                                                            if (attack[i][0] > attack[i][1]) {
                                                                attack[i][1] = 0;
                                                            }
                                                           else if (attack[i][0] < attack[i][1]) {
                                                                double e=CardsDamagePlayer2[Integer.parseInt(num) - 1]/Integer.parseInt(Card.returnCardbyName(CardsPlayer2[Integer.parseInt(num)-1]).getDuration());
                                                                Damageplayer[i][1] = (int)e;
                                                                Player2Damage += Damageplayer[i][1];
                                                                Player1Damage -= Damageplayer[i][0];
                                                                attack[i][0] = 0;
                                                            }
                                                            if (attack[i][1] == attack[i][0]) {
                                                                Player1Damage -= Damageplayer[i][0];
                                                                attack[i][1] = 0;
                                                                attack[i][0] = 0;
                                                            }
                                                        }
                                                        ///////////////////////special card
                                                        else {
                                                            MapGame[i][1]=CardsPlayer1[Integer.parseInt(num)-1];
                                                            attack[i][1]=CardsAttackPlayer2[Integer.parseInt(num)-1];
                                                            if (MapGame[i][0].equals("shield")) {
                                                                attack[i][1] = 0;
                                                            }
                                                        }

                                                    }

                                                }
                                            }
                                            ///////////////////////////////////////////////////////////
                                            Random random2 = new Random();
                                            String cardRand = "";
                                            int randomIndex3 = random2.nextInt(Namecard1.size());
                                            cardRand = Namecard1.get(randomIndex3);
                                            CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                            if (Card.CheckName(cardRand)) {
                                                CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                            }
                                            if (SpecialCard.Checkname(cardRand)) {
                                                CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                            }
                                            ////////////////////////////////////////////////
                                            --numRand2;
                                            play2 = false;
                                            play1 = true;
                                        }
                                    }
                                    ///////////////////////////////SpecialCard
                                    else if (SpecialCard.Checkname(CardsPlayer2[Integer.parseInt(num) - 1])) {
                                        if (GameTowPlayer.CheckTheSelectSpecialCard(lenght, MapGame)) {
                                            System.out.println("you can not place this special card in this location !");
                                        } else {
                                            if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("healing")) {
                                                MapGame[Integer.parseInt(lenght) - 1][1] = "healing";
                                                CardLocation[Integer.parseInt(lenght) - 1][1] = CardLoca;
                                                ++CardLoca;
                                                attack[Integer.parseInt(lenght) - 1][1] = 0;
                                                Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
                                                Random random5 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random5.nextInt(Namecard1.size());
                                                cardRand = Namecard1.get(randomIndex3);
                                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                }
                                                ////////////////////////////////////////////////
//                                                loginedUser1.setHP(loginedUser1.getHP() + 15);
                                                HpPlayer2+=15;
                                                --numRand2;
                                                play2 = false;
                                                play1 = true;
                                            }
                                            else if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("repairman")) {
                                                Random random6 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random6.nextInt(Namecard1.size());
                                                cardRand = Namecard1.get(randomIndex3);
                                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                }
                                                ////////////////////////////////////////////////
                                                MapGame[randomNum1player2][1] = "";
                                                --numRand2;
                                                play2 = false;
                                                play1 = true;
                                            }
                                            else  if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("roundReducer")) {
                                                Random random7 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random7.nextInt(Namecard1.size());
                                                cardRand = Namecard1.get(randomIndex3);
                                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                }
                                                /////////////////////////////////////////////////
                                                --numRand2;
                                                --numRand2;
                                                --numRand1;
                                                play2 = false;
                                                play1 = true;
                                            }
                                            else    if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("shield")) {
                                                MapGame[Integer.parseInt(lenght) - 1][1] = "shield";
                                                attack[Integer.parseInt(lenght) - 1][1] = 0;
                                                Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
                                                CardLocation[Integer.parseInt(lenght) - 1][1] = CardLoca;
                                                ++CardLoca;
                                                Random random9 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random9.nextInt(Namecard1.size());
                                                cardRand = Namecard1.get(randomIndex3);
                                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand2;
                                                play2 = false;
                                                play1 = true;
                                                ////////////////////////////////////////////////
                                                if (MapGame[Integer.parseInt(lenght) - 1][0] == "" || MapGame[Integer.parseInt(lenght) - 1][0] == "#") {
                                                } else if (MapGame[Integer.parseInt(lenght) - 1][0] != "") {
                                                    if (SpecialCard.Checkname(MapGame[Integer.parseInt(lenght) - 1][0])) {
                                                    } else if (Card.CheckName(MapGame[Integer.parseInt(lenght) - 1][0])) {
                                                        Player2Damage -= Damageplayer[Integer.parseInt(lenght) - 1][0];
                                                        attack[Integer.parseInt(lenght) - 1][0] = 0;
                                                    }
                                                }

                                            }
                                            else  if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("HoleLocationModifier")) {
                                                MapGame[Integer.parseInt(lenght) - 1][1] = "HoleLocationModifier";
                                                attack[Integer.parseInt(lenght) - 1][1] = 0;
                                                Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
                                                CardLocation[Integer.parseInt(lenght) - 1][1] = CardLoca;
                                                ++CardLoca;
                                                MapGame[randomNumplayer1][0] = "";
                                                MapGame[randomNum1player2][1] = "";
                                                while (true) {
                                                    int randomplayer1 = (int) (Math.random() * 21);
                                                    if (MapGame[randomplayer1][1] == "") {
                                                        MapGame[randomplayer1][1] = "#";
                                                        randomNum1player2 = randomplayer1;
                                                        break;
                                                    }
                                                }
                                                while (true) {
                                                    int randomplayer2 = (int) (Math.random() * 21);
                                                    if (MapGame[randomplayer2][1] == "") {
                                                        MapGame[randomplayer2][1] = "#";
                                                        randomNumplayer1 = randomplayer2;
                                                        break;
                                                    }
                                                }
                                                Random random0 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random0.nextInt(Namecard.size());
                                                cardRand = Namecard1.get(randomIndex3);
                                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand2;
                                                play2 = false;
                                                play1 = true;
                                            }
                                            else   if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("CardWeakner")) {
                                                ArrayList<Integer> rend = new ArrayList<>();
                                                ArrayList<Integer> Weakner = new ArrayList<>();
                                                for (int i = 0; i < 5; i++) {
                                                    if (Card.CheckName(CardsPlayer1[i])) {
                                                        Weakner.add(i);
                                                    }
                                                }
                                                if (Weakner.size() > 1) {
                                                    Random random21 = new Random();
                                                    while (rend.size() < 2) {
                                                        int randomIndex = random21.nextInt(Weakner.size());
                                                        rend.add(Weakner.get(randomIndex));
                                                    }
                                                    CardsAttackPlayer1[rend.get(0)] -= 3;
                                                    CardsDamagePlayer1[rend.get(1)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer1[rend.get(1)]).getDuration());
                                                }
                                                if (Weakner.size() == 1) {
                                                    Random random31 = new Random();
                                                    int randomIndex = random31.nextInt(2);
                                                    if (randomIndex == 0) {
                                                        CardsAttackPlayer1[Weakner.get(0)] -= 3;
                                                    }
                                                    if (randomIndex == 1) {
                                                        CardsDamagePlayer1[Weakner.get(0)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer1[rend.get(1)]).getDuration());
                                                    }
                                                }
                                                if (Weakner.size() == 0) {
                                                }
                                                Random random03 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random03.nextInt(Namecard1.size());
                                                cardRand = Namecard1.get(randomIndex3);
                                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand2;
                                                play2 = false;
                                                play1 = true;
                                            }
                                            else   if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("PowerBosster")) {
                                                Random random03 = new Random();
                                                int randomIndex3 = random03.nextInt(CardLoca);

                                                for (int i = 0; i < 21; i++) {
                                                    if (CardLocation[i][0] == randomIndex3) {
                                                        Damageplayer[i][0] += 3;
                                                        Player2Damage += 3;
                                                    }
                                                }
                                                Random random04 = new Random();
                                                String cardRand = "";
                                                int randomIndex4 = random04.nextInt(Namecard1.size());
                                                cardRand = Namecard1.get(randomIndex4);
                                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand2;
                                                play2 = false;
                                                play1 = true;
                                            }
                                            else   if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("Copycard")) {
                                                String copy = "";
                                                while (true) {
                                                    System.out.println("please enter the desired Card number for the copy !");
                                                    String NUM = input.nextLine();
                                                    if (!NUM.equals("1") && !NUM.equals("2") && !NUM.equals("3") && !NUM.equals("4") && !NUM.equals("5")) {
                                                        System.out.println("please enter a number between 1 and 5 !");
                                                    } else {
                                                        copy = NUM;
                                                        break;
                                                    }
                                                }
                                                CardsPlayer2[5] = CardsPlayer2[Integer.parseInt(copy) - 1];
                                                CardsAttackPlayer2[5] = CardsAttackPlayer2[Integer.parseInt(copy) - 1];
                                                CardsDamagePlayer2[5] = CardsDamagePlayer2[Integer.parseInt(copy) - 1];
                                                CardsCopy6player2 = 1;

                                                Random random04 = new Random();
                                                String cardRand = "";
                                                int randomIndex4 = random04.nextInt(Namecard1.size());
                                                cardRand = Namecard1.get(randomIndex4);
                                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand2;
                                                play2 = false;
                                                play1 = true;
                                            }
                                            else  if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("RemoveCard")) {
                                                if (CardsCopy6player2 == 1) {
                                                    System.out.println("you can not use this Card");
                                                    continue;
                                                } else {
                                                    Random random2 = new Random();
                                                    int cin = random2.nextInt(5);
                                                    CardsPlayer2[5] = CardsPlayer1[cin];
                                                    CardsAttackPlayer2[5] = CardsAttackPlayer1[cin];
                                                    CardsDamagePlayer2[5] = CardsDamagePlayer1[cin];
                                                    CardsCopy6player2 = 1;
                                                    CardsPlayer1[cin] = "";
                                                    CardsAttackPlayer1[cin] = 0;
                                                    CardsDamagePlayer1[cin] = 0;
                                                }
                                                /////////////////////////
                                                Random random05 = new Random();
                                                String cardRand = "";
                                                int randomIndex4 = random05.nextInt(Namecard1.size());
                                                cardRand = Namecard1.get(randomIndex4);
                                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand2;
                                                play2 = false;
                                                play1 = true;
                                            }
                                            else  if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("HiddenCard")) {
                                                HiddenCardPlayer1 = 1;
                                                String a = CardsPlayer1[0];
                                                String b = CardsPlayer1[1];
                                                String c = CardsPlayer1[2];
                                                String d = CardsPlayer1[3];
                                                String e = CardsPlayer1[4];
                                                CardsPlayer1[0] = d;
                                                CardsPlayer1[1] = c;
                                                CardsPlayer1[2] = b;
                                                CardsPlayer1[3] = e;
                                                CardsPlayer1[4] = a;
                                                timeHiddenplayer1 = numRand1;
                                                Random random05 = new Random();
                                                String cardRand = "";
                                                int randomIndex4 = random05.nextInt(Namecard1.size());
                                                cardRand = Namecard1.get(randomIndex4);
                                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                }
                                                --numRand2;
                                                play2 = false;
                                                play1 = true;
                                            }
                                        }
                                    }
                                }

                            }
                            for (int i = 0; i <=CardLoca; i++) {
                                int w=0;
                                int z=0;
                                for (int j = 0; j < 21; j++) {
                                    if (attack[j][0]==0&&Damageplayer[j][0]!=0&&CardLocation[j][0]==i&&!cardShecanPlayer1.contains(i)) {
                                        ++w;
                                    }
                                    if (CardLocation[j][0]==i) {
                                        ++z;
                                    }
                                }
                                if (w==z) {
                                    Random random2=new Random();
                                    int r=random2.nextInt(4);
                                    if (r !=3) {
                                        System.out.println(" player2 :you won 5 coins for defeating your opponent's Card");
                                        loginedUser1.setCoin(loginedUser1.getCoin()+5);
                                        cardShecanPlayer1.add(i);
                                    }
                                    if (r == 3) {
                                        System.out.println("player 2 :you won 3 XP for defeating your opponent's Card");
                                        loginedUser1.setXP(loginedUser1.getXP()+3);
                                        cardShecanPlayer1.add(i);
                                    }
                                }
                            }
                            for (int i = 0; i <=CardLoca; i++) {
                                int w=0;
                                int z=0;
                                for (int j = 0; j < 21; j++) {
                                    if (attack[j][1]==0&&Damageplayer[j][1]!=0&&CardLocation[j][1]==i&&!cardShecanPlayer2.contains(i)) {
                                        ++w;
                                    }
                                    if (CardLocation[j][1]==i) {
                                        ++z;
                                    }
                                }
                                if (w==z) {
                                    Random random2=new Random();
                                    int r=random2.nextInt(4);
                                    if (r !=3) {
                                        System.out.println("player 1 : you won 5 coins for defeating your opponent's Card");
                                        loginedUser.setCoin(loginedUser.getCoin()+5);
                                        cardShecanPlayer2.add(i);
                                    }
                                    if (r == 3) {
                                        System.out.println("player 1 : you won 3 XP for defeating your opponent's Card");
                                        loginedUser.setXP(loginedUser.getXP()+3);
                                        cardShecanPlayer2.add(i);
                                    }
                                }
                            }
                            System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "rand 1", "rand 2");
                            System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", numRand1, numRand2);
                            System.out.println();
                            System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", "1-", "2-");
                            System.out.println();
                            for (int i = 0; i < 21; i++) {
                                String CardPlayer1 = "";
                                String CardPlayer2 = "";
                                String CardFeaturePlayer1 = "";
                                String CardFeaturePlayer2 = "";
                                String tab = "";
                                if (i >= 0 && i <= 8) {
                                    tab = "    ";
                                }
                                if (i > 8) {
                                    tab = "     ";
                                }
                                String HP1 = "";
                                String HP2 = "";
                                String Nameplayer1 = "";
                                String Nameplayer2 = "";
                                if (i == 8) {
                                    CardPlayer1 = "1- " + CardsPlayer1[0];
                                    CardPlayer2 = "1- " + CardsPlayer2[0];
                                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[0], CardsAttackPlayer1[0], CardsDamagePlayer1[0]);
                                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[0], CardsAttackPlayer2[0], CardsDamagePlayer2[0]);
                                }
                                if (i == 9) {
                                    CardPlayer1 = "2- " + CardsPlayer1[1];
                                    CardPlayer2 = "2- " + CardsPlayer2[1];
                                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[1], CardsAttackPlayer1[1], CardsDamagePlayer1[1]);
                                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[1], CardsAttackPlayer2[1], CardsDamagePlayer2[1]);
                                }
                                if (i == 10) {
                                    CardPlayer1 = "3- " + CardsPlayer1[2];
                                    CardPlayer2 = "3- " + CardsPlayer2[2];
                                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[2], CardsAttackPlayer1[2], CardsDamagePlayer1[2]);
                                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[2], CardsAttackPlayer2[2], CardsDamagePlayer2[2]);
                                    Nameplayer1 = "gamer 1 :" + loginedUser.getCharecter();
                                    Nameplayer2 = "gamer 2 :" + loginedUser1.getCharecter();
                                    HP1 = "Hp player1 :" + HpPlayer1;
                                    HP2 = "Hp player2 :" + HpPlayer2;
                                }
                                if (i == 11) {
                                    CardPlayer1 = "4- " + CardsPlayer1[3];
                                    CardPlayer2 = "4- " + CardsPlayer2[3];
                                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[3], CardsAttackPlayer1[3], CardsDamagePlayer1[3]);
                                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[3], CardsAttackPlayer2[3], CardsDamagePlayer2[3]);
                                }
                                if (i == 12) {
                                    CardPlayer1 = "5- " + CardsPlayer1[4];
                                    CardPlayer2 = "5- " + CardsPlayer2[4];
                                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[4], CardsAttackPlayer1[4], CardsDamagePlayer1[4]);
                                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[4], CardsAttackPlayer2[4], CardsDamagePlayer2[4]);
                                }
                                if (i == 13 && CardsCopy6player1 == 1) {
                                    CardPlayer1 = "6- " + CardsPlayer1[5];
                                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[5], CardsAttackPlayer1[5], CardsDamagePlayer1[5]);
                                }
                                if (i == 13 && CardsCopy6player2 == 1) {
                                    CardPlayer2 = "6- " + CardsPlayer2[5];
                                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[5], CardsAttackPlayer2[5], CardsDamagePlayer2[5]);
                                }
                                if (HiddenCardPlayer1 == 1) {
                                    String[] space = CardPlayer1.split(" ");
                                    CardPlayer1 = space[0];
                                    CardFeaturePlayer1 = "";
                                }
                                if (HiddenCardPlayer2 == 1) {
                                    String[] space = CardPlayer2.split(" ");
                                    CardPlayer2 = space[0];
                                    CardFeaturePlayer2 = "";
                                }

                                System.out.printf("%-20s %-25s %-25s %-25s %-25s %-25s%n", Nameplayer1, CardPlayer1, (i + 1) + "-  " + MapGame[i][0], MapGame[i][1], CardPlayer2, Nameplayer2);
                                Nameplayer1 = "";
                                Nameplayer2 = "";
                                CardPlayer1 = "";
                                CardPlayer2 = "";
                                System.out.printf("%-20s %-25s %-25s %-25s %-25s %-25s", HP1, "   " + CardFeaturePlayer1, tab + GameTowPlayer.getCardFeauture1(MapGame[i][0], attack[i][0], Damageplayer[i][0]),
                                        GameTowPlayer.getCardFeauture1(MapGame[i][1], attack[i][1], Damageplayer[i][1]), "   " + CardFeaturePlayer2, HP2);
                                System.out.println();
                                System.out.println();
                            }
                            System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "player damage 1", "player damage 2");
                            System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", Player1Damage, Player2Damage);
                            System.out.println();
                        }
                    }
                    ///////////////////////////////////time line\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
                    for (int i = 0; i < 21; i++) {
                        if (HpPlayer2<=0) {
//                            System.out.println("Player 1 wins the game");
                            break;
                        }
                        if (HpPlayer1<=0) {
//                            System.out.println("Player 2 wins the game");
                            break;
                        }
                        if (attack[i][0]!=0) {
                            HpPlayer2-=Damageplayer[i][0];
                            System.out.println("Hp player 2 decrease "+Damageplayer[i][0]);
                            if (HpPlayer2>=0) {
                                System.out.println("Hp player 2: "+HpPlayer2);
                            }
                            if (HpPlayer2<0) {
                                System.out.println("Hp player 2: "+0);
                            }
                        }
                        if (attack[i][1]!=0) {
                            HpPlayer1-=Damageplayer[i][1];
                            System.out.println("Hp player 1 decrease "+Damageplayer[i][1]);
                            if (HpPlayer1>=0) {
                                System.out.println("Hp player 1: "+HpPlayer1);
                            }
                            if (HpPlayer1<0) {
                                System.out.println("Hp player 1: "+0);
                            }
                        }
                    }

                    if (HpPlayer2<=0) {
                        System.out.println("Player 1 wins the game");
                        int coinWin= (int) Math.min(Math.max((loginedUser.getCoin())/(Player2Damage+1),40),200);
                        loginedUser.setCoin(coinWin+ loginedUser.getCoin());
                        int XP= (int) (loginedUser.getXP()+Math.min(5,Math.sqrt(4* loginedUser.getCoin())));
                        System.out.println(" your XP :"+XP);
                        if (XP>=loginedUser.getXPlevelup()) {
                            System.out.println("you can level up to "+(loginedUser.getLevel()+1));
                            System.out.println("Congratulation for level up !");
                            System.out.println("You get 10 coins as a reward for leveling up !");
                            loginedUser.setCoin(10+ loginedUser.getCoin());
                            loginedUser.setLevel(loginedUser.getLevel()+1);
                             XP-= loginedUser.getXPlevelup();
                        }
                        loginedUser.setXP(XP);
                        loginedUser.setXPlevelup(loginedUser.getXPlevelup()*2);
                        //////////////////////////////////////////////////
                        int XPlose= (int) Math.min(15,Math.max(5,Math.sqrt(Player2Damage)));
                        System.out.println("Player 2 you are increase Xp :"+XPlose);
                        if (XPlose>=loginedUser1.getXPlevelup()) {
                            System.out.println("you can level up to "+(loginedUser1.getLevel()+1));
                            System.out.println("Congratulation for level up !");
                            System.out.println("You get 10 coins as a reward for leveling up !");
                            loginedUser1.setCoin(10+ loginedUser1.getCoin());
                            loginedUser1.setLevel(loginedUser1.getLevel()+1);
                            XPlose-= loginedUser1.getXPlevelup();
                        }
                        loginedUser1.setXP(XPlose);
                        loginedUser1.setXPlevelup(loginedUser1.getXPlevelup()*2);
                        ////////////////////////Historygame\\\\\\\\\\\\\\\\\\\\\\
                        LocalDateTime timegame = LocalDateTime.now();
                        LocalDateTime truncatedDateTime= timegame.withSecond(0).withNano(0);
                        HistoryGame historyGameplayer1=new HistoryGame(loginedUser.getNickname(),truncatedDateTime,"Coin :"+Integer.toString(coinWin)+",Xp: "+Integer.toString(XP),"Win",Integer.toString(loginedUser1.getLevel()));
                        HistoryGame historyGameplayer2=new HistoryGame(loginedUser1.getNickname(),truncatedDateTime,"Xp :"+Integer.toString(XPlose),"Lose",Integer.toString(loginedUser.getLevel()));
                            loginedUser.getHistoryGame().add(historyGameplayer1);
                            loginedUser1.getHistoryGame().add(historyGameplayer2);
                        /////////////////////////////////////////////////////
                        System.out.println("log out player 2");
                        currentMenu[0]=menu.Main_Menu;
                        System.out.println("you are enter Main Menu");
                        break;
                    }
                    ////////////////////////////////////////
                    if (HpPlayer1<=0) {
                        System.out.println("Player 2 wins the game");
                        int coinWin= (int) Math.min(Math.max((loginedUser1.getCoin())/(Player1Damage+1),40),200);
                        loginedUser1.setCoin(coinWin+ loginedUser1.getCoin());
                        int XP= (int) (loginedUser1.getXP()+Math.min(5,Math.sqrt(4* loginedUser1.getCoin())));
                        System.out.println(" your XP :"+XP);
                        if (XP>=loginedUser1.getXPlevelup()) {
                            System.out.println("you can level up to "+(loginedUser1.getLevel()+1));
                            System.out.println("Congratulation for level up !");
                            System.out.println("You get 10 coins as a reward for leveling up !");
                            loginedUser1.setCoin(10+ loginedUser1.getCoin());
                            loginedUser1.setLevel(loginedUser1.getLevel()+1);
                            XP-= loginedUser1.getXPlevelup();
                        }
                        loginedUser1.setXP(XP);
                        loginedUser1.setXPlevelup(loginedUser1.getXPlevelup()*2);
                        //////////////////////////////////////////////////
                        int XPlose= (int) Math.min(15,Math.max(5,Math.sqrt(Player1Damage)));
                        System.out.println("Player 1 you are increase Xp :"+XPlose);
                        if (XPlose>=loginedUser.getXPlevelup()) {
                            System.out.println("you can level up to "+(loginedUser.getLevel()+1));
                            System.out.println("Congratulation for level up !");
                            System.out.println("You get 10 coins as a reward for leveling up !");
                            loginedUser.setCoin(10+ loginedUser.getCoin());
                            loginedUser.setLevel(loginedUser.getLevel()+1);
                            XPlose-= loginedUser.getXPlevelup();
                        }
                        loginedUser.setXP(XPlose);
                        loginedUser.setXPlevelup(loginedUser.getXPlevelup()*2);
                        ///////////////////////////////////////////history
                        LocalDateTime timegame = LocalDateTime.now();
                        LocalDateTime truncatedDateTime= timegame.withSecond(0).withNano(0);
                        HistoryGame historyGameplayer2=new HistoryGame(loginedUser1.getNickname(),truncatedDateTime,"Coin :"+Integer.toString(coinWin)+",Xp: "+Integer.toString(XP),"Win",Integer.toString(loginedUser1.getLevel()));
                        HistoryGame historyGameplayer1=new HistoryGame(loginedUser.getNickname(),truncatedDateTime,"Xp :"+Integer.toString(XPlose),"Lose",Integer.toString(loginedUser.getLevel()));
                        loginedUser.getHistoryGame().add(historyGameplayer1);
                        loginedUser1.getHistoryGame().add(historyGameplayer2);

                        ////////////////////////////////////
                        System.out.println("log out player 2");
                        currentMenu[0]=menu.Main_Menu;
                        System.out.println("you are enter Main Menu");
                        break;
                    }
                    ///////////////////////////////////////////////////////////////////////////
                }
            }
            if (currentMenu[0] == menu.BettingMode) {
                currentMenu[0]=menu.loginforGamebetting;
                System.out.println("please login the second Player !");
            }
            if (currentMenu[0]==menu.loginforGamebetting) {
                if (loginMatcher.matches()) {
                    String username = loginMatcher.group(1);
                    String password = loginMatcher.group(2);
                    if (!exist(users, a -> a.username.equals(username))) System.out.println("Username doesn’t exist!");
                    else {
                        loginedUser1 = find(users, a -> a.username.equals(username));
                        if (!loginedUser1.password.equals(password)) {
                            System.out.println("Password and Username don't match!");
                            failCount++;
                            banDuration = 5000L * failCount;
                            banStartTime = System.currentTimeMillis();

                            System.out.format("Try again in %d seconds\n", banDuration / 1000);
                        } else {
                            failCount = 0;
                            System.out.println("user logged in successfully for game!");
                            currentMenu[0] = menu.GameBettingMode_Menu;
                            if (loginedUser1.CardsPlayer.size()==0&&loginedUser1.specialCardsPlayer.size()==0) {
                                starterpack(loginedUser1);
                                System.out.println();
                            }
                            System.out.println("you are start game");
                            // دسترسی کامل به thisUser
                            // ادامه برنامه ...
                        }
                    }
                }
                if (forgotMatcher.matches()) {
                    String user = forgotMatcher.group(1);
                    if (!exist(users, a -> a.username.equals(user))) System.out.println("The user not found.");
                    else {
                        User thisUser = find(users, a -> a.username.equals(user));
                        System.out.print("Please answer all of the security questions : \n" +
                                "• 1-What is your father’s name ?\n" +
                                "• 2-What is your favourite color ?\n" +
                                "• 3-What was the name of your first pet?\n");
                        String[] answers = {"", "", ""};

                        while (answers[0].isEmpty() || answers[1].isEmpty() || answers[2].isEmpty()) {
                            String answer = input.nextLine();
                            String answerRegex = "^\\s*question\\s+pick\\s+-q\\s+(.*)\\s+-a\\s+(.*)\\s+-c\\s+(.*)\\s*$";
                            Pattern answerPattern = Pattern.compile(answerRegex);
                            Matcher answerMatcher = answerPattern.matcher(answer);

                            if (answerMatcher.matches()) {
                                int questionNum = Integer.parseInt(answerMatcher.group(1));
                                String Answer = answerMatcher.group(2);
                                String confirmAnswer = answerMatcher.group(3);
                                if (questionNum > 3 || questionNum < 1) System.out.println("Invalid question number");
                                else if (!Answer.equals(confirmAnswer))
                                    System.out.println("Please check your answer again!");
                                else {
                                    System.out.format("Question %d answered!\n", questionNum);

                                    answers[questionNum - 1] = Answer;
                                }
                            }
                        }
                        if (answers[0].equals(thisUser.securityQuestion[0]) && answers[1].equals(thisUser.securityQuestion[1]) && answers[2].equals(thisUser.securityQuestion[2])) {
                            boolean getPass = true;
                            while (getPass) {
                                System.out.println("Enter your new password: ");
                                String newPass = input.nextLine();
                                String checkPass1 = "^.{8,}$";
                                String checkPass2 = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d\\s])[^\\s]*$";
                                Matcher passMatcher = setMatcher(newPass, checkPass1);
                                Matcher passMatcher2 = setMatcher(newPass, checkPass2);
                                if (!passMatcher.matches())
                                    System.out.println("The password must have at least 8 characters");
                                else if (!passMatcher2.matches())
                                    System.out.print("The password must have at least:\n" +
                                            "- A small letter\n" +
                                            "- A capital letter\n" +
                                            "- A number\n" +
                                            "- One character except numbers and letters\n");
                                else {
                                    getPass = false;
                                    thisUser.password = newPass;
                                    System.out.println("Your password changed successfully!");
                                }
                            }
                        } else System.out.println("Wrong Answers!");
                    }


                }
            }
            if (currentMenu[0]==menu.GameBettingMode_Menu) {
                System.out.println("100 coins will be deducted from your coins to start the game !");
                if (loginedUser.getCoin() < 100) {
                    System.out.println("player1 you do not have enough coins to start the game !");
                    currentMenu[0] = menu.Main_Menu;
                    System.out.println("you are enter Main Menu");
                }
                if (loginedUser1.getCoin() < 100) {
                    System.out.println("player2 you do not have enough coins to start the game !");
                    currentMenu[0] = menu.Main_Menu;
                    System.out.println("log out player 2");
                    System.out.println("you are enter Main Menu");
                }
                else {
                    loginedUser.setCoin(loginedUser.getCoin()-100);
                    loginedUser1.setCoin(loginedUser1.getCoin()-100);
                    for (int i = 0; i < carecter.size(); i++) {
                        System.out.println((i + 1) + " - " + carecter.get(i).getName());
                    }
                    GameTowPlayer.SelectCharacter(loginedUser, "first", input);
                    GameTowPlayer.SelectCharacter(loginedUser1, "second", input);
                    System.out.println("start fight !");
                    ///////////////////////////////////again
                    ////////////////////////////////////////nobat\\\\\\\\\\\\\\\\\\\\
                    boolean play1 = false;
                    boolean play2 = false;
                    int randomStartGame = (int) (Math.random() * 3) + 1;
                    if (randomStartGame == 1 || randomStartGame == 2) {
                        play1 = true;
                        play2 = false;
                    }
                    if (randomStartGame == 3) {
                        play2 = true;
                        play1 = false;
                    }
                    int HpPlayer1 = loginedUser.getHP();
                    int HpPlayer2 = loginedUser1.getHP();
                    ////////////////////////////////////////////////Map
                    int rund = 1;
                    //////////////////////////////////////////
                    while (true) {
                        System.out.println("Rund : " + rund);
                        ++rund;
                        String[][] MapGame = new String[21][2];
                        int[][] CardLocation = new int[21][2];
                        int CardLoca = 0;
                        int[][] Damageplayer = new int[21][2];
                        int[][] attack = new int[21][2];
                        for (int i = 0; i < 21; i++) {
                            for (int j = 0; j < 2; j++) {
                                MapGame[i][j] = "";
                                Damageplayer[i][j] = 0;
                                attack[i][j] = 0;
                                CardLocation[i][j] = -1;
                            }
                        }
                        int randomNumplayer1 = (int) (Math.random() * 21);
                        int randomNum1player2 = (int) (Math.random() * 21);
                        MapGame[randomNumplayer1][0] = "#";
                        MapGame[randomNum1player2][1] = "#";
                        /////////////////////////////////////////player1
                        ArrayList<String> Namecard = new ArrayList<>();
                        String[] CardsPlayer1 = new String[6];
                        int[] CardsAttackPlayer1 = new int[6];
                        int[] CardsDamagePlayer1 = new int[6];
                        for (int i = 0; i < 6; i++) {
                            CardsPlayer1[i] = "";
                        }
                        for (int i = 0; i < loginedUser.CardsPlayer.size(); i++) {
                            Namecard.add(loginedUser.CardsPlayer.get(i).getName());
                        }
                        for (int i = 0; i < loginedUser.specialCardsPlayer.size(); i++) {
                            Namecard.add(loginedUser.specialCardsPlayer.get(i).getNameCard());
                        }
                        Set<String> selectedItems = new HashSet<>();
                        Random random = new Random();
                        while (selectedItems.size() < 5) {
                            int randomIndex = random.nextInt(Namecard.size());
                            selectedItems.add(Namecard.get(randomIndex));
                        }
                        int x = 0;
                        for (String item : selectedItems) {
                            CardsPlayer1[x] = item;
                            if (Card.CheckName(item)) {
                                CardsAttackPlayer1[x] = Integer.parseInt(Card.returnCardbyName(item).getCardAttack());
                                CardsDamagePlayer1[x] = Integer.parseInt(Card.returnCardbyName(item).getPlayerDamage());
                            }
                            if (SpecialCard.Checkname(item)) {
                                CardsAttackPlayer1[x] = 0;
                                CardsDamagePlayer1[x] = 0;
                            }
                            ++x;
                        }
                        /////////////////////////////////////////player2
                        ArrayList<String> Namecard1 = new ArrayList<>();
                        String[] CardsPlayer2 = new String[6];
                        int[] CardsAttackPlayer2 = new int[6];
                        int[] CardsDamagePlayer2 = new int[6];
                        for (int i = 0; i < 6; i++) {
                            CardsPlayer2[i] = "";
                        }
                        for (int i = 0; i < loginedUser1.CardsPlayer.size(); i++) {
                            Namecard1.add(loginedUser1.CardsPlayer.get(i).getName());
                        }
                        for (int i = 0; i < loginedUser1.specialCardsPlayer.size(); i++) {
                            Namecard1.add(loginedUser1.specialCardsPlayer.get(i).getNameCard());
                        }
                        Set<String> selectedItems1 = new HashSet<>();
                        Random random1 = new Random();
                        while (selectedItems1.size() < 5) {
                            int randomIndex1 = random1.nextInt(Namecard1.size());
                            selectedItems1.add(Namecard1.get(randomIndex1));
                        }
                        int x1 = 0;
                        for (String item : selectedItems1) {
                            CardsPlayer2[x1] = item;
                            if (Card.CheckName(item)) {
                                CardsAttackPlayer2[x1] = Integer.parseInt(Card.returnCardbyName(item).getCardAttack());
                                CardsDamagePlayer2[x1] = Integer.parseInt(Card.returnCardbyName(item).getPlayerDamage());
                            }
                            if (SpecialCard.Checkname(item)) {
                                CardsAttackPlayer2[x1] = 0;
                                CardsDamagePlayer2[x1] = 0;
                            }
                            ++x1;
                        }
                        //////////////////////////////////////////again
                        int numRand1 = 4;
                        int numRand2 = 4;
                        int CardsCopy6player1 = 0;
                        int CardsCopy6player2 = 0;
                        int HiddenCardPlayer2 = 0;
                        int HiddenCardPlayer1 = 0;
                        int timeHiddenplayer1 = 0;
                        int timeHiddenplayer2 = 0;
/////////////////////////////////////////////////////////////////
                        int Player1Damage = 0;
                        int Player2Damage = 0;
                        ////////////////////////////////////////////////////////////////////////
                        System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "rand 1", "rand 2");
                        System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", numRand1, numRand2);
                        System.out.println();
                        System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", "1-", "2-");
                        System.out.println();
                        for (int i = 0; i < 21; i++) {
                            String CardPlayer1 = "";
                            String CardPlayer2 = "";
                            String CardFeaturePlayer1 = "";
                            String CardFeaturePlayer2 = "";
                            String tab = "";
                            if (i >= 0 && i <= 8) {
                                tab = "    ";
                            }
                            if (i > 8) {
                                tab = "     ";
                            }
                            String HP1 = "";
                            String HP2 = "";
                            String Nameplayer1 = "";
                            String Nameplayer2 = "";
                            if (i == 8) {
                                CardPlayer1 = "1- " + CardsPlayer1[0];
                                CardPlayer2 = "1- " + CardsPlayer2[0];
                                CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[0], CardsAttackPlayer1[0], CardsDamagePlayer1[0]);
                                CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[0], CardsAttackPlayer2[0], CardsDamagePlayer2[0]);
                            }
                            if (i == 9) {
                                CardPlayer1 = "2- " + CardsPlayer1[1];
                                CardPlayer2 = "2- " + CardsPlayer2[1];
                                CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[1], CardsAttackPlayer1[1], CardsDamagePlayer1[1]);
                                CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[1], CardsAttackPlayer2[1], CardsDamagePlayer2[1]);
                            }
                            if (i == 10) {
                                CardPlayer1 = "3- " + CardsPlayer1[2];
                                CardPlayer2 = "3- " + CardsPlayer2[2];
                                CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[2], CardsAttackPlayer1[2], CardsDamagePlayer1[2]);
                                CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[2], CardsAttackPlayer2[2], CardsDamagePlayer2[2]);
                                Nameplayer1 = "gamer 1 :" + loginedUser.getCharecter();
                                Nameplayer2 = "gamer 2 :" + loginedUser1.getCharecter();
                                HP1 = "Hp player1 :" + HpPlayer1;
                                HP2 = "Hp player2 :" + HpPlayer2;
                            }
                            if (i == 11) {
                                CardPlayer1 = "4- " + CardsPlayer1[3];
                                CardPlayer2 = "4- " + CardsPlayer2[3];
                                CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[3], CardsAttackPlayer1[3], CardsDamagePlayer1[3]);
                                CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[3], CardsAttackPlayer2[3], CardsDamagePlayer2[3]);
                            }
                            if (i == 12) {
                                CardPlayer1 = "5- " + CardsPlayer1[4];
                                CardPlayer2 = "5- " + CardsPlayer2[4];
                                CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[4], CardsAttackPlayer1[4], CardsDamagePlayer1[4]);
                                CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[4], CardsAttackPlayer2[4], CardsDamagePlayer2[4]);
                            }
                            if (i == 13 && CardsCopy6player1 == 1) {
                                CardPlayer1 = "6- " + CardsPlayer1[5];
//                            CardPlayer2 = "6- " + CardsPlayer2[4];
                                CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[5], CardsAttackPlayer1[5], CardsDamagePlayer1[5]);
//                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[4],CardsAttackPlayer2[4],CardsDamagePlayer2[4]);
                            }
                            if (i == 13 && CardsCopy6player2 == 1) {
                                CardPlayer2 = "6- " + CardsPlayer2[5];
                                CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[5], CardsAttackPlayer2[5], CardsDamagePlayer2[5]);
                            }
                            if (HiddenCardPlayer1 == 1) {
                                String[] space = CardPlayer1.split(" ");
                                CardPlayer1 = space[0];
                                CardFeaturePlayer1 = "";
                            }
                            if (HiddenCardPlayer2 == 1) {
                                String[] space = CardPlayer2.split(" ");
                                CardPlayer2 = space[0];
                                CardFeaturePlayer2 = "";
                            }

                            System.out.printf("%-20s %-25s %-25s %-25s %-30s %-30s%n", Nameplayer1, CardPlayer1, (i + 1) + "-  " + MapGame[i][0], MapGame[i][1], CardPlayer2, Nameplayer2);
                            Nameplayer1 = "";
                            Nameplayer2 = "";
                            CardPlayer1 = "";
                            CardPlayer2 = "";
                            System.out.printf("%-20s %-25s %-25s %-25s %-30s %-30s", HP1, "   " + CardFeaturePlayer1, tab + GameTowPlayer.getCardFeauture1(MapGame[i][0], attack[i][0], Damageplayer[i][0]),
                                    GameTowPlayer.getCardFeauture1(MapGame[i][1], attack[i][1], Damageplayer[i][1]), "   " + CardFeaturePlayer2, HP2);
                            System.out.println();
                            System.out.println();
                        }
                        System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "player damage 1", "player damage 2");
                        System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", Player1Damage, Player2Damage);
                        System.out.println();
                        /////////////////////////////////
                        ArrayList<Integer> cardShecanPlayer1 = new ArrayList<>();
                        ArrayList<Integer> cardShecanPlayer2 = new ArrayList<>();
                        while (true) {
                            if (numRand1 == 0 && numRand2 == 0) {
                                break;
                            }
                            if (play1 && !play2) {
                                System.out.println("placing card player 1 or select");
                            }
                            if (!play1 && play2) {
                                System.out.println("placing card player 2 or select");
                            }
                            if (numRand2 == timeHiddenplayer2 - 1) {
                                HiddenCardPlayer2 = 0;
                            }
                            if (numRand1 == timeHiddenplayer1 - 1) {
                                HiddenCardPlayer1 = 0;
                            }
                            String vorody = input.nextLine();
                            String regex1 = "-Select card number (?<number>.+) player (?<player>.+)";
                            Matcher regexVorody = setMatcher(vorody, regex1);
                            String regex = "Placing card number (?<num>.+) in block (?<location>.+)";
                            Matcher regexAns = setMatcher(vorody, regex);
                            if (regexVorody.matches()) {
                                String Cardnum = regexVorody.group("number");
                                String gamer = regexVorody.group("player");
                                if (!Cardnum.equals("1") && !Cardnum.equals("2") && !Cardnum.equals("3") && !Cardnum.equals("4") && !Cardnum.equals("5")) {
                                    System.out.println("please enter a number between 1 and 5 !");
                                } else if (!gamer.equals("1") && !gamer.equals("2")) {
                                    System.out.println("please enter number between 1 and 2 !");
                                } else {
                                    if (gamer.equals("1")) {
                                        String Name = CardsPlayer1[Integer.parseInt(Cardnum) - 1];
                                        if (Card.CheckName(CardsPlayer1[Integer.parseInt(Cardnum) - 1])) {
                                            System.out.println("Name Card : " + Name);
                                            System.out.println("Duration Card : " + Card.returnCardbyName(Name).getDuration());
                                            System.out.println("Attack Card : " + Card.returnCardbyName(Name).getCardAttack());
                                            System.out.println("Player Damage Card : " + Card.returnCardbyName(Name).getPlayerDamage());
                                            System.out.println("Character Card : " + Card.returnCardbyName(Name).getCharec());
                                        }
                                        if (SpecialCard.Checkname(CardsPlayer1[Integer.parseInt(Cardnum) - 1])) {
                                            System.out.println("Name Card : " + SpecialCard.returnSpecialbyName(Name).getNameCard());
                                            System.out.println("Description :" + SpecialCard.returnSpecialbyName(Name).getDescription());
                                        }
                                    }
                                    if (gamer.equals("2")) {
                                        String Name = CardsPlayer2[Integer.parseInt(Cardnum) - 1];
                                        if (Card.CheckName(CardsPlayer2[Integer.parseInt(Cardnum) - 1])) {
                                            System.out.println("Name Card : " + Name);
                                            System.out.println("Duration Card : " + Card.returnCardbyName(Name).getDuration());
                                            System.out.println("Attack Card : " + Card.returnCardbyName(Name).getCardAttack());
                                            System.out.println("Player Damage Card : " + Card.returnCardbyName(Name).getPlayerDamage());
                                            System.out.println("Character Card : " + Card.returnCardbyName(Name).getCharec());
                                        }
                                        if (SpecialCard.Checkname(CardsPlayer2[Integer.parseInt(Cardnum) - 1])) {
                                            System.out.println("Name Card : " + SpecialCard.returnSpecialbyName(Name).getNameCard());
                                            System.out.println("Description :" + SpecialCard.returnSpecialbyName(Name).getDescription());
                                        }
                                    }
                                }
                            }
                            if (regexAns.matches()) {
                                String num = regexAns.group("num");
                                if (play1) {
                                    String lenght = regexAns.group("location");
                                    System.out.println(lenght);
                                    if (!num.equals("1") && !num.equals("2") && !num.equals("3") && !num.equals("4") && !num.equals("5") && (!num.equals("6") || CardsCopy6player1 == 0)) {
                                        System.out.println("please enter a number between 1 and 5 !");
                                    } else if (!lenght.equals("1") && !lenght.equals("2") && !lenght.equals("3") && !lenght.equals("4") && !lenght.equals("5") &&
                                            !lenght.equals("6") && !lenght.equals("7") && !lenght.equals("8") && !lenght.equals("9") && !lenght.equals("10") &&
                                            !lenght.equals("11") && !lenght.equals("12") && !lenght.equals("13") && !lenght.equals("14") && !lenght.equals("15") &&
                                            !lenght.equals("20") && !lenght.equals("19") && !lenght.equals("18") && !lenght.equals("17") && !lenght.equals("16") && !lenght.equals("21")
                                    ) {
                                        System.out.println("please enter a number between 1 and 21");
                                    } else {
                                        if (Card.CheckName(CardsPlayer1[Integer.parseInt(num) - 1])) {
                                            if (Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer1).getDuration()) + Integer.parseInt(lenght) > 22) {
                                                System.out.println("you can not place this card in this location1 !");
                                            } else if (GameTowPlayer.CheckTheSelectCardplayer1(num, lenght, CardsPlayer1, MapGame)) {
                                                System.out.println("you can not place this card in this location2 !");
                                            } else {
                                                int x2 = Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer1).getDuration()) + Integer.parseInt(lenght) - 1;
                                                for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
                                                    MapGame[i][0] = GameTowPlayer.getCardWithName(num, CardsPlayer1).getName();
                                                    attack[i][0] = CardsAttackPlayer1[Integer.parseInt(num) - 1];
                                                    CardLocation[i][0] = CardLoca;
                                                }
                                                ++CardLoca;
                                                if (Integer.parseInt(num) != 3 && CardsPlayer1[5].equals("")) {
                                                    int q = GameTowPlayer.CharChargetScore(Card.returnCardbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getCharec(), Card.returnCardbyName(CardsPlayer1[2]).getCharec(), Integer.parseInt(Card.returnCardbyName(CardsPlayer1[2]).getDuration()));
                                                    CardsDamagePlayer1[2] += q;
                                                }
                                                //////////////////////////////////////
//                                         player damage
                                                for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
                                                    if (loginedUser.getCharecter().equals(Card.returnCardbyName(MapGame[i][0]).getCharec())) {
                                                        if (MapGame[i][1] == "" || MapGame[i][1] == "#") {
                                                            MapGame[i][0] = CardsPlayer1[Integer.parseInt(num) - 1];
                                                            attack[i][0] = CardsAttackPlayer1[Integer.parseInt(num) - 1];
                                                            double e = (CardsDamagePlayer1[Integer.parseInt(num) - 1]) / Integer.parseInt(Card.returnCardbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getDuration());
                                                            Damageplayer[i][0] = (int) e + 1;
                                                            Player1Damage += Damageplayer[i][0];
                                                        } else {
                                                            MapGame[i][0] = CardsPlayer1[Integer.parseInt(num) - 1];
                                                            attack[i][0] = CardsAttackPlayer1[Integer.parseInt(num) - 1];
                                                            ////////////////Card
                                                            if (Card.CheckName(MapGame[i][1])) {
                                                                if (attack[i][1] > attack[i][0]) {
                                                                    attack[i][0] = 0;
                                                                } else if (attack[i][1] < attack[i][0]) {
                                                                    double e = CardsDamagePlayer1[Integer.parseInt(num) - 1] / Integer.parseInt(Card.returnCardbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getDuration());
                                                                    Damageplayer[i][0] = (int) e + 1;
                                                                    Player1Damage += Damageplayer[i][0];
                                                                    Player2Damage -= Damageplayer[i][1];
                                                                    attack[i][1] = 0;
                                                                } else if (attack[i][1] == attack[i][0]) {
                                                                    Player2Damage -= Damageplayer[i][1];
//                                                                Damageplayer[i][1] = 0;
//                                                                Damageplayer[i][0] = 0;
                                                                    attack[i][1] = 0;
                                                                    attack[i][0] = 0;
                                                                }
                                                                //////////Special Card
                                                                else {
                                                                    MapGame[i][0] = CardsPlayer1[Integer.parseInt(num) - 1];
                                                                    if (MapGame[i][1].equals("shield")) {
//                                                                    Damageplayer[i][0] = 0;
                                                                        attack[i][0] = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (MapGame[i][1] == "" || MapGame[i][1] == "#") {
                                                            MapGame[i][0] = CardsPlayer1[Integer.parseInt(num) - 1];
                                                            attack[i][0] = CardsAttackPlayer1[Integer.parseInt(num) - 1];
                                                            double e = CardsDamagePlayer1[Integer.parseInt(num) - 1] / Integer.parseInt(Card.returnCardbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getDuration());
                                                            Damageplayer[i][0] = (int) e;
                                                            Player1Damage += Damageplayer[i][0];
                                                        } else {
                                                            //////////////card
                                                            MapGame[i][0] = CardsPlayer1[Integer.parseInt(num) - 1];
                                                            attack[i][0] = CardsAttackPlayer1[Integer.parseInt(num) - 1];
                                                            if (Card.CheckName(MapGame[i][1])) {
                                                                if (attack[i][1] > attack[i][0]) {
                                                                    attack[i][0] = 0;
                                                                } else if (attack[i][1] < attack[i][0]) {
                                                                    double e = CardsDamagePlayer1[Integer.parseInt(num) - 1] / Integer.parseInt(Card.returnCardbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getDuration());
                                                                    Damageplayer[i][0] = (int) e;
                                                                    Player1Damage += Damageplayer[i][0];
                                                                    Player2Damage -= Damageplayer[i][1];
                                                                    attack[i][1] = 0;
                                                                } else if (attack[i][1] == attack[i][0]) {
                                                                    Player2Damage -= Damageplayer[i][1];
                                                                    attack[i][0] = 0;
                                                                    attack[i][1] = 0;
                                                                }
                                                            }
                                                            ///////////////////////special card
                                                            else {
                                                                MapGame[i][0] = CardsPlayer1[Integer.parseInt(num) - 1];
                                                                if (MapGame[i][1].equals("shield")) {
                                                                    attack[i][0] = 0;
                                                                }
                                                            }

                                                        }

                                                    }
                                                }
                                                ///////////////////////////////////////////////////////////
                                                Random random2 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random2.nextInt(Namecard.size());
                                                cardRand = Namecard.get(randomIndex3);
                                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                }
                                                ////////////////////////////////////////////////
                                                --numRand1;
                                                play1 = false;
                                                play2 = true;
                                            }
                                        }
                                        ///////////////////////////////SpeciaCard
                                        else if (SpecialCard.Checkname(CardsPlayer1[Integer.parseInt(num) - 1])) {
                                            if (GameTowPlayer.CheckTheSelectSpecialCard(lenght, MapGame)) {
                                                System.out.println("you can not place this special card in this location !");
                                            } else {
                                                if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("healing")) {
                                                    MapGame[Integer.parseInt(lenght) - 1][0] = "healing";
                                                    CardLocation[Integer.parseInt(lenght) - 1][0] = CardLoca;
                                                    ++CardLoca;
                                                    attack[Integer.parseInt(lenght) - 1][0] = 0;
                                                    Damageplayer[Integer.parseInt(lenght) - 1][0] = 0;
                                                    Random random5 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random5.nextInt(Namecard.size());
                                                    cardRand = Namecard.get(randomIndex3);
                                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    ////////////////////////////////////////////////
//                                                /loginedUser.setHP(loginedUser.getHP() + 15);
                                                    HpPlayer1 += 15;
                                                    --numRand1;
                                                    play1 = false;
                                                    play2 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("repairman")) {
                                                    Random random6 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random6.nextInt(Namecard.size());
                                                    cardRand = Namecard.get(randomIndex3);
                                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    ////////////////////////////////////////////////
                                                    MapGame[randomNumplayer1][0] = "";
                                                    --numRand1;
                                                    play1 = false;
                                                    play2 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("roundReducer")) {
                                                    Random random7 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random7.nextInt(Namecard.size());
                                                    cardRand = Namecard.get(randomIndex3);
                                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    /////////////////////////////////////////////////
                                                    --numRand1;
                                                    --numRand1;
                                                    --numRand2;
                                                    play1 = false;
                                                    play2 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("shield")) {
                                                    MapGame[Integer.parseInt(lenght) - 1][0] = "shield";
                                                    attack[Integer.parseInt(lenght) - 1][0] = 0;
                                                    Damageplayer[Integer.parseInt(lenght) - 1][0] = 0;
                                                    CardLocation[Integer.parseInt(lenght) - 1][0] = CardLoca;
                                                    ++CardLoca;
                                                    Random random9 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random9.nextInt(Namecard.size());
                                                    cardRand = Namecard.get(randomIndex3);
                                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand1;
                                                    play1 = false;
                                                    play2 = true;
                                                    ////////////////////////////////////////////////
                                                    if (MapGame[Integer.parseInt(lenght) - 1][1] == "" || MapGame[Integer.parseInt(lenght) - 1][1] == "#") {
                                                    } else if (MapGame[Integer.parseInt(lenght) - 1][1] != "") {
                                                        if (SpecialCard.Checkname(MapGame[Integer.parseInt(lenght) - 1][1])) {
                                                        } else if (Card.CheckName(MapGame[Integer.parseInt(lenght) - 1][1])) {
                                                            Player2Damage -= Damageplayer[Integer.parseInt(lenght) - 1][1];
//                                                        Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
                                                            attack[Integer.parseInt(lenght) - 1][1] = 0;
                                                        }
                                                    }

                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("HoleLocationModifier")) {
                                                    MapGame[Integer.parseInt(lenght) - 1][0] = "HoleLocationModifier";
                                                    attack[Integer.parseInt(lenght) - 1][0] = 0;
                                                    Damageplayer[Integer.parseInt(lenght) - 1][0] = 0;
                                                    CardLocation[Integer.parseInt(lenght) - 1][0] = CardLoca;
                                                    ++CardLoca;
                                                    MapGame[randomNumplayer1][0] = "";
                                                    MapGame[randomNum1player2][1] = "";
                                                    while (true) {
                                                        int randomplayer1 = (int) (Math.random() * 21);
                                                        if (MapGame[randomplayer1][0] == "") {
                                                            MapGame[randomplayer1][0] = "#";
                                                            randomNumplayer1 = randomplayer1;
                                                            break;
                                                        }
                                                    }
                                                    while (true) {
                                                        int randomplayer2 = (int) (Math.random() * 21);
                                                        if (MapGame[randomplayer2][0] == "") {
                                                            MapGame[randomplayer2][0] = "#";
                                                            randomNum1player2 = randomplayer2;
                                                            break;
                                                        }
                                                    }
                                                    Random random0 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random0.nextInt(Namecard.size());
                                                    cardRand = Namecard.get(randomIndex3);
                                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand1;
                                                    play1 = false;
                                                    play2 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("CardWeakner")) {
                                                    ArrayList<Integer> rend = new ArrayList<>();
                                                    ArrayList<Integer> Weakner = new ArrayList<>();
                                                    for (int i = 0; i < 5; i++) {
                                                        if (Card.CheckName(CardsPlayer2[i])) {
                                                            Weakner.add(i);
                                                        }
                                                    }
                                                    if (Weakner.size() > 1) {
                                                        Random random21 = new Random();
                                                        while (rend.size() < 2) {
                                                            int randomIndex = random21.nextInt(Weakner.size());
                                                            rend.add(Weakner.get(randomIndex));
                                                        }
                                                        CardsAttackPlayer2[rend.get(0)] -= 3;
                                                        CardsDamagePlayer2[rend.get(1)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer2[rend.get(1)]).getDuration());
                                                    }
                                                    if (Weakner.size() == 1) {
                                                        Random random31 = new Random();
                                                        int randomIndex = random31.nextInt(2);
                                                        if (randomIndex == 0) {
                                                            CardsAttackPlayer2[Weakner.get(0)] -= 3;
                                                        }
                                                        if (randomIndex == 1) {
                                                            CardsDamagePlayer2[Weakner.get(0)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer2[rend.get(1)]).getDuration());
                                                        }
                                                    }
                                                    if (Weakner.size() == 0) {
                                                    }
                                                    Random random03 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random03.nextInt(Namecard.size());
                                                    cardRand = Namecard.get(randomIndex3);
                                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand1;
                                                    play1 = false;
                                                    play2 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("PowerBosster")) {
                                                    Random random03 = new Random();
                                                    int randomIndex3 = random03.nextInt(CardLoca);

                                                    for (int i = 0; i < 21; i++) {
                                                        if (CardLocation[i][0] == randomIndex3) {
                                                            Damageplayer[i][0] += 3;
                                                            Player1Damage += 3;
                                                        }
                                                    }
                                                    Random random04 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex4 = random04.nextInt(Namecard.size());
                                                    cardRand = Namecard.get(randomIndex4);
                                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand1;
                                                    play1 = false;
                                                    play2 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("Copycard")) {
                                                    String copy = "";
                                                    while (true) {
                                                        System.out.println("please enter the desired Card number for the copy !");
                                                        String NUM = input.nextLine();
                                                        if (!NUM.equals("1") && !NUM.equals("2") && !NUM.equals("3") && !NUM.equals("4") && !NUM.equals("5")) {
                                                            System.out.println("please enter a number between 1 and 5 !");
                                                        } else {
                                                            copy = NUM;
                                                            break;
                                                        }
                                                    }
                                                    CardsPlayer1[5] = CardsPlayer1[Integer.parseInt(copy) - 1];
                                                    CardsAttackPlayer1[5] = CardsAttackPlayer1[Integer.parseInt(copy) - 1];
                                                    CardsDamagePlayer1[5] = CardsDamagePlayer1[Integer.parseInt(copy) - 1];
                                                    CardsCopy6player1 = 1;

                                                    Random random04 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex4 = random04.nextInt(Namecard.size());
                                                    cardRand = Namecard.get(randomIndex4);
                                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand1;
                                                    play1 = false;
                                                    play2 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("RemoveCard")) {
                                                    if (CardsCopy6player1 == 1) {
                                                        System.out.println("you can not use this Card");
                                                        continue;
                                                    } else {
                                                        Random random2 = new Random();
                                                        int cin = random2.nextInt(5);
                                                        CardsPlayer1[5] = CardsPlayer2[cin];
                                                        CardsAttackPlayer1[5] = CardsAttackPlayer2[cin];
                                                        CardsDamagePlayer1[5] = CardsDamagePlayer2[cin];
                                                        CardsCopy6player1 = 1;
                                                        CardsPlayer2[cin] = "";
                                                        CardsAttackPlayer2[cin] = 0;
                                                        CardsDamagePlayer2[cin] = 0;
                                                    }
                                                    /////////////////////////
                                                    Random random05 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex4 = random05.nextInt(Namecard.size());
                                                    cardRand = Namecard.get(randomIndex4);
                                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand1;
                                                    play1 = false;
                                                    play2 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("HiddenCard")) {
                                                    HiddenCardPlayer2 = 1;
                                                    String a = CardsPlayer2[0];
                                                    String b = CardsPlayer2[1];
                                                    String c = CardsPlayer2[2];
                                                    String d = CardsPlayer2[3];
                                                    String e = CardsPlayer2[4];
                                                    CardsPlayer2[0] = d;
                                                    CardsPlayer2[1] = c;
                                                    CardsPlayer2[2] = b;
                                                    CardsPlayer2[3] = e;
                                                    CardsPlayer2[4] = a;
                                                    timeHiddenplayer2 = numRand2;
                                                    Random random05 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex4 = random05.nextInt(Namecard.size());
                                                    cardRand = Namecard.get(randomIndex4);
                                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand1;
                                                    play1 = false;
                                                    play2 = true;
                                                }
                                            }
                                        }
                                    }
                                } else if (play2) {
//                                    System.out.println("please select player 2 desired card and specify its location !");
//                                    String num = regexAns.group("num");
                                    String lenght = regexAns.group("location");
                                    if (!num.equals("1") && !num.equals("2") && !num.equals("3") && !num.equals("4") && !num.equals("5") && (!num.equals("6") || CardsCopy6player2 == 0)) {
                                        System.out.println("please enter a number between 1 and 5 !");
                                    } else if (!lenght.equals("1") && !lenght.equals("2") && !lenght.equals("3") && !lenght.equals("4") && !lenght.equals("5") &&
                                            !lenght.equals("6") && !lenght.equals("7") && !lenght.equals("8") && !lenght.equals("9") && !lenght.equals("10") &&
                                            !lenght.equals("11") && !lenght.equals("12") && !lenght.equals("13") && !lenght.equals("14") && !lenght.equals("15") &&
                                            !lenght.equals("20") && !lenght.equals("19") && !lenght.equals("18") && !lenght.equals("17") && !lenght.equals("16") && !lenght.equals("21")
                                    ) {
                                        System.out.println("please enter a number between 1 and 21");
                                    } else {
                                        if (Card.CheckName(CardsPlayer2[Integer.parseInt(num) - 1])) {
                                            if (Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer2).getDuration()) + Integer.parseInt(lenght) > 22) {
                                                System.out.println("you can not place this card in this location3 !");
                                            } else if (GameTowPlayer.CheckTheSelectCardplayer2(num, lenght, CardsPlayer2, MapGame)) {
                                                System.out.println("you can not place this card in this location4 !");
                                            } else {
                                                int x2 = Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer2).getDuration()) + Integer.parseInt(lenght) - 1;
                                                for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
                                                    MapGame[i][1] = GameTowPlayer.getCardWithName(num, CardsPlayer2).getName();
                                                    attack[i][1] = CardsAttackPlayer2[Integer.parseInt(num) - 1];
                                                    CardLocation[i][1] = CardLoca;
                                                }
                                                ++CardLoca;
                                                if (Integer.parseInt(num) != 3 && CardsPlayer2[5].equals("")) {
                                                    int q = GameTowPlayer.CharChargetScore(Card.returnCardbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getCharec(), Card.returnCardbyName(CardsPlayer2[2]).getCharec(), Integer.parseInt(Card.returnCardbyName(CardsPlayer2[2]).getDuration()));
                                                    CardsDamagePlayer2[2] += q;
                                                }
                                                //////////////////////////////////////
//                                         player damage
                                                for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
                                                    if (loginedUser1.getCharecter().equals(Card.returnCardbyName(MapGame[i][1]).getCharec())) {
                                                        if (MapGame[i][0] == "" || MapGame[i][0] == "#") {
                                                            MapGame[i][1] = CardsPlayer2[Integer.parseInt(num) - 1];
                                                            attack[i][1] = CardsAttackPlayer2[Integer.parseInt(num) - 1];
                                                            double e = CardsDamagePlayer2[Integer.parseInt(num) - 1] / Integer.parseInt(Card.returnCardbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getDuration());
                                                            Damageplayer[i][1] = (int) e + 1;
                                                            Player2Damage += Damageplayer[i][1];
                                                        } else {
                                                            MapGame[i][1] = CardsPlayer2[Integer.parseInt(num) - 1];
                                                            attack[i][1] = CardsAttackPlayer2[Integer.parseInt(num) - 1];
                                                            ////////////////Card
                                                            if (Card.CheckName(MapGame[i][0])) {
                                                                if (attack[i][0] > attack[i][1]) {
                                                                    attack[i][1] = 0;
                                                                } else if (attack[i][0] < attack[i][1]) {
                                                                    double e = CardsDamagePlayer2[Integer.parseInt(num) - 1] / Integer.parseInt(Card.returnCardbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getDuration());
                                                                    Damageplayer[i][1] = (int) e + 1;
                                                                    Player2Damage += Damageplayer[i][1];
                                                                    Player1Damage -= Damageplayer[i][0];
                                                                    attack[i][0] = 0;
                                                                } else if (attack[i][1] == attack[i][0]) {
                                                                    Player1Damage -= Damageplayer[i][0];
                                                                    attack[i][1] = 0;
                                                                    attack[i][0] = 0;
                                                                }
                                                                //////////Special Card
                                                                else {
                                                                    MapGame[i][1] = CardsPlayer1[Integer.parseInt(num) - 1];
                                                                    attack[i][1] = CardsAttackPlayer2[Integer.parseInt(num) - 1];
                                                                    if (MapGame[i][0].equals("shield")) {
                                                                        attack[i][1] = 0;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (MapGame[i][0] == "" || MapGame[i][0] == "#") {
                                                            MapGame[i][1] = CardsPlayer2[Integer.parseInt(num) - 1];
                                                            attack[i][1] = CardsAttackPlayer2[Integer.parseInt(num) - 1];
                                                            double e = CardsDamagePlayer2[Integer.parseInt(num) - 1] / Integer.parseInt(Card.returnCardbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getDuration());
                                                            Damageplayer[i][1] = (int) e;
                                                            Player2Damage += Damageplayer[i][1];
                                                        } else {
                                                            MapGame[i][1] = CardsPlayer2[Integer.parseInt(num) - 1];
                                                            attack[i][1] = CardsAttackPlayer2[Integer.parseInt(num) - 1];
                                                            //////////////card
                                                            if (Card.CheckName(MapGame[i][0])) {
                                                                if (attack[i][0] > attack[i][1]) {
                                                                    attack[i][1] = 0;
                                                                } else if (attack[i][0] < attack[i][1]) {
                                                                    double e = CardsDamagePlayer2[Integer.parseInt(num) - 1] / Integer.parseInt(Card.returnCardbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getDuration());
                                                                    Damageplayer[i][1] = (int) e;
                                                                    Player2Damage += Damageplayer[i][1];
                                                                    Player1Damage -= Damageplayer[i][0];
                                                                    attack[i][0] = 0;
                                                                }
                                                                if (attack[i][1] == attack[i][0]) {
                                                                    Player1Damage -= Damageplayer[i][0];
                                                                    attack[i][1] = 0;
                                                                    attack[i][0] = 0;
                                                                }
                                                            }
                                                            ///////////////////////special card
                                                            else {
                                                                MapGame[i][1] = CardsPlayer1[Integer.parseInt(num) - 1];
                                                                attack[i][1] = CardsAttackPlayer2[Integer.parseInt(num) - 1];
                                                                if (MapGame[i][0].equals("shield")) {
                                                                    attack[i][1] = 0;
                                                                }
                                                            }

                                                        }

                                                    }
                                                }
                                                ///////////////////////////////////////////////////////////
                                                Random random2 = new Random();
                                                String cardRand = "";
                                                int randomIndex3 = random2.nextInt(Namecard1.size());
                                                cardRand = Namecard1.get(randomIndex3);
                                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                if (Card.CheckName(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                }
                                                if (SpecialCard.Checkname(cardRand)) {
                                                    CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                    CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                }
                                                ////////////////////////////////////////////////
                                                --numRand2;
                                                play2 = false;
                                                play1 = true;
                                            }
                                        }
                                        ///////////////////////////////SpecialCard
                                        else if (SpecialCard.Checkname(CardsPlayer2[Integer.parseInt(num) - 1])) {
                                            if (GameTowPlayer.CheckTheSelectSpecialCard(lenght, MapGame)) {
                                                System.out.println("you can not place this special card in this location !");
                                            } else {
                                                if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("healing")) {
                                                    MapGame[Integer.parseInt(lenght) - 1][1] = "healing";
                                                    CardLocation[Integer.parseInt(lenght) - 1][1] = CardLoca;
                                                    ++CardLoca;
                                                    attack[Integer.parseInt(lenght) - 1][1] = 0;
                                                    Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
                                                    Random random5 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random5.nextInt(Namecard1.size());
                                                    cardRand = Namecard1.get(randomIndex3);
                                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    ////////////////////////////////////////////////
//                                                loginedUser1.setHP(loginedUser1.getHP() + 15);
                                                    HpPlayer2 += 15;
                                                    --numRand2;
                                                    play2 = false;
                                                    play1 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("repairman")) {
                                                    Random random6 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random6.nextInt(Namecard1.size());
                                                    cardRand = Namecard1.get(randomIndex3);
                                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    ////////////////////////////////////////////////
                                                    MapGame[randomNum1player2][1] = "";
                                                    --numRand2;
                                                    play2 = false;
                                                    play1 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("roundReducer")) {
                                                    Random random7 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random7.nextInt(Namecard1.size());
                                                    cardRand = Namecard1.get(randomIndex3);
                                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    /////////////////////////////////////////////////
                                                    --numRand2;
                                                    --numRand2;
                                                    --numRand1;
                                                    play2 = false;
                                                    play1 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("shield")) {
                                                    MapGame[Integer.parseInt(lenght) - 1][1] = "shield";
                                                    attack[Integer.parseInt(lenght) - 1][1] = 0;
                                                    Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
                                                    CardLocation[Integer.parseInt(lenght) - 1][1] = CardLoca;
                                                    ++CardLoca;
                                                    Random random9 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random9.nextInt(Namecard1.size());
                                                    cardRand = Namecard1.get(randomIndex3);
                                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand2;
                                                    play2 = false;
                                                    play1 = true;
                                                    ////////////////////////////////////////////////
                                                    if (MapGame[Integer.parseInt(lenght) - 1][0] == "" || MapGame[Integer.parseInt(lenght) - 1][0] == "#") {
                                                    } else if (MapGame[Integer.parseInt(lenght) - 1][0] != "") {
                                                        if (SpecialCard.Checkname(MapGame[Integer.parseInt(lenght) - 1][0])) {
                                                        } else if (Card.CheckName(MapGame[Integer.parseInt(lenght) - 1][0])) {
                                                            Player2Damage -= Damageplayer[Integer.parseInt(lenght) - 1][0];
                                                            attack[Integer.parseInt(lenght) - 1][0] = 0;
                                                        }
                                                    }

                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("HoleLocationModifier")) {
                                                    MapGame[Integer.parseInt(lenght) - 1][1] = "HoleLocationModifier";
                                                    attack[Integer.parseInt(lenght) - 1][1] = 0;
                                                    Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
                                                    CardLocation[Integer.parseInt(lenght) - 1][1] = CardLoca;
                                                    ++CardLoca;
                                                    MapGame[randomNumplayer1][0] = "";
                                                    MapGame[randomNum1player2][1] = "";
                                                    while (true) {
                                                        int randomplayer1 = (int) (Math.random() * 21);
                                                        if (MapGame[randomplayer1][1] == "") {
                                                            MapGame[randomplayer1][1] = "#";
                                                            randomNum1player2 = randomplayer1;
                                                            break;
                                                        }
                                                    }
                                                    while (true) {
                                                        int randomplayer2 = (int) (Math.random() * 21);
                                                        if (MapGame[randomplayer2][1] == "") {
                                                            MapGame[randomplayer2][1] = "#";
                                                            randomNumplayer1 = randomplayer2;
                                                            break;
                                                        }
                                                    }
                                                    Random random0 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random0.nextInt(Namecard.size());
                                                    cardRand = Namecard1.get(randomIndex3);
                                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand2;
                                                    play2 = false;
                                                    play1 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("CardWeakner")) {
                                                    ArrayList<Integer> rend = new ArrayList<>();
                                                    ArrayList<Integer> Weakner = new ArrayList<>();
                                                    for (int i = 0; i < 5; i++) {
                                                        if (Card.CheckName(CardsPlayer1[i])) {
                                                            Weakner.add(i);
                                                        }
                                                    }
                                                    if (Weakner.size() > 1) {
                                                        Random random21 = new Random();
                                                        while (rend.size() < 2) {
                                                            int randomIndex = random21.nextInt(Weakner.size());
                                                            rend.add(Weakner.get(randomIndex));
                                                        }
                                                        CardsAttackPlayer1[rend.get(0)] -= 3;
                                                        CardsDamagePlayer1[rend.get(1)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer1[rend.get(1)]).getDuration());
                                                    }
                                                    if (Weakner.size() == 1) {
                                                        Random random31 = new Random();
                                                        int randomIndex = random31.nextInt(2);
                                                        if (randomIndex == 0) {
                                                            CardsAttackPlayer1[Weakner.get(0)] -= 3;
                                                        }
                                                        if (randomIndex == 1) {
                                                            CardsDamagePlayer1[Weakner.get(0)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer1[rend.get(1)]).getDuration());
                                                        }
                                                    }
                                                    if (Weakner.size() == 0) {
                                                    }
                                                    Random random03 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex3 = random03.nextInt(Namecard1.size());
                                                    cardRand = Namecard1.get(randomIndex3);
                                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand2;
                                                    play2 = false;
                                                    play1 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("PowerBosster")) {
                                                    Random random03 = new Random();
                                                    int randomIndex3 = random03.nextInt(CardLoca);

                                                    for (int i = 0; i < 21; i++) {
                                                        if (CardLocation[i][0] == randomIndex3) {
                                                            Damageplayer[i][0] += 3;
                                                            Player2Damage += 3;
                                                        }
                                                    }
                                                    Random random04 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex4 = random04.nextInt(Namecard1.size());
                                                    cardRand = Namecard1.get(randomIndex4);
                                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand2;
                                                    play2 = false;
                                                    play1 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("Copycard")) {
                                                    String copy = "";
                                                    while (true) {
                                                        System.out.println("please enter the desired Card number for the copy !");
                                                        String NUM = input.nextLine();
                                                        if (!NUM.equals("1") && !NUM.equals("2") && !NUM.equals("3") && !NUM.equals("4") && !NUM.equals("5")) {
                                                            System.out.println("please enter a number between 1 and 5 !");
                                                        } else {
                                                            copy = NUM;
                                                            break;
                                                        }
                                                    }
                                                    CardsPlayer2[5] = CardsPlayer2[Integer.parseInt(copy) - 1];
                                                    CardsAttackPlayer2[5] = CardsAttackPlayer2[Integer.parseInt(copy) - 1];
                                                    CardsDamagePlayer2[5] = CardsDamagePlayer2[Integer.parseInt(copy) - 1];
                                                    CardsCopy6player2 = 1;

                                                    Random random04 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex4 = random04.nextInt(Namecard1.size());
                                                    cardRand = Namecard1.get(randomIndex4);
                                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand2;
                                                    play2 = false;
                                                    play1 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("RemoveCard")) {
                                                    if (CardsCopy6player2 == 1) {
                                                        System.out.println("you can not use this Card");
                                                        continue;
                                                    } else {
                                                        Random random2 = new Random();
                                                        int cin = random2.nextInt(5);
                                                        CardsPlayer2[5] = CardsPlayer1[cin];
                                                        CardsAttackPlayer2[5] = CardsAttackPlayer1[cin];
                                                        CardsDamagePlayer2[5] = CardsDamagePlayer1[cin];
                                                        CardsCopy6player2 = 1;
                                                        CardsPlayer1[cin] = "";
                                                        CardsAttackPlayer1[cin] = 0;
                                                        CardsDamagePlayer1[cin] = 0;
                                                    }
                                                    /////////////////////////
                                                    Random random05 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex4 = random05.nextInt(Namecard1.size());
                                                    cardRand = Namecard1.get(randomIndex4);
                                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand2;
                                                    play2 = false;
                                                    play1 = true;
                                                } else if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("HiddenCard")) {
                                                    HiddenCardPlayer1 = 1;
                                                    String a = CardsPlayer1[0];
                                                    String b = CardsPlayer1[1];
                                                    String c = CardsPlayer1[2];
                                                    String d = CardsPlayer1[3];
                                                    String e = CardsPlayer1[4];
                                                    CardsPlayer1[0] = d;
                                                    CardsPlayer1[1] = c;
                                                    CardsPlayer1[2] = b;
                                                    CardsPlayer1[3] = e;
                                                    CardsPlayer1[4] = a;
                                                    timeHiddenplayer1 = numRand1;
                                                    Random random05 = new Random();
                                                    String cardRand = "";
                                                    int randomIndex4 = random05.nextInt(Namecard1.size());
                                                    cardRand = Namecard1.get(randomIndex4);
                                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
                                                    if (Card.CheckName(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
                                                    }
                                                    if (SpecialCard.Checkname(cardRand)) {
                                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
                                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
                                                    }
                                                    --numRand2;
                                                    play2 = false;
                                                    play1 = true;
                                                }
                                            }
                                        }
                                    }

                                }
                                for (int i = 0; i <= CardLoca; i++) {
                                    int w = 0;
                                    int z = 0;
                                    for (int j = 0; j < 21; j++) {
                                        if (attack[j][0] == 0 && Damageplayer[j][0] != 0 && CardLocation[j][0] == i && !cardShecanPlayer1.contains(i)) {
                                            ++w;
                                        }
                                        if (CardLocation[j][0] == i) {
                                            ++z;
                                        }
                                    }
                                    if (w == z) {
                                        Random random2 = new Random();
                                        int r = random2.nextInt(4);
                                        if (r != 3) {
                                            System.out.println(" player2 :you won 5 coins for defeating your opponent's Card");
                                            loginedUser1.setCoin(loginedUser1.getCoin() + 5);
                                            cardShecanPlayer1.add(i);
                                        }
                                        if (r == 3) {
                                            System.out.println("player 2 :you won 3 XP for defeating your opponent's Card");
                                            loginedUser1.setXP(loginedUser1.getXP() + 3);
                                            cardShecanPlayer1.add(i);
                                        }
                                    }
                                }
                                for (int i = 0; i <= CardLoca; i++) {
                                    int w = 0;
                                    int z = 0;
                                    for (int j = 0; j < 21; j++) {
                                        if (attack[j][1] == 0 && Damageplayer[j][1] != 0 && CardLocation[j][1] == i && !cardShecanPlayer2.contains(i)) {
                                            ++w;
                                        }
                                        if (CardLocation[j][1] == i) {
                                            ++z;
                                        }
                                    }
                                    if (w == z) {
                                        Random random2 = new Random();
                                        int r = random2.nextInt(4);
                                        if (r != 3) {
                                            System.out.println("player 1 : you won 5 coins for defeating your opponent's Card");
                                            loginedUser.setCoin(loginedUser.getCoin() + 5);
                                            cardShecanPlayer2.add(i);
                                        }
                                        if (r == 3) {
                                            System.out.println("player 1 : you won 3 XP for defeating your opponent's Card");
                                            loginedUser.setXP(loginedUser.getXP() + 3);
                                            cardShecanPlayer2.add(i);
                                        }
                                    }
                                }
                                System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "rand 1", "rand 2");
                                System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", numRand1, numRand2);
                                System.out.println();
                                System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", "1-", "2-");
                                System.out.println();
                                for (int i = 0; i < 21; i++) {
                                    String CardPlayer1 = "";
                                    String CardPlayer2 = "";
                                    String CardFeaturePlayer1 = "";
                                    String CardFeaturePlayer2 = "";
                                    String tab = "";
                                    if (i >= 0 && i <= 8) {
                                        tab = "    ";
                                    }
                                    if (i > 8) {
                                        tab = "     ";
                                    }
                                    String HP1 = "";
                                    String HP2 = "";
                                    String Nameplayer1 = "";
                                    String Nameplayer2 = "";
                                    if (i == 8) {
                                        CardPlayer1 = "1- " + CardsPlayer1[0];
                                        CardPlayer2 = "1- " + CardsPlayer2[0];
                                        CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[0], CardsAttackPlayer1[0], CardsDamagePlayer1[0]);
                                        CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[0], CardsAttackPlayer2[0], CardsDamagePlayer2[0]);
                                    }
                                    if (i == 9) {
                                        CardPlayer1 = "2- " + CardsPlayer1[1];
                                        CardPlayer2 = "2- " + CardsPlayer2[1];
                                        CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[1], CardsAttackPlayer1[1], CardsDamagePlayer1[1]);
                                        CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[1], CardsAttackPlayer2[1], CardsDamagePlayer2[1]);
                                    }
                                    if (i == 10) {
                                        CardPlayer1 = "3- " + CardsPlayer1[2];
                                        CardPlayer2 = "3- " + CardsPlayer2[2];
                                        CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[2], CardsAttackPlayer1[2], CardsDamagePlayer1[2]);
                                        CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[2], CardsAttackPlayer2[2], CardsDamagePlayer2[2]);
                                        Nameplayer1 = "gamer 1 :" + loginedUser.getCharecter();
                                        Nameplayer2 = "gamer 2 :" + loginedUser1.getCharecter();
                                        HP1 = "Hp player1 :" + HpPlayer1;
                                        HP2 = "Hp player2 :" + HpPlayer2;
                                    }
                                    if (i == 11) {
                                        CardPlayer1 = "4- " + CardsPlayer1[3];
                                        CardPlayer2 = "4- " + CardsPlayer2[3];
                                        CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[3], CardsAttackPlayer1[3], CardsDamagePlayer1[3]);
                                        CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[3], CardsAttackPlayer2[3], CardsDamagePlayer2[3]);
                                    }
                                    if (i == 12) {
                                        CardPlayer1 = "5- " + CardsPlayer1[4];
                                        CardPlayer2 = "5- " + CardsPlayer2[4];
                                        CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[4], CardsAttackPlayer1[4], CardsDamagePlayer1[4]);
                                        CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[4], CardsAttackPlayer2[4], CardsDamagePlayer2[4]);
                                    }
                                    if (i == 13 && CardsCopy6player1 == 1) {
                                        CardPlayer1 = "6- " + CardsPlayer1[5];
                                        CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[5], CardsAttackPlayer1[5], CardsDamagePlayer1[5]);
                                    }
                                    if (i == 13 && CardsCopy6player2 == 1) {
                                        CardPlayer2 = "6- " + CardsPlayer2[5];
                                        CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[5], CardsAttackPlayer2[5], CardsDamagePlayer2[5]);
                                    }
                                    if (HiddenCardPlayer1 == 1) {
                                        String[] space = CardPlayer1.split(" ");
                                        CardPlayer1 = space[0];
                                        CardFeaturePlayer1 = "";
                                    }
                                    if (HiddenCardPlayer2 == 1) {
                                        String[] space = CardPlayer2.split(" ");
                                        CardPlayer2 = space[0];
                                        CardFeaturePlayer2 = "";
                                    }

                                    System.out.printf("%-20s %-25s %-25s %-25s %-25s %-25s%n", Nameplayer1, CardPlayer1, (i + 1) + "-  " + MapGame[i][0], MapGame[i][1], CardPlayer2, Nameplayer2);
                                    Nameplayer1 = "";
                                    Nameplayer2 = "";
                                    CardPlayer1 = "";
                                    CardPlayer2 = "";
                                    System.out.printf("%-20s %-25s %-25s %-25s %-25s %-25s", HP1, "   " + CardFeaturePlayer1, tab + GameTowPlayer.getCardFeauture1(MapGame[i][0], attack[i][0], Damageplayer[i][0]),
                                            GameTowPlayer.getCardFeauture1(MapGame[i][1], attack[i][1], Damageplayer[i][1]), "   " + CardFeaturePlayer2, HP2);
                                    System.out.println();
                                    System.out.println();
                                }
                                System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "player damage 1", "player damage 2");
                                System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", Player1Damage, Player2Damage);
                                System.out.println();
                            }
                        }
                        ///////////////////////////////////time line\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
                        for (int i = 0; i < 21; i++) {
                            if (HpPlayer2 <= 0) {
//                            System.out.println("Player 1 wins the game");
                                break;
                            }
                            if (HpPlayer1 <= 0) {
//                            System.out.println("Player 2 wins the game");
                                break;
                            }
                            if (attack[i][0] != 0) {
                                HpPlayer2 -= Damageplayer[i][0];
                                System.out.println("Hp player 2 decrease " + Damageplayer[i][0]);
                                if (HpPlayer2 >= 0) {
                                    System.out.println("Hp player 2: " + HpPlayer2);
                                }
                                if (HpPlayer2 < 0) {
                                    System.out.println("Hp player 2: " + 0);
                                }
                            }
                            if (attack[i][1] != 0) {
                                HpPlayer1 -= Damageplayer[i][1];
                                System.out.println("Hp player 1 decrease " + Damageplayer[i][1]);
                                if (HpPlayer1 >= 0) {
                                    System.out.println("Hp player 1: " + HpPlayer1);
                                }
                                if (HpPlayer1 < 0) {
                                    System.out.println("Hp player 1: " + 0);
                                }
                            }
                        }

                        if (HpPlayer2 <= 0) {
                            System.out.println("Player 1 wins the betting game and you have earned 200 coins");
                            int coinWin = (int) Math.min(Math.max((loginedUser.getCoin()) / (Player2Damage + 1), 40), 200);
                            loginedUser.setCoin(coinWin + loginedUser.getCoin()+200);
                            int XP = (int) (loginedUser.getXP() + Math.min(5, Math.sqrt(4 * loginedUser.getCoin())));
                            System.out.println(" your XP :" + XP);
                            if (XP >= loginedUser.getXPlevelup()) {
                                System.out.println("you can level up to " + (loginedUser.getLevel() + 1));
                                System.out.println("Congratulation for level up !");
                                System.out.println("You get 10 coins as a reward for leveling up !");
                                loginedUser.setCoin(10 + loginedUser.getCoin());
                                loginedUser.setLevel(loginedUser.getLevel() + 1);
                                XP -= loginedUser.getXPlevelup();
                            }
                            loginedUser.setXP(XP);
                            loginedUser.setXPlevelup(loginedUser.getXPlevelup() * 2);
                            //////////////////////////////////////////////////
                            int XPlose = (int) Math.min(15, Math.max(5, Math.sqrt(Player2Damage)));
                            System.out.println("Player 2 you are increase Xp :" + XPlose);
                            if (XPlose >= loginedUser1.getXPlevelup()) {
                                System.out.println("you can level up to " + (loginedUser1.getLevel() + 1));
                                System.out.println("Congratulation for level up !");
                                System.out.println("You get 10 coins as a reward for leveling up !");
                                loginedUser1.setCoin(10 + loginedUser1.getCoin());
                                loginedUser1.setLevel(loginedUser1.getLevel() + 1);
                                XPlose -= loginedUser1.getXPlevelup();
                            }
                            loginedUser1.setXP(XPlose);
                            loginedUser1.setXPlevelup(loginedUser1.getXPlevelup() * 2);
                            ////////////////////////Historygame\\\\\\\\\\\\\\\\\\\\\\
                            LocalDateTime timegame = LocalDateTime.now();
                            LocalDateTime truncatedDateTime = timegame.withSecond(0).withNano(0);
                            HistoryGame historyGameplayer1 = new HistoryGame(loginedUser.getNickname(), truncatedDateTime, "Coin :" + Integer.toString(coinWin) + ",Xp: " + Integer.toString(XP), "Win", Integer.toString(loginedUser1.getLevel()));
                            HistoryGame historyGameplayer2 = new HistoryGame(loginedUser1.getNickname(), truncatedDateTime, "Xp :" + Integer.toString(XPlose), "Lose", Integer.toString(loginedUser.getLevel()));
                            loginedUser.getHistoryGame().add(historyGameplayer1);
                            loginedUser1.getHistoryGame().add(historyGameplayer2);
                            /////////////////////////////////////////////////////
                            System.out.println("log out player 2");
                            currentMenu[0] = menu.Main_Menu;
                            System.out.println("you are enter Main Menu");
                            break;
                        }
                        ////////////////////////////////////////
                        if (HpPlayer1 <= 0) {
                            System.out.println("Player 2 wins the betting game and you have earned 200 coins");
                            int coinWin = (int) Math.min(Math.max((loginedUser1.getCoin()) / (Player1Damage + 1), 40), 200);
                            loginedUser1.setCoin(coinWin + loginedUser1.getCoin()+200);
                            int XP = (int) (loginedUser1.getXP() + Math.min(5, Math.sqrt(4 * loginedUser1.getCoin())));
                            System.out.println(" your XP :" + XP);
                            if (XP >= loginedUser1.getXPlevelup()) {
                                System.out.println("you can level up to " + (loginedUser1.getLevel() + 1));
                                System.out.println("Congratulation for level up !");
                                System.out.println("You get 10 coins as a reward for leveling up !");
                                loginedUser1.setCoin(10 + loginedUser1.getCoin());
                                loginedUser1.setLevel(loginedUser1.getLevel() + 1);
                                XP -= loginedUser1.getXPlevelup();
                            }
                            loginedUser1.setXP(XP);
                            loginedUser1.setXPlevelup(loginedUser1.getXPlevelup() * 2);
                            //////////////////////////////////////////////////
                            int XPlose = (int) Math.min(15, Math.max(5, Math.sqrt(Player1Damage)));
                            System.out.println("Player 1 you are increase Xp :" + XPlose);
                            if (XPlose >= loginedUser.getXPlevelup()) {
                                System.out.println("you can level up to " + (loginedUser.getLevel() + 1));
                                System.out.println("Congratulation for level up !");
                                System.out.println("You get 10 coins as a reward for leveling up !");
                                loginedUser.setCoin(10 + loginedUser.getCoin());
                                loginedUser.setLevel(loginedUser.getLevel() + 1);
                                XPlose -= loginedUser.getXPlevelup();
                            }
                            loginedUser.setXP(XPlose);
                            loginedUser.setXPlevelup(loginedUser.getXPlevelup() * 2);
                            ///////////////////////////////////////////history
                            LocalDateTime timegame = LocalDateTime.now();
                            LocalDateTime truncatedDateTime = timegame.withSecond(0).withNano(0);
                            HistoryGame historyGameplayer2 = new HistoryGame(loginedUser1.getNickname(), truncatedDateTime, "Coin :" + Integer.toString(coinWin) + ",Xp: " + Integer.toString(XP), "Win", Integer.toString(loginedUser1.getLevel()));
                            HistoryGame historyGameplayer1 = new HistoryGame(loginedUser.getNickname(), truncatedDateTime, "Xp :" + Integer.toString(XPlose), "Lose", Integer.toString(loginedUser.getLevel()));
                            loginedUser.getHistoryGame().add(historyGameplayer1);
                            loginedUser1.getHistoryGame().add(historyGameplayer2);

                            ////////////////////////////////////
                            System.out.println("log out player 2");
                            currentMenu[0] = menu.Main_Menu;
                            System.out.println("you are enter Main Menu");
                            break;
                        }
                        ///////////////////////////////////////////////////////////////////////////
                    }
                }
            }

/////////////////////////////////////ViewCards\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
            if (currentMenu[0] == menu.ViewCards_Menu) {
                View();
            }
////////////////////////////////////////////////////HistoryGames\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
            if (currentMenu[0] == menu.HistoryGames_Menu) {
                HistoryGame(input,currentMenu);
            }
///////////////////////////////////////////////////StoreMenu\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
            if (currentMenu[0] == menu.Stor_Menu) {
                while (true){
                    ArrayList<Card>cardstore=new ArrayList<>();
                ArrayList<SpecialCard>specialcardstore=new ArrayList<>();
                System.out.println("Do you want to buy a card or upgrade the card ?");
                String ans=input.nextLine();
                    if (ans.equals("Back the Menu Main")) {
                        currentMenu[0]=menu.Main_Menu;
                        System.out.println("you are in Menu Main");
                        break;
                    }
                    if (ans.equals("buy")) {
                        int x=1;
                        int y=1;
                    for (int i = 0; i < cards.size(); i++) {
                        boolean exist=true;
                        for (int j = 0; j < loginedUser.CardsPlayer.size(); j++) {
                            if (checkTasavycard(cards.get(i),loginedUser.CardsPlayer.get(j))) {
                                exist=false;
                            }
                        }
                        if (exist==true) {
                            cardstore.add(Main.cards.get(i));
                            System.out.println("Card "+x+" :");
                            System.out.println("Name : " + Main.cards.get(i).getName());
                            System.out.println("Attack : " + Main.cards.get(i).getCardAttack());
                            System.out.println("Duration : " + Main.cards.get(i).getDuration());
                            System.out.println("Damage : " +Main.cards.get(i).getPlayerDamage());
                            System.out.println("Upgrade Level : " + Main.cards.get(i).getUpgradeLevel());
                            System.out.println("Upgrade Cost : " + Main.cards.get(i).getUpgradeCost());
                            System.out.println("Price : " + Main.cards.get(i).getPrice());
                            System.out.println();
                            ++x;
                        }
                    }
                    for (int i = 0; i < specialCards.size(); i++) {
                        boolean exist1 = true;
                        for (int j = 0; j < loginedUser.specialCardsPlayer.size(); j++) {
                            if (checkTasavySpecialCard(specialCards.get(i), loginedUser.specialCardsPlayer.get(j))) {
                                exist1 = false;
                            }
                        }
                        if (exist1 == true) {
                            specialcardstore.add(specialCards.get(i));
                            System.out.println("Special Card " + y + " :");
                            System.out.println("Name : " + specialCards.get(i).getNameCard());
                            System.out.println("Price : " + specialCards.get(i).getPrice());
                            System.out.println();
                            ++y;
                        }
                    }
                        while (true) {
                            System.out.println("Which card or special card do you want ?");
                            String numb = input.nextLine();
                            if (numb.equals("back of the Menu Store")) {
                                System.out.println("you are in Store Menu !");
                                break;
                            }
                           else  if (!Card.CheckName(numb) && !SpecialCard.Checkname(numb)) {
                                System.out.println("No exist this Name Card !");
                            }
                            else if (!checkcard(cardstore, numb) && !checkspecialcard(specialcardstore, numb)) {
                                System.out.println("you have this Card or Special Card");
                            } else {
                                if (checkcard(cardstore, numb)) {
                                    if (Integer.parseInt(returncard(cardstore, numb).getPrice()) > loginedUser.getCoin()) {
                                        System.out.println("you don't have enough coins !");
                                    } else {
                                        System.out.println("you bought this card");
                                        double remainderCoin = loginedUser.getCoin() - Double.parseDouble(returncard(cardstore, numb).getPrice());
                                        loginedUser.setCoin(remainderCoin);
                                        Card card = returncard(cardstore, numb);
                                        loginedUser.CardsPlayer.add(new Card(card.getName(), card.getCardAttack(), card.getDuration(), card.getPlayerDamage(), card.getUpgradeLevel(), card.getUpgradeCost(), card.getPrice(),card.getCharec()));
                                        cardstore.remove(returncard(cardstore, numb));
                                    }
                                }
                                if (checkspecialcard(specialcardstore, numb)) {
                                    if (Integer.parseInt(returnspecialcard(specialcardstore, numb).getPrice()) > loginedUser.getCoin()) {
                                        System.out.println("you don't have enough coins !");
                                    } else {
                                        System.out.println("you bought this special card");
                                        double remainderCoin = loginedUser.getCoin() - Double.parseDouble(returnspecialcard(specialcardstore, numb).getPrice());
                                        loginedUser.setCoin(remainderCoin);
                                        SpecialCard card = returnspecialcard(specialcardstore, numb);
                                        loginedUser.specialCardsPlayer.add(new SpecialCard(card.getNameCard(), card.getPrice()));
                                        specialcardstore.remove(returnspecialcard(specialcardstore, numb));
                                    }
                                }
                            }
                        }
                    }
                    if (ans.equals("upgrade")) {
                        int r=1;
                        for (int i = 0; i < loginedUser.CardsPlayer.size(); i++) {
                            System.out.println("Card " + r + " after upgrade :");
                            System.out.println("Name : " + loginedUser.CardsPlayer.get(i).getName());
                            System.out.println("attack\\defence : " + loginedUser.CardsPlayer.get(i).getCardAttack());
                            System.out.println("duration : " + loginedUser.CardsPlayer.get(i).getDuration());
                            System.out.println("player damage : " + Integer.parseInt(loginedUser.CardsPlayer.get(i).getPlayerDamage()) + 5);
                            System.out.println("Upgrade Level : "+loginedUser.CardsPlayer.get(i).getUpgradeLevel());
                            System.out.println("Upgrade Cost : "+Double.parseDouble(loginedUser.CardsPlayer.get(i).getUpgradeCost())*1.25);
                            System.out.println();
                        }
                        while (true) {
                            System.out.println("Which card do you want to upgrade ?");
                            String numb = input.nextLine();
                            if (numb.equals("back of the Menu Store")) {
                                System.out.println("you are in Store Menu !");
                                break;
                            }
                            if (!Card.CheckName(numb)) {
                                System.out.println("No exist this Name Card !");
                            }
                            else if (!checkcard(loginedUser.CardsPlayer, numb)) {
                                System.out.println("you do'nt have this Card");
                            }
                            else {
                                if (Double.parseDouble(returncard(loginedUser.CardsPlayer,numb).getUpgradeLevel())>loginedUser.getLevel()) {
                                    System.out.println("your level is too low to upgrade your card !");
                                }
                               else if (Double.parseDouble(returncard(loginedUser.CardsPlayer,numb).getUpgradeCost())>loginedUser.getCoin()) {
                                    System.out.println("your coins are too low to upgrade your card !");
                                }
                               else {
                                   int x=Integer.parseInt(returncard(loginedUser.CardsPlayer,numb).getPlayerDamage()) + 5;
                                   double z=loginedUser.getCoin()-Double.parseDouble(returncard(loginedUser.CardsPlayer,numb).getUpgradeCost());
                                   loginedUser.setCoin(z);
                                    returncard(loginedUser.CardsPlayer,numb).setPlayerDamage(Integer.toString(x));
                                    double y=Double.parseDouble(returncard(loginedUser.CardsPlayer,numb).getUpgradeCost())*1.25;
                                    returncard(loginedUser.CardsPlayer,numb).setUpgradeCost(Double.toString(y));
                                    System.out.println(returncard(loginedUser.CardsPlayer,numb).getName()+" was upgraded");
                                }
                            }
                        }
                    }
                }
            }
//////////////////////////////////////////////////////Admin\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
            if (true) {
                if (LoginAdminMatcher.matches()) {
                    String pass = LoginAdminMatcher.group("AdminPass");
                    if (!pass.equals(PassWordAdmin)) {
                        System.out.println("Wrong PassWord");
                    }
                    if (pass.equals(PassWordAdmin)) {
                        System.out.println("Welcome Admin");
                        currentMenu1[0]=currentMenu[0];
                        currentMenu[0] = menu.Admin_Menu;
                    }
                }
                if (currentMenu[0] == menu.Admin_Menu) {
                    if (AddCard1.matches()) {
                        currentMenu[0] = menu.AddCard_Menu;
                    }
                    if (EditingCardMatcher.matches()) {
                        currentMenu[0] = menu.EdittingCard_Menu;
                    }
                    if (DeleteCardMatcher.matches()) {
                        currentMenu[0] = menu.DeleteCard_Menu;
                    }
                    if (ViewPlayerMatcher.matches()) {
                        currentMenu[0] = menu.ViewPlayers_Menu;
                    }
                }
//
                if (currentMenu[0] == menu.AddCard_Menu) {
                    add = true;
                    System.out.println("Please Add The desired Card :");
                    while (add) {
                        AddCard(input);
                    }
                    if (!add) {
                        currentMenu[0] = menu.Admin_Menu;
                    }
                }
                if (currentMenu[0] == menu.EdittingCard_Menu) {
                    Checknumber(input);
                    if (!edit) {
                        currentMenu[0] = menu.Admin_Menu;
                    }
                }
                if (currentMenu[0] == menu.DeleteCard_Menu) {
                    Checkdelete(input);
                    currentMenu[0] = menu.Admin_Menu;
                }
                if (currentMenu[0] == menu.ViewPlayers_Menu) {
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println("Name :" + users.get(i).username + " Level :" + users.get(i).level + " Coin :" + users.get(i).coin);
                    }
                }
                if (logoutadminMatcher.matches()) {
                    currentMenu[0] =currentMenu1[0];
                    System.out.println("log out successfully");
                    System.out.println("enter "+currentMenu[0]);
                }
            }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
    }
    public static Matcher setMatcher(String entry, String Regex) {
        Pattern pattern = Pattern.compile(Regex);
        return pattern.matcher(entry);
    }
    public static void SignupUser(Matcher SignupMatcher, Scanner input, ArrayList<User> users, menu[] currentMenu) {
        String username = SignupMatcher.group(1);
        String password = SignupMatcher.group(2);
        String passConfirm = SignupMatcher.group(3);
        String email = SignupMatcher.group(4);
        String nickname = SignupMatcher.group(5);

        String checkUsername = "^[a-zA-Z0-9_]+$";
        String checkPass1 = "^.{8,}$";
        String checkPass2 = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d\\s])[^\\s]*$";
        String checkEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern usernamePattern = Pattern.compile(checkUsername);
        Pattern passPattern = Pattern.compile(checkPass1);
        Pattern passPattern2 = Pattern.compile(checkPass2);
        Pattern emailPattern = Pattern.compile(checkEmail);
        Matcher usernameChecker = usernamePattern.matcher(username);
        Matcher passMatcher = passPattern.matcher(password);
        Matcher passMatcher2 = passPattern2.matcher(password);
        Matcher emailMatcher = emailPattern.matcher(email);
        if (username.isEmpty()) System.out.println("Please enter username!");
        else if (password.isEmpty()) System.out.println("Please enter password!");
        else if (!password.equals("random") && passConfirm.isEmpty())
            System.out.println("Please confirm your password!");
        else if (email.isEmpty()) System.out.println("Please enter email!");
        else if (nickname.isEmpty()) System.out.println("Please set a nickname for account");
        else if (!usernameChecker.matches())
            System.out.println("Username can only contain uppercase and lowercase letters, numbers and underscores");
        else if (exist(users, a -> a.username.equals(username)))
            System.out.println("The user with this username has already registered!");
        else if (!password.equals("random") && !passMatcher.matches())
            System.out.println("The password must have at least 8 characters");
        else if (!password.equals("random") && !passMatcher2.matches())
            System.out.print("The password must have at least:\n" +
                    "- A small letter\n" +
                    "- A capital letter\n" +
                    "- A number\n" +
                    "- One character except numbers and letters\n");
        else if (!password.equals("random") && !password.equals(passConfirm))
            System.out.println("Please check your password again!");
        else if (!emailMatcher.matches()) System.out.println("The entered email format should be <email>@<domain>.com");
        else {
            User newuser = new User(username, nickname, email);
            NumberEntered=true;

            currentMenu[0] = menu.Signup_Menu;
            for (int i = 0; i < 3; i++) {
                newuser.securityQuestion[i] = "";
            }

            if (password.equals("random")) {

                String randomPass = RandomPasswordGenerator.generatePassword(8);
                System.out.println("Your random password: " + randomPass);

                boolean run = true;
                while (run) {
                    System.out.print("Please enter your password: ");
                    String randomPassConfirm = input.next();
                    if (randomPassConfirm.equals(randomPass)) run = false;
                }
                newuser.password = randomPass;

            } else {
                newuser.password = password;
            }

            System.out.print("User created successfully. Please choose a security question : \n" +
                    "• 1-What is your father’s name ?\n" +
                    "• 2-What is your favourite color ?\n" +
                    "• 3-What was the name of your first pet?\n");
            while (newuser.securityQuestion[0].isEmpty() || newuser.securityQuestion[1].isEmpty() || newuser.securityQuestion[2].isEmpty()) {
                String answer = input.nextLine();
                String answerRegex = "^\\s*question\\s+pick\\s+-q\\s+(.*)\\s+-a\\s+(.*)\\s+-c\\s+(.*)\\s*$";
                Pattern answerPattern = Pattern.compile(answerRegex);
                Matcher answerMatcher = answerPattern.matcher(answer);

                if (answerMatcher.matches()) {
                    int questionNum = Integer.parseInt(answerMatcher.group(1));
                    String Answer = answerMatcher.group(2);
                    String confirmAnswer = answerMatcher.group(3);
                    if (questionNum > 3 || questionNum < 1) System.out.println("Invalid question number");
                    else if (!Answer.equals(confirmAnswer)) System.out.println("Please check your answer again!");
                    else {
                        System.out.println("Your answer saved successfully!");
                        newuser.securityQuestion[questionNum - 1] = Answer;
                    }
                }
            }

            Random random = new Random();

            boolean createCaptcha = true;
            while (createCaptcha) {
                int length = 5 + random.nextInt(3); // تولید عددی بین 5 و 7
                StringBuilder captchaNumber = new StringBuilder(length);

                for (int i = 0; i < length; i++) {
                    int digit = random.nextInt(10); // تولید یک رقم بین 0 و 9
                    captchaNumber.append(digit);
                }
                int captchaInteger = Integer.parseInt(captchaNumber.toString());
                printCaptcha(captchaNumber.toString());

                System.out.println("Enter number of captcha: ");
                int captcha = input.nextInt();

                if (captcha == captchaInteger) {
                    createCaptcha = false;
                    users.add(newuser);
                    System.out.println("Your account successfully created! Now you can login...");
                    currentMenu[0] = menu.Start_Menu;
                }
            }


        }
    }
    public static void ShowUserInfo(User thisUser) {
        System.out.format("Username: %s\n" +
                "Account password: %s\n" +
                "Nickname: %s\n" +
                "Email: %s\n" +
                "Father's name: %s\n" +
                "Favorite color: %s\n" +
                "Name of your first pet: %s\n" +
                "Gaming Info -> level: %d, HP: %d, XP: %d, coin: %d\n", thisUser.username, thisUser.password, thisUser.nickname, thisUser.email, thisUser.securityQuestion[0], thisUser.securityQuestion[1], thisUser.securityQuestion[2], thisUser.level, thisUser.HP, thisUser.XP, thisUser.coin);
    }
    public static void ChangeUsername(User thisUser, ArrayList<User> users, String newUsername) {
        String checkUsername = "^[a-zA-Z0-9_]+$";
        Matcher userMatcher = setMatcher(newUsername, checkUsername);
        if (!userMatcher.matches())
            System.out.println("Username can only contain uppercase and lowercase letters, numbers and underscores");
        else if (exist(users, a -> a.username.equals(newUsername))) System.out.println("This username already in use!");
        else {
            System.out.format("You have changed your username -> Old: %s, New: %s\n", thisUser.username, newUsername);
            thisUser.username = newUsername;
        }
    }
    public static void ChangeNickname(User thisUser, String newNickname) {
        System.out.format("You have changed your nickname -> Old: %s, New: %s\n", thisUser.nickname, newNickname);
        thisUser.nickname = newNickname;
    }
    public static void ChangePass(User thisUser, String oldPass, String newPass, Scanner input) {
        boolean getPass = true;
        while (getPass) {

            String checkPass1 = "^.{8,}$";
            String checkPass2 = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d\\s])[^\\s]*$";
            Matcher passMatcher = setMatcher(newPass, checkPass1);
            Matcher passMatcher2 = setMatcher(newPass, checkPass2);
            if (!passMatcher.matches())
                System.out.println("The password must have at least 8 characters");
            else if (!passMatcher2.matches()) System.out.print("The password must have at least:\n" +
                    "- A small letter\n" +
                    "- A capital letter\n" +
                    "- A number\n" +
                    "- One character except numbers and letters\n");
            else if (oldPass.equals(newPass)) System.out.println("Please enter a new password!");
            else {
                getPass = false;

                Random random = new Random();

                boolean createCaptcha = true;
                while (createCaptcha) {
                    int length = 5 + random.nextInt(3); // تولید عددی بین 5 و 7
                    StringBuilder captchaNumber = new StringBuilder(length);

                    for (int i = 0; i < length; i++) {
                        int digit = random.nextInt(10); // تولید یک رقم بین 0 و 9
                        captchaNumber.append(digit);
                    }
                    int captchaInteger = Integer.parseInt(captchaNumber.toString());
                    printCaptcha(captchaNumber.toString());

                    System.out.println("Enter number of captcha: ");
                    int captcha = Integer.parseInt(input.nextLine());

                    if (captchaInteger == captcha) {
                        createCaptcha = false;
                        System.out.println("Please enter your new password again:");
                    }

                }

                boolean bln = true;
                while (bln) {
                    String passConfirm = input.nextLine();
                    if (passConfirm.equals(newPass)) {
                        bln = false;
                        thisUser.password = newPass;
                        System.out.println("Your password changed successfully!");
                    } else {
                        System.out.println("Wrong pass confirmation! repeat again:");
                    }
                }
                ///
                //            System.out.println("Please enter your new password again");
            }
        }
    }
    public static void ChangeEmail(User thisUser, String email) {
        String checkEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Matcher emailMatcher = setMatcher(email, checkEmail);
        if (emailMatcher.matches()) {
            System.out.println("Your Email changed successfully!");
            thisUser.email = email;
        } else {
            System.out.println("Wrong email format!");
        }
    }
    public static <T> boolean exist(ArrayList<T> list, Predicate<T> predicate) {
        boolean bln = false;
        for (T item : list) {
            if (predicate.test(item)) bln = true;
        }
        return bln;
    }
    public static <T> T find(ArrayList<T> list, Predicate<T> predicate) {
        int index = 0;
        for (T item : list) {
            if (predicate.test(item)) break;
            index++;
        }
        return list.get(index);
    }
    private static void printCaptcha(String captcha) {
        // نمایش CAPTCHA در 5 خط
        for (int row = 0; row < 8; row++) {
            for (char digit : captcha.toCharArray()) {
                System.out.print(DIGITS_ART[Character.getNumericValue(digit)][row] + "  ");
            }
            System.out.println();
        }
    }
    public static void AddCard(Scanner input) {
        boolean a = true;
        while (a) {
            String Add = "Add Card (?<Name>.+),(?<Deffence>.+),(?<Duration>.+),(?<Damage>.+),(?<Upgradelevel>.+),(?<Upgradecost>.+),(?<character>.+)";
            String entry = input.nextLine();
            if (entry.equals("Back of Add Card")) {
                System.out.println("you are in Menu Admin");
                add = false;
                break;
            }
            Matcher AddCardMatcher = setMatcher(entry.trim(), Add);
            if (AddCardMatcher.matches()) {
//                System.out.println("123432");
                String Name = AddCardMatcher.group("Name");
                String Deffence = AddCardMatcher.group("Deffence");
                String Duration = AddCardMatcher.group("Duration");
                String Damage = AddCardMatcher.group("Damage");
                String UpgradeLevel = AddCardMatcher.group("Upgradelevel");
                String UpgradeCost = AddCardMatcher.group("Upgradecost");
                String charectar=AddCardMatcher.group("character");
                if (Card.CheckName(Name.trim())) {
                    System.out.println("The name of the card is duplicated");
                } else if (Integer.parseInt(Deffence) < 10 || Integer.parseInt(Deffence) > 100) {
                    System.out.println(Name);
                    System.out.println(Deffence);
                    System.out.println("Enter a number between 10 and 100 for deffence\\attack");
                } else if (Integer.parseInt(Duration) < 0 || Integer.parseInt(Duration) > 5) {
                    System.out.println("Enter a number between 1 and 5 for Duration");
                } else if (Integer.parseInt(Damage) < 10 || Integer.parseInt(Damage) > 50) {
                    System.out.println("Enter a number between 10 and 50 for Damage");
                }
                else if (!charectar.equals("Beta")&&!charectar.equals("Tao")&&!charectar.equals("Alfa")&&!charectar.equals("Leon")&&!charectar.equals(" ")){
                    System.out.println("please enter Correct character !");
                }
                else {
                    Card card = new Card(Name.trim(), Deffence, Duration, Damage, UpgradeLevel, UpgradeCost, Integer.toString(Integer.parseInt(Duration)*Integer.parseInt(Deffence)),charectar);
                    cards.add(card);
                    Char.returnCharByName(charectar).getCards().add(card);
                    System.out.println("Card added successfully");
                    add = false;
                }
            }
        }
    }
    public static void Checknumber(Scanner input) {
        Card.NameCard();
        edit=true;
        while (edit) {
            System.out.println("Please editing the desire Card");
            String number = input.nextLine();
            if (number.equals("Back of edit card")) {
                System.out.println("you are in menu Admin");
                edit=false;
            }

           else  if (Integer.parseInt(number) > Main.cards.size()) {
                System.out.println("please enter a number between 1 and " +Main.cards.size());
            }
           else  if (Integer.parseInt(number) <= Main.cards.size()) {
                System.out.println("1-Name : " + Main.cards.get(Integer.parseInt(number) - 1).getName());
                System.out.println("2-Attack : " + Main.cards.get(Integer.parseInt(number) - 1).getCardAttack());
                System.out.println("3-Duration : " + Main.cards.get(Integer.parseInt(number) - 1).getDuration());
                System.out.println("4-Damage : " +Main.cards.get(Integer.parseInt(number) - 1).getPlayerDamage());
                System.out.println("5-Upgrade Level : " + Main.cards.get(Integer.parseInt(number) - 1).getUpgradeLevel());
                System.out.println("6-Upgrade Cost : " + Main.cards.get(Integer.parseInt(number) - 1).getUpgradeCost());
                editfield=true;
                while (editfield){
                    System.out.println("please your field edit");
                    String field = input.nextLine();
                    if (field.equals("Back")) {
                        System.out.println("you enter the number card !");
                        break;
                    }
                    if (Integer.parseInt(field) > 6) {
                        System.out.println("please enter a number between 1 and 6");
                    }
                    if (Integer.parseInt(field) <= 6) {
                        if (Integer.parseInt(field)==1) {
                            System.out.println("please edit name");
                            while (true) {
                                String nameedit = input.nextLine();
                                if (Card.CheckName(nameedit) && !nameedit.equals(Main.cards.get(Integer.parseInt(number) - 1).getName())) {
                                    System.out.println("The name of the card is duplicated");
                                } else {
                                    System.out.println("are you sure you want to edit this card ?");
                                    String anser = input.nextLine();
                                    if (anser.equals("Yes")) {
                                        Main.cards.get(Integer.parseInt(number) - 1).setName(nameedit);
                                        System.out.println("edited successfully Name Card");
                                    } else {
                                        System.out.println("No edit name");
                                    }
                                    break;
                                }
                            }
                        }
                        /////////////////////
                        if (Integer.parseInt(field)==2) {
                            System.out.println("please edit attack\\defence card");
                            while (true) {
                                String attackedit = input.nextLine();
                                if (Integer.parseInt(attackedit) < 10 || Integer.parseInt(attackedit) > 100) {
                                    System.out.println("Enter a number between 10 and 100 for defence\\attack");
                                } else {
                                    System.out.println("are you sure you want to edit this card ?");
                                    String anser = input.nextLine();
                                    if (anser.equals("Yes")) {
                                        Main.cards.get(Integer.parseInt(number) - 1).setCardAttack(attackedit);
                                        System.out.println("edited successfully defence\\attack Card");
                                    } else {
                                        System.out.println("No edit defence\\attack");
                                    }
                                    break;
                                }
                            }
                        }
                        ////////////////////////////////////
                        if (Integer.parseInt(field)==3) {
                            System.out.println("please edit duration card");
                            while (true) {
                                String durationedit = input.nextLine();
                                if (Integer.parseInt(durationedit) < 0 || Integer.parseInt(durationedit) > 5) {
                                    System.out.println("Enter a number between 1 and 5 for Duration");
                                } else {
                                    System.out.println("are you sure you want to edit this card ?");
                                    String anser = input.nextLine();
                                    if (anser.equals("Yes")) {
                                        Main.cards.get(Integer.parseInt(number) - 1).setDuration(durationedit);
                                        System.out.println("edited successfully duration Card");
                                    } else {
                                        System.out.println("No edit duration");
                                    }
                                    break;
                                }
                            }
                        }
                        if (Integer.parseInt(field)==4) {
                            System.out.println("please edit player damage card");
                            while (true) {
                                String damageedit = input.nextLine();
                                if (Integer.parseInt(damageedit) < 10 || Integer.parseInt(damageedit) > 50) {
                                    System.out.println("Enter a number between 10 and 50 for Damage");
                                } else {
                                    System.out.println("are you sure you want to edit this card ?");
                                    String anser = input.nextLine();
                                    if (anser.equals("Yes")) {
                                        Main.cards.get(Integer.parseInt(number) - 1).setPlayerDamage(damageedit);
                                        System.out.println("edited successfully player damage Card");
                                    } else {
                                        System.out.println("No edit player damage");
                                    }
                                    break;
                                }
                            }
                        }
                        if (Integer.parseInt(field)==5) {
                            System.out.println("please edit player upgrade level");
                            String upgradeleveledit = input.nextLine();
                            System.out.println("are you sure you want to edit this card ?");
                            String anser = input.nextLine();
                            if (anser.equals("Yes")) {
                                Main.cards.get(Integer.parseInt(number) - 1).setUpgradeLevel(upgradeleveledit);
                                System.out.println("edited successfully player upgrade level Card");
                            } else {
                                System.out.println("No edit player upgrade level");
                            }
                        }
                        if (Integer.parseInt(field)==6) {
                            System.out.println("please edit player upgrade level");
                            String upgradecostedit = input.nextLine();
                            System.out.println("are you sure you want to edit this card ?");
                            String anser = input.nextLine();
                            if (anser.equals("Yes")) {
                                Main.cards.get(Integer.parseInt(number) - 1).setUpgradeCost(upgradecostedit);
                                System.out.println("edited successfully player upgrade level Card");
                            } else {
                                System.out.println("No edit player upgrade cost");
                            }
                        }
                    }


                }
            }
        }
//        if (!edit) {
//            currentMenu[0]=menu.Admin_Menu;
//        }
    }
    public static void Checkdelete(Scanner input) {
    Card.NameCard();
    delete=true;
    while (delete) {
        System.out.println("The number of the card you want to delete ?");
        String num = input.nextLine();
        if (num.equals("Back the menu Admin")) {
            System.out.println("you enter the Menu Admin!");
            break;
        }
        else if (Integer.parseInt(num) >Main.cards.size()) {
            System.out.println("please enter a number between 1 and "+Main.cards.size());
        }
        else if (Integer.parseInt(num) <=Main.cards.size()) {
            System.out.println("are you sure you want to edit this card ?");
            String anser = input.nextLine();
            if (anser.equals("Yes")) {
                Main.cards.remove(Integer.parseInt(num)-1);
                Char.returnCharByName(cards.get(Integer.parseInt(num)-1).getName()).getCards().remove(cards.get(Integer.parseInt(num)-1));
                System.out.println("deleted successfully  Card");
            } else {
                System.out.println("No delete card");
            }
        }
    }
}
    public static void View(){
        for (int i = 0; i < loginedUser.CardsPlayer.size(); i++) {
            System.out.println("Card "+(i+1)+" : ");
            System.out.println("Name : " + loginedUser.CardsPlayer.get(i).getName());
            System.out.println("Attack : " + loginedUser.CardsPlayer.get(i).getCardAttack());
            System.out.println("Duration : " + loginedUser.CardsPlayer.get(i).getDuration());
            System.out.println("Damage : " +loginedUser.CardsPlayer.get(i).getPlayerDamage());
            System.out.println("Upgrade Level : " + loginedUser.CardsPlayer.get(i).getUpgradeLevel());
            System.out.println();
        }
        for (int i = 0; i < loginedUser.specialCardsPlayer.size(); i++) {
            System.out.println("Special Card "+(i+1)+" : ");
            System.out.println("Name : "+loginedUser.specialCardsPlayer.get(i).getNameCard());
            System.out.println("Price : "+loginedUser.specialCardsPlayer.get(i).getPrice());
            System.out.println();
        }
    }
    public static void starterpack(User user){
            NumberEntered = false;
            ArrayList<String>Namecard=new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            Namecard.add(cards.get(i).getName());
        }
        for (int i = 0; i < specialCards.size(); i++) {
            Namecard.add(specialCards.get(i).getNameCard());
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
                Card card =new Card(rand.getName(),rand.getCardAttack(),rand.getDuration(),rand.getPlayerDamage()
                        ,rand.getUpgradeLevel(),rand.getUpgradeCost(),Integer.toString(Integer.parseInt(rand.getDuration())*Integer.parseInt(rand.getCardAttack())),rand.getCharec());
                         user.CardsPlayer.add(card);
            }
            if (SpecialCard.Checkname(item)) {
                SpecialCard rand=SpecialCard.returnSpecialbyName(item);
                SpecialCard scard =new SpecialCard(rand.getNameCard(),rand.getPrice());
                user.specialCardsPlayer.add(scard);
            }
        }
        System.out.println("you got 20 gift cards !");
    }
    public static boolean checkcard(ArrayList<Card>cards,String name){
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static Card returncard(ArrayList<Card>cards,String name){
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getName().equals(name)) {
                return cards.get(i);
            }
        }
        return null;

    }
    public static boolean checkspecialcard(ArrayList<SpecialCard>cards,String name){
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getNameCard().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public static SpecialCard returnspecialcard(ArrayList<SpecialCard>specard,String name){
        for (int i = 0; i < specard.size(); i++) {
            if (specard.get(i).getNameCard().equals(name)) {
                return specard.get(i);
            }
        }
        return null;
    }
    public static boolean checkTasavycard(Card card,Card card1){
        if (card.getName().equals(card1.getName())&&card.getPrice().equals(card1.getPrice())&&card.getUpgradeCost().equals(card1.getUpgradeCost())&&
        card.getDuration().equals(card1.getDuration())&&card.getCardAttack().equals(card1.getCardAttack())&&card.getPlayerDamage().equals(card1.getPlayerDamage())&&
        card.getPrice().equals(card1.getPrice())&&card.getUpgradeLevel().equals(card1.getUpgradeLevel())) {
        return true;
        }
        return false;
    }
    public static boolean checkTasavySpecialCard(SpecialCard card,SpecialCard card1){
        if (card.getNameCard().equals(card1.getNameCard())&&card.getPrice().equals(card1.getPrice())) {
            return true;
        }
        return false;
    }
    public static void createSpell(){
        ///////separ
        SpecialCard shield = new SpecialCard("shield", "400");
        shield.setDescription("It breaks against any card with any damage.");
        //////shefa
        SpecialCard healing = new SpecialCard("healing", "400");
        healing.setDescription("This card adds some HP to the player (no card can break this card).");
        /////increasepower
        SpecialCard PowerBosster = new SpecialCard("PowerBooster", "400");
        PowerBosster.setDescription("By playing this card, one of the played cards will be woven randomly(This card does not occupy space on the ground)");
        /////taghirmakan
        SpecialCard HoleLocationModifier = new SpecialCard("HoleLocationModifier", "400");
        HoleLocationModifier.setDescription("This card can randomly place the missing block of both players to change (The block in which the card was played should not change)");
        /////tamir
        SpecialCard repairman = new SpecialCard("repairman", "400");
        repairman.setDescription("This card can be played on the holes and repair them (this space card from the earth does not occupy");
        /////kamkonanderand
        SpecialCard roundReducer = new SpecialCard("roundReducer", "400");
        roundReducer.setDescription("If this card is played, one of the game rounds will be reduced. For example, the game of 4 The round turns into 3 rounds.(This card does not occupy space on the ground)");
        /////hazf card harif
        SpecialCard RemoveCard = new SpecialCard("RemoveCard", "400");
        RemoveCard.setDescription("This card causes one of the opponent's cards (randomly) to hand\n" +
                "The player himself is transferred. After this incident, the opponent has 4 cards until the end of the round and the player himself is only in that hand\n" +
                "There are 6 cards. (This card does not occupy space on the ground)");
        //////tazifkonande
        SpecialCard CardWeakner = new SpecialCard("CardWeakner", "400");
        CardWeakner.setDescription("Two opponent cards are chosen randomly. One of them is Damijesh and the other one\n" +
                "Its power decreases. (This card does not occupy space on the ground)");
        ///////copy
        SpecialCard CopyCard = new SpecialCard("CopyCard", "400");
        CopyCard.setDescription("By playing this card, it is necessary for the player to enter another card number of his own\n" +
                "chooses and a copy is taken from that card and the player gets 6 cards in that round. (This space card\n" +
                "does not occupy the land)");
        ///////makhfykonande
        SpecialCard HiddenCard = new SpecialCard("HiddenCard", "400");
        HiddenCard.setDescription("This card makes the opponent unable to see his cards in the next round. naturally with\n" +
                "Playing this card, in addition to hiding the cards, their position should also change randomly (this\n" +
                "The card does not occupy the space of the earth)");
        specialCards.add(shield);
        specialCards.add(healing);
        specialCards.add(PowerBosster);
        specialCards.add(HoleLocationModifier);
        specialCards.add(repairman);
        specialCards.add(roundReducer);
        specialCards.add(RemoveCard);
        specialCards.add(CardWeakner);
        specialCards.add(CopyCard);
        specialCards.add(HiddenCard);

    }
    public static void createCharecter(){
        Char cahr1=new Char("Beta");
        Char cahr2=new Char("Alfa");
        Char cahr3=new Char("Leon");
        Char cahr4=new Char("Tao");
        carecter.add(cahr1);
        carecter.add(cahr2);
        carecter.add(cahr3);
        carecter.add(cahr4);
    }
    public static HistoryGame His(int i){
        return loginedUser.getHistoryGame().get(i);
    }
    public static ArrayList<HistoryGame> sortHistory(String type,String sort,ArrayList<HistoryGame>historyGames){
        if (type.equals("ascending")) {
            if (sort.equals("Time")) {
                return loginedUser.getHistoryGame();
            }
            if (sort.equals("Lose")) {
                ArrayList<HistoryGame>historyGames1=new ArrayList<>();
                for (int i = 0; i < historyGames.size(); i++) {
                    if (historyGames.get(i).getLoseWin().equals("Lose")) {
                        historyGames1.add(historyGames.get(i));
                    }
                }
                for (int i = 0; i < historyGames.size(); i++) {
                    if (historyGames.get(i).getLoseWin().equals("Win")) {
                        historyGames1.add(historyGames.get(i));
                    }
                }
                return historyGames1;
            }
            if (sort.equals("Win")) {
                ArrayList<HistoryGame>historyGames1=new ArrayList<>();
                for (int i = 0; i < historyGames.size(); i++) {
                    if (historyGames.get(i).getLoseWin().equals("Win")) {
                        historyGames1.add(historyGames.get(i));
                    }
                }
                for (int i = 0; i < historyGames.size(); i++) {
                    if (historyGames.get(i).getLoseWin().equals("Lose")) {
                        historyGames1.add(historyGames.get(i));
                    }
                }
                return historyGames1;

            }
            if (sort.equals("Name opponent")) {
                ArrayList<HistoryGame>historyGameList=new ArrayList<>(historyGames);
                Collections.sort(historyGameList, Comparator.comparing(HistoryGame::getNameHarif));
            return historyGameList;
            }
            if (sort.equals("opponent level")) {
                ArrayList<HistoryGame>historyGameList=new ArrayList<>(historyGames);
                Collections.sort(historyGameList, Comparator.comparing(HistoryGame::getLevelHarif));
                return historyGameList;
            }
        }

        if (type.equals("descending")) {
            if (sort.equals("Time")) {
                ArrayList<HistoryGame>historyGames1=new ArrayList<>();
                for (int i = loginedUser.getHistoryGame().size()-1; i >=0 ; i--) {
                    historyGames1.add(loginedUser.getHistoryGame().get(i));
                }
                return historyGames1;
            }
            if (sort.equals("Lose")) {
                ArrayList<HistoryGame>historyGames1=new ArrayList<>();
                for (int i = 0; i < historyGames.size(); i++) {
                    if (historyGames.get(i).getLoseWin().equals("Lose")) {
                        historyGames1.add(historyGames.get(i));
                    }
                }
                for (int i = 0; i < historyGames.size(); i++) {
                    if (historyGames.get(i).getLoseWin().equals("Win")) {
                        historyGames1.add(historyGames.get(i));
                    }
                }
                return historyGames1;
            }
            if (sort.equals("Win")) {
                ArrayList<HistoryGame>historyGames1=new ArrayList<>();
                for (int i = 0; i < historyGames.size(); i++) {
                    if (historyGames.get(i).getLoseWin().equals("Win")) {
                        historyGames1.add(historyGames.get(i));
                    }
                }
                for (int i = 0; i < historyGames.size(); i++) {
                    if (historyGames.get(i).getLoseWin().equals("Lose")) {
                        historyGames1.add(historyGames.get(i));
                    }
                }
                return historyGames1;
            }
            if (sort.equals("Name opponent")) {
                ArrayList<HistoryGame>historyGameList=new ArrayList<>(historyGames);
                Collections.sort(historyGameList, Comparator.comparing(HistoryGame::getNameHarif).reversed());
                return historyGameList;
            }
            if (sort.equals("opponent level")) {
                ArrayList<HistoryGame>historyGameList=new ArrayList<>(historyGames);
                Collections.sort(historyGameList, Comparator.comparing(HistoryGame::getLevelHarif).reversed());
                return historyGameList;
            }
        }
        return null;
    }
    public static void HistoryGame(Scanner input,menu[]currentMenu){
        int numHistory=1;
        for (int i = 0; i < loginedUser.HistoryGame.size(); i++) {
            if (i < 10) {
                System.out.printf("%-20s %-25s%-25s %-20s%n", (i + 1) + "- " + His(i).getLoseWin(), His(i).getTime(), His(i).getNameHarif(), His(i).getAwards());
            }
        }
        System.out.println("page 1");
        ArrayList<HistoryGame>Sorter=new ArrayList<>();
        while (true){
            System.out.println("1-next");
            System.out.println("2-previous");
            System.out.println("3-sort");
            System.out.println("4-back");
            String ans=input.nextLine();
            if (ans.equals("next")) {
                if (numHistory * 10 >= ((loginedUser.getHistoryGame().size()))) {
                    System.out.println("No exist next page");
                    continue;
                } else {
                    ++numHistory;
                }
            }
            if (ans.equals("previous")) {
                if (numHistory == 1) {
                    System.out.println("No exist previous page");
                    continue;
                } else {
                    --numHistory;
                }
            }
            if (ans.equals("sort")) {
                String TypeSort = "";
                String WhySort = "";
                while (true) {
                    System.out.println("Sort ascending or descending ?");
                    String ans2 = input.nextLine();
                    if (!ans2.equals("ascending") && !ans2.equals("descending")) {
                        System.out.println("please enter ascending or descending !");
                    } else {
                        TypeSort = ans2;
                        break;
                    }
                }
                while (true) {
                    System.out.println("according to what should be sorted ?");
                    System.out.println("1-Time");
                    System.out.println("2-Name opponent");
                    System.out.println("3-Lose or Win");
                    System.out.println("4-opponent level");
                    String ans3 = input.nextLine();
                    if (!ans3.equals("Time") && !ans3.equals("Name opponent") && !ans3.equals("Lose or Win") && !ans3.equals("opponent level")) {
                        System.out.println("please please choose between the above entries !");
                    } else {
                        WhySort = ans3;
                        break;
                    }
                }
                Sorter = sortHistory(TypeSort, WhySort, loginedUser.getHistoryGame());
                numHistory = 1;
            }
            if (ans.equals("back")) {
                currentMenu[0]=menu.Main_Menu;
                System.out.println("you are enter Main Menu !");
                break;
            }
            for (int i = numHistory-1; i < Sorter.size(); i++) {
                if (i < 10*numHistory) {
                    System.out.printf("%-20s %-25s%-25s %-20s%n", (i + 1) + "- " + His(i).getLoseWin(), His(i).getTime(), His(i).getNameHarif(), His(i).getAwards());
                }
            }
            System.out.println("page : "+numHistory);

        }


    }
    public static final String[][] DIGITS_ART = {
            {
                    " .d8888b.  ",
                    "d88P  Y88b ",
                    "888    888 ",
                    "888    888 ",
                    "888    888 ",
                    "888    888 ",
                    "Y88b  d88P ",
                    " \"Y8888P\"  "
            },
            {
                    "   d888    ",
                    "  d8888    ",
                    "    888    ",
                    "    888    ",
                    "    888    ",
                    "    888    ",
                    "    888    ",
                    "  8888888  "
            },
            {
                    " .d8888b.  ",
                    "d88P  Y88b ",
                    "      .d88 ",
                    "     d88P  ",
                    "   .d88P   ",
                    " .d88P     ",
                    "d88P   .d8 ",
                    "88888888PP "
            },
            {
                    " .d8888b.  ",
                    "d88P  Y88b ",
                    "     .d88P ",
                    "    8888\"  ",
                    "     \"Y8b. ",
                    "        888",
                    "Y88b  d88P ",
                    " \"Y8888P\"  "
            },
            {
                    "    d8888  ",
                    "   d8P888  ",
                    "  d8P 888  ",
                    " d8P  888  ",
                    "d88   888  ",
                    "8888888888 ",
                    "      888  ",
                    "      888  "
            },
            {
                    "888888888  ",
                    "888        ",
                    "888        ",
                    "8888888b.  ",
                    "     \"Y88b ",
                    "       888 ",
                    "Y88b  d88P ",
                    " \"Y8888P\"  "
            },
            {
                    " .d8888b.  ",
                    "d88P  Y88b ",
                    "888        ",
                    "888d888b.  ",
                    "888P \"Y88b ",
                    "888    888 ",
                    "Y88b  d88P ",
                    " \"Y8888P\"  "
            },
            {
                    "8888888888 ",
                    "      d88P ",
                    "     d88P  ",
                    "    d88P   ",
                    "   d88P    ",
                    "  d88P     ",
                    " d88P      ",
                    "d88P       "
            },
            {
                    " .d8888b.  ",
                    "d88P  Y88b ",
                    "Y88b. d88P ",
                    " \"Y88888\"  ",
                    ".d8P\"\"Y8b. ",
                    "888    888 ",
                    "Y88b  d88P ",
                    " \"Y8888P\"  "
            },
            {
                    " .d8888b.  ",
                    "d88P  Y88b ",
                    "888    888 ",
                    "Y88b. d888 ",
                    " \"Y888P888 ",
                    "       888 ",
                    "Y88b  d88P ",
                    " \"Y8888P\"  "
            }
    };
}

