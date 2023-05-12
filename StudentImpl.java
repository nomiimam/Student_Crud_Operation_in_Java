
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EmptyStackException;

public class StudentImpl implements StudentInterface {
    Connection con;

    @Override
    public void createStudent(Student std) {
        con = DBConnection.createDBConnection();
        String query = "insert into student values(?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, std.getId());
            pstm.setString(2, std.getName());
            pstm.setDouble(3, std.getGrade());
            pstm.setInt(4, std.getAge());
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Inserted Successfully !!!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void showStudent() {
        con = DBConnection.createDBConnection();
        String query = "select * from student";
        System.out.println("~`~`~`~`~  Student Details  ~`~`~`~`~");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Grade", "Age");
        System.out.println("---------------------------------------------");
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void showStudentBasedOnId(int id) {
        con = DBConnection.createDBConnection();
        String query = "select * from student where id=" + id;
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void updateStudent(int id, String name) {

        con = DBConnection.createDBConnection();
        String query = "update student set name=? where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setInt(2, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Student Details updated successfully !!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        con = DBConnection.createDBConnection();
        String query = "delete from student where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Student Deleted Successfully!!! " + id);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
