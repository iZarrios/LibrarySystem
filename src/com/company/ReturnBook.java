package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBook implements ActionListener {

    private final JFrame returnBookFrame;
    private final JPanel returnBookPanel;

    private final JButton returnBookButton;
    private final JButton backButton;

    private final JLabel returnBookLabel;
    private final JLabel bookCallingLabel;
    private final JLabel studentIDLabel;

    private final JTextField bookCallingField;
    private final JTextField studentIDField;

    ReturnBook() {
        // Creating Frame
        returnBookFrame = new JFrame();
        // Labels
        returnBookLabel = new JLabel("Return Books");
        returnBookLabel.setBounds(200, 10, 100, 50);

        bookCallingLabel = new JLabel("Book Calling: ");
        bookCallingLabel.setBounds(100, 60, 100, 50);

        studentIDLabel = new JLabel("Student ID: ");
        studentIDLabel.setBounds(100, 110, 100, 50);

        // Text fields
        bookCallingField = new JTextField();
        bookCallingField.setBounds(180, 70, 100, 30);

        studentIDField = new JTextField();
        studentIDField.setBounds(180, 120, 100, 30);

        // Buttons
        returnBookButton = new JButton(" Return Book");
        returnBookButton.setBounds(170, 200, 130, 30);
        returnBookButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(180, 250, 100, 30);

        // Panel
        returnBookPanel = new JPanel();

        // Add to Frame
        returnBookFrame.add(returnBookLabel);

        returnBookFrame.add(bookCallingLabel);
        returnBookFrame.add(bookCallingField);

        returnBookFrame.add(studentIDLabel);
        returnBookFrame.add(studentIDField);

        returnBookFrame.add(returnBookButton);
        returnBookFrame.add(backButton);

        // Frame
        returnBookFrame.add(returnBookPanel, BorderLayout.CENTER);
        returnBookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        returnBookFrame.setTitle("University Library System");
        returnBookFrame.pack();
        returnBookFrame.setSize(500, 400);
        returnBookFrame.setLayout(null);
        returnBookFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnBookButton) {
            System.out.println("I am clicked");
            JOptionPane.showMessageDialog(null, "Book has been returned Successfully!");
            // addBooksFrame.dispose();
        }
        if (e.getSource() == backButton) {

            System.out.println("I am clicked");
            returnBookFrame.dispose();
            new LibrarianSection();
        }
    }

}
