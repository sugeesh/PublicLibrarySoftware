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
import library.version1.model.OrderBookDetail;

/**
 *
 * @author Neo_
 */
public class OrderBookDetailController {
    
    public static int addOrderBookDetail (ArrayList<OrderBookDetail> orderBookList, Connection connection) throws SQLException{
        int count=0;
        for(OrderBookDetail orderBookDetail : orderBookList){
            String sql="INSERT INTO OrderBookDetail VALUES ('"+orderBookDetail.getoId()+"','"+orderBookDetail.getAccessionNumber()+"')";
            int result = DBHandle.setData(connection, sql);
            count+=result;
        }
        return count;
    }
    
    public static ArrayList<OrderBookDetail> getOrderDetail() throws SQLException, ClassNotFoundException{
        String sql="SELECT * FROM OrderBookDetail";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        ArrayList<OrderBookDetail> orderList = new ArrayList<OrderBookDetail>();
        while(result.next()){
            OrderBookDetail orderBookDetail = new  OrderBookDetail(result.getString("OId"),result.getString("AccessionNumber"));
            orderList.add(orderBookDetail);
        }    
        return orderList;
    }
    
    public static int deleteDetail (String oId) throws SQLException, ClassNotFoundException{
        String sql="DELETE From OrderBookDetail Where OId = '"+oId+"'";
        int result = DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
       
        return result;
    }
}
