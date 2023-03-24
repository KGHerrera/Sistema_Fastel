/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author KHerrera
 */
public class Habitacion {
    private int idHabitacion;
    private String tipoHabitacion;
    private boolean disponible;
    private boolean bajaTemporal;
    private double precioNoche;

    public Habitacion(){
        
    }
    // Constructor
    public Habitacion(int idHabitacion, String tipoHabitacion, boolean disponible, boolean bajaTemporal, double precioNoche) {
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.disponible = disponible;
        this.bajaTemporal = bajaTemporal;
        this.precioNoche = precioNoche;
    }

    // Getters y setters
    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isBajaTemporal() {
        return bajaTemporal;
    }

    public void setBajaTemporal(boolean bajaTemporal) {
        this.bajaTemporal = bajaTemporal;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    // toString para imprimir el objeto como String
    @Override
    public String toString() {
        return "Habitacion [idHabitacion=" + idHabitacion + ", tipoHabitacion=" + tipoHabitacion + ", disponible="
                + disponible + ", bajaTemporal=" + bajaTemporal + ", precioNoche=" + precioNoche + "]";
    }
}
