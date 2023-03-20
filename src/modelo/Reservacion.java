/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author KHerrera
 */
public class Reservacion {

    private String fechaReservacion;
    private String vigencia;
    private double costoTotal;
    private int idHabitacion;
    private int idCliente;

    public Reservacion(String fechaReservacion, String vigencia, double costoTotal, int idHabitacion, int idCliente) {
        this.fechaReservacion = fechaReservacion;
        this.vigencia = vigencia;
        this.costoTotal = costoTotal;
        this.idHabitacion = idHabitacion;
        this.idCliente = idCliente;
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
