
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fatmaal-wasmi
 */
public class StudentQueries {
    private static Connection connection;
    private static PreparedStatement addStudent;
    private static PreparedStatement getAllStudents;
    private static ResultSet resultSet;
    
    public static void addStudent(StudentEntry student) //adminTab-->addStudent-->subbmitButton
    {
        connection = DBconnection.getConnection();
        try
        {
            addStudent = connection.prepareStatement("insert into app.StudentEntry (StidentID, FirstName, LastName) values (?,?,?)");
            addStudent.setString(1, student.getStudentID());//getter method of these values
            addStudent.setString(2, student.getFirstName());
            addStudent.setString(3, student.getLastName());
            addStudent.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
public static ArrayList<StudentEntry> getAllStudents() //studentTab-->displayScheduleTab-->selectStudentComboBox
        
    {
         connection = DBconnection.getConnection();
         ArrayList<StudentEntry> students = new ArrayList<StudentEntry>();
         try
         {
             getAllStudents = connection.prepareStatement("select StidentID, FirstName, LastName from  app.StudentEntry");
             
             
             
             
             resultSet = getAllStudents.executeQuery();
        
            while(resultSet.next())
                {
                    
                    StudentEntry entry = new StudentEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                    students.add(entry);
                    
                }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
            return students;
        }
       
}















