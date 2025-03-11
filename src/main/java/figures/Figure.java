package figures;

import figures.interfaces.Colorable;
import figures.interfaces.Drawable;
import figures.interfaces.Undoable;
import javafx.scene.paint.Color;

public abstract class Figure implements Drawable, Undoable, Colorable {
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
}