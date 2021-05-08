package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class StudentLoginPage implements ActionListener {


    // hashmap but as it is not needed here :)
    JFrame frame;
    private final JButton loginButton = new JButton("Login");
    private final JButton resetButton = new JButton("Reset");
    private final JButton backButton = new JButton("Back");
    private final JTextField userIDField = new JTextField();
    private final JPasswordField userPasswordField = new JPasswordField();
    private final JLabel messageLabel = new JLabel();

    StudentLoginPage() {

        // private final String USERNAME = "", PASSWORD = "";// the admin account
        // credentials
        // we can add more users by making a class where it returns an array or a
        frame = new JFrame();
        frame.setResizable(false);
        JLabel adminLoginForm = new JLabel("Student Login Form");
        adminLoginForm.setBounds(100, 10, 220, 50);
        adminLoginForm.setFont(new Font(null, Font.ITALIC, 20));

        JLabel userIDLabel = new JLabel("Enter ID:");
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

        backButton.addActionListener(this);
        backButton.setBounds(180, 300, 100, 30);

        frame.add(adminLoginForm);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(backButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    // done
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {

            frame.dispose();
            new GUI();
        }

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        } // done
        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            ArrayList<String> dataStudent;
            UserData studentData = new UserData(".\\src\\com\\company\\StudentDB.txt");
            dataStudent = studentData.getData();
            int size = dataStudent.size();
            int flag = 0;
            System.out.println(size);
            String[][] c1 = new String[size][8];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 8; j++) {
                    String[] s1 = dataStudent.get(i).split(",");
                    c1[i][j] = s1[j];
                }
                if (c1[i][0].equals(userID) && c1[i][2].equals(password)) {
                    new ViewStudentIssuedBooks(userID);
                    userPasswordField.setText("");
                    userIDField.setText("");
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Login failed");
            }
        }

    }

}
