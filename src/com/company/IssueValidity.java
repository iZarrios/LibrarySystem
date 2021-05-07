package com.company;

import java.util.ArrayList;

public class IssueValidity {
    private int indexStudent;
    private ArrayList<String> dataStudent;
    private int indexBook;
    private ArrayList<String> dataBook;

    private UserData studentData = new UserData(".\\src\\com\\company\\StudentDB.txt");
    private UserData bookData = new UserData(".\\src\\com\\company\\books.txt");
    private String[][] c1;
    private String[][] c2;

//    public static void main(String[] args) {
//        IssueValidity v=new IssueValidity();
//        System.out.println(v.canStudentIssue(7052));
//        System.out.println(v.canBeIssuedBook(705));
//        v.decQuantityIncIssued();
//    }

    public int canStudentIssue(int ID){
        int validStudent=0;
        dataStudent = studentData.getData();
        int size = dataStudent.size();
        c1 = new String[size][8];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 8; j++) {
                String[] s1 = dataStudent.get(i).split(",");
                c1[i][j] = s1[j];
            }
            if(Integer.parseInt(c1[i][0])==ID && Integer.parseInt(c1[i][7])<3) {
                validStudent=1;
                indexStudent=i;
            }
        }
        return validStudent;
    }
    public int canBeIssuedBook(int call){
        int validBook=0;
        dataBook = bookData.getData();
        int size = dataBook.size();
        //System.out.println(dataBook);
        c2 = new String[size][5];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 5; j++) {
                String[] s2 = dataBook.get(i).split(",");
                c2[i][j] = s2[j];
            }
            if(Integer.parseInt(c2[i][0])==call && Integer.parseInt(c2[i][4])>0) {
                validBook=1;
                indexBook=i;
            }
        }
        return validBook;

    }
    public void decQuantityIncIssued(){
        c1[indexStudent][7]=Integer.toString(Integer.parseInt(c1[indexStudent][7])+1);
        System.out.println("Quantity: "+c1[indexStudent][7]);
        studentData.removeUser(dataStudent,indexStudent);
        StringBuilder temp1 = new StringBuilder();
        for(int j=0;j<8;j++){
            temp1.append(c1[indexStudent][j]);
            if(j!=7) temp1.append(",");
        }
        studentData.addUser(dataStudent,temp1.toString());
        studentData.saveData();

        c2[indexBook][4]=Integer.toString(Integer.parseInt(c2[indexBook][4])-1);
        bookData.removeUser(dataBook,indexBook);
        StringBuilder temp2 = new StringBuilder();
        for(int i=0;i<5;i++){
            temp2.append(c2[indexBook][i]);
            if(i!=4) temp2.append(",");
        }
        bookData.addUser(dataBook,temp2.toString());
        bookData.saveData();
    }
}
