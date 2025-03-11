package figures.simple;

import figures.Figure;
import javafx.geometry.Point2D;

public abstract class SimpleFigure extends Figure {
    protected Point2D start, end;
    public void setEndCoords(double endX, double endY) {
        this.end = new Point2D(endX, endY);
    }

    public SimpleFigure(double startX, double startY) {
        this.start = new Point2D(startX, startY);
        this.end = new Point2D(startX, startY);
    }
}