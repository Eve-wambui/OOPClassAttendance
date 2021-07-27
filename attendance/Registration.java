package attendance;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;

public class Registration {
    private static ArrayList<String> serializationNumbers = new ArrayList<>();
    private static ArrayList<String> classCodes = new ArrayList<>();
    private static ArrayList<Integer> years = new ArrayList<>();
    private static ArrayList<String> names = new ArrayList<>();

    public Registration() {
    }

    //adding the students class code
    public void setClassCode() {
        System.out.println("Enter class code");
        Scanner classCodeObj = new Scanner(System.in);
        String classCode = classCodeObj.nextLine();
        if (!(classCode.equalsIgnoreCase("SCCJ")) && !(classCode.equalsIgnoreCase("SCCI"))) {
            System.out.println("invalid");
            setClassCode();
        } else {
            classCodes.add(classCode);
        }
    }


    //adding students serial number
    public void setSerial() {
        Scanner serializationCodeObj = new Scanner(System.in);
        System.out.println("Enter serialization");
        String serialization = serializationCodeObj.nextLine();
        if (serialization.length() != 5) {
            System.out.println("Invalid serialization code");
            setSerial();
        } else {
            if (serializationNumbers.contains(serialization)) {
                System.out.println("The serilaization number entered already exists");
                setSerial();
            } else {
                serializationNumbers.add(serialization);
            }
        }
    }

    //Setting the year student enrolled in the university
    public void setYear() {
        Scanner yearObj = new Scanner(System.in);
        System.out.println("Enter year");
        int year = yearObj.nextInt();
        if (year < 2013 || year > 2020) {
            System.out.println("Invalid year");
            setYear();
        } else {
            years.add(year);
        }
    }

    //Entering the student name
    public void setName() {
        Scanner nameObj = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = nameObj.nextLine();
        if (name.length() == 0) {
            System.out.println("Invalid name");
            setName();
        } else {
            names.add(name);
        }
    }

    //Displaying the student details
    public void displayStudentDetails() {
        for (int i = 0; i < years.size(); i++) {
            System.out.println();
            System.out.println("Class code of student " + (i + 1) + " is " + classCodes.get(i));
            System.out.println("Serialization of student " + (i + 1) + " is " + serializationNumbers.get(i));
            System.out.println("Year of student " + (i + 1) + " is " + years.get(i));
        }

    }

    //Registering students
    public ArrayList<Student> registerStudents() {
        for (int i = 0; i < 1; i++) {
            System.out.println("Register student " + (i + 1));
            setName();
            setClassCode();
            setSerial();
            setYear();
            System.out.println();
        }
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < serializationNumbers.size(); i++) {
            String regNo = classCodes.get(i) + "/" + serializationNumbers.get(i) + "/" + years.get(i);
            String name = names.get(i);
            Student student = new Student();
            student.setRegNo(regNo);
            student.setName(name);
            students.add(student);
            StudentFiles files = new StudentFiles();
            files.addStudentToFile(student, "RegisteredStudents.txt");
        }
        return students;
    }

}
