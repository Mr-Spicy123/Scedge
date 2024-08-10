package GUIs;
import Misc.ImageIconScaler;
import Misc.ScalePos;
import Misc.ScreenInfo;
import Misc.SwingSetup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClass {

    ActionListener listener;
    JFrame frame = new JFrame();

    public AddClass() {

        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source instanceof JButton) {
                    JButton button = (JButton) source;
                    String currentItem = "";
                    switch (button.getText()) {
                        case "exit":
                            frame.dispose();
                            System.exit(0);
                            break;
                        case "back":
                            new Menu();
                            frame.dispose();
                            break;
                    }
                }
            }
        };

        SwingSetup.setupFrame(frame, 0, 0, ScreenInfo.screenWidth, ScreenInfo.screenHeight, false, null);
        frame.setUndecorated(true);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(frame);

        JLayeredPane panel = new JLayeredPane();
        panel.setLayout(null);
        panel.setBounds(0, 0, ScreenInfo.screenWidth, ScreenInfo.screenHeight);
        frame.add(panel);

        ImageIcon bgImage = ImageIconScaler.scaleImageIcon(new ImageIcon("Images/Backgrounds/SCEDGE_AddClass.png"), ScreenInfo.screenWidth, ScreenInfo.screenHeight);
        JLabel bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, ScreenInfo.screenWidth, ScreenInfo.screenHeight);
        panel.add(bgLabel, JLayeredPane.DEFAULT_LAYER);

        JButton exit = new JButton("exit");
        int x1 = ScalePos.scaleWidth(1230), y1 = ScalePos.scaleHeight(0), width1 = ScalePos.scaleWidth(50), height1 = ScalePos.scaleHeight(50);
        SwingSetup.setupInvisibleButton(exit, panel, listener, x1, y1, width1, height1, false, false);

        JButton back = new JButton("back");
        int x2 = ScalePos.scaleWidth(0), y2 = ScalePos.scaleHeight(0), width2 = ScalePos.scaleWidth(250), height2 = ScalePos.scaleHeight(100);
        SwingSetup.setupInvisibleButton(back, panel, listener, x2, y2, width2, height2, false, false);

        frame.setVisible(true);
    }
}
