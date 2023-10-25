module ec.edu.espol.eddproyecto.fxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espol.eddproyecto.fxml to javafx.fxml;
    exports ec.edu.espol.eddproyecto.fxml;
}
