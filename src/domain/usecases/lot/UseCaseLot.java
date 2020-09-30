/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.usecases.lot;

import core.UseCase;
import domain.entities.Lot;
import domain.gateways.LotRepository;
import java.util.List;

/**
 *
 * @author Victor Budal
 */
public class UseCaseLot implements UseCase<LotRequestModel, LotResponseModel> {

    private LotRepository lotRepository;

    public UseCaseLot(LotRepository lotRepository) {
        this.lotRepository = lotRepository;

    }

    @Override
    public LotResponseModel execute(LotRequestModel arg) {
        LotResponseModel response = new LotResponseModel();
        if (arg.isTable()) {
            List<Lot> listlot = lotRepository.takeAllLot();

            response.setListLot(listlot);
            return response;
        } else if (arg.isUpdate()) {
            Lot lot = new Lot();
            lot.setName(arg.getName());
            lot.setPrice(arg.getPrice());
            lot.setWeight(arg.getWeight());
            lot.setAmount(arg.getAmount());
            lot.setId(arg.getId());
            if (lotRepository.updateLot(lot)) {
                response.setMensage("Concluido com sucesso");
            } else {
                response.setMensage("Não foi possivel concluir essa ação");
            }

            return response;
        } else if (arg.isSearch()) {

            response.setListLot(lotRepository.readForName(arg.getName()));
            return response;
        } else if (arg.isCreate()) {
            Lot lot = new Lot();
            
            lot.setName(arg.getName());
            lot.setPrice(arg.getPrice());
            lot.setWeight(arg.getWeight());
            lot.setAmount(arg.getAmount());
            if (lotRepository.createLot(lot)) {
                response.setMensage("Concluido com sucesso");
            } else {
                response.setMensage("Não foi possivel concluir essa ação");
            }
            return response;

        } else {
            if (lotRepository.deletLot(arg.getId())) {
                response.setMensage("Concluido com sucesso");
            } else {
                response.setMensage("Não foi possivel concluir essa ação");
            }
            return response;
        }

    }

}
