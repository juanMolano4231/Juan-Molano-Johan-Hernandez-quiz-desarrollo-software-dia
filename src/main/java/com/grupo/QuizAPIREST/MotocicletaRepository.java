/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.QuizAPIREST;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan José Molano
 */

@Repository
public class MotocicletaRepository {
    
    private final List<Motocicleta> motocicletas = new ArrayList<>();
    
    public List<Motocicleta> getAllMotocicletas() {
        return new ArrayList<>(motocicletas);
    }
    
    public Motocicleta save(Motocicleta m) {
        motocicletas.add(m);
        return m;
    }
    
    public Motocicleta buscarPorPlaca(String placa) {
        for (Motocicleta m : motocicletas) {
            if (placa.equals(m.getPlacaMotocicleta())) {
                return m;
            }
        }
        return null;
    }
    
}
