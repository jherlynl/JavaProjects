package StudentManagementSystem;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private int year;
    private String studentId;
    private String courses = " ";

    private int tuitionBalance = 0;
    private static int classCost=600;
    private static int id = 100;

    //Ask for Student's name and year
    public Student() {
        Scanner fn = new Scanner(System.in);
        System.out.print("Enter student's first name: ");
        this.firstName = fn.nextLine();

        Scanner ln = new Scanner(System.in);
        System.out.print("Enter student's last name: ");
        this.lastName = ln.nextLine();

        Scanner yr = new Scanner(System.in);
        System.out.print("1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nPlease enter student's grade year: ");
        this.gradeYear = yr.nextInt();
        if(gradeYear == 1) {
            this.year = Integer.parseInt("09");
        } else if (gradeYear ==2) {
            this.year = Integer.parseInt("10");
        } else if(gradeYear == 3) {
            this.year = Integer.parseInt("11");
        } else {
            this.year = Integer.parseInt("12");
        }
        setStudentId();

        //System.out.println("Student name: " + firstName + " " + lastName + ". Grade Year: " + year + ". Student ID: " + studentId);

    }

    //Create a student ID with their grade level
    private void setStudentId() {
        id++;
        if(gradeYear == 1) {
            this.studentId = String.valueOf("09" + "" + id);
        } else if (gradeYear ==2) {
            this.studentId = String.valueOf("10" + "" + id);
        } else if(gradeYear == 3) {
            this.studentId = String.valueOf("11" + "" + id);
        } else {
            this.studentId = String.valueOf("12" + "" + id);
        }
    }

    //Enroll student in courses
    public void enroll() {
        do {
            System.out.print("Enter course name to enroll student (Type QUIT to exit):");
            Scanner en = new Scanner(System.in);
            String course = en.nextLine();
            if (!course.equals("QUIT")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + classCost;
            } else {
                System.out.println("Finished enrolling in courses!");
                break;
            }
        } while (true);
        //System.out.println("Courses Student Enrolled In: " + courses);
        //System.out.println("1Tuition Balance: $" + tuitionBalance);
    }

    //View balance
    public void viewBalance() {
        System.out.println("Tuition Balance: $" + tuitionBalance);
    }
    //Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Please enter a payment amount: $");
        Scanner pay = new Scanner(System.in);
        int payment = pay.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $" + payment + ".");
        System.out.println("Your tuition balance is now: $" + tuitionBalance + ".");
    }

    //Show status
    public void showStatus() {
        System.out.println("Student Name: " + firstName + " " + lastName +
                "\nGrade Level: " + year +
                "\nStudent ID: " + studentId +
                "\nCourses Enrolled:" + courses +
                "\nTuition Balance: $" + tuitionBalance);
    }
}
