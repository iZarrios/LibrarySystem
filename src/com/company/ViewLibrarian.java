package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.ArrayList;

public class ViewLibrarian {

    ViewLibrarian() {
        ArrayList<String> data;
        UserData auth = new UserData(".\\src\\com\\company\\DB.txt");
        data = auth.getData();
        int size = data.size();
        System.out.println(size);
        String[][] c = new String[size][7];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 7; j++) {
                String[] s = data.get(i).split(",");
                c[i][j] = s[j];
            }
        }

        String[] columnKeys = { "ID", "Name", "Password", "Email", "Address", "City", "Contact Info" };
        JTable table = new JTable(c, columnKeys);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int j = 0; j < 7; j++) {
            table.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
        table.setBounds(0, 0, 200, 300);
        table.setEnabled(false);
        JScrollPane sp = new JScrollPane(table);
        JFrame frame = new JFrame();
        frame.add(sp);
        // end
        table.setEnabled(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(820, 420);
        frame.setVisible(true);
    }
}