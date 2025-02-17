package figures.simple;

import figures.Figure;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public abstract class SimpleFigure implements Figure {
    protected Point2D start, end;

    public abstract void draw(GraphicsContext gc);

    public void setEndCoords(double endX, double endY) {
        this.end = new Point2D(endX, endY);
    }

    public SimpleFigure(double startX, double startY, double endX, double endY) {
        this.start = new Point2D(startX, startY);
        this.end = new Point2D(endX, endY);
    }
}