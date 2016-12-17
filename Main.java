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

public class Main extends JFrame {
    
    private JLabel labelTitulo;
    private JPanel panelcabecera;
    private JPanel panelPestanias;
    private JTabbedPane pestanias;
    
    public Main() {
        initComponents();
    }

    private void initComponents() {

        panelcabecera = new JPanel();
        panelPestanias = new JPanel();
        labelTitulo = new JLabel();
        pestanias = new JTabbedPane();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        
        labelTitulo.setText("SISTEMA GESTION DE EMIGRANTES");
        panelcabecera.setBorder(BorderFactory.createLineBorder(new Color(100, 0, 0)));
        panelcabecera.setMaximumSize(new Dimension(1500, 180));
        panelcabecera.setMinimumSize(new Dimension(1500, 180));
        panelcabecera.setPreferredSize(new Dimension(1500, 180));


        panelPestanias.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        panelPestanias.setMaximumSize(new Dimension(1500, 720));
        panelPestanias.setMinimumSize(new Dimension(1500, 720));
        panelPestanias.setPreferredSize(new Dimension(1500, 720));

        pestanias.addTab("pestaniaUno", new JLabel("Agregar aki lo de la pestania MAPA"));
        pestanias.addTab("PestaniaDos", new JLabel("Agregar tambien aki todo lo de la pestania CIUDAD"));
        pestanias.addTab("EMIGRANTES", new PestaniaEmigrantes());
        pestanias.addTab("PestaniaCuatro", new JLabel("Agregar aki todo lo de la pestania ANALISIS ESTADISTICO"));
        pestanias.addTab("PestaniaCinco", new JLabel("Agregar aki todo LO DE registrar SECRETARIAS"));
        pestanias.addTab("PestaniaSeis", new JLabel("SALIR"));

        panelcabecera.setLayout(new FlowLayout());
        panelcabecera.add(labelTitulo);

        panelPestanias.setLayout(new FlowLayout());
        panelPestanias.add(pestanias);

        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        this.add(panelcabecera);
        this.add(panelPestanias);


        this.setSize(1500, 900);
        setLocationRelativeTo(null);
    }                       

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

}
