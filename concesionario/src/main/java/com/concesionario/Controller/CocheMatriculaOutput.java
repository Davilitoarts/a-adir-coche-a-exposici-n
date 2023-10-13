package com.concesionario.Controller;

import com.concesionario.Domain.InvalidArgumentException;

public class CocheMatriculaOutput {
    private String matricula;

    public CocheMatriculaOutput(String matricula) throws InvalidArgumentException {
        if (matricula == null) throw new InvalidArgumentException("matricula no puede ser nula");
        if (matricula.trim().length() == 0) throw new InvalidArgumentException("matricula no puede ser nula");
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}
