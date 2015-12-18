/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Neo_
 */
public class DBConnection {
    static private DBConnection dbConnection;
    static private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost/Library","root","lpdscneo");
    }

    public Connection getConnection(){
        return connection;
    }

    public static DBConnection getDBConnection() throws ClassNotFoundException, SQLException{
   //     if(dbConnection==null){
            dbConnection=new DBConnection();
     //   }
        return dbConnection;
    }

    
    
}
