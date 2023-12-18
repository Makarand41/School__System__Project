import java.util.ArrayList;

public class Courses {
    private String courseName;
    private String professorName;
    private int year;
    private ArrayList<Student> enrolledStudents;

    public Courses(String courseName, String professorName, int year) {
        this.courseName = courseName;
        this.professorName = professorName;
        this.year = year;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }




    public void enroll(Student student) {
        enrolledStudents.add(student);
    }

    public void unEnroll(Student student) {
        enrolledStudents.remove(student);
    }

    public int countStudents() {
        return enrolledStudents.size();
    }

    public int bestGrade() {
        int maxGrade = enrolledStudents.get(0).getGrade();
        for (int i = 1; i < enrolledStudents.size(); i++) {
            int currentGrade = enrolledStudents.get(i).getGrade();
            maxGrade = Math.max(maxGrade, currentGrade);
        }

        return maxGrade;
    }


    public double averageGrade()
    {
        int totalGrades = 0;
        for (int i = 0; i < enrolledStudents.size(); i++) {
            Student student = enrolledStudents.get(i);
            totalGrades += student.getGrade();
        }

        return (double) totalGrades / enrolledStudents.size();
    }


    public void printStudentRanking() {
        int n = enrolledStudents.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Student student1 = enrolledStudents.get(j);
                Student student2 = enrolledStudents.get(j + 1);

                if (student1.getGrade() < student2.getGrade()) {
                    enrolledStudents.set(j, student2);
                    enrolledStudents.set(j + 1, student1);
                }
            }
        }

        System.out.println("Student Ranking:");
        for (int i = 0; i < enrolledStudents.size(); i++) {
            Student student = enrolledStudents.get(i);
            System.out.println((i + 1) + ". " + student.getFirstName() + " " + student.getLastName() + " - Grade: " + student.getGrade());
        }
    }

    public void showAboveAverage() {
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled in the course.");
            return;
        }

        
        double averageGrade = averageGrade();

        System.out.println("Students and Their Performance relative to Course Average:");
        for (int i = 0; i < enrolledStudents.size(); i++) {
            Student student = enrolledStudents.get(i);
            String aboveOrBelow = (student.getGrade() > averageGrade) ? "Above" : "Below";
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - Grade: " + student.getGrade() + " - " + aboveOrBelow + " Course Average");
        }
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }



}
