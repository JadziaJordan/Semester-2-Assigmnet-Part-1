/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignmentonesemestertwo;

import java.util.Scanner;

/**
 *
 * @author Jadzia Jordan
 */
public class AssignmentOneSemesterTwo {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    Scanner kb = new Scanner(System.in); // SCanner system 
    Student stud = new Student(); // constructor 
    String choice;// allows for a loop 
    
    int menuOption;

    System.out.println("STUDENT MANAGEMENT APPLICATION\n******************************************");
    System.out.println("Enter (1) to launch menu or any other key to exit");
    choice = kb.nextLine(); // if one is  entered  the menu is popped up 

    while ("1".equals(choice)) {
        System.out.println("Please select one of the following menu items: " //
            + "\n(1) Capture a new Student."
            + "\n(2) Search for a student."
            + "\n(3) Delete a student."
            + "\n(4) Print a student report."
            + "\n(5) Exit Application.");

        menuOption = kb.nextInt();
        kb.nextLine();  // Consume newline left-over from pressing Enter

        switch(menuOption) {
            case 1: 
                stud.collectAndSaveStudent(); // pulls from the student , collects and saves 
                break;
            case 2: 
                stud.collectAndSearchStudent(); // pulls from student 
                break;
            case 3: 
                stud.collectAndDeleteStudent(); 
                break;
            case 4: 
                stud.StudentReport(); 
                break;
            case 5: 
                stud.ExitStudentApplication();// displays outro msg 
                return;
            default: 
                System.out.println("Invalid choice");// if the wrong number is entered then it re loops 
        }  

        System.out.println("Enter (1) to launch menu or any other key to exit");
        choice = kb.nextLine();// loops again 
    }

    stud.ExitStudentApplication();
}
}