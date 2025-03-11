package figures.complex;

import figures.Figure;
import java.util.ArrayList;
import java.util.List;

public abstract class ComplexFigure extends Figure {
    protected List<Point> coords;

    public void addPoint(double newX, double newY) {
        this.coords.add(new Point(newX, newY));
    }

    @Override
    public void setEndCoords(double endX, double endY) {
        coords.set(coords.size() - 1, new Point(endX, endY));
    }

    ComplexFigure(double startX, double startY) {
        this.coords = new ArrayList<>(List.of(new Point(startX, startY), new Point(startX, startY)));
    }
}
