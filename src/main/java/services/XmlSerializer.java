package services;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import javafx.scene.paint.Color;
import plugins.SimpleFigurePlugin;

import java.util.List;

public class XmlSerializer extends XStream {
    private XmlSerializer() {
    }

    {
        this.registerConverter(new ColorConverter());
        this.allowTypesByWildcard(new String[] {"figures.**"});
    }

    private static XmlSerializer instance;

    public static XmlSerializer getInstance() {
        if (instance == null) {
            instance = new XmlSerializer();
        }
        return instance;
    }

    public void addSupportedClasses(List<Class<? extends SimpleFigurePlugin>> classes) {
        String[] classNames = classes.stream()
                .map(Class::getName)
                .toArray(String[]::new);
        instance.allowTypes(classNames);

        for (Class<? extends SimpleFigurePlugin> clazz : classes) {
            ClassLoader pluginLoader = clazz.getClassLoader();
            instance.setClassLoader(pluginLoader);
        }
    }

    private static class ColorConverter implements Converter {
        @Override
        public boolean canConvert(Class aClass) {
            return aClass.equals(Color.class);
        }

        @Override
        public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {
            Color color = (Color) o;
            writeColor(writer, "red", color.getRed());
            writeColor(writer, "green", color.getGreen());
            writeColor(writer, "blue", color.getBlue());
            writeColor(writer, "opacity", color.getOpacity());
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
            double red = readColor(hierarchicalStreamReader);
            double green = readColor(hierarchicalStreamReader);
            double blue = readColor(hierarchicalStreamReader);
            double opacity = readColor(hierarchicalStreamReader);
            return new Color(red, green, blue, opacity);
        }

        private void writeColor(HierarchicalStreamWriter writer, String key, double value) {
            writer.startNode(key);
            writer.setValue(String.valueOf(value));
            writer.endNode();
        }

        private double readColor(HierarchicalStreamReader reader) {
            reader.moveDown();
            double value = Double.parseDouble(reader.getValue());
            reader.moveUp();
            return value;
        }
    }
}
