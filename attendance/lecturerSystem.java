package attendance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.jar.Attributes.Name;

import javax.xml.validation.ValidatorHandler;


public class lecturerSystem {
    
    String passFileName="Lecturer.txt";

    boolean checkLecturer(String name, String email){
        
        if (validate(name,email)){
        System.out.println("was Found");
        return true;
        }
        else {
            System.out.println("was NOT Found");
            return false;
        }
    }

        boolean validate(String name, String email) {
            boolean tempValidation = false;
            BufferedReader fileReader;
            try{
                fileReader = new BufferedReader(new FileReader(passFileName));
                String oneLine = fileReader.readLine();
                while (oneLine !=null){
                    String tmpname = oneLine.substring(0,oneLine.indexOf(" "));
                    String tmpemail = oneLine.substring(oneLine.indexOf(" ")+1);
                    if ((tmpname.equals(name)) && (tmpemail.equals(email)))
                        tempValidation = true;
                    //System.out.println(tmpCode);
                    //System.out.println(tmpTitle);
                    oneLine = fileReader.readLine();
                }    

            } catch (IOException ioe){
                ioe.printStackTrace();
                }
               return tempValidation;      
             }
               
         void createLecturerFile(String name,String email){
                 //create bytes to write to file
                 String oneLine = name +" "+email+"\n";
                 byte data[] = oneLine.getBytes();
                 try{
                     File LecturerFile = new File(passFileName);
                     if (!LecturerFile.exists()){
                             OutputStream outPassFile = new FileOutputStream(passFileName);
                             outPassFile.write(data,0,data.length);
                     }else{
                         OutputStream outPassFile = new FileOutputStream(passFileName,true);
                          outPassFile.write(data,0,data.length);
                     }
                 }catch(IOException e) {
                  System.out.print("Exception: " +e.getMessage());
                 
                 }
             
             }





























}
