package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class ViewBooks {
    public static void main(String[] args) {
        new ViewBooks();
    }

    ViewBooks() {
        // Creating Frame
        JFrame viewBooksFrame = new JFrame();

        // Panel
        JPanel viewBooksPanel = new JPanel();

        // Table
        ArrayList<String> data = new ArrayList<>();
        UserData userData = new UserData(".\\src\\com\\company\\books.txt");
        data = userData.getData();
        int size = data.size();
        System.out.println(size);
        String[][] c = new String[size][6];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 6; j++) {
                String[] s = data.get(i).split(",");
                c[i][j] = s[j];
            }
        }
        String[] columnsNames = { "Call No", "Name", "Author", "Publisher", "Quantity", "Date Added" };

        JTable viewBooksTable = new JTable(c, columnsNames);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int j = 0; j < 6; j++) {
            viewBooksTable.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
        viewBooksTable.setFillsViewportHeight(true);
        viewBooksTable.setBounds(0, 0, 500, 500);
        JScrollPane sp = new JScrollPane(viewBooksTable);
        // Add to frame
        viewBooksFrame.add(viewBooksPanel, BorderLayout.CENTER);
        viewBooksFrame.add(sp);

        // Frame
        viewBooksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewBooksFrame.setTitle("University Library System");
        viewBooksFrame.pack();
        viewBooksFrame.setSize(500, 500);
        viewBooksFrame.setVisible(true);
    }
}
