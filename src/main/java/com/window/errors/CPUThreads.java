package com.window.errors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPUThreads {
    public static void create() {
        JDialog error = new JDialog();
        error.setTitle("Error CPUthread");
        JButton ok = new JButton("Ok");
        error.setVisible(true);
        JLabel label = new JLabel("     1Kerner werden nicht unterstützt");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        error.add(label, BorderLayout.CENTER);
        error.add(ok, BorderLayout.SOUTH);
        error.setMinimumSize(new Dimension(240, 140));
    }
}
