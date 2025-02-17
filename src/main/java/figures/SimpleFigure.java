package figures;

import javafx.scene.canvas.GraphicsContext;

public abstract class SimpleFigure implements Figure {
    protected double startX, startY, endX, endY;

    public abstract void draw(GraphicsContext gc);

    public void setEndCoords(double endX, double endY) {
        this.endX = endX;
        this.endY = endY;
    }

    public SimpleFigure(double startX, double startY, double endX, double endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}