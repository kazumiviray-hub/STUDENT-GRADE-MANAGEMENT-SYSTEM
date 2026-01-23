/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentgradesystem;
import java. util. Scanner;
/**
 *
 * @author BED
 */
public class StudentGradeSystem {

     static String[] names = new String[50];
    static int[] ids = new int[50]; 
    static double[] averages = new double[100];
    static String[] remarks = new String[100];
    static int count = 0; 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ProgramTitle = "STUDENT GRADE MANAGEMENT SYSTEM";
        String Separator = "=".repeat(60);
        int HELLO = 0;

        do {
            System.out.println("\nWELCOME TO THE " + ProgramTitle);
            System.out.println(Separator);

            System.out.println("[1] Add Student");
            System.out.println("[2] View All Students");
            System.out.println("[3] Exit");
            System.out.print("Enter Choice: ");

            if (sc.hasNextInt()) {
                HELLO = sc.nextInt();
                sc.nextLine(); 

                switch (HELLO) {
                    case 1:
                        // --- CASE 1: ADD STUDENT ---
                        if (count >= names.length) {
                            System.out.println("Database is full (Max 50 Students)");
                            break;
                        }

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter ID Number: ");
                        int id = sc.nextInt(); 

                        System.out.println("Enter 3 Grades for each subject:");
                        System.out.print("Grade 1: ");
                        int g1 = sc.nextInt();
                        System.out.print("Grade 2: ");
                        int g2 = sc.nextInt();
                        System.out.print("Grade 3: ");
                        int g3 = sc.nextInt();
                        sc.nextLine();

                        // Calculate Average
                        double avg = (g1 + g2 + g3) / 3.0;

                      
                        String remark;
                        if (avg >= 90) {
                            remark = "Excellent";
                        } else if (avg >= 80) {
                            remark = "Very Good";
                        } else if (avg >= 70) {
                            remark = "Good";
                        } else if (avg >= 60) {
                            remark = "Needs Improvement";
                        } else {
                            remark = "Fail";
                        }
                        
                        // Save data to arrays
                        names[count] = name;
                        ids[count] = id;
                        averages[count] = avg;
                        remarks[count] = remark;
                        count++; 

                        System.out.println("Student Added Successfully!");
                        break;

                    case 2:
                        // --- CASE 2: VIEW ALL STUDENTS ---
                        if (count == 0) {
                            System.out.println("No students added yet.");
                        } else {
                            System.out.println(Separator);
                            
                            System.out.printf("%-10s %-20s %-10s %-20s%n", "ID", "Name", "Average", "Remark");
                            System.out.println(Separator);

                            for (int i = 0; i < count; i++) {
                                System.out.printf("%-10d %-20s %-10.2f %-20s%n", 
                                    ids[i], names[i], averages[i], remarks[i]);
                            }
                            System.out.println(Separator);
                        }
                        break;

                    case 3:
                        // --- CASE 3: EXIT ---
                        System.out.println("Completed. Goodbye");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Clear invalid input
                HELLO = 0; // Reset to keep loop going
            }

        } while (HELLO != 3); // Loop repeats until user chooses 3
    }
}
   
