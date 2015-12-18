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
import library.version1.model.MemberType;

/**
 *
 * @author Neo_
 */
public class MemberTypeController {
    
    public static int addMemberType(MemberType memberType) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO MemberType VALUES ('"+memberType.getId()+"','"+memberType.getType()+"')";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
     public static int updateMemberType(MemberType memberType) throws SQLException, ClassNotFoundException{
        String sql="Update MemberType Set Type = '"+memberType.getType()+"' Where MTId = '"+memberType.getId()+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
     
     public static int deleteMemberType(String id) throws SQLException, ClassNotFoundException{
        String sql="Delete from MemberType Where MTId ='"+id+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
    
    public static ArrayList<String> getMemberTypes() throws ClassNotFoundException, SQLException{
        String sql="SELECT Type FROM MemberType";
        ResultSet result= DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        ArrayList<String> memberTypes=new ArrayList<String>();
        while(result.next()){
            String type=result.getString("Type");
            memberTypes.add(type);
        }
        return memberTypes;
    
    }
    
    public static String getMemberTypeId(String type) throws ClassNotFoundException, SQLException{
        String sql="SELECT MTId from MemberType Where Type ='"+type+"'";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        String id=null;
        if(result.next()){
            id = result.getString("MTId");
        }
        return id;   
    }
    
    public static ArrayList<MemberType> getAllMemberTypesDetail() throws ClassNotFoundException, SQLException{
        String sql="SELECT * FROM MemberType";
        ResultSet result= DBHandle.getData(DBConnection.getDBConnection().getConnection(),sql);
        ArrayList<MemberType> memberTypes=new ArrayList<MemberType>();
        while(result.next()){
            String id=result.getString("MTId");
            String type=result.getString("Type");
            MemberType memberType = new MemberType(id, type);
            memberTypes.add(memberType);
        }
        return memberTypes;
    
    }
    
    
    
}
