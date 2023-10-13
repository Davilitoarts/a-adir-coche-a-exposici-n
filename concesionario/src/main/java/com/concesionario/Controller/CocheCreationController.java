package com.concesionario.Controller;
import com.concesionario.Domain.Coche;
import com.concesionario.Domain.InvalidArgumentException;

import com.concesionario.Service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.concesionario.Domain.Coche;
import com.concesionario.Domain.InvalidArgumentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coches")
public class CocheCreationController {

    @Autowired
    private CocheService cocheService;

    @PostMapping("/coches/agregar")
    public ResponseEntity<String> agregarCoche(@RequestBody CocheOutput cocheOutput) {
        try {
            cocheService.agregarCoche(new Coche(cocheOutput.getMatricula(), cocheOutput.getMarca(), cocheOutput.getModelo(), cocheOutput.getAnyo()));
            return ResponseEntity.status(HttpStatus.CREATED).body("Coche agregado a la exposición correctamente.");
        } catch (InvalidArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al agregar el coche: " + e.getMessage());
        }
    }
}
