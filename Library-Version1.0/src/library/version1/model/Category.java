/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

/**
 *
 * @author Neo_
 */
public class Category {
    private String id;
    private String name;
    private String dewyNumber;

    public Category() {
    }

    public Category(String id, String name, String dewyNumber) {
        this.id = id;
        this.name = name;
        this.dewyNumber = dewyNumber;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the dewyNumber
     */
    public String getDewyNumber() {
        return dewyNumber;
    }

    /**
     * @param dewyNumber the dewyNumber to set
     */
    public void setDewyNumber(String dewyNumber) {
        this.dewyNumber = dewyNumber;
    }
    
   
    
    
}
