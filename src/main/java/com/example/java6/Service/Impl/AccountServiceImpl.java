package com.example.java6.Service.Impl;

import com.example.java6.Entity.store.Account;
import com.example.java6.Repository.AccountRepository;
import com.example.java6.Service.AccountService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountByUsername(String username) throws NotFoundException {
        return accountRepository.findById(username)
                .orElseThrow(() -> new NotFoundException("Account " + username + " không tồn tại"));
    }

    @Override
    public void addAccount(Account account) {
        if (accountRepository.existsById(account.getUsername())) {
            throw new IllegalArgumentException("Account " + account.getUsername() + " đã tồn tại");
        }
        accountRepository.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        if (!accountRepository.existsById(account.getUsername())) {
            throw new IllegalArgumentException("Account " + account.getUsername() + " không tồn tại");
        }
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String username) {
        if (!accountRepository.existsById(username)) {
            throw new IllegalArgumentException("Account " + username + " không tồn tại");
        }
        accountRepository.deleteById(username);
    }

}
