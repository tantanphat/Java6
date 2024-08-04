package com.example.java6.API;

import com.example.java6.Entity.store.Authority;
import com.example.java6.Repository.AccountRepository;
import com.example.java6.Repository.AuthorityRepository;
import com.example.java6.Repository.RoleRepository;
import com.example.java6.Service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthorityAPI {


    @Autowired
    AuthorityRepository authorityDao;
    @Autowired
    RoleRepository roleDao;
    @Autowired
    AccountRepository accountDao;

    @GetMapping("/rest/authorities")
    public Map<String, Object> getAuthorities(){
        Map<String, Object> data = new HashMap<>();
        data.put("authorities", authorityDao.findAll());
        data.put("roles", roleDao.findAll());
        data.put("accounts", accountDao.findAll());
        return data;
    }
    @PostMapping("/rest/authorities")
    public Authority create(@RequestBody Authority authority){
        return authorityDao.save(authority);
    }
    @DeleteMapping("/rest/authorities/{id}")
    public void delete(@PathVariable("id") Integer id){
        authorityDao.deleteById(id);
    }

    @GetMapping("/rest/authoritie")
    public ResponseEntity<Authority> getAuthorityById(@RequestParam("username") String id){
        return ResponseEntity.ok(authorityDao.findByUsername(id));
    }
}
