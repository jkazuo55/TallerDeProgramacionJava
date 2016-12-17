import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class CuerpoEmigrante extends javax.swing.JPanel {

    private DatosPersonales panelDatosPesonales;
    private DatosEmigrante panelDatosEmigrante;
    BtnsModificarEmigrar panelBtnsModificarEmigrar;
    private JPanel panelCentro;

    public CuerpoEmigrante() {
        initComponents();
    }
  
    private void initComponents() {

        panelDatosPesonales = new DatosPersonales();
        panelDatosEmigrante = new DatosEmigrante();
        panelBtnsModificarEmigrar = new BtnsModificarEmigrar();
        panelCentro = new JPanel();

        panelDatosPesonales.setMaximumSize(new java.awt.Dimension(500, 0));
        panelDatosPesonales.setMinimumSize(new java.awt.Dimension(500, 0));
        panelDatosPesonales.setPreferredSize(new java.awt.Dimension(500, 0));

        panelDatosEmigrante.setMaximumSize(new java.awt.Dimension(500, 0));
        panelDatosEmigrante.setMinimumSize(new java.awt.Dimension(500, 0));
        panelDatosEmigrante.setPreferredSize(new java.awt.Dimension(500, 0));

        panelBtnsModificarEmigrar.setMaximumSize(new java.awt.Dimension(500, 100));
        panelBtnsModificarEmigrar.setMinimumSize(new java.awt.Dimension(500, 100));
        panelBtnsModificarEmigrar.setPreferredSize(new java.awt.Dimension(500, 100));

        panelCentro.setMaximumSize(new java.awt.Dimension(20, 0));
        panelCentro.setMinimumSize(new java.awt.Dimension(20, 0));
        panelCentro.setPreferredSize(new java.awt.Dimension(20, 0));


        this.setLayout(new BorderLayout());
        this.add(panelDatosPesonales,BorderLayout.WEST);
        this.add(panelDatosEmigrante,BorderLayout.EAST);
        this.add(panelBtnsModificarEmigrar,BorderLayout.SOUTH);
        this.add(panelCentro,BorderLayout.CENTER);

        

        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
    } 

}
