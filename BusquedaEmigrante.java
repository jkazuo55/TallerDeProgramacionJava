import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;

public class BusquedaEmigrante extends JPanel{
	
    private OpsBusqueda panelOpsBusqueda;
    private CuerpoEmigrante panelCuerpoEmigrante;

    public BusquedaEmigrante(){
    	inicializarPanelEmigrantesDer();
    }

    public void inicializarPanelEmigrantesDer(){
    	
    	panelOpsBusqueda = new OpsBusqueda();
        panelCuerpoEmigrante = new CuerpoEmigrante();


        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(panelOpsBusqueda);
        this.add(panelCuerpoEmigrante);

        this.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
        this.setMaximumSize(new Dimension(1100, 600));
        this.setMinimumSize(new Dimension(1100, 600));
        this.setPreferredSize(new Dimension(1100, 600));

    }
}