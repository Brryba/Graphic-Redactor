package figures.interfaces;

import javafx.scene.canvas.GraphicsContext;

public interface Drawable {
    void draw(GraphicsContext gc);
    void setEndCoords(double endX, double endY);
}
