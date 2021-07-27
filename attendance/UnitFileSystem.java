package attendance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.validation.ValidatorHandler;

public class UnitFileSystem {
    String passFileName="Unit.txt";

    boolean checkUnit(String unitCode, String unitTitle){
        
        if (validate(unitCode,unitTitle)){
        System.out.println("was Found");
        return true;
        }
        else {
            System.out.println("was NOT Found");
            return false;
        }
    }

        boolean validate(String unitCode, String unitTitle) {
            boolean tempValidation = false;
            BufferedReader fileReader;
            try{
                fileReader = new BufferedReader(new FileReader(passFileName));
                String oneLine = fileReader.readLine();
                while (oneLine !=null){
                    String tmpCode = oneLine.substring(0,oneLine.indexOf(" "));
                    String tmpTitle = oneLine.substring(oneLine.indexOf(" ")+1);
                    if ((tmpCode.equals(unitCode)) && (tmpTitle.equals(unitTitle)))
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
               
             void createUnitFile(String unitCode,String unitTitle){
                 //create bytes to write to file
                 String oneLine = unitCode+" "+unitTitle+"\n";
                 byte data[] = oneLine.getBytes();
                 try{
                     File UnitFile = new File(passFileName);
                     if (!UnitFile.exists()){
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




    

