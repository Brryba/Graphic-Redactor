package figures.complex;

import javafx.scene.canvas.GraphicsContext;

public class BrokenLine extends ComplexFigure{
    public BrokenLine(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        for (int i = 1; i < coords.size(); i++) {
            gc.moveTo(coords.get(i - 1).getX(), coords.get(i - 1).getY());
            gc.lineTo(coords.get(i).getX(), coords.get(i).getY());
            gc.stroke();
        }
    }
}
