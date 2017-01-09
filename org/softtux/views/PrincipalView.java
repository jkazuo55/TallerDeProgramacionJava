package org.softtux.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;

public class PrincipalView extends JFrame {

        private JTabbedPane tabbedPanel;
	private JLabel imgLogoLabel, userLabel, welcomeLabel;
	private ImageIcon imageSofttux, imageWelcome, imageUser;
        private JPanel mainPanel, mapa, ciudades, emigrantes, estadistico, usuarios;
        private PanelEstadisticoView panelEstadistico;

	public PrincipalView(){
		super("Sistema de gestion de emigrantes - Administrador");
		setUI();
	}

	public void setUI(){
                tabbedPanel = new JTabbedPane();
		imgLogoLabel = new JLabel();
		welcomeLabel = new JLabel();
		userLabel = new JLabel();
		mainPanel = new JPanel();
                panelEstadistico = new PanelEstadisticoView();
		//mainPanel.setLayout(new MigLayout("","[center][right][left][c]","[top][center][b]"));
		mainPanel.setLayout(new MigLayout());
		mapa = new JPanel();
                mapa.setName("Mapa General");
		ciudades = new JPanel();
                ciudades.setName("Detalles de Ciudades");
		emigrantes = new JPanel();
                emigrantes.setName("Registro de Emigrantes");
		estadistico = new JPanel();
                estadistico.setName("Analisis Estadistico");
		usuarios = new JPanel();
                usuarios.setName("Registro de Usuarios");
                tabbedPanel.add(mapa);
                tabbedPanel.add(panelEstadistico);
                tabbedPanel.add(emigrantes);
                tabbedPanel.add(estadistico);
                tabbedPanel.add(usuarios);
		imageSofttux = new ImageIcon("/home/chavita/taller_progra/banner_v5.jpg");
		imageWelcome = new ImageIcon("/home/chavita/taller_progra/welcome.jpg");
		imageUser = new ImageIcon("/home/chavita/taller_progra/admin.png");
		imgLogoLabel.setIcon(imageSofttux);
		welcomeLabel.setIcon(imageWelcome);
		userLabel.setIcon(imageUser);
		mainPanel.add(imgLogoLabel,"wrap");
                mainPanel.add(tabbedPanel,"grow, push");
		//buildToolBar();				
		this.setContentPane(mainPanel);
		//mainPanel.setBackground(Color.white);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);	
	}

}

