package com.concesionario.Controller;

public class CocheMatMarcOutput {
    private String matricula;
    private String marca;

    public CocheMatMarcOutput(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }
}
