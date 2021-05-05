package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewIssuedBooks{

    private final JFrame viewIssuedBooksFrame;
    private final JPanel viewIssuedBooksPanel;
    private final JTable viewIssuedBooksTable;

    ViewIssuedBooks() {
        // Creating Frame
        viewIssuedBooksFrame = new JFrame();

        // Panel
        viewIssuedBooksPanel = new JPanel();

        // Table
        String[] columnsNames = { "ID", "Book Calling", "Student ID", "Student Name", "Issue Date" };
        String[][] data = { { "1", "Book1", "6764", "Zeyad", "1/1/2021" },
                { "2", "Book2", "7128", "Eyad", "5/1/2021" } };
        viewIssuedBooksTable = new JTable(data, columnsNames);
//      viewIssuedBooksTable.setFillsViewportHeight(true);
        viewIssuedBooksTable.setBounds(0, 0, 500, 500);
        JScrollPane sp = new JScrollPane(viewIssuedBooksTable);
        // Add to frame
        viewIssuedBooksFrame.add(viewIssuedBooksPanel, BorderLayout.CENTER);
        viewIssuedBooksFrame.add(sp);

        // Frame

        viewIssuedBooksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewIssuedBooksFrame.setTitle("University Library System");
        viewIssuedBooksFrame.pack();
        viewIssuedBooksFrame.setSize(500, 500);
        viewIssuedBooksFrame.setVisible(true);
    }
}
