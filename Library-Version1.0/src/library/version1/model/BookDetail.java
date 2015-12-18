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
public class BookDetail {
    private String accessionNumber;
    private ArrayList<String> title;
    private ArrayList<String> authorName;
    private String publishedYear;
    private String publisherName;
    private double price;
    private String categoryName;
    private String sectionName;
    private String publishedPlace;
    private boolean donation;
    private boolean expired;

    public BookDetail() {
    }

    public BookDetail(String accessionNumber, ArrayList<String> title, ArrayList<String> authorName, String publishedYear, String publisherName, double price, String categoryName, String sectionName, String publishedPlace, boolean donation) {
        this.accessionNumber = accessionNumber;
        this.title = title;
        this.authorName = authorName;
        this.publishedYear = publishedYear;
        this.publisherName = publisherName;
        this.price = price;
        this.categoryName = categoryName;
        this.sectionName = sectionName;
        this.publishedPlace = publishedPlace;
        this.donation = donation;
    }

    
    public BookDetail(String accessionNumber, ArrayList<String> title, ArrayList<String> authorName, String publishedYear, String publisherName, double price, String categoryName, String sectionName) {
        this.accessionNumber = accessionNumber;
        this.title = title;
        this.authorName = authorName;
        this.publishedYear = publishedYear;
        this.publisherName = publisherName;
        this.price = price;
        this.categoryName = categoryName;
        this.sectionName = sectionName;
    }

    public BookDetail(String accessionNumber, ArrayList<String> authorName, String publishedYear, String publisherName, double price, String categoryName, String sectionName) {
        this.accessionNumber = accessionNumber;
        this.authorName = authorName;
        this.publishedYear = publishedYear;
        this.publisherName = publisherName;
        this.price = price;
        this.categoryName = categoryName;
        this.sectionName = sectionName;
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
     * @return the publishedYear
     */
    public String getPublishedYear() {
        return publishedYear;
    }

    /**
     * @param publishedYear the publishedYear to set
     */
    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    /**
     * @return the publisherName
     */
    public String getPublisherName() {
        return publisherName;
    }

    /**
     * @param publisherName the publisherName to set
     */
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
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
     * @return the publishedPlace
     */
    public String getPublishedPlace() {
        return publishedPlace;
    }

    /**
     * @param publishedPlace the publishedPlace to set
     */
    public void setPublishedPlace(String publishedPlace) {
        this.publishedPlace = publishedPlace;
    }

    /**
     * @return the donation
     */
    public boolean isDonation() {
        return donation;
    }

    /**
     * @param donation the donation to set
     */
    public void setDonation(boolean donation) {
        this.donation = donation;
    }

    /**
     * @return the expired
     */
    public boolean isExpired() {
        return expired;
    }

    /**
     * @param expired the expired to set
     */
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    /**
     * @return the accessionNumber
     */
    
}
