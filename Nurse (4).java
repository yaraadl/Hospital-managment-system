package hospital_project;
public class Nurse extends Staff implements Managment {
    private double hourlyWage =100 ;
    private double hoursWorked; 
    private double salary ;
    private Doctor []  doctor  ; 
     private int noOfDoctors; 
    Nurse(String name ){
        super(name); 
        doctor = new Doctor[noOfDoctors];
        } 
    
    @Override
     public double salary (int hoursWorked ){   //calcaulating the salary depending on the hours worked
      this.hoursWorked = hoursWorked ; 
      salary = hourlyWage*hoursWorked ; 
      return salary ;
     }   
     
    @Override
     public void increase(double value){    //adding avalue to the hourly wage 
      hourlyWage+=value; 
     }
    @Override
    
    public void decrease(double value){   //removing avalue to the hourly wage 
        hourlyWage-=value; 
     }
    
    @Override
   public void add (String name ){ //adding doctors in the nurse list
     int length = (doctor.length+1);        
     Doctor temp[] = new Doctor [length];  // creating temporary array which has length greater than the patient's array by one
     for(int i =0 ;i<doctor.length;i++){
         temp[i]=doctor[i];   //adding previous doctors in the temp array 
     }
     temp[length-1] = new Doctor( name);  //adding the new doctor in the last position 
    doctor = temp;
    noOfDoctors++;
  }
//=============================================================================//    
//getters and setters 
    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Doctor[] getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor[] doctor) {
        this.doctor = doctor;
    }

    public int getNoOfDoctors() {
        return noOfDoctors;
    }

    public void setNoOfDoctors(int noOfDoctors) {
        this.noOfDoctors = noOfDoctors;
    }

  
}

