package hospital_project;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//class the includes the gui of the project
public class clientUI extends Application  {
 String  Hospital ; 
 Nurse nurse[] = new Nurse[3];    
 Department  department[] = new Department[3]; 
 Scene root ,root2 ,root3,root4,root5,root6,root7,root8,root9,root10 ; 
 Scene root11 ,root12 ,root13,root14,root15,root16,root17,root18,root19,root20,root21,root22 ;
 TextField d ,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18,d19,d20,d21,d22,d23,d24,d25,d26,d27,d28,d29,d30,d31,d32,d33,d34,d35,d36,d37,d38,
         d39,d40,d41,d42,d43,d44,d45,d46,d47,d48,d49,d50,d51,d52,d53,d54,d55,forsalary;
 Button btn,btn2,btn3 ,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn20,btn21,btn22,btn23,btn24,btn25,btn26,btn27,
 btn28,btn29,btn30,btn31,btn32,btn33,btn34,btn35,btn36,btn37,btn38,btn39,btn40,btn41,btn42,btn43,btn44,btn45,btn46,btn47,btn48,btn50,btn51,btn52,btn53; 
String checkUser, checkPw;
//=============================================================================//
public void start(Stage primaryStage) {  //method that starts the creation of gui
//taking the name of the hospital 
 primaryStage.setTitle("Hospital system");      
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));
        
        //Adding HBox
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));
        
        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
       //Implementing Nodes for GridPane for creating the login form
        Label lblUserName = new Label("Username");
        final TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Login");
        final Label lblMessage = new Label();
        
        //Adding Nodes to GridPane layout
        gridPane.add(new Label ("           Login form"), 1, 3);
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 2, 1);
        gridPane.add(lblMessage, 1, 2);

        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");    
        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);
 //=============================================================================//       
        //Action for btnLogin    
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {            	
        	public void handle(ActionEvent event) {
                        checkUser = txtUserName.getText().toString();
                        checkPw = pf.getText().toString();
        	        if(database.checkUserAndPass(checkUser,checkPw)){
        	        lblMessage.setText("Congratulations!");
     	        lblMessage.setTextFill(Color.GREEN);
                       primaryStage.setScene(root);
        	}
                else{
        	       lblMessage.setText("Incorrect user or pw.");
        	       lblMessage.setTextFill(Color.RED);
        	}
        	txtUserName.setText("");
        	pf.setText("");
        	}
        });
//=============================================================================//       
//Add HBox and GridPane layout to BorderPane Layout
bp.setTop(hb);
bp.setCenter(gridPane);  
        
 //Adding BorderPane to the scene and loading CSS
store s = new store (); 
FlowPane pane1 = new FlowPane();

//scene for hospital name
d = new TextField(); 
btn = new Button ("submit"); 
root = new Scene(pane1, 300, 250);
pane1.setPadding(new Insets(11, 12, 13, 14));
pane1.setHgap(5);
pane1.setVgap(5);
pane1.getChildren().addAll(new Label ("Enter name of hospital "),d,btn); 
//=============================================================================//
//scene for taking departments names
FlowPane pane2 = new FlowPane();
d2= new TextField(); 
d3 = new TextField(); 
d4= new TextField(); 
root2 = new Scene(pane2, 300, 250);
pane2.setPadding(new Insets(11, 12, 13, 14));
pane2.setHgap(5);
pane2.setVgap(5);
btn2 = new Button ("submit"); 
pane2.getChildren().addAll(new Label ("Enter name of department no 1 "),d2,
        new Label ("Enter name of department no 2 "),d3,
        new Label ("Enter name of department no 3"),d4,btn2    );  
//=============================================================================//
//scene for taking the first three doctor's names 
FlowPane pane3 = new FlowPane();
root3= new Scene(pane3, 300, 250);
pane3.setPadding(new Insets(11, 12, 13, 14));
pane3.setHgap(5);
pane3.setVgap(5);
d5 = new TextField();
d6 = new TextField();
d7 = new TextField();
btn3 = new Button ("submit"); 
pane3.getChildren().addAll(new Label ("Enter name of doctor department no 1 "),d5,
        new Label ("Enter name of doctor department no 2 "),d6,
        new Label ("Enter name of doctor department no 3"),d7,btn3);  
