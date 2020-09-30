package domain.gateways;

import domain.entities.Lot;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor Budal
 */
public interface LotRepository {
    boolean createLot (Lot lot);
    List<Lot> takeAllLot ();
    boolean deletLot(int id);
    boolean updateLot(Lot lot);
    List<Lot>  readForName(String  name);
}
