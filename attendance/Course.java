package attendance;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private static  String unitCode;
    private static String unitTitle;
    private Lecturer lecturer;
    private ArrayList<Session> attendedSessions = new ArrayList<>();
    
   /* public String getUnitCode() {
        return unitCode;
    }
    
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }
    
    public String getUnitTitle() {
        return unitTitle;
    }
    
    public void setUnitTitle(String unitTitle) {
        this.unitTitle = unitTitle; 
    } 
    
    public Lecturer getLecturer() {
        return lecturer;
    }
    
    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    } */

    public static void addNewCourse() {
        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Enter unitCode to Register:");
        String unitCode = keyBoard.next();
        System.out.println("Enter unitTitle for User: ");
        String unitTitle = keyBoard.next();
        UnitFileSystem Unit = new UnitFileSystem();
        Unit.createUnitFile(unitTitle, unitCode);
    }
    
    public ArrayList<Session> getAttendedSessions() {
        return attendedSessions;
    }

    public void addAttendedSession(Session attendedSession) {
        this.attendedSessions.add(attendedSession);
    }

}
