package CollegeManagementSystem;

/**
 * Represents a teacher in the college management system.
 */
public class Teacher {

    private int id; // Encapsulation: Using private access modifier to encapsulate the teacher's ID.
    private String name; // Encapsulation: Using private access modifier to encapsulate the teacher's name.
    private int salary; // Encapsulation: Using private access modifier to encapsulate the teacher's salary.
    private int salaryEarned; // Encapsulation: Using private access modifier to encapsulate the salary earned by the teacher.

    /**
     * Creates a new Teacher object.
     * The teacher's ID.
     * The teacher's name.
     * The teacher's salary.
     */
    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.salaryEarned = 0;
    }

    /**
     * Retrieves the teacher's ID.
     * @return The teacher's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the teacher's name.
     * @return The teacher's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the teacher's salary.
     * @return The teacher's salary.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Sets the teacher's salary.
     * The teacher's new salary.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Adds the salary to the total salary earned by the teacher.
     * The salary to be added.
     */
    public void receiveSalary(int salary) {
        salaryEarned += salary;
    }

    @Override
    public String toString() {
        return "Name of the Teacher: " + name + " | Total salary earned so far: $" + salaryEarned;
    }
}
