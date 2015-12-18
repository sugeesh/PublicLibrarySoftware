/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.model;

/**
 *
 * @author Neo_
 */
public class Publisher {
    private String id;
    private String name;

    public Publisher() {
    }

    public Publisher(String id, String name) {
        this.id = id;
        this.name = name;
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
    
    
}
