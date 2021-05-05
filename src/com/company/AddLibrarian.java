package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import static com.company.UserData.isStringOnlyAlphabet;

import static com.company.UserData.isStringOnlyAlphabet;
import static com.company.UserData.isValidEMail;

public class AddLibrarian implements ActionListener {

    private JFrame frame  = new JFrame();
    private JLabel welcomeLabel;
    private JLabel studentName;
    private JTextField nameField = new JTextField("");
    private JLabel studentPassword = new JLabel("Password:");
    private JPasswordField passwordField = new JPasswordField("");
    private JLabel studentEmail = new JLabel("E-Mail:");
    private JTextField emailField = new JTextField("");
    private JLabel studentAddress = new JLabel("Address:");
    private JTextField addressField = new JTextField("");
    private JLabel studentCity = new JLabel("City:");
    private JTextField cityField = new JTextField("");
    private JLabel studentContactInfo = new JLabel("Contact No:");
    private JTextField contactInfoField = new JTextField("");
    private JButton addStudentButton = new JButton("Add Student");
    private JButton backButton = new JButton("Back");


//    public static void main(String[] args) {
//
//        AddLibrarian addLibrarian = new AddLibrarian();
//    }

    AddLibrarian()
    {
        frame.setResizable(false);
        //main label
        welcomeLabel = new JLabel("Add Librarian");
        welcomeLabel.setBounds(130,10,220,50);
        welcomeLabel.setFont(new Font(null,Font.ITALIC,20));
        frame.add(welcomeLabel);

        //name
        studentName = new JLabel("Name:");
        studentName.setBounds(50,50,220,50);
        frame.add(studentName);

        nameField.setBounds(150,65,180,20);
        frame.add(nameField);
        //password
        studentPassword.setBounds(50,90,220,50);
        frame.add(studentPassword);

        passwordField.setBounds(150,105,180,20);
        frame.add(passwordField);

        //email
        studentEmail.setBounds(50,130,220,50);
        frame.add(studentEmail);

        emailField.setBounds(150,145,180,20);
        frame.add(emailField);

        //address
        studentAddress.setBounds(50,170,220,50);
        frame.add(studentAddress);

        addressField.setBounds(150,185,180,20);
        frame.add(addressField);

        //city
        studentCity.setBounds(50,210,220,50);
        frame.add(studentCity);

        cityField.setBounds(150,225,180,20);
        frame.add(cityField);

        //contact info
        studentContactInfo.setBounds(50,250,220,50);
        frame.add(studentContactInfo);

        contactInfoField.setBounds(150,265,180,20);
        frame.add(contactInfoField);



        //buttons
        addStudentButton.setBounds(125, 300, 150, 45);
        addStudentButton.setFocusable(false);
        addStudentButton.addActionListener(this);
        frame.add(addStudentButton);

        backButton.setBounds(320, 345, 80, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(backButton);

        //end
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }





    @Override
    public void actionPerformed(ActionEvent e) {
        UserData auth = new UserData(".\\src\\com\\company\\db.txt");
        ArrayList<String> data = auth.getData();
        if(e.getSource() == addStudentButton)
        {
            String name = nameField.getText();
            char[] temppass = passwordField.getPassword();//get password returns an array of char
            String password = new String(temppass);
            String email = emailField.getText();
            String address = addressField.getText();
            String city = cityField.getText();
            String number = contactInfoField.getText();
            String user;
            if(isStringOnlyAlphabet(name) == true && isValidEMail(email) == true && temppass.length != 0)
            {
                int count = data.size();
                user = count + "," +name + "," + password+ "," + email + "," + address + "," + city + "," + number;
                System.out.println(user);
                auth.addUser(data,user);
                System.out.println(data);
                auth.saveData();
                System.out.println("it works?");
                JOptionPane.showMessageDialog(null, "Librarian has been added Successfully!");
                nameField.setText("");
                passwordField.setText("");
                addressField.setText("");
                cityField.setText("");
                contactInfoField.setText("");
                emailField.setText("");
            }
            else {
                JOptionPane.showMessageDialog(null, "Check Credentials!!");

            }


//            frame.dispose();
        }
        if(e.getSource() == backButton)
        {

            System.out.println("I am clicked");
            frame.dispose();
            new AdminSection();
        }

    }
}

