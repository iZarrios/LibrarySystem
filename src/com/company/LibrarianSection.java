package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianSection implements ActionListener {

    private final JFrame librarianFrame;

    private final JButton addBooksButton;
    private final JButton viewBooksButton;
    private final JButton issueBookButton;
    private final JButton viewIssuedBooksButton;
    private final JButton returnBookButton;
    private final JButton logOutButton;

    LibrarianSection() {
        // Creating Frame
        librarianFrame = new JFrame();
        // Label
        JLabel librarianSectionLabel = new JLabel("LibrarianSection");
        librarianSectionLabel.setFont(new Font(null, Font.ITALIC, 20));
        librarianSectionLabel.setBounds(130, 0, 200, 50);

        // Buttons
        addBooksButton = new JButton(" Add Books");
        addBooksButton.setBounds(140, 70, 160, 50);
        addBooksButton.addActionListener(this);

        viewBooksButton = new JButton("View Books");
        viewBooksButton.addActionListener(this);
        viewBooksButton.setBounds(140, 140, 160, 50);

        issueBookButton = new JButton("Issue Book");
        issueBookButton.addActionListener(this);
        issueBookButton.setBounds(140, 210, 160, 50);

        viewIssuedBooksButton = new JButton("View Issued Books");
        viewIssuedBooksButton.addActionListener(this);
        viewIssuedBooksButton.setBounds(140, 280, 160, 50);

        returnBookButton = new JButton(" Return Book");
        returnBookButton.addActionListener(this);
        returnBookButton.setBounds(140, 350, 160, 50);

        logOutButton = new JButton(" Log Out");
        logOutButton.addActionListener(this);
        logOutButton.setBounds(160, 440, 120, 50);

        // Panel
        JPanel librarianPanel = new JPanel();
        // Add to Frame
        librarianFrame.add(librarianSectionLabel);
        librarianFrame.add(addBooksButton);
        librarianFrame.add(viewBooksButton);
        librarianFrame.add(issueBookButton);
        librarianFrame.add(viewIssuedBooksButton);
        librarianFrame.add(returnBookButton);
        librarianFrame.add(logOutButton);

        // Frame
        librarianFrame.add(librarianPanel, BorderLayout.CENTER);
        // addBooksFrame.add(addBooksPanel);
        librarianFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        librarianFrame.setTitle("University Library System");
        librarianFrame.pack();
        librarianFrame.setSize(450, 600);
        librarianFrame.setLayout(null);
        librarianFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBooksButton) {
            librarianFrame.dispose();
            new AddBooks();
        }
        if (e.getSource() == viewBooksButton) {

            new ViewBooks();
        }
        if (e.getSource() == issueBookButton) {

            librarianFrame.dispose();
            new IssueBook();
        }
        if (e.getSource() == viewIssuedBooksButton) {

            // librarianFrame.dispose();
            new ViewIssuedBooks();
        }
        if (e.getSource() == returnBookButton) {

            librarianFrame.dispose();
            new ReturnBook();
        }
        if (e.getSource() == logOutButton) {

            librarianFrame.dispose();
            new GUI();
        }
    }

}
