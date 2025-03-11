package services;

import figures.Figure;
import storage.Figures;

import java.util.ArrayDeque;
import java.util.Deque;

public class RedoFigureManager {
    private RedoFigureManager() {}
    private static final Deque<Figure> redoableDeque = new ArrayDeque<>();

    public static void add(Figure figure) {
        redoableDeque.addLast(figure);
    }

    public static void redo() {
        if (redoableDeque.isEmpty()) {
            return;
        }
        Figure figure = redoableDeque.removeLast();
        Figures.addFigure(figure);
    }
}
