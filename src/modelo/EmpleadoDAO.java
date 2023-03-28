/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import conexionBD.ConexionBD;
import modelo.Empleado;

/**
 *
 * @author KHerrera
 */
public class EmpleadoDAO implements Runnable{

    private int opcion;
    private Empleado empleado;
    private boolean res = false;

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public boolean isRes() {
        return res;
    }

    public boolean altaEmpleado() {
        res = ConexionBD.altaEmpleado(empleado);
        return res;
    }

    public boolean bajaEmpleado() {
        res = ConexionBD.bajaEmpleado(empleado);
        return res;
    }

    public boolean cambiarEmpleado() {
        res = ConexionBD.cambiarEmpleado(empleado);
        return res;
    }

    @Override
    public void run() {
        if (opcion == 1) {
            altaEmpleado();
        }
        if (opcion == 2) {
            bajaEmpleado();
        }
        if (opcion == 3) {
            cambiarEmpleado();
        }
    }
}
