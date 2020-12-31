import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class InputWatcher {
    public static HashMap<Integer, Boolean> buttonsDown = new HashMap<>();
    public static Point mousePosition = new Point(0,0);
    public static double scrollRotation = 0;
    public static boolean mouseDown = false;

    public static MouseAdapter clickHandler = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            mouseDown = true;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDown = false;
        }
    };

    public static MouseAdapter scrollHandler = new MouseAdapter() {
        public void mouseWheelMoved(MouseWheelEvent e) {
            scrollRotation = e.getWheelRotation();
        }
    };

    public static MouseAdapter movementHandler = new MouseAdapter() {
        public void mouseMoved(MouseEvent e) {
            mousePosition = e.getPoint();
        }
    };

    public static void initMap() {
        buttonsDown.put(KeyEvent.VK_0, false);
        buttonsDown.put(KeyEvent.VK_1, false);
        buttonsDown.put(KeyEvent.VK_2, false);
        buttonsDown.put(KeyEvent.VK_3, false);
        buttonsDown.put(KeyEvent.VK_4, false);
        buttonsDown.put(KeyEvent.VK_5, false);
        buttonsDown.put(KeyEvent.VK_6, false);
        buttonsDown.put(KeyEvent.VK_7, false);
        buttonsDown.put(KeyEvent.VK_8, false);
        buttonsDown.put(KeyEvent.VK_9, false);
        buttonsDown.put(KeyEvent.VK_Q, false);
        buttonsDown.put(KeyEvent.VK_W, false);
        buttonsDown.put(KeyEvent.VK_E, false);
        buttonsDown.put(KeyEvent.VK_R, false);
        buttonsDown.put(KeyEvent.VK_T, false);
        buttonsDown.put(KeyEvent.VK_Y, false);
        buttonsDown.put(KeyEvent.VK_U, false);
        buttonsDown.put(KeyEvent.VK_I, false);
        buttonsDown.put(KeyEvent.VK_O, false);
        buttonsDown.put(KeyEvent.VK_P, false);
        buttonsDown.put(KeyEvent.VK_A, false);
        buttonsDown.put(KeyEvent.VK_S, false);
        buttonsDown.put(KeyEvent.VK_D, false);
        buttonsDown.put(KeyEvent.VK_F, false);
        buttonsDown.put(KeyEvent.VK_G, false);
        buttonsDown.put(KeyEvent.VK_H, false);
        buttonsDown.put(KeyEvent.VK_J, false);
        buttonsDown.put(KeyEvent.VK_K, false);
        buttonsDown.put(KeyEvent.VK_L, false);
        buttonsDown.put(KeyEvent.VK_SEMICOLON, false);
        buttonsDown.put(KeyEvent.VK_Z, false);
        buttonsDown.put(KeyEvent.VK_X, false);
        buttonsDown.put(KeyEvent.VK_C, false);
        buttonsDown.put(KeyEvent.VK_V, false);
        buttonsDown.put(KeyEvent.VK_B, false);
        buttonsDown.put(KeyEvent.VK_N, false);
        buttonsDown.put(KeyEvent.VK_M, false);
        buttonsDown.put(KeyEvent.VK_COMMA, false);
        buttonsDown.put(KeyEvent.VK_PERIOD, false);
        buttonsDown.put(KeyEvent.VK_SPACE, false);
        buttonsDown.put(KeyEvent.VK_TAB, false);
        buttonsDown.put(KeyEvent.VK_BACK_SPACE, false);
        buttonsDown.put(KeyEvent.VK_ENTER, false);
        buttonsDown.put(KeyEvent.VK_SHIFT, false);
        buttonsDown.put(KeyEvent.VK_CONTROL, false);
        buttonsDown.put(KeyEvent.VK_ALT, false);
        buttonsDown.put(KeyEvent.VK_DELETE, false);
        buttonsDown.put(KeyEvent.VK_UP, false);
        buttonsDown.put(KeyEvent.VK_DOWN, false);
        buttonsDown.put(KeyEvent.VK_LEFT, false);
        buttonsDown.put(KeyEvent.VK_RIGHT, false);
        buttonsDown.put(KeyEvent.VK_BACK_QUOTE, false);
        buttonsDown.put(KeyEvent.VK_SLASH, false);
    }

    public static ArrayList<Integer> getButttonsDown() {
        ArrayList<Integer> buttons = new ArrayList<>();

        for (int key : buttonsDown.keySet().toArray(new Integer[buttonsDown.keySet().size()])) {
            if (buttonsDown.get(key)) {
                buttons.add(key);
            }
        }

        return buttons;
    }

    public static KeyEventDispatcher dispatcher = ke -> {
        synchronized (InputWatcher.class) {
            if (ke.getID() == KeyEvent.KEY_PRESSED) {
                if (!buttonsDown.get(ke.getKeyCode())) {
                    System.out.println(KeyEvent.getKeyText(ke.getKeyCode()) + " is pressed");
                    buttonsDown.put(ke.getKeyCode(), true);
                }
            } else if (ke.getID() == KeyEvent.KEY_RELEASED) {
                System.out.println(KeyEvent.getKeyText(ke.getKeyCode()) + " is released");
                buttonsDown.put(ke.getKeyCode(), false);
            }
        }
        return false;
    };
}
