import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Courses course = new Courses("Java Programming", "Prof. Johnson", 2023);

        int choice = 0;

        while (choice !=8 ) {
            System.out.println("-----------------------Welcome to School System Project-----------------------");
            System.out.println("Menu:");
            System.out.println("1. Enroll a student");
            System.out.println("2. Unenroll a student");
            System.out.println("3. Count of total students ");
            System.out.println("4. List of students");
            System.out.println("5. Best grade of the student");
            System.out.println("6. Students ranking");
            System.out.println("7. Students above average");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Enroll a student
                    System.out.print("Enter student's first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter student's last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter student's grade: ");
                    int grade = scanner.nextInt();
                    System.out.print("Enter student's year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter student's registration number: ");
                    int registrationNumber = scanner.nextInt();

                    Student newStudent = new Student(firstName, lastName, registrationNumber, grade, year);
                    course.enroll(newStudent);
                    System.out.println("Student enrolled successfully.");
                    System.out.println("Enrolled Student Details:");
                    System.out.println("Name: " + newStudent.getFirstName() + " " + newStudent.getLastName());
                    System.out.println("Registration Number: " + newStudent.getRegistration());
                    System.out.println("Grade: " + newStudent.getGrade());
                    System.out.println("Year: " + newStudent.getYear());
                    break;

                case 2:
                    // Unenroll a student
                    System.out.print("Enter the registration number of the student to unenroll: ");
                    registrationNumber = scanner.nextInt();
                    course.unEnroll(new Student("", "", registrationNumber)); // Create a dummy student for unenrolling
                    System.out.println("Student unenrolled successfully.");
                    break;

                case 3:
                    if (course.countStudents()==0)
                    {
                        System.out.print("The number of students are : ");
                        System.out.print("0");
                        System.out.println(" ");
                    }
                    else {
                        System.out.print("The number of students are : ");
                        course.countStudents();
                        System.out.println(" ");

                    }
                    break;






                case 4:
                    System.out.println("List of Enrolled Students:");
                    for (int i = 0; i < course.countStudents(); i++) {
                        Student student = course.getEnrolledStudents().get(i);
                        System.out.println("Student " + (i + 1) + ":");
                        System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
                        System.out.println("Registration Number: " + student.getRegistration());
                        System.out.println("Grade: " + student.getGrade());
                        System.out.println("Year: " + student.getYear());
                        System.out.println("---------------------");
                    }
                    break;
                case 5:
                    System.out.println("Best grade in the course after enrolling a list: " + course.bestGrade());
                    break;





                case 6:
                    course.printStudentRanking();
                    break;

                case 7:
                    System.out.println("Average grade in the course: " + course.averageGrade());
                    course.showAboveAverage();


                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    break;


                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}
