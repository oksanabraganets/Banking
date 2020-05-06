package org.example.model.service;

import org.example.controller.exception.NotEnoughMoneyException;
import org.example.model.dao.AccountDao;
import org.example.model.dao.DaoFactory;
import org.example.model.entity.Account;
import org.example.model.entity.TransferData;

public class TransferService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public void transferMoney(TransferData transferData){
        System.out.println(transferData);

        try (AccountDao dao = daoFactory.createAccountDao()) {
            Account source = dao.findById(transferData.getSourceId());
            Account dest = dao.findById(transferData.getDestId());
            if (source.getAvailableMoney() < transferData.getAmount()) throw new NotEnoughMoneyException();
            source.setBalance(source.getBalance() -  transferData.getAmount());
            dest.setBalance(dest.getBalance() + transferData.getAmount());
            System.out.println("Source updated : "+ source);
            dao.update(source);
            dao.update(dest);
        }
    }
}
