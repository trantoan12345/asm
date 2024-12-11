
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Toan;


/**
 *
 * @author Admin
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Treenode studentTree = new Treenode();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nStudent Management System:");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Search Student");
                System.out.println("5. Display All Students");
                System.out.println("6. Display Students Sorted by Marks");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Student ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        String name;
                        while (true) {
                            System.out.print("Enter Student Name: ");
                            name = scanner.nextLine();
                            if (name.matches(".*\\d.*")) { // Kiểm tra nếu tên chứa số
                                System.out.println("Invalid name. Name should not contain numbers.");
                            } else {
                                break; // Thoát vòng lặp nếu tên hợp lệ
                            }
                        }

                        double marks;
                        while (true) {
                            System.out.print("Enter Marks (1 to 10): ");
                            marks = Double.parseDouble(scanner.nextLine());
                            if (marks < 1 || marks > 10) { // Kiểm tra nếu điểm ngoài khoảng 1-10
                                System.out.println("Invalid marks. Marks should be between 1 and 10.");
                            } else {
                                break; // Thoát vòng lặp nếu điểm hợp lệ
                            }
                        }

                        studentTree.addStudent(id, name, marks);
                    }
                    case 2 -> {
                        System.out.print("Enter Student ID to edit: ");
                        int editId = Integer.parseInt(scanner.nextLine());

                        String newName;
                        while (true) {
                            System.out.print("Enter new name: ");
                            newName = scanner.nextLine();
                            if (newName.matches(".*\\d.*")) { // Kiểm tra nếu tên chứa số
                                System.out.println("Invalid name. Name should not contain numbers.");
                            } else {
break; // Thoát vòng lặp nếu tên hợp lệ
                            }
                        }

                        double newMarks;
                        while (true) {
                            System.out.print("Enter new marks (1 to 10): ");
                            newMarks = Double.parseDouble(scanner.nextLine());
                            if (newMarks < 1 || newMarks > 10) { // Kiểm tra nếu điểm ngoài khoảng 1-10
                                System.out.println("Invalid marks. Marks should be between 1 and 10.");
                            } else {
                                break; // Thoát vòng lặp nếu điểm hợp lệ
                            }
                        }

                        studentTree.editStudent(editId, newName, newMarks);
                    }
                    case 3 -> {
                        System.out.print("Enter Student ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        studentTree.deleteStudent(deleteId);
                    }
                    case 4 -> {
                        System.out.print("Enter Student ID to search: ");
                        int searchId = Integer.parseInt(scanner.nextLine());
                        Student foundStudent = studentTree.searchStudent(searchId);
                        if (foundStudent != null) {
                            System.out.println("Student Found: " + foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                    }
                    case 5 -> {
                        System.out.println("All Students:");
                        studentTree.displayStudents();
                    }
                    case 6 -> studentTree.displayStudentsSortedByMarks();
                    case 7 -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}




