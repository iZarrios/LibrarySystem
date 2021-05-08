package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserData {
    private ArrayList<String> data = new ArrayList<>();
    private String path;

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public void setUser(ArrayList<String> data, String newData, int index) {
        data.set(index, newData);
    }

    public void addUser(ArrayList<String> data, String newData) {
        data.add(newData);
    }

    public void removeUser(ArrayList<String> data, int index) {
        data.remove(index);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public UserData(String path) {
        this.path = path;
    }

    public ArrayList getData() {
        try {
            File f = new File(path);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                data.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void saveData() {
        try {
            PrintWriter out = new PrintWriter(path);
            for (String datum : data) {
                out.println(String.valueOf(datum));
            }
            out.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isStringOnlyAlphabet(String str) {
        return ((str != null) // if string not null nor empty and is matches that regex expression
                && (!str.equals(""))// returns 1 on success
                && (str.matches("^[a-zA-Z ]*$")));
    } // src :
    // https://www.geeksforgeeks.org/check-if-a-string-contains-only-alphabets-in-java-using-regex/

    public static boolean isValidEMail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);// returns 1 on success
    } // src : https://www.tutorialspoint.com/validate-email-address-in-java

}