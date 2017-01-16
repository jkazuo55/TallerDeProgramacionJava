/**
* @class VistaGrafo.java 
* @brief Implementacion de la Clase VistaGrafo</br>
* La clase VistaGrafo Vista para llenar la representacion de un grafo en una matriz;
* @author SoftTux
* @version 0.2
* @since 1.0
* @see https://github.com/jkazuo55/TallerDeProgramacionJava
*/
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable; 
import javax.swing.table.*;
import javax.swing.JScrollPane;

public class VistaGrafo{

	public JPanel panelPrincipal;
	public JPanel panelGeneral;

	public JLabel lab00;
	public JLabel labLPY;
	public JLabel labPndoY;
	public JLabel labBniY;
	public JLabel labCbbaY;
	public JLabel labScY;
	public JLabel labOruY;
	public JLabel labPotY;
	public JLabel labChuqY;
	public JLabel labTarjY;

	public JLabel labLPX;
	public JLabel labPndoX;
	public JLabel labBniX;
	public JLabel labCbbaX;
	public JLabel labScX;
	public JLabel labOruX;
	public JLabel labPotX;
	public JLabel labChuqX;
	public JLabel labTarjX;

	public JLabel lab11;
	public JLabel lab12;
	public JLabel lab13;
	public JLabel lab14;
	public JLabel lab15;
	public JLabel lab16;
	public JLabel lab17;
	public JLabel lab18;
	public JLabel lab19;

	public JLabel lab21;
	public JLabel lab22;
	public JLabel lab23;
	public JLabel lab24;
	public JLabel lab25;
	public JLabel lab26;
	public JLabel lab27;
	public JLabel lab28;
	public JLabel lab29;

	public JLabel lab31;
	public JLabel lab32;
	public JLabel lab33;
	public JLabel lab34;
	public JLabel lab35;
	public JLabel lab36;
	public JLabel lab37;
	public JLabel lab38;
	public JLabel lab39;

	public JLabel lab41;
	public JLabel lab42;
	public JLabel lab43;
	public JLabel lab44;
	public JLabel lab45;
	public JLabel lab46;
	public JLabel lab47;
	public JLabel lab48;
	public JLabel lab49;

	public JLabel lab51;
	public JLabel lab52;
	public JLabel lab53;
	public JLabel lab54;
	public JLabel lab55;
	public JLabel lab56;
	public JLabel lab57;
	public JLabel lab58;
	public JLabel lab59;

	public JLabel lab61;
	public JLabel lab62;
	public JLabel lab63;
	public JLabel lab64;
	public JLabel lab65;
	public JLabel lab66;
	public JLabel lab67;
	public JLabel lab68;
	public JLabel lab69;

	public JLabel lab71;
	public JLabel lab72;
	public JLabel lab73;
	public JLabel lab74;
	public JLabel lab75;
	public JLabel lab76;
	public JLabel lab77;
	public JLabel lab78;
	public JLabel lab79;

	public JLabel lab81;
	public JLabel lab82;
	public JLabel lab83;
	public JLabel lab84;
	public JLabel lab85;
	public JLabel lab86;
	public JLabel lab87;
	public JLabel lab88;
	public JLabel lab89;

	public JLabel lab91;
	public JLabel lab92;
	public JLabel lab93;
	public JLabel lab94;
	public JLabel lab95;
	public JLabel lab96;
	public JLabel lab97;
	public JLabel lab98;
	public JLabel lab99;

