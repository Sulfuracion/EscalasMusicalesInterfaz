module com.example.escalas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.escalas to javafx.fxml;
    exports com.example.escalas;
}