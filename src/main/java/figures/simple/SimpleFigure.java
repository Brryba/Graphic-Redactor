package figures.simple;

import figures.Figure;

public abstract class SimpleFigure extends Figure {
    protected Point start, end;
    public void setEndCoords(double endX, double endY) {
        this.end = new Point(endX, endY);
    }

    public SimpleFigure(double startX, double startY) {
        this.start = new Point(startX, startY);
        this.end = new Point(startX, startY);
    }
}