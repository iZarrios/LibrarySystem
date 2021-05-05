package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WelcomePage implements ActionListener {

    JFrame frame = new JFrame();
    private final JButton addLibrarian = new JButton("Add Librarian");
    private final JButton viewLibrarian = new JButton("View Librarians");
    private final JButton deleteLibrarian = new JButton("Delete Librarian");
    private final JButton logOut = new JButton("Log Out");

//    WelcomePage(String userID){
    WelcomePage(){
        frame.setResizable(false);
        JLabel welcomeLabel = new JLabel("Admin Section");
        welcomeLabel.setBounds(120,10,220,50);
        welcomeLabel.setFont(new Font(null,Font.ITALIC,20));
        frame.add(welcomeLabel);

        addLibrarian.setBounds(90, 80, 200, 50);
        addLibrarian.setFocusable(false);
        addLibrarian.addActionListener(this);
        frame.add(addLibrarian);

        viewLibrarian.setBounds(90, 140, 200, 50);
        viewLibrarian.setFocusable(false);
        viewLibrarian.addActionListener(this);
        frame.add(viewLibrarian);

        deleteLibrarian.setBounds(90, 200, 200, 50);
        deleteLibrarian.setFocusable(false);
        deleteLibrarian.addActionListener(this);
        frame.add(deleteLibrarian);

        logOut.setBounds(90, 260, 200, 50);
        logOut.setFocusable(false);
        logOut.addActionListener(this);
        frame.add(logOut);


        //end
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addLibrarian)
        {
            new AddLibrarian();
            System.out.println("I am clicked");
            frame.dispose();
        }
        if(e.getSource() == viewLibrarian)
        {
            new ViewLibrarian();
            System.out.println("I am clicked");
            frame.dispose();
        }
        if(e.getSource() == deleteLibrarian)
        {
            System.out.println("I am clicked");
//            frame.dispose();
        }
        if(e.getSource() == logOut)
        {
            new GUI();
            System.out.println("I am clicked");
            frame.dispose();
        }
    }
}