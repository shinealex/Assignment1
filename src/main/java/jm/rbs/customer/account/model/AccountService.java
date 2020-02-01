package jm.rbs.customer.account.model;

import jm.rbs.customer.account.excception.CustomException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private List<Account> accounts = new ArrayList<>( Arrays.asList(
            new Account("100", "Scott", 1500),
            new Account("101", "Jaffer", 1500),
            new Account("102", "Shine", 500),
            new Account("103", "Limy", 300)
    ));


    public List<Account> getAccounts() {
        return accounts;
    }

    public Double getBalance(String id) throws CustomException {
        return accounts
                .stream()
                .filter(t -> t.getAccountNumber().equalsIgnoreCase(id))
                .findAny()
                .map(account ->  account.getBalance())
                .orElseThrow(()-> new CustomException(
                "Id is not existing",
                "You've entered an incorrect account Number, try again with correct one 100, 101 or 102",
                "Validate the given Input",
                "Please try with 100 or 101",
                "mail to shinekuttiadi@gmail.com"));

        /* TODO The hard coded values has to be moved form this class!!! */
    }

    public void withdrawAmount(String id, double amount) throws CustomException {

        Account account = getAccount(id);

        if(account.getBalance() - amount > 0)
            account.setBalance(account.getBalance() - amount);
        else
        throw new CustomException(
                "Insufficient balance !!",
                "Please top up your account",
                "Check the withdrawal Account",
                "Please try with amount less than balance",
                "Visit the near By Deposit machine to deposit cash");

        /* TODO The hard coded values has to be moved form this class!!! */
    }


    public void depositAmount(String id, double amount) throws CustomException {

        Account account = getAccount(id);

        if(amount > 0)
            account.setBalance(account.getBalance() + amount);
        else
            throw new CustomException(
                    "Amount balance should be greater than zero!!",
                    "Please check the input value",
                    "Check the Deposit Account",
                    "Please try with £10",
                    "mail shinekuttiadi@gmail.com for more details");
    }


    public void addAccount(Account account) throws CustomException {
        if(accounts.contains(account))
            throw new CustomException(
                    "Account is already Existing",
                    "Please check the input values",
                    "Check the Account Number",
                    "Please try with New account Name",
                    "mail shinekuttiadi@gmail.com for more details");
        else
            accounts.add(account);
    }


    private Account getAccount(String id ) throws CustomException {
        return   accounts
                .stream()
                .filter(t -> t.getAccountNumber().equalsIgnoreCase(id))
                .findAny()
                .orElseThrow(() -> new CustomException(
                        "Id is not existing",
                        "You've entered an incorrect account Number, try again with correct one 100, 101 or 102",
                        "Validate the given Input",
                        "Please try with 100 or 101",
                        "mail to shinekuttiadi@gmail.com"));

        /* TODO The hard coded values has to be moved form this class!!! */
    }

}
