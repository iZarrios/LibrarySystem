package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ViewBooks{

    private final JFrame viewBooksFrame;
    private final JPanel viewBooksPanel;
    private final JTable viewBooksTable;
    public static void main(String[] args) {
        new ViewBooks();
    }

    ViewBooks() {
        // Creating Frame
        viewBooksFrame = new JFrame();

        // Panel
        viewBooksPanel = new JPanel();

        // Table
        ArrayList<String> data = new ArrayList<String>();
        UserData userData = new UserData(".\\src\\com\\company\\books.txt");
        data = userData.getData();
        int size = data.size();
        System.out.println(size);
        String[][] c = new String[size][5];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 5; j++) {
                String[] s = data.get(i).split(",");
                c[i][j] = s[j];
            }
        }
        String[] columnsNames = {"Call No", "Name", "Author", "Publisher", "Quantity"};

        viewBooksTable = new JTable(c,columnsNames);
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


