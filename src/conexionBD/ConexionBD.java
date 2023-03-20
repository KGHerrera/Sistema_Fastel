/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;

/**
 *
 * @author KHerrera
 */
public class ConexionBD {
    
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=fastel;TrustServerCertificate=True";
    private static Connection conexion = null;
    private static PreparedStatement pstm;
    private static ResultSet rs;
    
    private ConexionBD() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(url, "kherrera", "123456");
            System.out.println("se conecto con exito XD");

        }  catch(ClassNotFoundException e){
            System.out.println("Error de DRIVER");
        }
        catch (SQLException e) {
            System.out.println("Error de conexion en SQL Server " + e);
        }
    }

    public static Connection getConexion() {
        if (conexion == null) {
            new ConexionBD();
        }
        return conexion;
    }

    public void cerrarConexion() {
        try {
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion");
            //e.printStackTrace();
        }
    }  
    
    // Consultas clientes
    
    public static boolean altaCliente(Cliente a) {
        int res = 0;
        try {
            // TRANSACCION ALTAS
            conexion.setAutoCommit(false);

            String consulta = "INSERT INTO clientes VALUES(?,?,?,?,GETDATE())";
            pstm = conexion.prepareStatement(consulta);

           
            pstm.setString(1, a.getNombre());
            pstm.setString(2, a.getApellido());
            pstm.setString(3, a.getRfc());
            pstm.setString(4, a.getTelefono());

            res = pstm.executeUpdate();

            // SE EJECUTA SI NO EXISTE ERROR
            conexion.commit();
        } catch (SQLException error) {
            res = 0;

            // REGRESA AL ESTADO ANTERIOR
            try {
                conexion.rollback();
            } catch (SQLException er) {

            }
            error.printStackTrace();
        }

        if (res != 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
     
    public static void main(String[] args) {
        ConexionBD.getConexion();
        
        Cliente cliente1 = new Cliente(1, "rumpel", "lombriz", "HRJEKS20293", "4945123709", "12-12-2023");
        altaCliente(cliente1);
        
    } 
    
    
    
}
