package figures;

import javafx.scene.canvas.GraphicsContext;

public abstract interface Figure {

    public abstract void draw(GraphicsContext gc);

    public void setEndCoords(double endX, double endY);
}