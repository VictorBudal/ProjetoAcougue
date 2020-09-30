/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.connection.ConnectionFactory;
import domain.entities.User;
import domain.gateways.UsersRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Victor Budal
 */
public class UserDAO implements UsersRepository {

    private boolean isCreated = false;

    private boolean create(User user) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        if(!loginExist(user.getLogin())){
            return false;
        }

        try {
            stmt = con.prepareStatement("INSERT INTO user (username,login,password)VALUES(?,?,?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();
            return  true;
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }

    private User searchLogin(String login) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs= null;
        try {
            stmt= con.prepareStatement("SELECT * FROM user ");
            rs=stmt.executeQuery();
            
            while (rs.next()) {
                String loginsBD= rs.getString("login");
               
              if(loginsBD.equals(login)){
                  User user = new User(rs.getString("username"), login, rs.getString("password"));
                  return user;
              }
                
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um erro"+e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return null;
    }
    private boolean loginExist(String login) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs= null;
        try {
            stmt= con.prepareStatement("SELECT * FROM user ");
            rs=stmt.executeQuery();
            
            while (rs.next()) {
                String loginsBD= rs.getString("login");
               
              if(loginsBD.equals(login)){
                  User user = new User(rs.getString("username"), login, rs.getString("password"));
                  return true;
              }
                
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um erro"+e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return false;
    }

    @Override
    public User retrieveUserByLogin(String login) {
        return searchLogin(login);
    }

    @Override
    public Boolean createLogin(User user) {
        
        return create(user);
    }
}
