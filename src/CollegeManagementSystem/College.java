package CollegeManagementSystem;

/**
Project Submission for OOP from BAP-II
Instructor: Sir Saeed Ahmed
Created by: Neil Kamal (BAP-221024) on 17th June 2023
Along with Syed Shahzain Shakeel (BAP-221007) & Muhammad Daniyal (BAP-221026)
Project Idea from a Youtube Video
GUI from ChatGPT
 */


import java.util.ArrayList;
import java.util.List;

/**
 * Represents a College Management System that manages teachers, students, and financial transactions.
 */
public class College {
    private List<Teacher> teachers; // Encapsulation: Using private access modifier to encapsulate the list of teachers.
    private List<Student> students; // Encapsulation: Using private access modifier to encapsulate the list of students.
    private int totalMoneyEarned; // Encapsulation: Using private access modifier to encapsulate the total money earned by the college.
    private int totalMoneySpent; // Encapsulation: Using private access modifier to encapsulate the total money spent by the college.

    public College(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        this.totalMoneyEarned = 0;
        this.totalMoneySpent = 0;
    }

    /**
     * Adds a teacher to the college.
     * The teacher to be added.
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     * Retrieves the list of teachers in the college.
     * @return The list of teachers.
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Adds a student to the college.
     * The student to be added.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Retrieves the list of students in the college.
     * @return The list of students.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Retrieves the total money earned by the college.
     * @return The total money earned.
     */
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * Updates the total money earned by the college.
     * The money earned to be added.
     */
    public void updateTotalMoneyEarned(int moneyEarned) {
        totalMoneyEarned += moneyEarned;
    }

    /**
     * Retrieves the total money spent by the college.
     * @return The total money spent.
     */
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    /**
     * Updates the total money spent by the college.
     * The money spent to be added.
     */
    public void updateTotalMoneySpent(int moneySpent) {
        totalMoneySpent += moneySpent;
    }

    /**
     * Pays the salary to all the teachers in the college.
     * Implements polymorphism: The method can work with any type of teacher objects implementing the Teacher interface.
     * Implements abstraction: The method abstracts the process of paying salaries to the teachers, providing a higher-level interface.
     */
    public void paySalaryToTeachers() {
        for (Teacher teacher : teachers) {
            int salary = teacher.getSalary();
            totalMoneySpent += salary;
            updateTotalMoneySpent(salary);
        }
    }
}
