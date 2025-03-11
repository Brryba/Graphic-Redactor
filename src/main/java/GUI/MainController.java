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
import services.FigureFabric;
import services.RedoFigureManager;
import storage.Figures;
import services.UndoFigureManager;

public class MainController {
    @FXML
    private DrawingCanvas canvas;
    private Figure currentFigure;
    @FXML
    public ComboBox figureTypeSelector;
    @FXML
    private ColorPicker borderColorPicker;
    @FXML
    private ColorPicker figureColorPicker;
    @FXML
    private Slider thicknessSelector;

    public void onMousePressed(MouseEvent event) {
        if (currentFigure == null) {
            currentFigure = createFigure(event.getX(), event.getY());
            Figures.addFigure(currentFigure);
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
            currentFigure = null;
        }
        canvas.redraw(Figures.getFiguresList());
    }

    public void onKeyPress(KeyEvent event) {
        if (currentFigure instanceof ComplexFigure && event.getCode() == KeyCode.ENTER) {
            currentFigure = null;
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
        }
    }

    private Figure createFigure(double startX, double startY) {
        FigureFabric figureFabric = new FigureFabric(figureColorPicker.getValue(),
                borderColorPicker.getValue(), startX, startY, thicknessSelector.getValue());
        return figureFabric.createFigure(figureTypeSelector.getValue().toString());
    }

    @FXML
    public void initialize() {
        borderColorPicker.setValue(Color.BLACK);
    }
}