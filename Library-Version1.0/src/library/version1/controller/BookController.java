/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import library.version1.db.DBConnection;
import library.version1.db.DBHandle;
import library.version1.model.Book;
import library.version1.model.BookDetail;
import library.version1.model.BookSearch;


/**
 *
 * @author Neo_
 */
public class BookController {
    
   // To add Book to the Database
   public static boolean addBook(Book book) {
        Connection connection=null;
        boolean bool=false;
        try {
            String sql="INSERT INTO Book VALUES ('"+book.getAccessionNumber()+"',"+book.getPublishedYear()+","+book.getPrice()+",'"+book.getPublisherId()+"','"+book.getPublishedPlace()+"',"+book.isDonation()+","+book.isExpired()+",true)";
            connection=DBConnection.getDBConnection().getConnection();
            connection.setAutoCommit(false);
            int resultBook=DBHandle.setData(connection, sql);
            if(resultBook==1){
                int resultBookPosition=BookPositionController.addBookPosition(book.getBookPosition(),connection);
                if(resultBookPosition==1){
                    int resultBookAuthor=BookAuthorDetailController.addBookAuthorDetail(book.getAuthor(),connection);
                    if(resultBookAuthor==book.getAuthor().size()){
                        int resultBookTitle=BookTitleController.addBookTitle(book.getTitle(),connection);
                        if(resultBookTitle==book.getTitle().size()){
                            connection.commit();
                            JOptionPane.showMessageDialog(null,"Book Added");
                            bool= true;
                        }else{
                            connection.rollback();
                            bool=false;
                        }
                    }else{
                        connection.rollback();
                        bool=false;
                    }
                }else{
                    connection.rollback();
                    bool=false;
                }
            }else{
                connection.rollback();
                bool=false;
            }
        } catch (SQLException ex) {
               ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
        }finally{
            if(connection != null){
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    
                }
            }
	}
        return bool;
    }
   
   // To check the Book is existed
   public static boolean checkDuplicate (String id) throws ClassNotFoundException, SQLException{
       String sql="Select Count(AccessionNumber) as Count From Book Where AccessionNumber = '"+id+"'";
       ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
       boolean bool=false;
       if(result.next()){
           int count = result.getInt("Count");
           if(count==1){
               bool = true;
           }else if(count ==0){
               bool=false;
           }
       }
       return bool;
   } 
            
   // Get All Books Detail (Only get some detail in book table)
   public static ArrayList<BookSearch> getAllBooksDetails() throws ClassNotFoundException, SQLException{
        String sql="Select CAST(b.AccessionNumber AS UNSIGNED) as AccessionNumber,b.Availability,s.Name as SectionNumber,c.Name as CategoryName,p.Name as PublisherName From Book b ,BookPosition bp,Section s,Publisher p,Category c Where b.AccessionNumber= bp.AccessionNumber And bp.SId=s.SId And bp.CId=c.CId And b.PId=p.PId order by AccessionNumber";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<BookSearch> bookSearch =new ArrayList<BookSearch>();
        while(result.next()){
            boolean availability = result.getBoolean("Availability");
            String accessionNumber = result.getString("AccessionNumber");
            String sectionName  = result.getString("SectionNumber");
            String categoryName = result.getString("categoryName");
            String publisherName = result.getString("PublisherName");
            BookSearch book=new BookSearch( accessionNumber, sectionName, categoryName, publisherName,availability);
            bookSearch.add(book);
        }
        return bookSearch;
    }
   
    // Get Specific Books Details ( Some data about that book in book table) Return ArrayList<BookSearch>
    public static ArrayList<BookSearch> getBookDetails(ArrayList<BookSearch> bookSearchIn) throws ClassNotFoundException, SQLException{
        ArrayList<BookSearch> bookSearchOut =new ArrayList<BookSearch>();
        for(BookSearch book : bookSearchIn){
            String sql="Select b.AccessionNumber,b.Availability,s.Name as SectionName,c.Name as CategoryName,p.Name as PublisherName\n" +
"From Book b ,BookPosition bp,Section s,Publisher p,Category c Where b.AccessionNumber= bp.AccessionNumber And bp.SId=s.SId And bp.CId=c.CId And b.PId=p.PId And b.AccessionNumber='"+book.getAccessionNumber()+"'" ;

            ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
            if(result.next()){
                boolean availability = result.getBoolean("Availability");
                String sectionName  = result.getString("SectionName");
                String categoryName = result.getString("categoryName");
                String publisherName = result.getString("PublisherName");
                
                BookSearch bookDetail=new BookSearch(book.getTitle(), book.getAccessionNumber(), book.getAuthorName(), sectionName, categoryName, publisherName, availability);
                bookSearchOut.add(bookDetail);
            }
        }
        return bookSearchOut;
    }
    // Get Specific Book Details ( All data about that book in book table) Return BookDetail
    public static BookDetail getBookDetail(String id) throws ClassNotFoundException, SQLException {
        String sql= "Select b.AccessionNumber,b.Year,s.Name as SectionName,c.Name as CategoryName,p.Name as PublisherName,b.Price,b.PublishedPlace,b.Donation,b.Expired From Book b ,BookPosition bp,Section s,Publisher p,Category c Where b.AccessionNumber= bp.AccessionNumber And bp.SId=s.SId And bp.CId=c.CId And b.PId=p.PId And b.AccessionNumber = '"+id+"'";
        Connection connection=DBConnection.getDBConnection().getConnection();
        ResultSet result=DBHandle.getData(connection,sql);
        BookDetail book=new BookDetail();
        if(result.first()){
           book.setAccessionNumber(result.getString("AccessionNumber"));
           book.setSectionName(result.getString("SectionName"));
           book.setPublishedYear(result.getString("Year"));
           book.setPrice(Double.parseDouble(result.getString("Price")));
           book.setPublisherName(result.getString("PublisherName"));
           book.setPublishedPlace(result.getString("PublishedPlace"));
           book.setDonation(result.getBoolean("Donation"));
           book.setExpired(result.getBoolean("Expired"));
           book.setCategoryName(result.getString("CategoryName"));
        }
        return book;
    }
    
    // Update the Book Details
    public static boolean updateBook(Book book) {
        Connection connection=null;
        boolean bool=false;
        try {
            String sql="UPDATE Book SET Year='"+book.getPublishedYear()+"',Price='"+book.getPrice()+"',PId='"+book.getPublisherId()+"',PublishedPlace='"+book.getPublishedPlace()+"',Donation = "+book.isDonation()+",Expired = "+book.isExpired()+" WHERE AccessionNumber='"+book.getAccessionNumber()+"'";
            connection=DBConnection.getDBConnection().getConnection();
            connection.setAutoCommit(false);
            int resultBook=DBHandle.setData(connection, sql);
            if(resultBook==1){
                int resultBookPosition=BookPositionController.updateBookPosition(book.getBookPosition(),connection);
                if(resultBookPosition==1){
                    int resultBookAuthor=BookAuthorDetailController.updateBookAuthorDetail(book.getAuthor(),book.getAccessionNumber(),connection);
                    if(resultBookAuthor==book.getAuthor().size()){
                        int resultBookTitle=BookTitleController.updateBookTitle(book.getTitle(),book.getAccessionNumber(),connection);
                        if(resultBookTitle==book.getTitle().size()){
                            connection.commit();
                            JOptionPane.showMessageDialog(null,"Book Updated");
                            bool= true;
                        }else{
                            connection.rollback();
                            bool=false;
                        }
                    }else{
                        connection.rollback();
                        bool=false;
                    }
                }else{
                    connection.rollback();
                    bool=false;
                }
            }else{
                connection.rollback();
                bool=false;
            }
        } catch (SQLException ex) {
                
        } catch (ClassNotFoundException ex) {
                
        }finally{
            if(connection != null){
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    
                }
            }
	}
        return bool;
    }
    
     //Delete Book
     public static int deleteBook(String accesionNumber) throws ClassNotFoundException, SQLException {
        String sql="DELETE FROM Book WHERE AccessionNumber='"+accesionNumber+"'";
        int result=DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
        return result;
    }
     
     //Update Book Availability
     public static void updateAvailability(boolean availability,String accessionNumber) throws ClassNotFoundException, SQLException{
        String sql="UPDATE Book SET Availability ="+availability+" WHERE AccessionNumber ='"+accessionNumber+"'";
        DBHandle.setData(DBConnection.getDBConnection().getConnection(),sql);
    }
    
    //check Book Availability
    public static boolean checkAvailability(String accessionNumber) throws ClassNotFoundException, SQLException{
        String sql="SELECT Availability,Expired From Book WHERE AccessionNumber='"+accessionNumber+"'";
        ResultSet result =DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        boolean availability=false;
        boolean missplaced=false;
        if(result.first()){
            availability=result.getBoolean("Availability");
            missplaced = result.getBoolean("Expired");
        }
        return (availability&&(!missplaced));    
    }
    
    public static int countAllBooks() throws ClassNotFoundException, SQLException{
        String sql="SELECT Count(*) as Count from Book";
        ResultSet result =DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        int count = 0;
        if(result.next()){
            count = result.getInt("Count");
        }
        return count;    
    }
    
    public static int countMisplacedBooks() throws ClassNotFoundException, SQLException{
        String sql="SELECT Count(*) as Count from Book Where Expired = true";
        ResultSet result =DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        int count = 0;
        if(result.next()){
            count = result.getInt("Count");
        }
        return count;    
    }
    
    public static int countAvailableBooks() throws ClassNotFoundException, SQLException{
        String sql="SELECT Count(*) as Count from Book Where Availability = true And Expired = false";
        ResultSet result =DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        int count = 0;
        if(result.next()){
            count = result.getInt("Count");
        }
        return count;    
    }
    
    
     
}
