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

public class VentanaPrincipal extends JFrame implements ActionListener{
    
    private JLabel labelTitulo;
    private JPanel panelcabecera;
    private JPanel panelPestanias;
    private JTabbedPane pestanias;

    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem itemOpciones;

    public PestaniaMapa pestaniaMapa;
    public PanelRegistroEmigrante vistaRegistroEmigrante;
    public PestaniaCiudad pestaniaCiudad;
    public PestaniaFuncionarios pestaniaFuncionarios;
    public PanelEstadisticoView panelEstadistico;

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
        
        vistaRegistroEmigrante= new PanelRegistroEmigrante();
        pestaniaMapa = new PestaniaMapa();
        pestaniaCiudad = new PestaniaCiudad();        
        pestaniaFuncionarios = new PestaniaFuncionarios();
        panelEstadistico = new PanelEstadisticoView();

        panelcabecera = new JPanel();
        panelPestanias = new JPanel();
        labelTitulo = new JLabel();
        pestanias = new JTabbedPane();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        barraMenu = new JMenuBar();
        menu = new JMenu();
        itemOpciones=new JMenuItem();
        menu.setText("Opciones");
        itemOpciones.setText("Cambiar de usuario");
        itemOpciones.addActionListener(this);

        menu.add(itemOpciones);
        barraMenu.add(menu);
        setJMenuBar(barraMenu);
        
        Image imagen= new ImageIcon("/home/xenial/proyectos/java/TallerDeProgramacionJava/imagenes/banner_opt.png").getImage().getScaledInstance(1400,180,Image.SCALE_DEFAULT);

        labelTitulo.setIcon(new ImageIcon(imagen));

        // labelTitulo.setText("SISTEMA GESTION DE EMIGRANTES");
        panelcabecera.setBorder(BorderFactory.createLineBorder(new Color(100, 0, 0)));
        panelcabecera.setMaximumSize(new Dimension(1500, 180));
        panelcabecera.setMinimumSize(new Dimension(1500, 180));
        panelcabecera.setPreferredSize(new Dimension(1500, 180));


        panelPestanias.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        panelPestanias.setMaximumSize(new Dimension(1500, 720));
        panelPestanias.setMinimumSize(new Dimension(1500, 720));
        panelPestanias.setPreferredSize(new Dimension(1500, 720));

        pestanias.addTab("REPRESENTACION GRAFICA", pestaniaMapa.panelGeneral);
        pestanias.addTab("REPORTE POR CIUDAD", pestaniaCiudad.panelGeneral);
        pestanias.addTab("ADMINISTRACION DE EMIGRANTES", vistaRegistroEmigrante.panelGeneral);
        pestanias.addTab("ANALISIS ESTADISTICO", panelEstadistico);
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
        labelTitulo.setText("Bienbenido: " + usuario);
        if (usuario.equals("Usuario")) {
            pestanias.setEnabledAt(pestanias.getTabCount()-6, false);
            pestanias.setEnabledAt(pestanias.getTabCount()-3, false);
            pestanias.setEnabledAt(pestanias.getTabCount()-2, false);
        }//else if (usuario.equals("Administrador")) {
        //     pestanias.setEnabledAt(pestanias.getTabCount()-6, true);
        //     pestanias.setEnabledAt(pestanias.getTabCount()-3, true);
        //     pestanias.setEnabledAt(pestanias.getTabCount()-2, true);
        // }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==itemOpciones) {
            control.mostrarLogin();       
        }
    }
}
