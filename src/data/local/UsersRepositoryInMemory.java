/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local;

import domain.entities.User;
import domain.gateways.UsersRepository;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Victor Budal
 */
public class UsersRepositoryInMemory implements UsersRepository {
    private  Map<String,User> users;
    
    public UsersRepositoryInMemory(){
        this.users=new HashMap<>();
        users.put("Victor", new User("Victor", "Victor Budal", "1234"));
        users.put("Joao", new User("Joao", "Joao da Silva", "senha"));
        users.put("Rafael", new User("Rafael", "Rafael da Cunha", "forget"));
    }
    
   
    @Override
    public User retrieveUserByLogin(String login){
       return users.get(login);
    }

    @Override
    public Boolean createLogin(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
}