	public VistaGrafo(){
		inicializar();
	}
	public void inicializar(){

		panelPrincipal=new JPanel();
		panelGeneral=new JPanel();

		lab00 = new JLabel();
		labLPY = new JLabel();
		labPndoY = new JLabel();
		labBniY = new JLabel();
		labCbbaY = new JLabel();
		labScY = new JLabel();
		labOruY = new JLabel();
		labPotY = new JLabel();
		labChuqY = new JLabel();
		labTarjY = new JLabel();

		labLPX = new JLabel();
		labPndoX = new JLabel();
		labBniX = new JLabel();
		labCbbaX = new JLabel();
		labScX = new JLabel();
		labOruX = new JLabel();
		labPotX = new JLabel();
		labChuqX = new JLabel();
		labTarjX = new JLabel();

		lab11 = new JLabel();
		lab12 = new JLabel();
		lab13 = new JLabel();
		lab14 = new JLabel();
		lab15 = new JLabel();
		lab16 = new JLabel();
		lab17 = new JLabel();
		lab18 = new JLabel();
		lab19 = new JLabel();

		lab21 = new JLabel();
		lab22 = new JLabel();
		lab23 = new JLabel();
		lab24 = new JLabel();
		lab25 = new JLabel();
		lab26 = new JLabel();
		lab27 = new JLabel();
		lab28 = new JLabel();
		lab29 = new JLabel();

		lab31 = new JLabel();
		lab32 = new JLabel();
		lab33 = new JLabel();
		lab34 = new JLabel();
		lab35 = new JLabel();
		lab36 = new JLabel();
		lab37 = new JLabel();
		lab38 = new JLabel();
		lab39 = new JLabel();

		lab41 = new JLabel();
		lab42 = new JLabel();
		lab43 = new JLabel();
		lab44 = new JLabel();
		lab45 = new JLabel();
		lab46 = new JLabel();
		lab47 = new JLabel();
		lab48 = new JLabel();
		lab49 = new JLabel();

		lab51 = new JLabel();
		lab52 = new JLabel();
		lab53 = new JLabel();
		lab54 = new JLabel();
		lab55 = new JLabel();
		lab56 = new JLabel();
		lab57 = new JLabel();
		lab58 = new JLabel();
		lab59 = new JLabel();

		lab61 = new JLabel();
		lab62 = new JLabel();
		lab63 = new JLabel();
		lab64 = new JLabel();
		lab65 = new JLabel();
		lab66 = new JLabel();
		lab67 = new JLabel();
		lab68 = new JLabel();
		lab69 = new JLabel();

		lab71 = new JLabel();
		lab72 = new JLabel();
		lab73 = new JLabel();
		lab74 = new JLabel();
		lab75 = new JLabel();
		lab76 = new JLabel();
		lab77 = new JLabel();
		lab78 = new JLabel();
		lab79 = new JLabel();

		lab81 = new JLabel();
		lab82 = new JLabel();
		lab83 = new JLabel();
		lab84 = new JLabel();
		lab85 = new JLabel();
		lab86 = new JLabel();
		lab87 = new JLabel();
		lab88 = new JLabel();
		lab89 = new JLabel();

		lab91 = new JLabel();
		lab92 = new JLabel();
		lab93 = new JLabel();
		lab94 = new JLabel();
		lab95 = new JLabel();
		lab96 = new JLabel();
		lab97 = new JLabel();
		lab98 = new JLabel();
		lab99 = new JLabel();

		lab00.setText("  ");

		labLPY.setText("LPZ");
		labPndoY.setText("PND");
		labBniY.setText("BNI");
		labCbbaY.setText("CBA");
		labScY.setText("SCZ");
		labOruY.setText("ORU");
		labPotY.setText("PSI");
		labChuqY.setText("CHQ");
		labTarjY.setText("TJA");

		labLPX.setText("LPZ");
		labPndoX.setText("PND");
		labBniX.setText("BNI");
		labCbbaX.setText("CBA");
		labScX.setText("SCZ");
		labOruX.setText("ORU");
		labPotX.setText("PSI");
		labChuqX.setText("CHQ");
		labTarjX.setText("TJA");

		lab11.setText("0");
		lab12.setText("0");
		lab13.setText("0");
		lab14.setText("0");
		lab15.setText("0");
		lab16.setText("0");
		lab17.setText("0");
		lab18.setText("0");
		lab19.setText("0");

		lab21.setText("0");
		lab22.setText("0");
		lab23.setText("0");
		lab24.setText("0");
		lab25.setText("0");
		lab26.setText("0");
		lab27.setText("0");
		lab28.setText("0");
		lab29.setText("0");

		lab31.setText("0");
		lab32.setText("0");
		lab33.setText("0");
		lab34.setText("0");
		lab35.setText("0");
		lab36.setText("0");
		lab37.setText("0");
		lab38.setText("0");
		lab39.setText("0");

		lab41.setText("0");
		lab42.setText("0");
		lab43.setText("0");
		lab44.setText("0");
		lab45.setText("0");
		lab46.setText("0");
		lab47.setText("0");
		lab48.setText("0");
		lab49.setText("0");

		lab51.setText("0");
		lab52.setText("0");
		lab53.setText("0");
		lab54.setText("0");
		lab55.setText("0");
		lab56.setText("0");
		lab57.setText("0");
		lab58.setText("0");
		lab59.setText("0");

		lab61.setText("0");
		lab62.setText("0");
		lab63.setText("0");
		lab64.setText("0");
		lab65.setText("0");
		lab66.setText("0");
		lab67.setText("0");
		lab68.setText("0");
		lab69.setText("0");

		lab71.setText("0");
		lab72.setText("0");
		lab73.setText("0");
		lab74.setText("0");
		lab75.setText("0");
		lab76.setText("0");
		lab77.setText("0");
		lab78.setText("0");
		lab79.setText("0");

		lab81.setText("0");
		lab82.setText("0");
		lab83.setText("0");
		lab84.setText("0");
		lab85.setText("0");
		lab86.setText("0");
		lab87.setText("0");
		lab88.setText("0");
		lab89.setText("0");

		lab91.setText("0");
		lab92.setText("0");
		lab93.setText("0");
		lab94.setText("0");
		lab95.setText("0");
		lab96.setText("0");
		lab97.setText("0");
		lab98.setText("0");
		lab99.setText("0");

		panelGeneral.setLayout(new GridLayout(10,10));

		panelGeneral.add(lab00);
		panelGeneral.add(labLPX);
		panelGeneral.add(labPndoX);
		panelGeneral.add(labBniX);
		panelGeneral.add(labCbbaX);
		panelGeneral.add(labScX);
		panelGeneral.add(labOruX);
		panelGeneral.add(labPotX);
		panelGeneral.add(labChuqX);
		panelGeneral.add(labTarjX);

		panelGeneral.add(labLPY);
		panelGeneral.add(lab11);
		panelGeneral.add(lab12);
		panelGeneral.add(lab13);
		panelGeneral.add(lab14);
		panelGeneral.add(lab15);
		panelGeneral.add(lab16);
		panelGeneral.add(lab17);
		panelGeneral.add(lab18);
		panelGeneral.add(lab19);

		panelGeneral.add(labPndoY);
		panelGeneral.add(lab21);
		panelGeneral.add(lab22);
		panelGeneral.add(lab23);
		panelGeneral.add(lab24);
		panelGeneral.add(lab25);
		panelGeneral.add(lab26);
		panelGeneral.add(lab27);
		panelGeneral.add(lab28);
		panelGeneral.add(lab29);

		panelGeneral.add(labBniY);
		panelGeneral.add(lab31);
		panelGeneral.add(lab32);
		panelGeneral.add(lab33);
		panelGeneral.add(lab34);
		panelGeneral.add(lab35);
		panelGeneral.add(lab36);
		panelGeneral.add(lab37);
		panelGeneral.add(lab38);
		panelGeneral.add(lab39);

		panelGeneral.add(labCbbaY);
		panelGeneral.add(lab41);
		panelGeneral.add(lab42);
		panelGeneral.add(lab43);
		panelGeneral.add(lab44);
		panelGeneral.add(lab45);
		panelGeneral.add(lab46);
		panelGeneral.add(lab47);
		panelGeneral.add(lab48);
		panelGeneral.add(lab49);

		panelGeneral.add(labScY);
		panelGeneral.add(lab51);
		panelGeneral.add(lab52);
		panelGeneral.add(lab53);
		panelGeneral.add(lab54);
		panelGeneral.add(lab55);
		panelGeneral.add(lab56);
		panelGeneral.add(lab57);
		panelGeneral.add(lab58);
		panelGeneral.add(lab59);

		panelGeneral.add(labOruY);
		panelGeneral.add(lab61);
		panelGeneral.add(lab62);
		panelGeneral.add(lab63);
		panelGeneral.add(lab64);
		panelGeneral.add(lab65);
		panelGeneral.add(lab66);
		panelGeneral.add(lab67);
		panelGeneral.add(lab68);
		panelGeneral.add(lab69);
		
		panelGeneral.add(labPotY);
		panelGeneral.add(lab71);
		panelGeneral.add(lab72);
		panelGeneral.add(lab73);
		panelGeneral.add(lab74);
		panelGeneral.add(lab75);
		panelGeneral.add(lab76);
		panelGeneral.add(lab77);
		panelGeneral.add(lab78);
		panelGeneral.add(lab79);

		panelGeneral.add(labChuqY);
		panelGeneral.add(lab81);
		panelGeneral.add(lab82);
		panelGeneral.add(lab83);
		panelGeneral.add(lab84);
		panelGeneral.add(lab85);
		panelGeneral.add(lab86);
		panelGeneral.add(lab87);
		panelGeneral.add(lab88);
		panelGeneral.add(lab89);

		panelGeneral.add(labTarjY);
		panelGeneral.add(lab91);
		panelGeneral.add(lab92);
		panelGeneral.add(lab93);
		panelGeneral.add(lab94);
		panelGeneral.add(lab95);
		panelGeneral.add(lab96);
		panelGeneral.add(lab97);
		panelGeneral.add(lab98);
		panelGeneral.add(lab99);

		panelGeneral.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE));

		panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.Y_AXIS));
		panelPrincipal.add(panelGeneral);

	}	
}