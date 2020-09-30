/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.registerLogin;

import core.UseCase;
import domain.usecases.login.register.RegisterRequestModel;
import domain.usecases.login.register.RegisterResponseModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor Budal
 */
public class RegisterPresenter {
//    private LoginView view;
//    private final UseCase<LoginRequestModel,LoginResponseModel> useCase;
//    private RegisterPresenter registerPresenter = new RegisterPresenter();
    private RegisterView view = new RegisterView(this);
    private final UseCase<RegisterRequestModel,RegisterResponseModel> useCase;
    
    
    public RegisterPresenter(UseCase<RegisterRequestModel,RegisterResponseModel> useCase) {
        this.useCase=useCase;
    }
    public void initView(){
        view.setVisible(true);
    }
    
    public void registerUser(){
        String name=view.getNameFiel();
        String login= view.getLoginField();
        String password= view.getPasswordField();
        if (name.length()<3 || login.length()<3) {
           
            return;
        }
        
        RegisterRequestModel request = new RegisterRequestModel();
        request.setLogin(login);
        request.setName(name);
        request.setPassword(password);
        RegisterResponseModel response= useCase.execute(request);
        if(response.isCreated()){
            JOptionPane.showMessageDialog(view, "Ocorreu um erro tente novamente");
        }else{
            view.setVisible(false);
        }
        
        
    }
    
    
}
