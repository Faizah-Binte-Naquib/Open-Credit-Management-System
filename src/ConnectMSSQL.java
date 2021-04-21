/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP PAVILION
 */
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class ConnectMSSQL {
    
    String query = "";
    int queryType; 
    ResultSet resultSet;
    public ConnectMSSQL()
    {
        
    }
    public ConnectMSSQL(String query, int x)
    {
        this.query = query;
        queryType = x;
    }
    public ResultSet connectDB(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=OpenCourseCreditSystem;selectMethod=cursor",   "sa", "123456");
            System.out.println("DATABASE NAME IS:"                        + connection.getMetaData().getDatabaseProductName());
            java.sql.Statement statement = connection.createStatement();
             if(queryType == 1){
                 statement.executeUpdate(query);
  
            }
            if(queryType == 2){
                 resultSet = statement.executeQuery(query);
  
            }
            /*while (resultSet.next()) {
                System.out.println("Customer NAME:" + resultSet.getString("FirstName"));
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }  
    
    
}
