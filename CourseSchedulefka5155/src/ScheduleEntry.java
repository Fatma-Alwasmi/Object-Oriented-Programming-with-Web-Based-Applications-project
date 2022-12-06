/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fatmaal-wasmi
 */
public class ScheduleEntry {
    String Semester;
    String CourseCode;
    String StudentID;
    String Status;
    //timestamp?

    public String getSemester() {
        return Semester;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public String getStudentID() {
        return StudentID;
    }
    
    public String getSatus() {
        return Status;
    }

    public ScheduleEntry(String Semester, String CourseCode, String StudentID, String Status) {
        this.Semester = Semester;
        this.CourseCode = CourseCode;
        this.StudentID = StudentID;
        this.Status = Status;
    }

    
    
}
