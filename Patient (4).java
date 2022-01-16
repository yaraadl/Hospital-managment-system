package hospital_project;
 public class Patient  {
   private String name ;             
   private double patientBill ;    
   Patient(String name ){
       this.name = name ; 
      
       }
    public void owes(double amount){  // adding amount of money to the bill 
        patientBill+=amount ;
       
    }
    public void pay (double amount ){ // removing amount of money to the bill 
       
        if(patientBill<0 || patientBill==0){
            System.out.println("the patient owes 0 "); 
        }
        else  {
           patientBill-=amount ;
         System.out.println("the patient owes  "+patientBill); 
        }  
    }
    public void checkPatient (Staff s ){  //checking patient from one of the staff 
        System.out.println("the Patient was checked");
    }
//=============================================================================//    
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getPatientBill() {
        return patientBill;
    }

    public void setPatientBill(double patientBill) {
        this.patientBill = patientBill;
    }
    
}
