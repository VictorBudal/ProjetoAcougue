/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local;

import domain.entities.User;
import domain.gateways.UsersRepository;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Budal
 */
public class UsersRepositoryInFile implements UsersRepository {

    @Override
    public User retrieveUserByLogin(String login) {
        URL url = UsersRepositoryInFile.class.getResource("Users.txt");
        Map<String,User> users = new HashMap<>();
        try {
            File file = new File(url.toURI());
            Scanner scan = new Scanner(file);

            while (scan.hasNext()) {

                String loginRead = scan.nextLine();
                String name = scan.nextLine();
                String password = scan.nextLine();

                User user = new User(name, loginRead, password);
                users.put(loginRead, user);
                return users.get(login);
            }

        } catch (URISyntaxException | FileNotFoundException ex) {
            Logger.getLogger(UsersRepositoryInFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public Boolean createLogin(User user) {
        
        return false;
    }
}
