package com.ENSA.JIBI.repository;

import com.ENSA.JIBI.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    Agent findByUsername(String username);
    Agent findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
