package presentation.effectLogin;

import presentation.registerLogin.RegisterPresenter;
import domain.usecases.login.LoginRequestModel;
import domain.usecases.login.LoginResponseModel;
import core.UseCase;
import javax.swing.JOptionPane;
import presentation.MainPresenter;

/**
 *
 * @author Victor Budal
 */
public class LoginPresenter {

    private LoginView view;
    private final UseCase<LoginRequestModel,LoginResponseModel> useCase;
    private final RegisterPresenter registerPresenter;
    private MainPresenter mainPresenter;

    public LoginPresenter( UseCase<LoginRequestModel,LoginResponseModel> useCase,RegisterPresenter registerPresenter,MainPresenter mainPresenter) {
        this.registerPresenter=registerPresenter;
        this.view = new LoginView(this);
        this.useCase = useCase;
        this.mainPresenter=mainPresenter;
    }
    public void registerView(LoginView view){
        this.view=view;
    }
    

    public void authentic() {
        String user = view.getLogin();
        String password = view.getPassword();

        if (user.length() < 3 || password.length() < 3) {
            return;
        }

        LoginRequestModel request = new LoginRequestModel();
        request.setLogin(user);
        request.setPassword(password);

        LoginResponseModel response = useCase.execute(request);

        if (response != null) {
            JOptionPane.showMessageDialog(view, response.getName() + ", Seja bem vindo!");
            view.clearTextBoxes();
            view.setVisible(false);
            mainPresenter.setId(response.getId());
            mainPresenter.setUserName(response.getName());
            mainPresenter.initMenuView();
            

        } else {
            JOptionPane.showMessageDialog(view, "Falha na autenticação!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cancel() {
        view.clearTextBoxes();
    }

    public void start() {
        view.setVisible(true);
    }
    
    public void registerUser(){
       registerPresenter.initView();
    }
}
