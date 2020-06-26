package com.window;


import com.sun.net.httpserver.HttpServer;
import com.window.errors.CPUThreads;
import com.window.utils.AppData;
import com.window.utils.FileBrowser;

import javax.print.attribute.standard.JobHoldUntil;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
private static JTextArea area = new JTextArea();
private static OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    final static SystemTray tray = SystemTray.getSystemTray();
    private static TrayIcon tray2;

    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException, AWTException {
        JFrame f = new JFrame( "HARDWARE Management By Werwolf2303");
        if(os.getAvailableProcessors() == 1) {
            CPUThreads.create();
        }else {
            JMenuBar bar = new JMenuBar();
            JMenu info = new JMenu("Info");
            JMenuItem item = new JMenuItem("Info");
            JMenu tools = new JMenu("Tools");
            JMenu help = new JMenu("Hilfe");
            JMenuItem hilfe = new JMenuItem("Hilfe");
            JMenuItem ramfree = new JMenuItem("FreeRam");
            JMenuItem file = new JMenuItem("FileBrowser");
            ramfree.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        File f = new File(new AppData().getAppData + "FreeRAM.exe");
                        File myObj = new File(System.getenv("appdata") + "/applic");
                        if(f.exists()) {
                            Runtime.getRuntime().exec("cmd /c start %appdata%/applic/FreeRAM.exe");
                        }else{
                            Runtime.getRuntime().exec("cmd /c cd %appdata%/applic&wget werwolf2303.github.io/FreeRAM.exe");
                            Thread.sleep(99);
                            Runtime.getRuntime().exec("cmd /c start %appdata%/applic/FreeRAM.exe");
                        }
                        if (myObj.mkdir()) {} else {}

                    } catch (IOException e2) {
                        System.out.println("An error occurred.");
                        e2.printStackTrace();
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            });
            File photo = new File(new AppData().getAppData + "pc.png");
            if(photo.exists()) {
                f.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getenv("appdata") + "/applic/pc.png"));
            }else{
                Runtime.getRuntime().exec("cmd /c cd " + System.getenv("appdata") + "/applic" + "&wget werwolf2303.github.io/pc.png");
                Thread.sleep(2);
                f.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getenv("appdata") + "/applic/pc.png"));
            }
            help.add(item);
            bar.add(help);
            help.add(hilfe);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dia = new JDialog();
                    JPanel cent = new JPanel();
                    JLabel about = new JLabel(" HARDWARE Management ist aus einem Test entstanden");
                    JLabel l = new JLabel(new ImageIcon(new AppData().getAppData + "pc.png"));
                    dia.add(l, BorderLayout.CENTER);
                    dia.add(cent, BorderLayout.SOUTH);
                    l.setMaximumSize(new Dimension(2, 2));
                    cent.add(about);
                    dia.setVisible(true);
                    dia.setMinimumSize(new Dimension(343, 223));
                    dia.setTitle("Über HARDWARE Management");
                }
            });
            hilfe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog d = new JDialog();
                    JComponent c = new JTextArea("Not Implemented Yet");
                    JTabbedPane pane = new JTabbedPane();
                    pane.addTab("Hilfe", c);
                    d.setVisible(true);
                    d.add(pane);
                    d.setMinimumSize(new Dimension(340, 520));
                    d.setTitle("Hilfe");
                }
            });
            bar.add(tools);
            tools.add(ramfree);
            tools.add(file);
            file.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FileBrowser.create("Öffnen", "C:/");
                }
            });
            f.setJMenuBar(bar);
            area.setBackground(Color.lightGray);
            area.setEditable(false);
            f.setVisible(true);
            f.setMinimumSize(new Dimension(430, 460));
            f.setResizable(false);
            f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            f.addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {

                }

                @Override
                public void windowClosing(WindowEvent e) {

                }

                @Override
                public void windowClosed(WindowEvent e) {
                    System.exit(0);
                }

                @Override
                public void windowIconified(WindowEvent e) {

                }

                @Override
                public void windowDeiconified(WindowEvent e) {

                }

                @Override
                public void windowActivated(WindowEvent e) {

                }

                @Override
                public void windowDeactivated(WindowEvent e) {

                }
            });
            f.add(area, BorderLayout.CENTER);
            ram();
        }
    }

    public static void ram() throws InterruptedException {
        for (; ; ) {
            StringBuilder sb = new StringBuilder();
            NumberFormat format = NumberFormat.getInstance();
            long maxMemory = Runtime.getRuntime().maxMemory();
            long allocatedMemory = Runtime.getRuntime().totalMemory();
            long freeMemory = Runtime.getRuntime().freeMemory();
            String made;
            String java;
            String cpu = System.getenv("PROCESSOR_ARCHITECTURE");
            if (cpu.equalsIgnoreCase("AMD64")) {
                made = "AMD";
            } else {
                made = "Intel";
            }
                String path = System.getenv("Path");
                if(path.contains("java")) {
                    java = "Ja";
                }else{
                    if(path.contains("Java")) {
                        java = "Ja";
                    }else{
                        java = "Nein";
                    }
                }
            area.setText("\n" + " Freier Arbeitsspeicher ist der für Java zugewiesene Arbeitsspeicher" + "\n\n" + "\n" + " Freier Arbeitsspeicher: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + " / " + format.format(maxMemory / 1024) + " GB" + "\n\n" + " CPU Kerne: " + os.getAvailableProcessors() + "\n\n" + " CPU Hersteller: " + made + "\n\n" + " OS Name: " + os.getName() + "\n\n" + " OS Version: " + os.getVersion() + "\n\n" + " Java Installiert: " + java);
            Thread.sleep(4);
        }
    }
}
