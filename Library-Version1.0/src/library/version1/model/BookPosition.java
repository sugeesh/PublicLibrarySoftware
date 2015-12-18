/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

/**
 *
 * @author Neo_
 */
public class BookPosition {
    private String accessionNumber;
    private String sectionId;
    private String categoryId;

    public BookPosition() {
    }

    public BookPosition(String accessionNumber, String sectionId, String categoryId) {
        this.accessionNumber = accessionNumber;
        this.sectionId = sectionId;
        this.categoryId = categoryId;
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
     * @return the sectionId
     */
    public String getSectionId() {
        return sectionId;
    }

    /**
     * @param sectionId the sectionId to set
     */
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

}