//=============================================================================//
//sence for taking the first three patients names
FlowPane pane4  = new FlowPane(); 
root4 = new Scene (pane4,300,250); 
pane4.setPadding(new Insets(11, 12, 13, 14));
pane4.setHgap(5);
pane4.setVgap(5);
 d8 = new TextField();
 d9 = new TextField();
 d10 = new TextField();
 btn4 = new Button ("submit"); 
pane4.getChildren().addAll(new Label ("Enter name of doctor department no 1 patient"),d8,
        new Label ("Enter name of doctor department no 2 patient "),d9,
        new Label ("Enter name of doctor department no 3 patient"),d10,btn4);  
//=============================================================================//
 //sence for entering the nurses' data
FlowPane pane5  = new FlowPane(); 
root5 = new Scene (pane5,300,300); 
pane5.setPadding(new Insets(11, 12, 13, 14));
pane5.setHgap(5);
pane5.setVgap(5);
 d11 = new TextField();
 d12 = new TextField();
 d13 = new TextField();
 d14 = new TextField();
 d15 = new TextField();
 d16 = new TextField();
 btn5 = new Button ("submit"); 
pane5.getChildren().addAll(new Label ("Enter name of nurse"),d11,new Label ("Enter name of nurse2 "),d12,new Label ("Enter name of nurse3"),d13); 
pane5.getChildren().addAll(new Label ("Enter name of nurse1 doctot"),d14,new Label ("Enter name of nurse2 doctor "),d15,
        new Label ("Enter name of nurse3 doctor"),d16,btn5);  
//=============================================================================//
//sence for printing a menu for the user
FlowPane pane6  = new FlowPane(); 
root6 = new Scene (pane6,300,400); 
pane6.setPadding(new Insets(11, 12, 13, 14));
pane6.setHgap(100);
pane6.setVgap(20);
d17 = new TextField();
d18 = new TextField();
d19 = new TextField();
btn6 = new Button("1)About a doctor's salary "); 
btn7 = new  Button("2)About a Nurse's salary  "); 
btn8 = new Button("3)Add Doctor "); 
btn9 = new Button("4)Add  Patient"); 
btn10 = new Button("5)Add Doctors for Nurse list  "); 
btn11= new Button("6)Enter How much the patient owes"); 
btn12= new Button("7)Enter How much the patient will pay "); 
 btn13= new Button("8)Check Patient"); 
pane6.getChildren().addAll(btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13); 
//=============================================================================//
//sence for choosing the query about the doctor's salary   
FlowPane pane8  = new FlowPane(); 
root8 = new Scene(pane8,300,250); 
pane8.setPadding(new Insets(11, 12, 13, 14));
pane8.setHgap(100);
pane8.setVgap(20);
btn15 = new Button ("salary"); 
btn53 = new Button ("salary for extra work");
btn16 = new Button ("increase or decrease");
btn35 = new Button ("Back to main menu ");
pane8.getChildren().addAll(btn15,btn16,btn53,btn35);
//=============================================================================//
//sence for calcaulating a dcotor's salary
FlowPane pane7  = new FlowPane(); 
root7 = new Scene(pane7,300,400); 
pane7.setPadding(new Insets(11, 12, 13, 14));
pane7.setHgap(100);
pane7.setVgap(20);
btn14 = new Button ("submit");
d20 = new TextField();
d21 = new TextField();
btn36= new Button ("Back to main menu ");        
pane7.getChildren().addAll(new Label("what is department number"),d20,new Label("what is doctor name"),d21);
pane7.getChildren().addAll(new Label ("Enter no of  employment years ")); 
forsalary = new TextField (); 
pane7.getChildren().addAll(forsalary,btn14,btn36); 
//=============================================================================//
//decreae or increase doctor salary
FlowPane pane9  = new FlowPane(); 
root9 = new Scene(pane9,400,400); 
pane9.setPadding(new Insets(15, 20, 22, 22));
pane9.setHgap(50);
pane9.setVgap(50);
 btn20 = new Button ("Increase"); 
 btn21 = new Button ("decrease"); 
 btn37= new Button ("Back to main menu ");
pane9.getChildren().addAll(btn21,btn20); 
 d22 = new TextField(); 
 d23 = new TextField(); 
 d24 = new TextField(); 
pane9.getChildren().addAll(new Label("what is department number"),d22,new Label("what is doctor name"),d23);
pane9.getChildren().addAll(new Label("enter the value to be added to basic salary or removed "),d24,btn37);
    
