package com.ENSA.JIBI.repository;

import com.ENSA.JIBI.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
    Compte findByRib(String rib);
}
