package domain.usecases.login;

import core.UseCase;
import domain.gateways.UsersRepository;
import domain.entities.User;

/**
 *
 * @author Victor Budal
 */
public class UseCaseLogin implements UseCase<LoginRequestModel, LoginResponseModel> {

    private final UsersRepository usersRepository;

    public UseCaseLogin(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;

    }

    @Override
    public LoginResponseModel execute(LoginRequestModel arg) {
        String login = arg.getLogin();
        String password = arg.getPassword();

        User user = this.usersRepository.retrieveUserByLogin(login);
        
        if (user != null) {
            boolean isPasswordValid = user.passwordValidator(password);
            if (isPasswordValid) {
                LoginResponseModel response = new LoginResponseModel();

                response.setName(user.getName());
                response.setLogin(user.getLogin());
                
                return response;
            }
        }
        return null;
    }

}
