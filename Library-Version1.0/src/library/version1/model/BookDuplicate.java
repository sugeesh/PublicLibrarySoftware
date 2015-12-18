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
public class BookDuplicate {
    private ArrayList<String> title;
    private String accessionNumber;
    private ArrayList<String> authorName;
    private String sectionName;
    private String categoryName;
    private String publisher;
    private boolean availability;

    public BookDuplicate() {
    }

    public BookDuplicate(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }


    public BookDuplicate(ArrayList<String> title, String accessionNumber, ArrayList<String> authorName, String sectionName, String categoryName, String publisher, boolean availability) {
        this.title = title;
        this.accessionNumber = accessionNumber;
        this.authorName = authorName;
        this.sectionName = sectionName;
        this.categoryName = categoryName;
        this.publisher = publisher;
        this.availability = availability;
    }

    
    
    /**
     * @return the title
     */
    public ArrayList<String> getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(ArrayList<String> title) {
        this.title = title;
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
     * @return the authorName
     */
    public ArrayList<String> getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public void setAuthorName(ArrayList<String> authorName) {
        this.authorName = authorName;
    }

    /**
     * @return the sectionName
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * @param sectionName the sectionName to set
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the availability
     */
    public boolean isAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    
}