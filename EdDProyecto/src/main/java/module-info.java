module ec.edu.espol.eddproyecto.fxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.eddproyecto.fxml to javafx.fxml;
    exports ec.edu.espol.eddproyecto.clases;
    exports ec.edu.espol.eddproyecto.fxml;
    opens ec.edu.espol.eddproyecto.clases to javafx.base;
}
