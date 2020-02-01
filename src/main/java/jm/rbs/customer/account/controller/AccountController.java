package jm.rbs.customer.account.controller;

import jm.rbs.customer.account.excception.CustomException;
import jm.rbs.customer.account.model.Account;
import jm.rbs.customer.account.model.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/getAccounts")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("getBalance/{id}")
    public Double getBalance(@PathVariable String id)  throws CustomException {
        return accountService.getBalance(id);
    }

    @GetMapping("withdrawAmount/{id}/{amount}")
    @ResponseStatus(value = HttpStatus.OK)
    public void withdrawAmount(@PathVariable String id, @PathVariable Double amount) throws CustomException {
        accountService.withdrawAmount(id,amount);
    }

    @GetMapping("deposit/{id}/{amount}")
    @ResponseStatus(value = HttpStatus.OK)
    public void depositAmount(@PathVariable String id, @PathVariable Double amount) throws CustomException {
        accountService.depositAmount(id,amount);
    }

    @PostMapping("addAccount")
    @ResponseStatus(value = HttpStatus.OK)
    public void addAccount(@RequestBody Account account) throws CustomException {
        accountService.addAccount(account);
    }

}



