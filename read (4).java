package hospital_project;
import java.io.*;  
public class read { 
    //reading data from file
    public read() { 
       try{                                                            
         BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\K i n G\\Desktop\\test\\output.txt"));   //file directory through which we read user's info 
         String s ; 
         while((s=read.readLine()) != null){
         System.out.println(s);
         }
        read.close();
       }
     catch(IOException ex){
       System.out.println(ex.getMessage());
    }    
  }  
}  
