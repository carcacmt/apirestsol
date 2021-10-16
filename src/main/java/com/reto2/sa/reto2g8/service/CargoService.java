/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.service;

import com.reto2.sa.reto2g8.entity.Cargo;
import com.reto2.sa.reto2g8.entity.Cargo;
import com.reto2.sa.reto2g8.repository.CargoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class CargoService {
      @Autowired
    private CargoRepository repository;
    
    public Cargo saveCargo(Cargo cargo){
        return repository.save(cargo);
    }
    
    public List<Cargo> getCargos(){
        return repository.findAll();
    }
    
    public Cargo getCargoById(int id){
        return repository.findById(id).orElse(null);
    }
    
    public Cargo updateCargo(Cargo cargo){
        
        Cargo existeCargo=getCargoById(cargo.getId_cargo());
        existeCargo.setNomcargo(cargo.getNomcargo());
        existeCargo.setSalario(cargo.getSalario());
        existeCargo.setDepartamento(cargo.getDepartamento());
        return repository.save(existeCargo);        
    }
    
    public void deleteCargo(int id){
        repository.deleteById(id);
    }

}
