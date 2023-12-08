package com.PrestamoBancarios.Prestamo.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoClientes")
public class TipoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcionTipoCliente;

    public TipoCliente(String descripcionTipoCliente) {
        this.descripcionTipoCliente = descripcionTipoCliente;
    }

    public TipoCliente(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcionTipoCliente() {
        return descripcionTipoCliente;
    }

    public void setDescripcionTipoCliente(String descripcionTipoCliente) {
        this.descripcionTipoCliente = descripcionTipoCliente;
    }
}
