/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import core.UseCase;
import domain.usecases.lot.LotRequestModel;
import domain.usecases.lot.LotResponseModel;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor Budal
 */
public class MainPresenter {

    private DefaultTableModel modelLot;
    private DefaultTableModel modelMeat;
    private MainMenu view;
    private String userName;
    private int id;
    private UseCase<LotRequestModel, LotResponseModel> useCase;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setModelLot(DefaultTableModel modelLot) {
        this.modelLot = modelLot;
    }

    public void setModelMeat(DefaultTableModel modelMeat) {
        this.modelMeat = modelMeat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MainPresenter(UseCase<LotRequestModel, LotResponseModel> useCase) {
        this.view = new MainMenu(this);
        this.useCase = useCase;
    }

    public void initMenuView() {
        view.setVisible(true);
        initTableLot();
        setNameLabel();
    }

    private void initTableLot() {
        LotRequestModel request = new LotRequestModel();
        request.setTable(true);
        modelLot.setNumRows(0);
        LotResponseModel response = useCase.execute(request);
        List<String> names = response.getListName();
        List<Float> prices = response.getListPrices();
        List<Float> weigths = response.getListWeight();
        List<Integer> ids = response.getListId();
        List<Integer>amount = response.getListAmount();
        //adicionarLista de quantidade do response
        
        for (int i = 0; i < names.size(); i++) {
            modelLot.addRow(new Object[]{
                ids.get(i),
                names.get(i),
                amount.get(i),
                weigths.get(i),
                prices.get(i)

            });
        }

    }

    private void initTableSearch(LotResponseModel response) {

        modelLot.setNumRows(0);

        List<String> names = response.getListName();
        List<Float> prices = response.getListPrices();
        List<Float> weigths = response.getListWeight();
        List<Integer> ids = response.getListId();
        List<Integer>amount = response.getListAmount();
        //adicionarLista de quantidade do response
        
        for (int i = 0; i < names.size(); i++) {
            modelLot.addRow(new Object[]{
                ids.get(i),
                names.get(i),
                amount.get(i),
                weigths.get(i),
                prices.get(i)

            });
        }
    }

    private void setNameLabel() {
        JLabel label = view.getLabelUser();
        label.setText(userName);
    }

    void addLot() {
        LotRequestModel request = new LotRequestModel();
        request.setCreate(true);
        request.setName(view.getName());
        request.setPrice(view.getPriceLotField());
        request.setWeight(view.getWeightLotField());
        request.setAmount(view.getAmountLotField());
        LotResponseModel response = useCase.execute(request);
        initTableLot();
        showMessage(response.getMensage());
    }

    void editLot() {
        LotRequestModel request = new LotRequestModel();

        request.setUpdate(true);
        request.setName(view.getName());
        request.setPrice(view.getPriceLotField());
        request.setWeight(view.getWeightLotField());
        request.setAmount(view.getAmountLotField());
        request.setId(view.getId());
        LotResponseModel response = useCase.execute(request);
        System.out.println(response.getMensage());
        initTableLot();
    }
    void searchForName(String name){
        LotRequestModel request = new LotRequestModel();
        request.setName(name);
        request.setSearch(true);
        LotResponseModel response= useCase.execute(request);
        initTableSearch(response);
    }
    
    void deleteLot(){
        LotRequestModel request = new LotRequestModel();
        request.setId(view.getId());
        LotResponseModel response= useCase.execute(request);
        initTableLot();
    }

    private void showMessage(String mensage) {
        JOptionPane.showMessageDialog(view, mensage);
    }
}
