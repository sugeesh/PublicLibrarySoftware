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
public class BookAuthorDetail {

    private String AccessionNumber;
    private String AId;

    public BookAuthorDetail() {
    }

    public BookAuthorDetail(String AccessionNumber, String AId) {
        this.AccessionNumber = AccessionNumber;
        this.AId = AId;
    }

    /**
     * @return the AccessionNumber
     */
    public String getAccessionNumber() {
        return AccessionNumber;
    }

    /**
     * @param AccessionNumber the AccessionNumber to set
     */
    public void setAccessionNumber(String AccessionNumber) {
        this.AccessionNumber = AccessionNumber;
    }

    /**
     * @return the AId
     */
    public String getAId() {
        return AId;
    }

    /**
     * @param AId the AId to set
     */
    public void setAId(String AId) {
        this.AId = AId;
    }

 
}
