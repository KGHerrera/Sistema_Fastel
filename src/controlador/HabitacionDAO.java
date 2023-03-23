/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexionBD.ConexionBD;
import modelo.Habitacion;

/**
 *
 * @author KHerrera
 */
public class HabitacionDAO implements Runnable {

    private int opcion;
    private Habitacion habitacion;
    private boolean res = false;

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public boolean isRes() {
        return res;
    }

    public boolean altaHabitacion() {
        res = ConexionBD.altaHabitacion(habitacion);
        return res;
    }

    public boolean bajaHabitacion() {
        res = ConexionBD.bajaHabitacion(habitacion);
        return res;
    }

    public boolean cambiarHabitacion() {
        res = ConexionBD.cambiarHabitacion(habitacion);
        return res;
    }

    @Override
    public void run() {
        if (opcion == 1) {
            altaHabitacion();
        }
        if (opcion == 2) {
            bajaHabitacion();
        }
        if (opcion == 3) {
            cambiarHabitacion();
        }
    }
}
