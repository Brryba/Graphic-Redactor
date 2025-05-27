package plugins;

import figures.Figure;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader {
    private static final String PLUGINS_DIRECTORY_PATH = "used-plugins";

    public List<Class<? extends SimpleFigurePlugin>> loadClasses() {
        try {
            File dir = new File(PLUGINS_DIRECTORY_PATH);
            File[] jarFiles = dir.listFiles((dir1, name) ->
                    name.toLowerCase().endsWith(".jar"));

            if (jarFiles == null || jarFiles.length == 0) {
                return null;
            }

            URL[] urls = new URL[jarFiles.length];
            for (int i = 0; i < jarFiles.length; i++) {
                urls[i] = jarFiles[i].toURI().toURL();
            }

            try (URLClassLoader cl = URLClassLoader.newInstance(urls)) {
                List<Class<? extends SimpleFigurePlugin>> classes = new ArrayList<>();
                for (File jarFile : jarFiles) {
                    try (JarFile jar = new JarFile(jarFile)) {
                        Enumeration<JarEntry> entries = jar.entries();

                        while (entries.hasMoreElements()) {
                            JarEntry jarEntry = entries.nextElement();
                            if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(".class")) {
                                continue;
                            }

                            String className = jarEntry.getName()
                                    .replace('/', '.')
                                    .replace(".class", "");

                            try {
                                Class<?> c = cl.loadClass(className);
                                classes.add((Class<? extends SimpleFigurePlugin>) c);
                            } catch (NoClassDefFoundError | ClassNotFoundException e) {
                                System.out.println("  Не удалось загрузить класс: " + className +
                                        ":\n" + e.getMessage());
                            }
                        }
                    }
                }
                return classes;
            }
        } catch (Exception e) {
            System.err.println("Error loading plugins from " + PLUGINS_DIRECTORY_PATH + ":\n" + e.getMessage());
            return null;
        }
    }
}
