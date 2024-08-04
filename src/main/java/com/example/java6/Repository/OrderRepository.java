package com.example.java6.Repository;

import com.example.java6.Entity.store.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Object> {
}
