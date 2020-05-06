package org.example.model.dao.mapper;

import org.example.model.entity.Account;
import org.example.model.entity.CreditAccount;
import org.example.model.entity.DepositAccount;
import org.example.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

interface AccountTypeStrings{
    public static final String DEPOSIT = "DEPOSIT";
    public static final String CREDIT = "CREDIT";
}

public class AccountMapper implements ObjectMapper<Account> {

    public Account extractFromResultSet(ResultSet rs) throws SQLException {
        AccountMaker maker;
        if (rs.getString("type").equals(AccountTypeStrings.DEPOSIT)){
            maker = new DepositMaker();
        } else{
            maker = new CreditMaker();
        }
        return maker.makeAccount(rs);
    }

    public Account makeUnique(Map<Integer, Account> cache, Account item) {
        return null;
    }
}

interface AccountMaker{
    Account makeAccount(ResultSet rs) throws SQLException ;
}

class DepositMaker implements AccountMaker{
    public Account makeAccount(ResultSet rs) throws SQLException  {
        DepositAccount account = new DepositAccount();
        account.setId(rs.getInt("idaccount"));
        account.setBalance(rs.getInt("balance"));
        account.setValidity(rs.getDate("validity"));
        account.setDepositRate(rs.getInt("rate"));
        account.setDepositAmount(rs.getInt("amount"));
        return account;
    }
}

class CreditMaker implements AccountMaker{

    public Account makeAccount(ResultSet rs) throws SQLException {
        CreditAccount account = new CreditAccount();
        account.setId(rs.getInt("idaccount"));
        account.setBalance(rs.getInt("balance"));
        account.setValidity(rs.getDate("validity"));
        account.setCreditRate(rs.getInt("rate"));
        account.setDebt(rs.getInt("debt"));
        account.setAccrued(rs.getInt("accrued"));
        account.setCreditLimit(rs.getInt("credit_limit"));

        return account;
    }
}