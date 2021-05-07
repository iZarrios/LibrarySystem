package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage implements ActionListener {

    private final JFrame frame = new JFrame(); // we can add more admins by making a class where it returns an array or
                                               // a
    // hashmap but as it is not needed here :)
    // making an internal array (hard coded)
    private final JButton loginButton = new JButton("Login");
    private final JButton resetButton = new JButton("Reset");
    private final JTextField userIDField = new JTextField();
    private final JPasswordField userPasswordField = new JPasswordField();
    private final JLabel messageLabel = new JLabel();

    LoginPage() {

        frame.setResizable(false);
        JLabel adminLoginForm = new JLabel("Admin Login Form");
        adminLoginForm.setBounds(100, 10, 220, 50);
        adminLoginForm.setFont(new Font(null, Font.ITALIC, 20));

        JLabel userIDLabel = new JLabel("Enter Name:");
        userIDLabel.setBounds(50, 100, 75, 25);
        JLabel userPasswordLabel = new JLabel("Enter Password:");
        userPasswordLabel.setBounds(20, 150, 115, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(adminLoginForm);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    // done
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        } // done
        if (e.getSource() == loginButton) {

            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            // the admin account credentials
            String PASSWORD = "admin";
            String USERNAME = "admin";
            if (userID.equals(USERNAME) && password.equals(PASSWORD)) {
                messageLabel.setForeground(Color.green);
                messageLabel.setText("Login successful");
                frame.dispose();
                new AdminSection();
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Login failed");
            }
        }

    }

}