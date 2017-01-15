//package org.softtux.views;
import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

public class PestaniaEstadistico extends JPanel{
    private JLabel label,label2,label3;
    private JPanel menuPanel;
    public JComboBox<String> comboMotivo,comboCiudad,comboYear;
    public JRadioButton general,porCiudad;
    private ButtonGroup buttonGroup;
    private BorderLayout borderLayout;
    public GraficoEmigrante grafico;
    private JButton boton;
    private PanelEstadisticoCtrl controller;

    public PestaniaEstadistico(){
        setUi();
    }

    public void setUi(){
        boton = new JButton("Generar");
        boton.setActionCommand("graphicButton");
        boton.addActionListener(new PanelEstadisticoCtrl(this));
        borderLayout = new BorderLayout();
        comboMotivo = new JComboBox<String>();
        comboCiudad = new JComboBox<String>();
	comboYear  = new JComboBox<String>();
        menuPanel = new JPanel();
        menuPanel.setLayout(new MigLayout());
        grafico = new GraficoEmigrante();
        this.setLayout(borderLayout);
        buttonGroup = new ButtonGroup();
        general = new JRadioButton("General",true);
        general.setActionCommand("radioGeneral");
        general.setActionCommand("radioGeneral");
        general.addActionListener(new PanelEstadisticoCtrl(this));
        porCiudad = new JRadioButton("Ciudad");
        porCiudad.setActionCommand("radioCiudad");
        porCiudad.addActionListener(new PanelEstadisticoCtrl(this));
        buttonGroup.add(general);
        buttonGroup.add(porCiudad);
        label = new JLabel("Motivo de Migracion");
        label2 = new JLabel("SISTEMA DE GESTION DE EMIGRANTES");
	label3 = new JLabel("Año de migracion");
        comboMotivo.addItem("Trabajo");
        comboMotivo.addItem("Academico");
        comboMotivo.addItem("Familiar");
        comboMotivo.addItem("Economico");
        comboMotivo.addItem("Otros");
        comboCiudad.addItem("Cochabamba");
        comboCiudad.addItem("La Paz");
        comboCiudad.addItem("Oruro");
        comboCiudad.addItem("Potosi");
        comboCiudad.addItem("Santacruz");
        comboCiudad.addItem("Beni");
        comboCiudad.addItem("Tarija");
        comboCiudad.addItem("Chuquisaca");
        comboCiudad.addItem("Pando");
	comboYear.addItem("1993");
	comboYear.addItem("1994");
	comboYear.addItem("1995");
	comboYear.addItem("1996");
	comboYear.addItem("1997");
	comboYear.addItem("1998");
	comboYear.addItem("1999");
	comboYear.addItem("2000");
	comboYear.addItem("2001");
	comboYear.addItem("2002");
	comboYear.addItem("2003");
	comboYear.addItem("2004");
	comboYear.addItem("2005");
	comboYear.addItem("2006");
	comboYear.addItem("2007");
	comboYear.addItem("2008");
	comboYear.addItem("2009");
	comboYear.addItem("2010");
	comboYear.addItem("2011");
	comboYear.addItem("2012");
	comboYear.addItem("2013");
	comboYear.addItem("2014");
	comboYear.addItem("2015");
	comboYear.addItem("2016");
	comboYear.addItem("2017");
        menuPanel.add(label,"wrap");
        menuPanel.add(comboMotivo,"wrap");
	menuPanel.add(label3,"wrap");
	menuPanel.add(comboYear,"wrap");
        menuPanel.add(general,"wrap");
        menuPanel.add(porCiudad,"wrap");
        //menuPanel.add(buttonGroup,"wrap");
        menuPanel.add(comboCiudad, "wrap");
        menuPanel.add(boton);
        comboCiudad.setEnabled(false);
        this.add(label2,BorderLayout.PAGE_START);
        this.add(menuPanel,BorderLayout.LINE_START);
        this.add(grafico,BorderLayout.CENTER);
    }
}
