package utils;

import figures.Figure;
import figures.complex.Undoable;
import figures.simple.SimpleFigure;
import storage.Figures;

public class UndoManager {
    private UndoManager() {}

    public static void undo() {
        Figure curr = Figures.getLast();
        if (curr instanceof Undoable undoableFigure) {
            undoFigure(undoableFigure);
        }
        else if (curr instanceof SimpleFigure) {
            Figures.deleteLast();
        }
    }

    private static void undoFigure(Undoable figure) {
        figure.deletePoint();
        if (figure.isEmpty()) {
            Figures.deleteLast();
        }
    }
}
