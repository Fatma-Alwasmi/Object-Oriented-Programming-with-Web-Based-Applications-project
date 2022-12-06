
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
public class CourseQueries {
     private static Connection connection;
     private static ResultSet resultSet;
     private static PreparedStatement getAllCourses;
     private static PreparedStatement addCourse;
     private static PreparedStatement getAllCourseCodes;
     private static PreparedStatement getCourseSeats;
     private static int seats;
     
     
     
    public static ArrayList<CourseEntry> getAllCourses(String semester) //studentTab-->displayCourseTab-->DisplayButton
    {
         connection = DBconnection.getConnection();
         ArrayList<CourseEntry> courses = new ArrayList<CourseEntry>();
         try
         {
             getAllCourses = connection.prepareStatement("select Semester, courseCode, Description, Seats from  app.CourseEntry");
                resultSet = getAllCourses.executeQuery();
            
            while(resultSet.next())
            {
                CourseEntry entry = new CourseEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                courses.add(entry);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courses;
         }
    
        public static void addCourse(CourseEntry course) //adminTab-->addCourseTab-->subbmitButton
    {
        connection = DBconnection.getConnection();
        try
        {
            addCourse = connection.prepareStatement("insert into app.CourseEntry (Semester, CourseCode, Description, Seats) values (?,?,?,?)");
            addCourse.setString(1, course.getSemester());
            addCourse.setString(2, course.getCourseCode());
            addCourse.setString(3, course.getDescription());
            addCourse.setString(4, String.valueOf(course.getSeats()));
            addCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
        public static ArrayList<String> getAllCourseCodes(String semester)  //studentTab-->displayCouseTab-->displayButton
    {
         connection = DBconnection.getConnection();
         ArrayList<String> CourseCode = new ArrayList<String>();
         try
         {
             getAllCourseCodes = connection.prepareStatement("select CourseCode from  app.CourseEntry where Semester = ?"); //prepareStatement?
                 
                getAllCourseCodes.setString(1, semester);
                resultSet = getAllCourseCodes.executeQuery();
                

            
             while(resultSet.next())
            {
                CourseCode.add(resultSet.getString(1));
            }
        }
            catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
            return CourseCode;
         }
        
        
        
        
        public static int getCourseSeats(String semester, String courseCode) { //where is this used in gui?
        //method done properly?
        //studentTab-->scheduleCourse-->addCourse
        try{
            connection = DBconnection.getConnection();
            getCourseSeats = connection.prepareStatement("Select Seats from app.CourseEntry where Semester = ? and courseCode = ?");

           getCourseSeats.setString(1, semester);
           getCourseSeats.setString(1, courseCode);
            resultSet = getCourseSeats.executeQuery(); 
           
            
            while(resultSet.next()){
                 seats = resultSet.getInt(1);
            }
          }
        catch(SQLException sqlException)
            {
            sqlException.printStackTrace();
        }
        return seats;
        }
    }
        

