package com.devintech.prueba.Repository;

import com.devintech.prueba.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
