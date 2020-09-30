
import domain.usecases.login.LoginRequestModel;
import domain.usecases.login.LoginResponseModel;
import core.UseCase;
import data.dao.LotDAO;
import data.dao.UserDAO;
import data.local.LotRepositoryInMemory;
import domain.gateways.LotRepository;
import domain.usecases.login.UseCaseLogin;
import domain.gateways.UsersRepository;
import domain.usecases.lot.UseCaseLot;
import domain.usecases.login.register.RegisterRequestModel;
import domain.usecases.login.register.RegisterResponseModel;
import domain.usecases.login.register.UseCaseRegister;
import domain.usecases.lot.LotRequestModel;
import domain.usecases.lot.LotResponseModel;
import presentation.MainPresenter;

import presentation.effectLogin.LoginPresenter;
import presentation.registerLogin.RegisterPresenter;

/**
 *
 * @author Victor Budal
 */
public class Program {

    public static void main(String[] args) {
        initLogin();
        

    }

    private static void initLogin() {
        UsersRepository repository = new UserDAO();
        LotRepository respositoryLot = new LotDAO();
      
        UseCase<LotRequestModel, LotResponseModel> useCaseLot = new UseCaseLot(respositoryLot);
        UseCase<LoginRequestModel, LoginResponseModel> useCase = new UseCaseLogin(repository);
        UseCase<RegisterRequestModel, RegisterResponseModel> registerUseCase = new UseCaseRegister(repository);
        MainPresenter mainPresenter = new MainPresenter(useCaseLot);
        RegisterPresenter registerPresenter = new RegisterPresenter(registerUseCase);
        LoginPresenter presenter = new LoginPresenter(useCase, registerPresenter,mainPresenter);

        presenter.start();
    }

 
}
