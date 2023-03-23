/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import conexionBD.ConexionBD;
import controlador.ClienteDAO;
import controlador.HabitacionDAO;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URI;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Cliente;
import modelo.Habitacion;

/**
 *
 * @author KHerrera
 */
public class VentanaPrincipal extends javax.swing.JFrame implements KeyListener {

    Color btnColorHover;
    Color btnColorMain;
    Color btnColorReset;
    Color panelMessageColor;
    Color colorAlta;
    Color colorCambio;
    Color colorBaja;
    Color colorError;
    Color colorBtnAgregar;

    String modoCliente = "alta";
    String modoReservacion = "alta";
    String modoHabitacion = "alta";
    String modoEmpleado = "alta";

    Cliente cliente;
    ClienteDAO clienteDAO;

    Habitacion habitacion;
    HabitacionDAO habitacionDAO;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        ConexionBD.getConexion();

        cliente = new Cliente();
        clienteDAO = new ClienteDAO();

        habitacion = new Habitacion();
        habitacionDAO = new HabitacionDAO();

        // Seleccionar tema aleatorio
        Random rand = new Random();
        double randomNum = rand.nextDouble();

        Color btnColorHover1 = new Color(0, 79, 160);
        Color btnColorMain1 = new Color(0, 65, 130);
        Color btnColorReset1 = new Color(0, 79, 146);

        btnColorMain = horaDelRandomizer(btnColorMain1, randomNum);
        btnColorHover = horaDelRandomizer(btnColorHover1, randomNum);
        btnColorReset = horaDelRandomizer(btnColorReset1, randomNum);

        /*
        if (intRandom == 1) {
            btnColorHover = new Color(0, 79, 160);
            btnColorMain = new Color(0, 65, 130);
            btnColorReset = new Color(0, 79, 146);
        } else if (intRandom == 2) {
            btnColorHover = new Color(160, 79, 160);
            btnColorMain = new Color(130, 65, 130);
            btnColorReset = new Color(146, 79, 146);
        } else if (intRandom == 3) {
            btnColorHover = new Color(79, 160, 160);
            btnColorMain = new Color(65, 130, 130);
            btnColorReset = new Color(79, 146, 146);
        }
         */
        // Declaracion de colores
        panelMessageColor = new Color(0, 153, 153);
        colorAlta = new Color(0, 179, 77);
        colorBaja = new Color(219, 0, 84);
        colorCambio = new Color(219, 168, 0);
        colorError = new Color(214, 2, 31);
        colorBtnAgregar = new Color(72, 58, 125);

        // inicializacion de componentes        
        initComponents();

        // Centrar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);

        // ocultar paneles
        ocultarPaneles(panelInicio);

        // desabilitar cajas no editables
        cajaIdCliente.setEnabled(false);
        cajaFechaRegistroCliente.setEnabled(false);

        actualizarTablaClientes();
        actualizarTablaHabitaciones();

        kdance.setVisible(false);

        // key listeners
        cajaNombreCliente.addKeyListener(this);
        cajaApellidoCliente.addKeyListener(this);
        cajaRfcCliente.addKeyListener(this);
        cajaTelefonoCliente.addKeyListener(this);
        cajaIdCliente.addKeyListener(this);
        cajaFechaRegistroCliente.addKeyListener(this);
        cajaIdHabitacion.addKeyListener(this);
        cajaPrecioHabitacion.addKeyListener(this);

        // datos de prueba si me da tiempo los cargo de la base de datos
        String[] datos = {"selecciona opcion", "sencilla", "doble", "estandar", "familiar"};

