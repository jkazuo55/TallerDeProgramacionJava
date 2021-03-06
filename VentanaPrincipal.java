/**
* @class VentanaPrincipal.java 
* @brief Implementacion de la Clase VentanaPrincipal </br>
* La clase VentanaPrincipal es quien administra todo lo que son las vistas del programa 
* @author SoftTux
* @version 0.2
* @since 1.0
* @see https://github.com/jkazuo55/TallerDeProgramacionJava
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame implements ActionListener{
    
    private JLabel labelTitulo;
    private JPanel panelcabecera;
    private JPanel panelPestanias;
    private JTabbedPane pestanias;

    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem itemOpciones;

    public PestaniaEmigrante pestaniaEmigrante;
    public PestaniaCiudad pestaniaCiudad;
    public PestaniaMapa pestaniaMapa;
    public PestaniaEstadistico pestaniaEstadistico;
    public PestaniaFuncionarios pestaniaFuncionarios;

    private Controlador control;
    
    public VentanaPrincipal() {
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
        initComponents();
    }

    private void initComponents() {
        
        pestaniaEmigrante= new PestaniaEmigrante();
        pestaniaCiudad = new PestaniaCiudad();        
        pestaniaEstadistico = new PestaniaEstadistico();
        pestaniaMapa = new PestaniaMapa();
        pestaniaFuncionarios = new PestaniaFuncionarios();

        panelcabecera = new JPanel();
        panelPestanias = new JPanel();
        labelTitulo = new JLabel();
        pestanias = new JTabbedPane();
        
        // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });

        barraMenu = new JMenuBar();
        menu = new JMenu();
        itemOpciones=new JMenuItem();
        menu.setText("Opciones");
        itemOpciones.setText("Cambiar de usuario");
        itemOpciones.addActionListener(this);

        menu.add(itemOpciones);
        barraMenu.add(menu);
        setJMenuBar(barraMenu);
        
        Image imagen= new ImageIcon("imagenes/banner_opt.png").getImage().getScaledInstance(1400,180,Image.SCALE_DEFAULT);

        labelTitulo.setIcon(new ImageIcon(imagen));

        panelcabecera.setMaximumSize(new Dimension(1500, 180));
        panelcabecera.setMinimumSize(new Dimension(1500, 180));
        panelcabecera.setPreferredSize(new Dimension(1500, 180));


        panelPestanias.setMaximumSize(new Dimension(1500, 720));
        panelPestanias.setMinimumSize(new Dimension(1500, 720));
        panelPestanias.setPreferredSize(new Dimension(1500, 720));

        pestanias.addTab("ADMINISTRACION DE EMIGRANTES", pestaniaEmigrante.panelGeneral);
        pestanias.addTab("REPORTE POR CIUDAD", pestaniaCiudad.panelGeneral);
        pestanias.addTab("REPRESENTACION GRAFICA ", pestaniaMapa.panelGeneral);
        pestanias.addTab("ANALISIS ESTADISTICO", pestaniaEstadistico);
        pestanias.addTab("ADMINISTRACION DE EMPLEADOS", pestaniaFuncionarios.panelGeneral);

        panelcabecera.setLayout(new FlowLayout());
        panelcabecera.add(labelTitulo);

        panelPestanias.setLayout(new FlowLayout());
        panelPestanias.add(pestanias);

        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        this.add(panelcabecera);
        this.add(panelPestanias);
    }

    // Métodos de la VentanaPrincipal:
    public void setControlador(Controlador control) {
        this.control=control;
    }

    public void asignarPrivilegios(String usuario){
        // labelTitulo.setText("Bienbenido: " + usuario);
        if (usuario.equals("Usuario")) {
            pestanias.setEnabledAt(pestanias.getTabCount()-1, false);
            pestanias.setEnabledAt(pestanias.getTabCount()-2, false);
        }else{
            pestanias.setEnabledAt(pestanias.getTabCount()-1, true);
            pestanias.setEnabledAt(pestanias.getTabCount()-2, true);
        }
    }

    // private void close(){
    //     if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?","Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
    //         control.serializarTodo();            
    //         System.exit(0);
    // }

  
    
    public void close(){
        Object [] opciones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"En realidad desea realizar cerrar la aplicacion","Mensaje de Confirmacion",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        {
            control.serializarTodo();
            System.exit(0);
        }else{
            System.out.println("canselado");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==itemOpciones) {
            control.mostrarLogin();       
        }
    }
}
