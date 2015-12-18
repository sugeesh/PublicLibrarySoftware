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
public class Book {
    private String accessionNumber;
    private ArrayList<BookTitle> title;
    private ArrayList<BookAuthorDetail> author;
    private String publishedYear;
    private String publisherId;
    private double price;
    private String categoryId;
    private BookPosition bookPosition;
    private boolean availability;
    private String publishedPlace;
    private boolean donation;
    private boolean expired;

    public Book() {
    }

    public Book(String accessionNumber, ArrayList<BookTitle> title, ArrayList<BookAuthorDetail> author, String publishedYear, String publisherId, double price, String categoryId, BookPosition bookPosition, boolean availability, String publishedPlace, boolean donation, boolean expired) {
        this.accessionNumber = accessionNumber;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.publisherId = publisherId;
        this.price = price;
        this.categoryId = categoryId;
        this.bookPosition = bookPosition;
        this.availability = availability;
        this.publishedPlace = publishedPlace;
        this.donation = donation;
        this.expired = expired;
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
    public ArrayList<BookTitle> getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(ArrayList<BookTitle> title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public ArrayList<BookAuthorDetail> getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(ArrayList<BookAuthorDetail> author) {
        this.author = author;
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
     * @return the publisherId
     */
    public String getPublisherId() {
        return publisherId;
    }

    /**
     * @param publisherId the publisherId to set
     */
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
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

    /**
     * @return the bookPosition
     */
    public BookPosition getBookPosition() {
        return bookPosition;
    }

    /**
     * @param bookPosition the bookPosition to set
     */
    public void setBookPosition(BookPosition bookPosition) {
        this.bookPosition = bookPosition;
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

    
}
