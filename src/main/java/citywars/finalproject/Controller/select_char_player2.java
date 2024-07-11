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

public class select_char_player2 {
    public UserSession2 userSession2;
    public void initialize () {
        userSession2 = UserSession2.getInstance();
    }
    @FXML
    public void char1(MouseEvent mouseEvent) {
        userSession2.setCharacter("1");
    }
    @FXML
    public void char2(MouseEvent mouseEvent) {
        userSession2.setCharacter("2");
    }
    @FXML
    public void char3(MouseEvent mouseEvent) {
        userSession2.setCharacter("3");
    }
    @FXML
    public void char4(MouseEvent mouseEvent) {
        userSession2.setCharacter("4");
    }
    @FXML
    public void fight(MouseEvent mouseEvent)throws IOException {
        if (!userSession2.getCharacter().equals("")) {
            Parent gameRoot = FXMLLoader.load(getClass().getResource("/View/TwoPlayer_Game.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(gameRoot);
            stage.setScene(scene);
            stage.show();
        }
    }
}
