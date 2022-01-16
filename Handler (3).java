package hospital_project;
import java.io.*;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

//class that handles all the processes done in the system
public class Handler implements Runnable { 
   Socket socket ; 
   String Hospital ; 
   int counter  ;
   Nurse nurse[] = new Nurse[3];    
   Department  department[] = new Department[3]; 
   store s = new store (); 
   String doctor1, doctor2 , doctor3 ; 
              
   Handler(Socket socket){
      this.socket =  socket  ; 
   }
 //=============================================================================//   
 public void run(){    //method that starts the threading
     try{
         
         DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
         DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
         Hospital =  inputFromClient.readUTF();   //reading hospital name from my client
            s.store("name of hospital  = "+Hospital+"\n");
           System.out.println("accepted"); 
           
           //taking departments names (3 departments for the hospital )
           department[0] = new Department (inputFromClient.readUTF());
           department[1] = new Department (inputFromClient.readUTF());
           department[2] = new Department (inputFromClient.readUTF());
           
            //storing names in file 
           s.store(department[0].getName()+" department no 1 \n");   
           s.store(department[1].getName()+" department no 2 \n");
           s.store(department[2].getName()+" department no 3 \n");
          System.out.println("accepted");    //ensuring of accepting names  
          doctor1 = inputFromClient.readUTF();
           doctor2 = inputFromClient.readUTF();
           doctor3 =   inputFromClient.readUTF();
           
           //adding  the first three doctors in the hospital 
           department[0].add(doctor1); 
           department[1].add(doctor2);
           department[2].add(doctor3);
           
           //storing names in file 
           s.store( doctor1+" doctor in dept 1 \n");   
           s.store(doctor2+ " doctor in dept 2 \n");
           s.store(doctor3 +" doctor in dept 3 \n");
            System.out.println("accepted"); //ensuring of accepting names 
            
            //adding patient for the first three doctors in the hospital and storing them in the file
           String patient1 = inputFromClient.readUTF() ;
           String patient2 = inputFromClient.readUTF()  ;
           String patient3 = inputFromClient.readUTF()  ;
           Doctor DoctorsOfDepartment1[] = department[0].getDoctor();
           DoctorsOfDepartment1[0].add(patient1 );  
           Doctor DoctorsOfDepartment2[] = department[1].getDoctor();
           DoctorsOfDepartment2[0].add( patient2);  
           Doctor DoctorsOfDepartment3[] = department[2].getDoctor();
           DoctorsOfDepartment3[0].add( patient3);  
           s.store(patient1+"\n");
           s.store(patient2+"\n");
           s.store(patient3+"\n");
           department[0].setDoctor(DoctorsOfDepartment1);
           department[1].setDoctor(DoctorsOfDepartment2);
           department[2].setDoctor(DoctorsOfDepartment3);
           
             //taking nurses info
             String nurse1 = inputFromClient.readUTF()  ;
             String nurse2 = inputFromClient.readUTF()  ;
             String nurse3 = inputFromClient.readUTF()  ;
             String doct1 =  inputFromClient.readUTF()  ;
             String doct2 =  inputFromClient.readUTF()  ;
             String doct3 =  inputFromClient.readUTF()  ;          
             nurse[0]=new Nurse(nurse1);
             nurse[1]=new Nurse(nurse2);
             nurse[2]=new Nurse(nurse3);
             
             //adding which doctor is the nurse working with
             nurse[0].add(doct1); 
             nurse[1].add(doct2);
             nurse[2].add(doct3);
             
             //storing names of doctors in file
            s.store(nurse1+" works for "+doct1+"\n");  
            s.store(nurse2+" works for "+doct2+"\n");
            s.store(nurse3+" works for "+doct3+"\n");
            System.out.println("accepted"); 
            
            //sending data to database
            System.out.println(doctor1);
            if(!doctor1.matches("")){    //incase the textfield is left empty,nothing is stored in the database
                 database.AddDoctors(doctor1, nurse1, 1000, 0, 1, patient1);
            }
            if(!doctor2.matches("")){
                  database.AddDoctors(doctor2, nurse2, 1000, 0, 2, patient2);
            }
           if(!doctor3.matches("")){
               database.AddDoctors(doctor3, nurse3, 1000, 0, 3, patient3);
           }
      //=============================================================================//
    while(true){   
    String choice = inputFromClient.readUTF() ;   //taking a string after presing a button to determine wich operation to do
    switch(choice) {
        
    case "calc": 
     //calcaulating doctor salary depending on employment years 
    String name = inputFromClient.readUTF(); 
    int number2 = Integer.parseInt(inputFromClient.readUTF());
    Doctor[] doctors = department[number2-1].getDoctor(); 
    for(int i =0 ; i<doctors.length;i++){
       if(doctors[i].getName().matches(name)){  
           int empyears = Integer.parseInt(inputFromClient.readUTF());
           database.Update("doctors","employmentyears", empyears, name);     //updating doctor's employment years in database
            System.out.println("the salary of doctor "+doctors[i].getName()+" is = "+String.valueOf(doctors[i].salary(empyears))); 
        }
     }
    break;
    //=============================================================================//
    case "Increase":
    //increase doctor's basic  salary 
   int n = Integer.parseInt(inputFromClient.readUTF());  
   Doctor[] d = department[n-1].getDoctor(); 
   String Name = inputFromClient.readUTF() ; 
   for(int i =0 ; i<d.length;i++){
       if(d[i].getName().matches( Name)){  
           d[i].increase(Integer.parseInt(inputFromClient.readUTF()));
           System.out.println("the basic salary for "+d[i].getName()+" increased became "+String.valueOf(d[i].getBasicsalary()));
           s.store("doctor "+d[i].getName()+" 's salary incresed and became "+String.valueOf(d[i].getBasicsalary())+"\n");     //storing doctor's increase in file
           database.Update("doctors","salary", d[i].getBasicsalary(), Name);      //updating doctor's salary after increase in database
        }
    }
   break ;
   //=============================================================================//
   case"Decrease":
        //decrease doctor's basic  salary 
       int number3 = Integer.parseInt(inputFromClient.readUTF())-1;  
       Doctor[] doct = department[number3].getDoctor(); 
       String str   =inputFromClient.readUTF() ; 
       for(int i =0 ; i<doct.length;i++){
         if(doct[i].getName().matches(str)){    
           doct[i].decrease(Integer.parseInt(inputFromClient.readUTF()));
           System.out.println("the basic salary for "+doct[i].getName()+" decreased became "+String.valueOf(doct[i].getBasicsalary()));
             s.store("doctor "+doct[i].getName()+" 's salary decreased and became "+String.valueOf(doct[i].getBasicsalary())+"\n");
         }
       }
       break ;
       //=============================================================================//
    case"Add":
    //adding doctor in one of the three departments 
    int num = Integer.parseInt(inputFromClient.readUTF())-1;
    String newDoctor = inputFromClient.readUTF() ; 
    department[num].add(newDoctor);
    Doctor doctorOfDepartment[] = department[num].getDoctor();
    s.store("doctor "+newDoctor+" was added to department number "+String.valueOf(num)+"\n"); //storing the new doctor added to the file
    System.out.println("the doctors of the department are");
        for(int i =0 ;i<doctorOfDepartment.length;i++){
        System.out.println("Dr."+doctorOfDepartment[i].getName());
        counter++; 
        }
     break;
     //=============================================================================//
  case"AddPatient":
      //adding new patient in doctor's list 
       int numm = Integer.parseInt(inputFromClient.readUTF());
       Doctor[] dd = department[numm-1].getDoctor(); 
       String ss = inputFromClient.readUTF() ; 
      for(int i =0 ; i<dd.length;i++){
        if(dd[i].getName().matches(ss)){  
          String namee = inputFromClient.readUTF() ; 
          dd[i].add(namee);
          s.store("patient "+namee+" was added to department number "+String.valueOf(numm)+" with doctor"+ss+"\n");
          department [numm-1].setDoctor(dd);
           Doctor Doctorss [] = department [numm-1].getDoctor();
           Patient[] p =  Doctorss[i].getPatients();
           System.out.println("The patients for doctor are");
           for(int j=0;j<p.length;j++){
                System.out.println(" "+p[j].getName());
           }
        }
   }
   break; 
   //=============================================================================//
   case"AddtoNurse":
       //adding doctors for a nurse list 
       String nname = inputFromClient.readUTF()  ;
        for(int i=0;i<3;i++){
          if(nurse[i].getName().matches(nname)) {
           String nurseNewDoc = inputFromClient.readUTF() ;
           nurse[i].add(nurseNewDoc);
           s.store("doctor "+nurseNewDoc+" was added to nurse "+nname+"\n");
           Doctor doctor[] = nurse[i].getDoctor(); 
           System.out.println("the doctors for "+nurse[i].getName()+" are "); 
           for(int j=0;j<doctor.length;j++){
             System.out.println(doctor[j].getName());
               }  
            }
        } 
      break;
      //=============================================================================//
   case "owe":
   //enter how much patient owes
   int Num  =Integer.parseInt(inputFromClient.readUTF())-1; 
   Doctor doctor [] = department[Num].getDoctor();
   String pname = inputFromClient.readUTF(); 
   for(int i=0;i<doctor.length;i++){
     if(doctor[i].getName().matches(pname)){
        Patient[] p =  doctor[i].getPatients();
        String PatientName = inputFromClient.readUTF(); 
        for(int j=0;j<p.length;j++){
               if(p[j].getName().matches(PatientName)){
                        p[j].owes(Double.parseDouble(inputFromClient.readUTF()));
                        System.out.println(p[j].getName()+" owes now "+p[j].getPatientBill()); 
                        s.store("the patient "+p[j].getName()+"owe now "+String.valueOf(p[j].getPatientBill())+"\n");
                }
        }
    }
}
    break;
    //=============================================================================//
   case"pay":
   //enter how much patient will pay 
   int Numm  =Integer.parseInt(inputFromClient.readUTF())-1; 
   Doctor doctorr [] = department[Numm].getDoctor();
   String ppname = inputFromClient.readUTF() ; 
   for(int i=0;i<doctorr.length;i++){
      if(doctorr[i].getName().matches(ppname)){
          Patient[] p =  doctorr[i].getPatients();
          String PatientName = inputFromClient.readUTF(); 
          for(int j=0;j<p.length;j++){
             if(p[j].getName().matches(PatientName)){
                  p[j].pay(Double.parseDouble(inputFromClient.readUTF()));
                  System.out.println(p[j].getName()+" owes now "+p[j].getPatientBill()); 
                  s.store("the patient "+p[j].getName()+"owe now "+String.valueOf(p[j].getPatientBill())+"\n"); //storing how much the patient owes to the file 
              }
          }
       }
  }
   break ; 
   //=============================================================================//
   case"checkbydoctor":
    //check the patient by doctor after taking doctor name and the department 
    int no  =Integer.parseInt(inputFromClient.readUTF())-1;
    String doctorOfPatient = inputFromClient.readUTF();      
    String PatientName = inputFromClient.readUTF();   
    Doctor doctorss[]= department [no].getDoctor();
    for(int i=0;i<doctorss.length;i++){
         if(doctorss[i].getName().matches(doctorOfPatient)){
             Patient[] p =  doctorss[i].getPatients();         
              for(int j=0;j<p.length;j++){
                 if(p[j].getName().matches(PatientName)){  
                     p[j].checkPatient(doctorss[i]);
                     System.out.println("Doctor "+doctorss[i].getName()+" Has just check the patient "+p[j].getName());
                     s.store("Doctor "+doctorss[i].getName()+" Has just check the patient "+p[j].getName()+"\n"); //storing in the file that the patient is checked by a doctor
                 }   
             }
        }
    }
   break; 
   //=============================================================================//
   case"checkbynurse":
   //check the patient by nurse after taking nurse name and the department 
   int numb  =Integer.parseInt(inputFromClient.readUTF())-1; 
   Doctor doctorsss[]= department [numb].getDoctor();  
   String doctorofPatient = inputFromClient.readUTF(); 
   for(int i=0;i<doctorsss.length;i++){
            if(doctorsss[i].getName().matches(doctorofPatient)){
                Patient[] p =  doctorsss[i].getPatients();
                String Patientname = inputFromClient.readUTF(); 
                String nursename  = inputFromClient.readUTF(); 
                for(int j=0;j<p.length;j++){
                    if(p[j].getName().matches(Patientname)){  
                        for(int  k=0; k<nurse.length;k++){
                            if(nurse[k].getName().matches(nursename)){
                                p[j].checkPatient(nurse[k]);
                                System.out.println("Nurse "+nurse[k].getName()+" Has just check the patient");
                                s.store("Nurse "+nurse[k].getName()+" Has just check the patient\n");  //storing in the file that the patient is checked by a nurse
                            }  
                       }
                   }   
              }
          }
    }
   break ;
   //=============================================================================//
   case"calcNursesalary":
       //calcaulating nurse salary depending on the hours she worked
       String nurname = inputFromClient.readUTF(); 
       for(int i=0;i<nurse.length;i++){          
          if(nurse[i].getName().matches(nurname)){
            int numOfHours = Integer.parseInt(inputFromClient.readUTF()); 
            nurse[i].salary(numOfHours);
            System.out.println("The salary for Nurse "+nurse[i].getName()+" is "+nurse[i].getSalary());
            }
        }
      break; 
      //=============================================================================//
    case"increaseNursesal":
        //increasing the nurse's hourly wage
        String Nursename  =inputFromClient.readUTF() ;
        for(int i=0;i<nurse.length;i++){
           if(nurse[i].getName().matches(Nursename)){
               nurse[i].increase(Integer.parseInt(inputFromClient.readUTF()));
               System.out.println("The basic salary of nurse "+nurse[i].getName()+" became "+nurse[i].getHourlyWage());
               s.store("The basic salary of nurse "+nurse[i].getName()+" became "+nurse[i].getHourlyWage()+"\n"); //storing the increase of nurse wage      
           }
        }
     break;
   //=============================================================================//  
   case"decreasenursesal":
       //decreasing the nurse's hourly wage
       String nurseName = inputFromClient.readUTF() ;        
        for(int i=0;i<nurse.length;i++){        
            if(nurse[i].getName().matches(nurseName)){
                nurse[i].decrease(Integer.parseInt(inputFromClient.readUTF()));
                System.out.println("The basic salary of nurse "+nurse[i].getName()+" became "+nurse[i].getHourlyWage());
                s.store("The basic salary of nurse "+nurse[i].getName()+" became "+nurse[i].getHourlyWage()+"\n");   //storing the decrease of nurse wage     
           }
       }
    break; 
    //=============================================================================//
   case "Extra":
     //calcaulating the wage of extra hours the doctor worked
       int departmetnumber = Integer.parseInt(inputFromClient.readUTF())-1; 
       String doctorname =inputFromClient.readUTF(); 
       Doctor doctorsOfDepartment[] = department[departmetnumber].getDoctor();
       for(int c=0;c<doctorsOfDepartment.length;c++){
                 if(doctorsOfDepartment[c].getName().matches(doctorname)){
                     double hours = Double.parseDouble (inputFromClient.readUTF() );
                     doctorsOfDepartment[c].salary(hours);
                     System.out.println("Extra Wage for Doctor "+doctorsOfDepartment[c].getName()+" is "+doctorsOfDepartment[c].getExtra());
                      s.store("Doctor "+doctorsOfDepartment[c].getName()+"Worked extra hours and got "+String.valueOf(doctorsOfDepartment[c].getExtra())+"\n");
       
               }   
       }
   break ;
   //=============================================================================//
  default:  // default case 
   System.out.println("wrong choice");
      }            
   }
 }     
   catch(IOException e){
    System.out.println("exception "+e.getMessage());   
      }
catch(IllegalArgumentException ex){   //handling the case in which the user entered a string instead of a number
System.out.println("exception "+ex.getMessage());
    } 
  }     
}
