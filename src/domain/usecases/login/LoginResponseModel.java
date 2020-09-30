/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.usecases.login;

import core.UseCase;
import domain.usecases.lot.LotRequestModel;
import domain.usecases.lot.LotResponseModel;
import java.util.List;

/**
 *
 * @author Victor Budal
 */
public class LoginResponseModel {

    private int id;
    private String name;
    private String login;
    private UseCase<LotRequestModel, LotResponseModel> useCaseLot;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UseCase<LotRequestModel, LotResponseModel> getUseCaseLot() {
        return useCaseLot;
    }

    public void setUseCaseLot(UseCase<LotRequestModel, LotResponseModel> useCaseLot) {
        this.useCaseLot = useCaseLot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
   
}
