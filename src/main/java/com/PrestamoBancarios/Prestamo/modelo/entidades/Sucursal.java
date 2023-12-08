package com.PrestamoBancarios.Prestamo.modelo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_sucursal")
    private String nombreSucursal;

    @Column(name = "ubicacion_sucursal")
    private String ubicacionSucursal;

    public Sucursal(){}

    public Sucursal(Integer id, String nombreSucursal, String ubicacionSucursal) {
        this.id = id;
        this.nombreSucursal = nombreSucursal;
        this.ubicacionSucursal = ubicacionSucursal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getUbicacionSucursal() {
        return ubicacionSucursal;
    }

    public void setUbicacionSucursal(String ubicacionSucursal) {
        this.ubicacionSucursal = ubicacionSucursal;
    }
}
