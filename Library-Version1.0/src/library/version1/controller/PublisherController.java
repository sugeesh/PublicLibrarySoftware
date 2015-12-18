/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.version1.db.DBConnection;
import library.version1.db.DBHandle;
import library.version1.model.Publisher;

/**
 *
 * @author Neo_
 */
public class PublisherController {
   
    public static int addPublisher(Publisher publisher) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO Publisher VALUES('"+publisher.getId()+"','"+publisher.getName()+"')";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
     public static int updatePublisher(Publisher publisher) throws SQLException, ClassNotFoundException{
        String sql="Update Publisher Set Name ='"+publisher.getName()+"' Where PId ='"+publisher.getId()+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
     
      public static int deletePublisher(String id) throws SQLException, ClassNotFoundException{
        String sql="Delete from Publisher Where PId = '"+id+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
    public static ArrayList<String> getPublisherNames() throws SQLException, ClassNotFoundException{
        String sql="SELECT Name From Publisher Order by Name";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        ArrayList<String> publisherlist=new ArrayList<String>();
        while(result.next()){
            publisherlist.add(result.getString("Name"));
        }        
        return publisherlist;
    }
    
    public static String getPublisherId(String name) throws SQLException, ClassNotFoundException{
        String sql="SELECT PId From Publisher WHERE Name='"+name+"'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        String id=null;
        if(result.next()){
            id= result.getString("PId");
        }
        return id;
    }
   
    
    public static ArrayList<Publisher>  getAllPublisherDetails() throws SQLException, ClassNotFoundException{
        String sql="SELECT * From Publisher";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        ArrayList<Publisher> publisherlist=new ArrayList<Publisher>();
        while(result.next()){
            Publisher publisher = new Publisher(result.getString("PId"), result.getString("Name"));
            publisherlist.add(publisher);
        }        
        return publisherlist;
    }
    
     public static boolean checkPublisher(String name) throws SQLException, ClassNotFoundException{
        String sql="Select Count(PId) as Count From Publisher Where Name ='"+name+"'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        boolean check ;
        int count=0;
        if(result.next()){
            count = result.getInt("Count");
        }
        if(count>0){
           check=true;
        }else{
            check=false;
        }
        return check;
        
    }
    
    
}
