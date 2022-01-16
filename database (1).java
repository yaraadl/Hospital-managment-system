package hospital_project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//class that stores data in database
public class database {    
    private static String url = "";
    private static String dbName = "test";
    static Connection con;
    static Statement stmt;
    static void setURL(){ //setting url for the database
        url = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&characterEncoding=UTF-8";
     }
    //setting connection for the database
    static void setConnection(){        
        try { //exception handling
            setURL();
            con = DriverManager.getConnection(url, "root", "");
        }
        catch (SQLException ex) {
            System.out.println("url is incorrect");
        }        
    } 
//=============================================================================//    
    //overloading
    public static void Add(String table,String ColumnName, String value) //method that adds string value to the database table as doctor name,patient name and nurse name
    {
        try
        {
            setConnection();
            stmt = con.createStatement();
            String str = "INSERT INTO " + table + " (" + ColumnName + ") VALUES ('" + value + "')";
            stmt.executeUpdate(str);
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println("the add method is wrong");
        }
    }
 //=============================================================================//   
    public static void Add(String table,String ColumnName, int value) //method that adds integer value to the database table as employment years
    {
        try
        {
            setConnection();
            stmt = con.createStatement();
            String str = "INSERT INTO " + table + " (" + ColumnName + ") VALUES (" + value + ")";
            stmt.executeUpdate(str);
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println("the add method is wrong");
        }
    }
//=============================================================================//    
    public static void Add(String table,String ColumnName, double value) //method that adds double value to the database table as salary
    {
        try
        {
            setConnection();
            stmt = con.createStatement();
            String str = "INSERT INTO " + table + " (" + ColumnName + ") VALUES (" + value + ")";
            stmt.executeUpdate(str);
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println("the add method is wrong");
        }
    }
 //=============================================================================//   
    public static void AddDoctors(String doctorname,String nursename,double salary,int employmentyears,int department,String patientname){ 
    //method adds all the data entered at once to the database
        try
        {
            setConnection();
            stmt = con.createStatement();
            String str = "INSERT INTO doctors  VALUES ('" + doctorname + "','" + nursename + "',"+salary+","+employmentyears+","+department+",'" + patientname + "')";
            stmt.executeUpdate(str);
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println("the add method is wrong");
        }
    }
 //=============================================================================//   
   public static boolean checkUserAndPass(String username, String password) {
 //method that checks the username and password entered in the login form are identical the the once stored in database or not   
        try {
            setConnection();
            stmt = con.createStatement();
            String strCheck = "SELECT username,password FROM login  WHERE username = '" + username + "' and password = '" + password + "'";
            stmt.executeQuery(strCheck);
            while(stmt.getResultSet().next())
            {
                con.close();
                return true;
            }
            con.close();
        } 
        catch (SQLException ex) {
            System.out.println("the check method is wrong");
        }
        return false;        
    }
//=============================================================================//   
    public static void Update(String table,String ColumnName, String value, String doctorname){
    //method updates the string values to database as when adding new docotor or patient
        try
        {
            setConnection();
            stmt = con.createStatement();
            String str = "UPDATE " + table + " SET " + ColumnName + " = '" + value + "' WHERE doctorname = '" + doctorname+"'";
            stmt.executeUpdate(str);
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println("the update method is wrong");
        }
    }
//=============================================================================//    
    public static void Update(String table,String ColumnName, double value, String doctorname){
        //method updates the double values to database as when increasing or decreasing salary
        try
        {
            setConnection();
            stmt = con.createStatement();
            String str = "UPDATE " + table + " SET " + ColumnName + " = " + value + " WHERE doctorname = '" + doctorname+"'";
            stmt.executeUpdate(str);
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println("the update method is wrong");
        }
    }
 //=============================================================================//   
    public static void Update(String table,String ColumnName, int value, String doctorname){
        //method updates the int values to database as employment years of doctor
        try
        {
            setConnection();
            stmt = con.createStatement();
            String str = "UPDATE " + table + " SET " + ColumnName + " = " + value + " WHERE doctorname = '" + doctorname+"'";
            stmt.executeUpdate(str);
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println("the update method is wrong");
        }
    }
 //=============================================================================//   
    public static void Delete(String table,int id){
    //method that deletes data from the database table       
        try
        {
            setConnection();
            stmt = con.createStatement();
            String str = "DELETE FROM " + table ;
            stmt.executeUpdate(str);
            con.close();
        }
        catch(SQLException ex)
        {
            System.out.println("the Delete method is wrong");
        }
    }
//=============================================================================//    
     public static ResultSet Select(String table){
    //method that select from the database
        ResultSet rs = null;
        try
        {
            setConnection();
            stmt = con.createStatement();
            String str = "SELECT * FROM " + table;
            rs = stmt.executeQuery(str);
            return rs;
        }
        catch(SQLException ex)
        {
            System.out.println("the select method is wrong");
        }
        return rs;
    }  
}
