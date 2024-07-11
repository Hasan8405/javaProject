package citywars.finalproject;//package citywars.finalproject;//package citywars.finalproject;
//
import citywars.finalproject.Model.Card;
import citywars.finalproject.Model.SpecialCard;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;

import static citywars.finalproject.Model.SpecialCard.specialCards;

public class CitywarsApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ///////////////////////////
        CreateCard();
        CreateSpecialCard();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/start-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("City Wars!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

public void CreateCard(){
    Card card1=new Card("card1",36,1,25,6,30,150,"1");
    Card card2=new Card("card2",31,1,45,4,20,100,"2");
    Card card3=new Card("card3",28,3,15,2,10,50,"3");
    Card card4=new Card("card4",30,1,36,3,15,75,"4");
    Card card5=new Card("card5",28,1,28,2,10,50,"1");
    Card card6=new Card("card6",36,4,40,6,30,150,"2");
    Card card7=new Card("card7",37,3,48,6,30,150,"3");
    Card card8=new Card("card8",30,2,26,3,15,75,"4");
    Card card9=new Card("card9",26,1,35,2,10,50,"1");
    Card card10=new Card("card10",35,4,40,6,30,150,"2");
    Card card11=new Card("card11",35,4,20,6,30,150,"3");
    Card card12=new Card("card12",26,4,36,2,10,50,"4");
    Card card13=new Card("card13",33,4,40,5,25,125,"1");
    Card card14=new Card("card14",27,3,15,2,10,50,"2");
    Card card15=new Card("card15",25,5,40,2,10,50,"3");
    Card card16=new Card("card16",30,3,21,3,15,50,"4");
    Card card17=new Card("card17",33,1,25,5,25,50,"1");
    Card card18=new Card("card18",20,1,55,2,10,50,"2");
    Card card19=new Card("card19",27,1,30,2,10,50,"3");
    Card card20=new Card("card20",37,1,25,6,30,150,"4");
    Card card21=new Card("card21",29,1,33,3,15,75,"1");
    Card card22=new Card("card22",25,4,40,2,10,50,"2");
    Card card23=new Card("card23",29,3,27,3,15,75,"3");
    Card card24=new Card("card24",27,3,30,2,10,50,"4");
    Card card25=new Card("card25",27,1,39,2,10,50,"1");
    Card card26=new Card("card26",38,3,48,7,35,175,"2");
    Card card27=new Card("card27",31,1,15,3,15,75,"3");
    Card card28=new Card("card28",30,2,30,3,15,75,"4");
    Card card29=new Card("card29",34,3,36,5,25,125,"1");
    Card card30=new Card("card30",31,4,32,3,15,75,"2");
    Card card31=new Card("card31",30,1,30,3,15,75,"3");
    Card card32=new Card("card32",31,3,33,3,15,75,"4");
    Card card33=new Card("card33",34,4,40,5,25,125,"1");
    Card card34=new Card("card34",20,4,40,2,10,50,"2");
    Card card35=new Card("card35",34,1,30,5,25,125,"3");
    Card card36=new Card("card36",38,4,40,7,35,175,"4");
    Card card37=new Card("card37",30,5,25,3,15,75,"1");
    Card card38=new Card("card38",27,2,10,2,10,50,"2");
    Card card39=new Card("card39",36,2,50,5,25,125,"3");
    Card card40=new Card("card40",34,5,40,5,25,125,"4");
    Card card41=new Card("card41",29,2,20,2,10,50,"1");
    Card card42=new Card("card42",28,1,15,2,10,50,"2");
    Card card43=new Card("card43",29,5,25,2,10,50,"3");
    Card card44=new Card("card44",32,3,42,3,15,75,"4");
    Card card45=new Card("card45",31,2,52,3,15,75,"1");
    Card card46=new Card("card46",25,1,45,2,10,50,"2");
    Card.cards.add(card1);
    Card.cards.add(card2);
    Card.cards.add(card3);
    Card.cards.add(card4);
    Card.cards.add(card5);
    Card.cards.add(card6);
    Card.cards.add(card7);
    Card.cards.add(card8);
    Card.cards.add(card9);
    Card.cards.add(card10);
    Card.cards.add(card11);
    Card.cards.add(card12);
    Card.cards.add(card13);
    Card.cards.add(card14);
    Card.cards.add(card15);
    Card.cards.add(card16);
    Card.cards.add(card17);
    Card.cards.add(card18);
    Card.cards.add(card19);
    Card.cards.add(card20);
    Card.cards.add(card21);
    Card.cards.add(card22);
    Card.cards.add(card23);
    Card.cards.add(card24);
    Card.cards.add(card25);
    Card.cards.add(card26);
    Card.cards.add(card27);
    Card.cards.add(card28);
    Card.cards.add(card29);
    Card.cards.add(card30);
    Card.cards.add(card31);
    Card.cards.add(card32);
    Card.cards.add(card33);
    Card.cards.add(card34);
    Card.cards.add(card35);
    Card.cards.add(card36);
    Card.cards.add(card37);
    Card.cards.add(card38);
    Card.cards.add(card39);
    Card.cards.add(card40);
    Card.cards.add(card41);
    Card.cards.add(card42);
    Card.cards.add(card43);
    Card.cards.add(card44);
    Card.cards.add(card45);
    Card.cards.add(card46);

    }
    public void CreateSpecialCard(){
        ///////separ
        SpecialCard shield = new SpecialCard("shield", "400");
        shield.setDuration(1);
        shield.setDescription("It breaks against any card with any damage.");
        //////shefa
        SpecialCard healing = new SpecialCard("healing", "400");
        healing.setDescription("This card adds some HP to the player (no card can break this card).");
        healing.setDuration(1);
        /////increasepower
//        SpecialCard PowerBosster = new SpecialCard("PowerBooster", "400");
//        PowerBosster.setDescription("By playing this card, one of the played cards will be woven randomly(This card does not occupy space on the ground)");
//        /////taghirmakan
//        SpecialCard HoleLocation = new SpecialCard("HoleLocation", "400");
//        HoleLocation.setDescription("This card can randomly place the missing block of both players to change (The block in which the card was played should not change)");
//        HoleLocation.setDuration(1);
//        /////tamir
//        SpecialCard repairman = new SpecialCard("repairman", "400");
//        repairman.setDescription("This card can be played on the holes and repair them (this space card from the earth does not occupy");
//        repairman.setDuration(1);
//        /////kamkonanderand
//        SpecialCard roundReducer = new SpecialCard("roundReducer", "400");
//        roundReducer.setDescription("If this card is played, one of the game rounds will be reduced. For example, the game of 4 The round turns into 3 rounds.(This card does not occupy space on the ground)");
//        roundReducer.setDuration(1);
//        //////tazifkonande
//        SpecialCard CardWeaker = new SpecialCard("CardWeaker", "400");
//        CardWeaker.setDescription("Two opponent cards are chosen randomly. One of them is Damijesh and the other one\n" +
//                "Its power decreases. (This card does not occupy space on the ground)");
//        CardWeaker.setDuration(1);
        specialCards.add(shield);
        specialCards.add(healing);
//        specialCards.add(PowerBosster);
//        specialCards.add(HoleLocation);
//        specialCards.add(repairman);
//        specialCards.add(roundReducer);
//        specialCards.add(CardWeaker);
    }
}

