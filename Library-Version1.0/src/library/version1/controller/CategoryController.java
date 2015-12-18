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
import library.version1.model.Category;

/**
 *
 * @author Neo_
 */
public class CategoryController {
    
    public static int addCategory(Category category) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO Category VALUES('"+category.getId()+"','"+category.getName()+"','"+category.getDewyNumber()+"')";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
    public static ArrayList<String> getCategoryNames() throws SQLException, ClassNotFoundException{
        String sql="SELECT Name From Category Order by Name";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        ArrayList<String> categoryList=new ArrayList<String>();
        while(result.next()){
            categoryList.add(result.getString("Name"));
        }        
        return categoryList;
    }
    
    public static String getCategoryId(String name) throws SQLException, ClassNotFoundException{
        String sql="SELECT CId From Category WHERE Name='"+name+"'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        String id=null;
        if(result.next()){
            id= result.getString("CId");
        }
        return id;
    }
    
    public static String getCategoryDewNumber(String name) throws SQLException, ClassNotFoundException{
        String sql="SELECT DeweyNumber From Category WHERE Name='"+name+"'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        String deweyNumber=null;
        if(result.next()){
            deweyNumber= result.getString("DeweyNumber");
        }
        return deweyNumber;
    }
    
    public static String getCategoryforDewNumber(String number) throws SQLException, ClassNotFoundException{
        String sql="SELECT Name From Category WHERE DeweyNumber='"+number+"'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        String name=null;
        if(result.next()){
            name= result.getString("Name");
        }
        return name;
    }
    
    
    public static ArrayList<Category> getCategoryList() throws ClassNotFoundException, SQLException{
        String sql="SELECT CId , Name ,DeweyNumber From Category Order by DeweyNumber";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<Category> categoryList =new ArrayList<Category>();
        while(result.next()){
            String id = result.getString("CId");
            String name = result.getString("Name");
            String deweyNumber = result.getString("DeweyNumber");            
            Category category = new Category(id, name, deweyNumber);
            categoryList.add(category);
        }
        return categoryList;
    }
    
    public static Category getCategoryDetail(String cId) throws ClassNotFoundException, SQLException{
        String sql="SELECT CId , Name ,DeweyNumber From Category Where CId ='"+cId+"'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        Category category = null;
        if(result.next()){
            String id = result.getString("CId");
            String name = result.getString("Name");
            String deweyNumber = result.getString("DeweyNumber");            
            category = new Category(id, name, deweyNumber);
        }
        return category;
    }
    
     public static int updateCategory(Category category) throws SQLException, ClassNotFoundException{
        String sql="Update Category Set Name='"+category.getName()+"', DeweyNumber='"+category.getDewyNumber()+"' Where CId='"+category.getId()+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
     
    public static int deleteCategory(String categoryId) throws SQLException, ClassNotFoundException{
        String sql="Delete From Category Where CId='"+categoryId+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
}
