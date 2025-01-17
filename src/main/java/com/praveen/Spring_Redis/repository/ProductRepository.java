package com.praveen.Spring_Redis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.Spring_Redis.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
