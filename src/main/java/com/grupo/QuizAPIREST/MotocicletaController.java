/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.QuizAPIREST;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan José Molano
 */

@RestController
@RequestMapping("/api/motocicletas")
public class MotocicletaController {
    private final MotocicletaService service;
    
    @Autowired
    public MotocicletaController(MotocicletaService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Motocicleta>> getAllMotocicletas() {
        List<Motocicleta> motocicletas = service.getAllMotocicletas();
        return new ResponseEntity<>(motocicletas, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Motocicleta> createMotocicleta (@RequestBody Motocicleta motocicleta) {
        Motocicleta newMotocicleta = service.save(motocicleta);
        return new ResponseEntity<>(newMotocicleta, HttpStatus.CREATED);
    }
}
