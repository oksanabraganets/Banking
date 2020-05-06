package org.example.controller.command;

import org.example.controller.exception.AccountNotExist;
import org.example.controller.exception.NotEnoughMoneyException;
import org.example.model.entity.Account;
import org.example.model.entity.TransferBuilder;
import org.example.model.entity.TransferData;
import org.example.model.entity.User;
import org.example.model.service.TransferService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class Transfer implements Command {

    private static final String NUMBER = "[0-9 ]{1,10}";

    TransferService transferService;

    public Transfer(TransferService transferService) {
        this.transferService = transferService;
    }

    public String execute(HttpServletRequest request) {
        String source = request.getParameter("source");
        String dest = request.getParameter("dest");
        String amount = request.getParameter("amount");

        if( source == null || source.equals("")
            || dest == null || dest.equals("")
            || amount == null || amount.equals("")){
            return "/WEB-INF/user/transfer.jsp";
        }
        System.out.println(source + " " + dest + " " + amount);

        if (!(dest.matches(NUMBER) && amount.matches(NUMBER))) return "/WEB-INF/user/transfer.jsp";
        int sourceAccount = Integer.parseInt(source);
        int destAccount = Integer.parseInt(dest);
        int transferAmount = Integer.parseInt(amount);

            isEnoughMoney(request, sourceAccount, transferAmount);


        TransferData transferData = new TransferBuilder()
                .sourceId(sourceAccount)
                .destId(destAccount)
                .amount(transferAmount)
                .date(new java.sql.Date(System.currentTimeMillis()))
                .type(TransferData.TYPE.TRANSFER)
                .build();
        transferService.transferMoney(transferData);
        return "/WEB-INF/user/transfer.jsp";
    }

    private void isEnoughMoney(HttpServletRequest request, int sourceId, int amount)
            throws AccountNotExist, NotEnoughMoneyException{
        User user = (User) request.getSession().getAttribute("user");
        Account account =
                user.getAccounts().stream()
                        .filter(x -> (sourceId == x.getId()))
                        .findFirst()
                        .orElseThrow(AccountNotExist::new);

        if (account.getAvailableMoney() < amount) throw new NotEnoughMoneyException();
    }
}
