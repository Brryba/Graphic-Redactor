module graphic_editor {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires xstream;
    requires static lombok;

    opens GUI to javafx.fxml;
    exports GUI;
    exports figures;
    exports figures.simple;
    exports figures.complex;
    exports storage;
    exports figures.interfaces;
    exports plugins;

    opens figures to xstream;
    opens figures.simple to xstream;
    opens figures.complex to xstream;
    opens figures.interfaces to xstream;
}