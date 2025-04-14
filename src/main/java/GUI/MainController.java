package GUI;

import figures.*;
import figures.complex.*;
import figures.simple.*;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import services.*;
import storage.Figures;

import java.io.IOException;
import java.util.List;

public class MainController {
    @FXML
    private DrawingCanvas canvas;
    private Figure currentFigure;
    @FXML
    public ComboBox<String> figureTypeSelector;
    @FXML
    private ColorPicker borderColorPicker;
    @FXML
    private ColorPicker figureColorPicker;
    @FXML
    private Slider thicknessSelector;
    private final services.FileReader fileReader = new FileReader();
    private final services.FileSaver fileSaver = new FileSaver();
    private final FigureFabric figureFabric = new FigureFabric();

    public void onMousePressed(MouseEvent event) {
        if (currentFigure == null) {
            currentFigure = createFigure(event.getX(), event.getY());
            Figures.addFigure(currentFigure);
            RedoFigureManager.clear();
        } else if (currentFigure instanceof ComplexFigure) {
            ((ComplexFigure) currentFigure).addPoint(event.getX(), event.getY());
        }
        canvas.redraw(Figures.getFiguresList());
    }

    public void onMouseDragged(MouseEvent event) {
        currentFigure.setEndCoords(event.getX(), event.getY());
        canvas.redraw(Figures.getFiguresList());
    }

    public void onMouseReleased() {
        if (currentFigure instanceof SimpleFigure) {
            currentFigure.setFinished(true);
            currentFigure = null;
        }
        canvas.redraw(Figures.getFiguresList());
    }

    public void onKeyPress(KeyEvent event) {
        if (currentFigure instanceof ComplexFigure && event.getCode() == KeyCode.ENTER) {
            currentFigure.setFinished(true);
            currentFigure = null;
        }
        canvas.redraw(Figures.getFiguresList());
    }

    @FXML
    public void read() {
        List<Figure> figures = null;
        try {
            figures = fileReader.open();
        } catch (IOException e) {
            new ErrorViewer().showError("Figures were not opened",
                    "Error opening figures");
        } catch (ClassNotFoundException | ClassCastException e) {
            new ErrorViewer().showError("Figures were not opened",
                    "File information is broken");
        }
        if (figures != null) {
            Figures.createFigures(figures);
        }
        canvas.redraw(Figures.getFiguresList());
    }

    @FXML
    public void save() {
        try {
            fileSaver.save();
        } catch (IOException e) {
            new ErrorViewer().showError("Figures were not saved",
                    "Error writing figures");
        }
    }

    @FXML
    public void undo() {
        UndoFigureManager.undo();
        canvas.redraw(Figures.getFiguresList());
    }

    @FXML
    public void redo() {
        RedoFigureManager.redo();
        canvas.redraw(Figures.getFiguresList());
    }

    @FXML
    public void onKeyReleased(KeyEvent event) {
        if (new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_ANY)
                .match(event)) {
            undo();
        } else if (new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_ANY, KeyCombination.SHIFT_ANY)
                .match(event)) {
            redo();
        } else if (new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_ANY)
                .match(event)) {
            read();
        } else if (new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_ANY)
                .match(event)) {
            save();
        }
    }

    private Figure createFigure(double startX, double startY) {
        figureFabric.setFigureParams(figureColorPicker.getValue(),
                borderColorPicker.getValue(), startX, startY, thicknessSelector.getValue());
        try {
            return figureFabric.createFigure(figureTypeSelector.getValue());
        } catch (ReflectiveOperationException e) {
            new ErrorViewer().showError("Error creating the figure",
                    "Your figure was not created :(");
            return null;
        }
    }

    @FXML
    public void initialize() {
        borderColorPicker.setValue(Color.BLACK);
        figureTypeSelector.getItems().addAll(figureFabric.getAllFigureNames());
    }
}