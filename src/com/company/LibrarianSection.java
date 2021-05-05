package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianSection implements ActionListener {

    private final JFrame librarianFrame;
    private final JPanel librarianPanel;

    private final JButton addBooksButton;
    private final JButton viewBooksButton;
    private final JButton issueBookButton;
    private final JButton viewIssuedBooksButton;
    private final JButton returnBookButton;
    private final JButton logOutButton;

    private final JLabel librarianSectionLabel;

    LibrarianSection() {
        // Creating Frame
        librarianFrame = new JFrame();
        // Label
        librarianSectionLabel = new JLabel("LibrarianSection");
        librarianSectionLabel.setFont(new Font(null, Font.ITALIC, 20));
        librarianSectionLabel.setBounds(130, 0, 200, 50);

        // Buttons
        addBooksButton = new JButton(" addBooks");
        addBooksButton.setBounds(140, 70, 140, 50);
        addBooksButton.addActionListener(this);

        viewBooksButton = new JButton("viewBooks");
        viewBooksButton.addActionListener(this);
        viewBooksButton.setBounds(140, 140, 140, 50);

        issueBookButton = new JButton("issueBook");
        issueBookButton.addActionListener(this);
        issueBookButton.setBounds(140, 210, 140, 50);

        viewIssuedBooksButton = new JButton("viewIssuedBooks");
        viewIssuedBooksButton.addActionListener(this);
        viewIssuedBooksButton.setBounds(140, 280, 140, 50);

        returnBookButton = new JButton(" returnBook");
        returnBookButton.addActionListener(this);
        returnBookButton.setBounds(150, 370, 120, 50);

        logOutButton = new JButton(" Log Out");
        logOutButton.addActionListener(this);
        logOutButton.setBounds(150, 430, 120, 50);

        // Panel
        librarianPanel = new JPanel();
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
            System.out.println("I am clicked");
            JOptionPane.showMessageDialog(null, "Moving to Add Books!");
            librarianFrame.dispose();
            new AddBooks();
        }
        if (e.getSource() == viewBooksButton) {

            System.out.println("I am clicked");
            JOptionPane.showMessageDialog(null, "Moving to View Books!");
            librarianFrame.dispose();
            new ViewBooks();
        }
        if (e.getSource() == issueBookButton) {

            System.out.println("I am clicked");
            JOptionPane.showMessageDialog(null, "Moving to issue Book!");
            librarianFrame.dispose();
            new IssueBook();
        }
        if (e.getSource() == viewIssuedBooksButton) {

            System.out.println("I am clicked");
            JOptionPane.showMessageDialog(null, "Moving to View issued Books!");
            librarianFrame.dispose();
            new ViewIssuedBooks();
        }
        if (e.getSource() == returnBookButton) {

            System.out.println("I am clicked");
            JOptionPane.showMessageDialog(null, "Moving to Return Book!");
            librarianFrame.dispose();
            new ReturnBook();
        }
        if (e.getSource() == logOutButton) {

            System.out.println("I am clicked");
            JOptionPane.showMessageDialog(null, "Logging Out!");
            librarianFrame.dispose();
            new GUI();
        }
    }

}
