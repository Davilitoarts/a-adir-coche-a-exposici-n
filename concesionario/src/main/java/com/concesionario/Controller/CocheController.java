package com.concesionario.Controller;

import com.concesionario.Domain.InvalidArgumentException;
import com.concesionario.Service.CocheService;
import com.concesionario.Service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CocheController {

    @Autowired
    private CocheService cocheService;

    @GetMapping("/coches")
    public ResponseEntity<List<CocheOutput>> listCoches() {
        List<CocheOutput> coches = null;
        try {
            coches = cocheService.listCoches();
        } catch (InvalidArgumentException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
        return ResponseEntity.ok(coches);
    }

    @GetMapping("/coches/{matricula}")
    public ResponseEntity<CocheMatriculaOutput> getCoche(@PathVariable String matricula) {
        CocheMatriculaOutput coche = null;
        try {
            coche = cocheService.getCoche(matricula);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (InvalidArgumentException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
        return ResponseEntity.ok(coche);
    }
}
