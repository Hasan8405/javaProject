module citywars.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
//    requires rt;
//    requires jfxrt;


    opens citywars.finalproject to javafx.fxml;
    exports citywars.finalproject;
    exports citywars.finalproject.Controller;
    opens citywars.finalproject.Controller to javafx.fxml;
}