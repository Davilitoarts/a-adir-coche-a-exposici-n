package com.concesionario.Service;

import com.concesionario.Controller.CocheMatriculaOutput;
import com.concesionario.Controller.CocheOutput;
import com.concesionario.Domain.Coche;
import com.concesionario.Domain.InvalidArgumentException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CocheService {
    private HashMap<String, Coche> coches;

    public CocheService() {
        coches = new HashMap<>();
    }

    public List<CocheOutput> listCoches() throws InvalidArgumentException {
        List<CocheOutput> cochesOutput = new ArrayList<>();
        for (Coche item: coches.values()) {
            cochesOutput.add(new CocheOutput(item.getMatricula(), item.getMarca(), item.getModelo(), item.getAnyo()));
        }
        return cochesOutput;
    }

    public CocheMatriculaOutput getCoche(String matricula) throws NotFoundException, InvalidArgumentException {
        Coche coche =  coches.get(matricula);
        if (coche == null) throw new NotFoundException("El coche de matricula: " + matricula + " no existe");
        return new CocheMatriculaOutput(coche.getMatricula());
    }

    public void agregarCoche(Coche coche) throws InvalidArgumentException {
        if (coches.containsKey(coche.getMatricula())) {
            throw new InvalidArgumentException("El coche con la matrícula " + coche.getMatricula() + " ya existe.");
        }
        coches.put(coche.getMatricula(), coche);
    }
}
