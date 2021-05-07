package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class StudentLoginPage implements ActionListener {

    //private final String USERNAME = "", PASSWORD = "";// the admin account credentials
    private JFrame frame = new JFrame(); // we can add more users by making a class where it returns an array or a
                                         // hashmap but as it is not needed here :)
    private JButton loginButton = new JButton("Login");
    private JButton resetButton = new JButton("Reset");
    private JTextField userIDField = new JTextField();
    private JPasswordField userPasswordField = new JPasswordField();
    private JLabel userIDLabel = new JLabel("Enter ID:");
    private JLabel userPasswordLabel = new JLabel("Enter Password:");
    private JLabel messageLabel = new JLabel();
    private JLabel adminLoginForm = new JLabel("Student Login Form");

    StudentLoginPage() {

        frame.setResizable(false);
        adminLoginForm.setBounds(100, 10, 220, 50);
        adminLoginForm.setFont(new Font(null, Font.ITALIC, 20));

        userIDLabel.setBounds(50, 100, 75, 25);
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

            ArrayList<String> dataStudent;
            UserData studentData = new UserData(".\\src\\com\\company\\StudentDB.txt");
            dataStudent = studentData.getData();
            int size = dataStudent.size();
            System.out.println(size);
            String[][] c1 = new String[size][8];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 8; j++) {
                    String[] s1 = dataStudent.get(i).split(",");
                    c1[i][j] = s1[j];
                }
                if(c1[i][0].equals(userID) && c1[i][2].equals(password)){
                    System.out.println("I am clicked !!");
                    JOptionPane.showMessageDialog(null,"Moving to view students");
                    frame.dispose();
                    new ViewStudents();
                    break;
                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Login failed");
                    //userIDField.setText("");
                    userPasswordField.setText("");
                }
            }

        }

    }

}



