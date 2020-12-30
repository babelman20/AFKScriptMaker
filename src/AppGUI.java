import javax.swing.*;
import java.awt.*;

public class AppGUI implements Runnable {
    private boolean firstTime;
    private JFrame appFrame;

    public AppGUI(boolean firstTime) {
        this.firstTime = firstTime;
    }

    @Override
    public void run() {
        initWindow();
    }

    public void initWindow() {
        appFrame = new JFrame("Login");
        Container content = appFrame.getContentPane();
        content.setLayout(new BorderLayout());
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        appFrame.setSize(900, 600);
        appFrame.setLocationRelativeTo(null);
        appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        appFrame.setVisible(true);
    }
}
