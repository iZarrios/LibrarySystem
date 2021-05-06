package com.company;

import javax.swing.*;
import java.util.ArrayList;


public class ViewLibrarian  {
    private JFrame frame = new JFrame();;
    private JTable table;

    ViewLibrarian() {
        ArrayList<String> data;
        UserData auth = new UserData(".\\src\\com\\company\\db.txt");
        data = auth.getData();
        int size = data.size();
        System.out.println(size);
        String[][] c = new String[size][7];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 7; j++) {
                String  [] s = data.get(i).split(",");
                c[i][j] = s[j];
            }
            String[] columnKeys = {"ID", "Name", "Password", "Email", "Address", "City", "Contact Info"};
            table = new JTable(c, columnKeys);
            table.setBounds(0, 0, 200, 300);
            table.setEnabled(false);
            JScrollPane sp = new JScrollPane(table);
            frame.add(sp);
            // end
            table.setEnabled(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(820, 420);
            frame.setVisible(true);
        }
    }
}