/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Toan;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Admin
 */
public class StudentManagement {

    private final Stack<Student> studentStack = new Stack<>();

    public void addStudent(Student student) {
        studentStack.push(student);
    }
    public void editStudent(int id, String newName, double newMarks) {
        Stack<Student> tempStack = new Stack<>();
        boolean found = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.id == id) {
                student.name = newName;
                student.marks = newMarks;
                student.rank = student.determineRank(newMarks);
                found = true;
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }
    public void deleteStudent(int id) {
        Stack<Student> tempStack = new Stack<>();
        boolean found = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.id == id) {
                found = true;
                continue; // Skip this student
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found!");
        }
    }
    public void searchStudent(int id) {
        Stack<Student> tempStack = new Stack<>();
        boolean found = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.id == id) {
                found = true;
                System.out.println(student);
            }
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    public void displayStudents() {
        Stack<Student> tempStack = new Stack<>();

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            System.out.println(student);
            tempStack.push(student);
        }

        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }
    }

    public void bubbleSortByMarks() {
        // Chuyển Stack thành ArrayList để dễ dàng thực hiện Bubble Sort
        ArrayList<Student> studentList = new ArrayList<>(studentStack);

        int n = studentList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (studentList.get(j).marks > studentList.get(j + 1).marks) {
                    // Hoán đổi sinh viên nếu điểm của sinh viên trước lớn hơn sinh viên sau
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                }
            }
        }

        // Cập nhật lại Stack với danh sách sinh viên đã sắp xếp
        studentStack.clear();
        studentStack.addAll(studentList);

        System.out.println("Students sorted by marks in ascending order.");
    }

}
