package com.company;

import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ReturnValidity {
    private final int callingNumber;
    private final int ID;

    ReturnValidity(int callingNumber, int ID) {
        this.callingNumber = callingNumber;
        this.ID = ID;
    }

    private ArrayList<String> dataStudent;

    private ArrayList<String> dataBook;
    private int indexIssuedBook;

    private ArrayList<String> dataIssuedBook;

    private final UserData studentData = new UserData(".\\src\\com\\company\\StudentDB.txt");
    private final UserData bookData = new UserData(".\\src\\com\\company\\books.txt");
    private final UserData issuedBooksData = new UserData(".\\src\\com\\company\\issuedBooks.txt");

    private String[][] c0;
    private String[][] c1;
    private String[][] c2;

    public int canReturn() {
        int validReturn = 0;
        dataIssuedBook = issuedBooksData.getData();
        int size = dataIssuedBook.size();
        c0 = new String[size][5];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 5; j++) {
                String[] s1 = dataIssuedBook.get(i).split(",");
                c0[i][j] = s1[j];
            }
            if (Integer.parseInt(c0[i][0]) == callingNumber && Integer.parseInt(c0[i][1]) == ID) {
                validReturn = 1;
                indexIssuedBook = i;
            }
        }
        return validReturn;
    }

    private int getStudent() {
        dataStudent = studentData.getData();
        int size = dataStudent.size();
        c1 = new String[size][8];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 8; j++) {
                String[] s1 = dataStudent.get(i).split(",");
                c1[i][j] = s1[j];
            }
            if (Integer.parseInt(c1[i][0]) == ID) {
                return i;
            }
        }
        return -1;
    }

    private int getBook() {
        dataBook = bookData.getData();
        int size = dataBook.size();
        c2 = new String[size][5];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 5; j++) {
                String[] s2 = dataBook.get(i).split(",");
                c2[i][j] = s2[j];
            }
            if (Integer.parseInt(c2[i][0]) == callingNumber) {
                return i;
            }
        }
        return -1;
    }

    public void decQuantityIncBooksRemoveIssued() {
        int indexStudent = getStudent();
        c1[indexStudent][7] = Integer.toString(Integer.parseInt(c1[indexStudent][7]) - 1);
        System.out.println("Quantity: " + c1[indexStudent][7]);
        studentData.removeUser(dataStudent, indexStudent);
        StringBuilder temp1 = new StringBuilder();
        for (int j = 0; j < 8; j++) {
            temp1.append(c1[indexStudent][j]);
            if (j != 7)
                temp1.append(",");
        }
        studentData.addUser(dataStudent, temp1.toString());
        studentData.saveData();

        int indexBook = getBook();
        c2[indexBook][4] = Integer.toString(Integer.parseInt(c2[indexBook][4]) + 1);
        bookData.removeUser(dataBook, indexBook);
        StringBuilder temp2 = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            temp2.append(c2[indexBook][i]);
            if (i != 4)
                temp2.append(",");
        }
        bookData.addUser(dataBook, temp2.toString());
        bookData.saveData();
        String todayDate;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar obj = Calendar.getInstance();
        todayDate = format.format(obj.getTime());
        try {
            if (format.parse(todayDate).compareTo(format.parse(c0[indexIssuedBook][4])) > 0)
                JOptionPane.showMessageDialog(null, "There is a financial Penalty");
            else if (format.parse(todayDate).compareTo(format.parse(c0[indexIssuedBook][4])) == 0)
                JOptionPane.showMessageDialog(null, "Right on Time");
            else {
                JOptionPane.showMessageDialog(null, "Thanks for early return");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        issuedBooksData.removeUser(dataIssuedBook, indexIssuedBook);
        issuedBooksData.saveData();
    }

}
