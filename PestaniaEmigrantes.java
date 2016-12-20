import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PestaniaEmigrantes extends JPanel{

    private JPanel panelDerecha;
    private JPanel panelIzquierda;

    private JButton btnBuscar;
    private JButton btnRegistrar;

    
    GridBagLayout layout = new GridBagLayout(); 
    
    RegistroEmigrante panelRegistroEmigrante;
    BusquedaEmigrante panelBusquedaEmigrante;
    
    RegistroEmigrante hola;

    public PestaniaEmigrantes() {
        initComponents();

        panelBusquedaEmigrante = new BusquedaEmigrante();
        panelRegistroEmigrante = new RegistroEmigrante();
        hola = new RegistroEmigrante();
        
        panelDerecha.setLayout(layout);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        panelDerecha.add(panelBusquedaEmigrante,c);
        c.gridx = 0;
        c.gridy = 0;
        panelDerecha.add(hola.panelTodo,c);
        
        panelBusquedaEmigrante.setVisible(true);
        // panelRegistroEmigrante.setVisible(false);
        hola.panelTodo.setVisible(false);
    }      
    private void initComponents() {

        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();
        
        btnBuscar = new JButton();
        btnRegistrar = new JButton();

        setLayout(new BorderLayout());

        panelIzquierda.setBackground(new Color(175, 214, 166)); //verde
        panelIzquierda.setPreferredSize(new Dimension(190, 720));
        panelIzquierda.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));


        
        btnBuscar.setText(" BUSCAR ");
        btnBuscar.setMaximumSize(new Dimension(150, 120));
        btnBuscar.setMinimumSize(new Dimension(150, 120));
        btnBuscar.setPreferredSize(new Dimension(150, 120));

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPanel1ActionPerformed(evt);
            }
        });

        
        btnRegistrar.setText(" REGISTRAR ");
        btnRegistrar.setMaximumSize(new Dimension(150, 120));
        btnRegistrar.setMinimumSize(new Dimension(150, 120));
        btnRegistrar.setPreferredSize(new Dimension(150, 120));

        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPanel2ActionPerformed(evt);
            }
        });

        panelIzquierda.setLayout(new FlowLayout());
        panelIzquierda.add(btnBuscar);
        panelIzquierda.add(btnRegistrar);

        //panelDerecha.setLayout(new FlowLayout());
        //panelDerecha.add();


        this.setLayout(new BorderLayout());
        this.add(panelIzquierda, BorderLayout.LINE_START);
        this.add(panelDerecha, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createLineBorder(new Color(0, 200, 0)));
        this.setMaximumSize(new Dimension(1400, 650));
        this.setMinimumSize(new Dimension(1400, 650));
        this.setPreferredSize(new Dimension(1400, 650));

    }                  

    private void btnPanel1ActionPerformed(ActionEvent evt) {                                          
        panelBusquedaEmigrante.setVisible(true);
        // panelRegistroEmigrante.setVisible(false);
        hola.panelTodo.setVisible(false);
    }                                         

    private void btnPanel2ActionPerformed(ActionEvent evt) {                                          
        panelBusquedaEmigrante.setVisible(false);
        // panelRegistroEmigrante.setVisible(true);        
        hola.panelTodo.setVisible(true);
        
    }                                         

}
































