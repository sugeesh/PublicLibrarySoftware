/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

/**
 *
 * @author Neo_
 */
public class BookBorrowDetail {
    private String bBDId;
    private String memberNumber;
    private String accessionNumber;
    private String returnDate;
    private String dueDates;

    public BookBorrowDetail() {
    }

    public BookBorrowDetail(String bBDId, String memberNumber, String accessionNumber, String returnDate, String dueDates) {
        this.bBDId = bBDId;
        this.memberNumber = memberNumber;
        this.accessionNumber = accessionNumber;
        this.returnDate = returnDate;
        this.dueDates = dueDates;
    }
    
    public BookBorrowDetail(String bBDId, String memberNumber, String accessionNumber) {
        this.bBDId = bBDId;
        this.memberNumber = memberNumber;
        this.accessionNumber = accessionNumber;
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
     * @return the dueDates
     */
    public String getDueDates() {
        return dueDates;
    }

    /**
     * @param dueDates the dueDates to set
     */
    public void setDueDates(String dueDates) {
        this.dueDates = dueDates;
    }


   
    
}
