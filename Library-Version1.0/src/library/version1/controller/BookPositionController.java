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
import library.version1.model.BookPosition;
import library.version1.model.BookSearch;

/**
 *
 * @author Neo_
 */
public class BookPositionController {

    
    public static int addBookPosition(BookPosition bookPosition,Connection connection) throws ClassNotFoundException, SQLException{
        String sql="INSERT INTO BookPosition VALUES ('"+bookPosition.getAccessionNumber()+"','"+bookPosition.getSectionId()+"' ,'"+bookPosition.getCategoryId()+"' )";
        int result= DBHandle.setData(connection, sql);
        return result;
    }
    public static int updateBookPosition(BookPosition bookPosition,Connection connection) throws ClassNotFoundException, SQLException{
        String sql="UPDATE BookPosition SET SId='"+bookPosition.getSectionId()+"' ,CId ='"+bookPosition.getCategoryId()+"' WHERE AccessionNumber='"+bookPosition.getAccessionNumber()+"'";
        int result= DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
        return result;
        
    }
    
    
    public static ArrayList<BookSearch> searchByCategory(String name) throws SQLException, ClassNotFoundException{
        String sql ="Select bp.AccessionNumber From Category c , BookPosition bp Where c.CId = bp.CId AND c.Name like '%"+name+"%'";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<BookSearch> bookSearch = new ArrayList<BookSearch>();
        while(result.next()){
            BookSearch book = new BookSearch();
            book.setAccessionNumber(result.getString("AccessionNumber"));
            bookSearch.add(book);
        }
        return bookSearch;
    }  
    
    public static ArrayList<BookSearch> searchByCategoryId(String cId) throws SQLException, ClassNotFoundException{
        String sql ="Select bp.AccessionNumber From Category c , BookPosition bp Where c.CId = bp.CId AND c.CId ='"+cId+"'";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<BookSearch> bookSearch = new ArrayList<BookSearch>();
        while(result.next()){
            BookSearch book = new BookSearch();
            book.setAccessionNumber(result.getString("AccessionNumber"));
            bookSearch.add(book);
        }
        return bookSearch;
    }  

}
