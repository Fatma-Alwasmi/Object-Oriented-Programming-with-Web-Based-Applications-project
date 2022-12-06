
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
public class SemesterQueries {
    private static Connection connection;
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addSemester;
    private static PreparedStatement getSemesterList;
    private static ResultSet resultSet;
    
    public static void addSemester(String name) //gui--> adminTab--> SubmitButton
    {
        connection = DBconnection.getConnection();
        try
        {
            addSemester = connection.prepareStatement("insert into app.semester (name) values (?)");
            addSemester.setString(1, name);
            addSemester.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<String> getSemesterList()// gui --> changeSemesterComboBox
    {
        connection = DBconnection.getConnection();
        ArrayList<String> semester = new ArrayList<String>();
        try
        {
            getSemesterList = connection.prepareStatement("select name from app.semester order by name");
            resultSet = getSemesterList.executeQuery();
            
            while(resultSet.next())
            {
                semester.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return semester;
   }
}
