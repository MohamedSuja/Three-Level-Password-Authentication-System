/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package three.level.password.authentication.system;

/**
 *
 * @author Suja Mohamed
 */
public class tablelist {
    
    String id,name,ia;

    public tablelist(String id, String name, String ia) {
        this.id = id;
        this.name = name;
        this.ia = ia;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIa() {
        return ia;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIa(String ia) {
        this.ia = ia;
    }
    
    
    
}
