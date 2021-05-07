package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

import static com.company.UserData.isStringOnlyAlphabet;
import static com.company.UserData.isValidEMail;

public class AddStudent implements ActionListener {

    private final JFrame frame = new JFrame();
    private final JTextField nameField = new JTextField("");
    private final JPasswordField passwordField = new JPasswordField("");
    private final JTextField emailField = new JTextField("");
    private final JTextField addressField = new JTextField("");
    private final JTextField cityField = new JTextField("");
    private final JTextField contactInfoField = new JTextField("");
    private final JButton addStudentButton = new JButton("Add Student");
    private final JButton backButton = new JButton("Back");

    AddStudent() {
        frame.setResizable(false);
        // main label
        JLabel welcomeLabel = new JLabel("Add Student");
        welcomeLabel.setBounds(130, 10, 220, 50);
        welcomeLabel.setFont(new Font(null, Font.ITALIC, 20));
        frame.add(welcomeLabel);

        // name
        JLabel studentName = new JLabel("Name:");
        studentName.setBounds(50, 50, 220, 50);
        frame.add(studentName);

        nameField.setBounds(150, 65, 180, 20);
        frame.add(nameField);
        // password
        JLabel studentPassword = new JLabel("Password:");
        studentPassword.setBounds(50, 90, 220, 50);
        frame.add(studentPassword);

        passwordField.setBounds(150, 105, 180, 20);
        frame.add(passwordField);

        // email
        JLabel studentEmail = new JLabel("E-Mail:");
        studentEmail.setBounds(50, 130, 220, 50);
        frame.add(studentEmail);

        emailField.setBounds(150, 145, 180, 20);
        frame.add(emailField);

        // address
        JLabel studentAddress = new JLabel("Address:");
        studentAddress.setBounds(50, 170, 220, 50);
        frame.add(studentAddress);

        addressField.setBounds(150, 185, 180, 20);
        frame.add(addressField);

        // city
        JLabel studentCity = new JLabel("City:");
        studentCity.setBounds(50, 210, 220, 50);
        frame.add(studentCity);

        cityField.setBounds(150, 225, 180, 20);
        frame.add(cityField);

        // contact info
        JLabel studentContactInfo = new JLabel("Contact No:");
        studentContactInfo.setBounds(50, 250, 220, 50);
        frame.add(studentContactInfo);

        contactInfoField.setBounds(150, 265, 180, 20);
        frame.add(contactInfoField);

        // buttons
        addStudentButton.setBounds(125, 300, 150, 45);
        addStudentButton.setFocusable(false);
        addStudentButton.addActionListener(this);
        frame.add(addStudentButton);

        backButton.setBounds(320, 345, 80, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(backButton);

        // end
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserData auth = new UserData(".\\src\\com\\company\\StudentDB.txt");
        ArrayList data = auth.getData();
        Random rand = new Random();
        if (e.getSource() == addStudentButton) {
            String name = nameField.getText();
            char[] temppass = passwordField.getPassword();// get password returns an array of char
            String password = new String(temppass);
            String email = emailField.getText();
            String address = addressField.getText();
            String city = cityField.getText();
            String number = contactInfoField.getText();
            String user;
            if (isStringOnlyAlphabet(name) && isValidEMail(email) && temppass.length != 0) {
                int resRandom1 = rand.nextInt((9999 - 100) + 1) + 10;
                int booksIssued = 0;
                int count = data.size();
                user = resRandom1 + "," + name + "," + password + "," + email + "," + address + "," + city + ","
                        + number + "," + booksIssued;
                auth.addUser(data, user);
                System.out.println(data);
                auth.saveData();
                JOptionPane.showMessageDialog(null, "Student has been added Successfully!");
                nameField.setText("");
                passwordField.setText("");
                addressField.setText("");
                cityField.setText("");
                contactInfoField.setText("");
                emailField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Check Credentials!!");
            }
        }
        if (e.getSource() == backButton) {
            frame.dispose();
            new AdminSection();
        }

    }
}
