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
import library.version1.model.Guarantor;

/**
 *
 * @author Neo_
 */
public class GuarantorController {
    
    public static int addGuarantor(Guarantor guarantor) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO Guarantor VALUES('"+guarantor.getId()+"','"+guarantor.getName()+"','"+guarantor.getStatus()+"','"+guarantor.getAddress()+"')";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
        return result;
    }
    
    public static int updateGuarantor(Guarantor guarantor) throws SQLException, ClassNotFoundException{
        String sql="Update Guarantor Set Name ='"+guarantor.getName()+"', Status ='"+guarantor.getStatus()+"', Address ='"+guarantor.getAddress()+"' Where GId ='"+guarantor.getId()+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
        return result;
    }
    
    public static int deleteGuarantor(String gId) throws SQLException, ClassNotFoundException{
        String sql="Delete From Guarantor Where GId='"+gId+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
    public static ArrayList<String> getGuarantorNames() throws SQLException, ClassNotFoundException{
        String sql="SELECT Name FROM Guarantor Order by Name";
        ResultSet result= DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<String> guarantorList=new ArrayList<String>();
        while(result.next()){
            String name=result.getString("Name");
            guarantorList.add(name);
        }
        return guarantorList;
    }
    
    public static String getGuarantorId(String name) throws ClassNotFoundException, SQLException{
        String sql="SELECT GId from Guarantor Where Name ='"+name+"'";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        String id=null;
        if(result.next()){
            id = result.getString("GId");
        }
        return id;   
    }
    
    public static ArrayList<Guarantor> getAllGuarantorDetails() throws ClassNotFoundException, SQLException{
        String sql="SELECT * from Guarantor ";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        ArrayList<Guarantor> list = new ArrayList<Guarantor>();
        while(result.next()){
            String gId = result.getString("GId");
            String name = result.getString("Name");
            String status = result.getString("Status");
            String address = result.getString("Address");
            Guarantor guarantor = new Guarantor(gId, name, status, address);
            list.add(guarantor);
        }
        return list;   
    }
    
    
}
