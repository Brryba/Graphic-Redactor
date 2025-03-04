package figures.complex;

import figures.Figure;
import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.List;

public abstract class ComplexFigure extends Figure {
    protected List<Point2D> coords;

    public void addPoint(double newX, double newY) {
        this.coords.add(new Point2D(newX, newY));
    }

    @Override
    public void setEndCoords(double endX, double endY) {
        coords.set(coords.size() - 1, new Point2D(endX, endY));
    }

    ComplexFigure(double startX, double startY) {
        this.coords = new ArrayList<>(List.of(new Point2D(startX, startY), new Point2D(startX, startY)));
    }
}
