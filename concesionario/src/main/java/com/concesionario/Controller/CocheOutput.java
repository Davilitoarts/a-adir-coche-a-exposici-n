package com.concesionario.Controller;

import com.concesionario.Domain.InvalidArgumentException;

public class CocheOutput {
    private String matricula;
    private String marca;
    private String modelo;
    private int anyo;

    public CocheOutput(String matricula, String marca, String modelo, int anyo) throws InvalidArgumentException {
        if (matricula == null) throw new InvalidArgumentException("matricula no puede ser nula");
        if (matricula.trim().equalsIgnoreCase("")) throw new InvalidArgumentException("matricula no puede ser nula");
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnyo() {
        return anyo;
    }
}
