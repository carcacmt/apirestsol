/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.controller;

import com.reto2.sa.reto2g8.entity.Departamento;
import com.reto2.sa.reto2g8.service.DepartamentoService;
import java.util.List;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Departamento/")   
public class DepartamentoController {
    
    @Autowired
    private DepartamentoService service;
    
    @GetMapping("/all")    
    public List<Departamento> findAllDepartamentos(){
        return service.getDepartamentos();
    }
    
    @GetMapping("/{id}")    
    public Departamento findDepartamentosId(@PathVariable int id){
        return service.getDepartamentoById(id);
    }
    
     @PostMapping("/save")
    public ResponseEntity addDepartamento(@RequestBody Departamento departamento){
        service.saveDepartamento(departamento);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateDepartamento(@RequestBody Departamento departamento){
        service.updateDepartamento(departamento);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartamento(@PathVariable int id){
       service.deleteDepartamento(id);
       return ResponseEntity.status(204).build();
    }

    
}
