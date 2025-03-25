/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.QuizAPIREST;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan José Molano
 */

@Service
public class MotocicletaService {
    private final MotocicletaRepository repository;
    
    @Autowired
    public MotocicletaService(MotocicletaRepository repository) {
        this.repository = repository;
        initSampleData();
    }
    
    private void initSampleData() {
        Motocicleta m1 = new Motocicleta("Honda", "KDW-23A", 125, 3000000, "negro");
        Motocicleta m2 = new Motocicleta("Yamaha", "JKG-73B", 300, 7000000, "amarillo");
        save(m1);
        save(m2);
    }
    
    public Motocicleta save(Motocicleta m) {
        return repository.save(m);
    }
    
    public List<Motocicleta> getAllMotocicletas() {
        return repository.getAllMotocicletas();
    }
    
    public Motocicleta buscarPorPlaca(String placa) {
        return repository.buscarPorPlaca(placa);
    }
    
}
