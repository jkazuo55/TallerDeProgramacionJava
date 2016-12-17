import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class OpsBusqueda extends javax.swing.JPanel {
                  
    private JButton btnBuscar;
    private JLabel lbelTituloBusq;
    private JLabel lblIngreseCi;
    private JPanel panelCabeceraSupDer;
    private JTextField textFildCi;

    public OpsBusqueda() {
        initComponents();
    }
                          
    private void initComponents() {

        panelCabeceraSupDer = new JPanel();
        lbelTituloBusq = new JLabel();
        lblIngreseCi = new JLabel();
        textFildCi = new JTextField();
        btnBuscar = new JButton();

        lbelTituloBusq.setText("          Busqueda de Ciudadano ");

        lblIngreseCi.setText("Ingrese su Cedula de Identidad ");

        textFildCi.setText("textFildCi");

        btnBuscar.setText("btnBuscar");

        javax.swing.GroupLayout panelCabeceraSupDerLayout = new javax.swing.GroupLayout(this);
        this.setLayout(panelCabeceraSupDerLayout);
        panelCabeceraSupDerLayout.setHorizontalGroup(
            panelCabeceraSupDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraSupDerLayout.createSequentialGroup()
                .addGap(10)
                .addGroup(panelCabeceraSupDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbelTituloBusq, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCabeceraSupDerLayout.createSequentialGroup()
                        .addComponent(lblIngreseCi, javax.swing.GroupLayout.PREFERRED_SIZE,500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(textFildCi, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCabeceraSupDerLayout.setVerticalGroup(
            panelCabeceraSupDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraSupDerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbelTituloBusq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(panelCabeceraSupDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIngreseCi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCabeceraSupDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFildCi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        this.setSize(1000,100);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    }                        

}
