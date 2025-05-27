package plugins;

import figures.simple.SimpleFigure;
import javafx.scene.canvas.GraphicsContext;

public abstract class SimpleFigurePlugin extends SimpleFigure {
    public SimpleFigurePlugin(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public final void draw(GraphicsContext gc) {
        super.draw(gc);
        drawPlugin(gc);
    }

    protected abstract void drawPlugin(GraphicsContext gc);
}
