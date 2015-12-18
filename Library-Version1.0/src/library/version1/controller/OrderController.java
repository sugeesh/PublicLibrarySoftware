/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import library.version1.db.DBConnection;
import library.version1.db.DBHandle;
import library.version1.model.Order;
import library.version1.model.OrderDetail;

/**
 *
 * @author Neo_
 */
public class OrderController {
    
    public static void addOrder(Order order) {
        Connection connection=null;
        boolean bool=false;
        
        try {
            connection=DBConnection.getDBConnection().getConnection();
            connection.setAutoCommit(false);
            
            String sql="INSERT INTO OrderBook VALUES ('"+order.getoId()+"','"+order.getMemberNumber()+"',false,null,'"+order.getTitle()+"')";
            int resultOrder = DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
            if(resultOrder ==1){
               int resultOrderBookDetail = OrderBookDetailController.addOrderBookDetail(order.getOrderBookDetailList(),connection);
                    if(resultOrderBookDetail==order.getOrderBookDetailList().size()){
                        connection.commit();
                        JOptionPane.showMessageDialog(null,"Order Added");
                        bool= true;
                    }else{
                        connection.rollback();
                        bool=false;
                    }
            }else{
              connection.rollback();
              bool=false;
            }
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }  
    }
    
    public static Order getOrderDetail(String oId) throws SQLException, ClassNotFoundException{
        String sql="Select * from OrderBook Where oId = '"+oId+"'";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        Order order = null;
        if(result.next()){
            order =new Order(oId, result.getString("MemberNumber"), null);
        }
        return order;
    }
    
    public static void updateReturned(boolean returned, String oId, String accessionNumber) throws SQLException, ClassNotFoundException{
        String sql="Update OrderBook Set Returned="+returned+" ,AccessionNumber ='"+accessionNumber+"' Where OId ='"+oId+"'";
        int result = DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
        
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public static ArrayList<OrderDetail> getAllOrderDetail() throws SQLException, ClassNotFoundException{
        String sql="Select * FROM OrderBook ";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        
        ArrayList<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        while(result.next()){
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setoId(result.getString("OId"));
            orderDetail.setTitle(result.getString("Title"));
            orderDetail.setAccessionNumber(result.getString("AccessionNumber"));
            orderDetail.setMemberNumber(result.getString("MemberNumber"));
            orderDetail.setReturned(result.getBoolean("Returned"));
            orderDetailList.add(orderDetail);
        }
        return orderDetailList;
    }
    
    
    
    
    public static int deleteOrder(String oId) throws SQLException, ClassNotFoundException{
        String sql="Delete From OrderBook Where OId='"+oId+"'";
        int result = DBHandle.setData(DBConnection.getDBConnection().getConnection(), sql);
        return result;
    }
    
    public static boolean checkMember(String memberNumber) throws SQLException, ClassNotFoundException{
        String sql="Select count(OId) as count \n" +
                    "From OrderBook \n" +
                    "Where MemberNumber='"+memberNumber+"'";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        int count=0;
        boolean check=false;
        if(result.next()){
            count=result.getInt("count");
        }
        if(count>0){
            check=true;
        }
        return check;
    }
    
    public static boolean checkBook(String accessionNumber) throws SQLException, ClassNotFoundException{
        String sql="Select count(OId) as count \n" +
                    "From OrderBook \n" +
                    "Where AccessionNumber='"+accessionNumber+"'";
        ResultSet result = DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        int count=0;
        boolean check=false;
        if(result.next()){
            count=result.getInt("count");
        }
        if(count>0){
            check=true;
        }
        return check;
    }
    
  
    
    
}
