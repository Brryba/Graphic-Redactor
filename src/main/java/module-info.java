module org.example.graphic_editor {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens graphic_redactor to javafx.fxml;
    exports graphic_redactor;
    exports figures;
}