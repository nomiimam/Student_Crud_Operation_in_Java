
public interface StudentInterface {
    // create student
    public void createStudent(Student std);

    // show student
    public void showStudent();

    // show student based on id
    public void showStudentBasedOnId(int id);

    // update student
    public void updateStudent(int id, String name);

    // delete student
    public void deleteStudent(int id);
}
