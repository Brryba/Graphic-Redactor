package figures;

import javafx.scene.canvas.GraphicsContext;

public class BrokenLine extends ComplexFigure {
    public BrokenLine(double startX, double startY) {
        super(startX, startY);
    }

    @Override
    public void draw(GraphicsContext gc) {
        for (int i = 1; i < coordsX.size(); i++) {
            gc.moveTo(coordsX.get(i - 1), coordsY.get(i - 1));
            gc.lineTo(coordsX.get(i), coordsY.get(i));
            gc.stroke();
        }
    }
}
