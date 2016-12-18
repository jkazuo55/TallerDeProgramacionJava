import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class DatosEmigrante extends JPanel {

    private JPanel jpanelSuperior;
    private JPanel jpanelInferior;
    private JLabel labelTitulo;
    private JLabel labelEmigranteSiNo;
    private JLabel labelFecha;
    private JLabel labelOrigen;
    private JLabel labelDestino;
    private JLabel labelMotivoDeMigracion;

    private JComboBox comboBoxOrigen;
    private JComboBox comboBoxDestino;
    private JTextField textEmigranteSiNo;
    private JTextField textFecha;
    private JComboBox comboBoxMotivoDeMigracion;
  
    public DatosEmigrante() {
        initComponents();
    }

    private void initComponents() {

        jpanelSuperior = new JPanel();
        jpanelInferior = new JPanel();

        labelTitulo = new JLabel();

        labelEmigranteSiNo = new JLabel();
        labelFecha = new JLabel();
        labelOrigen = new JLabel();
        labelDestino = new JLabel();
        labelMotivoDeMigracion = new JLabel();

        textEmigranteSiNo = new JTextField();
        textFecha = new JTextField();
        comboBoxOrigen = new JComboBox();
        comboBoxDestino = new JComboBox();
        comboBoxMotivoDeMigracion = new JComboBox();

        labelTitulo.setText(" DATOS DE MIGRACION ");
        labelEmigranteSiNo.setText("Emigrante si/no");
        labelFecha.setText("Ultima Fecha Migracion");
        labelOrigen.setText("Origen");
        labelDestino.setText("Destino");
        labelMotivoDeMigracion.setText("Motivo de Migracion");

        textEmigranteSiNo.setText("textEmigranteSiNo");
        textFecha.setText("textFecha");
        comboBoxOrigen.addItem("cochabamba");
        comboBoxOrigen.addItem("la paz");
        comboBoxOrigen.addItem("tarija");
        comboBoxOrigen.addItem("chuquisaca");
        comboBoxOrigen.addItem("pando");
        comboBoxOrigen.addItem("beni");
        comboBoxOrigen.addItem("oruro");
        comboBoxOrigen.addItem("santa cruz");
        comboBoxOrigen.addItem("pando");
        comboBoxOrigen.addItem("potosi");
        comboBoxDestino.addItem("cochabamba");
        comboBoxDestino.addItem("la paz");
        comboBoxDestino.addItem("tarija");
        comboBoxDestino.addItem("chuquisaca");
        comboBoxDestino.addItem("pando");
        comboBoxDestino.addItem("beni");
        comboBoxDestino.addItem("oruro");
        comboBoxDestino.addItem("santa cruz");
        comboBoxDestino.addItem("pando");
        comboBoxDestino.addItem("potosi");
        comboBoxMotivoDeMigracion.addItem("Economico");
        comboBoxMotivoDeMigracion.addItem("Trabajo");
        comboBoxMotivoDeMigracion.addItem("Estudios");
        comboBoxMotivoDeMigracion.addItem("Otros");

        jpanelSuperior.setLayout(new FlowLayout());
        jpanelSuperior.add(labelTitulo);

        jpanelInferior.setLayout(new GridLayout(5,2));
        jpanelInferior.add(labelEmigranteSiNo);
        jpanelInferior.add(textEmigranteSiNo);
        jpanelInferior.add(labelFecha);
        jpanelInferior.add(textFecha);
        jpanelInferior.add(labelOrigen);
        jpanelInferior.add(comboBoxOrigen);
        jpanelInferior.add(labelDestino);
        jpanelInferior.add(comboBoxDestino);
        jpanelInferior.add(labelMotivoDeMigracion);
        jpanelInferior.add(comboBoxMotivoDeMigracion);

        jpanelSuperior.setMaximumSize(new java.awt.Dimension(500, 30));
        jpanelSuperior.setMinimumSize(new java.awt.Dimension(500, 30));
        jpanelSuperior.setPreferredSize(new java.awt.Dimension(500, 30));

        jpanelInferior.setMaximumSize(new java.awt.Dimension(500, 350));
        jpanelInferior.setMinimumSize(new java.awt.Dimension(500, 350));
        jpanelInferior.setPreferredSize(new java.awt.Dimension(500, 350));

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(jpanelSuperior);
        this.add(jpanelInferior);

        this.setSize(1000,300);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    }

    
}
