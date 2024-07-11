package CityWars;

import java.security.SecureRandom;

public class RandomPasswordGenerator {

    // Generate a random password with the specified length
    public static String generatePassword(int length) {
        // Define character sets for each required type of character
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digitChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+";

        // Create a string builder to construct the password
        StringBuilder passwordBuilder = new StringBuilder();

        // Add at least one character from each character set
        passwordBuilder.append(lowercaseChars.charAt(new SecureRandom().nextInt(lowercaseChars.length())));
        passwordBuilder.append(uppercaseChars.charAt(new SecureRandom().nextInt(uppercaseChars.length())));
        passwordBuilder.append(digitChars.charAt(new SecureRandom().nextInt(digitChars.length())));
        passwordBuilder.append(specialChars.charAt(new SecureRandom().nextInt(specialChars.length())));

        // Fill the rest of the password with random characters from all character sets
        for (int i = 4; i < length; i++) {
            String allChars = lowercaseChars + uppercaseChars + digitChars + specialChars;
            passwordBuilder.append(allChars.charAt(new SecureRandom().nextInt(allChars.length())));
        }

        // Shuffle the characters in the password to randomize their order
        String password = passwordBuilder.toString();
        char[] passwordArray = password.toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = new SecureRandom().nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }
        return new String(passwordArray);
    }
}
////////////////////////////////
//////////////////////////////////////////////////////////////////////
////////////////////////////////
//                    while (true) {
//                        System.out.println("Please select desired Card !");
//                        String regex1 = "-Select card number (?<number>.+) player (?<player>.+)";
//                        String vorody = input.nextLine();
//                        Matcher regexVorody = setMatcher(vorody, regex1);
//                        String Cardnum = regexVorody.group("number");
//                        String gamer = regexVorody.group("player");
//                        if (vorody.equals("Back the Game")) {
//                            System.out.println("Continue game !");
//                            break;
//                        } else if (!Cardnum.equals("1") && !Cardnum.equals("2") && !Cardnum.equals("3") && !Cardnum.equals("4") && !Cardnum.equals("5")) {
//                            System.out.println("please enter a number between 1 and 5 !");
//                        } else if (!gamer.equals("1") && !!gamer.equals("2")) {
//                            System.out.println("please enter number between 1 and 2 !");
//                        } else {
//                            if (gamer.equals("1")) {
//                                String Name = CardsPlayer1[Integer.parseInt(Cardnum) - 1];
//                                if (Card.CheckName(CardsPlayer1[Integer.parseInt(Cardnum) - 1])) {
//                                    System.out.println("Name Card : " + Name);
//                                    System.out.println("Duration Card : " + Card.returnCardbyName(Name).getDuration());
//                                    System.out.println("Attack Card : " + Card.returnCardbyName(Name).getCardAttack());
//                                    System.out.println("Player Damage Card : " + Card.returnCardbyName(Name).getPlayerDamage());
//                                    System.out.println("Character Card : " + Card.returnCardbyName(Name).getCharec());
//                                }
//                                if (SpecialCard.Checkname(CardsPlayer1[Integer.parseInt(Cardnum) - 1])) {
//                                    System.out.println("Name Card : " + SpecialCard.returnSpecialbyName(Name).getNameCard());
//                                    System.out.println("Description :" + SpecialCard.returnSpecialbyName(Name).getDescription());
//                                }
//                            }
//                            if (gamer.equals("2")) {
//                                String Name = CardsPlayer2[Integer.parseInt(Cardnum) - 1];
//                                if (Card.CheckName(CardsPlayer2[Integer.parseInt(Cardnum) - 1])) {
//                                    System.out.println("Name Card : " + Name);
//                                    System.out.println("Duration Card : " + Card.returnCardbyName(Name).getDuration());
//                                    System.out.println("Attack Card : " + Card.returnCardbyName(Name).getCardAttack());
//                                    System.out.println("Player Damage Card : " + Card.returnCardbyName(Name).getPlayerDamage());
//                                    System.out.println("Character Card : " + Card.returnCardbyName(Name).getCharec());
//                                }
//                                if (SpecialCard.Checkname(CardsPlayer2[Integer.parseInt(Cardnum) - 1])) {
//                                    System.out.println("Name Card : " + SpecialCard.returnSpecialbyName(Name).getNameCard());
//                                    System.out.println("Description :" + SpecialCard.returnSpecialbyName(Name).getDescription());
//                                }
//                            }
//                        }
//                    }
///////////////////////////////////////////////////////////////////

