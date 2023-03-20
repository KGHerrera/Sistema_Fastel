/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author KHerrera
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    Color btnColorHover = new Color(0, 79, 160);
    Color btnColorReset = new Color(0, 79, 146);

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();

        // Centrar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        barraVentana = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        sideMenu = new javax.swing.JPanel();
        txtLogo = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        txtcClientes2 = new javax.swing.JLabel();
        txtcClientes3 = new javax.swing.JLabel();
        btnClientes = new javax.swing.JPanel();
        txtClientes = new javax.swing.JLabel();
        btnReservaciones = new javax.swing.JPanel();
        txtReservaciones = new javax.swing.JLabel();
        btnHabitaciones = new javax.swing.JPanel();
        txtHabitaciones = new javax.swing.JLabel();
        btnEmpleados = new javax.swing.JPanel();
        txtEmpleados = new javax.swing.JLabel();
        btnReportes = new javax.swing.JPanel();
        txtReportes = new javax.swing.JLabel();
        panelReservaciones = new javax.swing.JPanel();
        barraReservaciones = new javax.swing.JPanel();
        txtModoReservaciones = new javax.swing.JLabel();
        txtReservacionesTitulo = new javax.swing.JLabel();
        btnModoRegistrarReservaciones = new javax.swing.JLabel();
        btnModoModificarReservaciones = new javax.swing.JLabel();
        btnModoEliminarReservaciones = new javax.swing.JLabel();
        btnModoConsultarReservaciones = new javax.swing.JLabel();
        messageReservaciones = new javax.swing.JPanel();
        txtMessageReservaciones = new javax.swing.JLabel();
        panelClientes = new javax.swing.JPanel();
        barraClientes = new javax.swing.JPanel();
        txtModoClientes = new javax.swing.JLabel();
        txtClientesTitulo = new javax.swing.JLabel();
        btnModoRegistrarClientes = new javax.swing.JLabel();
        btnModoModificarClientes = new javax.swing.JLabel();
        btnModoEliminarClientes = new javax.swing.JLabel();
        btnModoConsultarClientes = new javax.swing.JLabel();
        messageClientes = new javax.swing.JPanel();
        txtMessageClientes = new javax.swing.JLabel();
        panelInicio = new javax.swing.JPanel();
        barraInicioPane = new javax.swing.JPanel();
        txtSeleccionaAccion = new javax.swing.JLabel();
        txtInicioTitulo = new javax.swing.JLabel();
        txtWelcomeUser = new javax.swing.JLabel();
        txtLogoMain = new javax.swing.JLabel();
        messagePaneInicio = new javax.swing.JPanel();
        txtMessageInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Inicio");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPrincipal.setBackground(new java.awt.Color(240, 240, 240));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraVentana.setBackground(new java.awt.Color(0, 65, 130));
        barraVentana.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraVentanaMouseDragged(evt);
            }
        });
        barraVentana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraVentanaMousePressed(evt);
            }
        });
        barraVentana.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMinimize.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnMinimize.setForeground(new java.awt.Color(240, 240, 240));
        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setText("–");
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });
        barraVentana.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 40, 40));

        btnClose.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(240, 240, 240));
        btnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClose.setText("X");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        barraVentana.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, 40, 40));

        jPanelPrincipal.add(barraVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 40));

        sideMenu.setBackground(new java.awt.Color(0, 65, 130));
        sideMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLogo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        txtLogo.setForeground(new java.awt.Color(240, 240, 240));
        txtLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtLogo.setText("Fastel");
        txtLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sideMenu.add(txtLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 100));

        userPanel.setBackground(new java.awt.Color(0, 79, 146));
        userPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcClientes2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtcClientes2.setForeground(new java.awt.Color(240, 240, 240));
        txtcClientes2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcClientes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/user.png"))); // NOI18N
        userPanel.add(txtcClientes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 90));

        txtcClientes3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtcClientes3.setForeground(new java.awt.Color(240, 240, 240));
        txtcClientes3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcClientes3.setText("USERNAME");
        userPanel.add(txtcClientes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 260, 30));

        sideMenu.add(userPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 260, 140));

        btnClientes.setBackground(new java.awt.Color(0, 79, 146));
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClientesMouseExited(evt);
            }
        });
        btnClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtClientes.setForeground(new java.awt.Color(240, 240, 240));
        txtClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cliente.png"))); // NOI18N
        txtClientes.setText("Clientes");
        btnClientes.add(txtClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 180, 60));

        sideMenu.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 260, 60));

        btnReservaciones.setBackground(new java.awt.Color(0, 79, 146));
        btnReservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReservaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReservacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReservacionesMouseExited(evt);
            }
        });
        btnReservaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtReservaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtReservaciones.setForeground(new java.awt.Color(240, 240, 240));
        txtReservaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtReservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/reservacion.png"))); // NOI18N
        txtReservaciones.setText("Reservaciones");
        btnReservaciones.add(txtReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 180, 60));

        sideMenu.add(btnReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 260, 60));

        btnHabitaciones.setBackground(new java.awt.Color(0, 79, 146));
        btnHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHabitacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHabitacionesMouseExited(evt);
            }
        });
        btnHabitaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHabitaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtHabitaciones.setForeground(new java.awt.Color(240, 240, 240));
        txtHabitaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/habitacion.png"))); // NOI18N
        txtHabitaciones.setText("Habitaciones");
        btnHabitaciones.add(txtHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 180, 60));

        sideMenu.add(btnHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 260, 60));

        btnEmpleados.setBackground(new java.awt.Color(0, 79, 146));
        btnEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmpleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmpleadosMouseExited(evt);
            }
        });
        btnEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEmpleados.setForeground(new java.awt.Color(240, 240, 240));
        txtEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/empleado.png"))); // NOI18N
        txtEmpleados.setText("Empleados");
        btnEmpleados.add(txtEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 180, 60));

        sideMenu.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 260, 60));

        btnReportes.setBackground(new java.awt.Color(0, 79, 146));
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportesMouseExited(evt);
            }
        });
        btnReportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtReportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtReportes.setForeground(new java.awt.Color(240, 240, 240));
        txtReportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/reportes.png"))); // NOI18N
        txtReportes.setText("Reportes");
        btnReportes.add(txtReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 180, 60));

        sideMenu.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 260, 60));

        jPanelPrincipal.add(sideMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 260, 680));

        panelReservaciones.setBackground(new java.awt.Color(240, 240, 240));
        panelReservaciones.setForeground(new java.awt.Color(240, 240, 240));
        panelReservaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraReservaciones.setBackground(new java.awt.Color(0, 65, 130));
        barraReservaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtModoReservaciones.setFont(new java.awt.Font("Roboto", 2, 24)); // NOI18N
        txtModoReservaciones.setForeground(new java.awt.Color(240, 240, 240));
        txtModoReservaciones.setText("MODO REGISTRO");
        barraReservaciones.add(txtModoReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 60));

        txtReservacionesTitulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtReservacionesTitulo.setForeground(new java.awt.Color(240, 240, 240));
        txtReservacionesTitulo.setText("RESERVACIONES");
        barraReservaciones.add(txtReservacionesTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 30));

        btnModoRegistrarReservaciones.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoRegistrarReservaciones.setForeground(new java.awt.Color(230, 230, 230));
        btnModoRegistrarReservaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoRegistrarReservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add-16.png"))); // NOI18N
        btnModoRegistrarReservaciones.setText("Registrar");
        btnModoRegistrarReservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraReservaciones.add(btnModoRegistrarReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 90, 30));

        btnModoModificarReservaciones.setBackground(new java.awt.Color(72, 58, 125));
        btnModoModificarReservaciones.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoModificarReservaciones.setForeground(new java.awt.Color(230, 230, 230));
        btnModoModificarReservaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoModificarReservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit-2-16.png"))); // NOI18N
        btnModoModificarReservaciones.setText("Modificar");
        btnModoModificarReservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraReservaciones.add(btnModoModificarReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 90, 30));

        btnModoEliminarReservaciones.setBackground(new java.awt.Color(72, 58, 125));
        btnModoEliminarReservaciones.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoEliminarReservaciones.setForeground(new java.awt.Color(230, 230, 230));
        btnModoEliminarReservaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoEliminarReservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/x-mark-4-16.png"))); // NOI18N
        btnModoEliminarReservaciones.setText("Eliminar");
        btnModoEliminarReservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraReservaciones.add(btnModoEliminarReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 90, 30));

        btnModoConsultarReservaciones.setBackground(new java.awt.Color(72, 58, 125));
        btnModoConsultarReservaciones.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoConsultarReservaciones.setForeground(new java.awt.Color(230, 230, 230));
        btnModoConsultarReservaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoConsultarReservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search-15-16.png"))); // NOI18N
        btnModoConsultarReservaciones.setText("Consultar");
        btnModoConsultarReservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraReservaciones.add(btnModoConsultarReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, 90, 30));

        panelReservaciones.add(barraReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 100));

        messageReservaciones.setBackground(new java.awt.Color(0, 153, 153));
        messageReservaciones.setForeground(new java.awt.Color(33, 235, 103));
        messageReservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messageReservaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMessageReservaciones.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtMessageReservaciones.setForeground(new java.awt.Color(240, 240, 240));
        txtMessageReservaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMessageReservaciones.setText("AQUI SE MOSTRARAN LOS MENSAJES DE LAS ACCIONES");
        messageReservaciones.add(txtMessageReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 930, 50));

        panelReservaciones.add(messageReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1020, 50));

        jPanelPrincipal.add(panelReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 1020, 680));

        panelClientes.setBackground(new java.awt.Color(240, 240, 240));
        panelClientes.setForeground(new java.awt.Color(240, 240, 240));
        panelClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraClientes.setBackground(new java.awt.Color(0, 65, 130));
        barraClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtModoClientes.setFont(new java.awt.Font("Roboto", 2, 24)); // NOI18N
        txtModoClientes.setForeground(new java.awt.Color(240, 240, 240));
        txtModoClientes.setText("MODO REGISTRO");
        barraClientes.add(txtModoClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 60));

        txtClientesTitulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtClientesTitulo.setForeground(new java.awt.Color(240, 240, 240));
        txtClientesTitulo.setText("CLIENTES");
        barraClientes.add(txtClientesTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 30));

        btnModoRegistrarClientes.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoRegistrarClientes.setForeground(new java.awt.Color(230, 230, 230));
        btnModoRegistrarClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoRegistrarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add-16.png"))); // NOI18N
        btnModoRegistrarClientes.setText("Registrar");
        btnModoRegistrarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraClientes.add(btnModoRegistrarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 90, 30));

        btnModoModificarClientes.setBackground(new java.awt.Color(72, 58, 125));
        btnModoModificarClientes.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoModificarClientes.setForeground(new java.awt.Color(230, 230, 230));
        btnModoModificarClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoModificarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit-2-16.png"))); // NOI18N
        btnModoModificarClientes.setText("Modificar");
        btnModoModificarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraClientes.add(btnModoModificarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 90, 30));

        btnModoEliminarClientes.setBackground(new java.awt.Color(72, 58, 125));
        btnModoEliminarClientes.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoEliminarClientes.setForeground(new java.awt.Color(230, 230, 230));
        btnModoEliminarClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoEliminarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/x-mark-4-16.png"))); // NOI18N
        btnModoEliminarClientes.setText("Eliminar");
        btnModoEliminarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraClientes.add(btnModoEliminarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 90, 30));

        btnModoConsultarClientes.setBackground(new java.awt.Color(72, 58, 125));
        btnModoConsultarClientes.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoConsultarClientes.setForeground(new java.awt.Color(230, 230, 230));
        btnModoConsultarClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoConsultarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search-15-16.png"))); // NOI18N
        btnModoConsultarClientes.setText("Consultar");
        btnModoConsultarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraClientes.add(btnModoConsultarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, 90, 30));

        panelClientes.add(barraClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 100));

        messageClientes.setBackground(new java.awt.Color(0, 153, 153));
        messageClientes.setForeground(new java.awt.Color(33, 235, 103));
        messageClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messageClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMessageClientes.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtMessageClientes.setForeground(new java.awt.Color(240, 240, 240));
        txtMessageClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMessageClientes.setText("AQUI SE MOSTRARAN LOS MENSAJES DE LAS ACCIONES");
        messageClientes.add(txtMessageClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 930, 50));

        panelClientes.add(messageClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1020, 50));

        jPanelPrincipal.add(panelClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 1020, 680));

        panelInicio.setBackground(new java.awt.Color(240, 240, 240));
        panelInicio.setForeground(new java.awt.Color(240, 240, 240));
        panelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraInicioPane.setBackground(new java.awt.Color(0, 65, 130));
        barraInicioPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSeleccionaAccion.setFont(new java.awt.Font("Roboto", 2, 24)); // NOI18N
        txtSeleccionaAccion.setForeground(new java.awt.Color(240, 240, 240));
        txtSeleccionaAccion.setText("SELECCIONA ALGUNA DE LAS OPCIONES DE LA IZQUIERDA");
        barraInicioPane.add(txtSeleccionaAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 60));

        txtInicioTitulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtInicioTitulo.setForeground(new java.awt.Color(240, 240, 240));
        txtInicioTitulo.setText("PANTALLA DE INICIO");
        barraInicioPane.add(txtInicioTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        panelInicio.add(barraInicioPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 100));

        txtWelcomeUser.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        txtWelcomeUser.setForeground(new java.awt.Color(50, 50, 50));
        txtWelcomeUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtWelcomeUser.setText("Bienvenido al SISTEMA");
        txtWelcomeUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelInicio.add(txtWelcomeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1020, 80));

        txtLogoMain.setFont(new java.awt.Font("Calibri", 1, 64)); // NOI18N
        txtLogoMain.setForeground(new java.awt.Color(50, 50, 50));
        txtLogoMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtLogoMain.setText("FASTEL");
        panelInicio.add(txtLogoMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 1020, 80));

        messagePaneInicio.setBackground(new java.awt.Color(0, 153, 153));
        messagePaneInicio.setForeground(new java.awt.Color(33, 235, 103));
        messagePaneInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messagePaneInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMessageInicio.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtMessageInicio.setForeground(new java.awt.Color(240, 240, 240));
        txtMessageInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMessageInicio.setText("POWERED BY APACHE FRIJOLES NETOS");
        messagePaneInicio.add(txtMessageInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 930, 50));

        panelInicio.add(messagePaneInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1020, 50));

        jPanelPrincipal.add(panelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 1020, 680));

        getContentPane().add(jPanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setExtendedState(ICONIFIED);
        this.setExtendedState(1);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    //=======================================================
    // Metodos de la barra de la ventana 
    //=======================================================
    int xMouse, yMouse;

    private void barraVentanaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraVentanaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_barraVentanaMousePressed

    private void barraVentanaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraVentanaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_barraVentanaMouseDragged

    // ===========================================================
    // Cambios de color en los botones del menu
    //=============================================================

    private void btnClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseEntered
        btnClientes.setBackground(btnColorHover);
    }//GEN-LAST:event_btnClientesMouseEntered

    private void btnClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseExited
        btnClientes.setBackground(btnColorReset);
    }//GEN-LAST:event_btnClientesMouseExited

    private void btnReservacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservacionesMouseEntered
        btnReservaciones.setBackground(btnColorHover);
    }//GEN-LAST:event_btnReservacionesMouseEntered

    private void btnReservacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservacionesMouseExited
        btnReservaciones.setBackground(btnColorReset);
    }//GEN-LAST:event_btnReservacionesMouseExited

    private void btnHabitacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHabitacionesMouseEntered
        btnHabitaciones.setBackground(btnColorHover);
    }//GEN-LAST:event_btnHabitacionesMouseEntered

    private void btnHabitacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHabitacionesMouseExited
        btnHabitaciones.setBackground(btnColorReset);
    }//GEN-LAST:event_btnHabitacionesMouseExited

    private void btnEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadosMouseEntered
        btnEmpleados.setBackground(btnColorHover);
    }//GEN-LAST:event_btnEmpleadosMouseEntered

    private void btnEmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadosMouseExited
        btnEmpleados.setBackground(btnColorReset);
    }//GEN-LAST:event_btnEmpleadosMouseExited

    private void btnReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseEntered
        btnReportes.setBackground(btnColorHover);
    }//GEN-LAST:event_btnReportesMouseEntered

    private void btnReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseExited
        btnReportes.setBackground(btnColorReset);
    }//GEN-LAST:event_btnReportesMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraClientes;
    private javax.swing.JPanel barraInicioPane;
    private javax.swing.JPanel barraReservaciones;
    private javax.swing.JPanel barraVentana;
    private javax.swing.JPanel btnClientes;
    private javax.swing.JLabel btnClose;
    private javax.swing.JPanel btnEmpleados;
    private javax.swing.JPanel btnHabitaciones;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnModoConsultarClientes;
    private javax.swing.JLabel btnModoConsultarReservaciones;
    private javax.swing.JLabel btnModoEliminarClientes;
    private javax.swing.JLabel btnModoEliminarReservaciones;
    private javax.swing.JLabel btnModoModificarClientes;
    private javax.swing.JLabel btnModoModificarReservaciones;
    private javax.swing.JLabel btnModoRegistrarClientes;
    private javax.swing.JLabel btnModoRegistrarReservaciones;
    private javax.swing.JPanel btnReportes;
    private javax.swing.JPanel btnReservaciones;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel messageClientes;
    private javax.swing.JPanel messagePaneInicio;
    private javax.swing.JPanel messageReservaciones;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelReservaciones;
    private javax.swing.JPanel sideMenu;
    private javax.swing.JLabel txtClientes;
    private javax.swing.JLabel txtClientesTitulo;
    private javax.swing.JLabel txtEmpleados;
    private javax.swing.JLabel txtHabitaciones;
    private javax.swing.JLabel txtInicioTitulo;
    private javax.swing.JLabel txtLogo;
    private javax.swing.JLabel txtLogoMain;
    private javax.swing.JLabel txtMessageClientes;
    private javax.swing.JLabel txtMessageInicio;
    private javax.swing.JLabel txtMessageReservaciones;
    private javax.swing.JLabel txtModoClientes;
    private javax.swing.JLabel txtModoReservaciones;
    private javax.swing.JLabel txtReportes;
    private javax.swing.JLabel txtReservaciones;
    private javax.swing.JLabel txtReservacionesTitulo;
    private javax.swing.JLabel txtSeleccionaAccion;
    private javax.swing.JLabel txtWelcomeUser;
    private javax.swing.JLabel txtcClientes2;
    private javax.swing.JLabel txtcClientes3;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
