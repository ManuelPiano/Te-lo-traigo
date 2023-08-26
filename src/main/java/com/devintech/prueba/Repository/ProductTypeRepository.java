package com.devintech.prueba.Repository;

import com.devintech.prueba.Entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
