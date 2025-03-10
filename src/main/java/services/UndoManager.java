package services;

import figures.Figure;
import storage.Figures;

public class UndoManager {
    private UndoManager() {}

    public static void undo() {
        Figures.deleteLast();
    }
}
