package citywars.finalproject.Controller;

import citywars.finalproject.Model.UserSession;
import citywars.finalproject.Model.UserSession2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class WinOver {

    @FXML
    public ImageView playGameOver;
    @FXML
    public Label levelp1;
    @FXML
    public Label levelp2;
    @FXML
    public Label coinp1;
    @FXML
    public Label coinp2;
    public UserSession userSession1;
    public UserSession2 userSession2;


    public void initialize() {
        userSession1 = UserSession.getInstance();
        userSession2 = UserSession2.getInstance();
        coinp2.setText(Double.toString(userSession2.getCoin()));
        coinp1.setText(Double.toString(userSession1.getCoin()));
        levelp1.setText(Double.toString(userSession1.getLevel()));
        levelp2.setText(Double.toString(userSession2.getLevel()));

    }

    public void back(MouseEvent mouseEvent) throws IOException {
        Parent gameRoot = FXMLLoader.load(getClass().getResource("/View/game-menu.fxml"));
        Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(gameRoot);
        stage.setScene(scene);
        stage.show();
    }
}
