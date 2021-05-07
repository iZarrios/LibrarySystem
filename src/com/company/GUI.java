package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private final JFrame frame = new JFrame();

    private final JButton librarianButton = new JButton("Librarian Login");
    private final JButton adminButton = new JButton("Admin Login");
    private final JButton studentButton = new JButton("Student Login");

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {

        frame.setResizable(false);
        adminButton.setBounds(100, 100, 200, 60);
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.add(adminButton);

        librarianButton.setBounds(100, 200, 200, 60);
        librarianButton.setFocusable(false);
        librarianButton.addActionListener(this);
        panel.add(librarianButton);

        studentButton.setBounds(100, 300, 200, 60);
        studentButton.setFocusable(false);
        studentButton.addActionListener(this);
        panel.add(studentButton);

        JLabel mainLabel = new JLabel("Library Management ");
        mainLabel.setBounds(100, 10, 220, 50);
        mainLabel.setFont(new Font(null, Font.ITALIC, 20));

        panel.setSize(420, 420);
        panel.add(mainLabel);
        panel.setLayout(null);

        // end
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        // frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminButton) {
            frame.dispose();
            new LoginPage();
        }
        if (e.getSource() == librarianButton) {
            new LibrarianLogin();
            frame.dispose();
        }
        if (e.getSource() == studentButton) {
            new StudentLoginPage();
            frame.dispose();
        }

    }
}