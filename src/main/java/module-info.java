module org.example.graphic_editor {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens GUI to javafx.fxml;
    exports GUI;
    exports figures;
    exports figures.simple;
    exports figures.complex;
    exports storage;
}