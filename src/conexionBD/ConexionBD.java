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
import modelo.Habitacion;
import modelo.Reservacion;
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

    // =============================================
    // consultas para la tabla habitaciones
    // =============================================
    public static boolean altaHabitacion(Habitacion habitacion) {
        boolean exito = false;
        try {
            // Iniciar transacción
            conexion.setAutoCommit(false);

            // Preparar la consulta SQL
            String consulta = "INSERT INTO habitaciones (tipo_habitacion, disponible, baja_temporal, precio_noche) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(consulta);

            // Establecer los parámetros de la consulta
            ps.setString(1, habitacion.getTipoHabitacion());
            ps.setBoolean(2, habitacion.isDisponible());
            ps.setBoolean(3, habitacion.isBajaTemporal());
            ps.setDouble(4, habitacion.getPrecioNoche());

            // Ejecutar la consulta
            int filasInsertadas = ps.executeUpdate();

            // Confirmar la transacción
            conexion.commit();

            // Comprobar si se han insertado filas
            if (filasInsertadas > 0) {
                exito = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();

            // Deshacer la transacción en caso de error
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            // Restaurar el modo de auto-commit
            try {
                conexion.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return exito;
    }

    public static boolean cambiarHabitacion(Habitacion habitacion) {
        boolean resultado = false;
        PreparedStatement psActualizar = null;

        try {
            conexion.setAutoCommit(false);

            String sqlActualizar = "UPDATE habitaciones SET tipo_habitacion = ?, disponible = ?, baja_temporal = ?, precio_noche = ? WHERE id_habitacion = ?";
            psActualizar = conexion.prepareStatement(sqlActualizar);
            psActualizar.setString(1, habitacion.getTipoHabitacion());
            psActualizar.setBoolean(2, habitacion.isDisponible());
            psActualizar.setBoolean(3, habitacion.isBajaTemporal());
            psActualizar.setDouble(4, habitacion.getPrecioNoche());
            psActualizar.setInt(5, habitacion.getIdHabitacion());

            int filasAfectadas = psActualizar.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
                conexion.commit();
            } else {
                conexion.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (psActualizar != null) {
                    psActualizar.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;
    }

    public static boolean bajaHabitacion(Habitacion habitacion) {
        boolean resultado = false;
        PreparedStatement psEliminar = null;

        try {
            conexion.setAutoCommit(false);

            String sqlEliminar = "DELETE FROM habitaciones WHERE id_habitacion = ?";
            psEliminar = conexion.prepareStatement(sqlEliminar);
            psEliminar.setInt(1, habitacion.getIdHabitacion());

            int filasAfectadas = psEliminar.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
                conexion.commit();
            } else {
                conexion.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (psEliminar != null) {
                    psEliminar.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;
    }

    public static boolean bajaTemporalHabitacion(Habitacion habitacion, boolean baja) {
        boolean resultado = false;
        PreparedStatement psActualizar = null;

        try {
            conexion.setAutoCommit(false);

            String sqlActualizar = "UPDATE habitaciones SET baja_temporal = ? WHERE id_habitacion = ?";
            psActualizar = conexion.prepareStatement(sqlActualizar);
            psActualizar.setBoolean(1, baja);
            psActualizar.setInt(2, habitacion.getIdHabitacion());

            int filasAfectadas = psActualizar.executeUpdate();
            if (filasAfectadas > 0) {
                resultado = true;
                conexion.commit();
            } else {
                conexion.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (psActualizar != null) {
                    psActualizar.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;
    }
    
    public static ResultSetTableModel consultaHabitacion(Habitacion habitacion) {

        ResultSetTableModel modeloDatos = null;
        String consulta = "SELECT * FROM habitaciones "
                + "WHERE id_habitacion LIKE " + habitacion.getIdHabitacion()
                + " or tipo_habitacion LIKE '" + habitacion.getTipoHabitacion()
                + "' or precio_noche LIKE " + habitacion.getPrecioNoche()+ "";

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

    // =======================================================
    // Metodos de consultas para reservaciones
    // =======================================================
    
    public static int altaReservacion(Reservacion reservacion) {
        int resultado = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            // Verificar si existe el cliente y la habitación
            String sqlCliente = "SELECT id_cliente FROM clientes WHERE id_cliente = ?";
            ps = conexion.prepareStatement(sqlCliente);
            ps.setInt(1, reservacion.getIdCliente());
            rs = ps.executeQuery();
            if (!rs.next()) {
               
                //System.out.println("el cliente no existe");
                return -1;               
            }

            String sqlHabitacion = "SELECT id_habitacion FROM habitaciones WHERE id_habitacion = ?";
            ps = conexion.prepareStatement(sqlHabitacion);
            ps.setInt(1, reservacion.getIdHabitacion());
            rs = ps.executeQuery();
            if (!rs.next()) {
                
                //System.out.println("la habitacion no existe");
                return -2;
            }
            
            // verificar si la habitacion esta disponible
            String sqlHabitacion1 = "SELECT id_habitacion FROM habitaciones WHERE id_habitacion = ? AND disponible = ?";
            ps = conexion.prepareStatement(sqlHabitacion1);
            ps.setInt(1, reservacion.getIdHabitacion());
            ps.setInt(2, 1);
            rs = ps.executeQuery();
            if (!rs.next()) {
                //System.out.println("la habitacion esta ocupada");
                return -3;
            }
            
            // verificar si la habitacion no esta de baja temporal
            String sqlHabitacion2 = "SELECT id_habitacion FROM habitaciones WHERE id_habitacion = ? AND baja_temporal = ?";
            ps = conexion.prepareStatement(sqlHabitacion2);
            ps.setInt(1, reservacion.getIdHabitacion());
            ps.setInt(2, 0);
            rs = ps.executeQuery();
            if (!rs.next()) {
                //System.out.println("la habitacion esta ocupada");
                return -4;
            }            
            
            // Iniciar la transacción
            conexion.setAutoCommit(false);
            
            // modificar la habitacion para que este ocupada
            String sqlHabitacionOcupada = "UPDATE habitaciones SET disponible = ? WHERE id_habitacion = ?";
            ps = conexion.prepareStatement(sqlHabitacionOcupada);
            ps.setBoolean(1, false);
            ps.setInt(2, reservacion.getIdHabitacion());
            ps.executeUpdate();

            // Insertar la reservación
            String sqlReservacion = "INSERT INTO reservaciones (fecha_reservacion, vigencia, costo_total, fk_id_habitacion, fk_id_cliente) "
                    + "VALUES (GETDATE(), ?, ?, ?, ?)";
            ps = conexion.prepareStatement(sqlReservacion);
            ps.setString(1, reservacion.getVigencia());
            ps.setDouble(2, reservacion.getCostoTotal());
            ps.setInt(3, reservacion.getIdHabitacion());
            ps.setInt(4, reservacion.getIdCliente());
            resultado = ps.executeUpdate();

            // Confirmar la transacción
            conexion.commit();
            
        } catch (SQLException e) {
            // Cancelar la transacción
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Cerrar el PreparedStatement y el ResultSet
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Restablecer el valor de autoCommit a true
            try {
                if (conexion != null) {
                    conexion.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;
    }
    
    public static void main(String[] args) {
        ConexionBD.getConexion();

        Reservacion reservacion = new Reservacion(1, "", "2023-02-02", 2000.78, 2,1);
        
        int resultado = altaReservacion(reservacion);
        
        if (resultado == -1){
            System.out.println("el cliente no existe");
        } else if(resultado == -2){
            System.out.println("la habitacion no existe");
        } else if (resultado == 1){
            System.out.println("se agrego correctamente");
        } else if(resultado == -3){
            System.out.println("la habitacion esta ocupada");
        } else if(resultado == -4){
            System.out.println("la habitacion esta de baja temporal");
        }

    }

}
