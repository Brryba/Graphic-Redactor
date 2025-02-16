module org.example.graphic_editor {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.graphic_editor to javafx.fxml;
    exports org.example.graphic_editor;
}