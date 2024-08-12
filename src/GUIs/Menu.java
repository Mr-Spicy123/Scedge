package GUIs;

import Misc.ScalePos;
import Misc.ScreenInfo;
import Misc.SwingSetup;
import Misc.ImageIconScaler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    ActionListener listener;


    static JFrame frame = new JFrame();

    public Menu() {

        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source instanceof JButton) {
                    JButton button = (JButton) source;
                    switch (button.getText()) {
                        case "exit":
                            frame.setVisible(false);
                            System.exit(0);
                            break;
                        case "add class":
                            new AddClass();
                            frame.dispose();
                            break;
                        case "view schedule":
                            System.exit(0);
                            break;
                        case "add event":
                            new AddEvent();
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
        frame.setContentPane(panel);
        ImageIcon bgImage = ImageIconScaler.scaleImageIcon(new ImageIcon("Images/Backgrounds/SCEDGE_HomeScreen.png"), ScreenInfo.screenWidth, ScreenInfo.screenHeight);
        JLabel bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, ScreenInfo.screenWidth, ScreenInfo.screenHeight);
        panel.add(bgLabel, JLayeredPane.DEFAULT_LAYER);

        JButton exit = new JButton("exit");
        int x1 = ScalePos.scaleWidth(1230), y1 = ScalePos.scaleHeight(0), width1 = ScalePos.scaleWidth(50), height1 = ScalePos.scaleHeight(50);
        SwingSetup.setupInvisibleButton(exit, panel, listener, x1, y1, width1, height1, false, false);

        JButton addClass = new JButton("add class");
        int x2 = ScalePos.scaleWidth(50), y2 = ScalePos.scaleHeight(508), width2 = ScalePos.scaleWidth(380), height2 = ScalePos.scaleHeight(130);
        SwingSetup.setupInvisibleButton(addClass, panel, listener, x2, y2, width2, height2, false, false);

        JButton viewSchedule = new JButton("view schedule");
        int x3 = ScalePos.scaleWidth(462), y3 = ScalePos.scaleHeight(508), width3 = ScalePos.scaleWidth(380), height3 = ScalePos.scaleHeight(130);
        SwingSetup.setupInvisibleButton(viewSchedule, panel, listener, x3, y3, width3, height3, false, false);

        JButton addEvent = new JButton("add event");
        int x4 = ScalePos.scaleWidth(866), y4 = ScalePos.scaleHeight(508), width4 = ScalePos.scaleWidth(380), height4 = ScalePos.scaleHeight(130);
        SwingSetup.setupInvisibleButton(addEvent, panel, listener, x4, y4, width4, height4, true, false);

        frame.setVisible(true);

    }

    public static void delay(int mills) {
        try  {
            Thread.sleep(mills);
        }catch(InterruptedException e){
        }
    }
}
