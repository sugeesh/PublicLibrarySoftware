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
import library.version1.model.Section;

/**
 *
 * @author Neo_
 */
public class SectionController {
    
    public static int addSection(Section section) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO Section VALUES('"+section.getId()+"','"+section.getName()+"')";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
    public static int updateSection(Section section) throws SQLException, ClassNotFoundException{
        String sql="Update Section Set Name = '"+section.getName()+"' Where SId = '"+section.getId()+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
    public static int deleteSection(String id) throws SQLException, ClassNotFoundException{
        String sql="Delete from Section Where SId = '"+id+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
    public static ArrayList<String> getSectionNames() throws SQLException, ClassNotFoundException{
        String sql="SELECT Name From Section";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        ArrayList<String> sectionList=new ArrayList<String>();
        while(result.next()){
            String name=result.getString("Name");       
            sectionList.add(name);
        }        
        return sectionList;
    }
    
    public static String getSectionId(String name) throws SQLException, ClassNotFoundException{
        String sql="SELECT SId From Section WHERE Name='"+name+"'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        String id=null;
        if(result.next()){
            id= result.getString("SId");
        }
        return id;
    }
    
    public static ArrayList<Section> getAllSectionDetails() throws SQLException, ClassNotFoundException{
        String sql="SELECT * From Section";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        ArrayList<Section> sectionList=new ArrayList<Section>();
        while(result.next()){
            String id=result.getString("SId");        
            String name=result.getString("Name");        
            Section section  = new Section(id, name);
            sectionList.add(section);
        }        
        return sectionList;
    }
}
