/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local;

import domain.entities.Lot;
import domain.gateways.LotRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Budal
 */
public class LotRepositoryInMemory implements LotRepository {

    private final List<Lot> listLot= new ArrayList<>(); ;
    
    public LotRepositoryInMemory() {
        
        Lot lot = new Lot("Victor", 1500, 1200,50);
        listLot.add(lot);
        lot = new Lot("Budal", 1500, 1200,50);
        listLot.add(lot);
        lot = new Lot("Moreira", 1500, 1200,50);
        listLot.add(lot);
    }
    

    @Override
    public boolean createLot(Lot lot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lot> takeAllLot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletLot(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateLot(Lot lot) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lot> readForName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   

    

}
