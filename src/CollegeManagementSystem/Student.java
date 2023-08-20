package CollegeManagementSystem;

/**
 * This class is responsible for keeping the track
 * of students fees, name, grade & fees paid.
 */
public class Student {

    private int id; // Encapsulation: Using private access modifier to encapsulate the student's ID.
    private String name; // Encapsulation: Using private access modifier to encapsulate the student's name.
    private int grade; // Encapsulation: Using private access modifier to encapsulate the student's grade.
    private int feesPaid; // Encapsulation: Using private access modifier to encapsulate the fees paid by the student.
    private int feesTotal; // Encapsulation: Using private access modifier to encapsulate the total fees of the student.

    private College college; // Composition: Has-a relationship with the College class.

    /**
     * Creates a new student object.
     * The ID for the student.
     * The name of the student.
     * The grade of the student.
     * The college associated with the student.
     */
    public Student(int id, String name, int grade, College college) {
        this.feesPaid = 0;
        this.feesTotal = 30000;
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.college = college;
    }

    // Not going to alter student's name or student's ID.

    /**
     * Used to update the student's grade.
     * The new grade of the student.
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Keep adding the fees to feesPaid field.
     * Add the fees to the fees paid.
     * The college is going to receive the funds.
     * The fees that the student pays.
     */
    public void payFees(int fees) {
        feesPaid += fees;
        college.updateTotalMoneyEarned(feesPaid);

        CMSGUI gui = new CMSGUI(college); // Composition: Creates an instance of the CMSGUI class.
        gui.displayCollegeInformation(); // Polymorphism: Calls the displayCollegeInformation() method on the GUI instance.
    }

    /**
     * @return The ID of the student.
     */
    public int getId() {
        return id;
    }

    /**
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The grade of the student.
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @return The fees paid by the student.
     */
    public int getFeesPaid() {
        return feesPaid;
    }

    /**
     * @return The total fees of the student.
     */
    public int getFeesTotal() {
        return feesTotal;
    }

    /**
     * @return The remaining fees.
     */
    public int getRemainingFees() {
        return feesTotal - feesPaid;
    }

    @Override
    public String toString() {
        return "Student's name: " + name + ", Total fees paid so far: $" + feesPaid;
    }
}

