/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.usecases.lot;

import domain.entities.Lot;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Budal
 */
public class LotResponseModel {

    private int id;
    private String name;
    private float price;
    private float weight;
    private int amount;
    private List<Lot> listLot;
    private String mensage;

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
    

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public List<Lot> getListLot() {
        return listLot;
    }

    public void setListLot(List<Lot> listLot) {
        this.listLot = listLot;
    }

    public List<String> getListName() {
        List<String> names = new ArrayList<>();
        listLot.forEach((lot) -> {
            names.add(lot.getName());
        });

        return names;

    }

    public List<Float> getListPrices() {
        List<Float> prices = new ArrayList<>();
        listLot.forEach((lot) -> {
            prices.add(lot.getPrice());
        });

        return prices;
    }

    public List<Float> getListWeight() {
        List<Float> weights = new ArrayList<>();
        listLot.forEach((lot) -> {
            weights.add(lot.getWeight());
        });

        return weights;
    }

    public List<Integer> getListId() {
        List<Integer> ids = new ArrayList<>();
        listLot.forEach((lot) -> {
            ids.add(lot.getId());
        });

        return ids;
    }
    public List<Integer> getListAmount() {
        List<Integer> amount = new ArrayList<>();
        listLot.forEach((lot) -> {
            amount.add(lot.getAmount());
        });

        return amount;
    }
}
