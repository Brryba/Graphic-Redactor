package storage;

import figures.Figure;
import services.RedoFigureManager;
import services.UndoFigureManager;

import java.io.Serializable;
import java.util.*;

public class Figures implements Serializable {
    static private Deque<Figure> figures = new ArrayDeque<>();

    public static ArrayList<Figure> getFiguresList() {
        return new ArrayList<>(figures);
    }

    public static void createFigures(Collection<Figure> addedFigures) {
        figures = new ArrayDeque<>(addedFigures);
        RedoFigureManager.clear();
    }
    public static void addFigure(Figure figure) {
        figures.add(figure);
    }

    public static Figure removeLast() {
        if (figures.isEmpty()) {
            return null;
        }
        return figures.removeLast();
    }

    public static int lastFigureIndex() {
        return figures.size() - 1;
    }

    public static void clearFigures() {
        figures.clear();
    }
}
