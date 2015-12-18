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
import library.version1.model.BookDetail;
import library.version1.model.BookDuplicate;
import library.version1.model.BookSearch;
import library.version1.model.BookTitle;

/**
 *
 * @author Neo_
 */
public class BookTitleController {
    
    //Add Title for Book
    public static int addBookTitle(ArrayList<BookTitle> bookTitleList, Connection connection) throws ClassNotFoundException, SQLException {
        int result = 0;
        for(BookTitle bookTitle : bookTitleList ){
            String sql="INSERT INTO BookTitle VALUES ('"+bookTitle.getAccessionNumber()+"','"+bookTitle.getTitle()+"')";
            int count = DBHandle.setData(connection, sql);
            result += count;
        }
        return result;
    }
   
    //Get List of Book Names
    public static ArrayList<String>  getBookTitles() throws ClassNotFoundException, SQLException {
        String sql= "SELECT Distinct Title FROM BookTitle ORDER BY Title";
        Connection connection=DBConnection.getDBConnection().getConnection();
        ResultSet result=DBHandle.getData(connection,sql);
        ArrayList<String> bookNames=new ArrayList<String>();
        while(result.next()){
            String bookName =result.getString("Title");
            bookNames.add(bookName);
        }
        return bookNames;
    }
    
    
    //Get Books Details
    public static ArrayList<BookSearch> getBooksDetails(ArrayList<BookSearch> bookSearch) throws ClassNotFoundException, SQLException{
        ArrayList<BookSearch> bookDetailsWithTitle = new ArrayList<BookSearch>();
        for(BookSearch book : bookSearch){
            String sql="SELECT Title FROM BookTitle Where AccessionNumber = '"+book.getAccessionNumber()+"' Order by Title ";
            ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
            String title=" ";
            while(result.next()){
                title = title + result.getString("Title") + ",";
            }
            title = title.substring(0, title.length()-1);
            BookSearch bookwithTitle = new BookSearch(title,book.getAccessionNumber(),book.getAuthorName(),book.getSectionName(),book.getCategoryName(),book.getPublisher(),book.isAvailability());
            bookDetailsWithTitle.add(bookwithTitle);
        }
        return bookDetailsWithTitle;
    }
    
   //Get Specific Book Detail
    public static BookDetail getTitleForBook(BookDetail book) throws ClassNotFoundException, SQLException{
         
       String sql="SELECT Title FROM BookTitle Where AccessionNumber = '"+book.getAccessionNumber()+"'";
       ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
       ArrayList<String> title= new ArrayList<String>();
       while(result.next()){
           title.add(result.getString("Title"));
       }
       book.setTitle(title);
       return book;
    }
    
    //Get Specific Book Title
    public static String getTitleForBook(String accessionNumber) throws ClassNotFoundException, SQLException{
       String sql="SELECT Title FROM BookTitle Where AccessionNumber = '"+accessionNumber+"'";
       ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
       String title = " ";
       while(result.next()){
           title = title + result.getString("Title") +",";
       }
       title = title.substring(0, title.length()-1);
       return title;
    }
    
    
    
    
     //Update Book Title
      public static int updateBookTitle(ArrayList<BookTitle> bookTitleList,String accessionNumber, Connection connection) throws ClassNotFoundException, SQLException {
        int result = 0;
        String sql1 = "DELETE FROM BookTitle Where AccessionNumber = '"+accessionNumber+"'";
        int result1 = DBHandle.setData(connection,sql1);
        if(result1>=0){
            for(BookTitle bookTitle : bookTitleList ){
                String sql="INSERT INTO BookTitle VALUES ('"+bookTitle.getAccessionNumber()+"','"+bookTitle.getTitle()+"')";
                int count = DBHandle.setData(connection, sql);
                result += count;
            }
        }else{
            result=-1;
        }
        return result;
    }
    
    // Search Book by Title
    public static ArrayList<BookSearch> searchByTitle(String title) throws SQLException, ClassNotFoundException{
        String sql ="Select Distinct AccessionNumber From BookTitle Where Title like '%"+title+"%'";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<BookSearch> bookSearch = new ArrayList<BookSearch>();
        while(result.next()){
            BookSearch book = new BookSearch();
            book.setAccessionNumber(result.getString("AccessionNumber"));
            bookSearch.add(book);
        }
        return bookSearch;
    }  
      
     public static ArrayList<String> getAccessionNumbersForTitle(String title) throws ClassNotFoundException, SQLException{
         
       String sql="SELECT AccessionNumber FROM BookTitle Where Title = '"+title+"'";
       ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
       ArrayList<String> accessioNumbers= new ArrayList<String>();
       while(result.next()){
           accessioNumbers.add(result.getString("AccessionNumber"));
       }
       return accessioNumbers;
    }
    
    public static BookDuplicate getBookRightTitle(BookDuplicate book) throws ClassNotFoundException, SQLException{
        String sql="SELECT Title FROM BookTitle Where AccessionNumber = '"+book.getAccessionNumber()+"' Order by Title ";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<String> title = new ArrayList<String>();
        while(result.next()){
          title.add(result.getString("Title"));
        }
        book.setTitle(title);
        return book;
    }
    
    
      
}
