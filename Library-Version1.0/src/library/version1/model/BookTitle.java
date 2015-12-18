/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

/**
 *
 * @author Neo_
 */
public class BookTitle {
    private String accessionNumber;
    private String title;

    public BookTitle() {
    }

    public BookTitle(String accessionNumber, String title) {
        this.accessionNumber = accessionNumber;
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
