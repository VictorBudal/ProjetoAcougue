/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.connection.ConnectionFactory;
import domain.entities.Lot;
import domain.gateways.LotRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Budal
 */
public class LotDAO implements LotRepository {

    @Override
    public boolean createLot(Lot lot) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO lot (name,price,weight,status,amount)VALUES(?,?,?,?,?)");

            stmt.setString(1, lot.getName());
            stmt.setFloat(2, lot.getPrice());
            stmt.setFloat(3, lot.getWeight());
            stmt.setString(4, "1");
            stmt.setInt(5, lot.getAmount());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    @Override
    public List<Lot> takeAllLot() {
        List<Lot> listLot = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM lot");
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("status").equalsIgnoreCase("1")) {
                    Lot lot = new Lot();
                    lot.setId(rs.getInt("id_lot"));
                    lot.setName(rs.getString("name"));
                    lot.setPrice(rs.getFloat("price"));
                    lot.setWeight(rs.getFloat("weight"));
                    lot.setAmount(rs.getInt("amount"));
                    listLot.add(lot);
                }
            }
            return listLot;
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    @Override
    public boolean deletLot(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Lot lotBanco = new Lot();
            stmt = con.prepareStatement("UPDATE lot SET status=? WHERE id_lot=? ");
            stmt.setString(1, "0");
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    @Override
    public boolean updateLot(Lot lot) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("UPDATE lot SET name=?,price=?,weight=?,amount=? WHERE id_lot=? ");

            stmt.setString(1, lot.getName());
            stmt.setFloat(2, lot.getPrice());
            stmt.setFloat(3, lot.getWeight());
            stmt.setInt(4, lot.getAmount());
            stmt.setInt(5, lot.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    @Override
    public List<Lot> readForName(String name) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            List<Lot> listLot = new ArrayList<>();
            stmt = con.prepareStatement("SELECT * FROM lot WHERE name LIKE ?");
            stmt.setString(1, "%" + name + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {

                if (rs.getString("status").equalsIgnoreCase("1")) {

                    Lot lot = new Lot();
                    lot.setId(rs.getInt("id_lot"));
                    lot.setName(rs.getString("name"));
                    lot.setPrice(rs.getFloat("price"));
                    lot.setWeight(rs.getFloat("weight"));
                    lot.setAmount(rs.getInt("amount"));
                    listLot.add(lot);
                }
            }
            return listLot;
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    
}
