package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteLibrarian implements ActionListener {
    private JFrame frame;
    private JButton deleteButton = new JButton("Delete");
    private JLabel userIDLabel = new JLabel("Enter ID:");
    private JTextField userIDField = new JTextField();
    private JButton backButton = new JButton("Back");

    public static void main(String[] args) {
        new DeleteLibrarian();
    }

    DeleteLibrarian() {
        frame = new JFrame();
        userIDLabel.setBounds(50, 100, 75, 25);
        userIDField.setBounds(125, 100, 200, 25);

        deleteButton.setBounds(150, 200, 100, 25);
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(this);

        backButton.setBounds(320, 345, 80, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        frame.add(backButton);
        frame.add(deleteButton);
        frame.add(userIDLabel);
        frame.add(userIDField);
        // end
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> data = new ArrayList<String>();
        UserData auth = new UserData(".\\src\\com\\company\\db.txt");
        data = auth.getData();
        int size = data.size();
        int flag  = 0;
        String[][] c = new String[size][7];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 7; j++) {
                String[] s = data.get(i).split(",");
                c[i][j] = s[j];
            }
        }
        String ID = userIDField.getText();
        if (e.getSource() == deleteButton) {
            for (int i = 0; i < size; i++) {
                if (c[i][0].equals(ID)) {
                    data.remove(i);
                    auth.saveData();
                    data = auth.getData();
                    userIDField.setText("");
                    JOptionPane.showMessageDialog(null, "Record deleted Successfully!");
                    flag = 1;
                    break;

                }
            }
                if(flag == 0)
                    JOptionPane.showMessageDialog(null, "ID not found!");
                if(flag == 1) {
                    auth.saveData();
                    data = auth.getData();
                }
        }
        if (e.getSource() == backButton) {
            new AdminSection();
            frame.dispose();
        }
    }
}
