/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmentonesemestertwo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jadzia Jordan
 */
public class Student {

    ArrayList<String> studentName = new ArrayList<>(); // array lists to save the  information 
    ArrayList<String> studentEmail = new ArrayList<>();
    ArrayList<String> studentCourse = new ArrayList<>();
    ArrayList<Integer> studentID = new ArrayList<>();
    ArrayList<Integer> studentAge = new ArrayList<>();
    Scanner jn = new Scanner(System.in);

    // Business logic to save student using parameters
    public void SaveStudent(int id, String name, int age, String email, String course) { // saves to the array and used for the unit test 
        studentID.add(id);
        studentName.add(name);
        studentAge.add(age);
        studentEmail.add(email);
        studentCourse.add(course);
    }

    // Method to collect user input and then save student
    public void collectAndSaveStudent() {
        System.out.println("CAPTURE A NEW STUDENT \n************************");
        System.out.print("Enter the student ID:");
        int inputID = jn.nextInt();

        System.out.print("Enter the student name:");
        jn.nextLine();
        String inputName = jn.nextLine();

        int correctAge = ageLoop();

        System.out.print("Enter the student email:");
        String inputEmail = jn.nextLine();

        System.out.print("Enter the student course:");
        String inputCourse = jn.nextLine();

        SaveStudent(inputID, inputName, correctAge, inputEmail, inputCourse);
        System.out.println("Student details have been successfully saved.");
    }

    public int ageLoop() { // checks to see if a letter or number below 16 is entered
        boolean isValid = false;  
        String inputAge;
        int correctAge = 0;
        System.out.print("Enter the student age:");
        inputAge = jn.nextLine();
        while (!isValid) {
        
            if (isLetter(inputAge)) {
                System.out.println("You have entered an incorrect student Age!!!");
                System.out.print("Please re-enter the student age>>>");
                inputAge = jn.nextLine();
            } else {
                correctAge = Integer.parseInt(inputAge);

                if (correctAge < 16) {
                    System.out.println("You have entered an incorrect student Age!!!");
                    System.out.print("Please re-enter the student age>>>");
                    inputAge = jn.nextLine();
                } else {
                    isValid = true;
                }
            }
        }
        
        return correctAge;
    }
   
    public static boolean isLetter(String str) {
        return str.matches("[a-zA-Z]+"); // used to see if it is a ketter 
    } 

    // Business logic to search student using parameters , this is used for unit tests
    public void SearchStudent(int id) {
        if (studentID.contains(id)) {
            int position = studentID.indexOf(id);
            System.out.println("Student ID: " + id + "\n" +
                     "Student Name: " + studentName.get(position) + "\n" +
                     "Student Age: " + studentAge.get(position) + "\n" +
                     "Student Email: " + studentEmail.get(position) + "\n" +
                     "Student Course: " + studentCourse.get(position));
        } else {
            System.out.println("Student with Student ID: " + id + " was not found");
        }
    }

    // Method to collect user input and then search student
    public void collectAndSearchStudent() {
        System.out.print("Enter the student ID to search:");
        int inputSearch = jn.nextInt();
        SearchStudent(inputSearch);
    }

    // Business logic to delete student using parameters
    public void DeleteStudent(int id) {
        if (studentID.contains(id)) {
            int deletePosition = studentID.indexOf(id);
            studentID.remove(deletePosition);
            studentName.remove(deletePosition);
            studentAge.remove(deletePosition);
            studentEmail.remove(deletePosition);
            studentCourse.remove(deletePosition);
        } else {
            System.out.println("Student with Student ID: " + id + " was not found!");
        }
    }

    // Method to collect user input and then delete student
    public void collectAndDeleteStudent() {
        System.out.print("Enter the student ID you want to delete: ");
        int inputDelete = jn.nextInt();
        DeleteStudent(inputDelete);
    }

    public void StudentReport() { // prints everything that is in the array list 
        for (int i = 0; i < studentName.size(); i++) {
            System.out.println("STUDENT "+ (i+1));
            System.out.println("-------------------------------------");
            System.out.println("Student ID: " + studentID.get(i) + "\n" +
                     "Student Name: " + studentName.get(i) + "\n" +
                     "Student Age: " + studentAge.get(i) + "\n" +
                     "Student Email: " + studentEmail.get(i) + "\n" +
                     "Student Course: " + studentCourse.get(i));
            System.out.println("-------------------------------------");
        }
    }

    public void ExitStudentApplication() { // outro msg
        System.out.println("Thank you for using the application!");
    }
}