        for (String dato : datos) {
            comboTipoHabitacion.addItem(dato);
        }
    }

    private Color horaDelRandomizer(Color color1, double randomNum) {
        float[] hsb = Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), null);
        float hue = hsb[0]; // Obtenemos el valor de hue
        float saturation = hsb[1]; // Obtenemos el valor de saturación
        float brightness = hsb[2]; // Obtenemos el valor de brillo
        return Color.getHSBColor(hue + (float) randomNum, saturation, brightness);
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
        panelHabitaciones = new javax.swing.JPanel();
        barraHabitaciones = new javax.swing.JPanel();
        txtModoHabitaciones = new javax.swing.JLabel();
        txtHabitacionesTitulo = new javax.swing.JLabel();
        btnModoRegistrarHabitaciones = new javax.swing.JLabel();
        btnModoModificarHabitaciones = new javax.swing.JLabel();
        btnModoEliminarHabitaciones = new javax.swing.JLabel();
        btnModoConsultarHabitaciones = new javax.swing.JLabel();
        messageHabitaciones = new javax.swing.JPanel();
        txtMessageHabitaciones = new javax.swing.JLabel();
        jScrollPaneTablaHabitaciones = new javax.swing.JScrollPane();
        tablaHabitaciones = new javax.swing.JTable();
        txtIdHabitacion = new javax.swing.JLabel();
        btnAgregarHabitaciones = new javax.swing.JPanel();
        txtAgregarHabitaciones = new javax.swing.JLabel();
        btnVaciarHabitaciones = new javax.swing.JPanel();
        txtVaciar1 = new javax.swing.JLabel();
        btnVerTodoHabitaciones = new javax.swing.JPanel();
        txtVerTodo1 = new javax.swing.JLabel();
        txtPrecioNoche = new javax.swing.JLabel();
        txtBajaTemporal = new javax.swing.JLabel();
        txtDisponible = new javax.swing.JLabel();
        txtTipoHabitacion = new javax.swing.JLabel();
        txtIntroduceDatosHabitacion = new javax.swing.JLabel();
        checkBajaTemporal = new javax.swing.JCheckBox();
        checkDisponibleHabitacion = new javax.swing.JCheckBox();
        comboTipoHabitacion = new javax.swing.JComboBox<>();
        cajaIdHabitacion = new javax.swing.JTextField();
        cajaPrecioHabitacion = new javax.swing.JTextField();
        panelInicio = new javax.swing.JPanel();
        barraInicioPane = new javax.swing.JPanel();
        txtSeleccionaAccion = new javax.swing.JLabel();
        txtInicioTitulo = new javax.swing.JLabel();
        txtWelcomeUser = new javax.swing.JLabel();
        txtLogoMain = new javax.swing.JLabel();
        messagePaneInicio = new javax.swing.JPanel();
        btnGithub = new javax.swing.JLabel();
        btnTwitter = new javax.swing.JLabel();
        btnTiktok = new javax.swing.JLabel();
        btnFacebook = new javax.swing.JLabel();
        btnYoutube = new javax.swing.JLabel();
        btnInstagram = new javax.swing.JLabel();
        kdance = new javax.swing.JLabel();
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
        txtNombre = new javax.swing.JLabel();
        txtIntroduceDatos = new javax.swing.JLabel();
        txtApellido = new javax.swing.JLabel();
        txtRfc = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        txtFormatoFecha = new javax.swing.JLabel();
        btnVerTodo = new javax.swing.JPanel();
        txtVerTodo = new javax.swing.JLabel();
        btnVaciar = new javax.swing.JPanel();
        txtVaciar = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JPanel();
        txtAgregar = new javax.swing.JLabel();
        jScrollTablaClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        txtFechaRegistro1 = new javax.swing.JLabel();
        cajaFechaRegistroCliente = new javax.swing.JTextField();
        cajaNombreCliente = new javax.swing.JTextField();
        cajaApellidoCliente = new javax.swing.JTextField();
        cajaIdCliente = new javax.swing.JTextField();
        cajaRfcCliente = new javax.swing.JTextField();
        cajaTelefonoCliente = new javax.swing.JTextField();
        panelEmpleados = new javax.swing.JPanel();
        barraEmpleados = new javax.swing.JPanel();
        txtModoEmpleados = new javax.swing.JLabel();
        txtEmpleadosTitulo = new javax.swing.JLabel();
        btnModoRegistrarEmpleados = new javax.swing.JLabel();
        btnModoModificarEmpleados = new javax.swing.JLabel();
        btnModoEliminarEmpleados = new javax.swing.JLabel();
        btnModoConsultarEmpleados = new javax.swing.JLabel();
        messageEmpleados = new javax.swing.JPanel();
        txtMessageEmpleados = new javax.swing.JLabel();
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
        panelReportes = new javax.swing.JPanel();
        barraReportes = new javax.swing.JPanel();
        txtGenerarReportes = new javax.swing.JLabel();
        txtReportesTitulo = new javax.swing.JLabel();
        messageReportes = new javax.swing.JPanel();
        txtMessageReportes = new javax.swing.JLabel();
        btnReportePane = new javax.swing.JPanel();
        txtReporteIcon = new javax.swing.JLabel();
        txtReporteGenerar = new javax.swing.JLabel();
        btnComenzar = new javax.swing.JPanel();
        txtComenzar = new javax.swing.JLabel();
        btnGraficoPane = new javax.swing.JPanel();
        txtIconGrafico = new javax.swing.JLabel();
        txtGenerarReporte = new javax.swing.JLabel();
        btnGenerarGrafico = new javax.swing.JPanel();
        txtComenzarGrafico = new javax.swing.JLabel();
        txtQueGenerar = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Inicio");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPrincipal.setBackground(new java.awt.Color(240, 240, 240));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHabitaciones.setBackground(new java.awt.Color(240, 240, 240));
        panelHabitaciones.setForeground(new java.awt.Color(240, 240, 240));
        panelHabitaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraHabitaciones.setBackground(btnColorMain);
        barraHabitaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtModoHabitaciones.setFont(new java.awt.Font("Roboto", 2, 24)); // NOI18N
        txtModoHabitaciones.setForeground(new java.awt.Color(240, 240, 240));
        txtModoHabitaciones.setText("MODO REGISTRO");
        barraHabitaciones.add(txtModoHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 60));

        txtHabitacionesTitulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtHabitacionesTitulo.setForeground(new java.awt.Color(240, 240, 240));
        txtHabitacionesTitulo.setText("HABITACIONES");
        barraHabitaciones.add(txtHabitacionesTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 30));

        btnModoRegistrarHabitaciones.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoRegistrarHabitaciones.setForeground(new java.awt.Color(230, 230, 230));
        btnModoRegistrarHabitaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoRegistrarHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add-16.png"))); // NOI18N
        btnModoRegistrarHabitaciones.setText("Registrar");
        btnModoRegistrarHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModoRegistrarHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModoRegistrarHabitacionesMouseClicked(evt);
            }
        });
        barraHabitaciones.add(btnModoRegistrarHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 90, 30));

        btnModoModificarHabitaciones.setBackground(new java.awt.Color(72, 58, 125));
        btnModoModificarHabitaciones.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoModificarHabitaciones.setForeground(new java.awt.Color(230, 230, 230));
        btnModoModificarHabitaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoModificarHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit-2-16.png"))); // NOI18N
        btnModoModificarHabitaciones.setText("Modificar");
        btnModoModificarHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModoModificarHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModoModificarHabitacionesMouseClicked(evt);
            }
        });
        barraHabitaciones.add(btnModoModificarHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 90, 30));

        btnModoEliminarHabitaciones.setBackground(new java.awt.Color(72, 58, 125));
        btnModoEliminarHabitaciones.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoEliminarHabitaciones.setForeground(new java.awt.Color(230, 230, 230));
        btnModoEliminarHabitaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoEliminarHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/x-mark-4-16.png"))); // NOI18N
        btnModoEliminarHabitaciones.setText("Eliminar");
        btnModoEliminarHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModoEliminarHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModoEliminarHabitacionesMouseClicked(evt);
            }
        });
        barraHabitaciones.add(btnModoEliminarHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 90, 30));

        btnModoConsultarHabitaciones.setBackground(new java.awt.Color(72, 58, 125));
        btnModoConsultarHabitaciones.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoConsultarHabitaciones.setForeground(new java.awt.Color(230, 230, 230));
        btnModoConsultarHabitaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoConsultarHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search-15-16.png"))); // NOI18N
        btnModoConsultarHabitaciones.setText("Consultar");
        btnModoConsultarHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModoConsultarHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModoConsultarHabitacionesMouseClicked(evt);
            }
        });
        barraHabitaciones.add(btnModoConsultarHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, 90, 30));

        panelHabitaciones.add(barraHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 100));

        messageHabitaciones.setBackground(panelMessageColor);
        messageHabitaciones.setForeground(new java.awt.Color(33, 235, 103));
        messageHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messageHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageHabitacionesMouseClicked(evt);
            }
        });
        messageHabitaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMessageHabitaciones.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtMessageHabitaciones.setForeground(new java.awt.Color(240, 240, 240));
        txtMessageHabitaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMessageHabitaciones.setText("AQUI SE MOSTRARAN LOS MENSAJES DE LAS ACCIONES (puedes darme clic para ocultarme)");
        messageHabitaciones.add(txtMessageHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 930, 50));

        panelHabitaciones.add(messageHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1020, 50));

        tablaHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaHabitaciones.setOpaque(false);
        tablaHabitaciones.setRequestFocusEnabled(false);
        tablaHabitaciones.setRowHeight(25);
        tablaHabitaciones.setSelectionBackground(btnColorMain);
        tablaHabitaciones.setSelectionForeground(new java.awt.Color(220, 220, 220));
        tablaHabitaciones.setShowGrid(false);
        tablaHabitaciones.getTableHeader().setResizingAllowed(false);
        tablaHabitaciones.getTableHeader().setReorderingAllowed(false);
        tablaHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaHabitacionesMouseReleased(evt);
            }
        });
        jScrollPaneTablaHabitaciones.setViewportView(tablaHabitaciones);

        panelHabitaciones.add(jScrollPaneTablaHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 930, 190));

        txtIdHabitacion.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        txtIdHabitacion.setForeground(btnColorMain);
        txtIdHabitacion.setText("ID del la HABITACION");
        panelHabitaciones.add(txtIdHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 140, 30));

        btnAgregarHabitaciones.setBackground(new java.awt.Color(72, 58, 125));
        btnAgregarHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarHabitacionesMouseClicked(evt);
            }
        });
        btnAgregarHabitaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAgregarHabitaciones.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtAgregarHabitaciones.setForeground(new java.awt.Color(240, 240, 240));
        txtAgregarHabitaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAgregarHabitaciones.setText("AGREGAR");
        btnAgregarHabitaciones.add(txtAgregarHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 0, 97, 30));

        panelHabitaciones.add(btnAgregarHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 310, 140, 30));

        btnVaciarHabitaciones.setBackground(new java.awt.Color(0, 153, 153));
        btnVaciarHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVaciarHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVaciarHabitacionesMouseClicked(evt);
            }
        });
        btnVaciarHabitaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtVaciar1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtVaciar1.setForeground(new java.awt.Color(240, 240, 240));
        txtVaciar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtVaciar1.setText("VACIAR");
        btnVaciarHabitaciones.add(txtVaciar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 30));

        panelHabitaciones.add(btnVaciarHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, 140, 30));

        btnVerTodoHabitaciones.setBackground(new java.awt.Color(153, 0, 153));
        btnVerTodoHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerTodoHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerTodoHabitacionesMouseClicked(evt);
            }
        });
        btnVerTodoHabitaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtVerTodo1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtVerTodo1.setForeground(new java.awt.Color(240, 240, 240));
        txtVerTodo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtVerTodo1.setText("VER TODOS");
        btnVerTodoHabitaciones.add(txtVerTodo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 30));

        panelHabitaciones.add(btnVerTodoHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, 140, 30));

        txtPrecioNoche.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        txtPrecioNoche.setForeground(new java.awt.Color(50, 50, 50));
        txtPrecioNoche.setText("precio por noche");
        panelHabitaciones.add(txtPrecioNoche, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 140, 30));

        txtBajaTemporal.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        txtBajaTemporal.setForeground(new java.awt.Color(50, 50, 50));
        txtBajaTemporal.setText("baja temporal");
        panelHabitaciones.add(txtBajaTemporal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 110, 30));

        txtDisponible.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        txtDisponible.setForeground(new java.awt.Color(50, 50, 50));
        txtDisponible.setText("disponible");
        panelHabitaciones.add(txtDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 90, 30));

        txtTipoHabitacion.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        txtTipoHabitacion.setForeground(new java.awt.Color(50, 50, 50));
        txtTipoHabitacion.setText("tipo de habitacion");
        panelHabitaciones.add(txtTipoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 140, 30));

        txtIntroduceDatosHabitacion.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtIntroduceDatosHabitacion.setForeground(new java.awt.Color(90, 90, 90));
        txtIntroduceDatosHabitacion.setText("Introduce los datos solicitados");
        panelHabitaciones.add(txtIntroduceDatosHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));
        panelHabitaciones.add(checkBajaTemporal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 30, 30));
        panelHabitaciones.add(checkDisponibleHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 30, 30));

        comboTipoHabitacion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        panelHabitaciones.add(comboTipoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 140, 30));
        panelHabitaciones.add(cajaIdHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 140, 30));
        panelHabitaciones.add(cajaPrecioHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 140, 30));

        jPanelPrincipal.add(panelHabitaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 1020, 680));

        panelInicio.setBackground(new java.awt.Color(240, 240, 240));
        panelInicio.setForeground(new java.awt.Color(240, 240, 240));
        panelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraInicioPane.setBackground(btnColorMain);
        barraInicioPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSeleccionaAccion.setFont(new java.awt.Font("Roboto", 2, 24)); // NOI18N
        txtSeleccionaAccion.setForeground(new java.awt.Color(240, 240, 240));
        txtSeleccionaAccion.setText("SELECCIONA ALGUNA DE LAS OPCIONES DE LA IZQUIERDA");
        barraInicioPane.add(txtSeleccionaAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 60));

        txtInicioTitulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtInicioTitulo.setForeground(new java.awt.Color(240, 240, 240));
        txtInicioTitulo.setText("PANTALLA DE INICIO");
        barraInicioPane.add(txtInicioTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 30));

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

        messagePaneInicio.setBackground(panelMessageColor);
        messagePaneInicio.setForeground(new java.awt.Color(33, 235, 103));
        messagePaneInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messagePaneInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGithub.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGithub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/git_de_la_minita.png"))); // NOI18N
        btnGithub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGithubMouseClicked(evt);
            }
        });
        messagePaneInicio.add(btnGithub, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 50, 50));

        btnTwitter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTwitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/tuito.png"))); // NOI18N
        messagePaneInicio.add(btnTwitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 50, 50));

        btnTiktok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTiktok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/titok.png"))); // NOI18N
        messagePaneInicio.add(btnTiktok, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 50, 50));

        btnFacebook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFacebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/facebu.png"))); // NOI18N
        messagePaneInicio.add(btnFacebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 50, 50));

        btnYoutube.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnYoutube.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/yutu.png"))); // NOI18N
        messagePaneInicio.add(btnYoutube, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 50, 50));

        btnInstagram.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInstagram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/itagran.png"))); // NOI18N
        messagePaneInicio.add(btnInstagram, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 50, 50));

        panelInicio.add(messagePaneInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1020, 50));

        kdance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/kdance.gif"))); // NOI18N
        panelInicio.add(kdance, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 480, -1, -1));

        jPanelPrincipal.add(panelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 1020, 680));

        panelClientes.setBackground(new java.awt.Color(240, 240, 240));
        panelClientes.setForeground(new java.awt.Color(240, 240, 240));
        panelClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraClientes.setBackground(btnColorMain);
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
        btnModoRegistrarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModoRegistrarClientesMouseClicked(evt);
            }
        });
        barraClientes.add(btnModoRegistrarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 90, 30));

        btnModoModificarClientes.setBackground(new java.awt.Color(72, 58, 125));
        btnModoModificarClientes.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoModificarClientes.setForeground(new java.awt.Color(230, 230, 230));
        btnModoModificarClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoModificarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit-2-16.png"))); // NOI18N
        btnModoModificarClientes.setText("Modificar");
        btnModoModificarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModoModificarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModoModificarClientesMouseClicked(evt);
            }
        });
        barraClientes.add(btnModoModificarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 90, 30));

        btnModoEliminarClientes.setBackground(new java.awt.Color(72, 58, 125));
        btnModoEliminarClientes.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoEliminarClientes.setForeground(new java.awt.Color(230, 230, 230));
        btnModoEliminarClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoEliminarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/x-mark-4-16.png"))); // NOI18N
        btnModoEliminarClientes.setText("Eliminar");
        btnModoEliminarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModoEliminarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModoEliminarClientesMouseClicked(evt);
            }
        });
        barraClientes.add(btnModoEliminarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 90, 30));

        btnModoConsultarClientes.setBackground(new java.awt.Color(72, 58, 125));
        btnModoConsultarClientes.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoConsultarClientes.setForeground(new java.awt.Color(230, 230, 230));
        btnModoConsultarClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoConsultarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search-15-16.png"))); // NOI18N
        btnModoConsultarClientes.setText("Consultar");
        btnModoConsultarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModoConsultarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModoConsultarClientesMouseClicked(evt);
            }
        });
        barraClientes.add(btnModoConsultarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, 90, 30));

        panelClientes.add(barraClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 100));

        messageClientes.setBackground(panelMessageColor);
        messageClientes.setForeground(new java.awt.Color(33, 235, 103));
        messageClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messageClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageClientesMouseClicked(evt);
            }
        });
        messageClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMessageClientes.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtMessageClientes.setForeground(new java.awt.Color(240, 240, 240));
        txtMessageClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMessageClientes.setText("AQUI SE MOSTRARAN LOS MENSAJES DE LAS ACCIONES (puedes darme clic para ocultarme)");
        messageClientes.add(txtMessageClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 930, 50));

        panelClientes.add(messageClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1020, 50));

        txtNombre.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(50, 50, 50));
        txtNombre.setText("nombre");
        panelClientes.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 140, 30));

        txtIntroduceDatos.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtIntroduceDatos.setForeground(new java.awt.Color(90, 90, 90));
        txtIntroduceDatos.setText("Introduce los datos solicitados");
        panelClientes.add(txtIntroduceDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        txtApellido.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(50, 50, 50));
        txtApellido.setText("apellido");
        panelClientes.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 140, 30));

        txtRfc.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        txtRfc.setForeground(new java.awt.Color(50, 50, 50));
        txtRfc.setText("rfc");
        panelClientes.add(txtRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 140, 30));

        txtIdCliente.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        txtIdCliente.setForeground(btnColorMain);
        txtIdCliente.setText("ID del CLIENTE");
        panelClientes.add(txtIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 140, 30));

        txtTelefono.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(50, 50, 50));
        txtTelefono.setText("telefono");
        panelClientes.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 140, 30));

        txtFormatoFecha.setFont(new java.awt.Font("Roboto", 2, 10)); // NOI18N
        txtFormatoFecha.setForeground(new java.awt.Color(50, 50, 50));
        txtFormatoFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtFormatoFecha.setText("formato aaaa-mm-dd");
        txtFormatoFecha.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelClientes.add(txtFormatoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 140, 30));

        btnVerTodo.setBackground(new java.awt.Color(153, 0, 153));
        btnVerTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerTodoMouseClicked(evt);
            }
        });
        btnVerTodo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtVerTodo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtVerTodo.setForeground(new java.awt.Color(240, 240, 240));
        txtVerTodo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtVerTodo.setText("VER TODOS");
        btnVerTodo.add(txtVerTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 30));

        panelClientes.add(btnVerTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, 140, 30));

        btnVaciar.setBackground(new java.awt.Color(0, 153, 153));
        btnVaciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVaciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVaciarMouseClicked(evt);
            }
        });
        btnVaciar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtVaciar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtVaciar.setForeground(new java.awt.Color(240, 240, 240));
        txtVaciar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtVaciar.setText("VACIAR");
        btnVaciar.add(txtVaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 30));

        panelClientes.add(btnVaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, 140, 30));

        btnAgregar.setBackground(new java.awt.Color(72, 58, 125));
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAgregar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtAgregar.setForeground(new java.awt.Color(240, 240, 240));
        txtAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAgregar.setText("AGREGAR");
        btnAgregar.add(txtAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 0, 97, 30));

        panelClientes.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 310, 140, 30));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaClientes.setOpaque(false);
        tablaClientes.setRequestFocusEnabled(false);
        tablaClientes.setRowHeight(25);
        tablaClientes.setSelectionBackground(btnColorMain);
        tablaClientes.setSelectionForeground(new java.awt.Color(220, 220, 220));
        tablaClientes.setShowGrid(false);
        tablaClientes.getTableHeader().setResizingAllowed(false);
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaClientesMouseReleased(evt);
            }
        });
        jScrollTablaClientes.setViewportView(tablaClientes);

        panelClientes.add(jScrollTablaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 930, 190));

        txtFechaRegistro1.setFont(new java.awt.Font("Roboto", 2, 12)); // NOI18N
        txtFechaRegistro1.setForeground(new java.awt.Color(50, 50, 50));
        txtFechaRegistro1.setText("fecha registro");
        panelClientes.add(txtFechaRegistro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 140, 30));
        panelClientes.add(cajaFechaRegistroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 140, 30));
        panelClientes.add(cajaNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 140, 30));
        panelClientes.add(cajaApellidoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 140, 30));
        panelClientes.add(cajaIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 140, 30));
        panelClientes.add(cajaRfcCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 140, 30));
        panelClientes.add(cajaTelefonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 140, 30));

        jPanelPrincipal.add(panelClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 1020, 680));

        panelEmpleados.setBackground(new java.awt.Color(240, 240, 240));
        panelEmpleados.setForeground(new java.awt.Color(240, 240, 240));
        panelEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraEmpleados.setBackground(btnColorMain);
        barraEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtModoEmpleados.setFont(new java.awt.Font("Roboto", 2, 24)); // NOI18N
        txtModoEmpleados.setForeground(new java.awt.Color(240, 240, 240));
        txtModoEmpleados.setText("MODO REGISTRO");
        barraEmpleados.add(txtModoEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 60));

        txtEmpleadosTitulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtEmpleadosTitulo.setForeground(new java.awt.Color(240, 240, 240));
        txtEmpleadosTitulo.setText("EMPLEADOS");
        barraEmpleados.add(txtEmpleadosTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 30));

        btnModoRegistrarEmpleados.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoRegistrarEmpleados.setForeground(new java.awt.Color(230, 230, 230));
        btnModoRegistrarEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoRegistrarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add-16.png"))); // NOI18N
        btnModoRegistrarEmpleados.setText("Registrar");
        btnModoRegistrarEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraEmpleados.add(btnModoRegistrarEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 90, 30));

        btnModoModificarEmpleados.setBackground(new java.awt.Color(72, 58, 125));
        btnModoModificarEmpleados.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoModificarEmpleados.setForeground(new java.awt.Color(230, 230, 230));
        btnModoModificarEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoModificarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit-2-16.png"))); // NOI18N
        btnModoModificarEmpleados.setText("Modificar");
        btnModoModificarEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraEmpleados.add(btnModoModificarEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 90, 30));

        btnModoEliminarEmpleados.setBackground(new java.awt.Color(72, 58, 125));
        btnModoEliminarEmpleados.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoEliminarEmpleados.setForeground(new java.awt.Color(230, 230, 230));
        btnModoEliminarEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoEliminarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/x-mark-4-16.png"))); // NOI18N
        btnModoEliminarEmpleados.setText("Eliminar");
        btnModoEliminarEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraEmpleados.add(btnModoEliminarEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 90, 30));

        btnModoConsultarEmpleados.setBackground(new java.awt.Color(72, 58, 125));
        btnModoConsultarEmpleados.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        btnModoConsultarEmpleados.setForeground(new java.awt.Color(230, 230, 230));
        btnModoConsultarEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModoConsultarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/search-15-16.png"))); // NOI18N
        btnModoConsultarEmpleados.setText("Consultar");
        btnModoConsultarEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraEmpleados.add(btnModoConsultarEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, 90, 30));

        panelEmpleados.add(barraEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 100));

        messageEmpleados.setBackground(panelMessageColor);
        messageEmpleados.setForeground(new java.awt.Color(33, 235, 103));
        messageEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messageEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageEmpleadosMouseClicked(evt);
            }
        });
        messageEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMessageEmpleados.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtMessageEmpleados.setForeground(new java.awt.Color(240, 240, 240));
        txtMessageEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMessageEmpleados.setText("AQUI SE MOSTRARAN LOS MENSAJES DE LAS ACCIONES (puedes darme clic para ocultarme)");
        messageEmpleados.add(txtMessageEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 930, 50));

        panelEmpleados.add(messageEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1020, 50));

        jPanelPrincipal.add(panelEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 1020, 680));

        panelReservaciones.setBackground(new java.awt.Color(240, 240, 240));
        panelReservaciones.setForeground(new java.awt.Color(240, 240, 240));
        panelReservaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraReservaciones.setBackground(btnColorMain);
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

        messageReservaciones.setBackground(panelMessageColor);
        messageReservaciones.setForeground(new java.awt.Color(33, 235, 103));
        messageReservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messageReservaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageReservacionesMouseClicked(evt);
            }
        });
        messageReservaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMessageReservaciones.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtMessageReservaciones.setForeground(new java.awt.Color(240, 240, 240));
        txtMessageReservaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMessageReservaciones.setText("AQUI SE MOSTRARAN LOS MENSAJES DE LAS ACCIONES (puedes darme clic para ocultarme)");
        messageReservaciones.add(txtMessageReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 930, 50));

        panelReservaciones.add(messageReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1020, 50));

        jPanelPrincipal.add(panelReservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 1020, 680));

        panelReportes.setBackground(new java.awt.Color(240, 240, 240));
        panelReportes.setForeground(new java.awt.Color(240, 240, 240));
        panelReportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraReportes.setBackground(btnColorMain);
        barraReportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtGenerarReportes.setFont(new java.awt.Font("Roboto", 2, 24)); // NOI18N
        txtGenerarReportes.setForeground(new java.awt.Color(240, 240, 240));
        txtGenerarReportes.setText("REPORTES Y GRAFICOS");
        barraReportes.add(txtGenerarReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 60));

        txtReportesTitulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtReportesTitulo.setForeground(new java.awt.Color(240, 240, 240));
        txtReportesTitulo.setText("REPORTES");
        barraReportes.add(txtReportesTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 30));

        panelReportes.add(barraReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 100));

        messageReportes.setBackground(panelMessageColor);
        messageReportes.setForeground(new java.awt.Color(33, 235, 103));
        messageReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        messageReportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMessageReportes.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtMessageReportes.setForeground(new java.awt.Color(240, 240, 240));
        txtMessageReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMessageReportes.setText("POWERED BY JASPER REPORTS");
        messageReportes.add(txtMessageReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 930, 50));

        panelReportes.add(messageReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 1020, 50));

        btnReportePane.setBackground(btnColorMain);
        btnReportePane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 220, 220), 2, true));
        btnReportePane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtReporteIcon.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtReporteIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtReporteIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-reporte-de-negocios-100 (1).png"))); // NOI18N
        btnReportePane.add(txtReporteIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 190, 130));

        txtReporteGenerar.setBackground(new java.awt.Color(220, 220, 220));
        txtReporteGenerar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtReporteGenerar.setForeground(new java.awt.Color(220, 220, 220));
        txtReporteGenerar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtReporteGenerar.setText("Generar Reporte");
        btnReportePane.add(txtReporteGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 190, 70));

        btnComenzar.setBackground(new java.awt.Color(220, 220, 220));
        btnComenzar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtComenzar.setBackground(new java.awt.Color(220, 220, 220));
        txtComenzar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtComenzar.setForeground(new java.awt.Color(50, 50, 50));
        txtComenzar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtComenzar.setText("COMENZAR");
        btnComenzar.add(txtComenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 0, 220, 40));

        btnReportePane.add(btnComenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 250, 40));

        panelReportes.add(btnReportePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 310, 340));

        btnGraficoPane.setBackground(btnColorMain);
        btnGraficoPane.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 220, 220), 2, true));
        btnGraficoPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGraficoPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIconGrafico.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtIconGrafico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIconGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-reporte-de-negocios-100.png"))); // NOI18N
        btnGraficoPane.add(txtIconGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 190, 130));

        txtGenerarReporte.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtGenerarReporte.setForeground(new java.awt.Color(220, 220, 220));
        txtGenerarReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGenerarReporte.setText("Generar Grafico");
        btnGraficoPane.add(txtGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 190, 70));

        btnGenerarGrafico.setBackground(new java.awt.Color(220, 220, 220));
        btnGenerarGrafico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtComenzarGrafico.setBackground(new java.awt.Color(220, 220, 220));
        txtComenzarGrafico.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtComenzarGrafico.setForeground(new java.awt.Color(50, 50, 50));
        txtComenzarGrafico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtComenzarGrafico.setText("COMENZAR");
        btnGenerarGrafico.add(txtComenzarGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 0, 220, 40));

        btnGraficoPane.add(btnGenerarGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 250, 40));

        panelReportes.add(btnGraficoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 310, 340));

        txtQueGenerar.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtQueGenerar.setForeground(new java.awt.Color(90, 90, 90));
        txtQueGenerar.setText("SELECCIONA LO QUE QUIERES GENERAR");
        panelReportes.add(txtQueGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jPanelPrincipal.add(panelReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 1020, 680));

        barraVentana.setBackground(btnColorMain);
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

        btnMinimize.setBackground(btnColorMain);
        btnMinimize.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
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

        btnClose.setBackground(btnColorMain);
        btnClose.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
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

        sideMenu.setBackground(btnColorMain);
        sideMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLogo.setBackground(btnColorMain);
        txtLogo.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        txtLogo.setForeground(new java.awt.Color(240, 240, 240));
        txtLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtLogo.setText("Fastel");
        txtLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLogoMouseClicked(evt);
            }
        });
        sideMenu.add(txtLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 100));

        userPanel.setBackground(btnColorReset);
        userPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcClientes2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtcClientes2.setForeground(new java.awt.Color(240, 240, 240));
        txtcClientes2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcClientes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/user.png"))); // NOI18N
        userPanel.add(txtcClientes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, 90));

        txtcClientes3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtcClientes3.setForeground(new java.awt.Color(240, 240, 240));
        txtcClientes3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcClientes3.setText("USERNAME");
        userPanel.add(txtcClientes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 260, 30));

        sideMenu.add(userPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 260, 180));

        btnClientes.setBackground(btnColorReset);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesMouseClicked(evt);
            }
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

        btnReservaciones.setBackground(btnColorReset);
        btnReservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReservaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReservacionesMouseClicked(evt);
            }
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

        btnHabitaciones.setBackground(btnColorReset);
        btnHabitaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHabitacionesMouseClicked(evt);
            }
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

        btnEmpleados.setBackground(btnColorReset);
        btnEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpleadosMouseClicked(evt);
            }
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

        btnReportes.setBackground(btnColorReset);
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
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

        getContentPane().add(jPanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ======================================================
    // metodos para actualizar tablas
    // ======================================================
    private void actualizarTablaClientes() {
        ConexionBD.actualizarTabla(tablaClientes, "clientes", "id_cliente");
    }

    private void actualizarTablaHabitaciones() {
        ConexionBD.actualizarTabla(tablaHabitaciones, "habitaciones", "id_habitacion");
    }

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    // ======================================================
    // Personalizacion de mensajes :D
    // ======================================================
    private void mensajePersonalizado(JPanel panel, Color color, String mensaje, JLabel label) {
        panel.setBackground(color);
        label.setText(mensaje);
        panel.setVisible(true);
    }

    private void ocultarPaneles(JPanel panelVisible) {
        panelInicio.setVisible(false);
        panelHabitaciones.setVisible(false);
        panelEmpleados.setVisible(false);
        panelReportes.setVisible(false);
        panelClientes.setVisible(false);
        panelReservaciones.setVisible(false);

        panelVisible.setVisible(true);
    }
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

    // =======================================================
    // Mostrar y ocultar paneles
    // =======================================================

    private void btnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseClicked
        ocultarPaneles(panelClientes);
    }//GEN-LAST:event_btnClientesMouseClicked

    private void btnReservacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservacionesMouseClicked
        ocultarPaneles(panelReservaciones);
    }//GEN-LAST:event_btnReservacionesMouseClicked

    private void btnHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHabitacionesMouseClicked
        ocultarPaneles(panelHabitaciones);
    }//GEN-LAST:event_btnHabitacionesMouseClicked

    private void btnEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpleadosMouseClicked
        ocultarPaneles(panelEmpleados);
    }//GEN-LAST:event_btnEmpleadosMouseClicked

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        ocultarPaneles(panelReportes);
    }//GEN-LAST:event_btnReportesMouseClicked

    int kdanceCount = 1;
    private void txtLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLogoMouseClicked
        ocultarPaneles(panelInicio);
        kdanceCount++;
        if ((kdanceCount % 4) == 0) {
            kdance.setVisible(true);
        } else {
            kdance.setVisible(false);
        }
    }//GEN-LAST:event_txtLogoMouseClicked

    // ===================================================================
    // Ocultar mensajes de ayuda
    // ===================================================================

    private void messageClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageClientesMouseClicked
        messageClientes.setVisible(false);
    }//GEN-LAST:event_messageClientesMouseClicked

    private void messageEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageEmpleadosMouseClicked
        messageEmpleados.setVisible(false);
    }//GEN-LAST:event_messageEmpleadosMouseClicked

    private void messageReservacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageReservacionesMouseClicked
        messageReservaciones.setVisible(false);
    }//GEN-LAST:event_messageReservacionesMouseClicked

    private void messageHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageHabitacionesMouseClicked
        messageHabitaciones.setVisible(false);
    }//GEN-LAST:event_messageHabitacionesMouseClicked

    // =====================================================
    // Metodo hace vidas facil
    // =====================================================
    private void eventoRegistro(JLabel titulo, String modoFormulario,
            JLabel txtBtn, String nombreBtn, JPanel btn, Color color) {

        titulo.setText(modoFormulario);
        txtBtn.setText(nombreBtn);
        btn.setBackground(color);
    }

    private void vaciarCajasClientes() {
        cajaIdCliente.setText("");
        cajaNombreCliente.setText("");
        cajaApellidoCliente.setText("");
        cajaTelefonoCliente.setText("");
        cajaRfcCliente.setText("");
        cajaFechaRegistroCliente.setText("");
    }

    // =====================================================
    // Eventos de registro clientes
    // =====================================================
    public void habilitarCajasClientes() {
        cajaIdCliente.setEnabled(true);
        cajaNombreCliente.setEnabled(true);
        cajaApellidoCliente.setEnabled(true);
        cajaRfcCliente.setEnabled(true);
        cajaTelefonoCliente.setEnabled(true);
        cajaFechaRegistroCliente.setEnabled(true);
    }

    public void desabilitarCajasClientes() {
        cajaIdCliente.setEnabled(false);
        cajaNombreCliente.setEnabled(false);
        cajaApellidoCliente.setEnabled(false);
        cajaRfcCliente.setEnabled(false);
        cajaTelefonoCliente.setEnabled(false);
        cajaFechaRegistroCliente.setEnabled(false);
    }

    private void btnModoRegistrarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModoRegistrarClientesMouseClicked
        eventoRegistro(txtModoClientes, "MODO REGISTRO",
                txtAgregar, "AGREGAR",
                btnAgregar, colorBtnAgregar);
        habilitarCajasClientes();
        cajaIdCliente.setEnabled(false);
        cajaFechaRegistroCliente.setEnabled(false);
        vaciarCajasClientes();
        modoCliente = "alta";

    }//GEN-LAST:event_btnModoRegistrarClientesMouseClicked

    private void btnModoModificarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModoModificarClientesMouseClicked
        eventoRegistro(txtModoClientes, "MODO EDICION",
                txtAgregar, "MODIFICAR",
                btnAgregar, colorCambio);
        habilitarCajasClientes();
        vaciarCajasClientes();
        cajaFechaRegistroCliente.setEnabled(false);
        modoCliente = "cambio";
    }//GEN-LAST:event_btnModoModificarClientesMouseClicked

    private void btnModoEliminarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModoEliminarClientesMouseClicked
        eventoRegistro(txtModoClientes, "MODO ELIMINACION",
                txtAgregar, "ELIMINAR", btnAgregar, colorBaja);
        desabilitarCajasClientes();
        cajaIdCliente.setEnabled(true);
        vaciarCajasClientes();
        modoCliente = "baja";
    }//GEN-LAST:event_btnModoEliminarClientesMouseClicked

    private void btnModoConsultarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModoConsultarClientesMouseClicked
        eventoRegistro(txtModoClientes, "MODO BUSQUEDA",
                txtAgregar, "BUSCAR", btnAgregar, colorBtnAgregar);
        habilitarCajasClientes();
        vaciarCajasClientes();
        modoCliente = "consulta";
    }//GEN-LAST:event_btnModoConsultarClientesMouseClicked

    // ================================================
    // Metodos para los botones del formulario clientes
    // ================================================
    private void btnVaciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVaciarMouseClicked
        vaciarCajasClientes();
    }//GEN-LAST:event_btnVaciarMouseClicked

    private void btnVerTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerTodoMouseClicked
        actualizarTablaClientes();
    }//GEN-LAST:event_btnVerTodoMouseClicked

    //Metodo de personalizacion de mensaje
    public void personalizarMensaje(JLabel txt, String datosFaltantes, JPanel panel, Color color) {
        txt.setText(datosFaltantes);
        panel.setBackground(color);
        panel.setVisible(true);
    }

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked

        String datosFaltantes = "TE FALTAN LOS DATOS DE [";
        boolean isIdCliente = !cajaIdCliente.getText().equals("");
        boolean isNombre = !cajaNombreCliente.getText().equals("");
        boolean isApellido = !cajaApellidoCliente.getText().equals("");
        boolean isTelefono = !cajaTelefonoCliente.getText().equals("");
        boolean isRfc = !cajaRfcCliente.getText().equals("");
        boolean isFecha = !cajaFechaRegistroCliente.getText().equals("");

        if (modoCliente.equals("alta")) {

            if (isNombre && isApellido && isTelefono && isRfc) {

                cliente.setNombre(cajaNombreCliente.getText());
                cliente.setApellido(cajaApellidoCliente.getText());
                cliente.setTelefono(cajaTelefonoCliente.getText());
                cliente.setRfc(cajaRfcCliente.getText());

                clienteDAO.setOpcion(1);
                clienteDAO.setCliente(cliente);

                Thread h1 = new Thread(clienteDAO);
                h1.start();

                try {
                    h1.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                if (clienteDAO.isRes()) {
                    personalizarMensaje(txtMessageClientes, "EXITO AL AGREGAR EL CLIENTE :D", messageClientes, colorAlta);
                    vaciarCajasClientes();
                } else {
                    personalizarMensaje(txtMessageClientes, "ERROR AL AGREGAR EL CLIENTE D:", messageClientes, colorError);
                    vaciarCajasClientes();
                }

                actualizarTablaClientes();

            } else {
                if (!isNombre) {
                    datosFaltantes += " NOMBRE";
                }

                if (!isApellido) {
                    datosFaltantes += " APELLIDO";
                }

                if (!isTelefono) {
                    datosFaltantes += " TELEFONO";
                }

                if (!isRfc) {
                    datosFaltantes += " RFC";
                }

                datosFaltantes += " ]";

                personalizarMensaje(txtMessageClientes, datosFaltantes, messageClientes, colorError);
            }

        } else if (modoCliente.equals("baja")) {
            if (isIdCliente) {
                cliente.setIdCliente(Integer.parseInt(cajaIdCliente.getText()));
                clienteDAO.setOpcion(2);
                clienteDAO.setCliente(cliente);

                Thread h1 = new Thread(clienteDAO);
                h1.start();

                try {
                    h1.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                if (clienteDAO.isRes()) {
                    personalizarMensaje(txtMessageClientes, "EXITO AL ELIMINAR EL CLIENTE", messageClientes, colorBaja);
                    vaciarCajasClientes();
                } else {
                    personalizarMensaje(txtMessageClientes, "ERROR AL ELIMINAR EL CLIENTE", messageClientes, colorError);
                    vaciarCajasClientes();
                }

                actualizarTablaClientes();

            } else {
                personalizarMensaje(txtMessageClientes, "AGREGA EL ID DEL CLIENTE ._.", messageClientes, colorError);
            }

        } else if (modoCliente.equals("cambio")) {

            if (isNombre && isApellido && isTelefono && isRfc && isIdCliente) {

                cliente.setNombre(cajaNombreCliente.getText());
                cliente.setApellido(cajaApellidoCliente.getText());
                cliente.setTelefono(cajaTelefonoCliente.getText());
                cliente.setRfc(cajaRfcCliente.getText());
                cliente.setIdCliente(Integer.parseInt(cajaIdCliente.getText()));

                clienteDAO.setOpcion(3);
                clienteDAO.setCliente(cliente);

                Thread h1 = new Thread(clienteDAO);
                h1.start();

                try {
                    h1.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                if (clienteDAO.isRes()) {
                    personalizarMensaje(txtMessageClientes, "EXITO AL MODIFICAR EL CLIENTE :D", messageClientes, colorCambio);
                    vaciarCajasClientes();
                } else {
                    personalizarMensaje(txtMessageClientes, "ERROR AL MODIFICAR EL CLIENTE D:", messageClientes, colorError);
                    vaciarCajasClientes();
                }

                actualizarTablaClientes();

            } else {
                if (!isNombre) {
                    datosFaltantes += " NOMBRE";
                }

                if (!isApellido) {
                    datosFaltantes += " APELLIDO";
                }

                if (!isTelefono) {
                    datosFaltantes += " TELEFONO";
                }

                if (!isRfc) {
                    datosFaltantes += " RFC";
                }

                if (!isIdCliente) {
                    datosFaltantes += " IDCLIENTE";
                }

                datosFaltantes += " ]";

                personalizarMensaje(txtMessageClientes, datosFaltantes, messageClientes, colorError);
            }

        } else if (modoCliente.equals("consulta")) {

            if (isNombre || isApellido || isTelefono || isRfc || isIdCliente || isFecha) {
                cliente.setNombre(cajaNombreCliente.getText());
                cliente.setApellido(cajaApellidoCliente.getText());
                cliente.setTelefono(cajaTelefonoCliente.getText());
                cliente.setRfc(cajaRfcCliente.getText());

                if (isIdCliente) {
                    cliente.setIdCliente(Integer.parseInt(cajaIdCliente.getText()));
                } else {
                    cliente.setIdCliente(0);
                }

                cliente.setFechaRegistro(cajaFechaRegistroCliente.getText());

                tablaClientes.setModel(ConexionBD.consultaCliente(cliente));

            } else {
                personalizarMensaje(txtMessageClientes, "AGREGA UN DATO DUDE .-.", messageClientes, colorError);
            }
        }
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setExtendedState(ICONIFIED);
        this.setExtendedState(1);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void tablaClientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseReleased
        if (modoCliente.equals("cambio")) {
            cajaIdCliente.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0)));
            cajaNombreCliente.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 1)));
            cajaApellidoCliente.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 2)));
            cajaRfcCliente.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 3)));
            cajaTelefonoCliente.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 4)));
        } else if (modoCliente.equals("baja")) {
            cajaIdCliente.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0)));
        }
    }//GEN-LAST:event_tablaClientesMouseReleased

    private void tablaHabitacionesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaHabitacionesMouseReleased
        if (modoHabitacion.equals("cambio")) {
            cajaIdHabitacion.setText(String.valueOf(tablaHabitaciones.getValueAt(tablaHabitaciones.getSelectedRow(), 0)));
            comboTipoHabitacion.setSelectedItem(String.valueOf(tablaHabitaciones.getValueAt(tablaHabitaciones.getSelectedRow(), 1)));
            checkDisponibleHabitacion.setSelected(Boolean.parseBoolean(String.valueOf(tablaHabitaciones.getValueAt(tablaHabitaciones.getSelectedRow(), 2))));
            checkBajaTemporal.setSelected(Boolean.parseBoolean(String.valueOf(tablaHabitaciones.getValueAt(tablaHabitaciones.getSelectedRow(), 3))));
            cajaPrecioHabitacion.setText(String.valueOf(tablaHabitaciones.getValueAt(tablaHabitaciones.getSelectedRow(), 4)));
        } else if (modoHabitacion.equals("baja")) {
            cajaIdHabitacion.setText(String.valueOf(tablaHabitaciones.getValueAt(tablaHabitaciones.getSelectedRow(), 0)));
        }
    }//GEN-LAST:event_tablaHabitacionesMouseReleased

    private void btnAgregarHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarHabitacionesMouseClicked
        boolean isTipoHabitacion = comboTipoHabitacion.getSelectedIndex() != 0;
        boolean isPrecioHabitacion = !cajaPrecioHabitacion.getText().equals("");
        boolean isCajaIDHabitacion = !cajaIdHabitacion.getText().equals("");
        String datosFaltantes = "TE FALTAN LOS DATOS DE [";

        if (modoHabitacion.equals("alta")) {
            if (isTipoHabitacion && isPrecioHabitacion) {

                habitacion.setTipoHabitacion(String.valueOf(comboTipoHabitacion.getSelectedItem()));
                habitacion.setPrecioNoche(Double.parseDouble(cajaPrecioHabitacion.getText()));
                habitacion.setDisponible(checkDisponibleHabitacion.isSelected());
                habitacion.setBajaTemporal(checkBajaTemporal.isSelected());

                habitacionDAO.setOpcion(1);
                habitacionDAO.setHabitacion(habitacion);

                Thread h1 = new Thread(habitacionDAO);
                h1.start();

                try {
                    h1.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                if (habitacionDAO.isRes()) {
                    personalizarMensaje(txtMessageHabitaciones, "EXITO AL AGREGAR LA HABITACION :D", messageHabitaciones, colorAlta);
                    vaciarCajasHabitaciones();
                } else {
                    personalizarMensaje(txtMessageHabitaciones, "ERROR AL AGREGAR LA HABITACION D:", messageHabitaciones, colorError);

                }

                actualizarTablaHabitaciones();

            } else {
                if (!isTipoHabitacion) {
                    datosFaltantes += " TIPO";
                }

                if (!isPrecioHabitacion) {
                    datosFaltantes += " PRECIO";
                }

                datosFaltantes += " ]";

                personalizarMensaje(txtMessageHabitaciones, datosFaltantes, messageHabitaciones, colorError);
            }
        } else if (modoHabitacion.equals("baja")) {
            if (isCajaIDHabitacion) {

                habitacion.setIdHabitacion(Integer.parseInt(cajaIdHabitacion.getText()));

                habitacionDAO.setOpcion(2);
                habitacionDAO.setHabitacion(habitacion);

                Thread h1 = new Thread(habitacionDAO);
                h1.start();

                try {
                    h1.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                if (habitacionDAO.isRes()) {
                    personalizarMensaje(txtMessageHabitaciones, "EXITO AL ELIMINAR LA HABITACION", messageHabitaciones, colorBaja);
                    vaciarCajasHabitaciones();
                } else {
                    personalizarMensaje(txtMessageHabitaciones, "ERROR AL ELIMINAR LA HABITACION", messageHabitaciones, colorError);

                }

                actualizarTablaHabitaciones();

            } else {
                personalizarMensaje(txtMessageHabitaciones, "INTRODUCE EL ID DE LA HABITACION .-.", messageHabitaciones, colorError);
            }

        } else if (modoHabitacion.equals("cambio")) {

            if (isTipoHabitacion && isPrecioHabitacion && isCajaIDHabitacion) {

                habitacion.setTipoHabitacion(String.valueOf(comboTipoHabitacion.getSelectedItem()));
                habitacion.setPrecioNoche(Double.parseDouble(cajaPrecioHabitacion.getText()));
                habitacion.setDisponible(checkDisponibleHabitacion.isSelected());
                habitacion.setBajaTemporal(checkBajaTemporal.isSelected());
                habitacion.setIdHabitacion(Integer.parseInt(cajaIdHabitacion.getText()));

                habitacionDAO.setOpcion(3);
                habitacionDAO.setHabitacion(habitacion);

                Thread h1 = new Thread(habitacionDAO);
                h1.start();

                try {
                    h1.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                if (habitacionDAO.isRes()) {
                    personalizarMensaje(txtMessageHabitaciones, "EXITO AL MODIFICAR LA HABITACION :D", messageHabitaciones, colorCambio);
                    vaciarCajasHabitaciones();
                } else {
                    personalizarMensaje(txtMessageHabitaciones, "ERROR AL MODIFICAR LA HABITACION D:", messageHabitaciones, colorError);

                }

                actualizarTablaHabitaciones();

            } else {

                if (!isCajaIDHabitacion) {
                    datosFaltantes += " IDHABITACION";
                }

                if (!isTipoHabitacion) {
                    datosFaltantes += " TIPO";
                }

                if (!isPrecioHabitacion) {
                    datosFaltantes += " PRECIO";
                }

                datosFaltantes += " ]";

                personalizarMensaje(txtMessageHabitaciones, datosFaltantes, messageHabitaciones, colorError);
            }

        }

    }//GEN-LAST:event_btnAgregarHabitacionesMouseClicked

    private void btnVaciarHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVaciarHabitacionesMouseClicked
        vaciarCajasHabitaciones();
    }//GEN-LAST:event_btnVaciarHabitacionesMouseClicked

    private void btnVerTodoHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerTodoHabitacionesMouseClicked
        actualizarTablaClientes();
    }//GEN-LAST:event_btnVerTodoHabitacionesMouseClicked

    // ===============================================
    // Eventos de registro de habitaciones
    // ===============================================
    public void habilitarCajasHabitaciones() {
        cajaIdHabitacion.setEnabled(true);
        cajaPrecioHabitacion.setEnabled(true);
        checkBajaTemporal.setEnabled(true);
        checkDisponibleHabitacion.setEnabled(true);
        comboTipoHabitacion.setEnabled(true);
    }

    public void desabilitarCajasHabitaciones() {
        cajaIdHabitacion.setEnabled(false);
        cajaPrecioHabitacion.setEnabled(false);
        checkBajaTemporal.setEnabled(false);
        checkDisponibleHabitacion.setEnabled(false);
        comboTipoHabitacion.setEnabled(false);
    }

    public void vaciarCajasHabitaciones() {
        cajaIdHabitacion.setText("");
        cajaPrecioHabitacion.setText("");
        checkBajaTemporal.setSelected(false);
        checkDisponibleHabitacion.setSelected(false);
        comboTipoHabitacion.setSelectedIndex(0);
    }

    private void btnModoRegistrarHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModoRegistrarHabitacionesMouseClicked
        eventoRegistro(txtModoHabitaciones, "MODO REGISTRO",
                txtAgregarHabitaciones, "AGREGAR",
                btnAgregarHabitaciones, colorBtnAgregar);
        habilitarCajasHabitaciones();
        cajaIdHabitacion.setEnabled(false);
        vaciarCajasHabitaciones();
        modoHabitacion = "alta";
    }//GEN-LAST:event_btnModoRegistrarHabitacionesMouseClicked

    private void btnModoModificarHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModoModificarHabitacionesMouseClicked
        eventoRegistro(txtModoHabitaciones, "MODO EDICION",
                txtAgregarHabitaciones, "MODIFICAR",
                btnAgregarHabitaciones, colorCambio);
        habilitarCajasHabitaciones();
        vaciarCajasHabitaciones();
        modoHabitacion = "cambio";
    }//GEN-LAST:event_btnModoModificarHabitacionesMouseClicked

    private void btnGithubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGithubMouseClicked
        try {
            // Crear un objeto URI con la dirección que quieres abrir en el navegador
            URI uri = new URI("https://github.com/KGHerrera");

            // Verificar si el sistema soporta la apertura de URIs
            if (Desktop.isDesktopSupported()) {
                // Obtener el objeto Desktop
                Desktop desktop = Desktop.getDesktop();

                // Verificar si la acción de abrir una URI es soportada
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    // Abrir la dirección en el navegador predeterminado
                    desktop.browse(uri);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGithubMouseClicked

    private void btnModoEliminarHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModoEliminarHabitacionesMouseClicked
        eventoRegistro(txtModoHabitaciones, "MODO ELIMINACION",
                txtAgregarHabitaciones, "ELIMINAR",
                btnAgregarHabitaciones, colorBaja);
        desabilitarCajasHabitaciones();
        cajaIdHabitacion.setEnabled(true);
        vaciarCajasHabitaciones();
        modoHabitacion = "baja";
    }//GEN-LAST:event_btnModoEliminarHabitacionesMouseClicked

    private void btnModoConsultarHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModoConsultarHabitacionesMouseClicked
        eventoRegistro(txtModoHabitaciones, "MODO BUSQUEDA",
                txtAgregarHabitaciones, "BUSCAR",
                btnAgregarHabitaciones, colorBtnAgregar);
        habilitarCajasHabitaciones();
        vaciarCajasHabitaciones();
        modoHabitacion = "consulta";
    }//GEN-LAST:event_btnModoConsultarHabitacionesMouseClicked

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

                try {
                    UIManager.setLookAndFeel(new FlatIntelliJLaf());
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraClientes;
    private javax.swing.JPanel barraEmpleados;
    private javax.swing.JPanel barraHabitaciones;
    private javax.swing.JPanel barraInicioPane;
    private javax.swing.JPanel barraReportes;
    private javax.swing.JPanel barraReservaciones;
    private javax.swing.JPanel barraVentana;
    private javax.swing.JPanel btnAgregar;
    private javax.swing.JPanel btnAgregarHabitaciones;
    private javax.swing.JPanel btnClientes;
    private javax.swing.JLabel btnClose;
    private javax.swing.JPanel btnComenzar;
    private javax.swing.JPanel btnEmpleados;
    private javax.swing.JLabel btnFacebook;
    private javax.swing.JPanel btnGenerarGrafico;
    private javax.swing.JLabel btnGithub;
    private javax.swing.JPanel btnGraficoPane;
    private javax.swing.JPanel btnHabitaciones;
    private javax.swing.JLabel btnInstagram;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel btnModoConsultarClientes;
    private javax.swing.JLabel btnModoConsultarEmpleados;
    private javax.swing.JLabel btnModoConsultarHabitaciones;
    private javax.swing.JLabel btnModoConsultarReservaciones;
    private javax.swing.JLabel btnModoEliminarClientes;
    private javax.swing.JLabel btnModoEliminarEmpleados;
    private javax.swing.JLabel btnModoEliminarHabitaciones;
    private javax.swing.JLabel btnModoEliminarReservaciones;
    private javax.swing.JLabel btnModoModificarClientes;
    private javax.swing.JLabel btnModoModificarEmpleados;
    private javax.swing.JLabel btnModoModificarHabitaciones;
    private javax.swing.JLabel btnModoModificarReservaciones;
    private javax.swing.JLabel btnModoRegistrarClientes;
    private javax.swing.JLabel btnModoRegistrarEmpleados;
    private javax.swing.JLabel btnModoRegistrarHabitaciones;
    private javax.swing.JLabel btnModoRegistrarReservaciones;
    private javax.swing.JPanel btnReportePane;
    private javax.swing.JPanel btnReportes;
    private javax.swing.JPanel btnReservaciones;
    private javax.swing.JLabel btnTiktok;
    private javax.swing.JLabel btnTwitter;
    private javax.swing.JPanel btnVaciar;
    private javax.swing.JPanel btnVaciarHabitaciones;
    private javax.swing.JPanel btnVerTodo;
    private javax.swing.JPanel btnVerTodoHabitaciones;
    private javax.swing.JLabel btnYoutube;
    private javax.swing.JTextField cajaApellidoCliente;
    private javax.swing.JTextField cajaFechaRegistroCliente;
    private javax.swing.JTextField cajaIdCliente;
    private javax.swing.JTextField cajaIdHabitacion;
    private javax.swing.JTextField cajaNombreCliente;
    private javax.swing.JTextField cajaPrecioHabitacion;
    private javax.swing.JTextField cajaRfcCliente;
    private javax.swing.JTextField cajaTelefonoCliente;
    private javax.swing.JCheckBox checkBajaTemporal;
    private javax.swing.JCheckBox checkDisponibleHabitacion;
    private javax.swing.JComboBox<String> comboTipoHabitacion;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPaneTablaHabitaciones;
    private javax.swing.JScrollPane jScrollTablaClientes;
    private javax.swing.JLabel kdance;
    private javax.swing.JPanel messageClientes;
    private javax.swing.JPanel messageEmpleados;
    private javax.swing.JPanel messageHabitaciones;
    private javax.swing.JPanel messagePaneInicio;
    private javax.swing.JPanel messageReportes;
    private javax.swing.JPanel messageReservaciones;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelEmpleados;
    private javax.swing.JPanel panelHabitaciones;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelReportes;
    private javax.swing.JPanel panelReservaciones;
    private javax.swing.JPanel sideMenu;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaHabitaciones;
    private javax.swing.JLabel txtAgregar;
    private javax.swing.JLabel txtAgregarHabitaciones;
    private javax.swing.JLabel txtApellido;
    private javax.swing.JLabel txtBajaTemporal;
    private javax.swing.JLabel txtClientes;
    private javax.swing.JLabel txtClientesTitulo;
    private javax.swing.JLabel txtComenzar;
    private javax.swing.JLabel txtComenzarGrafico;
    private javax.swing.JLabel txtDisponible;
    private javax.swing.JLabel txtEmpleados;
    private javax.swing.JLabel txtEmpleadosTitulo;
    private javax.swing.JLabel txtFechaRegistro1;
    private javax.swing.JLabel txtFormatoFecha;
    private javax.swing.JLabel txtGenerarReporte;
    private javax.swing.JLabel txtGenerarReportes;
    private javax.swing.JLabel txtHabitaciones;
    private javax.swing.JLabel txtHabitacionesTitulo;
    private javax.swing.JLabel txtIconGrafico;
    private javax.swing.JLabel txtIdCliente;
    private javax.swing.JLabel txtIdHabitacion;
    private javax.swing.JLabel txtInicioTitulo;
    private javax.swing.JLabel txtIntroduceDatos;
    private javax.swing.JLabel txtIntroduceDatosHabitacion;
    private javax.swing.JLabel txtLogo;
    private javax.swing.JLabel txtLogoMain;
    private javax.swing.JLabel txtMessageClientes;
    private javax.swing.JLabel txtMessageEmpleados;
    private javax.swing.JLabel txtMessageHabitaciones;
    private javax.swing.JLabel txtMessageReportes;
    private javax.swing.JLabel txtMessageReservaciones;
    private javax.swing.JLabel txtModoClientes;
    private javax.swing.JLabel txtModoEmpleados;
    private javax.swing.JLabel txtModoHabitaciones;
    private javax.swing.JLabel txtModoReservaciones;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtPrecioNoche;
    private javax.swing.JLabel txtQueGenerar;
    private javax.swing.JLabel txtReporteGenerar;
    private javax.swing.JLabel txtReporteIcon;
    private javax.swing.JLabel txtReportes;
    private javax.swing.JLabel txtReportesTitulo;
    private javax.swing.JLabel txtReservaciones;
    private javax.swing.JLabel txtReservacionesTitulo;
    private javax.swing.JLabel txtRfc;
    private javax.swing.JLabel txtSeleccionaAccion;
    private javax.swing.JLabel txtTelefono;
    private javax.swing.JLabel txtTipoHabitacion;
    private javax.swing.JLabel txtVaciar;
    private javax.swing.JLabel txtVaciar1;
    private javax.swing.JLabel txtVerTodo;
    private javax.swing.JLabel txtVerTodo1;
    private javax.swing.JLabel txtWelcomeUser;
    private javax.swing.JLabel txtcClientes2;
    private javax.swing.JLabel txtcClientes3;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables

    // ===================================================    
    // metodos de validacion poderosos
    // ===================================================
    private void validarSoloLetras(JTextField caja, KeyEvent e) {
        // Validacion de solo letras
        if (e.getSource() == caja) {
            if (!(Character.isLetter(e.getKeyChar()))) {
                e.consume();
            }
        }
    }

    private void validarSoloNumeros(JTextField caja, KeyEvent e) {
        if (e.getSource() == caja) {
            if (!Character.isDigit(e.getKeyChar())) {
                e.consume();
            }
        }
    }

    private void validarSoloLetrasNumeros(JTextField caja, KeyEvent e) {
        if (e.getSource() == caja) {
            if (!Character.isDigit(e.getKeyChar()) && !Character.isLetter(e.getKeyChar())) {
                e.consume();
            }
        }
    }

    private void validarFecha(JTextField caja, KeyEvent e) {
        if (e.getSource() == caja) {

            if (caja.getText().length() >= 10) {
                e.consume();
            }

            if (!Character.isDigit(e.getKeyChar()) && !(e.getKeyChar() == '-')) {
                e.consume();
            }

            if ((caja.getText().length() != 4 && caja.getText().length() != 7) && e.getKeyChar() == '-') {
                e.consume();
            }

            if ((caja.getText().length() == 4 || caja.getText().length() == 7) && Character.isDigit(e.getKeyChar())) {
                e.consume();
            }
        }
    }

    private void validarNumerosDecimales(JTextField caja, KeyEvent e) {
        if (e.getSource() == caja) {

            if (Character.isDigit(e.getKeyChar()) && caja.getText().length() == 5 && !caja.getText().contains(".")) {
                e.consume();
            }

            if (caja.getText().length() == 0 && e.getKeyChar() == '.') {
                e.consume();
            }

            if (((e.getKeyChar() < '0') || (e.getKeyChar() > '9'))
                    && (e.getKeyChar() != '.' || caja.getText().contains("."))) {
                e.consume();
            }
        }
    }

    private void validarLongitud(JTextField caja, KeyEvent e, int longitud) {
        if (e.getSource() == caja) {
            if (caja.getText().length() >= longitud) {
                e.consume();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        validarLongitud(cajaNombreCliente, e, 15);
        validarLongitud(cajaApellidoCliente, e, 15);
        validarLongitud(cajaRfcCliente, e, 14);
        validarLongitud(cajaTelefonoCliente, e, 12);
        validarLongitud(cajaIdCliente, e, 10);
        validarLongitud(cajaIdHabitacion, e, 5);
        validarLongitud(cajaPrecioHabitacion, e, 8);

        validarSoloLetras(cajaNombreCliente, e);
        validarSoloLetras(cajaApellidoCliente, e);
        validarSoloNumeros(cajaTelefonoCliente, e);
        validarSoloNumeros(cajaIdCliente, e);
        validarFecha(cajaFechaRegistroCliente, e);
        validarSoloLetrasNumeros(cajaRfcCliente, e);

        validarSoloNumeros(cajaIdHabitacion, e);
        validarNumerosDecimales(cajaPrecioHabitacion, e);

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