FlowPane pane10  = new FlowPane(); 
root10 =new Scene(pane10,200,300); 
pane10.setHgap(500);
pane10.setVgap(20);
 d25 = new TextField(); 
 d26 = new TextField(); 
 btn22 = new Button ("Add"); 
 btn38= new Button ("Back to main menu ");
pane10.getChildren().addAll(new Label ("enter the number of department "),d25,new Label ("enter the name of the new doctor") ,d26,btn22,btn38); 
//=============================================================================//
//sence for adding patient in the doctor's list
FlowPane pane11 = new FlowPane(); 
root11 = new Scene (pane11,300,300); 
pane11.setPadding(new Insets(11, 12, 13, 14));
pane11.setHgap(100);
pane11.setVgap(20);
 d27 = new TextField (); 
 d28 = new TextField (); 
 d29 = new TextField (); 
 btn39= new Button ("Back to main menu ");
 btn23 = new Button ("Add");
pane11.getChildren().addAll(new Label ("enter the dept no"),d27,new Label ("enter the doctor name "),d28,new Label("enter the patient name"),d29,btn23,btn39);
//=============================================================================//
//sence for adding a doctor for nurse's list 
FlowPane pane12 = new FlowPane(); 
root12 = new Scene (pane12,300,300); 
pane12.setPadding(new Insets(11, 12, 13, 14));
pane12.setHgap(100);
pane12.setVgap(20);
 d30 = new TextField (); 
 d31 = new TextField (); 
 btn40= new Button ("Back to main menu ");
 btn24 = new Button ("Add");
 pane12.getChildren().addAll(new Label ("enter the nurse name "),d30,new Label ("enter the doctor name "),d31,btn24,btn40); 
 //=============================================================================//
 //sence for entering how much patient owes
 FlowPane pane13= new FlowPane (); 
root13 = new Scene (pane13,400,400); 
pane13.setHgap(50);
pane13.setVgap(20);
 d32 = new TextField (); 
 d33 = new TextField (); 
 d34 = new TextField (); 
 d35 = new TextField ();
 btn17 = new Button ("submit"); 
 btn41= new Button ("Back to main menu ");
pane13.getChildren().addAll(new Label("enter the dept number "),d32,new Label("enter the doctor of patient name "),d33);
pane13.getChildren().addAll(new Label("enter the patient "),d34,new Label("enter how much the patient owes "),d35,btn17,btn41);
//=============================================================================//
//sence for entering how much patient will pay
FlowPane pane14= new FlowPane (); 
root14 = new Scene (pane14,400,400); 
pane14.setHgap(50);
pane14.setVgap(20);
 d36 = new TextField (); 
 d37 = new TextField (); 
 d38 = new TextField (); 
 d39 = new TextField ();
 btn42= new Button ("Back to main menu ");
 btn18 = new Button ("submit"); 
pane14.getChildren().addAll(new Label("enter the dept number "),d36,new Label("enter the doctor of patient name "),d37);
pane14.getChildren().addAll(new Label("enter the patient "),d38,new Label("enter how much the patient will pay "),d39,btn18,btn42);
//=============================================================================//
//sence for  who check the patient (doctor or nurse)
FlowPane pane15= new FlowPane (); 
root15 = new Scene (pane15,400,200); 
pane15.setHgap(50);
pane15.setVgap(20);
 btn25 = new Button ("check by doctor"); 
 btn26 = new Button ("check by nurse"); 
 btn43= new Button ("Back to main menu ");
pane15.getChildren().addAll(btn25,btn26,btn43); 
//=============================================================================//
//sence for checking by doctor
FlowPane pane16= new FlowPane (); 
root16 = new Scene (pane16,400,200); 
pane16.setHgap(50);
pane16.setVgap(20);
d40 = new TextField (); 
d41 = new TextField (); 
d42 = new TextField (); 
btn44= new Button ("Back to main menu ");
btn27 = new Button ("submit"); 
pane16.getChildren().addAll(new Label("enter the dept number"),d40,new Label("enter the doctor of patient name"),d41 );
pane16.getChildren().addAll(new Label("enter the patient name"),d42,btn27,btn44);
//=============================================================================//
//sence for checking by nurse
FlowPane pane17= new FlowPane (); 
root17 = new Scene (pane17,400,200); 
pane17.setHgap(50);
pane17.setVgap(20);
 d43 = new TextField (); 
 d44 = new TextField (); 
 d45 = new TextField (); 
 d46= new TextField (); 
 btn45= new Button ("Back to main menu ");
 btn28 = new Button ("submit"); 
