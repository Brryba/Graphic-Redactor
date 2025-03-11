package figures;

import figures.interfaces.Colorable;
import figures.interfaces.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Figure implements Drawable, Colorable {
    protected Color figureColor = Color.BLUE;
    protected Color borderColor = Color.BLACK;
    protected double thickness = 0;

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