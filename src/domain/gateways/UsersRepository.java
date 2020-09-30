package domain.gateways;

import domain.entities.User;

/**
 *
 * @author Victor Budal 
 */
public interface UsersRepository {
    User retrieveUserByLogin(String login);
    Boolean createLogin(User user);
}
