/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.controller;

import java.sql.SQLException;
import library.version1.db.DBConnection;
import library.version1.db.DBHandle;
import library.version1.model.BookReceiveDetail;

/**
 *
 * @author Neo_
 */
public class BookReceiveDetailController {
    
    
    public static int addReceiveData(BookReceiveDetail bookReceiveDetail) throws SQLException, ClassNotFoundException{
        String sql="INSERT INTO BookReceiveDetail VALUES('"+bookReceiveDetail.getbRDId()+"','"+bookReceiveDetail.getAccessionNumber()+"','"+bookReceiveDetail.getMemberNumber()+"',CURDATE(),'"+bookReceiveDetail.getReturnDate()+"','"+bookReceiveDetail.getbBDId()+"')";
        int result = DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
        return result;
    }
    
}
