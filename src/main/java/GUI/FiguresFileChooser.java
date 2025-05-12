package GUI;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.Setter;

import java.io.File;

public class FiguresFileChooser {
    @Setter
    private static Stage stage;

    private final String DEFAULT_EXT = "*.xml";
    private final String FILE_EXT_LABEL = "xml файл (" + DEFAULT_EXT + ")";

    public File selectReadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть файл");

        fileChooser.getExtensionFilters().add(new FileChooser
                .ExtensionFilter(FILE_EXT_LABEL, DEFAULT_EXT));

        return fileChooser.showOpenDialog(stage);
    }

    public File selectSaveFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранить файл");

        fileChooser.getExtensionFilters().add(new FileChooser
                .ExtensionFilter(FILE_EXT_LABEL, DEFAULT_EXT));

        return fileChooser.showSaveDialog(stage);
    }
}
