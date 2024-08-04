package com.example.java6.Repository;

import com.example.java6.Entity.store.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Object> {

}