//            if (play1) {
//                while (true) {
//                    System.out.println("please select player 1 desired card and specify its location !");
//                    String regex = "Placing card number (?<num>.+) in block (?<location>.+)";
//                    String ans = input.nextLine();
//                    Matcher regexAns = setMatcher(ans, regex);
//                    String num = regexAns.group("num");
//                    String lenght = regexAns.group("location");
//                    if (!num.equals("1") && !num.equals("2") && !num.equals("3") && !num.equals("4") && !num.equals("5")&&(!num.equals("6")||CardsCopy6player1==0)) {
//                        System.out.println("please enter a number between 1 and 5 !");
//                    } else if (!lenght.equals("6") && !lenght.equals("7") && !lenght.equals("8") && !lenght.equals("9") && !lenght.equals("10")) {
//                        System.out.println("please enter a number between 1 and 21");
//                    } else if (!lenght.equals("11") && !lenght.equals("12") && !lenght.equals("13") && !lenght.equals("14") && !lenght.equals("15")) {
//                        System.out.println("please enter a number between 1 and 21");
//                    } else if (!lenght.equals("20") && !lenght.equals("19") && !lenght.equals("18") && !lenght.equals("17") && !lenght.equals("16") && !lenght.equals("21")) {
//                        System.out.println("please enter a number between 1 and 21");
//                    } else {
//                        if (Card.CheckName(CardsPlayer1[Integer.parseInt(num) - 1])) {
//                            if (Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer1).getDuration()) + Integer.parseInt(lenght) > 22) {
//                                System.out.println("you can not place this card in this location !");
//                            } else if (GameTowPlayer.CheckTheSelectCard(num, lenght, CardsPlayer1, MapGame)) {
//                                System.out.println("you can not place this card in this location !");
//                            } else {
//                                int x2 = Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer1).getDuration()) + Integer.parseInt(lenght) - 1;
//                                for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
//                                    MapGame[i][0] = GameTowPlayer.getCardWithName(num, CardsPlayer1).getName();
//                                    attack[i][0]=CardsAttackPlayer1[Integer.parseInt(num)-1];
//                                    CardLocation[i][0]=CardLoca;
//                                }
//                                ++CardLoca;
//                                //////////////////////////////////////
////                                         player damage
//                                for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
//                                    if (loginedUser.getCharecter().equals(Card.returnCardbyName(MapGame[i][0]).getCharec())) {
//                                        if (MapGame[i][1] == "" || MapGame[i][1] == "#") {
//                                            Damageplayer[i][0] = CardsDamagePlayer1[Integer.parseInt(num) - 1] + 5;
//                                            Player1Damage += Damageplayer[i][0];
//                                        } else {
//                                            ////////////////Card
//                                            if (Card.CheckName(MapGame[i][1])) {
//                                                if (attack[i][1] > attack[i][0]) {
//                                                    Damageplayer[i][0] = 0;
//                                                }
//                                                if (attack[i][1] < attack[i][0]) {
//                                                    Damageplayer[i][0] = CardsDamagePlayer1[Integer.parseInt(num) - 1] + 5;
//                                                    Player1Damage += Damageplayer[i][0];
//                                                    Player2Damage -= Damageplayer[i][1];
//                                                    Damageplayer[i][1] = 0;
//                                                }
//                                                if (attack[i][1] == attack[i][0]) {
//                                                    Player2Damage -= Damageplayer[i][1];
//                                                    Damageplayer[i][1] = 0;
//                                                    Damageplayer[i][0] = 0;
//                                                }
//                                                //////////Special Card
//                                                else {
//                                                    if (MapGame[i][1].equals("shield")) {
//                                                        Damageplayer[i][0] = 0;
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    } else {
//                                        if (MapGame[i][1] == "" || MapGame[i][1] == "#") {
//                                            Damageplayer[i][0] = CardsDamagePlayer1[Integer.parseInt(num) - 1];
//                                            Player1Damage += Damageplayer[i][0];
//                                        } else {
//                                            //////////////card
//                                            if (Card.CheckName(MapGame[i][1])) {
//                                                if (attack[i][1] > attack[i][0]) {
//                                                    Damageplayer[i][0] = 0;
//                                                }
//                                                if (attack[i][1] < attack[i][0]) {
//                                                    Damageplayer[i][0] = CardsDamagePlayer1[Integer.parseInt(num) - 1];
//                                                    Player1Damage += Damageplayer[i][0];
//                                                    Player2Damage -= Damageplayer[i][1];
//                                                    Damageplayer[i][1] = 0;
//                                                }
//                                                if (attack[i][1] == attack[i][0]) {
//                                                    Player2Damage -= Damageplayer[i][1];
//                                                    Damageplayer[i][1] = 0;
//                                                    Damageplayer[i][0] = 0;
//                                                }
//                                            }
//                                            ///////////////////////special card
//                                            else {
//                                                if (MapGame[i][1].equals("shield")) {
//                                                    Damageplayer[i][0] = 0;
//                                                }
//                                            }
//
//                                        }
//
//                                    }
//                                }
//
//
//                                ///////////////////////////////////////////////////////////
//                                Random random2 = new Random();
//                                String cardRand = "";
//                                int randomIndex3 = random2.nextInt(Namecard.size());
//                                cardRand = Namecard.get(randomIndex3);
//                                CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
//                                if (Card.CheckName(cardRand)) {
//                                    CardsAttackPlayer1[Integer.parseInt(num)-1]=Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                    CardsDamagePlayer1[Integer.parseInt(num)-1]=Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                }
//                                if (SpecialCard.Checkname(cardRand)) {
//                                    CardsAttackPlayer1[Integer.parseInt(num)-1]=0;
//                                    CardsDamagePlayer1[Integer.parseInt(num)-1]=0;
//                                }
//                                ////////////////////////////////////////////////
//                                --numRand1;
//                                play1 = false;
//                                play2 = true;
//                                break;
//                            }
//                        }
//                        ///////////////////////////////SpeciaCard
//                        else if (SpecialCard.Checkname(CardsPlayer1[Integer.parseInt(num) - 1])) {
//                            if (GameTowPlayer.CheckTheSelectSpecialCard(lenght, MapGame)) {
//                                System.out.println("you can not place this special card in this location !");
//                            } else {
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("healing")) {
//                                    MapGame[Integer.parseInt(lenght) - 1][0] = "healing";
//                                    CardLocation[Integer.parseInt(lenght) - 1][0] = CardLoca;
//                                    ++CardLoca;
//                                    attack[Integer.parseInt(lenght) - 1][0] = 0;
//                                    Damageplayer[Integer.parseInt(lenght) - 1][0] = 0;
//                                    Random random5 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random5.nextInt(Namecard.size());
//                                    cardRand = Namecard.get(randomIndex3);
//                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    ////////////////////////////////////////////////
//                                    loginedUser.setHP(loginedUser.getHP() + 15);
//                                    --numRand1;
//                                    play1 = false;
//                                    play2 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("repairman")) {
//                                    Random random6 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random6.nextInt(Namecard.size());
//                                    cardRand = Namecard.get(randomIndex3);
//                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    ////////////////////////////////////////////////
//                                    MapGame[randomNumplayer1][0] = "";
//                                    --numRand1;
//                                    play1 = false;
//                                    play2 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("roundReducer")) {
//                                    Random random7 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random7.nextInt(Namecard.size());
//                                    cardRand = Namecard.get(randomIndex3);
//                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    /////////////////////////////////////////////////
//                                    --numRand1;
//                                    --numRand1;
//                                    --numRand2;
//                                    play1 = false;
//                                    play2 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("shield")) {
//                                    MapGame[Integer.parseInt(lenght) - 1][0] = "shield";
//                                    attack[Integer.parseInt(lenght) - 1][0] = 0;
//                                    Damageplayer[Integer.parseInt(lenght) - 1][0] = 0;
//                                    CardLocation[Integer.parseInt(lenght) - 1][0] = CardLoca;
//                                    ++CardLoca;
//                                    Random random9 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random9.nextInt(Namecard.size());
//                                    cardRand = Namecard.get(randomIndex3);
//                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand1;
//                                    play1 = false;
//                                    play2 = true;
//                                    ////////////////////////////////////////////////
//                                    if (MapGame[Integer.parseInt(lenght) - 1][1] == "" || MapGame[Integer.parseInt(lenght) - 1][1] == "#") {
//                                    } else if (MapGame[Integer.parseInt(lenght) - 1][1] != "") {
//                                        if (SpecialCard.Checkname(MapGame[Integer.parseInt(lenght) - 1][1])) {
//                                        } else if (Card.CheckName(MapGame[Integer.parseInt(lenght) - 1][1])) {
//                                            Player2Damage -= Damageplayer[Integer.parseInt(lenght) - 1][1];
//                                            Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
//                                        }
//                                    }
//
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("HoleLocationModifier")) {
//                                    MapGame[Integer.parseInt(lenght) - 1][0] = "HoleLocationModifier";
//                                    attack[Integer.parseInt(lenght) - 1][0] = 0;
//                                    Damageplayer[Integer.parseInt(lenght) - 1][0] = 0;
//                                    CardLocation[Integer.parseInt(lenght) - 1][0] = CardLoca;
//                                    ++CardLoca;
//                                    MapGame[randomNumplayer1][0] = "";
//                                    MapGame[randomNum1player2][1] = "";
//                                    while (true) {
//                                        int randomplayer1 = (int) (Math.random() * 21);
//                                        if (MapGame[randomplayer1][0] == "") {
//                                            MapGame[randomplayer1][0] = "#";
//                                            randomNumplayer1 = randomplayer1;
//                                            break;
//                                        }
//                                    }
//                                    while (true) {
//                                        int randomplayer2 = (int) (Math.random() * 21);
//                                        if (MapGame[randomplayer2][0] == "") {
//                                            MapGame[randomplayer2][0] = "#";
//                                            randomNum1player2 = randomplayer2;
//                                            break;
//                                        }
//                                    }
//                                    Random random0 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random0.nextInt(Namecard.size());
//                                    cardRand = Namecard.get(randomIndex3);
//                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand1;
//                                    play1 = false;
//                                    play2 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("CardWeakner")) {
//                                    ArrayList<Integer> rend = new ArrayList<>();
//                                    ArrayList<Integer> Weakner = new ArrayList<>();
//                                    for (int i = 0; i < 5; i++) {
//                                        if (Card.CheckName(CardsPlayer2[i])) {
//                                            Weakner.add(i);
//                                        }
//                                    }
//                                    if (Weakner.size() > 1) {
//                                        Random random21 = new Random();
//                                        while (rend.size() < 2) {
//                                            int randomIndex = random21.nextInt(Weakner.size());
//                                            rend.add(Weakner.get(randomIndex));
//                                        }
//                                        CardsAttackPlayer2[rend.get(0)] -= 3;
//                                        CardsDamagePlayer2[rend.get(1)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer2[rend.get(1)]).getDuration());
//                                    }
//                                    if (Weakner.size() == 1) {
//                                        Random random31 = new Random();
//                                        int randomIndex = random31.nextInt(2);
//                                        if (randomIndex == 0) {
//                                            CardsAttackPlayer2[Weakner.get(0)] -= 3;
//                                        }
//                                        if (randomIndex == 1) {
//                                            CardsDamagePlayer2[Weakner.get(0)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer2[rend.get(1)]).getDuration());
//                                        }
//                                    }
//                                    if (Weakner.size() == 0) {
//                                    }
//                                    Random random03 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random03.nextInt(Namecard.size());
//                                    cardRand = Namecard.get(randomIndex3);
//                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand1;
//                                    play1 = false;
//                                    play2 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("PowerBosster")) {
//                                    Random random03 = new Random();
//                                    int randomIndex3 = random03.nextInt(CardLoca);
//
//                                    for (int i = 0; i < 21; i++) {
//                                        if (CardLocation[i][0] == randomIndex3) {
//                                            Damageplayer[i][0] += 3;
//                                            Player1Damage += 3;
//                                        }
//                                    }
//                                    Random random04 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex4 = random04.nextInt(Namecard.size());
//                                    cardRand = Namecard.get(randomIndex4);
//                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand1;
//                                    play1 = false;
//                                    play2 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("Copycard")) {
//                                    String copy = "";
//                                    while (true) {
//                                        System.out.println("please enter the desired Card number for the copy !");
//                                        String NUM = input.nextLine();
//                                        if (!NUM.equals("1") && !NUM.equals("2") && !NUM.equals("3") && !NUM.equals("4") && !NUM.equals("5")) {
//                                            System.out.println("please enter a number between 1 and 5 !");
//                                        } else {
//                                            copy = NUM;
//                                            break;
//                                        }
//                                    }
//                                    CardsPlayer1[5] = CardsPlayer1[Integer.parseInt(copy) - 1];
//                                    CardsAttackPlayer1[5] = CardsAttackPlayer1[Integer.parseInt(copy) - 1];
//                                    CardsDamagePlayer1[5] = CardsDamagePlayer1[Integer.parseInt(copy) - 1];
//                                    CardsCopy6player1 = 1;
//
//                                    Random random04 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex4 = random04.nextInt(Namecard.size());
//                                    cardRand = Namecard.get(randomIndex4);
//                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand1;
//                                    play1 = false;
//                                    play2 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("RemoveCard")) {
//                                    if (CardsCopy6player1 == 1) {
//                                        System.out.println("you can not use this Card");
//                                        continue;
//                                    } else {
//                                        Random random2=new Random();
//                                        int cin=random2.nextInt(5);
//                                        CardsPlayer1[5]=CardsPlayer2[cin];
//                                        CardsAttackPlayer1[5]=CardsAttackPlayer2[cin];
//                                        CardsDamagePlayer1[5]=CardsDamagePlayer2[cin];
//                                        CardsCopy6player1=1;
//                                        CardsPlayer2[cin]="";
//                                        CardsAttackPlayer2[cin]=0;
//                                        CardsDamagePlayer2[cin]=0;
//                                    }
//                                    /////////////////////////
//                                    Random random05 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex4 = random05.nextInt(Namecard.size());
//                                    cardRand = Namecard.get(randomIndex4);
//                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand1;
//                                    play1 = false;
//                                    play2 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer1[Integer.parseInt(num) - 1]).getNameCard().equals("HiddenCard")) {
//                                    HiddenCardPlayer2=1;
//                                    String a=CardsPlayer2[0];
//                                    String b=CardsPlayer2[1];
//                                    String c=CardsPlayer2[2];
//                                    String d=CardsPlayer2[3];
//                                    String e=CardsPlayer2[4];
//                                    CardsPlayer2[0]=d;
//                                    CardsPlayer2[1]=c;
//                                    CardsPlayer2[2]=b;
//                                    CardsPlayer2[3]=e;
//                                    CardsPlayer2[4]=a;
//                                    timeHiddenplayer2=numRand2;
//                                    Random random05 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex4 = random05.nextInt(Namecard.size());
//                                    cardRand = Namecard.get(randomIndex4);
//                                    CardsPlayer1[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer1[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer1[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand1;
//                                    play1 = false;
//                                    play2 = true;
//                                }
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//            System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "rand 1", "rand 2");
//            System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", numRand1, numRand2);
//            System.out.println();
//            System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", "1-", "2-");
//            System.out.println();
//            for (int i = 0; i < 21; i++) {
//                String CardPlayer1 = "";
//                String CardPlayer2 = "";
//                String CardFeaturePlayer1 = "";
//                String CardFeaturePlayer2 = "";
//                String tab = "";
//                if (i >= 0 && i <= 8) {
//                    tab = "    ";
//                }
//                if (i > 8) {
//                    tab = "     ";
//                }
//                String HP1 = "";
//                String HP2 = "";
//                String Nameplayer1 = "";
//                String Nameplayer2 = "";
//                if (i == 8) {
//                    CardPlayer1 = "1- " + CardsPlayer1[0];
//                    CardPlayer2 = "1- " + CardsPlayer2[0];
//                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[0],CardsAttackPlayer1[0],CardsDamagePlayer1[0]);
//                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[0],CardsAttackPlayer2[0],CardsDamagePlayer2[0]);
//                }
//                if (i == 9) {
//                    CardPlayer1 = "2- " + CardsPlayer1[1];
//                    CardPlayer2 = "2- " + CardsPlayer2[1];
//                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[1],CardsAttackPlayer1[1],CardsDamagePlayer1[1]);
//                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[1],CardsAttackPlayer2[1],CardsDamagePlayer2[1]);
//                }
//                if (i == 10) {
//                    CardPlayer1 = "3- " + CardsPlayer1[2];
//                    CardPlayer2 = "3- " + CardsPlayer2[2];
//                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[2],CardsAttackPlayer1[2],CardsDamagePlayer1[2]);
//                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[2],CardsAttackPlayer2[2],CardsDamagePlayer2[2]);
//                    Nameplayer1 = "gamer 1 :" + loginedUser.getCharecter();
//                    Nameplayer2 = "gamer 2 :" + loginedUser1.getCharecter();
//                    HP1 = "Hp player1 :" + HpPlayer1;
//                    HP2 = "Hp player2 :" + HpPlayer2;
//                }
//                if (i == 11) {
//                    CardPlayer1 = "4- " + CardsPlayer1[3];
//                    CardPlayer2 = "4- " + CardsPlayer2[3];
//                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[3],CardsAttackPlayer1[3],CardsDamagePlayer1[3]);
//                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[3],CardsAttackPlayer2[3],CardsDamagePlayer2[3]);
//                }
//                if (i == 12) {
//                    CardPlayer1 = "5- " + CardsPlayer1[4];
//                    CardPlayer2 = "5- " + CardsPlayer2[4];
//                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[4],CardsAttackPlayer1[4],CardsDamagePlayer1[4]);
//                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[4],CardsAttackPlayer2[4],CardsDamagePlayer2[4]);
//                }
//                if (i == 13&&CardsCopy6player1==1) {
//                    CardPlayer1 = "6- " + CardsPlayer1[5];
////                            CardPlayer2 = "6- " + CardsPlayer2[4];
//                    CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[5],CardsAttackPlayer1[5],CardsDamagePlayer1[5]);
////                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[4],CardsAttackPlayer2[4],CardsDamagePlayer2[4]);
//                }
//                if (i == 13&&CardsCopy6player2==1) {
//                    CardPlayer2 = "6- " + CardsPlayer2[5];
//                    CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[5],CardsAttackPlayer2[5],CardsDamagePlayer2[5]);
//                }
//                if (HiddenCardPlayer1==1) {
//                    String[]space=CardPlayer1.split(" ");
//                    CardPlayer1=space[0];
//                    CardFeaturePlayer1="";
//                }
//                if (HiddenCardPlayer2==1) {
//                    String[]space=CardPlayer2.split(" ");
//                    CardPlayer2=space[0];
//                    CardFeaturePlayer2="";
//                }
//
//                System.out.printf("%-20s %-25s %-25s %-25s %-25s %-25s%n", Nameplayer1, CardPlayer1, (i + 1) + "-  " + MapGame[i][0], MapGame[i][1], CardPlayer2, Nameplayer2);
//                Nameplayer1 = "";
//                Nameplayer2 = "";
//                CardPlayer1 = "";
//                CardPlayer2 = "";
//                System.out.printf("%-20s %-25s %-25s %-25s %-25s %-25s", HP1, "   " + CardFeaturePlayer1, tab + GameTowPlayer.getCardFeauture1(MapGame[i][0], attack[i][0],Damageplayer[i][0]) ,
//                        GameTowPlayer.getCardFeauture1(MapGame[i][1],attack[i][0],Damageplayer[i][0]), "   " + CardFeaturePlayer2, HP2);
//                System.out.println();
//                System.out.println();
//            }
//            System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "player damage 1", "player damage 2");
//            System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", Player1Damage, Player2Damage);
//            System.out.println();
//            if (play2) {
//                while (true) {
//                    System.out.println("please select player 2 desired card and specify its location !");
//                    String regex = "Placing card number (?<num>.+) in block (?<location>.+)";
//                    String ans = input.nextLine();
//                    Matcher regexAns = setMatcher(ans, regex);
//                    String num = regexAns.group("num");
//                    String lenght = regexAns.group("location");
//                    if (!num.equals("1") && !num.equals("2") && !num.equals("3") && !num.equals("4") && !num.equals("5")&&(!num.equals("6")||CardsCopy6player2==0)) {
//                        System.out.println("please enter a number between 1 and 5 !");
//                    } else if (!lenght.equals("6") && !lenght.equals("7") && !lenght.equals("8") && !lenght.equals("9") && !lenght.equals("10")) {
//                        System.out.println("please enter a number between 1 and 21");
//                    } else if (!lenght.equals("11") && !lenght.equals("12") && !lenght.equals("13") && !lenght.equals("14") && !lenght.equals("15")) {
//                        System.out.println("please enter a number between 1 and 21");
//                    } else if (!lenght.equals("20") && !lenght.equals("19") && !lenght.equals("18") && !lenght.equals("17") && !lenght.equals("16") && !lenght.equals("21")) {
//                        System.out.println("please enter a number between 1 and 21");
//                    } else {
//                        if (Card.CheckName(CardsPlayer2[Integer.parseInt(num) - 1])) {
//                            if (Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer2).getDuration()) + Integer.parseInt(lenght) > 22) {
//                                System.out.println("you can not place this card in this location !");
//                            } else if (GameTowPlayer.CheckTheSelectCard(num, lenght, CardsPlayer2, MapGame)) {
//                                System.out.println("you can not place this card in this location !");
//                            } else {
//                                int x2 = Integer.parseInt(GameTowPlayer.getCardWithName(num, CardsPlayer2).getDuration()) + Integer.parseInt(lenght) - 1;
//                                for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
//                                    MapGame[i][1] = GameTowPlayer.getCardWithName(num, CardsPlayer2).getName();
//                                    attack[i][1]=CardsAttackPlayer2[Integer.parseInt(num)-1];
//                                    CardLocation[i][1]=CardLoca;
//                                }
//                                ++CardLoca;
//                                //////////////////////////////////////
////                                         player damage
//                                for (int i = Integer.parseInt(lenght) - 1; i < x2; i++) {
//                                    if (loginedUser1.getCharecter().equals(Card.returnCardbyName(MapGame[i][1]).getCharec())) {
//                                        if (MapGame[i][0] == "" || MapGame[i][0] == "#") {
//                                            Damageplayer[i][1] = CardsDamagePlayer2[Integer.parseInt(num) - 1] + 5;
//                                            Player2Damage += Damageplayer[i][1];
//                                        } else {
//                                            ////////////////Card
//                                            if (Card.CheckName(MapGame[i][0])) {
//                                                if (attack[i][0] > attack[i][1]) {
//                                                    Damageplayer[i][1] = 0;
//                                                }
//                                                if (attack[i][0] < attack[i][1]) {
//                                                    Damageplayer[i][1] = CardsDamagePlayer2[Integer.parseInt(num) - 1] + 5;
//                                                    Player2Damage += Damageplayer[i][1];
//                                                    Player1Damage -= Damageplayer[i][0];
//                                                    Damageplayer[i][0] = 0;
//                                                }
//                                                if (attack[i][1] == attack[i][0]) {
//                                                    Player1Damage -= Damageplayer[i][0];
//                                                    Damageplayer[i][1] = 0;
//                                                    Damageplayer[i][0] = 0;
//                                                }
//                                                //////////Special Card
//                                                else {
//                                                    if (MapGame[i][0].equals("shield")) {
//                                                        Damageplayer[i][1] = 0;
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    } else {
//                                        if (MapGame[i][0] == "" || MapGame[i][0] == "#") {
//                                            Damageplayer[i][1] = CardsDamagePlayer2[Integer.parseInt(num) - 1];
//                                            Player2Damage += Damageplayer[i][1];
//                                        } else {
//                                            //////////////card
//                                            if (Card.CheckName(MapGame[i][0])) {
//                                                if (attack[i][0] > attack[i][1]) {
//                                                    Damageplayer[i][1] = 0;
//                                                }
//                                                if (attack[i][0] < attack[i][1]) {
//                                                    Damageplayer[i][1] = CardsDamagePlayer2[Integer.parseInt(num) - 1];
//                                                    Player2Damage += Damageplayer[i][1];
//                                                    Player1Damage -= Damageplayer[i][0];
//                                                    Damageplayer[i][0] = 0;
//                                                }
//                                                if (attack[i][1] == attack[i][0]) {
//                                                    Player1Damage -= Damageplayer[i][0];
//                                                    Damageplayer[i][1] = 0;
//                                                    Damageplayer[i][0] = 0;
//                                                }
//                                            }
//                                            ///////////////////////special card
//                                            else {
//                                                if (MapGame[i][0].equals("shield")) {
//                                                    Damageplayer[i][1] = 0;
//                                                }
//                                            }
//
//                                        }
//
//                                    }
//                                }
//
//
//                                ///////////////////////////////////////////////////////////
//                                Random random2 = new Random();
//                                String cardRand = "";
//                                int randomIndex3 = random2.nextInt(Namecard1.size());
//                                cardRand = Namecard1.get(randomIndex3);
//                                CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
//                                if (Card.CheckName(cardRand)) {
//                                    CardsAttackPlayer2[Integer.parseInt(num)-1]=Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                    CardsDamagePlayer2[Integer.parseInt(num)-1]=Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                }
//                                if (SpecialCard.Checkname(cardRand)) {
//                                    CardsAttackPlayer2[Integer.parseInt(num)-1]=0;
//                                    CardsDamagePlayer2[Integer.parseInt(num)-1]=0;
//                                }
//                                ////////////////////////////////////////////////
//                                --numRand2;
//                                play2 = false;
//                                play1 = true;
//                                break;
//                            }
//                        }
//                        ///////////////////////////////SpecialCard
//                        else if (SpecialCard.Checkname(CardsPlayer2[Integer.parseInt(num) - 1])) {
//                            if (GameTowPlayer.CheckTheSelectSpecialCard(lenght, MapGame)) {
//                                System.out.println("you can not place this special card in this location !");
//                            } else {
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("healing")) {
//                                    MapGame[Integer.parseInt(lenght) - 1][1] = "healing";
//                                    CardLocation[Integer.parseInt(lenght) - 1][1] = CardLoca;
//                                    ++CardLoca;
//                                    attack[Integer.parseInt(lenght) - 1][1] = 0;
//                                    Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
//                                    Random random5 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random5.nextInt(Namecard1.size());
//                                    cardRand = Namecard1.get(randomIndex3);
//                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    ////////////////////////////////////////////////
//                                    loginedUser1.setHP(loginedUser1.getHP() + 15);
//                                    --numRand2;
//                                    play2 = false;
//                                    play1 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("repairman")) {
//                                    Random random6 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random6.nextInt(Namecard1.size());
//                                    cardRand = Namecard1.get(randomIndex3);
//                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    ////////////////////////////////////////////////
//                                    MapGame[randomNumplayer1][1] = "";
//                                    --numRand2;
//                                    play2 = false;
//                                    play1 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("roundReducer")) {
//                                    Random random7 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random7.nextInt(Namecard1.size());
//                                    cardRand = Namecard1.get(randomIndex3);
//                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    /////////////////////////////////////////////////
//                                    --numRand2;
//                                    --numRand2;
//                                    --numRand1;
//                                    play2 = false;
//                                    play1 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("shield")) {
//                                    MapGame[Integer.parseInt(lenght) - 1][1] = "shield";
//                                    attack[Integer.parseInt(lenght) - 1][1] = 0;
//                                    Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
//                                    CardLocation[Integer.parseInt(lenght) - 1][1] = CardLoca;
//                                    ++CardLoca;
//                                    Random random9 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random9.nextInt(Namecard1.size());
//                                    cardRand = Namecard1.get(randomIndex3);
//                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand2;
//                                    play2 = false;
//                                    play1 = true;
//                                    ////////////////////////////////////////////////
//                                    if (MapGame[Integer.parseInt(lenght) - 1][1] == "" || MapGame[Integer.parseInt(lenght) - 1][1] == "#") {
//                                    } else if (MapGame[Integer.parseInt(lenght) - 1][1] != "") {
//                                        if (SpecialCard.Checkname(MapGame[Integer.parseInt(lenght) - 1][1])) {
//                                        } else if (Card.CheckName(MapGame[Integer.parseInt(lenght) - 1][1])) {
//                                            Player2Damage -= Damageplayer[Integer.parseInt(lenght) - 1][1];
//                                            Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
//                                        }
//                                    }
//
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("HoleLocationModifier")) {
//                                    MapGame[Integer.parseInt(lenght) - 1][1] = "HoleLocationModifier";
//                                    attack[Integer.parseInt(lenght) - 1][1] = 0;
//                                    Damageplayer[Integer.parseInt(lenght) - 1][1] = 0;
//                                    CardLocation[Integer.parseInt(lenght) - 1][1] = CardLoca;
//                                    ++CardLoca;
//                                    MapGame[randomNumplayer1][0] = "";
//                                    MapGame[randomNum1player2][1] = "";
//                                    while (true) {
//                                        int randomplayer1 = (int) (Math.random() * 21);
//                                        if (MapGame[randomplayer1][1] == "") {
//                                            MapGame[randomplayer1][1] = "#";
//                                            randomNum1player2 = randomplayer1;
//                                            break;
//                                        }
//                                    }
//                                    while (true) {
//                                        int randomplayer2 = (int) (Math.random() * 21);
//                                        if (MapGame[randomplayer2][1] == "") {
//                                            MapGame[randomplayer2][1] = "#";
//                                            randomNumplayer1 = randomplayer2;
//                                            break;
//                                        }
//                                    }
//                                    Random random0 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random0.nextInt(Namecard.size());
//                                    cardRand = Namecard1.get(randomIndex3);
//                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand2;
//                                    play2 = false;
//                                    play1 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("CardWeakner")) {
//                                    ArrayList<Integer> rend = new ArrayList<>();
//                                    ArrayList<Integer> Weakner = new ArrayList<>();
//                                    for (int i = 0; i < 5; i++) {
//                                        if (Card.CheckName(CardsPlayer1[i])) {
//                                            Weakner.add(i);
//                                        }
//                                    }
//                                    if (Weakner.size() > 1) {
//                                        Random random21 = new Random();
//                                        while (rend.size() < 2) {
//                                            int randomIndex = random21.nextInt(Weakner.size());
//                                            rend.add(Weakner.get(randomIndex));
//                                        }
//                                        CardsAttackPlayer1[rend.get(0)] -= 3;
//                                        CardsDamagePlayer1[rend.get(1)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer1[rend.get(1)]).getDuration());
//                                    }
//                                    if (Weakner.size() == 1) {
//                                        Random random31 = new Random();
//                                        int randomIndex = random31.nextInt(2);
//                                        if (randomIndex == 0) {
//                                            CardsAttackPlayer1[Weakner.get(0)] -= 3;
//                                        }
//                                        if (randomIndex == 1) {
//                                            CardsDamagePlayer1[Weakner.get(0)] -= Integer.parseInt(Card.returnCardbyName(CardsPlayer1[rend.get(1)]).getDuration());
//                                        }
//                                    }
//                                    if (Weakner.size() == 0) {
//                                    }
//                                    Random random03 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex3 = random03.nextInt(Namecard1.size());
//                                    cardRand = Namecard1.get(randomIndex3);
//                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand2;
//                                    play2 = false;
//                                    play1 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("PowerBosster")) {
//                                    Random random03 = new Random();
//                                    int randomIndex3 = random03.nextInt(CardLoca);
//
//                                    for (int i = 0; i < 21; i++) {
//                                        if (CardLocation[i][0] == randomIndex3) {
//                                            Damageplayer[i][0] += 3;
//                                            Player2Damage += 3;
//                                        }
//                                    }
//                                    Random random04 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex4 = random04.nextInt(Namecard1.size());
//                                    cardRand = Namecard1.get(randomIndex4);
//                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand2;
//                                    play2 = false;
//                                    play1 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("Copycard")) {
//                                    String copy = "";
//                                    while (true) {
//                                        System.out.println("please enter the desired Card number for the copy !");
//                                        String NUM = input.nextLine();
//                                        if (!NUM.equals("1") && !NUM.equals("2") && !NUM.equals("3") && !NUM.equals("4") && !NUM.equals("5")) {
//                                            System.out.println("please enter a number between 1 and 5 !");
//                                        } else {
//                                            copy = NUM;
//                                            break;
//                                        }
//                                    }
//                                    CardsPlayer2[5] = CardsPlayer2[Integer.parseInt(copy) - 1];
//                                    CardsAttackPlayer2[5] = CardsAttackPlayer2[Integer.parseInt(copy) - 1];
//                                    CardsDamagePlayer2[5] = CardsDamagePlayer2[Integer.parseInt(copy) - 1];
//                                    CardsCopy6player2 = 1;
//
//                                    Random random04 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex4 = random04.nextInt(Namecard1.size());
//                                    cardRand = Namecard1.get(randomIndex4);
//                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand2;
//                                    play2 = false;
//                                    play1 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("RemoveCard")) {
//                                    if (CardsCopy6player2 == 1) {
//                                        System.out.println("you can not use this Card");
//                                        continue;
//                                    } else {
//                                        Random random2=new Random();
//                                        int cin=random2.nextInt(5);
//                                        CardsPlayer2[5]=CardsPlayer1[cin];
//                                        CardsAttackPlayer2[5]=CardsAttackPlayer1[cin];
//                                        CardsDamagePlayer2[5]=CardsDamagePlayer1[cin];
//                                        CardsCopy6player2=1;
//                                        CardsPlayer1[cin]="";
//                                        CardsAttackPlayer1[cin]=0;
//                                        CardsDamagePlayer1[cin]=0;
//                                    }
//                                    /////////////////////////
//                                    Random random05 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex4 = random05.nextInt(Namecard1.size());
//                                    cardRand = Namecard1.get(randomIndex4);
//                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand2;
//                                    play2 = false;
//                                    play1 = true;
//                                }
//                                if (SpecialCard.returnSpecialbyName(CardsPlayer2[Integer.parseInt(num) - 1]).getNameCard().equals("HiddenCard")) {
//                                    HiddenCardPlayer1=1;
//                                    String a=CardsPlayer1[0];
//                                    String b=CardsPlayer1[1];
//                                    String c=CardsPlayer1[2];
//                                    String d=CardsPlayer1[3];
//                                    String e=CardsPlayer1[4];
//                                    CardsPlayer1[0]=d;
//                                    CardsPlayer1[1]=c;
//                                    CardsPlayer1[2]=b;
//                                    CardsPlayer1[3]=e;
//                                    CardsPlayer1[4]=a;
//                                    timeHiddenplayer1=numRand1;
//                                    Random random05 = new Random();
//                                    String cardRand = "";
//                                    int randomIndex4 = random05.nextInt(Namecard1.size());
//                                    cardRand = Namecard1.get(randomIndex4);
//                                    CardsPlayer2[Integer.parseInt(num) - 1] = cardRand;
//                                    if (Card.CheckName(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getCardAttack());
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = Integer.parseInt(Card.returnCardbyName(cardRand).getPlayerDamage());
//                                    }
//                                    if (SpecialCard.Checkname(cardRand)) {
//                                        CardsAttackPlayer2[Integer.parseInt(num) - 1] = 0;
//                                        CardsDamagePlayer2[Integer.parseInt(num) - 1] = 0;
//                                    }
//                                    --numRand2;
//                                    play2 = false;
//                                    play1 = true;
//                                }
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//            if (true) {
//                    System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "rand 1", "rand 2");
//                    System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", numRand1, numRand2);
//                    System.out.println();
//                    System.out.printf("%-20s %-25s  %-25s %-20s%n", "", "", "1-", "2-");
//                    System.out.println();
//                    for (int i = 0; i < 21; i++) {
//                        String CardPlayer1 = "";
//                        String CardPlayer2 = "";
//                        String CardFeaturePlayer1 = "";
//                        String CardFeaturePlayer2 = "";
//                        String tab = "";
//                        if (i >= 0 && i <= 8) {
//                            tab = "    ";
//                        }
//                        if (i > 8) {
//                            tab = "     ";
//                        }
//                        String HP1 = "";
//                        String HP2 = "";
//                        String Nameplayer1 = "";
//                        String Nameplayer2 = "";
//                        if (i == 8) {
//                            CardPlayer1 = "1- " + CardsPlayer1[0];
//                            CardPlayer2 = "1- " + CardsPlayer2[0];
//                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[0],CardsAttackPlayer1[0],CardsDamagePlayer1[0]);
//                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[0],CardsAttackPlayer2[0],CardsDamagePlayer2[0]);
//                        }
//                        if (i == 9) {
//                            CardPlayer1 = "2- " + CardsPlayer1[1];
//                            CardPlayer2 = "2- " + CardsPlayer2[1];
//                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[1],CardsAttackPlayer1[1],CardsDamagePlayer1[1]);
//                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[1],CardsAttackPlayer2[1],CardsDamagePlayer2[1]);
//                        }
//                        if (i == 10) {
//                            CardPlayer1 = "3- " + CardsPlayer1[2];
//                            CardPlayer2 = "3- " + CardsPlayer2[2];
//                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[2],CardsAttackPlayer1[2],CardsDamagePlayer1[2]);
//                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[2],CardsAttackPlayer2[2],CardsDamagePlayer2[2]);
//                            Nameplayer1 = "gamer 1 :" + loginedUser.getCharecter();
//                            Nameplayer2 = "gamer 2 :" + loginedUser1.getCharecter();
//                            HP1 = "Hp player1 :" + HpPlayer1;
//                            HP2 = "Hp player2 :" + HpPlayer2;
//                        }
//                        if (i == 11) {
//                            CardPlayer1 = "4- " + CardsPlayer1[3];
//                            CardPlayer2 = "4- " + CardsPlayer2[3];
//                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[3],CardsAttackPlayer1[3],CardsDamagePlayer1[3]);
//                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[3],CardsAttackPlayer2[3],CardsDamagePlayer2[3]);
//                        }
//                        if (i == 12) {
//                            CardPlayer1 = "5- " + CardsPlayer1[4];
//                            CardPlayer2 = "5- " + CardsPlayer2[4];
//                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[4],CardsAttackPlayer1[4],CardsDamagePlayer1[4]);
//                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[4],CardsAttackPlayer2[4],CardsDamagePlayer2[4]);
//                        }
//                        if (i == 13&&CardsCopy6player1==1) {
//                            CardPlayer1 = "6- " + CardsPlayer1[5];
////                            CardPlayer2 = "6- " + CardsPlayer2[4];
//                            CardFeaturePlayer1 = GameTowPlayer.getCardFeauture(CardsPlayer1[5],CardsAttackPlayer1[5],CardsDamagePlayer1[5]);
////                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[4],CardsAttackPlayer2[4],CardsDamagePlayer2[4]);
//                        }
//                        if (i == 13&&CardsCopy6player2==1) {
//                            CardPlayer2 = "6- " + CardsPlayer2[5];
//                            CardFeaturePlayer2 = GameTowPlayer.getCardFeauture(CardsPlayer2[5],CardsAttackPlayer2[5],CardsDamagePlayer2[5]);
//                        }
//                        if (HiddenCardPlayer1==1) {
//                            String[]space=CardPlayer1.split(" ");
//                            CardPlayer1=space[0];
//                            CardFeaturePlayer1="";
//                        }
//                        if (HiddenCardPlayer2==1) {
//                            String[]space=CardPlayer2.split(" ");
//                            CardPlayer2=space[0];
//                            CardFeaturePlayer2="";
//                        }
//
//                        System.out.printf("%-20s %-25s %-25s %-25s %-25s %-25s%n", Nameplayer1, CardPlayer1, (i + 1) + "-  " + MapGame[i][0], MapGame[i][1], CardPlayer2, Nameplayer2);
//                        Nameplayer1 = "";
//                        Nameplayer2 = "";
//                        CardPlayer1 = "";
//                        CardPlayer2 = "";
//                        System.out.printf("%-20s %-25s %-25s %-25s %-25s %-25s", HP1, "   " + CardFeaturePlayer1, tab + GameTowPlayer.getCardFeauture1(MapGame[i][0], attack[i][0],Damageplayer[i][0]) ,
//                                GameTowPlayer.getCardFeauture1(MapGame[i][1],attack[i][0],Damageplayer[i][0]), "   " + CardFeaturePlayer2, HP2);
//                        System.out.println();
//                        System.out.println();
//                    }
//                    System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", "player damage 1", "player damage 2");
//                    System.out.printf("%-20s %-25s %-25s %-20s%n", "", "", Player1Damage, Player2Damage);
//                    System.out.println();
//                    }