pane17.getChildren().addAll(new Label("enter the dept number"),d43,new Label("enter the doctor of patient name"),d44 );
pane17.getChildren().addAll(new Label("enter the patient name"),d45,new Label ("enter the nurse name "),d46,btn28,btn45);
//=============================================================================//
//sence for entering the query about nurse's salary
FlowPane pane18= new FlowPane (); 
root18 = new Scene (pane18,400,200); 
pane18.setHgap(50);
pane18.setVgap(20);
 btn29 = new Button ("1)Calcaulate salary");    
 btn30 = new Button ("2)increase Nurse's hourlyWage ");    
 btn31 = new Button ("3)decrease Nurse's hourlyWage ");   
  btn46= new Button ("Back to main menu ");
 pane18.getChildren().addAll(btn29,btn30,btn31,btn46); 
 //=============================================================================//
//sence for calcaulating salary
 FlowPane pane19= new FlowPane (); 
root19 = new Scene (pane19,400,200); 
pane19.setHgap(50);
pane19.setVgap(20);
 d47 = new TextField (); 
 d48 = new TextField (); 
 btn47= new Button ("Back to main menu ");
btn32 = new Button ("submit");
pane19.getChildren().addAll(new Label("enter the nurse name"),d47,new Label ("enter the number of hours Worked"),d48,btn32,btn47); 
//=============================================================================//
//sence for increasing basic salary
FlowPane pane20= new FlowPane (); 
root20= new Scene (pane20,400,200); 
pane20.setHgap(50);
pane20.setVgap(20);
 d49 = new TextField (); 
 d50= new TextField ();     
 btn48= new Button ("Back to main menu ");
 btn33 = new Button ("submit");
pane20.getChildren().addAll(new Label("enter the nurse name"),d49,new Label ("Enter how Much to add to the Nurse's Basic salary "),d50,btn33,btn48); 
//=============================================================================//
//sence for decreasing basic salary
FlowPane pane21= new FlowPane (); 
root21 = new Scene (pane21,500,500); 
pane21.setHgap(50);
pane21.setVgap(20);
 d51 = new TextField (); 
 d52 = new TextField (); 
 btn50= new Button ("Back to main menu ");
 btn34 = new Button ("submit");
pane21.getChildren().addAll(new Label("enter the nurse name"),d51,new Label ("Enter how Much to remove from the Nurse's Basic salary "),d52,btn34,btn50); 
//=============================================================================//
//sence for calcaulating salary for extra hours
FlowPane pane22= new FlowPane (); 
root22 = new Scene (pane22,300,300); 
pane22.setHgap(50);
pane22.setVgap(20);
 d53 = new TextField (); 
 d54= new TextField (); 
 d55= new TextField (); 
 btn51= new Button ("Back to main menu ");
 btn52= new Button ("submit");
pane22.getChildren().addAll(new Label("Enter dept no"),d53,new Label ("enter doctor name "),d54,new Label ("enter no of extra hours"),d55,btn52,btn51); 
//=============================================================================//
primaryStage.show();
new Thread(new myClient(btn,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn20,btn21,btn22,btn23,btn24,btn25
        ,btn26,btn27,btn28,btn29,btn30,btn31,btn32,btn33,btn34,btn35,btn36,btn37,btn38,btn39,btn40,btn41,btn42,btn43,btn44,btn45,btn46,btn47,btn48,btn50,btn51,
        btn52,btn53,d,
        d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d20,d21,d22,d23,d24,d25,d26,d27,d28,d29,d30,d31,d32,d33,d34,d35,d36,d37,d38,d39,d40,d41,d42,d43,d44,d45,
        d46,d47,d48,d49,d50,d51,d52,d53,d54,d55,forsalary,primaryStage,root2,root3,root4,root5,root6,root7,root8,root9,root10,root11,
        root12,root13,root14,root15,root16,root17,root18,root19,root20,root21,root22)).start();
  }
 public static void main(String[] args) { 
   launch (args); //the calling of start method to generate the gui 
  }
}