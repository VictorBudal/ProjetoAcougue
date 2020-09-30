/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.usecases.login.register;

/**
 *
 * @author Victor Budal
 */
public class RegisterResponseModel {
     private String name;
     private boolean created;

    public boolean isCreated() {
        return created;
    }

    public void setIsCreated(boolean isCreated) {
        this.created = isCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
