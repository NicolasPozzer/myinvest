package com.demo.myinvest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
public class Inversion {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String nombre;
    private Double precioEntrada;
    private Double cantInvertida;

    public Inversion() {
    }

    public Inversion(Long id, String nombre, Double precioEntrada, Double cantInvertida) {
        this.id = id;
        this.nombre = nombre;
        this.precioEntrada = precioEntrada;
        this.cantInvertida = cantInvertida;
    }
}
