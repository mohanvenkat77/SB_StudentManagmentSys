package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Employe;
import com.example.backend.repository.repository;

@Service
public class empService {

    @Autowired
    private repository repository;

    public Employe saveEmploye(Employe employe) {
         repository.save(employe);
         return employe;
    }
    
}
