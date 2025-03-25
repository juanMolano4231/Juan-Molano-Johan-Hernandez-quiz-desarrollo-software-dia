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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @PutMapping("/{id}")
    public ResponseEntity<Motocicleta> actualizarMotocicleta(@PathVariable String id,
            @RequestBody Motocicleta motocicleta) {
        Motocicleta mExistente = service.findById(id);
        if (mExistente != null) {
            motocicleta.setId(id);
            Motocicleta mActualizada = service.update(motocicleta);
            return new ResponseEntity<>(mActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
  
    @PostMapping
    public ResponseEntity<Motocicleta> createMotocicleta(@RequestBody Motocicleta motocicleta) {
        Motocicleta newMotocicleta = service.save(motocicleta);
        return new ResponseEntity<>(newMotocicleta, HttpStatus.CREATED);

    }
    
    @DeleteMapping("/{id}")
	  public ResponseEntity<Void> deleteUsuario(@PathVariable String id) {
		Motocicleta mExistente = service.findById(id);
		if (mExistente != null) {
			service.delete(mExistente);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    

    @GetMapping("/buscar")
    public ResponseEntity<Motocicleta> buscarPorPlaca(@RequestParam String placa) {
        Motocicleta motocicleta = service.buscarPorPlaca(placa);
        return new ResponseEntity<>(motocicleta, HttpStatus.OK);
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<Motocicleta>> buscarMotocicletas(@RequestParam(required = false) int cilindraje) {
        List<Motocicleta> motocicletas = service.buscarPorFiltros(cilindraje);
        return new ResponseEntity<>(motocicletas, HttpStatus.OK);
    }

}
