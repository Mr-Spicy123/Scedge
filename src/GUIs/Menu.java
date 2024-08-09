package GUIs;

import Misc.ImageIconScaler;
import Misc.ScreenInfo;
import Misc.SwingSetup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    static int wid = ScreenInfo.screenWidth;
    static int hgt = ScreenInfo.screenHeight;

    ActionListener listener;


    static JFrame frame = new JFrame();
    public Menu() {

        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source instanceof JButton) {
                    JButton button = (JButton) source;
                    String currentItem = "";
                    switch (button.getText()) {
                        case "exit":
                            frame.setVisible(false);
                            System.exit(0);
                            break;
                    }
                }
            }
        };

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        frame = new JFrame();
        frame.setUndecorated(true);
        gd.setFullScreenWindow(frame);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(0, 0, wid, hgt);
        JLayeredPane panel = new JLayeredPane();
        panel.setLayout(null);
        frame.setContentPane(panel);
        ImageIcon bgImage = ImageIconScaler.scaleImageIcon(new ImageIcon("Images/Backgrounds/SCEDGE_HomeScreen.png"), wid, hgt);
        JLabel bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, wid, hgt);
        panel.add(bgLabel, JLayeredPane.DEFAULT_LAYER);
        frame.setVisible(true);

        JButton exit = new JButton("exit");
        int x = 1230, y = 0, width = 50, height = 50;
        SwingSetup.setupButton(exit, panel, listener, x, y, width, height, false, false);
    }
}
