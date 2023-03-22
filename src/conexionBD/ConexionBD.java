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
import javax.swing.JTable;
import modelo.Cliente;
import vista.ResultSetTableModel;

/**
 *
 * @author KHerrera
 */
public class ConexionBD {

    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=fastel;TrustServerCertificate=True";
    private static String controlador = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection conexion = null;
    private static PreparedStatement pstm;
    private static ResultSet rs;

    private ConexionBD() {
        try {
            Class.forName(controlador);
            conexion = DriverManager.getConnection(url, "kherrera", "123456");
            System.out.println("se conecto con exito XD");

        } catch (ClassNotFoundException e) {
            System.out.println("Error de DRIVER");
        } catch (SQLException e) {
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
    public static boolean altaCliente(Cliente cliente) {
        boolean exito = false;
        try {
            conexion.setAutoCommit(false); // Iniciar transacción
            String sql = "INSERT INTO clientes (nombre, apellido, rfc, telefono, fecha_registro) VALUES (?, ?, ?, ?, GETDATE())";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getRfc());
            ps.setString(4, cliente.getTelefono());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 1) {
                exito = true;
                conexion.commit(); // Confirmar transacción
            } else {
                conexion.rollback(); // Deshacer transacción
            }
        } catch (SQLException e) {
            try {
                conexion.rollback(); // Deshacer transacción
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conexion.setAutoCommit(true); // Reestablecer autocommit
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exito;
    }
    
    public static boolean cambiarCliente(Cliente cliente) {
        boolean exito = false;
        try {
            conexion.setAutoCommit(false); // Iniciar transacción
            String sql = "UPDATE clientes SET nombre = ?, apellido = ?, rfc = ?, telefono = ? WHERE id_cliente = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getRfc());
            ps.setString(4, cliente.getTelefono());
            ps.setInt(5, cliente.getIdCliente());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 1) {
                exito = true;
                conexion.commit(); // Confirmar transacción
            } else {
                conexion.rollback(); // Deshacer transacción
            }
        } catch (SQLException e) {
            try {
                conexion.rollback(); // Deshacer transacción
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conexion.setAutoCommit(true); // Reestablecer autocommit
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exito;
    }
    
    public static boolean bajaCliente(Cliente cliente) {
        boolean exito = false;
        try {
            conexion.setAutoCommit(false); // Iniciar transacción
            String sql = "DELETE FROM clientes WHERE id_cliente = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, cliente.getIdCliente());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 1) {
                exito = true;
                conexion.commit(); // Confirmar transacción
            } else {
                conexion.rollback(); // Deshacer transacción
            }
        } catch (SQLException e) {
            try {
                conexion.rollback(); // Deshacer transacción
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conexion.setAutoCommit(true); // Reestablecer autocommit
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exito;
    }   
    
    public static ResultSetTableModel consultaCliente(Cliente a) {

        ResultSetTableModel modeloDatos = null;
        String consulta = "SELECT * FROM clientes "
                + "WHERE id_cliente LIKE " + a.getIdCliente() 
                + " or nombre LIKE '" + a.getNombre()
                + "' or apellido LIKE '" + a.getApellido()
                + "' or telefono LIKE '" + a.getTelefono()
                + "' or rfc LIKE '" + a.getRfc()
                + "' or fecha_registro LIKE '" + a.getFechaRegistro() + "'";
        
        try {
            modeloDatos = new ResultSetTableModel(controlador, url,
                    consulta);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modeloDatos;
    }
    
    public static void actualizarTabla(JTable tabla, String nombreTabla, String order) {
        String consulta;
        consulta = "SELECT * FROM " + nombreTabla + " ORDER BY " + order + "";

        ResultSetTableModel modeloDatos = null;

        try {
            modeloDatos = new ResultSetTableModel(controlador, url, consulta);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tabla.setModel(modeloDatos);
    }
    

    public static void main(String[] args) {
        ConexionBD.getConexion();

        Cliente cliente1 = new Cliente(4, "megamun", "tarzo", "HIIWQO", "595182931", "2023-03-20");
        if(bajaCliente(cliente1) == true){
            System.out.println("se agrego correctamente");
        }

    }

}
