package citywars.finalproject.Controller;

import citywars.finalproject.Model.Card;
import citywars.finalproject.Model.SpecialCard;
import citywars.finalproject.Model.UserSession;
import citywars.finalproject.Model.UserSession2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TwoPlayerGame {
    @FXML
    public ImageView characterplayer1;
    @FXML
    public ImageView characterplayer2;
    /////////////////////////////////////
    @FXML
    public ImageView p2card1;
    public double Xp2card1;
    public double Yp2card1;
    @FXML
    public ImageView p2card2;
    public double Xp2card2;
    public double Yp2card2;
    @FXML
    public ImageView p2card3;
    public double Xp2card3;
    public double Yp2card3;
    @FXML
    public ImageView p2card4;
    public double Xp2card4;
    public double Yp2card4;
    @FXML
    public ImageView p2card5;
    public double Xp2card5;
    public double Yp2card5;
    @FXML
    public ImageView p1card1;
    public double Xp1card1;
    public double Yp1card1;
    @FXML
    public ImageView p1card2;
    public double Xp1card2;
    public double Yp1card2;
    @FXML
    public ImageView p1card3;
    public double Xp1card3;
    public double Yp1card3;
    @FXML
    public ImageView p1card4;
    public double Xp1card4;
    public double Yp1card4;
    @FXML
    public ImageView p1card5;
    public double Xp1card5;
    public double Yp1card5;
    @FXML
    public ImageView viewCard;
    @FXML
    public ImageView background;
    //////////////////////////////////
    @FXML
    public javafx.scene.control.Label runplay2;
    @FXML
    public Label runplay1;
    @FXML
    public  Label damage1;
    @FXML
    public  Label damage2;
    @FXML
    public  Label HPplayer1;
    @FXML
    public  Label HPplayer2;
    @FXML
    public Label rund;
    public int numrund = 1;
    @FXML
    public Label turn;
    ///////////////////////
    @FXML
    public Rectangle p21;
    @FXML
    public Label p21attack;
    @FXML
    public Label p21damage;
    @FXML
    public Rectangle p22;
    @FXML
    public Label p22attack;
    @FXML
    public Label p22damage;
    @FXML
    public Rectangle p23;
    @FXML
    public Label p23attack;
    @FXML
    public Label p23damage;
    @FXML
    public Rectangle p24;
    @FXML
    public Label p24attack;
    @FXML
    public Label p24damage;
    @FXML
    public Rectangle p25;
    @FXML
    public Label p25attack;
    @FXML
    public Label p25damage;
    @FXML
    public Rectangle p26;
    @FXML
    public Label p26attack;
    @FXML
    public Label p26damage;
    @FXML
    public Rectangle p27;
    @FXML
    public Label p27attack;
    @FXML
    public Label p27damage;
    @FXML
    public Rectangle p28;
    @FXML
    public Label p28attack;
    @FXML
    public Label p28damage;
    @FXML
    public Rectangle p29;
    @FXML
    public Label p29attack;
    @FXML
    public Label p29damage;
    @FXML
    public Rectangle p210;
    @FXML
    public Label p210attack;
    @FXML
    public Label p210damage;
    @FXML
    public Rectangle p211;
    @FXML
    public Label p211attack;
    @FXML
    public Label p211damage;
    @FXML
    public Rectangle p212;
    @FXML
    public Label p212attack;
    @FXML
    public Label p212damage;
    @FXML
    public Rectangle p213;
    @FXML
    public Label p213attack;
    @FXML
    public Label p213damage;
    @FXML
    public Rectangle p214;
    @FXML
    public Label p214attack;
    @FXML
    public Label p214damage;
    @FXML
    public Rectangle p215;
    @FXML
    public Label p215attack;
    @FXML
    public Label p215damage;
    @FXML
    public Rectangle p216;
    @FXML
    public Label p216attack;
    @FXML
    public Label p216damage;
    @FXML
    public Rectangle p217;
    @FXML
    public Label p217attack;
    @FXML
    public Label p217damage;
    @FXML
    public Rectangle p11;
    @FXML
    public Label p11attack;
    @FXML
    public Label p11damage;
    @FXML
    public Rectangle p12;
    @FXML
    public Label p12attack;
    @FXML
    public Label p12damage;
    @FXML
    public Rectangle p13;
    @FXML
    public Label p13attack;
    @FXML
    public Label p13damage;
    @FXML
    public Rectangle p14;
    @FXML
    public Label p14attack;
    @FXML
    public Label p14damage;
    @FXML
    public Rectangle p15;
    @FXML
    public Label p15attack;
    @FXML
    public Label p15damage;
    @FXML
    public Rectangle p16;
    @FXML
    public Label p16attack;
    @FXML
    public Label p16damage;
    @FXML
    public Rectangle p17;
    @FXML
    public Label p17attack;
    @FXML
    public Label p17damage;
    @FXML
    public Rectangle p18;
    @FXML
    public Label p18attack;
    @FXML
    public Label p18damage;
    @FXML
    public Rectangle p19;
    @FXML
    public Label p19attack;
    @FXML
    public Label p19damage;
    @FXML
    public Rectangle p110;
    @FXML
    public Label p110attack;
    @FXML
    public Label p110damage;
    @FXML
    public Rectangle p111;
    @FXML
    public Label p111attack;
    @FXML
    public Label p111damage;
    @FXML
    public Rectangle p112;
    @FXML
    public Label p112attack;
    @FXML
    public Label p112damage;
    @FXML
    public Rectangle p113;
    @FXML
    public Label p113attack;
    @FXML
    public Label p113damage;
    @FXML
    public Rectangle p114;
    @FXML
    public Label p114attack;
    @FXML
    public Label p114damage;
    @FXML
    public Rectangle p115;
    @FXML
    public Label p115attack;
    @FXML
    public Label p115damage;
    @FXML
    public Rectangle p116;
    @FXML
    public Label p116attack;
    @FXML
    public Label p116damage;
    @FXML
    public Rectangle p117;
    @FXML
    public Label p117attack;
    @FXML
    public Label p117damage;
    @FXML
    public Rectangle timelin;
    @FXML
    public ProgressBar progress;
    ///////////////////////
    public int run1 = 1;
    public int run2 = 1;
    public int damagep1 = 0;
    public int damagep2 = 0;
    public UserSession userSession1;
    public UserSession2 userSession2;
   public String[]CardsPlayer1=new String[5];
    public int[]CardsAttackPlayer1=new int[5];
    public int[]CardsDamagePlayer1=new int[5];
    public String[]CardsPlayer2=new String[5];
  public   int[]CardsAttackPlayer2=new int[5];
    public int[]CardsDamagePlayer2=new int[5];
   public  String [][] MapGame=new String[2][17];
   public int[][]Damageplayer=new int[2][17];
    public static int[][]attack=new int[2][17];
    public  int Player1Damage=0;
    public  int Hpp1=0;
    public int Hpp2=0;
    public boolean player1;
    public boolean player2;
    public    int Player2Damage=0;
    public void initialize() {
        StartGame();
        Cavity();
        FillDeck();
        SetXYCardDeck();
        Hpp1=userSession1.getHp();
        Hpp2=userSession2.getHp();
    }
public void viewCard(MouseEvent mouseEvent)throws IOException {
        viewCard.setImage(null);
}
     int x=0;
    double X;
    double Y;
    double X1;
    double Y1;
    double X2;
    double Y2;
    double X3;
    double Y3;
    double X4;
    double Y4;
    double X5;
    double Y5;
    double X6;
    double Y6;
    double X7;
    double Y7;
    double X8;
    double Y8;
    double X9;
    double Y9;
    int numRectangle=-1;
    public void p1card1(MouseEvent mouseEvent) {
        if (player1) {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            p1card1.setX(mouseX - p1card1.getFitWidth() / 2);
            p1card1.setY(mouseY - p1card1.getFitHeight() / 2);
        }
    }
    public void card1p1(MouseEvent mouseEvent)throws IOException {
        X=mouseEvent.getX();
        Y=mouseEvent.getY();
        Handle(p1card1,CardsPlayer1[0]);
        if (x!=0&&X>-104&&X<-59&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],1,1,MapGame)){
            ifHandle(0,0,p1card1);
        }
        else if (x!=0&&X>-59&&X<-14&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],2,1,MapGame)){
            ifHandle(1,0,p1card1);
        }
        else if (x!=0&&X>-14&&X<31&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],3,1,MapGame)) {ifHandle(2,0,p1card1);}
        else if (x!=0&&X>31&&X<79&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],4,1,MapGame)) {ifHandle(3,0,p1card1);}
        else if (x!=0&&X>79&&X<130&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],5,1,MapGame)) {ifHandle(4,0,p1card1);}
        else if (x!=0&&X>130&&X<181&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],6,1,MapGame)) {ifHandle(5,0,p1card1);}
        else if (x!=0&&X>181&&X<228&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],7,1,MapGame)) {ifHandle(6,0,p1card1);}
        else if (x!=0&&X>228&&X<278&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],8,1,MapGame)){ifHandle(7,0,p1card1);}
        else if (x!=0&&X>278&&X<330&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],9,1,MapGame)) {ifHandle(8,0,p1card1);}
        else if (x!=0&&X>330&&X<381&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],10,1,MapGame)) {ifHandle(9,0,p1card1);}
        else if (x!=0&&X>381&&X<429&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],11,1,MapGame)) {ifHandle(10,0,p1card1);}
        else if (x!=0&&X>429&&X<480&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],12,1,MapGame)) {ifHandle(11,0,p1card1);}
        else if (x!=0&&X>480&&X<528&&Y>-169&&Y<-13&&Check(CardsPlayer1[0],13,1,MapGame)) {ifHandle(12,0,p1card1);}
        else if (x!=0&&X>528&&X<580&&Y>-169&&Y<-13&&(Card.returnCardbyName(CardsPlayer1[0]).getDuration()!=5)&&Check(CardsPlayer1[0],14,1,MapGame)) {ifHandle(13,0,p1card1);}
        else if (x!=0&&X>580&&X<630&&Y>-169&&Y<-13&&(Card.returnCardbyName(CardsPlayer1[0]).getDuration()!=4)&&Card.returnCardbyName(CardsPlayer1[0]).getDuration()!=5&&Check(CardsPlayer1[0],15,1,MapGame)){ifHandle(14,0,p1card1);}
        else if (x!=0&&X>630&&X<680&&Y>-169&&Y<-13&&(Card.returnCardbyName(CardsPlayer1[0]).getDuration()==1)||Card.returnCardbyName(CardsPlayer1[0]).getDuration()==2&&Check(CardsPlayer1[0],16,1,MapGame)) {ifHandle(15,0,p1card1);}
        else if (x!=0&&X>680&&X<729&&Y>-169&&Y<-13&&Card.returnCardbyName(CardsPlayer1[0]).getDuration()==1&&Check(CardsPlayer1[0],17,1,MapGame)){ifHandle(16,0,p1card1);}
        else {
          elseHandle(p1card1);
        }
    }
    public void p1card2(MouseEvent mouseEvent) {
        if (player1) {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            p1card2.setX(mouseX - p1card2.getFitWidth() / 2);
            p1card2.setY(mouseY - p1card2.getFitHeight() / 2);
        }
}
    public void card2p1(MouseEvent mouseEvent)throws IOException {
    X1=mouseEvent.getX();
    Y1=mouseEvent.getY();
    Handle(p1card2,CardsPlayer1[1]);
        if (x!=0&&X1>-260&&X1<-218&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],1,1,MapGame)){ifHandle(0,1,p1card2);}
        else if (x!=0&&X1>-218&&X1<-167&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],2,1,MapGame)){ifHandle(1,1,p1card2);}
        else if (x!=0&&X1>-167&&X1<-120&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],3,1,MapGame)) {ifHandle(2,1,p1card2);}
        else if (x!=0&&X1>-120&&X1<-73&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],4,1,MapGame)) {ifHandle(3,1,p1card2);}
        else if (x!=0&&X1>-73&&X1<-20&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],5,1,MapGame)) {ifHandle(4,1,p1card2);}
        else if (x!=0&&X1>-20&&X1<27&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],6,1,MapGame)) {ifHandle(5,1,p1card2);}
        else if (x!=0&&X1>27&&X1<78&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],7,1,MapGame)) {ifHandle(6,1,p1card2);}
        else if (x!=0&&X1>78&&X1<124&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],8,1,MapGame)){ifHandle(7,1,p1card2);}
        else if (x!=0&&X1>124&&X1<179&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],9,1,MapGame)) {ifHandle(8,1,p1card2);}
        else if (x!=0&&X1>179&&X1<228&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],10,1,MapGame)) {ifHandle(9,1,p1card2);}
        else if (x!=0&&X1>228&&X1<272&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],11,1,MapGame)) {ifHandle(10,1,p1card2);}
        else if (x!=0&&X1>272&&X1<323&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],12,1,MapGame)) {ifHandle(11,1,p1card2);}
        else if (x!=0&&X1>323&&X1<371&&Y1>-169&&Y1<-13&&Check(CardsPlayer1[1],13,1,MapGame)) {ifHandle(12,1,p1card2);}
        else if (x!=0&&X1>371&&X1<422&&Y1>-169&&Y1<-13&&(Card.returnCardbyName(CardsPlayer1[1]).getDuration()!=5)&&Check(CardsPlayer1[1],14,1,MapGame)) {ifHandle(13,1,p1card2);}
        else if (x!=0&&X1>422&&X1<468&&Y1>-169&&Y1<-13&&(Card.returnCardbyName(CardsPlayer1[1]).getDuration()!=4)&&Card.returnCardbyName(CardsPlayer1[1]).getDuration()!=5&&Check(CardsPlayer1[1],15,1,MapGame)){ifHandle(14,1,p1card2);}
        else if (x!=0&&X1>468&&X1<523&&Y1>-169&&Y1<-13&&(Card.returnCardbyName(CardsPlayer1[1]).getDuration()==1)||Card.returnCardbyName(CardsPlayer1[1]).getDuration()==2&&Check(CardsPlayer1[1],16,1,MapGame)) {ifHandle(15,1,p1card2);}
        else if (x!=0&&X1>523&&X1<574&&Y1>-169&&Y1<-13&&Card.returnCardbyName(CardsPlayer1[1]).getDuration()==1&&Check(CardsPlayer1[1],17,1,MapGame)){ifHandle(16,1,p1card2);}
        else {
            elseHandle(p1card2);
        }
}
    public void p1card3(MouseEvent mouseEvent) {
        if (player1) {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            p1card3.setX(mouseX - p1card3.getFitWidth() / 2);
            p1card3.setY(mouseY - p1card3.getFitHeight() / 2);
        }
    }
    public void card3p1(MouseEvent mouseEvent)throws IOException {
        X2=mouseEvent.getX();
        Y2=mouseEvent.getY();
        Handle(p1card3,CardsPlayer1[2]);
        if (x!=0&&X2>-413&&X2<-369&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],1,1,MapGame)){ifHandle(0,2,p1card3);}
        else if (x!=0&&X2>-369&&X2<-324&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],2,1,MapGame)){ifHandle(1,2,p1card3);}
        else if (x!=0&&X2>-324&&X2<-272&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],3,1,MapGame)) {ifHandle(2,2,p1card3);}
        else if (x!=0&&X2>-272&&X2<-224&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],4,1,MapGame)) {ifHandle(3,2,p1card3);}
        else if (x!=0&&X2>-224&&X2<-174&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],5,1,MapGame)) {ifHandle(4,2,p1card3);}
        else if (x!=0&&X2>-174&&X2<-126&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],6,1,MapGame)) {ifHandle(5,2,p1card3);}
        else if (x!=0&&X2>-126&&X2<-75&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],7,1,MapGame)) {ifHandle(6,2,p1card3);}
        else if (x!=0&&X2>-75&&X2<-25&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],8,1,MapGame)){ifHandle(7,2,p1card3);}
        else if (x!=0&&X2>-25&&X2<27&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],9,1,MapGame)) {ifHandle(8,2,p1card3);}
        else if (x!=0&&X2>27&&X2<79&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],10,1,MapGame)) {ifHandle(9,2,p1card3);}
        else if (x!=0&&X2>79&&X2<125&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],11,1,MapGame)) {ifHandle(10,2,p1card3);}
        else if (x!=0&&X2>125&&X2<174&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],12,1,MapGame)) {ifHandle(11,2,p1card3);}
        else if (x!=0&&X2>174&&X2<223&&Y2>-169&&Y2<-13&&Check(CardsPlayer1[2],13,1,MapGame)) {ifHandle(12,2,p1card3);}
        else if (x!=0&&X2>223&&X2<275&&Y2>-169&&Y2<-13&&(Card.returnCardbyName(CardsPlayer1[2]).getDuration()!=5)&&Check(CardsPlayer1[2],14,1,MapGame)) {ifHandle(13,2,p1card3);}
        else if (x!=0&&X2>275&&X2<320&&Y2>-169&&Y2<-13&&(Card.returnCardbyName(CardsPlayer1[2]).getDuration()!=4)&&Card.returnCardbyName(CardsPlayer1[2]).getDuration()!=5&&Check(CardsPlayer1[2],15,1,MapGame)){ifHandle(14,2,p1card3);}
        else if (x!=0&&X2>320&&X2<371&&Y2>-169&&Y2<-13&&(Card.returnCardbyName(CardsPlayer1[2]).getDuration()==1)||Card.returnCardbyName(CardsPlayer1[2]).getDuration()==2&&Check(CardsPlayer1[2],16,1,MapGame)) {ifHandle(15,2,p1card3);}
        else if (x!=0&&X2>371&&X2<421&&Y2>-169&&Y2<-13&&Card.returnCardbyName(CardsPlayer1[2]).getDuration()==1&&Check(CardsPlayer1[2],17,1,MapGame)){ifHandle(16,2,p1card3);}
        else {
            elseHandle(p1card3);
        }
    }
    public void p1card4(MouseEvent mouseEvent) {
        if (player1) {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            p1card4.setX(mouseX - p1card4.getFitWidth() / 2);
            p1card4.setY(mouseY - p1card4.getFitHeight() / 2);
        }
    }
    public void card4p1(MouseEvent mouseEvent)throws IOException {
        X3=mouseEvent.getX();
        Y3=mouseEvent.getY();
        Handle(p1card4,CardsPlayer1[3]);
        if (x!=0&&X3>-561&&X3<-514&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],1,1,MapGame)){ifHandle(0,3,p1card4);}
        else if (x!=0&&X3>-514&&X3<-465&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],2,1,MapGame)){ifHandle(1,3,p1card4);}
        else if (x!=0&&X3>-465&&X3<-417&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],3,1,MapGame)) {ifHandle(2,3,p1card4);}
        else if (x!=0&&X3>-417&&X3<-368&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[2],4,1,MapGame)) {ifHandle(3,3,p1card4);}
        else if (x!=0&&X3>-368&&X3<-320&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],5,1,MapGame)) {ifHandle(4,3,p1card4);}
        else if (x!=0&&X3>-320&&X3<-267&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],6,1,MapGame)) {ifHandle(5,3,p1card4);}
        else if (x!=0&&X3>-267&&X3<-215&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],7,1,MapGame)) {ifHandle(6,3,p1card4);}
        else if (x!=0&&X3>-215&X3<-167&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],8,1,MapGame)){ifHandle(7,3,p1card4);}
        else if (x!=0&&X3>-167&&X3<-118&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],9,1,MapGame)) {ifHandle(8,3,p1card4);}
        else if (x!=0&&X3>-118&&X3<-70&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],10,1,MapGame)) {ifHandle(9,3,p1card4);}
        else if (x!=0&&X3>-70&&X3<-20&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],11,1,MapGame)) {ifHandle(10,3,p1card4);}
        else if (x!=0&&X3>-20&&X3<30&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],12,1,MapGame)) {ifHandle(11,3,p1card4);}
        else if (x!=0&&X3>30&&X3<77&&Y3>-169&&Y3<-13&&Check(CardsPlayer1[3],13,1,MapGame)) {ifHandle(12,3,p1card4);}
        else if (x!=0&&X3>77&&X3<130&&Y3>-169&&Y3<-13&&(Card.returnCardbyName(CardsPlayer1[3]).getDuration()!=5)&&Check(CardsPlayer1[3],14,1,MapGame)) {ifHandle(13,3,p1card4);}
        else if (x!=0&&X3>130&&X3<181&&Y3>-169&&Y3<-13&&(Card.returnCardbyName(CardsPlayer1[3]).getDuration()!=4)&&Card.returnCardbyName(CardsPlayer1[3]).getDuration()!=5&&Check(CardsPlayer1[3],15,1,MapGame)){ifHandle(14,3,p1card4);}
        else if (x!=0&&X3>181&&X3<224&&Y3>-169&&Y3<-13&&(Card.returnCardbyName(CardsPlayer1[3]).getDuration()==1)||Card.returnCardbyName(CardsPlayer1[3]).getDuration()==2&&Check(CardsPlayer1[3],16,1,MapGame)) {ifHandle(15,3,p1card4);}
        else if (x!=0&&X3>224&&X3<280&&Y3>-169&&Y3<-13&&Card.returnCardbyName(CardsPlayer1[3]).getDuration()==1&&Check(CardsPlayer1[3],17,1,MapGame)){ifHandle(16,3,p1card4);}
        else {
            elseHandle(p1card4);
        }
    }
    public void p1card5(MouseEvent mouseEvent) {
        if (player1) {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            p1card5.setX(mouseX - p1card5.getFitWidth() / 2);
            p1card5.setY(mouseY - p1card5.getFitHeight() / 2);
        }
    }
    public void card5p1(MouseEvent mouseEvent)throws IOException {
        X4=mouseEvent.getX();
        Y4=mouseEvent.getY();
//        System.out.println("X2"+X4);
//        System.out.println("Y2"+Y4);
        Handle(p1card5,CardsPlayer1[4]);
        if (x!=0&&X4>-706&&X4<-666&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],1,1,MapGame)){ifHandle(0,4,p1card5);}
        else if (x!=0&&X4>-666&&X4<-617&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],2,1,MapGame)){ifHandle(1,4,p1card5);}
        else if (x!=0&&X4>-617&&X4<-569&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],3,1,MapGame)) {ifHandle(2,4,p1card5);}
        else if (x!=0&&X4>-569&&X4<-519&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],4,1,MapGame)) {ifHandle(3,4,p1card5);}
        else if (x!=0&&X4>-519&&X4<-469&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],5,1,MapGame)) {ifHandle(4,4,p1card5);}
        else if (x!=0&&X4>-469&&X4<-422&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],6,1,MapGame)) {ifHandle(5,4,p1card5);}
        else if (x!=0&&X4>-422&&X4<-369&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],7,1,MapGame)) {ifHandle(6,4,p1card5);}
        else if (x!=0&&X4>-369&X4<-320&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],8,1,MapGame)){ifHandle(7,4,p1card5);}
        else if (x!=0&&X4>-320&&X4<-270&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],9,1,MapGame)) {ifHandle(8,4,p1card5);}
        else if (x!=0&&X4>-270&&X4<-220&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],10,1,MapGame)) {ifHandle(9,4,p1card5);}
        else if (x!=0&&X4>-220&&X4<-170&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],11,1,MapGame)) {ifHandle(10,4,p1card5);}
        else if (x!=0&&X4>-170&&X4<-120&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],12,1,MapGame)) {ifHandle(11,4,p1card5);}
        else if (x!=0&&X4>-120&&X4<-70&&Y4>-169&&Y4<-13&&Check(CardsPlayer1[4],13,1,MapGame)) {ifHandle(12,4,p1card5);}
        else if (x!=0&&X4>-70&&X4<-20&&Y4>-169&&Y4<-13&&(Card.returnCardbyName(CardsPlayer1[4]).getDuration()!=5)&&Check(CardsPlayer1[4],14,1,MapGame)) {ifHandle(13,4,p1card5);}
        else if (x!=0&&X4>-20&&X4<26&&Y4>-169&&Y4<-13&&(Card.returnCardbyName(CardsPlayer1[4]).getDuration()!=4)&&Card.returnCardbyName(CardsPlayer1[4]).getDuration()!=5&&Check(CardsPlayer1[4],15,1,MapGame)){ifHandle(14,4,p1card5);}
        else if (x!=0&&X4>26&&X4<78&&Y4>-169&&Y4<-13&&(Card.returnCardbyName(CardsPlayer1[4]).getDuration()==1)||Card.returnCardbyName(CardsPlayer1[4]).getDuration()==2&&Check(CardsPlayer1[4],16,1,MapGame)) {ifHandle(15,4,p1card5);}
        else if (x!=0&&X4>78&&X4<122&&Y4>-169&&Y4<-13&&Card.returnCardbyName(CardsPlayer1[4]).getDuration()==1&&Check(CardsPlayer1[4],17,1,MapGame)){ifHandle(16,4,p1card5);}
        else {
            elseHandle(p1card5);
        }

    }
    public void p2card1(MouseEvent mouseEvent) {
        if (player2) {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            p2card1.setX(mouseX - p2card1.getFitWidth() / 2);
            p2card1.setY(mouseY - p2card1.getFitHeight() / 2);
        }
}
    public void card1p2(MouseEvent mouseEvent)throws IOException {
    X5=mouseEvent.getX();
    Y5=mouseEvent.getY();
    Handle(p2card1,CardsPlayer2[0]);
    if (x!=0&&X5>-107&&X5<-66&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],1,2,MapGame)){ifHandle1(0,0,p2card1);}
    else if (x!=0&&X5>-66&&X5<-18&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],2,2,MapGame)){ifHandle1(1,0,p2card1);}
    else if (x!=0&&X5>-18&&X5<32&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],3,2,MapGame)) {ifHandle1(2,0,p2card1);}
    else if (x!=0&&X5>32&&X5<82&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],4,2,MapGame)) {ifHandle1(3,0,p2card1);}
    else if (x!=0&&X5>82&&X5<130&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],5,2,MapGame)) {ifHandle1(4,0,p2card1);}
    else if (x!=0&&X5>130&&X5<180&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],6,2,MapGame)) {ifHandle1(5,0,p2card1);}
    else if (x!=0&&X5>180&&X5<230&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],7,2,MapGame)) {ifHandle1(6,0,p2card1);}
    else if (x!=0&&X5>230&X5<280&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],8,2,MapGame)){ifHandle1(7,0,p2card1);}
    else if (x!=0&&X5>280&&X5<330&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],9,2,MapGame)) {ifHandle1(8,0,p2card1);}
    else if (x!=0&&X5>330&&X5<380&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],10,2,MapGame)) {ifHandle1(9,0,p2card1);}
    else if (x!=0&&X5>380&&X5<430&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],11,2,MapGame)) {ifHandle1(10,0,p2card1);}
    else if (x!=0&&X5>430&&X5<480&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],12,2,MapGame)) {ifHandle1(11,0,p2card1);}
    else if (x!=0&&X5>480&&X5<530&&Y5>164&&Y5<316&&Check(CardsPlayer2[0],13,2,MapGame)) {ifHandle1(12,0,p2card1);}
    else if (x!=0&&X5>530&&X5<580&&Y5>164&&Y5<316&&(Card.returnCardbyName(CardsPlayer2[0]).getDuration()!=5)&&Check(CardsPlayer2[0],14,2,MapGame)) {ifHandle1(13,0,p2card1);}
    else if (x!=0&&X5>580&&X5<630&&Y5>164&&Y5<316&&(Card.returnCardbyName(CardsPlayer2[0]).getDuration()!=4)&&Card.returnCardbyName(CardsPlayer2[0]).getDuration()!=5&&Check(CardsPlayer2[0],15,2,MapGame)){ifHandle1(14,0,p2card1);}
    else if (x!=0&&X5>630&&X5<680&&Y5>164&&Y5<316&&(Card.returnCardbyName(CardsPlayer2[0]).getDuration()==1)||Card.returnCardbyName(CardsPlayer2[0]).getDuration()==2&&Check(CardsPlayer2[0],16,2,MapGame)) {ifHandle1(15,0,p2card1);}
    else if (x!=0&&X5>680&&X5<730&&Y5>164&&Y5<316&&Card.returnCardbyName(CardsPlayer2[0]).getDuration()==1&&Check(CardsPlayer2[0],17,2,MapGame)){ifHandle1(16,4,p2card1);}
    else {
        elseHandle(p2card1);
    }
}
    public void p2card2(MouseEvent mouseEvent) {
        if (player2) {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            p2card2.setX(mouseX - p2card2.getFitWidth() / 2);
            p2card2.setY(mouseY - p2card2.getFitHeight() / 2);
        }
    }
    public void card2p2(MouseEvent mouseEvent)throws IOException  {
        X6=mouseEvent.getX();
        Y6=mouseEvent.getY();
        Handle(p2card2,CardsPlayer2[1]);
        if (x!=0&&X6>-260&&X6<-213&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],1,2,MapGame)){ifHandle1(0,1,p2card2);}
        else if (x!=0&&X6>-213&&X6<-166&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],2,2,MapGame)){ifHandle1(1,1,p2card2);}
        else if (x!=0&&X6>-166&&X6<-114&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],3,2,MapGame)) {ifHandle1(2,1,p2card2);}
        else if (x!=0&&X6>-114&&X6<-66&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],4,2,MapGame)) {ifHandle1(3,1,p2card2);}
        else if (x!=0&&X6>-66&&X6<-18&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],5,2,MapGame)) {ifHandle1(4,1,p2card2);}
        else if (x!=0&&X6>-18&&X6<32&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],6,2,MapGame)) {ifHandle1(5,1,p2card2);}
        else if (x!=0&&X6>32&&X6<82&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],7,2,MapGame)) {ifHandle1(6,1,p2card2);}
        else if (x!=0&&X6>82&X6<130&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],8,2,MapGame)){ifHandle1(7,1,p2card2);}
        else if (x!=0&&X6>130&&X6<180&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],9,2,MapGame)) {ifHandle1(8,1,p2card2);}
        else if (x!=0&&X6>180&&X6<230&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],10,2,MapGame)) {ifHandle1(9,1,p2card2);}
        else if (x!=0&&X6>230&&X6<280&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],11,2,MapGame)) {ifHandle1(10,1,p2card2);}
        else if (x!=0&&X6>280&&X6<330&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],12,2,MapGame)) {ifHandle1(11,1,p2card2);}
        else if (x!=0&&X6>330&&X6<380&&Y6>164&&Y6<316&&Check(CardsPlayer2[1],13,2,MapGame)) {ifHandle1(12,1,p2card2);}
        else if (x!=0&&X6>380&&X6<425&&Y6>164&&Y6<316&&(Card.returnCardbyName(CardsPlayer2[1]).getDuration()!=5)&&Check(CardsPlayer2[1],14,2,MapGame)) {ifHandle1(13,1,p2card2);}
        else if (x!=0&&X6>425&&X6<475&&Y6>164&&Y6<316&&(Card.returnCardbyName(CardsPlayer2[1]).getDuration()!=4)&&Card.returnCardbyName(CardsPlayer2[1]).getDuration()!=5&&Check(CardsPlayer2[1],15,2,MapGame)){ifHandle1(14,1,p2card2);}
        else if (x!=0&&X6>475&&X6<530&&Y6>164&&Y6<316&&(Card.returnCardbyName(CardsPlayer2[1]).getDuration()==1)||Card.returnCardbyName(CardsPlayer2[1]).getDuration()==2&&Check(CardsPlayer2[1],16,2,MapGame)) {ifHandle1(15,1,p2card2);}
        else if (x!=0&&X6>530&&X6<575&&Y6>164&&Y6<316&&Card.returnCardbyName(CardsPlayer2[1]).getDuration()==1&&Check(CardsPlayer2[1],17,2,MapGame)){ifHandle1(16,1,p2card2);}
        else {
            elseHandle(p2card2);
        }
    }
    public void p2card3(MouseEvent mouseEvent) {
        if (player2) {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            p2card3.setX(mouseX - p2card3.getFitWidth() / 2);
            p2card3.setY(mouseY - p2card3.getFitHeight() / 2);
        }
    }
    public void card3p2(MouseEvent mouseEvent)throws IOException  {
        X7=mouseEvent.getX();
        Y7=mouseEvent.getY();
        System.out.println("X " +X7);
        System.out.println("Y "+Y7);
        Handle(p2card3,CardsPlayer2[2]);
        if (x!=0&&X7>-412&&X7<-367&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],1,2,MapGame)){ifHandle1(0,2,p2card3);}
        else if (x!=0&&X7>-367&&X7<-316&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],2,2,MapGame)){ifHandle1(1,2,p2card3);}
        else if (x!=0&&X7>-316&&X7<-268&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],3,2,MapGame)) {ifHandle1(2,2,p2card3);}
        else if (x!=0&&X7>-268&&X7<-220&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],4,2,MapGame)) {ifHandle1(3,2,p2card3);}
        else if (x!=0&&X7>-220&&X7<-168&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],5,2,MapGame)) {ifHandle1(4,2,p2card3);}
        else if (x!=0&&X7>-168&&X7<-120&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],6,2,MapGame)) {ifHandle1(5,2,p2card3);}
        else if (x!=0&&X7>-120&&X7<-71&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],7,2,MapGame)) {ifHandle1(6,2,p2card3);}
        else if (x!=0&&X7>-71&&X7<-20&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],8,2,MapGame)){ifHandle1(7,2,p2card3);}
        else if (x!=0&&X7>-20&&X7<31&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],9,2,MapGame)) {ifHandle1(8,2,p2card3);}
        else if (x!=0&&X7>31&&X7<81&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],10,2,MapGame)) {ifHandle1(9,2,p2card3);}
        else if (x!=0&&X7>81&&X7<128&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],11,2,MapGame)) {ifHandle1(10,2,p2card3);}
        else if (x!=0&&X7>128&&X7<178&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],12,2,MapGame)) {ifHandle1(11,2,p2card3);}
        else if (x!=0&&X7>178&&X7<225&&Y7>164&&Y7<316&&Check(CardsPlayer2[2],13,2,MapGame)) {ifHandle1(12,2,p2card3);}
        else if (x!=0&&X7>225&&X7<276&&Y7>164&&Y7<316&&(Card.returnCardbyName(CardsPlayer2[2]).getDuration()!=5)&&Check(CardsPlayer2[2],14,2,MapGame)) {ifHandle1(13,2,p2card3);}
        else if (x!=0&&X7>276&&X7<326&&Y7>164&&Y7<316&&(Card.returnCardbyName(CardsPlayer2[2]).getDuration()!=4)&&Card.returnCardbyName(CardsPlayer2[2]).getDuration()!=5&&Check(CardsPlayer2[2],15,2,MapGame)){ifHandle1(14,2,p2card3);}
        else if (x!=0&&X7>326&&X7<371&&Y7>164&&Y7<316&&(Card.returnCardbyName(CardsPlayer2[2]).getDuration()==1)||Card.returnCardbyName(CardsPlayer2[2]).getDuration()==2&&Check(CardsPlayer2[2],16,2,MapGame)) {ifHandle1(15,2,p2card3);}
        else if (x!=0&&X7>371&&X7<423&&Y7>164&&Y7<316&&Card.returnCardbyName(CardsPlayer2[2]).getDuration()==1&&Check(CardsPlayer2[2],17,2,MapGame)){ifHandle1(16,2,p2card3);}
        else {
            elseHandle(p2card3);
        }
    }
    public void p2card4(MouseEvent mouseEvent) {
        if (player2) {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            p2card4.setX(mouseX - p2card4.getFitWidth() / 2);
            p2card4.setY(mouseY - p2card4.getFitHeight() / 2);
        }
    }
    public void card4p2(MouseEvent mouseEvent)throws IOException  {
        X8=mouseEvent.getX();
        Y8=mouseEvent.getY();
        System.out.println("X " +X8);
        System.out.println("Y "+Y8);
        Handle(p2card4,CardsPlayer2[3]);
        if (x!=0&&X8>-560&&X8<-514&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],1,2,MapGame)){ifHandle1(0,3,p2card4);}
        else if (x!=0&&X8>-514&&X8<-465&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],2,2,MapGame)){ifHandle1(1,3,p2card4);}
        else if (x!=0&&X8>-465&&X8<-420&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],3,2,MapGame)) {ifHandle1(2,3,p2card4);}
        else if (x!=0&&X8>-420&&X8<-370&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],4,2,MapGame)) {ifHandle1(3,3,p2card4);}
        else if (x!=0&&X8>-370&&X8<-320&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],5,2,MapGame)) {ifHandle1(4,3,p2card4);}
        else if (x!=0&&X8>-320&&X8<-267&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],6,2,MapGame)) {ifHandle1(5,3,p2card4);}
        else if (x!=0&&X8>-267&&X8<-220&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],7,2,MapGame)) {ifHandle1(6,3,p2card4);}
        else if (x!=0&&X8>-220&&X8<-170&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],8,2,MapGame)){ifHandle1(7,3,p2card4);}
        else if (x!=0&&X8>-170&&X8<-120&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],9,2,MapGame)) {ifHandle1(8,3,p2card4);}
        else if (x!=0&&X8>-120&&X8<-67&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],10,2,MapGame)) {ifHandle1(9,3,p2card4);}
        else if (x!=0&&X8>-67&&X8<-20&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],11,2,MapGame)) {ifHandle1(10,3,p2card4);}
        else if (x!=0&&X8>-20&&X8<26&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],12,2,MapGame)) {ifHandle1(11,3,p2card4);}
        else if (x!=0&&X8>26&&X8<78&&Y8>164&&Y8<316&&Check(CardsPlayer2[3],13,2,MapGame)) {ifHandle1(12,3,p2card4);}
        else if (x!=0&&X8>78&&X8<124&&Y8>164&&Y8<316&&(Card.returnCardbyName(CardsPlayer2[3]).getDuration()!=5)&&Check(CardsPlayer2[2],14,2,MapGame)) {ifHandle1(13,3,p2card4);}
        else if (x!=0&&X8>124&&X8<172&&Y8>164&&Y8<316&&(Card.returnCardbyName(CardsPlayer2[3]).getDuration()!=4)&&Card.returnCardbyName(CardsPlayer2[3]).getDuration()!=5&&Check(CardsPlayer2[3],15,2,MapGame)){ifHandle1(14,3,p2card4);}
        else if (x!=0&&X8>172&&X8<225&&Y8>164&&Y8<316&&(Card.returnCardbyName(CardsPlayer2[3]).getDuration()==1)||Card.returnCardbyName(CardsPlayer2[3]).getDuration()==2&&Check(CardsPlayer2[3],16,2,MapGame)) {ifHandle1(15,3,p2card4);}
        else if (x!=0&&X8>225&&X8<270&&Y8>164&&Y8<316&&Card.returnCardbyName(CardsPlayer2[3]).getDuration()==1&&Check(CardsPlayer2[3],17,2,MapGame)){ifHandle1(16,2,p2card4);}
        else {
            elseHandle(p2card4);
        }
    }
    public void p2card5(MouseEvent mouseEvent) {
        if (player2) {
            double mouseX = mouseEvent.getX();
            double mouseY = mouseEvent.getY();
            p2card5.setX(mouseX - p2card5.getFitWidth() / 2);
            p2card5.setY(mouseY - p2card5.getFitHeight() / 2);
        }
    }
    public void card5p2(MouseEvent mouseEvent)throws IOException {
        X9=mouseEvent.getX();
        Y9=mouseEvent.getY();
        Handle(p2card5,CardsPlayer2[4]);
        if (x!=0&&X9>-710&&X9<-664&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],1,2,MapGame)){ifHandle1(0,4,p2card5);}
        else if (x!=0&&X9>-664&&X9<-614&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],2,2,MapGame)){ifHandle1(1,4,p2card5);}
        else if (x!=0&&X9>-614&&X9<-564&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],3,2,MapGame)) {ifHandle1(2,4,p2card5);}
        else if (x!=0&&X9>-564&&X9<-515&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],4,2,MapGame)) {ifHandle1(3,4,p2card5);}
        else if (x!=0&&X9>-515&&X9<-466&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],5,2,MapGame)) {ifHandle1(4,4,p2card5);}
        else if (x!=0&&X9>-466&&X9<-416&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],6,2,MapGame)) {ifHandle1(5,4,p2card5);}
        else if (x!=0&&X9>-416&&X9<-365&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],7,2,MapGame)) {ifHandle1(6,4,p2card5);}
        else if (x!=0&&X9>-365&&X9<-314&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],8,2,MapGame)){ifHandle1(7,4,p2card5);}
        else if (x!=0&&X9>-314&&X9<-266&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],9,2,MapGame)) {ifHandle1(8,4,p2card5);}
        else if (x!=0&&X9>-266&&X9<-217&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],10,2,MapGame)) {ifHandle1(9,4,p2card5);}
        else if (x!=0&&X9>-217&&X9<-169&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],11,2,MapGame)) {ifHandle1(10,4,p2card5);}
        else if (x!=0&&X9>-169&&X9<-116&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],12,2,MapGame)) {ifHandle1(11,4,p2card5);}
        else if (x!=0&&X9>-116&&X9<-69&&Y9>164&&Y9<316&&Check(CardsPlayer2[4],13,2,MapGame)) {ifHandle1(12,4,p2card5);}
        else if (x!=0&&X9>-69&&X9<-19&&Y9>164&&Y9<316&&(Card.returnCardbyName(CardsPlayer2[4]).getDuration()!=5)&&Check(CardsPlayer2[4],14,2,MapGame)) {ifHandle1(13,4,p2card5);}
        else if (x!=0&&X9>-19&&X9<27&&Y9>164&&Y9<316&&(Card.returnCardbyName(CardsPlayer2[4]).getDuration()!=4)&&Card.returnCardbyName(CardsPlayer2[4]).getDuration()!=5&&Check(CardsPlayer2[4],15,2,MapGame)){ifHandle1(14,4,p2card5);}
        else if (x!=0&&X9>27&&X9<78&&Y9>164&&Y9<316&&(Card.returnCardbyName(CardsPlayer2[4]).getDuration()==1)||Card.returnCardbyName(CardsPlayer2[4]).getDuration()==2&&Check(CardsPlayer2[4],16,2,MapGame)) {ifHandle1(15,4,p2card5);}
        else if (x!=0&&X9>78&&X9<126&&Y9>164&&Y9<316&&Card.returnCardbyName(CardsPlayer2[4]).getDuration()==1&&Check(CardsPlayer2[4],17,2,MapGame)){ifHandle1(16,4,p2card5);}
        else {
            elseHandle(p2card5);
        }
    }
    public void ifHandle(int lenght,int numcard,ImageView imageView){
        if (Card.CheckName(CardsPlayer1[numcard])) {
            int a = Card.returnCardbyName(CardsPlayer1[numcard]).getDuration()+lenght;
            for (int i = lenght; i < a; i++) {
                MapGame[0][i] = Card.returnCardbyName(CardsPlayer1[numcard]).getName();
                attack[0][i] = CardsAttackPlayer1[numcard];
            }
            ////////////////////increase damagde becouse card3
            int q = CharChargetScore(Card.returnCardbyName(CardsPlayer1[numcard]).getCharec(), Card.returnCardbyName(CardsPlayer1[2]).getCharec(), Card.returnCardbyName(CardsPlayer1[2]).getDuration());
            CardsDamagePlayer1[2] += q;
            /////////////////////////////////

            for (int i = lenght; i < a; i++) {
                int increase = 0;
                if (userSession1.getCharacter().equals(Card.returnCardbyName(MapGame[0][i]).getCharec())) {
                    increase = 1;
                }
                ////////////////////////////////////////////////////////////////////////////////////
                if (MapGame[1][i].equals("") || MapGame[1][i].equals("#")) {
                    MapGame[0][i] = CardsPlayer1[numcard];
                    attack[0][i] = CardsAttackPlayer1[numcard];
                    double e = CardsDamagePlayer1[numcard] / Card.returnCardbyName(CardsPlayer1[numcard]).getDuration();
                    Damageplayer[0][i] = (int) e + increase;
                    Player1Damage += Damageplayer[0][i];
                } else {
                    MapGame[0][i] = CardsPlayer1[numcard];
                    attack[0][i] = CardsAttackPlayer1[numcard];
                    ////////////////Card
                    if (Card.CheckName(MapGame[1][i])) {
                        if (attack[1][i] > attack[0][i]) {
                            double e = CardsDamagePlayer1[numcard] / Card.returnCardbyName(CardsPlayer1[numcard]).getDuration();
                            Damageplayer[0][i] = (int) e + increase;
                            attack[0][i] = 0;
                        } else if (attack[1][i] < attack[0][i]) {
                            double e = CardsDamagePlayer1[numcard] / Card.returnCardbyName(CardsPlayer1[numcard]).getDuration();
                            Damageplayer[0][i] = (int) e + increase;
                            Player1Damage += Damageplayer[0][i];
                            Player2Damage -= Damageplayer[1][i];
                            System.out.println(Damageplayer[1][i]);
                            attack[1][i] = 0;
                        } else if (attack[1][i] == attack[0][i]) {
                            Player2Damage -= Damageplayer[1][i];
                            attack[1][i] = 0;
                            attack[0][i] = 0;
                            double e = CardsDamagePlayer1[numcard] / Card.returnCardbyName(CardsPlayer1[numcard]).getDuration();
                            Damageplayer[0][i] = (int) e + increase;
                        }
                        //////////Special Card
                        else {
                            MapGame[0][i] = CardsPlayer1[numcard];
                            if (MapGame[1][i].equals("shield")) {
                                attack[0][i] = 0;
                            }
                        }
                    }
                }
            }
        }
        else {
            if (SpecialCard.returnSpecialbyName(CardsPlayer1[numcard]).getNameCard().equals("healing")) {
                MapGame[0][lenght] = "healing";
                attack[0][lenght] = 0;
                Damageplayer[0][lenght] = 0;
                Hpp1+=15;
            }
            else if (SpecialCard.returnSpecialbyName(CardsPlayer1[numcard]).getNameCard().equals("repairman")) {
                for (int i = 0; i < 17; i++) {
                    if (MapGame[0][i].equals("#")) {
                        MapGame[0][i]="";
                    }
                }
            }
            else if (SpecialCard.returnSpecialbyName(CardsPlayer1[numcard]).getNameCard().equals("roundReducer")) {
//                    --numRand1;
//                    --numRand1;
//                    --numRand2;
            }

        }
        ///////////////////////////////////
        --run1;
        player1=false;
        player2=true;
        setImage();
        x=0;
        imageView.setImage(null);
        imageView.setX(checkX(imageView));
        imageView.setY(checkY(imageView));
        //////////////////////////////
        ArrayList<String> Namecard = new ArrayList<>();
        for (int i = 0; i < userSession1.getCardPlayer1().size(); i++) {
            Namecard.add(userSession1.getCardPlayer1().get(i).getName());
        }
        for (int i = 0; i < userSession1.getSpecialCardsPlayer1().size(); i++) {
            Namecard.add(userSession1.getSpecialCardsPlayer1().get(i).getNameCard());
        }
        Random random = new Random();
        int randomIndex = random.nextInt(Namecard.size());
        CardsPlayer1[numcard] = Namecard.get(randomIndex);
        if (Card.CheckName(CardsPlayer1[numcard])) {
            CardsAttackPlayer1[numcard] = (Card.returnCardbyName(CardsPlayer1[numcard]).getCardAttack());
            CardsDamagePlayer1[numcard] = (Card.returnCardbyName(CardsPlayer1[numcard]).getPlayerDamage());
            getCardImage(imageView, Card.returnCardbyName(CardsPlayer1[numcard]));
        }
        if (SpecialCard.Checkname(CardsPlayer1[numcard])) {
            CardsAttackPlayer1[numcard] = 0;
            CardsDamagePlayer1[numcard] = 0;
            getSpecialCardImage(imageView, SpecialCard.returnSpecialbyName(CardsPlayer1[numcard]));
        }
        //////////////////////////timeline\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if (run1==0&&run2==0) {
            p1card1.setImage(null);
            p1card2.setImage(null);
            p1card3.setImage(null);
            p1card4.setImage(null);
            p1card5.setImage(null);
            p2card1.setImage(null);
            p2card2.setImage(null);
            p2card3.setImage(null);
            p2card4.setImage(null);
            p2card5.setImage(null);
            runplay1.setText("");
            runplay2.setText("");
            viewCard.setImage(null);
            turn.setText("");
            timelin.setOpacity(1);
            MovingTimeLine controller = new MovingTimeLine(timelin, 17, 50,0,progress);
            controller.setOnRectanglePass(this::handleRectanglePass);
//            setTimeline1(numRectangle-1);
            controller.start();
            System.out.println("sfghgfdsdsfghgfdsafgh");
//////////////////////////////////////////



        }
    }

    public void overWin() {
        try {
            Parent gameRoot = FXMLLoader.load(getClass().getResource("/View/OverOrWin.fxml"));
            Stage stage = (Stage) p11.getScene().getWindow();
            Scene scene = new Scene(gameRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showErrorDialog("Failed to load the game menu.");
        }
    }

    private void showErrorDialog(String message) {
        // می‌توانید از یک دیالوگ برای نمایش پیام خطا استفاده کنید
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void endGame() {
        MovingTimeLine.passedRectangles=18;
        if (Hpp1 > 0&&Hpp2<=0) {
            userSession1.setHp(20);
            userSession2.setHp(20+userSession2.getHp());
            HPplayer2.setText("0");
            int coinWin = (int)userSession1.getCoin()+200;
            userSession1.setCoin(coinWin);
            int XP = (int)userSession1.getXP()+4;
            if (XP >=userSession1.getXPlevelup()) {
                userSession1.setCoin(10 + userSession1.getCoin());
                userSession1.setLevel(userSession1.getLevel() + 1);
                XP -= userSession1.getXPlevelup();
            }
            userSession1.setXP(XP);
            userSession1.setXPlevelup(userSession1.getXPlevelup() * 2);
            //////////////////////////////////////////////////
            int XPlose = userSession2.getXP()+1;
            if (XPlose >= userSession2.getXPlevelup()) {
                userSession2.setCoin(10 + userSession2.getCoin());
                userSession2.setLevel(userSession2.getLevel() + 1);
                XPlose -= userSession2.getXPlevelup();
            }
            userSession2.setXP(XPlose);
            userSession2.setXPlevelup(userSession2.getXPlevelup() * 2);
            overWin();
        }
        if (Hpp2 > 0&&Hpp1<=0) {
            userSession1.setHp(20);
            userSession2.setHp(20+userSession2.getHp());
            HPplayer1.setText("0");
            int coinWin = (int)userSession2.getCoin()+200;
            userSession2.setCoin(coinWin);
            int XP = (int)userSession2.getXP()+4;
            if (XP >=userSession2.getXPlevelup()) {
                userSession2.setCoin(10 + userSession2.getCoin());
                userSession2.setLevel(userSession2.getLevel() + 1);
                XP -= userSession2.getXPlevelup();
            }
            userSession2.setXP(XP);
            userSession2.setXPlevelup(userSession2.getXPlevelup() * 2);
            //////////////////////////////////////////////////
            int XPlose = userSession1.getXP()+1;
            if (XPlose >= userSession1.getXPlevelup()) {
                userSession1.setCoin(10 + userSession1.getCoin());
                userSession1.setLevel(userSession1.getLevel() + 1);
                XPlose -= userSession1.getXPlevelup();
            }
            userSession1.setXP(XPlose);
            userSession1.setXPlevelup(userSession1.getXPlevelup() * 2);
            overWin();
        }
    }
    public void setTimeline1(int i)  {
        Random random=new Random();
        if (attack[0][i]>attack[1][i]) {
            if (random.nextInt(3) == 1) {
                progress.setOpacity(1);
                Hpp2 -= progress.getProgress() * 10;
                HPplayer2.setText(Integer.toString(Hpp2));
            }
            endGame();
        }
        if (attack[1][i]>attack[0][i]) {
            if (random.nextInt(3) == 1) {
                progress.setOpacity(1);
                Hpp1 -= progress.getProgress() * 10;
                HPplayer1.setText(Integer.toString(Hpp1));
            }
            endGame();
        }
        if (attack[0][i] != 0) {
            Hpp2-= Damageplayer[0][i];
            Player1Damage-=Damageplayer[0][i];
            damage1.setText(Integer.toString(Player1Damage));
            HPplayer2.setText(Integer.toString(Hpp2));
            endGame();
        }
        if (attack[1][i] != 0) {
            Hpp1 -= Damageplayer[1][i];
            Player2Damage-=Damageplayer[1][i];
            damage2.setText(Integer.toString(Player2Damage));
            HPplayer1.setText(Integer.toString(Hpp1));
            endGame();

        }
        if (i==16) {
            userSession1.setHp(Hpp1);
            userSession2.setHp(Hpp2);
        }
        progress.setOpacity(0);
    }
    private void handleRectanglePass(int rectangleIndex) {
        numRectangle=rectangleIndex;
        setTimeline1(numRectangle);
        viewCard.setImage(null);
        System.out.println(numRectangle);
    }
    public void elseHandle(ImageView imageView){
        x=0;
        imageView.setX(checkX(imageView));
        imageView.setY(checkY(imageView));
    }
    public void Handle(ImageView imageView ,String CardsPlayer1){
        ++x;
        if (imageView.getX()==checkX(imageView)&&imageView.getY()==checkY(imageView)) {
            x=0;
            if (Card.CheckName(CardsPlayer1)) {
                getCardImage(viewCard,Card.returnCardbyName(CardsPlayer1));
            }
            else {
                getSpecialCardImage(viewCard,SpecialCard.returnSpecialbyName(CardsPlayer1));
            }
        }
    }
    public void ifHandle1(int lenght,int numcard,ImageView imageView){
        if (Card.CheckName(CardsPlayer2[numcard])) {
            int a = Card.returnCardbyName(CardsPlayer2[numcard]).getDuration()+lenght;
            for (int i = lenght; i < a; i++) {
                MapGame[1][i] = Card.returnCardbyName(CardsPlayer2[numcard]).getName();
                attack[1][i] = CardsAttackPlayer2[numcard];
            }
            ////////////////////increase damagde becouse card3
            int q = CharChargetScore(Card.returnCardbyName(CardsPlayer2[numcard]).getCharec(), Card.returnCardbyName(CardsPlayer2[2]).getCharec(), Card.returnCardbyName(CardsPlayer2[2]).getDuration());
            CardsDamagePlayer2[2] += q;
            /////////////////////////////////

            for (int i = lenght; i < a; i++) {
                int increase = 0;
                if (userSession2.getCharacter().equals(Card.returnCardbyName(MapGame[1][i]).getCharec())) {
                    increase = 1;
                }
                ////////////////////////////////////////////////////////////////////////////////////
                if (MapGame[0][i].equals("") || MapGame[0][i].equals("#")) {
                    MapGame[1][i] = CardsPlayer2[numcard];
                    attack[1][i] = CardsAttackPlayer2[numcard];
                    double e = CardsDamagePlayer2[numcard] / Card.returnCardbyName(CardsPlayer2[numcard]).getDuration();
                    Damageplayer[1][i] = (int) e + increase;
                    Player2Damage += Damageplayer[1][i];
                } else {
                    MapGame[1][i] = CardsPlayer2[numcard];
                    attack[1][i] = CardsAttackPlayer2[numcard];
                    ////////////////Card
                    if (Card.CheckName(MapGame[0][i])) {
                        if (attack[0][i] > attack[1][i]) {
                            attack[1][i] = 0;
                            double e = CardsDamagePlayer2[numcard] / Card.returnCardbyName(CardsPlayer2[numcard]).getDuration();
                            Damageplayer[1][i] = (int) e + increase;
                        } else if (attack[0][i] < attack[1][i]) {
                            double e = CardsDamagePlayer2[numcard] / Card.returnCardbyName(CardsPlayer2[numcard]).getDuration();
                            Damageplayer[1][i] = (int) e + increase;
                            Player2Damage += Damageplayer[1][i];
                            Player1Damage -= Damageplayer[0][i];
                            System.out.println(Damageplayer[0][i]);
                            attack[0][i] = 0;
                        } else if (attack[1][i] == attack[0][i]) {
                            Player1Damage -= Damageplayer[0][i];
                            double e = CardsDamagePlayer2[numcard] / Card.returnCardbyName(CardsPlayer2[numcard]).getDuration();
                            Damageplayer[1][i] = (int) e + increase;
                            attack[1][i] = 0;
                            attack[0][i] = 0;
                        }
                        //////////Special Card
                        else {
                            MapGame[1][i] = CardsPlayer2[numcard];
                            if (MapGame[0][i].equals("shield")) {
                                attack[1][i] = 0;
                            }
                        }
                    }
                }
            }
        }
        else {
            if (SpecialCard.returnSpecialbyName(CardsPlayer2[numcard]).getNameCard().equals("healing")) {
                MapGame[1][lenght] = "healing";
                attack[1][lenght] = 0;
                Damageplayer[1][lenght] = 0;
                Hpp2+=15;
            }
            else if (SpecialCard.returnSpecialbyName(CardsPlayer2[numcard]).getNameCard().equals("repairman")) {
                for (int i = 0; i < 17; i++) {
                    if (MapGame[1][i].equals("#")) {
                        MapGame[1][i]="";
                    }
                }
            }
            else if (SpecialCard.returnSpecialbyName(CardsPlayer2[numcard]).getNameCard().equals("roundReducer")) {
//                    --numRand1;
//                    --numRand1;
//                    --numRand2;
            }

        }
        ///////////////////////////////////
        --run2;
        player2=false;
        player1=true;
        setImage();
        x=0;
        imageView.setImage(null);
        imageView.setX(checkX(imageView));
        imageView.setY(checkY(imageView));
        //////////////////////////////
        ArrayList<String> Namecard = new ArrayList<>();
        for (int i = 0; i < userSession2.getCardPlayer2().size(); i++) {
            Namecard.add(userSession2.getCardPlayer2().get(i).getName());
        }
        for (int i = 0; i < userSession2.getSpecialCardsPlayer2().size(); i++) {
            Namecard.add(userSession2.getSpecialCardsPlayer2().get(i).getNameCard());
        }
        Random random = new Random();
        int randomIndex = random.nextInt(Namecard.size());
        CardsPlayer2[numcard] = Namecard.get(randomIndex);
        if (Card.CheckName(CardsPlayer2[numcard])) {
            CardsAttackPlayer2[numcard] = (Card.returnCardbyName(CardsPlayer2[numcard]).getCardAttack());
            CardsDamagePlayer2[numcard] = (Card.returnCardbyName(CardsPlayer2[numcard]).getPlayerDamage());
            getCardImage(imageView, Card.returnCardbyName(CardsPlayer2[numcard]));
        }
        if (SpecialCard.Checkname(CardsPlayer2[numcard])) {
            CardsAttackPlayer2[numcard] = 0;
            CardsDamagePlayer2[numcard] = 0;
            getSpecialCardImage(imageView, SpecialCard.returnSpecialbyName(CardsPlayer2[numcard]));
        }
        ////////////////////////////////////////////timeline\\\\\\\\\\\\\\\\\\\\\\\\\\
        if (run1==0&&run2==0) {
            p1card1.setImage(null);
            p1card2.setImage(null);
            p1card3.setImage(null);
            p1card4.setImage(null);
            p1card5.setImage(null);
            p2card1.setImage(null);
            p2card2.setImage(null);
            p2card3.setImage(null);
            p2card4.setImage(null);
            p2card5.setImage(null);
            runplay1.setText("");
            runplay2.setText("");
            turn.setText("");
            viewCard.setImage(null);
            timelin.setOpacity(1);
            MovingTimeLine controller = new MovingTimeLine(timelin, 17, 50,0,progress);
            controller.setOnRectanglePass(this::handleRectanglePass);
//            setTimeline1(numRectangle-1);
            controller.start();
            System.out.println("sfghgfdsdsfghgfdsafgh");
//////////////////////////////////////////


        }

    }
    public double checkX(ImageView imageView){
    if (imageView.equals(p1card1)) {
        return Xp1card1;
    }
   else if (imageView.equals(p1card2)) {
        return Xp1card2;
    }
   else if (imageView.equals(p1card3)) {
        return Xp1card3;
    }
   else if (imageView.equals(p1card4)) {
        return Xp1card4;
    }
   else if (imageView.equals(p1card5)) {
        return Xp1card5;
    }
   else if (imageView.equals(p2card1)) {
        return Xp2card1;
    }
    else if (imageView.equals(p2card2)) {
        return Xp2card2;
    }
    else if (imageView.equals(p2card3)) {
        return Xp2card3;
    }
    else if (imageView.equals(p2card4)) {
        return Xp2card4;
    }
    else if (imageView.equals(p2card5)) {
        return Xp2card5;
    }

    return 0;
}
    public double checkY(ImageView imageView){
        if (imageView.equals(p1card1)) {
            return Yp1card1;
        }
        else if (imageView.equals(p1card2)) {
            return Yp1card2;
        }
        else if (imageView.equals(p1card3)) {
            return Yp1card3;
        }
        else if (imageView.equals(p1card4)) {
            return Yp1card4;
        }
        else if (imageView.equals(p1card5)) {
            return Yp1card5;
        }
        else if (imageView.equals(p2card1)) {
            return Yp2card1;
        }
        else if (imageView.equals(p2card2)) {
            return Yp2card2;
        }
        else if (imageView.equals(p2card3)) {
            return Yp2card3;
        }
        else if (imageView.equals(p2card4)) {
            return Yp2card4;
        }
        else if (imageView.equals(p2card5)) {
            return Yp2card5;
        }

        return 0;
    }
    public void getCharImage(UserSession userSession, ImageView imageView) {
        if (userSession.getCharacter().equals("1")) {
            Image image = new Image(getClass().getResource("/images/character1.png").toExternalForm());
            imageView.setImage(image);
//            new Image(Packman.class.getResource("/Image/coin.png").toExternalForm());
        }
        if (userSession.getCharacter().equals("2")) {
            Image image = new Image(getClass().getResource("/images/character2.png").toExternalForm());
            imageView.setImage(image);
        }
        if (userSession.getCharacter().equals("3")) {
            Image image = new Image(getClass().getResource("/images/character3.png").toExternalForm());
            imageView.setImage(image);
        }
        if (userSession.getCharacter().equals("4")) {
            Image image = new Image(getClass().getResource("/images/character4.png").toExternalForm());
            imageView.setImage(image);
        }
    }
    public void getCharImage(UserSession2 userSession, ImageView imageView) {
        if (userSession.getCharacter().equals("1")) {
            Image image = new Image(getClass().getResource("/images/character1.png").toExternalForm());
            imageView.setImage(image);
        }
        if (userSession.getCharacter().equals("2")) {
            Image image = new Image(getClass().getResource("/images/character2.png").toExternalForm());
            imageView.setImage(image);
        }
        if (userSession.getCharacter().equals("3")) {
            Image image = new Image(getClass().getResource("/images/character3.png").toExternalForm());
            imageView.setImage(image);
        }
        if (userSession.getCharacter().equals("4")) {
            Image image = new Image(getClass().getResource("/images/character4.png").toExternalForm());
            imageView.setImage(image);
        }
    }
    public void getCardImage(ImageView imageView, Card card) {
        if (card.getName().equals("card1")) {
            Image image = new Image(getClass().getResource("/images/Card/card1.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card2")) {
            Image image = new Image(getClass().getResource("/images/Card/card2.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card3")) {
            Image image = new Image(getClass().getResource("/images/Card/card3.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card4")) {
            Image image = new Image(getClass().getResource("/images/Card/card4.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card5")) {
            Image image = new Image(getClass().getResource("/images/Card/card5.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card6")) {
            Image image = new Image(getClass().getResource("/images/Card/card6.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card7")) {
            Image image = new Image(getClass().getResource("/images/Card/card7.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card8")) {
            Image image = new Image(getClass().getResource("/images/Card/card8.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card9")) {
            Image image = new Image(getClass().getResource("/images/Card/card9.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card10")) {
            Image image = new Image(getClass().getResource("/images/Card/card10.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card11")) {
            Image image = new Image(getClass().getResource("/images/Card/card11.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card12")) {
            Image image = new Image(getClass().getResource("/images/Card/card12.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card13")) {
            Image image = new Image(getClass().getResource("/images/Card/card13.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card14")) {
            Image image = new Image(getClass().getResource("/images/Card/card14.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card15")) {
            Image image = new Image(getClass().getResource("/images/Card/card15.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card16")) {
            Image image = new Image(getClass().getResource("/images/Card/card16.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card17")) {
            Image image = new Image(getClass().getResource("/images/Card/card17.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card18")) {
            Image image = new Image(getClass().getResource("/images/Card/card18.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card19")) {
            Image image = new Image(getClass().getResource("/images/Card/card19.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card20")) {
            Image image = new Image(getClass().getResource("/images/Card/card20.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card21")) {
            Image image = new Image(getClass().getResource("/images/Card/card21.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card22")) {
            Image image = new Image(getClass().getResource("/images/Card/card22.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card23")) {
            Image image = new Image(getClass().getResource("/images/Card/card23.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card24")) {
            Image image = new Image(getClass().getResource("/images/Card/card24.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card25")) {
            Image image = new Image(getClass().getResource("/images/Card/card25.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card26")) {
            Image image = new Image(getClass().getResource("/images/Card/card26.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card27")) {
            Image image = new Image(getClass().getResource("/images/Card/card27.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card28")) {
            Image image = new Image(getClass().getResource("/images/Card/card28.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card29")) {
            Image image = new Image(getClass().getResource("/images/Card/card29.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card30")) {
            Image image = new Image(getClass().getResource("/images/Card/card30.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card31")) {
            Image image = new Image(getClass().getResource("/images/Card/card31.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card32")) {
            Image image = new Image(getClass().getResource("/images/Card/card32.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card33")) {
            Image image = new Image(getClass().getResource("/images/Card/card33.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card34")) {
            Image image = new Image(getClass().getResource("/images/Card/card34.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card35")) {
            Image image = new Image(getClass().getResource("/images/Card/card35.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card36")) {
            Image image = new Image(getClass().getResource("/images/Card/card36.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card37")) {
            Image image = new Image(getClass().getResource("/images/Card/card37.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card38")) {
            Image image = new Image(getClass().getResource("/images/Card/card38.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card39")) {
            Image image = new Image(getClass().getResource("/images/Card/card39.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card40")) {
            Image image = new Image(getClass().getResource("/images/Card/card40.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card41")) {
            Image image = new Image(getClass().getResource("/images/Card/card41.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card42")) {
            Image image = new Image(getClass().getResource("/images/Card/card42.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card43")) {
            Image image = new Image(getClass().getResource("/images/Card/card43.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card44")) {
            Image image = new Image(getClass().getResource("/images/Card/card44.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card45")) {
            Image image = new Image(getClass().getResource("/images/Card/card45.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getName().equals("card46")) {
            Image image = new Image(getClass().getResource("/images/Card/card46.png").toExternalForm());
            imageView.setImage(image);
        }
    }
    public void getSpecialCardImage(ImageView imageView, SpecialCard card) {
        if (card.getNameCard().equals("shield")) {
            Image image = new Image(getClass().getResource("/images/SpecialCard/shield.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getNameCard().equals("healing")) {
            Image image = new Image(getClass().getResource("/images/SpecialCard/healing.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getNameCard().equals("HoleLocation")) {
            Image image = new Image(getClass().getResource("/images/SpecialCard/HoleLocation.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getNameCard().equals("repairman")) {
            Image image = new Image(getClass().getResource("/images/SpecialCard/repairman.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getNameCard().equals("CardWeaker")) {
            Image image = new Image(getClass().getResource("/images/SpecialCard/CardWeaker.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getNameCard().equals("roundReducer")) {
            Image image = new Image(getClass().getResource("/images/SpecialCard/roundReducer.png").toExternalForm());
            imageView.setImage(image);
        }
        if (card.getNameCard().equals("PowerBooster")) {
            Image image = new Image(getClass().getResource("/images/SpecialCard/PowerBooster.png").toExternalForm());
            imageView.setImage(image);
        }

    }
    public void StartGame(){
        userSession1 = UserSession.getInstance();
        userSession2 = UserSession2.getInstance();
        getCharImage(userSession1, characterplayer1);
        getCharImage(userSession2, characterplayer2);
        runplay1.setText(Integer.toString(run1));
        runplay2.setText(Integer.toString(run2));
//        damage1.setText(Integer.toString(damagep1));
//        damage2.setText(Integer.toString(damagep2));
        HPplayer1.setText(Integer.toString(userSession1.getHp()));
        HPplayer2.setText(Integer.toString(userSession2.getHp()));
        rund.setText(Integer.toString(numrund));
        Random random = new Random();
        int rand = random.nextInt(1);
        if (rand == 0) {
            turn.setText("1");
            player1=true;
            player2=false;
        }
        if (rand == 1) {
            turn.setText("2");
            player1=false;
            player2=true;
        }
        userSession1.fillCard();
        userSession2.fillCard();
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < 17; j++) {
                MapGame[i][j] = "";
                Damageplayer[i][j]=0;
                attack[i][j]=0;
            }
        }
    }
    public void Cavity(){
        Random random1 = new Random();
        int cavity = random1.nextInt(17)+1;
        if (cavity == 1) {
            p11.setOpacity(0.5);
        }
        if (cavity == 2) {
            p12.setOpacity(0.5);
        }
        if (cavity == 3) {
            p13.setOpacity(0.5);
        }
        if (cavity == 4) {
            p14.setOpacity(0.5);
        }
        if (cavity == 5) {
            p15.setOpacity(0.5);
        }
        if (cavity == 6) {
            p16.setOpacity(0.5);
        }
        if (cavity == 7) {
            p17.setOpacity(0.5);
        }
        if (cavity == 8) {
            p18.setOpacity(0.5);
        }
        if (cavity == 9) {
            p19.setOpacity(0.5);
        }
        if (cavity == 10) {
            p110.setOpacity(0.5);
        }
        if (cavity == 11) {
            p111.setOpacity(0.5);
        }
        if (cavity == 12) {
            p112.setOpacity(0.5);
        }
        if (cavity == 13) {
            p113.setOpacity(0.5);
        }
        if (cavity == 14) {
            p114.setOpacity(0.5);
        }
        if (cavity == 15) {
            p115.setOpacity(0.5);
        }
        if (cavity == 16) {
            p116.setOpacity(0.5);
        }
        if (cavity == 17) {
            p117.setOpacity(0.5);
        }
        MapGame[0][cavity-1]="#";
///////////////////
        Random random2 = new Random();
        int cavity1 = random2.nextInt(17)+1;
        if (cavity1 == 1) {
            p21.setOpacity(0.5);
        }
        if (cavity1 == 2) {
            p22.setOpacity(0.5);
        }
        if (cavity1 == 3) {
            p23.setOpacity(0.5);
        }
        if (cavity1 == 4) {
            p24.setOpacity(0.5);
        }
        if (cavity1 == 5) {
            p25.setOpacity(0.5);
        }
        if (cavity1 == 6) {
            p26.setOpacity(0.5);
        }
        if (cavity1 == 7) {
            p27.setOpacity(0.5);
        }
        if (cavity1 == 8) {
            p28.setOpacity(0.5);
        }
        if (cavity1 == 9) {
            p29.setOpacity(0.5);
        }
        if (cavity1 == 10) {
            p210.setOpacity(0.5);
        }
        if (cavity1 == 11) {
            p211.setOpacity(0.5);
        }
        if (cavity1 == 12) {
            p212.setOpacity(0.5);
        }
        if (cavity1 == 13) {
            p213.setOpacity(0.5);
        }
        if (cavity1 == 14) {
            p214.setOpacity(0.5);
        }
        if (cavity1 == 15) {
            p215.setOpacity(0.5);
        }
        if (cavity1 == 16) {
            p216.setOpacity(0.5);
        }
        if (cavity1 == 17) {
            p217.setOpacity(0.5);
        }
        MapGame[1][cavity-1]="#";
    }
    public void FillDeck() {
        ArrayList<String> Namecard = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CardsPlayer1[i] = "";
        }
        for (int i = 0; i < userSession1.getCardPlayer1().size(); i++) {
            Namecard.add(userSession1.getCardPlayer1().get(i).getName());
        }
        for (int i = 0; i < userSession1.getSpecialCardsPlayer1().size(); i++) {
            Namecard.add(userSession1.getSpecialCardsPlayer1().get(i).getNameCard());
        }
        Set<String> selectedItems = new HashSet<>();
        Random random = new Random();
        while (selectedItems.size() < 5) {
            int randomIndex = random.nextInt(Namecard.size());
            selectedItems.add(Namecard.get(randomIndex));
        }
        int q = 0;
        for (String item : selectedItems) {
            CardsPlayer1[q] = item;
            if (Card.CheckName(item)) {
                CardsAttackPlayer1[q] = (Card.returnCardbyName(item).getCardAttack());
                CardsDamagePlayer1[q] = (Card.returnCardbyName(item).getPlayerDamage());
            }
            if (SpecialCard.Checkname(item)) {
                CardsAttackPlayer1[q] = 0;
                CardsDamagePlayer1[q] = 0;
            }
            ++q;
        }
        /////////////////////////////////////////player2
        ArrayList<String> Namecard1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CardsPlayer2[i] = "";
        }
        for (int i = 0; i < userSession2.getCardPlayer2().size(); i++) {
            Namecard1.add(userSession2.getCardPlayer2().get(i).getName());
        }
        for (int i = 0; i < userSession2.getSpecialCardsPlayer2().size(); i++) {
            Namecard1.add(userSession2.getSpecialCardsPlayer2().get(i).getNameCard());
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
                CardsAttackPlayer2[x1] = (Card.returnCardbyName(item).getCardAttack());
                CardsDamagePlayer2[x1] = (Card.returnCardbyName(item).getPlayerDamage());
            }
            if (SpecialCard.Checkname(item)) {
                CardsAttackPlayer2[x1] = 0;
                CardsDamagePlayer2[x1] = 0;
            }
            ++x1;
        }
        ///////////////////////////
        if (Card.CheckName(CardsPlayer1[0])) {
            getCardImage(p1card1, Card.returnCardbyName(CardsPlayer1[0]));
        } else {
            getSpecialCardImage(p1card1, SpecialCard.returnSpecialbyName(CardsPlayer1[0]));
        }
        //////////////////////////////////////
        if (Card.CheckName(CardsPlayer1[1])) {
            getCardImage(p1card2, Card.returnCardbyName(CardsPlayer1[1]));
        } else {
            getSpecialCardImage(p1card2, SpecialCard.returnSpecialbyName(CardsPlayer1[1]));
        }
        //////////
        if (Card.CheckName(CardsPlayer1[2])) {
            getCardImage(p1card3, Card.returnCardbyName(CardsPlayer1[2]));
        } else {
            getSpecialCardImage(p1card3, SpecialCard.returnSpecialbyName(CardsPlayer1[2]));
        }
        /////////////
        if (Card.CheckName(CardsPlayer1[3])) {
            getCardImage(p1card4, Card.returnCardbyName(CardsPlayer1[3]));
        } else {
            getSpecialCardImage(p1card4, SpecialCard.returnSpecialbyName(CardsPlayer1[3]));
        }
        //////////////
        if (Card.CheckName(CardsPlayer1[4])) {
            getCardImage(p1card5, Card.returnCardbyName(CardsPlayer1[4]));
        } else {
            getSpecialCardImage(p1card5, SpecialCard.returnSpecialbyName(CardsPlayer1[4]));
        }
        ///////////////////////////////////////////
        if (Card.CheckName(CardsPlayer2[0])) {
            getCardImage(p2card1, Card.returnCardbyName(CardsPlayer2[0]));
        } else {
            getSpecialCardImage(p2card1, SpecialCard.returnSpecialbyName(CardsPlayer2[0]));
        }
        /////////////////////////////
        if (Card.CheckName(CardsPlayer2[1])) {
            getCardImage(p2card2, Card.returnCardbyName(CardsPlayer2[1]));
        } else {
            getSpecialCardImage(p2card2, SpecialCard.returnSpecialbyName(CardsPlayer2[1]));
        }
        if (Card.CheckName(CardsPlayer2[2])) {
            getCardImage(p2card3, Card.returnCardbyName(CardsPlayer2[2]));
        } else {
            getSpecialCardImage(p2card3, SpecialCard.returnSpecialbyName(CardsPlayer2[2]));
        }
        if (Card.CheckName(CardsPlayer2[3])) {
            getCardImage(p2card4, Card.returnCardbyName(CardsPlayer2[3]));
        } else {
            getSpecialCardImage(p2card4, SpecialCard.returnSpecialbyName(CardsPlayer2[3]));
        }
        if (Card.CheckName(CardsPlayer2[4])) {
            getCardImage(p2card5, Card.returnCardbyName(CardsPlayer2[4]));
        } else {
            getSpecialCardImage(p2card5, SpecialCard.returnSpecialbyName(CardsPlayer2[4]));
        }
    }
    public void SetXYCardDeck(){
        Xp2card1=p2card1.getX();
        Yp2card1=p2card1.getY();
        Xp2card2=p2card2.getX();
        Yp2card2=p2card2.getY();
        Xp2card3=p2card3.getX();
        Yp2card3=p2card3.getY();
        Xp2card4=p2card4.getX();
        Yp2card4=p2card4.getY();
        Xp2card5=p2card5.getX();
        Yp2card5=p2card5.getY();
        Xp1card1=p1card1.getX();
        Yp1card1=p1card1.getY();
        Xp1card2=p1card2.getX();
        Yp1card2=p1card2.getY();
        Xp1card3=p1card3.getX();
        Yp1card3=p1card3.getY();
        Xp1card4=p1card4.getX();
        Yp1card4=p1card4.getY();
        Xp1card5=p1card5.getX();
        Yp1card5=p1card5.getY();
    }
    public  boolean Check(String name,int lenght,int width,String[][]Map){
        if (Card.CheckName(name)) {
            int a=lenght+Card.returnCardbyName(name).getDuration()-1;
            for (int i = lenght-1; i <a ; i++) {
                if (!Map[width-1][i].equals("")) {
                    return false;
                }
            }
            return true;
        }
        else {
            if (!Map[width-1][lenght-1].equals("")) {
                return false;
            }
            else {
                return true;
            }
        }
    }
    public void setImage(){
        if (player1&&!player2) {
            turn.setText("1");
        }
        if (!player1&&player2) {
            turn.setText("2");
        }
        runplay1.setText(Integer.toString(run1));
        runplay2.setText(Integer.toString(run2));
        HPplayer1.setText(Integer.toString(Hpp1));
        HPplayer2.setText(Integer.toString(Hpp2));
        damage1.setText(Integer.toString(Player1Damage));
        damage2.setText(Integer.toString(Player2Damage));

        if (!MapGame[0][0].equals("")&&!MapGame[0][0].equals("#")) {
            p11.setOpacity(1);
            p11attack.setText(Integer.toString(attack[0][0]));
            p11damage.setText(Integer.toString(Damageplayer[0][0]));
        }
        if (!MapGame[0][1].equals("")&&!MapGame[0][1].equals("#")) {
            p12.setOpacity(1);
            p12attack.setText(Integer.toString(attack[0][1]));
            p12damage.setText(Integer.toString(Damageplayer[0][1]));
        }
        if (!MapGame[0][2].equals("")&&!MapGame[0][2].equals("#")) {
            p13.setOpacity(1);
            p13attack.setText(Integer.toString(attack[0][2]));
            p13damage.setText(Integer.toString(Damageplayer[0][2]));
        }
        if (!MapGame[0][3].equals("")&&!MapGame[0][3].equals("#")) {
            p14.setOpacity(1);
            p14attack.setText(Integer.toString(attack[0][3]));
            p14damage.setText(Integer.toString(Damageplayer[0][3]));
        }
        if (!MapGame[0][4].equals("")&&!MapGame[0][4].equals("#")) {
            p15.setOpacity(1);
            p15attack.setText(Integer.toString(attack[0][4]));
            p15damage.setText(Integer.toString(Damageplayer[0][4]));
        }
        if (!MapGame[0][5].equals("")&&!MapGame[0][5].equals("#")) {
            p16.setOpacity(1);
            p16attack.setText(Integer.toString(attack[0][5]));
            p16damage.setText(Integer.toString(Damageplayer[0][5]));
        }
        if (!MapGame[0][6].equals("")&&!MapGame[0][6].equals("#")) {
            p17.setOpacity(1);
            p17attack.setText(Integer.toString(attack[0][6]));
            p17damage.setText(Integer.toString(Damageplayer[0][6]));
        }
        if (!MapGame[0][7].equals("")&&!MapGame[0][7].equals("#")) {
            p18.setOpacity(1);
            p18attack.setText(Integer.toString(attack[0][7]));
            p18damage.setText(Integer.toString(Damageplayer[0][7]));
        }
        if (!MapGame[0][8].equals("")&&!MapGame[0][8].equals("#")) {
            p19.setOpacity(1);
            p19attack.setText(Integer.toString(attack[0][8]));
            p19damage.setText(Integer.toString(Damageplayer[0][8]));
        }
        if (!MapGame[0][9].equals("")&&!MapGame[0][9].equals("#")) {
            p110.setOpacity(1);
            p110attack.setText(Integer.toString(attack[0][9]));
            p110damage.setText(Integer.toString(Damageplayer[0][9]));
        }
        if (!MapGame[0][10].equals("")&&!MapGame[0][10].equals("#")) {
            p111.setOpacity(1);
            p111attack.setText(Integer.toString(attack[0][10]));
            p111damage.setText(Integer.toString(Damageplayer[0][10]));
        }
        if (!MapGame[0][11].equals("")&&!MapGame[0][11].equals("#")) {
            p112.setOpacity(1);
            p112attack.setText(Integer.toString(attack[0][11]));
            p112damage.setText(Integer.toString(Damageplayer[0][11]));
        }
        if (!MapGame[0][12].equals("")&&!MapGame[0][12].equals("#")) {
            p113.setOpacity(1);
            p113attack.setText(Integer.toString(attack[0][12]));
            p113damage.setText(Integer.toString(Damageplayer[0][12]));
        }
        if (!MapGame[0][13].equals("")&&!MapGame[0][13].equals("#")) {
            p114.setOpacity(1);
            p114attack.setText(Integer.toString(attack[0][13]));
            p114damage.setText(Integer.toString(Damageplayer[0][13]));
        }
        if (!MapGame[0][14].equals("")&&!MapGame[0][14].equals("#")) {
            p115.setOpacity(1);
            p115attack.setText(Integer.toString(attack[0][14]));
            p115damage.setText(Integer.toString(Damageplayer[0][14]));
        }
        if (!MapGame[0][15].equals("")&&!MapGame[0][15].equals("#")) {
            p116.setOpacity(1);
            p116attack.setText(Integer.toString(attack[0][15]));
            p116damage.setText(Integer.toString(Damageplayer[0][15]));
        }
        if (!MapGame[0][16].equals("")&&!MapGame[0][16].equals("#")) {
            p117.setOpacity(1);
            p117attack.setText(Integer.toString(attack[0][16]));
            p117damage.setText(Integer.toString(Damageplayer[0][16]));
        }
        if (!MapGame[1][0].equals("")&&!MapGame[1][0].equals("#")) {
            p21.setOpacity(1);
            p21attack.setText(Integer.toString(attack[1][0]));
            p21damage.setText(Integer.toString(Damageplayer[1][0]));
        }
        if (!MapGame[1][1].equals("")&&!MapGame[1][1].equals("#")) {
            p22.setOpacity(1);
            p22attack.setText(Integer.toString(attack[1][1]));
            p22damage.setText(Integer.toString(Damageplayer[1][1]));
        }
        if (!MapGame[1][2].equals("")&&!MapGame[1][2].equals("#")) {
            p23.setOpacity(1);
            p23attack.setText(Integer.toString(attack[1][2]));
            p23damage.setText(Integer.toString(Damageplayer[1][2]));
        }
        if (!MapGame[1][3].equals("")&&!MapGame[1][3].equals("#")) {
            p24.setOpacity(1);
            p24attack.setText(Integer.toString(attack[1][3]));
            p24damage.setText(Integer.toString(Damageplayer[1][3]));
        }
        if (!MapGame[1][4].equals("")&&!MapGame[1][4].equals("#")) {
            p25.setOpacity(1);
            p25attack.setText(Integer.toString(attack[1][4]));
            p25damage.setText(Integer.toString(Damageplayer[1][4]));
        }
        if (!MapGame[1][5].equals("")&&!MapGame[1][5].equals("#")) {
            p26.setOpacity(1);
            p26attack.setText(Integer.toString(attack[1][5]));
            p26damage.setText(Integer.toString(Damageplayer[1][5]));
        }
        if (!MapGame[1][6].equals("")&&!MapGame[1][6].equals("#")) {
            p27.setOpacity(1);
            p27attack.setText(Integer.toString(attack[1][6]));
            p27damage.setText(Integer.toString(Damageplayer[1][6]));
        }
        if (!MapGame[1][7].equals("")&&!MapGame[1][7].equals("#")) {
            p28.setOpacity(1);
            p28attack.setText(Integer.toString(attack[1][7]));
            p28damage.setText(Integer.toString(Damageplayer[1][7]));
        }
        if (!MapGame[1][8].equals("")&&!MapGame[1][8].equals("#")) {
            p29.setOpacity(1);
            p29attack.setText(Integer.toString(attack[1][8]));
            p29damage.setText(Integer.toString(Damageplayer[1][8]));
        }
        if (!MapGame[1][9].equals("")&&!MapGame[1][9].equals("#")) {
            p210.setOpacity(1);
            p210attack.setText(Integer.toString(attack[1][9]));
            p210damage.setText(Integer.toString(Damageplayer[1][9]));
        }
        if (!MapGame[1][10].equals("")&&!MapGame[1][10].equals("#")) {
            p211.setOpacity(1);
            p211attack.setText(Integer.toString(attack[1][10]));
            p211damage.setText(Integer.toString(Damageplayer[1][10]));
        }
        if (!MapGame[1][11].equals("")&&!MapGame[1][11].equals("#")) {
            p212.setOpacity(1);
            p212attack.setText(Integer.toString(attack[1][11]));
            p212damage.setText(Integer.toString(Damageplayer[1][11]));
        }
        if (!MapGame[1][12].equals("")&&!MapGame[1][12].equals("#")) {
            p213.setOpacity(1);
            p213attack.setText(Integer.toString(attack[1][12]));
            p213damage.setText(Integer.toString(Damageplayer[1][12]));
        }
        if (!MapGame[1][13].equals("")&&!MapGame[1][13].equals("#")) {
            p214.setOpacity(1);
            p214attack.setText(Integer.toString(attack[1][13]));
            p214damage.setText(Integer.toString(Damageplayer[1][13]));
        }
        if (!MapGame[1][14].equals("")&&!MapGame[1][14].equals("#")) {
            p215.setOpacity(1);
            p215attack.setText(Integer.toString(attack[1][14]));
            p215damage.setText(Integer.toString(Damageplayer[1][14]));
        }
        if (!MapGame[1][15].equals("")&&!MapGame[1][15].equals("#")) {
            p216.setOpacity(1);
            p216attack.setText(Integer.toString(attack[0][15]));
            p216damage.setText(Integer.toString(Damageplayer[0][15]));
        }
        if (!MapGame[1][16].equals("")&&!MapGame[1][16].equals("#")) {
            p217.setOpacity(1);
            p217attack.setText(Integer.toString(attack[1][16]));
            p217damage.setText(Integer.toString(Damageplayer[1][16]));
        }



    }
    public static Integer CharChargetScore(String char1,String char2,Integer duration){
        if (char1.equals("1")&&char2.equals("2")||char2.equals("1")&&char1.equals("2")) {
            Random random=new Random();
            int r=random.nextInt(3);
            if (r!=0) {
                return duration;
            }
            if (r == 0) {
                return 0;
            }
        }
        if (char1.equals("1")&&char2.equals("3")||char2.equals("1")&&char1.equals("3")) {
            Random random=new Random();
            int r=random.nextInt(4);
            if (r==0) {
                return duration;
            }
            if (r != 0) {
                return 0;
            }
        }
        if (char1.equals("1")&&char2.equals("4")||char2.equals("1")&&char1.equals("4")) {
            Random random=new Random();
            int r=random.nextInt(2);
            if (r==0) {
                return duration;
            }
            if (r != 0) {
                return 0;
            }
        }
        if (char1.equals("2")&&char2.equals("3")||char2.equals("2")&&char1.equals("3")) {
            Random random=new Random();
            int r=random.nextInt(10);
            if (r!=0) {
                return duration;
            }
            if (r == 0) {
                return 0;
            }
        }
        if (char1.equals("2")&&char2.equals("4")||char2.equals("2")&&char1.equals("4")) {
            Random random=new Random();
            int r=random.nextInt(6);
            if (r==0) {
                return duration;
            }
            if (r != 0) {
                return 0;
            }
        }
        if (char1.equals("3")&&char2.equals("4")||char2.equals("3")&&char1.equals("4")) {
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
    public void back(MouseEvent mouseEvent) {
        System.out.println("x :"+mouseEvent.getX());
        System.out.println("y :"+mouseEvent.getY());
    }
    public void zamin(MouseEvent mouseEvent) {
        System.out.println("x "+mouseEvent.getX());
        System.out.println("y "+mouseEvent.getY());
    }

}
