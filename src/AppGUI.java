import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class AppGUI implements Runnable {
    private boolean firstTime;
    private JFrame appFrame;
    private Robot robot;
    private Timer clock;

    public AppGUI(boolean firstTime) {
        InputWatcher.initMap();
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        this.firstTime = firstTime;
    }

    @Override
    public void run() {
        initWindow();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(InputWatcher.dispatcher);
        clock = new Timer("Mouse Watcher");
        clock.scheduleAtFixedRate(new Clock(), 500, 50);
    }

    public void initWindow() {
        appFrame = new JFrame("Login");
        Container content = appFrame.getContentPane();
        content.setLayout(new BorderLayout());
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        appFrame.setSize(900, 600);
        appFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //appFrame.setUndecorated(true);
        appFrame.setLocationRelativeTo(null);
        appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel scriptPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(new JPanel(new GridBagLayout()));
        scriptPanel.add(scrollPane, BorderLayout.CENTER);

        content.add(scriptPanel, BorderLayout.WEST);

        appFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                clock.cancel();
                clock.purge();
                System.exit(0);
            }
        });

        appFrame.addMouseListener(InputWatcher.clickHandler);
        appFrame.addMouseMotionListener(InputWatcher.movementHandler);
        appFrame.addMouseWheelListener(InputWatcher.scrollHandler);
        appFrame.setVisible(true);
    }

    private class Clock extends TimerTask {
        /*public HashMap<Integer, Boolean> buttonsDown = new HashMap<>();
        public Point mousePosition = new Point(0,0);
        public double scrollRotation = 0;
        public boolean mouseDown = false;*/

        @Override
        public void run() {
            /*ArrayList<Integer> buttons = InputWatcher.getButttonsDown();
            if (buttons.size() > 0) {
                System.out.println("These are the buttons pressed: ");
                for (int button : buttons) {
                    System.out.print(KeyEvent.getKeyText(button) + ", ");
                }
                System.out.println();
            }*/
        }
    }
}
