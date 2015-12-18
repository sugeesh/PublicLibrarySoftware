/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

/**
 *
 * @author Neo_
 */
public class MemberSearch {
    private String memberNumber ;
    private String memberName;
    private String address ;
    private String renewDate ;
    private String mType ;
    private String guarantorName;
    private String guarantorAddress;

    public MemberSearch() {
    }

    public MemberSearch(String memberNumber, String memberName, String address, String renewDate, String mType, String guarantorName, String guarantorAddress) {
        this.memberNumber = memberNumber;
        this.memberName = memberName;
        this.address = address;
        this.renewDate = renewDate;
        this.mType = mType;
        this.guarantorName = guarantorName;
        this.guarantorAddress = guarantorAddress;
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
     * @return the guarantorAddress
     */
    public String getGuarantorAddress() {
        return guarantorAddress;
    }

    /**
     * @param guarantorAddress the guarantorAddress to set
     */
    public void setGuarantorAddress(String guarantorAddress) {
        this.guarantorAddress = guarantorAddress;
    }
    
    
    
}
