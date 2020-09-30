/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.usecases.login.register;

import core.UseCase;
import domain.entities.User;
import domain.gateways.UsersRepository;

/**
 *
 * @author Victor Budal
 */
public class UseCaseRegister implements UseCase<RegisterRequestModel, RegisterResponseModel> {

    private final UsersRepository usersRepository;

    public UseCaseRegister(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public RegisterResponseModel execute(RegisterRequestModel args) {

        User user = new User(args.getName(), args.getLogin(), args.getPassword());

        RegisterResponseModel response = new RegisterResponseModel();
        response.setName(user.getName());
        response.setIsCreated(usersRepository.createLogin(user));
        return response;

    }

}
