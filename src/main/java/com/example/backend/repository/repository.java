package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Employe;

@Repository
public interface repository extends JpaRepository<Employe,Long> {
    
}
