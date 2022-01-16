package hospital_project;
import java.io.*; 
public class store {
  public void store (String value){
    //storing data in file 
    try{                                                            
    BufferedWriter bw = new BufferedWriter(new FileWriter ("C:\\Users\\K i n G\\Desktop\\test\\output.txt",true));  //file directory through which we store user's info 
    bw.write(value);
    bw.close();
    }
catch(IOException ex){
System.out.println("file not found ");
  }
 }
}
