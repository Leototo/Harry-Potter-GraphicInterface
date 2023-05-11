module com.example.hpgraph {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.hpgraph to javafx.fxml;
    exports com.example.hpgraph;
}