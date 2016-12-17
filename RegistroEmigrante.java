import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;


public class RegistroEmigrante extends JPanel{
	
    private JPanel  panelCabecera;
    private JLabel tituloCabecera;
    private CuerpoEmigrante panelCuerpoEmigrante;

    public RegistroEmigrante(){
    	inicializarPanelEmigrantesDer();
    }

    public void inicializarPanelEmigrantesDer(){
    	
    	panelCabecera = new JPanel();
        panelCuerpoEmigrante = new CuerpoEmigrante();

        panelCuerpoEmigrante.panelBtnsModificarEmigrar.jButton1.setVisible(false);

        tituloCabecera =  new JLabel("REGISTRO DE EMIGRANTES");

        panelCabecera.setLayout(new FlowLayout());
        panelCabecera.add(tituloCabecera);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(panelCabecera);
        this.add(panelCuerpoEmigrante);

        this.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 0)));
        this.setMaximumSize(new Dimension(1100, 600));
        this.setMinimumSize(new Dimension(1100, 600));
        this.setPreferredSize(new Dimension(1100, 600));

    }
}