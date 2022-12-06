
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
public class ScheduleQueries {
      private static Connection connection;
     private static ResultSet resultSet;
     private static PreparedStatement addScheduleEntry;
     private static PreparedStatement getScheduleByStudent;
     private static PreparedStatement getScheduledStudentCount;
     private static int studentCount;
  
     public void addScheduleEntry(ScheduleEntry entry){ //adminTab-->addCourseTab-->subbmitButton
          connection = DBconnection.getConnection();
        try
        {
            addScheduleEntry = connection.prepareStatement("insert into app.StudentEntry (StidentID, FirstName, LastName) values (?,?,?)");
            addScheduleEntry.setString(1,entry.getSemester());
            addScheduleEntry.setString(2, entry.getCourseCode());
            addScheduleEntry.setString(3,entry.getStudentID());
            
            addScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
     }
    
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID) //studentTab-->DisplaySchedule-->displayButton
    {
        connection = DBconnection.getConnection();
        ArrayList<ScheduleEntry> Schedule = new ArrayList<ScheduleEntry>();
        try
        {
            getScheduleByStudent = connection.prepareStatement("select Semester, CourseCode, StudentID,Status from app.SheduleEntry where semester = ? and studentID = ?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, studentID);
            resultSet = getScheduleByStudent.executeQuery();
            
            while(resultSet.next())
            {
                ScheduleEntry entry = new ScheduleEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                Schedule.add(entry);
                

            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return Schedule;
   }
    
    public static int getScheduledStudentCount(String currentSemester, String CourseCode){ //whre is this used in gui 
//is there a reason why there was no identifier in the parameters in the layout?
            int count=0;
            connection = DBconnection.getConnection();
            
        try{
            getScheduledStudentCount = connection.prepareStatement("Select Count(StudentID) from app.Schedule where Semester = ? and where CourseCode = ?"); //???
            getScheduledStudentCount.setString(1, currentSemester);
            getScheduledStudentCount.setString(2, CourseCode);
            
            
            resultSet = getScheduledStudentCount.executeQuery(); 
            
            while(resultSet.next()){
               count = resultSet.getInt(1);  
                 
            }
            
          }
        catch(SQLException sqlException)
            {
            sqlException.printStackTrace();
        }
        return count;
        }
}
