package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBooks{

    private final JFrame viewBooksFrame;
    private final JPanel viewBooksPanel;
    private final JTable viewBooksTable;

    ViewBooks() {
        // Creating Frame
        viewBooksFrame = new JFrame();

        // Panel
        viewBooksPanel = new JPanel();

        // Table
        String[] columnsNames = { "Call No", "Name", "Author", "Publisher", "Quantity" };
        String[][] data = { { "One", "Book1", "shakespeare", "Zeyad", "2" },
                { "Two", "Book2", "Charles", "Eyad", "5" } };
        viewBooksTable = new JTable(data, columnsNames);
        // viewBooksTable.setPreferredScrollableViewportSize(new Dimension(500,100));
        viewBooksTable.setFillsViewportHeight(true);
        viewBooksTable.setBounds(0, 0, 500, 500);
        JScrollPane sp = new JScrollPane(viewBooksTable);
        // DefaultTableModel model= new DefaultTableModel();
        // model.setColumnIdentifiers(columnsNames);
        // viewBooksTable.setModel(model);
        // Add to frame
        viewBooksFrame.add(viewBooksPanel, BorderLayout.CENTER);
        viewBooksFrame.add(sp);

        // Frame
        viewBooksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewBooksFrame.setTitle("University Library System");
        viewBooksFrame.pack();
        viewBooksFrame.setSize(500, 500);
        viewBooksFrame.setVisible(true);
    }
}

