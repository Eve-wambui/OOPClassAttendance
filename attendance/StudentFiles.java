package attendance;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StudentFiles {

    public StudentFiles() {
    }

    public void addStudentToFile(Student student, String filename) {
        String oneLine = student.getName() + " " + student.getRegNo() + "\n";
        byte data[] = (oneLine).getBytes();
        try {
            java.io.File UnitFile = new java.io.File(filename);
            OutputStream outPassFile = new FileOutputStream(filename, (UnitFile.exists()));
            outPassFile.write(data, 0, data.length);

        } catch (IOException e) {
            System.out.print("Exception: " + e.getMessage());

        }
    }
}
