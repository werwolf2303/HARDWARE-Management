package com.window.utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileBrowser {
    public static void create(String ButtonText, String DefaultDIR) {
        JFileChooser chooser = new JFileChooser(DefaultDIR);
        chooser.setVisible(true);
        chooser.showDialog(chooser, ButtonText);
    }
}
