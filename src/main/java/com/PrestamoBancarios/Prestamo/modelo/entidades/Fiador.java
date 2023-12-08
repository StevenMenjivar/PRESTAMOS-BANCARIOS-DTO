package com.PrestamoBancarios.Prestamo.modelo.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "fiadores")
public class Fiador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_fiador")
    private String nombreFiador;

    @Column(name = "apellido_fiador")
    private String apellidoFiador;

    @Column(name = "dui_fiador")
    private String duiFiador;


    public Fiador(String nombreFiador, String apellidoFiador, String duiFiador) {
        this.nombreFiador = nombreFiador;
        this.apellidoFiador = apellidoFiador;
        this.duiFiador = duiFiador;
    }

    public Fiador(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreFiador() {
        return nombreFiador;
    }

    public void setNombreFiador(String nombreFiador) {
        this.nombreFiador = nombreFiador;
    }

    public String getApellidoFiador() {
        return apellidoFiador;
    }

    public void setApellidoFiador(String apellidoFiador) {
        this.apellidoFiador = apellidoFiador;
    }

    public String getDuiFiador() {
        return duiFiador;
    }

    public void setDuiFiador(String duiFiador) {
        this.duiFiador = duiFiador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fiador fiador = (Fiador) o;
        return Objects.equals(nombreFiador, fiador.nombreFiador) && Objects.equals(apellidoFiador, fiador.apellidoFiador) && Objects.equals(duiFiador, fiador.duiFiador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreFiador, apellidoFiador, duiFiador);
    }
}
