package hospital_project;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class myClient  implements Runnable { //class contain the set on action of all gui
    Button btn,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn20,btn21,btn22,btn23,btn24,btn25,btn26,btn27,btn28,
            btn29,btn30,btn31,btn32,btn33,btn34,btn35,btn36,btn37,btn38,btn39,btn40,btn41,btn42,btn43,btn44,btn45,btn46,btn47,btn48,btn50,btn51,btn52,btn53; 
    TextField d,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d20,d21,d22,d23,d24,d25,d26,d27,d28,d29,d30,d31,d32,d33,d34,d35,d36,d37,d38,d39,d40,d41,d42,
    d43,d44,d45,d46,d47,d48,d49,d50,d51,d52,d53,d54,d55,forsalary; 
    String  Hospital ;
    Stage primaryStage ;
    Scene root2,root3,root4,root5,root6,root7,root8,root9,root10,root11,root12,root13,root14,root15,root16,root17,root18,root19,root20,root21,root22; 
    Nurse nurse[] = new Nurse[3];    
    Department  department[] = new Department[3]; 
    public myClient() {
     super();
	}
     public myClient(Button btn,Button btn2 ,Button btn3,Button btn4,Button btn5 ,Button btn6,Button btn7,Button btn8,Button btn9,Button btn10,Button btn11,Button btn12,
              Button btn13,Button btn14,Button btn15,Button btn16,Button btn17,Button btn18,Button btn20,Button btn21,Button btn22,Button btn23,Button btn24,Button  btn25
             ,Button  btn26,Button  btn27,Button  btn28,Button  btn29,Button  btn30,Button  btn31,Button  btn32,Button  btn33,Button btn34,Button btn35,Button btn36,
              Button btn37,Button btn38,Button btn39,Button btn40,Button btn41,Button  btn42,Button  btn43,Button  btn44,Button  btn45,Button  btn46,Button  btn47,
              Button  btn48,Button  btn50,Button btn51 , Button btn52,Button btn53
               ,TextField d,TextField d2,TextField d3,TextField d4,TextField d5,TextField d6,TextField d7,TextField d8,TextField d9,TextField d10,TextField d11,TextField d12,
                TextField d13,TextField d14,TextField d15,TextField d16 ,TextField d20,TextField d21, TextField d22,TextField d23,TextField d24,TextField d25,TextField d26,
                TextField d27,TextField d28,TextField d29,TextField d30,TextField d31,TextField d32,TextField d33,TextField d34,TextField d35,TextField d36,TextField d37,
                TextField d38,TextField d39,TextField d40,TextField d41,TextField d42,TextField d43,TextField d44,TextField d45,TextField d46,TextField d47,TextField d48,
                TextField d49,TextField d50,TextField d51,TextField d52,TextField d53,TextField d54,TextField d55,TextField forsalary,Stage primaryStage,Scene root2
                ,Scene root3,Scene root4,Scene root5,Scene root6,Scene root7,Scene root8,Scene root9,Scene root10,Scene root11,Scene root12,Scene root13,Scene root14,
                Scene root15,Scene root16,Scene root17,Scene root18,Scene root19,Scene root20,Scene root21,Scene root22)
              {
	super();
	this.d  =d ;
                this.d2  =d2 ;
                this.d3  =d3 ;
                this.d4  =d4 ;
                this.d5 =d5 ;
                this.d6  =d6 ;
                this.d7  =d7;
                this.d8 =d8 ;
                this.d9  =d9 ;
                this.d10  =d10;
                this.d11  =d11;
                this.d12  =d12;
                this.d13  =d13;
                this.d14  =d14;
                this.d15 =d15;
                this.d16  =d16;
                this.d20  =d20;
                this.d21  =d21;
                this.d22  =d22;
                this.d23  =d23;
                this.d24  =d24;
                this.d25  =d25;
                this.d26  =d26;
                this.d27  =d27;
                this.d28  =d28;
                this.d29  =d29;
                this.d30 =d30;
                this.d31=d31;
                this.d32=d32;
                this.d33=d33;
                this.d34=d34;
                this.d35=d35;
                this.d36=d36;
                this.d37=d37;
                this.d38=d38;
                this.d39=d39;
                this.d40=d40;
                this.d41=d41;
                this.d42=d42;
                this.d43=d43;
                this.d44=d44;
                this.d45=d45;
                this.d46=d46;
                this.d47=d47;
                this.d48=d48;
                this.d49=d49;
                this.d50=d50;
                this.d51=d51;
                this.d52=d52;
                this.d53 = d53; 
                this.d54=d54;
                this.d55 = d55; 
                this.forsalary  =forsalary;
                this.btn = btn ; 
                this.btn2 = btn2 ; 
                this.btn3 = btn3;
                this.btn4 = btn4;
                this.btn5 = btn5;
                this.btn6 = btn6;
                this.btn7 = btn7;
                this.btn8 = btn8;
                this.btn9 = btn9;
                this.btn10 = btn10;
                this.btn11 = btn11;
                this.btn12 = btn12;
                this.btn13 = btn13;
                this.btn14 = btn14;
                this.btn15 = btn15;
                this.btn16 = btn16;
                this.btn17 = btn17;
                this.btn18 = btn18;
                this.btn20 = btn20;
                this.btn21 = btn21;
                this.btn22 = btn22;
                this.btn23 = btn23;
                this.btn24 = btn24;
                this.btn25= btn25;
                this.btn26 = btn26;
                this.btn27 = btn27;
                this.btn28 = btn28;
                this.btn29 = btn29;
                this.btn30 = btn30;
                this.btn31 = btn31;
                this.btn32 = btn32;
                this.btn33 = btn33;
                this.btn34 = btn34; 
                this.btn35 = btn35;
                this.btn36 = btn36;
                this.btn37= btn37;
                this.btn38= btn38;
                this.btn39= btn39;
                this.btn40= btn40;
                this.btn41= btn41;
                this.btn42= btn42;
                this.btn43= btn43;
                this.btn44= btn44;
                this.btn45= btn45;
                this.btn46= btn46;
                this.btn47= btn47;
                this.btn48= btn48;
                this.btn50= btn50;
                this.btn51= btn51;
                this.btn52= btn52;
                this.btn53= btn53;
                this.primaryStage = primaryStage ;  
                this.root2 = root2 ; 
                this.root3= root3 ; 
                this.root4= root4; 
                this.root5= root5; 
                this.root6= root6;
                this.root7= root7;
                this.root8= root8;
                this.root9 = root9 ; 
                this.root10= root10;
                this.root11= root11;
                this.root12= root12;
                this.root13= root13;
                this.root14= root14;
                this.root15= root15;
                this.root16= root16;
                this.root17= root17;
                this.root18= root18;
                this.root19= root19; 
                this.root20= root20;
                this.root21= root21;
                 this.root22= root22;               
	}
 
        public void run() {
            store s  =new store(); 
         try {                
             //8000 is the port number
             Socket socket = new Socket("localhost", 8000);

              // Create an input stream to receive data from the server
             DataInputStream fromServer = new DataInputStream(socket.getInputStream());

             // Create an output stream to send data to the server
             DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
                    btn.setOnAction(e->{
                          Hospital  = d.getText();
                          System.out.println("done"); //printing  done on entering hospital name
                           try {
                                 toServer.writeUTF(Hospital);      //sendig hospital name to the server(Handler)
                                } 
                           catch (IOException ex) {
                            System.out.println(ex.getMessage());
                           }
                     primaryStage.setScene(root2);
	});
//=============================================================================//                          
	   btn2.setOnAction((ActionEvent event2) -> {
                    try {      //sending departments name to the server 
                       toServer.writeUTF(d2.getText());
                       toServer.writeUTF(d3.getText());
                       toServer.writeUTF(d4.getText());
                      }
                    catch (IOException ex) {
                         System.out.println(ex.getMessage());      //printing exception's reason 
                   }
                         primaryStage.setScene(root3);                   
                        });
  //=============================================================================//
           //adding doctor's info 
                    btn3.setOnAction((ActionEvent event2) -> {
                      try {
                       toServer.writeUTF(d5.getText());   //sending doctor's data
                       toServer.writeUTF(d6.getText());
                       toServer.writeUTF(d7.getText());
                       } 
                      catch (IOException ex) {
                         System.out.println(ex.getMessage());
                       }
                      primaryStage.setScene(root4);
                    });
//=============================================================================//                   
                     //adding patients to doctors 
                   btn4.setOnAction((ActionEvent event4) -> {
                      try {
                       toServer.writeUTF(d8.getText());  //sending patient's data
                       toServer.writeUTF(d9.getText());
                       toServer.writeUTF(d10.getText());
                       } 
                      catch (IOException ex) {
                        System.out.println(ex.getMessage());
                       }
                        primaryStage.setScene(root5);
                     });
 //=============================================================================//                  
                     btn5.setOnAction((ActionEvent event4) -> {
                     try {
                       toServer.writeUTF(d11.getText());   //sending 3 nurses' name and the doctor they work with
                       toServer.writeUTF(d12.getText());
                       toServer.writeUTF(d13.getText());
                       toServer.writeUTF(d14.getText());
                       toServer.writeUTF(d15.getText());
                       toServer.writeUTF(d16.getText());
                      } 
                    catch (IOException ex) {
                         System.out.println(ex.getMessage());
                     }
                    primaryStage.setScene(root6);
                    });
//=============================================================================//                     
btn6.setOnAction((ActionEvent event4) -> {             
   primaryStage.setScene(root8);
});
btn8.setOnAction(e->{
    primaryStage.setScene(root10);
});
btn9.setOnAction(e->{
   primaryStage.setScene(root11);
});
btn10.setOnAction(e->{
   primaryStage.setScene(root12);
});
btn11.setOnAction(e->{
   primaryStage.setScene(root13);
});
btn12.setOnAction(e->{
   primaryStage.setScene(root14);
});
btn13.setOnAction(e->{
   primaryStage.setScene(root15);
});
btn7.setOnAction(e->{
   primaryStage.setScene(root18);
});
btn35.setOnAction(e->{
   primaryStage.setScene(root6);
});

btn15.setOnAction(e->{
    primaryStage.setScene(root7);
});
btn16.setOnAction(e->{
   primaryStage.setScene(root9);
});
btn36.setOnAction(e->{
   primaryStage.setScene(root6);
});
//=============================================================================//
btn14.setOnAction((ActionEvent event5) ->{   // calcaulateDoctorSalary
  try {
        toServer.writeUTF("calc");         //sending doctor's info to server (to be processed) to calcaulate salary
        toServer.writeUTF(d21.getText());
        toServer.writeUTF(d20.getText());
        toServer.writeUTF(forsalary.getText());
        
   } 
  catch (IOException ex) {
     System.out.println(ex.getMessage());
   }
 });

btn37.setOnAction(e->{
  primaryStage.setScene(root6);
});
btn53.setOnAction(e->{
primaryStage.setScene(root22);
  });

btn52.setOnAction(e->{
try {
    // sending the doctor who worked extra hours data
    
     toServer.writeUTF("Extra");    
     toServer.writeUTF(d53.getText());
     toServer.writeUTF(d54.getText());
     toServer.writeUTF(d55.getText());
    } catch (IOException ex) {
       System.out.println(ex.getMessage());
       }

});
btn51.setOnAction(e->{
 primaryStage.setScene(root6);
});
//=============================================================================//
btn20.setOnAction(e->{     
 try {
    // increase Basic salary   
    toServer.writeUTF("Increase");      //sending data to server to be procssed
    toServer.writeUTF(d22.getText());
    toServer.writeUTF(d23.getText());
    toServer.writeUTF(d24.getText());      
    }
 catch (IOException ex) {
         System.out.println(ex.getMessage());
                       
    }
});
//=============================================================================//
btn21.setOnAction(e->{   //decrease basic salary data
    try {
    toServer.writeUTF("Decrease");
    toServer.writeUTF(d22.getText());    //sending data to server to be procssed
    toServer.writeUTF(d23.getText());
    toServer.writeUTF(d24.getText());
      } 
    catch (IOException ex) {
         System.out.println(ex.getMessage());
        } 
});  
//=============================================================================//
btn38.setOnAction(e->{
    primaryStage.setScene(root6);
});

 btn22.setOnAction(e->{   //adding doctor to department
    try {
      toServer.writeUTF("Add");
      toServer.writeUTF(d25.getText());
      toServer.writeUTF(d26.getText());       
     }
    catch (IOException ex) {
        System.out.println(ex.getMessage());
        } 
}); 
 //=============================================================================//
btn39.setOnAction(e->{
   primaryStage.setScene(root6);
});

 btn23.setOnAction(e->{  //adding patient todoctor list 
    try {  
      toServer.writeUTF("AddPatient");
      toServer.writeUTF(d27.getText());
      toServer.writeUTF(d28.getText());
      toServer.writeUTF(d29.getText());       
     }
    catch (IOException ex) {
       System.out.println(ex.getMessage());
        }
});
 //=============================================================================//
 btn40.setOnAction(e->{
   primaryStage.setScene(root6);
});

btn24.setOnAction(e->{  // adding doctors for nurse list 
   try {   
      toServer.writeUTF("AddtoNurse");
      toServer.writeUTF(d30.getText());
      toServer.writeUTF(d31.getText());
       }
   catch (IOException ex) {
       System.out.println(ex.getMessage());
        }
});

btn41.setOnAction(e->{
   primaryStage.setScene(root6);
});

btn17.setOnAction(e->{    //enter how much patient ows 
   try { 
      toServer.writeUTF("owe");
      toServer.writeUTF(d32.getText());       //sending data about the patient and the amount of money they have to pay
      toServer.writeUTF(d33.getText());
      toServer.writeUTF(d34.getText());
      toServer.writeUTF(d35.getText());
        } 
      catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
   });

btn42.setOnAction(e->{
   primaryStage.setScene(root6);
});

btn18.setOnAction(e->{   //enter how much patient will pay 
    try {
      toServer.writeUTF("pay");
      toServer.writeUTF(d36.getText());     //sending data about the patient and the amount of money they paid
      toServer.writeUTF(d37.getText());
      toServer.writeUTF(d38.getText());
      toServer.writeUTF(d39.getText());
      } 
    catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
   });
//=============================================================================//
btn25.setOnAction(e->{
   primaryStage.setScene(root16);
});

btn26.setOnAction(e->{
   primaryStage.setScene(root17);
});

btn43.setOnAction(e->{
   primaryStage.setScene(root6);
});

   btn44.setOnAction(e->{
   primaryStage.setScene(root6);
});
 //=============================================================================//
btn27.setOnAction(e->{   //check by doctor
     try {
      toServer.writeUTF("checkbydoctor");
      toServer.writeUTF(d40.getText());
      toServer.writeUTF(d41.getText());    //sending data about the doctor name and the patient name and dept number
      toServer.writeUTF(d42.getText());
     }
     catch (IOException ex) {
       System.out.println(ex.getMessage());
        }
});

btn45.setOnAction(e->{
   primaryStage.setScene(root6);
});
btn28.setOnAction(e->{  //check by nurse
    try {
      toServer.writeUTF("checkbynurse");
      toServer.writeUTF(d43.getText());
      toServer.writeUTF(d44.getText());      //sending data about the patient name and the nurse name and the department numebr and doctor name
      toServer.writeUTF(d45.getText());
      toServer.writeUTF(d46.getText());
     } 
    catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
});
//=============================================================================//
btn46.setOnAction(e->{
   primaryStage.setScene(root6);
  });
btn29.setOnAction(e->{
   primaryStage.setScene(root19); 
});
btn30.setOnAction(e->{
   primaryStage.setScene(root20); 
});
btn31.setOnAction(e->{
   primaryStage.setScene(root21); 
});
btn47.setOnAction(e->{
   primaryStage.setScene(root6);
  });
//=============================================================================//
btn32.setOnAction(e->{     //calcaulate nurse salary 
      try {
      toServer.writeUTF("calcNursesalary");
      toServer.writeUTF(d47.getText());
      toServer.writeUTF(d48.getText());       //sending the nurse data to be processed
      }
      catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
}); 
//=============================================================================//
  btn48.setOnAction(e->{
   primaryStage.setScene(root6);
  });
btn33.setOnAction(e->{  // increase nurse basic salary
        try {  
      toServer.writeUTF("increaseNursesal");
      toServer.writeUTF(d49.getText());
      toServer.writeUTF(d50.getText());  //sending the nurse data to be processed     
       }
       catch (IOException ex) {
        System.out.println(ex.getMessage());
       } 
}); 
//=============================================================================//
btn50.setOnAction(e->{
   primaryStage.setScene(root6);
});

btn34.setOnAction(e->{
      try {  
      toServer.writeUTF("decreasenursesal");
      toServer.writeUTF(d51.getText());        //sending the nurse data to be processed
      toServer.writeUTF(d52.getText());       
      }
      catch (IOException ex) {
          System.out.println(ex.getMessage());
        }
  });
 }
  catch (Exception e) {
    System.out.println(e.getMessage());
   } 
 }
}

