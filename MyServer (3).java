package hospital_project;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main (String args[]){
    try{
      ServerSocket s = new ServerSocket(8000);  //8000 is the port number 
      Socket socket ; 
      // (multi threading)
    while(true){
        socket = s.accept() ; //accepting clients 
        new Thread(new Handler(socket)).start();
        System.out.println("Num of Threads "+Thread.activeCount());  //calcaulating the number of threads and printing it
      
      }
   }
      catch(IOException e){
          System.out.println(e.getMessage());
      
        }
    }
    
}
