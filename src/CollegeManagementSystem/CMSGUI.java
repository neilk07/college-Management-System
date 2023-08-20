package CollegeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//  Inheritance & use of Tag/Marker Interface
public class CMSGUI extends JFrame implements ActionListener {

    private College college; // Encapsulation
    private JTextField teacherNameField, teacherSalaryField, studentNameField, studentGradeField, feesPaidField;
    private JTextArea outputArea;
    private JLabel totalMoneyEarnedLabel, totalMoneySpentLabel, totalMoneyLeftLabel;

    public CMSGUI(College college) {
        this.college = college;
        initializeUI();
        displayCollegeInformation();
    }

    private void initializeUI() {
        setTitle("College Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = createInputPanel();
        add(inputPanel, BorderLayout.NORTH);

        JPanel outputPanel = createOutputPanel();
        add(outputPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Input fields for adding a teacher
        JLabel teacherLabel = new JLabel("Teacher");
        constraints.gridx = 0;
        constraints.gridy = 0;
        inputPanel.add(teacherLabel, constraints);

        // Teacher's name
        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        inputPanel.add(nameLabel, constraints);

        teacherNameField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        inputPanel.add(teacherNameField, constraints);

        // Teacher's salary
        JLabel salaryLabel = new JLabel("Salary:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        inputPanel.add(salaryLabel, constraints);

        teacherSalaryField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 2;
        inputPanel.add(teacherSalaryField, constraints);

        // Button to add a teacher
        JButton addTeacherButton = new JButton("Add Teacher");
        addTeacherButton.addActionListener(this);
        constraints.gridx = 2;
        constraints.gridy = 2;
        inputPanel.add(addTeacherButton, constraints);

        // Input fields for adding a student
        JLabel studentLabel = new JLabel("Student");
        constraints.gridx = 0;
        constraints.gridy = 3;
        inputPanel.add(studentLabel, constraints);

        // Student's name
        JLabel studentNameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        inputPanel.add(studentNameLabel, constraints);

        studentNameField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 4;
        inputPanel.add(studentNameField, constraints);

        // Student's grade
        JLabel gradeLabel = new JLabel("Grade:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        inputPanel.add(gradeLabel, constraints);

        studentGradeField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 5;
        inputPanel.add(studentGradeField, constraints);

        // Student's fees paid
        JLabel feesPaidLabel = new JLabel("Fees Paid:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        inputPanel.add(feesPaidLabel, constraints);

        feesPaidField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 6;
        inputPanel.add(feesPaidField, constraints);

        // Button to add a student
        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(this);
        constraints.gridx = 2;
        constraints.gridy = 6;
        inputPanel.add(addStudentButton, constraints);

        return inputPanel;
    }

    private JPanel createOutputPanel() {
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        outputPanel.add(scrollPane, BorderLayout.CENTER);
        return outputPanel;
    }

    private void updateOutputArea() {
        outputArea.setText("");

        // Displaying the list of teachers
        List<Teacher> teachers = college.getTeachers();
        outputArea.append("Teachers:\n");
        for (Teacher teacher : teachers) {
            outputArea.append(teacher.getName() + " (ID: " + teacher.getId() + ")\n");
        }

        // Displaying the list of students
        List<Student> students = college.getStudents();
        outputArea.append("\nStudents:\n");
        for (Student student : students) {
            outputArea.append(student.getName() + " (ID: " + student.getId() + ")\n");
        }

        // Displaying total money earned by the college
        outputArea.append("\nTotal Money Earned: $" + college.getTotalMoneyEarned() + "\n");
    }

    private void addTeacher() {
        // Adding a new teacher
        String name = teacherNameField.getText();
        int salary = Integer.parseInt(teacherSalaryField.getText());

        Teacher teacher = new Teacher(college.getTeachers().size() + 1, name, salary);
        college.addTeacher(teacher);

        // Clearing the input fields
        teacherNameField.setText("");
        teacherSalaryField.setText("");

        updateOutputArea();
    }

    private void addStudent() {
        // Adding a new student
        String name = studentNameField.getText();
        int grade = Integer.parseInt(studentGradeField.getText());
        int feesPaid = Integer.parseInt(feesPaidField.getText());

        Student student = new Student(college.getStudents().size() + 1, name, grade, college);
        student.payFees(feesPaid);

        // Clearing the input fields
        studentNameField.setText("");
        studentGradeField.setText("");
        feesPaidField.setText("");

        updateOutputArea();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handling button clicks
        if (e.getActionCommand().equals("Add Teacher")) {
            addTeacher();
        } else if (e.getActionCommand().equals("Add Student")) {
            addStudent();
        }
    }

    public void displayCollegeInformation() {
        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        totalMoneyEarnedLabel = new JLabel();
        totalMoneySpentLabel = new JLabel();
        totalMoneyLeftLabel = new JLabel();
        infoPanel.add(totalMoneyEarnedLabel);
        infoPanel.add(totalMoneySpentLabel);
        infoPanel.add(totalMoneyLeftLabel);

        add(infoPanel, BorderLayout.SOUTH);
        updateCollegeInformation();
    }

    private void updateCollegeInformation() {
        // Updating the labels with college information
        String totalMoneyEarned = "Total money earned by college: $" + college.getTotalMoneyEarned();
        String totalMoneySpent = "College paid salary to teachers: $" + college.getTotalMoneySpent();
        String totalMoneyLeft = "Total money left by college: $" + (college.getTotalMoneyEarned() - college.getTotalMoneySpent());

        totalMoneyEarnedLabel.setText(totalMoneyEarned);
        totalMoneySpentLabel.setText(totalMoneySpent);
        totalMoneyLeftLabel.setText(totalMoneyLeft);
    }

    public static void main(String[] args) {
        // Creating teacher and student lists
        List<Teacher> teacherList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();

        // Creating teachers
        Teacher zahra = new Teacher(1, "Zahra", 5000);
        Teacher naeem = new Teacher(2, "Naeem", 7000);
        Teacher farhan = new Teacher(3, "Farhan", 6000);

        // Adding teachers to the list
        teacherList.add(zahra);
        teacherList.add(naeem);
        teacherList.add(farhan);

        // Creating a college object with the teacher list and an empty student list
        College college = new College(teacherList, studentList);

        // Paying salary to the teachers
        college.paySalaryToTeachers();

        // Creating students
        Student ahmed = new Student(1, "Ahmed", 4, college);
        Student aisha = new Student(2, "Aisha Khan", 12, college);
        Student bilal = new Student(3, "Bilal", 5, college);

        // Adding students to the list
        studentList.add(ahmed);
        studentList.add(bilal);
        studentList.add(aisha);

        // Adding students to the college
        college.addStudent(ahmed);
        college.addStudent(bilal);
        college.addStudent(aisha);

        // Creating and adding a new teacher
        Teacher asma = new Teacher(6, "Asma", 9000);
        college.addTeacher(asma);

        // Paying fees for students
        ahmed.payFees(5000);
        bilal.payFees(6000);
        aisha.payFees(4000);

        // Printing college information to the console
        System.out.println("Total money earned by college: $" + college.getTotalMoneyEarned());
        System.out.println("-----");
        System.out.println("College paid salary to teachers: $" + college.getTotalMoneySpent());
        System.out.println("-----");
        System.out.println("Total money left by college: $" + college.getTotalMoneyEarned());

        // Creating an instance of CMSGUI and passing the college object
        new CMSGUI(college);
    }
}
