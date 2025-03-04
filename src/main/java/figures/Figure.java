package figures;

import javafx.scene.canvas.GraphicsContext;

public abstract class Figure {
    public abstract void draw(GraphicsContext gc);
    public abstract void setEndCoords(double endX, double endY);
}