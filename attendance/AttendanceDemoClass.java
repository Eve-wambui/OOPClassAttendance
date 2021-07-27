package attendance;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class AttendanceDemoClass {
    private static Scanner scanner = new Scanner(System.in);
    private static Lecturer lecturer  = new Lecturer();;
    private static ClassRoom classRoom = new ClassRoom();;
    private static Course course = new Course();
    public static void main(String args[]){
        System.out.println("Select an option below\n1. New registration\n2. Mark Attendance");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1: {
                lecturerRegistration();
                classRegistration();
                registerCourse();
                registerStudents();
                markAttendance();
                break;
            }
            case 2: {
                getRegisteredStudents();
                markAttendance();
                break;
            }
            default: {
                System.out.println("Wrong option");
            }
        }
    }

    private static void getRegisteredStudents(){
        File file = new File("RegisteredStudents.txt");
        try{
            Scanner sc = new Scanner(file) ;
            ArrayList<Student> registeredStudents = new ArrayList<>();
            while (sc.hasNextLine()){
                String text = sc.nextLine();
                String[] studentData = text.split( " ");
                Student student = new Student();
                student.setName(studentData[0]);
                student.setRegNo(studentData[1]);
                registeredStudents.add(student);
            }
            classRoom.setStudents(registeredStudents);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (classRoom.getStudents().isEmpty()){
            System.out.println("No registered students");
        }
    }
   
    //Registering a Lecturer
    private static void lecturerRegistration(){
        System.out.println("Please register yourself as a lecturer");
        System.out.println("Enter staff id : ");
        String staffId = scanner.nextLine();
        System.out.println("Enter Name : ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number : ");
        String phone = scanner.nextLine();
        System.out.println("Enter email : ");
        String email = scanner.nextLine();
        lecturer.setStaffId(staffId);
        lecturer.setName(name);
        lecturer.setPhoneNo(phone);
        lecturer.setEmail(email);
        System.out.println();
        System.out.println("Lecturer successfully registered (name: "+name+", email: "+email+" phone: "+phone+")");
        System.out.println();
    }

    //Class Registration
    private static void classRegistration(){
        try {
            System.out.println("Please Register a class");
            System.out.println("Enter class code: ");
            String classCode = scanner.nextLine();
            System.out.println("Enter current year of study (Int expexted): ");
            int currentYear = scanner.nextInt();
            System.out.println("Enter current semester (Int expexted): ");
            int currentSemester = scanner.nextInt();
            classRoom.setClassCode(classCode);
            classRoom.setCurrentYear(currentYear);
            classRoom.setCurrentSemester(currentSemester);
            System.out.println();
            System.out.println("Class successfully registered (code: "+classCode+", current yr: "+currentYear+" current sem: "+currentSemester+")");
            System.out.println();
        } catch (Exception e) {
            System.out.println();
            System.out.println("*****Wrong input******");
            System.out.println();
            classRegistration();
        }
    }


    // Registering Students
    private static void registerStudents(){
        System.out.println("Let atleast two students register for the class");
        Registration registration = new Registration();
        ArrayList<Student> students = registration.registerStudents();
        classRoom.setStudents(students);
        System.out.println();
        System.out.println("Students successfully added to classroom");
        System.out.println();
    }


    //Registering a Course
    private static void registerCourse(){
       /* System.out.println("Please register atleast one course for the class");
        System.out.println("Enter Unit code: ");
        scanner = new Scanner(System.in);
        String unitCode = scanner.nextLine();
        System.out.println("Enter unit title: ");
        String unitTitle = scanner.nextLine();

       course.setLecturer(lecturer);
        course.setUnitCode(unitCode);
        course.setUnitTitle(unitTitle);*/
        
        Course newCourse = new Course();
        Course.addNewCourse();

        System.out.println();
        System.out.println("Unit successfully added to classroom "+classRoom.getClassCode()+ " and assigned to lecturer "+lecturer.name);
        System.out.println();
    }


    //Marking attendance

    private static void markAttendance(){
        System.out.println("You can now mark your attendance");
        System.out.println("SELECT STUDENT FROM OPTIONS");
        try {
            ArrayList<Student> students = classRoom.getStudents();
            for(int i = 0; i < students.size(); i++){
                Student student = students.get(i);
                System.out.println((i+1)+": "+student.getName()+"(reg no: "+student.getRegNo()+")");
            }
            int selection = scanner.nextInt();
            Student selectedStudent = students.get((selection-1));
            StudentFiles file = new StudentFiles();
            file.addStudentToFile(selectedStudent, "Attendance.txt");
            System.out.println();
            System.out.println("######ATTENDANCE MARKED FOR "+selectedStudent.getName()+"(reg no: "+selectedStudent.getRegNo()+")########");
        } catch (Exception e) {
            System.out.println("*******Wrong input******");
        }
    }
}
