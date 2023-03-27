/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author KHerrera
 */
public class Empleado {

    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String rfc;
    private String telefono;
    private String puesto;
    private double sueldo;

    public Empleado() {

    }

    public Empleado(int idEmpleado, String nombre, String apellido, String rfc, String telefono, String puesto, double sueldo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rfc = rfc;
        this.telefono = telefono;
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

    // Getters y setters
    public int getId() {
        return idEmpleado;
    }

    public void setId(int id) {
        this.idEmpleado = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
