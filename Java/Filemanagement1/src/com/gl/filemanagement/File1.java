package  com.gl.filemanagement;

import  java.io.File;
import java.io.IOException;

public class File1 {
    public static void main(String[] args) {

        try{
        // i want  a file called "cricket.txt"
        //this line , creates only object , no mactual files
        File myFile =new File("cricket.txt");
        //actul file getting created
        myFile.createNewFile();// required a catch?

        /*
         * Space may not be sufficicent to create more file
         * permission problems (Linux)
         * 
         */
        if(myFile.exists()){
            System.out.println("File is Created");
        }else {
            System.out.println("File does not exist");
            myFile.createNewFile();
        }
        // Check if the file exists
            if (myFile.exists()) {
                System.out.println("File exists at: " + myFile.getAbsolutePath());
            } else {
                System.out.println(" File not found.");
            }

        }
        catch(IOException ex){

            System.out.println("Some problem in file creation" + ex.getMessage());
        }
       

            
        


        
    }

}
