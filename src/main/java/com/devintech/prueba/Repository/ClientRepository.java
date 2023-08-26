package com.devintech.prueba.Repository;

import com.devintech.prueba.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
