package com.window.utils;

import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.Objects;
import java.util.Optional;

public class HelpForm {
   public static class createHelpForm {
       private static TreePath path;
       private static MutableTreeNode node;
       public static void make1Tab(String title, String tab1, String content) {
           DefaultMutableTreeNode nNode = new DefaultMutableTreeNode(tab1);
           JDialog dialog = new JDialog();
           JPopupMenu tab12 = new JPopupMenu(tab1);
           JTextArea area = new JTextArea();
           JScrollPane content2 = new JScrollPane(area);
           JTree tree = new JTree(nNode);
           dialog.setVisible(true);
           dialog.setTitle(title);
           dialog.add(content2, BorderLayout.EAST);
           dialog.add(tree, BorderLayout.WEST);
           path = tree.getNextMatch("M", 0, Position.Bias.Forward);
       }
       public static void make2Tab(String title, String tab1, String content1, String tab2, String content2) {
           DefaultMutableTreeNode nNode = new DefaultMutableTreeNode("Hilfe");
           DefaultMutableTreeNode nNode3 = new DefaultMutableTreeNode(tab1);
           DefaultMutableTreeNode nNode2 = new DefaultMutableTreeNode(tab2);
           JDialog dialog = new JDialog();
           JTextArea area = new JTextArea();
           JScrollPane content3 = new JScrollPane(area);
           JTree tree = new JTree(nNode);
           nNode.add(nNode2);

           nNode.add(nNode3);
           dialog.setVisible(true);
           dialog.setTitle(title);
           dialog.add(content3, BorderLayout.EAST);
           dialog.add(tree, BorderLayout.WEST);
       }
       public static void make3Tab(String title, String tab1, String content1, String tab2, String content2, String tab3, String content3) {
           JDialog dialog = new JDialog();
           JTextArea area = new JTextArea();
           JScrollPane content4 = new JScrollPane(area);
           JTree tree = new JTree();
           dialog.setVisible(true);
           dialog.setTitle(title);
           dialog.add(content4, BorderLayout.EAST);
           dialog.add(tree, BorderLayout.WEST);
       }
       public static void make4Tab(String title, String tab1, String content1, String tab2, String content2, String tab3, String content3, String tab4, String content4) {
           JDialog dialog = new JDialog();
           JTextArea area = new JTextArea();
           JScrollPane content5 = new JScrollPane(area);
           JTree tree = new JTree();
           dialog.setVisible(true);
           dialog.setTitle(title);
           dialog.add(content5, BorderLayout.EAST);
           dialog.add(tree, BorderLayout.WEST);
       }
       public static void make5Tab(String title, String tab1, String content1, String tab2, String content2, String tab3, String content3, String tab4, String content4, String tab5, String content5) {
           JDialog dialog = new JDialog();
           JTextArea area = new JTextArea();
           JScrollPane content6 = new JScrollPane(area);
           JTree tree = new JTree();
           dialog.setVisible(true);
           dialog.setTitle(title);
           dialog.add(content6, BorderLayout.EAST);
           dialog.add(tree, BorderLayout.WEST);
       }
   }
}
