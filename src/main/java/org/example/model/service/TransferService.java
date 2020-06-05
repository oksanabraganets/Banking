package org.example.model.service;

import org.example.controller.exception.NotEnoughMoneyException;
import org.example.model.dao.AccountDao;
import org.example.model.dao.DaoFactory;
import org.example.model.dao.TransferDao;
import org.example.model.entity.Account;
import org.example.model.entity.TransferData;


public class TransferService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    AccountDao dao = daoFactory.createAccountDao();

    public void addAmount(int accountId, int amount){
        Account account = dao.findById(accountId);
        System.out.println(account);
        if (account.getAvailableMoney() + amount < 0 )
            throw new NotEnoughMoneyException();
        account.setBalance(account.getBalance() + amount);
        dao.update(account);
        System.out.println(account);
    }

    public void transferMoney(TransferData transferData){
        System.out.println(transferData);
        TransferDao transferDao = daoFactory.createTransferDao();
        try{
            dao.getConnection().setAutoCommit(false);
            addAmount(transferData.getSourceId(), - transferData.getAmount());
            addAmount(transferData.getDestId(), transferData.getAmount());
            dao.getConnection().commit();
        }catch (Exception e){
            try { dao.getConnection().rollback(); } catch (Exception ignored){}
            throw new RuntimeException(e.getMessage());
        }
        try {
            transferDao.create(transferData);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
