package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import static com.company.UserData.isStringOnlyAlphabet;
import static com.company.UserData.isValidEMail;

public class AddLibrarian implements ActionListener {

    private final JFrame frame = new JFrame();
    private final JTextField nameField = new JTextField("");
    private final JPasswordField passwordField = new JPasswordField("");
    private final JTextField emailField = new JTextField("");
    private final JTextField addressField = new JTextField("");
    private final JTextField cityField = new JTextField("");
    private final JTextField contactInfoField = new JTextField("");
    private final JButton addLibrarianButton = new JButton("Add Librarian");
    private final JButton backButton = new JButton("Back");

    AddLibrarian() {
        frame.setResizable(false);
        // main label
        JLabel welcomeLabel = new JLabel("Add Librarian");
        welcomeLabel.setBounds(130, 10, 220, 50);
        welcomeLabel.setFont(new Font(null, Font.ITALIC, 20));
        frame.add(welcomeLabel);

        // name
        JLabel librarianName = new JLabel("Name:");
        librarianName.setBounds(50, 50, 220, 50);
        frame.add(librarianName);

        nameField.setBounds(150, 65, 180, 20);
        frame.add(nameField);
        // password
        JLabel librarianPassword = new JLabel("Password:");
        librarianPassword.setBounds(50, 90, 220, 50);
        frame.add(librarianPassword);

        passwordField.setBounds(150, 105, 180, 20);
        frame.add(passwordField);

        // email
        JLabel librarianEMail = new JLabel("E-Mail:");
        librarianEMail.setBounds(50, 130, 220, 50);
        frame.add(librarianEMail);

        emailField.setBounds(150, 145, 180, 20);
        frame.add(emailField);

        // address
        JLabel librarianAddress = new JLabel("Address:");
        librarianAddress.setBounds(50, 170, 220, 50);
        frame.add(librarianAddress);

        addressField.setBounds(150, 185, 180, 20);
        frame.add(addressField);

        // city
        JLabel librarianCity = new JLabel("City:");
        librarianCity.setBounds(50, 210, 220, 50);
        frame.add(librarianCity);

        cityField.setBounds(150, 225, 180, 20);
        frame.add(cityField);

        // contact info
        JLabel librarianContactInfo = new JLabel("Contact No:");
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
            String name = nameField.getText();
            char[] temppassword = passwordField.getPassword();// get password returns an array of char
            String password = new String(temppassword);
            String email = emailField.getText();
            String address = addressField.getText();
            String city = cityField.getText();
            String number = contactInfoField.getText();
            String user;
            UserData auth = new UserData(".\\src\\com\\company\\db.txt");
            ArrayList data = auth.getData();
            if (isStringOnlyAlphabet(name) && isValidEMail(email) && temppassword.length != 0
                    && isStringOnlyAlphabet(city) && address.isEmpty() && city.isEmpty() && password.isEmpty()) {
                int count = data.size();
                user = count + "," + name + "," + password + "," + email + "," + address + "," + city + "," + number;
                System.out.println(user);
                auth.addUser(data, user);
                System.out.println(data);
                auth.saveData();
                data = auth.getData();
                JOptionPane.showMessageDialog(null, "Librarian has been added Successfully!");
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
