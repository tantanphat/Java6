package com.example.java6.Service.Impl;

import com.example.java6.Entity.store.Authority;
import com.example.java6.Repository.AuthorityRepository;
import com.example.java6.Service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;
    @Override
    public List<Authority> getAllAuthority() {
        return authorityRepository.findAll();
    }
}
