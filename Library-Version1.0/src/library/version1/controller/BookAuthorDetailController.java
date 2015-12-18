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
import library.version1.model.BookAuthorDetail;
import library.version1.model.BookDetail;
import library.version1.model.BookDuplicate;
import library.version1.model.BookSearch;

/**
 *
 * @author Neo_
 */
public class BookAuthorDetailController {
    
    //Add BookAuthorDetail
    public static int addBookAuthorDetail(ArrayList<BookAuthorDetail> author, Connection connection) throws ClassNotFoundException, SQLException {
        int result=0;
        for(BookAuthorDetail newAuthor : author){
            String sql="INSERT INTO BookAuthorDetail VALUES ('"+newAuthor.getAccessionNumber()+"','"+newAuthor.getAId()+"')";
            int count  = DBHandle.setData(connection, sql);           
            result +=count;
        }
        return result;
    }
    
    //Get BookList Authors
    public static ArrayList<BookSearch> getBooksDetails(ArrayList<BookSearch> bookSearch) throws ClassNotFoundException, SQLException{
        ArrayList<BookSearch> bookDetailsWithAuthor = new ArrayList<BookSearch>();
        for(BookSearch book : bookSearch){
            String sql="SELECT a.Name FROM Author a , BookAuthorDetail bad Where a.AId=bad.AId AND bad.AccessionNumber = '"+book.getAccessionNumber()+"'";
            ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
            String author=" ";
            while(result.next()){
                author = author + result.getString("Name") + ",";
            }
            author = author.substring(0, author.length()-1);
            
            BookSearch bookwithAuthor = new BookSearch(book.getTitle(),book.getAccessionNumber(),author,book.getSectionName(),book.getCategoryName(),book.getPublisher(),book.isAvailability());
            bookDetailsWithAuthor.add(bookwithAuthor);
        }
        return bookDetailsWithAuthor;
    }
    
    // Get Specified Book Author
     public static BookDetail getAuthorForBook(BookDetail book) throws ClassNotFoundException, SQLException{
        String sql="SELECT a.Name FROM Author a , BookAuthorDetail bad Where a.AId=bad.AId AND bad.AccessionNumber = '"+book.getAccessionNumber()+"'";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<String> author = new ArrayList<String>();
        while(result.next()){
          author.add(result.getString("Name"));
        }
        //BookDetail bookWithAuthor = new BookDetail(book.getAccessionNumber(), author, book.getPublishedYear(), book.getPublisherName(), book.getPrice(), book.getCategoryName(), book.getSectionName());
        book.setAuthorName(author);
        return book;
    }
     
      // Get Specified Book Author
     public static String getAuthorForBook(String accessionNumber) throws ClassNotFoundException, SQLException{
        String sql="SELECT a.Name FROM Author a , BookAuthorDetail bad Where a.AId=bad.AId AND bad.AccessionNumber = '"+accessionNumber+"'";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        String author = " ";
        while(result.next()){
           author = author + result.getString("Name") + ",";
        }
        author = author.substring(0, author.length()-1);
        return author;
    }
    
     //Update BookAuthorDetail
     public static int updateBookAuthorDetail(ArrayList<BookAuthorDetail> author, String accessionNumber, Connection connection) throws ClassNotFoundException, SQLException {
        int result=0;
        String sql1 = "DELETE FROM BookAuthorDetail Where AccessionNumber = '"+accessionNumber+"'";
        int result1 = DBHandle.setData(connection,sql1);
        if(result1>=0){
            for(BookAuthorDetail newAuthor : author){
                String sql2="INSERT INTO BookAuthorDetail VALUES ('"+newAuthor.getAccessionNumber()+"','"+newAuthor.getAId()+"')";
                int count  = DBHandle.setData(connection, sql2);           
                result +=count;
            }
        }else{
           result=-1;
        }
        return result;
    }
     
    //Search Book By Author's Name
    public static ArrayList<BookSearch> searchByAuthor(String name) throws SQLException, ClassNotFoundException{
        String sql ="Select Distinct bad.AccessionNumber, a.Name From BookAuthorDetail bad , Author a Where a.AId=bad.AId AND Name like '%"+name+"%' Group by bad.AccessionNumber; ";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<BookSearch> bookSearch = new ArrayList<BookSearch>();
        while(result.next()){
            BookSearch book = new BookSearch();
            book.setAccessionNumber(result.getString("AccessionNumber"));
            book.setAuthorName(result.getString("Name"));
            bookSearch.add(book);
        }
        return bookSearch;
    }  
    
    
    public static ArrayList<String> searchByAuthorId(String id) throws ClassNotFoundException, SQLException{
        String sql ="Select AccessionNumber From BookAuthorDetail Where AId = '"+id+"';";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<String> book=new ArrayList<String>();
        while(result.next()){
            String accessionNumber = result.getString("AccessionNumber");
            book.add(accessionNumber);
        }
        return book;
    }
     public static BookDuplicate getBookRightAuthor(BookDuplicate book) throws ClassNotFoundException, SQLException{
        String sql="SELECT a.Name FROM Author a , BookAuthorDetail bad Where a.AId=bad.AId AND bad.AccessionNumber = '"+book.getAccessionNumber()+"'";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<String> author = new ArrayList<String>();
        while(result.next()){
          author.add(result.getString("Name"));
        }
        book.setAuthorName(author);
        return book;
    }
    
    
}
