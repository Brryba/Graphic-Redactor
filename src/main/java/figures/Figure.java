package figures;

import javafx.scene.canvas.GraphicsContext;

public interface Figure {
    void draw(GraphicsContext gc);
    void setEndCoords(double endX, double endY);
}