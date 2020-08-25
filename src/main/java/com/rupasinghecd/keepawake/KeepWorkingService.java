package com.rupasinghecd.keepawake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class KeepWorkingService {

    public static void main(String[] args) throws AWTException {


        TrayIcon trayIcon = null;
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage("eye.png");
            // create a action listener to listen for default action executed on the tray icon
            ActionListener listener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            };
            PopupMenu popup = new PopupMenu();
            MenuItem defaultItem = new MenuItem();
            defaultItem.addActionListener(listener);
            popup.add(defaultItem);
            trayIcon = new TrayIcon(image, "keep awake", popup);
            // set the TrayIcon properties
            trayIcon.addActionListener(listener);

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println(e);
            }
        }
        keepAwake();
    }

    private static void keepAwake() throws AWTException {
        Robot hal = new Robot();
        Random random = new Random();
        while (true) {
            hal.delay(1000 * 60);
            int x = random.nextInt() % 640;
            int y = random.nextInt() % 480;
            hal.mouseMove(x, y);
        }
    }


}
