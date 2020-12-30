import javax.swing.*;
import java.io.*;

public class Main {
    public static AppGUI gui;

    public static void main(String[] args) {
        try {
            init();
            System.out.println("COMPLETE");
            SwingUtilities.invokeLater(gui);
        } catch (IOException ignored) {}
    }

    public static void init() throws IOException {
        boolean firstTime = false;
        File f = new File("C:\\Users\\Bradley\\Documents\\AFKScriptMaker\\temp"); //"C:\\Program Files\\AFKScriptMaker\\temp"

        if (!f.exists()) {
            if (f.getParentFile().mkdirs()) {
                f = new File(f.getPath());
                f.createNewFile();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeBoolean(false);
                oos.flush();
                oos.close();

                f = new File (f.getParentFile().getPath() + "\\Scripts");
                f.mkdir();
            }
        } else {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            firstTime = ois.readBoolean();
            ois.close();
        }

        gui = new AppGUI(firstTime);
    }
}
