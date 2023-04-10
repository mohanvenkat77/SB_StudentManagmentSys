package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Employe;
import com.example.backend.repository.repository;
import com.example.backend.service.empService;

@CrossOrigin(origins = {"http://localhost:3000/","http://localhost:3000/editEmp/:id"})

@RestController
@RequestMapping("/api/v1/")
public class controller {
    @Autowired
    private repository repository;

    @Autowired
    private empService service;

    @GetMapping("/employes")
    public List<Employe> getAllEmployes(){
        return repository.findAll();
        
    }

    @PostMapping("/add/employe")
    public Employe saveEmploye(@RequestBody Employe employe){
        return  service.saveEmploye(employe);
    }

    
    @DeleteMapping("/delete/{id}")
    public void deleteEmploye(@PathVariable("id") Long id){
         repository.deleteById(id);
    }
    @GetMapping("/employes/{id}")
    public Employe getEmpId(@PathVariable("id") Long id){
        return repository.findById(id).get();
    }

    @PutMapping("/employes/{id}")
        public Employe updateEmp(@PathVariable("id") Long id,@RequestBody Employe employe){
            Employe employe2=repository.findById(id).get();
            employe2.setFirstName(employe.getFirstName());
            employe2.setLastname(employe.getLastname());
            employe2.setEmailId(employe.getEmailId());
            repository.save(employe2);
            return employe2;
        }
    
}
