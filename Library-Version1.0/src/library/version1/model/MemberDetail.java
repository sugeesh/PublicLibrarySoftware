/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

import java.util.Date;

/**
 *
 * @author Neo_
 */
public class MemberDetail {
    private String memberNumber ;
    private String memberName;
    private String address ;
    private Date dob;
    private String mType ;
    private String guarantorName;
    private Date renewDate ;

    public MemberDetail() {
    }

    public MemberDetail(String memberNumber, String memberName, String address, Date dob, String mType, String guarantorName, Date renewDate) {
        this.memberNumber = memberNumber;
        this.memberName = memberName;
        this.address = address;
        this.dob = dob;
        this.mType = mType;
        this.guarantorName = guarantorName;
        this.renewDate = renewDate;
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
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * @param memberName the memberName to set
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
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
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the mType
     */
    public String getmType() {
        return mType;
    }

    /**
     * @param mType the mType to set
     */
    public void setmType(String mType) {
        this.mType = mType;
    }

    /**
     * @return the guarantorName
     */
    public String getGuarantorName() {
        return guarantorName;
    }

    /**
     * @param guarantorName the guarantorName to set
     */
    public void setGuarantorName(String guarantorName) {
        this.guarantorName = guarantorName;
    }

    /**
     * @return the renewDate
     */
    public Date getRenewDate() {
        return renewDate;
    }

    /**
     * @param renewDate the renewDate to set
     */
    public void setRenewDate(Date renewDate) {
        this.renewDate = renewDate;
    }

    
    
}
