package citywars.finalproject.Controller;

import citywars.finalproject.Model.UserSession;
import citywars.finalproject.Model.UserSession2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class select_char_player1 {
    public UserSession userSession1;
    public void initialize () {
        userSession1 = UserSession.getInstance();
    }
    @FXML
    public void char1(MouseEvent mouseEvent)throws IOException {
        userSession1.setCharacter("1");
        Parent gameRoot = FXMLLoader.load(getClass().getResource("/View/select_character_player2.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(gameRoot);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void char2(MouseEvent mouseEvent)throws IOException {
        userSession1.setCharacter("2");
        Parent gameRoot = FXMLLoader.load(getClass().getResource("/View/select_character_player2.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(gameRoot);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void char3(MouseEvent mouseEvent)throws IOException {
        userSession1.setCharacter("3");
        Parent gameRoot = FXMLLoader.load(getClass().getResource("/View/select_character_player2.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(gameRoot);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void char4(MouseEvent mouseEvent)throws IOException {
        userSession1.setCharacter("4");
        Parent gameRoot = FXMLLoader.load(getClass().getResource("/View/select_character_player2.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(gameRoot);
        stage.setScene(scene);
        stage.show();
    }
}
