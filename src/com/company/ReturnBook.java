package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBook implements ActionListener {

    private final JFrame returnBookFrame;

    private final JButton returnBookButton;
    private final JButton backButton;

    private final JTextField bookCallingField;
    private final JTextField studentIDField;

    ReturnBook() {
        // Creating Frame
        returnBookFrame = new JFrame();
        // Labels
        JLabel returnBookLabel = new JLabel("Return Books");
        returnBookLabel.setBounds(200, 10, 100, 50);

        JLabel bookCallingLabel = new JLabel("Book Calling: ");
        bookCallingLabel.setBounds(100, 60, 100, 50);

        JLabel studentIDLabel = new JLabel("Student ID: ");
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
        JPanel returnBookPanel = new JPanel();

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
            String bookCalling = bookCallingField.getText();
            String ID = studentIDField.getText();
            ReturnValidity v = new ReturnValidity(Integer.parseInt(bookCalling), Integer.parseInt(ID));
            if (v.canReturn() == 1) {
                v.decQuantityIncBooksRemoveIssued();
                JOptionPane.showMessageDialog(null, "Book has been returned Successfully!");
                bookCallingField.setText("");
                studentIDField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Check your Data!!");
            }
        }
        if (e.getSource() == backButton) {

            returnBookFrame.dispose();
            new LibrarianSection();
        }
    }

}
