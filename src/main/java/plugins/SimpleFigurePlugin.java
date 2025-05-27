package plugins;

import figures.simple.SimpleFigure;
import javafx.scene.canvas.GraphicsContext;

public abstract class SimpleFigurePlugin extends SimpleFigure {
    protected Point start, end;

    public SimpleFigurePlugin(double startX, double startY) {
        super(startX, startY);
    }

    public abstract String getName();

    @Override
    public abstract void draw(GraphicsContext gc);
}
