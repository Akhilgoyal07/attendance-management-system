import java.sql.*;


public class DBCON 
{
	//connection is a interface
    Connection con;
    DBCON()
    {
        try
        {
        	//address of database and college is name of database
            String connectionURL="jdbc:mysql://localhost:3306/college";
            
            //register driver using class.forName
            Class.forName("com.mysql.jdbc.Driver");
            
            //it return a reference of interface connection
            con=DriverManager.getConnection(connectionURL,"root","1234");
            System.out.println("Connection Success");
        }
        catch(Exception e)
        {
            System.out.println("Connection failed.."+e);
        }
    }
    public static void main(String a[])
    {
        new DBCON();
    }
}
