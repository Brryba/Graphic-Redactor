package services;

import GUI.FiguresFileChooser;
import figures.Figure;

import java.io.*;
import java.util.List;

public class FileReader {
    public List<Figure> open() throws IOException, ClassNotFoundException, ClassCastException {
        FiguresFileChooser fileChooser = new FiguresFileChooser();
        File file = fileChooser.selectReadFile();
        if (file == null) return null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<Figure> figures = (List<Figure>) ois.readObject();
            UndoFigureManager.setFirstFigureIndex(figures.size() - 1);
            return figures;
        }
    }
}
