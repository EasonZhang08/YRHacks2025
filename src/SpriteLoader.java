import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class SpriteLoader {
    private static final HashMap<String, Image> sprites = new HashMap<>();

    public static Image getSprite(String name) {
        if (!sprites.containsKey(name)) {
            // Load from /sprites/<name>.png
            ImageIcon icon = new ImageIcon(SpriteLoader.class.getResource("/sprites/" + name + ".png"));
            Image img = icon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // Adjust size as needed
            sprites.put(name, img);
        }
        return sprites.get(name);
    }

    public static Image load(String name) {
        if (!sprites.containsKey(name)) {
            try {
                ImageIcon icon = new ImageIcon(SpriteLoader.class.getResource("/sprites/" + name + ".png"));
                Image img = icon.getImage();
                sprites.put(name, img);
            } catch (Exception e) {
                System.err.println("Failed to load image: " + name);
                sprites.put(name, null); // avoid reloading bad path
            }
        }
        return sprites.get(name);
    }
}