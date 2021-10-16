/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.controller;

import com.reto2.sa.reto2g8.entity.Rol;
import com.reto2.sa.reto2g8.service.RolService;
import java.util.List;
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
@RequestMapping("/api/Rol/")   
public class RolController {
    
    @Autowired
    private RolService service;
    
    @GetMapping("/all")    
    public List<Rol> findAllRol(){
        return service.getRol();
    }
    
    @GetMapping("/{id}")    
    public Rol findRolId(@PathVariable int id){
        return service.getRolById(id);
    }
    
     @PostMapping("/save")
    public ResponseEntity addRol(@RequestBody Rol rol){
        service.saveRol(rol);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateRol(@RequestBody Rol rol){
        service.updateRol(rol);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRol(@PathVariable int id){
        service.deleteRol(id);
        return ResponseEntity.status(204).build();
    }
    
}
