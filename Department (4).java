package hospital_project;
 public class Department {
    private String name; 
    private int noOfDoctors; 
    private Doctor []  doctor  ; 
    
    Department(String name ){
        this.name = name; 
       doctor = new Doctor[noOfDoctors]; //aggregation relation between department and the doctors 
        } 
//=============================================================================//    
   // getters and setters 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
//=============================================================================//    
 public void add (String name ){       //adding doctors in department 
     int length = (doctor.length+1); // creating temporary array which has length greater than the doctors' array by one
     Doctor temp[] = new Doctor [length];  
     for(int i =0 ;i<doctor.length;i++){  //adding previous doctors in the temp array 
         temp[i]=doctor[i];    
     }
    temp[length-1] = new Doctor( name  );   //adding the new doctor in the last position 
    doctor = temp;    //putting the members in the doctors' array 
    noOfDoctors++; 
    }
}
