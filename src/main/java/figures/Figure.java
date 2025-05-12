package figures;

import figures.interfaces.Colorable;
import figures.interfaces.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public abstract class Figure implements Drawable, Colorable {
    @Data
    @AllArgsConstructor
    public static class Point {
        private double x;
        private double y;
    }

    protected Color figureColor;
    protected Color borderColor;
    protected double thickness = 0;
    protected boolean isFinished = false;

    @Override
    public void setFigureColor(Color figureColor) {
        this.figureColor = figureColor;
    }

    @Override
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(this.thickness);
        if (this.thickness > 0)
            gc.setStroke(this.borderColor);
        else {
            gc.setStroke(Color.TRANSPARENT);
        }
        gc.setFill(this.figureColor);
    }
}