package plugins;

import figures.Figure;

public interface Plugin {
    String getName();
    Figure create();
    Figure getInstance();
}
