/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto2.sa.reto2g8.service;

import com.reto2.sa.reto2g8.entity.Empleado;
import com.reto2.sa.reto2g8.repository.EmpleadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class EmpleadoService {
      @Autowired
    private EmpleadoRepository repository;
    
    public Empleado saveEmpleado(Empleado empleado){
       return repository.save(empleado);
    }
    
    public List<Empleado> getEmpleados(){
        return repository.findAll();
    }
    
    public Empleado getEmpleadoById(int id){
        return repository.findById(id).orElse(null);
    }
    
    public Empleado updateEmpleado(Empleado empleado){
        Empleado existeEmpleado=getEmpleadoById(empleado.getId_emp());
        existeEmpleado.setNombre(empleado.getNombre());
        existeEmpleado.setCargo(empleado.getCargo());
        existeEmpleado.setRol(empleado.getRol());
        return repository.save(existeEmpleado);
    }
    
    public void deleteEmpleado(int id){
        repository.deleteById(id);
    }
      

}
