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
import modelo.Empleado;
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
                + "' or precio_noche LIKE " + habitacion.getPrecioNoche() + "";

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

            // verificar que la fecha sea mayor
            String sqlFecha = "SELECT DATEDIFF(day, GETDATE(), ?)";
            ps = conexion.prepareStatement(sqlFecha);
            ps.setString(1, reservacion.getVigencia());
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) <= 0) {
                    return -5;
                }
            }

            // Iniciar la transacción
            conexion.setAutoCommit(false);

            // modificar la habitacion para que este ocupada, anuma esto tambien podria estar en un trigger
            String sqlHabitacionOcupada = "UPDATE habitaciones SET disponible = ? WHERE id_habitacion = ?";
            ps = conexion.prepareStatement(sqlHabitacionOcupada);
            ps.setBoolean(1, false);
            ps.setInt(2, reservacion.getIdHabitacion());
            ps.executeUpdate();

            // Insertar la reservación
            String sqlReservacion = "INSERT INTO reservaciones (fecha_reservacion, "
                    + "vigencia, costo_total, fk_id_habitacion, fk_id_cliente) "
                    + "VALUES (GETDATE(), ?, (SELECT DATEDIFF(day, GETDATE(), ?)) * "
                    + "(SELECT precio_noche FROM habitaciones WHERE id_habitacion = ?), ?, ?)";
            ps = conexion.prepareStatement(sqlReservacion);
            ps.setString(1, reservacion.getVigencia());
            ps.setString(2, reservacion.getVigencia());
            ps.setInt(3, reservacion.getIdHabitacion());
            ps.setInt(4, reservacion.getIdHabitacion());
            ps.setInt(5, reservacion.getIdCliente());
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

    public static int cambiarReservacion(Reservacion reservacion) {
        int result = 0;
        PreparedStatement stmt = null;
        try {

            // verificar que la fecha sea mayor
            String sqlFecha = "SELECT DATEDIFF(day, ?, ?)";
            stmt = conexion.prepareStatement(sqlFecha);

            stmt.setString(1, reservacion.getFechaReservacion());
            stmt.setString(2, reservacion.getVigencia());
            rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) <= 0) {
                    return -1;
                }
            }

            // INICIAR MODIFICACION
            conexion.setAutoCommit(false);
            stmt = conexion.prepareStatement("UPDATE reservaciones SET vigencia = ? , "
                    + "costo_total = ((SELECT DATEDIFF(day, ?, ?)) * "
                    + "(SELECT precio_noche FROM habitaciones WHERE id_habitacion = ?)) "
                    + "WHERE id_reservacion = ?");
            stmt.setString(1, reservacion.getVigencia());
            stmt.setString(2, reservacion.getFechaReservacion());
            stmt.setString(3, reservacion.getVigencia());
            stmt.setInt(4, reservacion.getIdHabitacion());
            stmt.setInt(5, reservacion.getIdReservacion());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                conexion.commit();
                result = 1;
            } else {
                conexion.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                conexion.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static int cancelarReservacion(Reservacion reservacion) {
        boolean resultado = false;
        PreparedStatement psEliminar = null;

        try {
            conexion.setAutoCommit(false);

            // modificar la habitacion para que este disponible
            String sqlHabitacionOcupada = "UPDATE habitaciones SET disponible = ? WHERE id_habitacion = ?";
            psEliminar = conexion.prepareStatement(sqlHabitacionOcupada);
            psEliminar.setBoolean(1, true);
            psEliminar.setInt(2, reservacion.getIdHabitacion());
            psEliminar.executeUpdate();

            // eliminar la habitacion, el trigger se encargara de lo demas y porque no hice un trigger que hiciera lo anterior :thinking:
            String sqlEliminar = "DELETE FROM reservaciones WHERE id_reservacion = ?";
            psEliminar = conexion.prepareStatement(sqlEliminar);
            psEliminar.setInt(1, reservacion.getIdReservacion());

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

        return resultado ? 1 : 0;
    }

    public static ResultSetTableModel consultaReservacion(Reservacion reservacion, String nombre) {

        ResultSetTableModel modeloDatos = null;
        String consulta = "SELECT * FROM v_reservaciones "
                + "WHERE id_reservacion LIKE " + reservacion.getIdReservacion()
                + " or id_habitacion LIKE " + reservacion.getIdHabitacion()
                + " or nombre_cliente LIKE '" + nombre + "%'"
                + " or vigencia LIKE '" + reservacion.getVigencia() + "'"
                + " or fecha_reservacion LIKE '" + reservacion.getFechaReservacion() + "'"
                + " or costo_total = " + reservacion.getCostoTotal();

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

    // ====================================================================
    // Consultas empleado
    // ====================================================================
    public static boolean altaEmpleado(Empleado empleado) {
        boolean exito = false;
        try {
            conexion.setAutoCommit(false); // Iniciar transacción
            String sql = "INSERT INTO empleados (nombre, apellido, rfc, telefono, puesto, sueldo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getRfc());
            ps.setString(4, empleado.getTelefono());
            ps.setString(5, empleado.getPuesto());
            ps.setDouble(6, empleado.getSueldo());

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

    public static boolean bajaEmpleado(Empleado empleado) {
        boolean exito = false;
        try {
            conexion.setAutoCommit(false); // Iniciar transacción
            String sql = "DELETE FROM empleados WHERE id_empleado = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, empleado.getId());
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

    public static boolean cambiarEmpleado(Empleado empleado) {
        boolean exito = false;
        try {
            conexion.setAutoCommit(false); // Iniciar transacción
            String sql = "UPDATE empleados SET nombre = ?, apellido = ?, rfc = ?, telefono = ?, puesto = ?, sueldo = ? WHERE id_empleado = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getRfc());
            ps.setString(4, empleado.getTelefono());
            ps.setString(5, empleado.getPuesto());
            ps.setDouble(6, empleado.getSueldo());
            ps.setInt(7, empleado.getId());
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

    public static ResultSetTableModel consultaEmpleado(Empleado empleado, String nombre) {

        ResultSetTableModel modeloDatos = null;
        String consulta = "SELECT * FROM empleados "
                + "WHERE id_empleado LIKE " + empleado.getId()
                + " or nombre LIKE '" + nombre + "%'"
                + " or apellido LIKE '" + empleado.getApellido() + "%'"
                + " or rfc LIKE '" + empleado.getRfc() + "%'"
                + " or telefono LIKE '" + empleado.getTelefono() + "%'"
                + " or puesto LIKE '" + empleado.getPuesto() + "%'"
                + " or sueldo = " + empleado.getSueldo();

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

    /*
    
    TRIGGER para reservaciones canceladas al eliminar
    
    CREATE TRIGGER tr_reservaciones_canceladas ON reservaciones
    AFTER DELETE
    AS
    BEGIN
    SET NOCOUNT ON;

    INSERT INTO reservaciones_canceladas (fecha_reservacion, vigencia, costo_total, fk_id_habitacion, fk_id_cliente)
    SELECT fecha_reservacion, vigencia, costo_total, fk_id_habitacion, fk_id_cliente
    FROM DELETED;
    END;
    
     */
    public static void main(String[] args) {
        ConexionBD.getConexion();

        String sql = "INSERT INTO empleados (nombre, apellido, rfc, telefono, puesto, sueldo) VALUES (?, ?, ?, ?, ?, ?)";
        Empleado empleado = new Empleado(2, "empleado", "robles", "PECA23891", "1", "cocinero", 2000.00);

        boolean res = ConexionBD.cambiarEmpleado(empleado);
        System.out.println(res);

    }

}
