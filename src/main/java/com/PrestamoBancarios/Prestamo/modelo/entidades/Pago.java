package com.PrestamoBancarios.Prestamo.modelo.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "monto_pago")
    private Double montoPago;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;
    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}) @JoinColumn(name = "prestamo_id", foreignKey = @ForeignKey(name = "FK_prestamo_id"))
    private Prestamo prestamo;


    public Pago(){}

    public Pago(Integer id, Double montoPago) {
        this.id = id;
        this.montoPago = montoPago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Double montoPago) {
        this.montoPago = montoPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
}
