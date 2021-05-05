package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddStudent implements ActionListener {

    private JFrame frame = new JFrame();
    private JLabel welcomeLabel;
    private JLabel librarianName;
    private JTextField nameField = new JTextField("");
    private JLabel librarianPassword = new JLabel("Password:");
    private JPasswordField passwordField = new JPasswordField("");
    private JLabel librarianEMail = new JLabel("E-Mail:");
    private JTextField emailField = new JTextField("");
    private JLabel librarianAddress = new JLabel("Address:");
    private JTextField addressField = new JTextField("");
    private JLabel librarianCity = new JLabel("City:");
    private JTextField cityField = new JTextField("");
    private JLabel librarianContactInfo = new JLabel("Contact No:");
    private JTextField contactInfoField = new JTextField("");
    private JButton addLibrarianButton = new JButton("Add Librarian");
    private JButton backButton = new JButton("Back");

    public static void main(String[] args) {

        AddLibrarian addLibrarian = new AddLibrarian();
    }

    AddStudent() {
        frame.setResizable(false);
        // main label
        welcomeLabel = new JLabel("Add Student");
        welcomeLabel.setBounds(130, 10, 220, 50);
        welcomeLabel.setFont(new Font(null, Font.ITALIC, 20));
        frame.add(welcomeLabel);

        // name
        librarianName = new JLabel("Name:");
        librarianName.setBounds(50, 50, 220, 50);
        frame.add(librarianName);

        nameField.setBounds(150, 65, 180, 20);
        frame.add(nameField);
        // password
        librarianPassword.setBounds(50, 90, 220, 50);
        frame.add(librarianPassword);

        passwordField.setBounds(150, 105, 180, 20);
        frame.add(passwordField);

        // email
        librarianEMail.setBounds(50, 130, 220, 50);
        frame.add(librarianEMail);

        emailField.setBounds(150, 145, 180, 20);
        frame.add(emailField);

        // address
        librarianAddress.setBounds(50, 170, 220, 50);
        frame.add(librarianAddress);

        addressField.setBounds(150, 185, 180, 20);
        frame.add(addressField);

        // city
        librarianCity.setBounds(50, 210, 220, 50);
        frame.add(librarianCity);

        cityField.setBounds(150, 225, 180, 20);
        frame.add(cityField);

        // contact info
        librarianContactInfo.setBounds(50, 250, 220, 50);
        frame.add(librarianContactInfo);

        contactInfoField.setBounds(150, 265, 180, 20);
        frame.add(contactInfoField);

        // buttons
        addLibrarianButton.setBounds(125, 300, 150, 45);
        addLibrarianButton.setFocusable(false);
        addLibrarianButton.addActionListener(this);
        frame.add(addLibrarianButton);

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

        if (e.getSource() == addLibrarianButton) {
            System.out.println("I am clicked");
            JOptionPane.showMessageDialog(null, "Librarian has been added Successfully!");
            nameField.setText("");
            passwordField.setText("");
            addressField.setText("");
            cityField.setText("");
            contactInfoField.setText("");
            emailField.setText("");
            // frame.dispose();
        }
        if (e.getSource() == backButton) {

            System.out.println("I am clicked");
            frame.dispose();
            new AdminSection();
        }

    }
}
