/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.version1.db.DBConnection;
import library.version1.db.DBHandle;
import library.version1.model.User;

/**
 *
 * @author Neo_
 */
public class UserController {
    
    public static int addUser(User user) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "Insert Into User Values ('"+user.getuId()+"','"+user.getUserName()+"',(Select Password('"+user.getPassword()+"')),"+user.getPrivilege()+")";
        int result = DBHandle.setData(connection, sql);
        return result;
    }
    
    public static int updateUser(User user) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "Update User Set UserName = '"+user.getUserName()+"' , Password =(Select Password('"+user.getPassword()+"'))   Where  UId ='"+user.getuId()+"'";
        int result = DBHandle.setData(connection, sql);
        return result;
    }

    public static int searchUser(User user) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getDBConnection().getConnection();
        
        String sql = "Select Privilege From User Where UserName = '"+user.getUserName()+"' AND"
                + " Password = (Select password('"+user.getPassword()+"'))";

        ResultSet data = DBHandle.getData(connection, sql);
        
        if(data.next()){
             int privilege = data.getInt("Privilege");
             return privilege;
        }else{
            return -1;
        }

    }
    
    
    public static int checkUserCount() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "Select count(*) from User ";
        ResultSet result = DBHandle.getData(connection, sql);
        int count=-1;
        if(result.next()){
            count = result.getInt(1);
        }
        return count;

    }
    
    
     public static ArrayList<User> getAllUsers() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from User Order by UId";
        ResultSet result = DBHandle.getData(connection, sql);
        ArrayList<User> list = new ArrayList<User>();
        while(result.next()){
            String uId = result.getString("UId");
            String userName = result.getString("UserName");
            int privilege = result.getInt("Privilege");
            User user = new User(uId ,userName, privilege);
            list.add(user);
        }
        return list;

    }
     
     
    public static int deleteUser(String id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "Delete from User Where UId ='"+id+"'";
        int result = DBHandle.setData(connection, sql);
        return result;
    }
    
    public static User getUserDetail(String id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from User Where UId ='"+id+"'";
        ResultSet result = DBHandle.getData(connection, sql);
        User user = new User();
        if(result.next()){
            user.setuId(result.getString("UId"));
            user.setUserName(result.getString("UserName"));
        }
        return user;
    }
    
}
