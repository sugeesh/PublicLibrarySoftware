/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

/**
 *
 * @author Neo_
 */
public class OrderDetail {
    private String oId;
    private String accessionNumber;
    private String memberNumber;
    private boolean returned;
    private String title;

    public OrderDetail() {
    }

    public OrderDetail(String oId, String accessionNumber, String memberNumber, boolean returned, String title) {
        this.oId = oId;
        this.accessionNumber = accessionNumber;
        this.memberNumber = memberNumber;
        this.returned = returned;
        this.title = title;
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
     * @return the returned
     */
    public boolean isReturned() {
        return returned;
    }

    /**
     * @param returned the returned to set
     */
    public void setReturned(boolean returned) {
        this.returned = returned;
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
