/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

/**
 *
 * @author Neo_
 */
public class Member {
    private String memberNumber;
    private String name;
    private String address;
    private String dob;
    private String renewDate;
    private String mtId;
    private String gId ;

    public Member() {
    }

    public Member(String memberNumber, String name, String address, String dob, String renewDate, String mtId, String gId) {
        this.memberNumber = memberNumber;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.renewDate = renewDate;
        this.mtId = mtId;
        this.gId = gId;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the renewDate
     */
    public String getRenewDate() {
        return renewDate;
    }

    /**
     * @param renewDate the renewDate to set
     */
    public void setRenewDate(String renewDate) {
        this.renewDate = renewDate;
    }

    /**
     * @return the mtId
     */
    public String getMtId() {
        return mtId;
    }

    /**
     * @param mtId the mtId to set
     */
    public void setMtId(String mtId) {
        this.mtId = mtId;
    }

    /**
     * @return the gId
     */
    public String getgId() {
        return gId;
    }

    /**
     * @param gId the gId to set
     */
    public void setgId(String gId) {
        this.gId = gId;
    }
    
    
    
    
}
