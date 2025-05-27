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
        XmlSerializer serializer = XmlSerializer.getInstance();
        try (InputStream ois = new FileInputStream(file)) {
            return (List<Figure>) serializer.fromXML(ois);
        }
    }
}
