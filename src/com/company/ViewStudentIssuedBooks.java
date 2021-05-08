package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class ViewStudentIssuedBooks {

    public static void main(String[] args) {
        new ViewStudentIssuedBooks("287");
    }
    ViewStudentIssuedBooks(String userID_1) {
        // Creating Frame
        JFrame viewIssuedBooksFrame = new JFrame();

        // Panel
        JPanel viewIssuedBooksPanel = new JPanel();

        // Table
        ArrayList<String> data;
        UserData userData = new UserData(".\\src\\com\\company\\IssuedBooks.txt");
        data = userData.getData();
        int size = data.size();
        String[][] c1 = new String[size][6];
        int ID = 0;
        int count=0;
        for (int i = 0; i < size; i++) {
            c1[i][0] = Integer.toString(++ID);
            for (int j = 0; j < 5; j++) {
                String[] s = data.get(i).split(",");
                c1[i][j + 1] = s[j];
            }
            if(c1[i][2].equals(userID_1)) count++;
        }
        String[][] c2 = new String[count][6];
        int row=0;
        for (int i = 0; i < size; i++) {
            if(c1[i][2].equals(userID_1)){
                for (int j = 0; j < 6; j++) {
                    c2[row][j]=c1[i][j];
                }
                row++;
            }
        }
        String[] columnsNames = { "ID", "Book Calling", "Student ID", "Student Name", "Contact", "Issue Date" };
        JTable viewIssuedBooksTable = new JTable(c2, columnsNames);
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