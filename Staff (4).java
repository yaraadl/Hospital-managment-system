package hospital_project;

public abstract class Staff {
  private String name ;             //Data for all people in hospital Encapsulated
    Staff(String name ){
       this.name = name ; 
    }
  //getters and setters for all data
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //  abstract method for adding memebers 
    public abstract void add(String name ); 
}
