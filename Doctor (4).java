package hospital_project;
 public class Doctor extends Staff implements Managment{
   private double Basicsalary = 1000 ;
   private double salary ; 
   private int NoOfPatients ;
   private double extra ;
   private Patient patients[]; 
     Doctor(String name  ){
        super( name); 
        patients= new Patient[NoOfPatients];   // aggregation relation between the doctor and patients
        }
//=============================================================================//     
   @Override
    public double salary (int employmentYears){ //calcaulate the doctor salary and implement one of the interface methods
        salary = Basicsalary+ employmentYears*100; 
        return salary ; 
    }  
     public double salary (double hours){ //calcaulate the doctor salary for extra work (over loading)
        extra = 100 *hours; 
        return extra ;
    }  
   
   @Override
   public void increase(double value){  //increasing the basic salary of the employee
      Basicsalary+=value; 
    }
   
   @Override
  public void decrease(double value){   //decreasing the basic salary of the employee
        Basicsalary-=value; 
    } 
  
   @Override
    public void add (String name  ){       //ading patients in doctor's list 
    int length = (patients.length+1);  // creating temporary array which has length greater than the patient's array by one
     Patient temp[] = new Patient [length];
     for(int i =0 ;i<patients.length;i++){  //adding previous patients in the temp array 
         temp[i]=patients[i];
        }
    temp[length-1] = new Patient( name ); //adding the new patient in the last position 
    patients = temp; //putting the members in the patient's array 
    NoOfPatients = patients.length; 
    }
//=============================================================================//
//getters and setters for all variables of the class 
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getNoOfPatients() {
        return NoOfPatients;
    }

    public void setNoOfPatients(int NoOfPatients) {
        this.NoOfPatients = NoOfPatients;
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }

    public double getExtra() {
        return extra;
    }

    public void setExtra(double extra) {
        this.extra = extra;
    }

    public double getBasicsalary() {
        return Basicsalary;
    }

    public void setBasicsalary(double Basicsalary) {
        this.Basicsalary = Basicsalary;
    }
    
}
