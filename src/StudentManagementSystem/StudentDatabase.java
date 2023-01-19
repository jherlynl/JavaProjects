package StudentManagementSystem;

import java.util.Scanner;

public class StudentDatabase {
    //jbk
    public static void main(String[] args) {

        //Ask user how many new students will be added to the database

        System.out.print("Enter amount of students to enroll: ");
        Scanner num = new Scanner(System.in);
        int studentNum = num.nextInt();
        Student[] students = new Student[studentNum];
        //Student[2]
        //i=0
        //i=1
        //i=2
        //i=3

        for (int i = 0; i < studentNum; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
            students[i].showStatus();
        }
    }
}