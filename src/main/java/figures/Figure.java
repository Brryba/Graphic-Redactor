package figures;

import figures.interfaces.Colorable;
import figures.interfaces.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.*;

public abstract class Figure implements Drawable, Colorable, Serializable {
    public record Point(double x, double y) implements Serializable {}
    public record SerializableColor(double red, double green, double blue, double opacity) implements Serializable {
        public SerializableColor(Color color) {
            this(color.getRed(), color.getGreen(), color.getBlue(), color.getOpacity());
        }
        public Color toColor() {
            return new Color(red, green, blue, opacity);
        }
    }
    protected SerializableColor figureColor;
    protected SerializableColor borderColor;
    protected double thickness = 0;

    @Override
    public void setFigureColor(Color figureColor) {
        this.figureColor = new SerializableColor(figureColor);
    }

    @Override
    public void setBorderColor(Color borderColor) {
        this.borderColor = new SerializableColor(borderColor);
    }

    @Override
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(this.thickness);
        if (this.thickness > 0)
            gc.setStroke(this.borderColor.toColor());
        else {
            gc.setStroke(Color.TRANSPARENT);
        }
        gc.setFill(this.figureColor.toColor());
    }
}