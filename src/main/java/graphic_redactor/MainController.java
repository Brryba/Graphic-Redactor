package graphic_redactor;

import figures.*;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML
    private DrawingCanvas canvas;
    private Figure figure;
    private final List<Figure> figures = new ArrayList<>();
    @FXML
    private ToggleGroup figuresToggleGroup;

    public void onMousePressed(MouseEvent event) {
        if (figure == null) {
            figure = createFigure(event.getX(), event.getY());
            figures.add(figure);
        } else if (figure instanceof ComplexFigure) {
            ((ComplexFigure) figure).addPoint(event.getX(), event.getY());
        }
        canvas.redraw(figures);
    }

    public void onMouseDragged(MouseEvent event) {
        figure.setEndCoords(event.getX(), event.getY());
        canvas.redraw(figures);
    }

    public void onMouseReleased(MouseEvent event) {
        if (!(figure instanceof ComplexFigure)) {
            figure = null;
        }
    }

    public void onKeyPress(KeyEvent event) {
        if (figure instanceof ComplexFigure && event.getCode() == KeyCode.ENTER) {
            figure = null;
        }
    }

    public void ignoreEnterButton(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            ((ToggleButton)event.getSource()).setSelected(false);
            onKeyPress(event);
        }
    }

    private Figure createFigure(double startX, double startY) {
        return switch (figuresToggleGroup.getSelectedToggle().getUserData().toString()) {
            case ("LINE") -> new Line(startX, startY, startX, startY);
            case ("ELLIPSE") -> new Ellipse(startX, startY, startX, startY);
            case ("RECTANGULAR") -> new Rectangular(startX, startY, startX, startY);
            case ("BROKEN_LINE") -> new BrokenLine(startX, startY);
            case ("POLYGON") -> new Polygon(startX, startY);
            default -> null;
        };
    }

    @FXML
    public void initialize() {
        figuresToggleGroup.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {
            if (newToggle == null) {
                figuresToggleGroup.selectToggle(oldToggle);
            }
        });
    }
}