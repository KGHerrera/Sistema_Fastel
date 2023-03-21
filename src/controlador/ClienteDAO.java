/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexionBD.ConexionBD;
import modelo.Cliente;

/**
 *
 * @author KHerrera
 */
public class ClienteDAO implements Runnable {
    private int opcion;
    private Cliente cliente;
    private boolean res = false;

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
              
    public boolean isRes(){
        return res;
    }
    
    public boolean altaCliente(){
        res = ConexionBD.altaCliente(cliente);
        return res;
    }
    
    public boolean bajaCliente(){
        res = ConexionBD.bajaCliente(cliente);
        return res;
    }

    @Override
    public void run() {
        if (opcion == 1){
            altaCliente();
        } if(opcion == 2){
            bajaCliente();
        }
    }
    
}
