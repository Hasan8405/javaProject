package CityWars;

import java.util.Random;
import java.util.Scanner;

public class GameTowPlayer {

private User user;
private User userharif;
    public GameTowPlayer(User user, User userharif) {
        this.user = user;
        this.userharif=userharif;
    }


    public static String getPlayerDamage(String name){
               double x= Double.parseDouble(Card.returnCardbyName(name).getPlayerDamage())/Double.parseDouble(Card.returnCardbyName(name).getDuration());
            return Double.toString(x);
    }
public static String getCardFeauture1(String name,double cardAttack,double Damage){
    if (Card.returnCardbyName(name)!=null) {
        String car="";
        if (Card.returnCardbyName(name).getCharec().equals("Alfa")) {
            car="A";
        }
        if (Card.returnCardbyName(name).getCharec().equals("Beta")) {
            car="B";
        }
        if (Card.returnCardbyName(name).getCharec().equals("Tao")) {
            car="T";
        }
        if (Card.returnCardbyName(name).getCharec().equals("Leon")) {
            car="L";
        }
//        double x=Damage/Double.parseDouble(Card.returnCardbyName(name).getDuration());
        return "H,A:"+(int)cardAttack+",D:1"+",P:"+(int)Damage
                +",C:"+car;
    }
    if (SpecialCard.returnSpecialbyName(name)!=null) {
        return "S";
    }
        return "";
}
    public static Card getCardWithName(String name, String[] array){
     return Card.returnCardbyName(array[Integer.parseInt(name)-1]);
    }
    public static String getNamebynum(String num,String[] array){
            return array[Integer.parseInt(num)-1];
    }
    public static boolean CheckTheSelectCardplayer1(String num,String lenght,String[] array,String[][]Map){
        int x=Integer.parseInt(lenght)+Integer.parseInt(getCardWithName(num,array).getDuration())-1;
        for (int i = Integer.parseInt(lenght)-1; i <x ; i++) {
            if (!Map[i][0].equals("")) {
                return true;
            }
        }
        return false;
    }

    public static boolean CheckTheSelectCardplayer2(String num,String lenght,String[] array,String[][]Map){
        int x=Integer.parseInt(lenght)+Integer.parseInt(getCardWithName(num,array).getDuration())-1;
        for (int i = Integer.parseInt(lenght)-1; i <x ; i++) {
            if (!Map[i][1].equals("")) {
                return true;
            }
        }
        return false;
    }

    public static boolean CheckTheSelectSpecialCard(String lenght,String[][]Map){
            if (!Map[Integer.parseInt(lenght)-1][0].equals("")) {
                return true;
            }
        return false;
    }
    public static String getCardFeauture(String name,double attack,double  Damage){
        if (Card.returnCardbyName(name)!=null) {
            String car="";
            if (Card.returnCardbyName(name).getCharec().equals("Alfa")) {
                car="A";
            }
            if (Card.returnCardbyName(name).getCharec().equals("Beta")) {
                car="B";
            }
            if (Card.returnCardbyName(name).getCharec().equals("Tao")) {
                car="T";
            }
            if (Card.returnCardbyName(name).getCharec().equals("Leon")) {
                car="L";
            }
            return "H,A:"+(int)attack+",D:"+ Card.returnCardbyName(name).getDuration()+",P:"+(int)Damage
                    +",C:"+car;
        }
        if (SpecialCard.returnSpecialbyName(name)!=null) {
            return "S";
        }
        return "";
    }
    public static void SelectCharacter(User user, String num, Scanner input){
        while (true){
            System.out.println("please select character "+num+" player !");
            String nameChar=input.nextLine();
            if (Char.returnCharByName(nameChar)==null) {
                System.out.println("no exist this character !");
            }
            else {
                user.setCharecter(Char.returnCharByName(nameChar).getName());
                System.out.println("first player you are character "+ Char.returnCharByName(nameChar).getName());
                break;
            }
        }
    }
//    public static void BettingGame(Scanner input)
    public static Integer CharChargetScore(String char1,String char2,Integer duration){
        if (char1.equals("Leon")&&char2.equals("Alfa")||char2.equals("Leon")&&char1.equals("Alfa")) {
            Random random=new Random();
            int r=random.nextInt(3);
            if (r!=0) {
                return duration;
            }
            if (r == 0) {
                return 0;
            }
        }
        if (char1.equals("Leon")&&char2.equals("Beta")||char2.equals("Leon")&&char1.equals("Beta")) {
            Random random=new Random();
            int r=random.nextInt(4);
            if (r==0) {
                return duration;
            }
            if (r != 0) {
                return 0;
            }
        }
        if (char1.equals("Leon")&&char2.equals("Tao")||char2.equals("Leon")&&char1.equals("Tao")) {
            Random random=new Random();
            int r=random.nextInt(2);
            if (r==0) {
                return duration;
            }
            if (r != 0) {
                return 0;
            }
        }
        if (char1.equals("Alfa")&&char2.equals("Beta")||char2.equals("Alfa")&&char1.equals("Beta")) {
            Random random=new Random();
            int r=random.nextInt(10);
            if (r!=0) {
                return duration;
            }
            if (r == 0) {
                return 0;
            }
        }
        if (char1.equals("Alfa")&&char2.equals("Tao")||char2.equals("Alfa")&&char1.equals("Tao")) {
            Random random=new Random();
            int r=random.nextInt(6);
            if (r==0) {
                return duration;
            }
            if (r != 0) {
                return 0;
            }
        }
        if (char1.equals("Tao")&&char2.equals("Beta")||char2.equals("Tao")&&char1.equals("Beta")) {
            Random random=new Random();
            int r=random.nextInt(4);
            if (r!=0) {
                return duration;
            }
            if (r == 0) {
                return 0;
            }
        }
        return 0;
    }
}
