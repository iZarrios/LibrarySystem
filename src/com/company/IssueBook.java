package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class IssueBook implements ActionListener {

    private final JFrame issueBookFrame;
    private final JPanel issueBookPanel;

    private final JButton issueBookButton;
    private final JButton backButton;

    private final JLabel issueBookLabel;
    private final JLabel bookCallingLabel;
    private final JLabel studentIDLabel;
    private final JLabel studentNameLabel;
    private final JLabel studentContactLabel;
    private final JLabel issueDateLabel;

    private final JTextField bookCallingField;
    private final JTextField studentIDField;
    private final JTextField studentNameField;
    private final JTextField studentContactField;
    private final JTextField issueDateField;
    IssueBook(){
        //Creating Frame
        issueBookFrame=new JFrame();
        //Labels
        issueBookLabel=new JLabel("Issue Book");
        issueBookLabel.setBounds(200,10,100,50);

//        idLabel=new JLabel("Call Number: ");
//        idLabel.setBounds(100,60,100,50);


        bookCallingLabel=new JLabel("Call Number: ");
        bookCallingLabel.setBounds(100,60,100,50);

        studentIDLabel=new JLabel("Student ID: ");
        studentIDLabel.setBounds(100,110,100,50);

        studentNameLabel=new JLabel("Student Name: ");
        studentNameLabel.setBounds(100,160,100,50);

        studentContactLabel=new JLabel("Student Contact:");
        studentContactLabel.setBounds(100,210,100,50);

        issueDateLabel=new JLabel("Return Date:");
        issueDateLabel.setBounds(100,260,100,50);


        //Text fields
//        idField=new JTextField();
//        idField.setBounds(180,70,100,30);

        bookCallingField=new JTextField();
        bookCallingField.setBounds(200,70,100,30);

        studentIDField=new JTextField();
        studentIDField.setBounds(200,120,100,30);

        studentNameField=new JTextField();
        studentNameField.setBounds(200,170,100,30);

        studentContactField=new JTextField();
        studentContactField.setBounds(200,220,100,30);

        issueDateField=new JTextField();
        issueDateField.setBounds(200,270,100,30);


        //Buttons
        issueBookButton =new JButton(" Issue Book");
        issueBookButton.setBounds(180,380,100,30);
        issueBookButton.addActionListener(this);
        backButton =new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(180,420,100,30);

        //Panel
        issueBookPanel =new JPanel();

        //Add to Frame
        issueBookFrame.add(issueBookLabel);

//        issueBookFrame.add(idLabel);
//        issueBookFrame.add(idField);

        issueBookFrame.add(bookCallingLabel);
        issueBookFrame.add(bookCallingField);

        issueBookFrame.add(studentIDLabel);
        issueBookFrame.add(studentIDField);

        issueBookFrame.add(studentNameLabel);
        issueBookFrame.add(studentNameField);

        issueBookFrame.add(studentContactLabel);
        issueBookFrame.add(studentContactField);

        issueBookFrame.add(issueDateLabel);
        issueBookFrame.add(issueDateField);

        issueBookFrame.add(issueBookButton);
        issueBookFrame.add(backButton);

        //Frame
        issueBookFrame.add(issueBookPanel,BorderLayout.CENTER);
        //addBooksFrame.add(addBooksPanel);
        issueBookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        issueBookFrame.setTitle("University Library System");
        issueBookFrame.pack();
        issueBookFrame.setSize(500, 500);
        issueBookFrame.setLayout(null);
        issueBookFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == issueBookButton)
        {
            System.out.println("I am clicked");
            JOptionPane.showMessageDialog(null, "Book has been issued Successfully!");
//            addBooksFrame.dispose();
        }
        if(e.getSource() == backButton)
        {

            System.out.println("I am clicked");
            issueBookFrame.dispose();
            new LibrarianSection();
        }
    }
}
