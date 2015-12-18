/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

import java.util.ArrayList;

/**
 *
 * @author Neo_
 */
public class Order {
    private String oId;
    private String memberNumber;
    private ArrayList<OrderBookDetail> orderBookDetailList;
    private String title;

    public Order() {
    }

    public Order(String oId, String memberNumber, ArrayList<OrderBookDetail> orderBookDetailList, String title) {
        this.oId = oId;
        this.memberNumber = memberNumber;
        this.orderBookDetailList = orderBookDetailList;
        this.title = title;
    }
    
    
    public Order(String oId, String memberNumber, ArrayList<OrderBookDetail> orderBookDetailList) {
        this.oId = oId;
        this.memberNumber = memberNumber;
        this.orderBookDetailList = orderBookDetailList;
    }

    /**
     * @return the oId
     */
    public String getoId() {
        return oId;
    }

    /**
     * @param oId the oId to set
     */
    public void setoId(String oId) {
        this.oId = oId;
    }

    /**
     * @return the memberNumber
     */
    public String getMemberNumber() {
        return memberNumber;
    }

    /**
     * @param memberNumber the memberNumber to set
     */
    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    /**
     * @return the orderBookDetailList
     */
    public ArrayList<OrderBookDetail> getOrderBookDetailList() {
        return orderBookDetailList;
    }

    /**
     * @param orderBookDetailList the orderBookDetailList to set
     */
    public void setOrderBookDetailList(ArrayList<OrderBookDetail> orderBookDetailList) {
        this.orderBookDetailList = orderBookDetailList;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
   
    
}
