package com.example.java6.Repository;

import com.example.java6.Entity.store.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    @Query("select a from Authority a where a.account.username = ?1")
    Authority findByUsername(String username);
}

