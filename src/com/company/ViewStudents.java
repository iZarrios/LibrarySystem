package com.company;

import javax.swing.*;
import java.util.ArrayList;


public class ViewStudents  {
    private JFrame frame = new JFrame();;
    private JTable table;

    ViewStudents() {
        ArrayList<String> data;
        UserData auth = new UserData(".\\src\\com\\company\\StudentDB.txt");
        data = auth.getData();
        int size = data.size();
        System.out.println(size);
        String[][] c = new String[size][7];
        for (int i = 0; i < size; i++) {
            int z=0;
            for (int j = 0; j < 8; j++) {
                if(j==2) continue;
                String  [] s = data.get(i).split(",");
                c[i][z] = s[j];
                z++;
            }
            String[] columnKeys = {"ID", "Name", "Email", "Address", "City", "Contact Info","Quantity"};
            table = new JTable(c, columnKeys);
            table.setBounds(0, 0, 200, 300);
            table.setEnabled(false);
            JScrollPane sp = new JScrollPane(table);
            frame.add(sp);
            // end
            table.setEnabled(false);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setSize(820, 420);
            frame.setVisible(true);
        }
    }
}