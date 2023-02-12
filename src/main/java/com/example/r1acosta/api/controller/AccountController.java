package com.example.r1acosta.api.controller;

import com.example.r1acosta.api.model.Account;
import com.example.r1acosta.api.service.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountRepository repo;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.repo = accountRepository;
    }

    private static class LocalAccount {
        public String nombreCliente;
        public float saldo;
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody String AddAccount(@RequestBody LocalAccount body) {
        Account nuevaCuenta = new Account();

        nuevaCuenta.clientName = body.nombreCliente;
        nuevaCuenta.balance = body.saldo;
        repo.save(nuevaCuenta);

        return "Cuenta creada con éxito.";
    }

    @GetMapping("")
    public @ResponseBody Iterable<Account> GetAllAccounts() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    public @ResponseBody Account GetAccount(@PathVariable int id) {
        if (repo.findById(id).isPresent())
            return repo.findById(id).get();

        return null;
    }

    @DeleteMapping("{id}")
    public @ResponseBody String DeleteAccount(@PathVariable int id) {
        if (repo.findById(id).isEmpty())
            return "No hay cuenta con id " + id;

        Account account = repo.findById(id).get();

        if (!account.accountState)
            return "La cuenta ya fue eliminada.";

        account.accountState = false;
        repo.save(account);

        return "Cuenta eliminada con éxito.";
    }

    @PutMapping("{id}")
    public @ResponseBody String ModifyBalance(@PathVariable int id, @RequestBody LocalAccount body) {
        if (repo.findById(id).isEmpty())
            return "No hay cuenta con id " + id;

        Account account = repo.findById(id).get();

        if (!account.accountState)
            return "No se puede modificar los datos de una cuenta desactivada.";
        if (account.balance + body.saldo < 0)
            return "No puede tener números negativos en la cuenta.";

        account.balance += body.saldo;
        repo.save(account);

        return "Saldo actualizado con éxito.";
    }
}
