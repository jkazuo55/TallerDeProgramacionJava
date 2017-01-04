//package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEmigranteIzq extends JPanel{
	
	public JButton buscar;
    public JButton registrar;
    public JPanel panelEmigranteIzq;

    public PanelEmigranteIzq(){
        System.out.println("ejecuto hasta aki");
        inicializarPanelEmigranteIzq();
    }

    public void  inicializarPanelEmigranteIzq(){

        JPanel panelEmigranteIzq = new JPanel();
        JButton buscar = new JButton();
        JButton registrar = new JButton();

        buscar.setText("BUSCAR");
        registrar.setText("REGISTRAR");

        registrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("boton Presionado");

                // AccionRegistroEmigrante hola = new AccionRegistroEmigrante();

                PestaniaEmigrantes obj = new PestaniaEmigrantes();
                //hola.setVisible(true);         
                               
            }
        });

        GroupLayout layoutPanelIzq = new GroupLayout(this);

        this.setLayout(layoutPanelIzq);
        layoutPanelIzq.setHorizontalGroup(
            layoutPanelIzq.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutPanelIzq.createSequentialGroup()
                .addGap(0)
                .addGroup(layoutPanelIzq.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscar)
                    .addComponent(registrar))
                .addGap(0))
        );
        layoutPanelIzq.setVerticalGroup(
            layoutPanelIzq.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutPanelIzq.createSequentialGroup()
                .addGap(10)
                .addComponent(buscar)
                .addGap(100)
                .addComponent(registrar)
                .addContainerGap())
        );
        this.setSize(500,750);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 30, 50)));
    }	
}