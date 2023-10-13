package com.concesionario.Domain;

public class Coche {
    private final String matricula;
    private String marca;
    private String modelo;
    private int anyo;

    public Coche(String matricula) throws InvalidArgumentException {
        String errorMatricula = "Matricula es obligatoria";
        if (matricula == null) {
            throw new InvalidArgumentException(errorMatricula);
        }
        if (matricula.trim().length() == 0) throw new InvalidArgumentException(errorMatricula);
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
    }

    public Coche(String matricula, String marca, String modelo, int anyo) throws InvalidArgumentException {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new InvalidArgumentException("La matrícula no puede estar vacía.");
        }
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
