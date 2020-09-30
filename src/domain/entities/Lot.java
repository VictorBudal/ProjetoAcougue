package domain.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Budal
 */
public class Lot {

    private String name;
    private int id;
    private float price;
    private boolean status;
    private List listMeat = new ArrayList<>();
    private float weight;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Lot(String name, int id, float price,float weight) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.status = true;
        this.weight=weight;
    }

    public Lot() {
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List getListMeat() {
        return listMeat;
    }

    public void setListMeat(List listMeat) {
        this.listMeat = listMeat;
    }

    
}
