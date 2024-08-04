package com.example.java6.Service;

import com.example.java6.Entity.store.Account;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> findAllAccount();

    Account getAccountByUsername(String username) throws NotFoundException;

    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(String username);


}
