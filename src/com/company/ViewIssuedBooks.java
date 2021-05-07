package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class ViewIssuedBooks {



    ViewIssuedBooks() {
        // Creating Frame
        JFrame viewIssuedBooksFrame = new JFrame();

        // Panel
        JPanel viewIssuedBooksPanel = new JPanel();

        // Table
        ArrayList<String> data = new ArrayList<String>();
        UserData userData = new UserData(".\\src\\com\\company\\issuedBooks.txt");
        data = userData.getData();
        int size = data.size();
        String[][] c = new String[size][6];
        int ID = 0;
        for (int i = 0; i < size; i++) {
            c[i][0] = Integer.toString(++ID);
            for (int j = 0; j < 5; j++) {
                String[] s = data.get(i).split(",");
                c[i][j + 1] = s[j];
            }
        }
        String[] columnsNames = { "ID", "Book Calling", "Student ID", "Student Name", "Contact", "Issue Date" };
        JTable viewIssuedBooksTable = new JTable(c, columnsNames);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int j = 0; j < 5; j++) {
            viewIssuedBooksTable.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
        // viewIssuedBooksTable.setFillsViewportHeight(true);
        viewIssuedBooksTable.setBounds(0, 0, 700, 500);
        JScrollPane sp = new JScrollPane(viewIssuedBooksTable);
        // Add to frame
        viewIssuedBooksFrame.add(viewIssuedBooksPanel, BorderLayout.CENTER);
        viewIssuedBooksFrame.add(sp);

        // Frame

        viewIssuedBooksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewIssuedBooksFrame.setTitle("University Library System");
        viewIssuedBooksFrame.pack();
        viewIssuedBooksFrame.setSize(700, 500);
        viewIssuedBooksFrame.setVisible(true);
    }
}
