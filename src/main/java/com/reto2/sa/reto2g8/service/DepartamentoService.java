/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.service;

import com.reto2.sa.reto2g8.entity.Departamento;
import com.reto2.sa.reto2g8.repository.DepartamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class DepartamentoService {
      @Autowired
    private DepartamentoRepository repository;
    
    public Departamento saveDepartamento(Departamento departamento){
       return repository.save(departamento);
    }
    
    public List<Departamento> getDepartamentos(){
        return repository.findAll();
    }
    
    public Departamento getDepartamentoById(int id){
        return repository.findById(id).orElse(null);
    }
    
    public Departamento updateDepartamento(Departamento departamento){
        Departamento existeDepartamento=getDepartamentoById(departamento.getId_dep());
        existeDepartamento.setNomdep(departamento.getNomdep());
        existeDepartamento.setStartDate(departamento.getStartDate());
        existeDepartamento.setEndDate(departamento.getEndDate());
        return repository.save(existeDepartamento);
    }
    
    public void deleteDepartamento(int id){
        repository.deleteById(id);
    }
    
      
 
}
