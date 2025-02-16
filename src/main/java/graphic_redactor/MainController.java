package graphic_redactor;

import Figures.Figure;
import Figures.Line;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    @FXML
    private DrawingCanvas canvas;
    private final List<Figure> figures = new ArrayList<>();

    public void onMousePressed(MouseEvent event) {
        Figure figure = new Line(event.getX(), event.getY(), event.getX(), event.getY());
        figures.add(figure);
    }

    public void onMouseDragged(MouseEvent event) {
        Figure curr = figures.getLast();
        curr.setEndCoords(event.getX(), event.getY());
        canvas.redraw(figures);
    }
}