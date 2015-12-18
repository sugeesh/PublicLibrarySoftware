/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

/**
 *
 * @author Neo_
 */
public class OrderBookDetail {
    private String oId;
    private String accessionNumber;

    public OrderBookDetail() {
    }

    public OrderBookDetail(String oId, String accessionNumber) {
        this.oId = oId;
        this.accessionNumber = accessionNumber;
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
     * @return the accessionNumber
     */
    public String getAccessionNumber() {
        return accessionNumber;
    }

    /**
     * @param accessionNumber the accessionNumber to set
     */
    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }
    
    
    
}
