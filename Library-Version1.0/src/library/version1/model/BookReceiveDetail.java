/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

import library.version1.extra.IdGenarate;

/**
 *
 * @author Neo_
 */
public class BookReceiveDetail {
    private String bRDId;
    private String accessionNumber;
    private String memberNumber;
    private String returnDate="2012-09-07";
    private String bBDId;

    public BookReceiveDetail() {
    } 

    public BookReceiveDetail(String bRDId, String accessionNumber, String memberNumber, String returnDate, String bBDId) {
        this.bRDId = bRDId;
        this.accessionNumber = accessionNumber;
        this.memberNumber = memberNumber;
        this.returnDate = returnDate;
        this.bBDId = bBDId;
    }
    
     /**
     * @return the bRDId
     */
    public String getbRDId() {
        return bRDId;
    }

    /**
     * @param bRDId the bRDId to set
     */
    public void setbRDId(String bRDId) {
        this.bRDId = bRDId;
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
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the bBDId
     */
    public String getbBDId() {
        return bBDId;
    }

    /**
     * @param bBDId the bBDId to set
     */
    public void setbBDId(String bBDId) {
        this.bBDId = bBDId;
    }
    
    
    

}
