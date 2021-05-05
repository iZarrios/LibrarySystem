package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.text.View;
import java.util.StringTokenizer;

public class ViewLibrarian implements ActionListener {
    private JFrame frame = new JFrame();;
    private JTable table;
    // private JPanel panel;
    private JButton backButton = new JButton("Back");


    // public static void main(String[] args) {
    // new ViewLibrarian();
    // }
    ViewLibrarian() {
        ArrayList<String> data = new ArrayList<String>();
        UserData auth = new UserData(".\\src\\com\\company\\db.txt");
        data = auth.getData();
//        System.out.println(data);
//        StringTokenizer st = new StringTokenizer(data.get(0), "::\n");
        int size = data.size() - 2;
        System.out.println(size);
        String[][] c = new String[size][7];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 7; j++) {
                String  [] s = data.get(i).split(",");
                c[i][j] = s[j];
            }
            String[] columnKeys = {"ID", "Name", "Password", "Email", "Address", "City", "Contact Info"};
            // panel = new JPanel();
            table = new JTable(c, columnKeys);
            table.setBounds(0, 0, 200, 300);
            JScrollPane sp = new JScrollPane(table);
            frame.add(sp);

            // backButton.setBounds(100, 100, 100, 100);
            // backButton.setFocusable(false);
            // backButton.addActionListener(this);
            // backButton.setLayout(null);
            // frame.add(backButton);

            // end
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(820, 420);
            frame.setVisible(true);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // if(e.getSource() == backButton)
        // {
        // System.out.println("I am clicked");
        // frame.dispose();
        // new WelcomePage();
        // }
    }
}