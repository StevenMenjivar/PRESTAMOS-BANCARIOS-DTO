package com.PrestamoBancarios.Prestamo.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoPrestamo")
public class TipoPrestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descripcion")
    private String descripcionTipoPrestamo;

    public TipoPrestamo(String descripcionTipoPrestamo) {
        this.descripcionTipoPrestamo = descripcionTipoPrestamo;
    }

    public TipoPrestamo (){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcionTipoPrestamo() {
        return descripcionTipoPrestamo;
    }

    public void setDescripcionTipoPrestamo(String descripcionTipoPrestamo) {
        this.descripcionTipoPrestamo = descripcionTipoPrestamo;
    }
}
