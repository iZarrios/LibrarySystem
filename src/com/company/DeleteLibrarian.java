package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        deleteButton.setBounds(125, 200, 100, 25);
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
        if (e.getSource() == deleteButton) {
            userIDField.setText("");
            JOptionPane.showMessageDialog(null, "Record deleted Successfully!");
            System.out.println("I am clicked");
            // frame.dispose();
        }
        if (e.getSource() == backButton) {
            new AdminSection();
            System.out.println("I am clicked");
            frame.dispose();
        }
    }
}
