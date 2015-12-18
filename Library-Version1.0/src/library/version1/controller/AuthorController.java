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
import library.version1.model.Author;

/**
 *
 * @author Neo_
 */
public class AuthorController {
    

    public static int addAuthor(Author author) throws SQLException, ClassNotFoundException{
        String sql="INSERT Author VALUES('"+author.getId()+"','"+author.getName()+"')";
        int result=DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
    public static ArrayList<Author> getAuthorIdNames() throws SQLException, ClassNotFoundException{
        String sql="SELECT * FROM Author Order by Name";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        ArrayList<Author> authorList=new ArrayList<Author>();
        while(result.next()){
            String name=result.getString("Name");
            String aId=result.getString("AId");
            Author author=new Author(aId, name);
            authorList.add(author);
        }        
        return authorList;
    }
    
    public static String getAuthorId(String name) throws SQLException, ClassNotFoundException{
        String sql="SELECT AId From Author WHERE Name='"+name+"'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        String id=null;
        if(result.next()){
            id= result.getString("AId");
        }
        return id;
    }
    
    public static String getAuthorName(String id) throws SQLException, ClassNotFoundException{
        String sql="SELECT Name From Author WHERE AId ='"+id+"'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        String author=null;
        if(result.next()){
            author=result.getString("Name");        
        }        
        return author;
    }
    
    public static ArrayList<String> getAuthorNames() throws SQLException, ClassNotFoundException{
        String sql="SELECT Name From Author Order by Name";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        ArrayList<String> authorList=new ArrayList<String>();
        while(result.next()){
            String name=result.getString("Name");        
            authorList.add(name);
        }        
        return authorList;
    }
    
    
    public static int updateAuthor(Author author) throws SQLException, ClassNotFoundException{
        String sql="UPDATE Author SET Name ='"+author.getName()+"' WHERE AId='"+author.getId()+"'";
        int result=DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
    public static int deleteAuthor(String authorId) throws SQLException, ClassNotFoundException{
        String sql="DELETE FROM Author WHERE AId='"+authorId+"'";
        int result=DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
    
    public static boolean checkAuthor(String name) throws SQLException, ClassNotFoundException{
        boolean check=false;
        String sql="SELECT Count(AId) as Count From Author Where Name ='"+name+"'";
       
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
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
