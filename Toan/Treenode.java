/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Toan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Treenode {
    class TreeNode {
    Student student;
    TreeNode left, right;

    public TreeNode(Student student) {
        this.student = student;
        left = right = null;
    }
}
    private TreeNode root;

    public void addStudent(int id, String name, double marks) {
        root = insert(root, new Student(id, name, marks));
    }

    private TreeNode insert(TreeNode node, Student student) {
        if (node == null) return new TreeNode(student);
        if (student.id < node.student.id) {
            node.left = insert(node.left, student);
        } else if (student.id > node.student.id) {
            node.right = insert(node.right, student);
        } else {
            System.out.println("Student with ID " + student.id + " already exists.");
        }
        return node;
    }

    public void deleteStudent(int id) {
        root = deleteNode(root, id);
    }

    private TreeNode deleteNode(TreeNode root, int id) {
        if (root == null) return null;

        if (id < root.student.id) root.left = deleteNode(root.left, id);
        else if (id > root.student.id) root.right = deleteNode(root.right, id);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.student = findMin(root.right).student;
            root.right = deleteNode(root.right, root.student.id);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public Student searchStudent(int id) {
        TreeNode result = search(root, id);
        return (result != null) ? result.student : null;
    }

    private TreeNode search(TreeNode root, int id) {
        if (root == null || root.student.id == id) return root;
        if (id < root.student.id) return search(root.left, id);
        return search(root.right, id);
    }

    public void editStudent(int id, String newName, double newMarks) {
        TreeNode node = search(root, id);
        if (node != null) {
            node.student.name = newName;
            node.student.marks = newMarks;
            node.student.rank = node.student.calculateRank(newMarks);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Method to collect all students in a list
    private void collectStudents(TreeNode node, List<Student> students) {
        if (node != null) {
            collectStudents(node.left, students);
            students.add(node.student);
            collectStudents(node.right, students);
        }
    }

    // Method to display students sorted by marks
    
    //viet lai bubble sort
    public void displayStudentsSortedByMarks() {
        List<Student> students = new ArrayList<>();
        collectStudents(root, students);
        
        students.sort(Comparator.comparingDouble(s -> s.marks));

        System.out.println("Students sorted by Marks:");
for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displayStudents() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.student);
            inOrderTraversal(node.right);
        }
    }
}


