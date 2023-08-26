package com.devintech.prueba.Repository;

import com.devintech.prueba.Entity.Client;
import com.devintech.prueba.Entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {
    List<Quotation> findByClient(Client client);
}
