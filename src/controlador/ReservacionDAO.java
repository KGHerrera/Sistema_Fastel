/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexionBD.ConexionBD;
import modelo.Reservacion;

/**
 *
 * @author KHerrera
 */
public class ReservacionDAO implements Runnable {

    private int opcion;
    private Reservacion reservacion;
    private int res = 0;

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public Reservacion getCliente() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }

    public int isRes() {
        return res;
    }

    public int altaReservacion() {
        res = ConexionBD.altaReservacion(reservacion);
        return res;
    }

    public int bajaReservacion() {
        res = ConexionBD.cancelarReservacion(reservacion);
        return res;
    }

    public int cambiarReservacion() {
        return res;
    }

    @Override
    public void run() {
        if (opcion == 1) {
            altaReservacion();
        }
        if (opcion == 2) {
            bajaReservacion();
        }
        if (opcion == 3) {
            cambiarReservacion();
        }
    }
}
