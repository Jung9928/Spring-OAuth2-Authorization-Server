package com.example.repository;

import com.example.model.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<RegisterEntity, String> {
    Optional<RegisterEntity> findByClientId(String clientId);
}
