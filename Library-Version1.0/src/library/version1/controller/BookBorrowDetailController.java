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
import library.version1.extra.IdGenarate;
import library.version1.model.BookBorrowDetail;
import library.version1.model.BookMemberDetail;

/**
 *
 * @author Neo_
 */
public class BookBorrowDetailController {
    
    public static int addBorrowingData(BookBorrowDetail bookBorrowDetail) throws ClassNotFoundException, SQLException{
        String sql="INSERT INTO BookBorrowDetail VALUES('"+bookBorrowDetail.getbBDId()+"','"+bookBorrowDetail.getAccessionNumber()+"','"+bookBorrowDetail.getMemberNumber()+"',CurDate(),INTERVAL 14 DAY + CurDate(),false)";
        int result = DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
        return result;
    }
   
    public static ArrayList<BookBorrowDetail> getNotReturnedBooks(String memberNumber) throws ClassNotFoundException, SQLException{
        String sql="SELECT * From BookBorrowDetail WHERE MId='"+memberNumber+"' AND Returned=false";
        Connection connection=DBConnection.getDBConnection().getConnection();
        ResultSet result = DBHandle.getData(connection, sql);
        ArrayList<BookBorrowDetail> bookBorrowDetails=new ArrayList<BookBorrowDetail>();
        while(result.next()){
            BookBorrowDetail bookBorrowDetail =new BookBorrowDetail();
            String accessionNumber=result.getString("BId");
            String bBDId=result.getString("BBDId");
            String returnDate=result.getString("ReturnDate");
            ResultSet r=DBHandle.getData(connection, "SELECT DATEDIFF(ReturnDate,CURDATE()) AS intval FROM BookBorrowDetail Where BBDId='"+bBDId+"'");
            String dueDates=null;
            if(r.next()){
                dueDates=r.getString(1);
            }
            bookBorrowDetail.setAccessionNumber(accessionNumber);
            bookBorrowDetail.setMemberNumber(memberNumber);
            bookBorrowDetail.setbBDId(bBDId);
            bookBorrowDetail.setReturnDate(returnDate);
            bookBorrowDetail.setDueDates(dueDates);            
            
            bookBorrowDetails.add(bookBorrowDetail);
        }
        return bookBorrowDetails;
        
    }
    
    
    public static int checkMember(String memberNumber) throws SQLException, ClassNotFoundException{
        String sql="Select Count(BBDId) from BookBorrowDetail Where MId='"+memberNumber+"' AND Returned=false";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        int bookCount=0;
        if(result.next()){
            bookCount=result.getInt(1);
        }
        return bookCount;
    }
    
    public static void updateReturned(boolean bool,String bBDId) throws SQLException, ClassNotFoundException{
        String sql="UPDATE BookBorrowDetail SET Returned="+bool+" WHERE BBDId='"+bBDId+"'";
        DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
    }
    
    public static int getDailyReportCounts(String date,String downLimit,String upLimit ) throws ClassNotFoundException, SQLException{
        String sql = "Select Count(BBDId)\n" +
                     "From BookBorrowDetail bbd, Category c ,BookPosition bp\n" +
                      "Where bbd.BId = bp.AccessionNumber and bp.CId=c.CId and Month(Date) = Month('"+date+"') and Year(Date) = Year('"+date+"') and DayOfMonth(Date) = DayOfMonth('"+date+"') and CAST(c.DeweyNumber AS UNSIGNED)>"+downLimit+" and CAST(c.DeweyNumber AS UNSIGNED)<"+upLimit+" Group by DayOfMonth(bbd.Date)";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        int bookCount=0;
      
        if(result.next()){
           bookCount=result.getInt(1);
        }
        return bookCount;
     }
    
    public static int getDailyReportMemberCount(String date ) throws ClassNotFoundException, SQLException{
        String sql = "Select Count(MId)\n" +
                     "From BookBorrowDetail bbd \n" +
                      "Where Month(Date) = Month('"+date+"') and Year(Date) = Year('"+date+"') and DayOfMonth(Date) = DayOfMonth('"+date+"') Group by MId" ;
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        int memberCount=0;
        if(result.next()){
            memberCount=result.getInt(1);
        }
        return memberCount;
     }
    
    
    public static ArrayList<BookMemberDetail> getBookDetail(String accessionNumber ) throws ClassNotFoundException, SQLException{
        String sql = "Select MId , Date , Returned From  BookBorrowDetail Where BId ='"+accessionNumber+"';" ;
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<BookMemberDetail> bookBorrowDetailList = new ArrayList<BookMemberDetail>();
        while(result.next()){
            String memberId = result.getString("MId");
            String Date = result.getString("Date");
            boolean returned = result.getBoolean("Returned");
            
            BookMemberDetail bookBorrowDetail = new BookMemberDetail(memberId,Date,returned);
            bookBorrowDetailList.add(bookBorrowDetail);
        }
        return bookBorrowDetailList;
     }
        
}
