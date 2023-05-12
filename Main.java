
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentImpl stdObj = new StudentImpl();
        String name;
        int id;

        System.out.println("Welcome to Student Management App");
        do {
            System.out.println("1. Add Student\n" +
                    "2. Show All Student\n" +
                    "3. Show Student based on id \n" +
                    "4. Update the Student\n" +
                    "5. Delete the Student\n" +
                    "6. Exit");

            System.out.println("Enter Choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Student std = new Student();
                    System.out.println("Enter ID : ");
                    id = sc.nextInt();
                    System.out.println("Enter name ");
                    name = sc.next();
                    System.out.println("Enter Grade ");
                    double grade = sc.nextDouble();
                    System.out.println("Enter age");
                    int age = sc.nextInt();
                    std.setId(id);
                    std.setName(name);
                    std.setGrade(grade);
                    std.setAge(age);
                    stdObj.createStudent(std);
                    break;
                case 2:
                    stdObj.showStudent();
                    break;
                case 3:
                    System.out.println("Enter id to show the details ");
                    int stdId = sc.nextInt();
                    stdObj.showStudentBasedOnId(stdId);
                    break;
                case 4:
                    System.out.println("Enter id to update the details");
                    int empid1 = sc.nextInt();
                    System.out.println("Enter the new name");
                    name = sc.next();
                    stdObj.updateStudent(empid1, name);
                    break;
                case 5:
                    System.out.println("Enter the id to delete");
                    id = sc.nextInt();
                    stdObj.deleteStudent(id);
                    break;
                case 6:
                    System.out.println("Thank you for using our app.");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice!");
                    break;
            }
        } while (true);
    }
}