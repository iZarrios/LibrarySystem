package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static com.company.UserData.isStringOnlyAlphabet;

public class AddBooks implements ActionListener {

    private final JFrame addBooksFrame;

    private final JButton addBooksButton;
    private final JButton backButton;

    private final JTextField callNumberTextField;
    private final JTextField nameField;
    private final JTextField authorTextField;
    private final JTextField publisherTextField;
    private final JTextField quantityTextField;

    AddBooks() {
        // Creating Frame
        addBooksFrame = new JFrame();
        // Labels
        JLabel addBooksLabel = new JLabel("Add Books");
        addBooksLabel.setBounds(200, 10, 100, 50);

        JLabel callNumberLabel = new JLabel("Call Number: ");
        callNumberLabel.setBounds(100, 60, 100, 50);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(100, 110, 100, 50);

        JLabel authorLabel = new JLabel("Author: ");
        authorLabel.setBounds(100, 160, 100, 50);

        JLabel publisherLabel = new JLabel("Publisher: ");
        publisherLabel.setBounds(100, 210, 100, 50);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setBounds(100, 260, 100, 50);

        // Text fields
        callNumberTextField = new JTextField();
        callNumberTextField.setBounds(180, 70, 100, 30);

        nameField = new JTextField();
        nameField.setBounds(180, 120, 100, 30);

        authorTextField = new JTextField();
        authorTextField.setBounds(180, 170, 100, 30);

        publisherTextField = new JTextField();
        publisherTextField.setBounds(180, 220, 100, 30);

        quantityTextField = new JTextField();
        quantityTextField.setBounds(180, 270, 100, 30);

        // Buttons
        addBooksButton = new JButton(" Add Books");
        addBooksButton.setBounds(180, 350, 100, 30);
        addBooksButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(180, 400, 100, 30);

        // Panel
        JPanel addBooksPanel = new JPanel();

        // Add to Frame
        addBooksFrame.add(addBooksLabel);

        addBooksFrame.add(callNumberLabel);
        addBooksFrame.add(callNumberTextField);

        addBooksFrame.add(nameLabel);
        addBooksFrame.add(nameField);

        addBooksFrame.add(authorLabel);
        addBooksFrame.add(authorTextField);

        addBooksFrame.add(publisherLabel);
        addBooksFrame.add(publisherTextField);

        addBooksFrame.add(quantityLabel);
        addBooksFrame.add(quantityTextField);

        addBooksFrame.add(addBooksButton);
        addBooksFrame.add(backButton);

        // Frame
        addBooksFrame.add(addBooksPanel, BorderLayout.CENTER);
        // addBooksFrame.add(addBooksPanel);
        addBooksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addBooksFrame.setTitle("University Library System");
        addBooksFrame.pack();
        addBooksFrame.setSize(500, 500);
        addBooksFrame.setLayout(null);
        addBooksFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBooksButton) {
            String callNumber = callNumberTextField.getText();
            String name = nameField.getText();
            String author = authorTextField.getText();
            String publisher = publisherTextField.getText();
            String quantity = quantityTextField.getText();
            UserData userData = new UserData(".\\src\\com\\company\\books.txt");
            ArrayList data = userData.getData();
            String book;
            String todayDate;
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Calendar obj = Calendar.getInstance();
            todayDate = format.format(obj.getTime());
            System.out.println(todayDate);
            if (CheckNumeric.isNumeric(callNumber) && isStringOnlyAlphabet(name) && isStringOnlyAlphabet(author)
                    && isStringOnlyAlphabet(publisher) && CheckNumeric.isNumeric(quantity)) {
                book = callNumber + "," + name + "," + author + "," + publisher + "," + quantity + "," + todayDate;
                System.out.println(book);
                userData.addUser(data, book);
                System.out.println(data);
                userData.saveData();
                JOptionPane.showMessageDialog(null, "Book has been added Successfully!");
                callNumberTextField.setText("");
                nameField.setText("");
                authorTextField.setText("");
                publisherTextField.setText("");
                quantityTextField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Check Credentials!!");
            }
        }
        if (e.getSource() == backButton) {

            addBooksFrame.dispose();
            new LibrarianSection();
        }
    }

}
