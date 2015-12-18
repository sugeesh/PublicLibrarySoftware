/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import library.version1.db.DBHandle;
import library.version1.db.DBConnection;
import library.version1.model.Member;
import library.version1.model.MemberDetail;
import library.version1.model.MemberSearch;

/**
 *
 * @author Neo_
 */
public class MemberController {
    
    public static int addMember(Member member,String receiptNo) throws ClassNotFoundException, SQLException{
        String sql="INSERT INTO Member VALUES ('"+member.getMemberNumber()+"' ,'"+member.getName()+"' ,'"+member.getAddress()+"' ,'"+member.getDob()+"' ,'"+member.getRenewDate()+"' ,'"+member.getMtId()+"' ,'"+member.getgId()+"','"+receiptNo+"')";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
        return result;
    }
    
    public static String getMemberName(String id) throws ClassNotFoundException, SQLException{
        String sql="SELECT Name FROM Member WHERE MemberNumber ='"+id+"'";
        ResultSet result= DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        String name=null;
        if(result.next()){
            name=result.getString("Name");
        }
        return name;
    }
    public static ArrayList<MemberSearch> searchByName(String name) throws ClassNotFoundException, SQLException{
        String sql="SELECT m.MemberNumber,m.Name as MemberName,m.Address as MemberAddress ,m.RenewDate,g.name as GuarantorName,g.address as GuarantorAddress,mt.Type as MemberType From Member m,Guarantor g,MemberType mt Where m.GId=g.GId and m.MTId=mt.MTId And m.Name like '%"+name+"%'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<MemberSearch> memberSearch =new ArrayList<MemberSearch>();
        while(result.next()){
            String memberNumber = result.getString("MemberNumber");
            String memberName = result.getString("MemberName");
            String memberAddress = result.getString("MemberAddress");
            String renewDate  = result.getString("RenewDate");
            String guarantorName  = result.getString("GuarantorName");
            String guarantorAddress = result.getString("GuarantorAddress");
            String memberType = result.getString("MemberType");
            MemberSearch member = new MemberSearch(memberNumber, memberName, memberAddress, renewDate, memberType, guarantorName, guarantorAddress);
            memberSearch.add(member);
        }
        return memberSearch;
    }
    
    public static ArrayList<MemberSearch> searchByNumber(String number) throws ClassNotFoundException, SQLException{
        String sql="SELECT m.MemberNumber,m.Name as MemberName,m.Address as MemberAddress ,m.RenewDate,g.name as GuarantorName,g.address as GuarantorAddress,mt.Type as MemberType From Member m,Guarantor g,MemberType mt Where m.GId=g.GId and m.MTId=mt.MTId And m.MemberNumber = '"+number+"'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<MemberSearch> memberSearch =new ArrayList<MemberSearch>();
        while(result.next()){
            String memberNumber = result.getString("MemberNumber");
            String memberName = result.getString("MemberName");
            String memberAddress = result.getString("MemberAddress");
            String renewDate  = result.getString("RenewDate");
            String guarantorName  = result.getString("GuarantorName");
            String guarantorAddress = result.getString("GuarantorAddress");
            String memberType = result.getString("MemberType");
            MemberSearch member = new MemberSearch(memberNumber, memberName, memberAddress, renewDate, memberType , guarantorName, guarantorAddress);
            memberSearch.add(member);
        }
        return memberSearch;
    }
    
    public static MemberDetail getMemberDetail(String number) throws ClassNotFoundException, SQLException{
        String sql="SELECT m.MemberNumber,m.Name as MemberName,m.Address as MemberAddress ,m.RenewDate,g.name as GuarantorName,mt.Type as MemberType, m.Dob From Member m,Guarantor g,MemberType mt Where m.GId=g.GId and m.MTId=mt.MTId And m.MemberNumber = '"+number+"'";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        MemberDetail member=null;
        if(result.next()){
            String memberNumber = result.getString("MemberNumber");
            String memberName = result.getString("MemberName");
            String memberAddress = result.getString("MemberAddress");
            Date renewDate  = result.getDate("RenewDate");
            String guarantorName  = result.getString("GuarantorName");
            Date dob  = result.getDate("Dob");
            String memberType = result.getString("MemberType");
            member = new MemberDetail(memberNumber,memberName,memberAddress,dob,memberType,guarantorName,renewDate);
        }
        return member;
    }
    
    public static int updateMember(Member member) throws ClassNotFoundException, SQLException{
        String sql="Update Member Set Name='"+member.getName()+"' ,Address='"+member.getAddress()+"' ,Dob='"+member.getDob()+"' , RenewDate='"+member.getRenewDate()+"' ,MTId='"+member.getMtId()+"' ,GId='"+member.getgId()+"' Where MemberNumber='"+member.getMemberNumber()+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
        return result;
    }
    
    public static int deleteMember(String memberNumber) throws ClassNotFoundException, SQLException{
        String sql="Delete FROM Member Where MemberNumber ='"+memberNumber+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
        return result;
    }
    
     public static ArrayList<MemberSearch> getMemberList() throws ClassNotFoundException, SQLException{
        String sql="SELECT m.MemberNumber,m.Name as MemberName,m.Address as MemberAddress ,m.RenewDate,g.name as GuarantorName,g.address as GuarantorAddress,mt.Type as MemberType From Member m,Guarantor g,MemberType mt Where m.GId=g.GId and m.MTId=mt.MTId Order by m.Name";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<MemberSearch> memberSearch =new ArrayList<MemberSearch>();
        while(result.next()){
            String memberNumber = result.getString("MemberNumber");
            String memberName = result.getString("MemberName");
            String memberAddress = result.getString("MemberAddress");
            String renewDate  = result.getString("RenewDate");
            String guarantorName  = result.getString("GuarantorName");
            String guarantorAddress = result.getString("GuarantorAddress");
            String memberType = result.getString("MemberType");
            MemberSearch member = new MemberSearch(memberNumber, memberName, memberAddress, renewDate, memberType, guarantorName, guarantorAddress);
            memberSearch.add(member);
        }
        return memberSearch;
    }
    
     
     
     public static boolean checkMember(String number) throws ClassNotFoundException, SQLException{
        String sql="Select count(*) as count From Member Where MemberNumber ='"+number+"'";
        ResultSet result= DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        if(result.next()){
            if(result.getInt("count") ==1){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }     
    }
     
    public static int checkRenewDate(String number) throws ClassNotFoundException, SQLException{
        String sql="Select DATEDIFF(RenewDate,CURDATE()) as date from Member Where MemberNumber = '"+number+"' ";
        ResultSet result= DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        int date =0;
        if(result.next()){
            date = result.getInt("date");
        } 
        return date;
    }
}
