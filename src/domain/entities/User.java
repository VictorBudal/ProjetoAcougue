/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

/**
 *
 * @author Victor Budal
 */
public class User {

    public String getPassword() {
        return password;
    }

    private final String name;
    private final String login;
    private final String password;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public boolean passwordValidator(String password) {
        return this.password.equals(password);
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }
    
}
