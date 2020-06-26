package com.window.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Error {
    public static void createError(String ButtonText, String Title, String HELPText) {
        JDialog error = new JDialog();
        error.setTitle(Title);
        JButton ok = new JButton(ButtonText);
        error.setVisible(true);
        JLabel label = new JLabel(HELPText);
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
