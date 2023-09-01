import java.sql.*;
class createtable
{
    public static void main(String []args)
    {
        String DB_URL = "jdbc:mysql://localhost:3306/airline";
        String USER = "root";
        String PASS = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();
            String sql ="Create table std (pessangerId int primary key,Name varchar(50),Class varchar(20),Date date,Totalprice int,From varchar(50),To varchar(50),TicketNumber int)";
            stmt.executeUpdate(sql);
            System.out.println("Table Created successfully");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}