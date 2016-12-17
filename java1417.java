
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//import com.sun.java.swing.*;
//import com.sun.java.swing.table.*;
import javax.swing.*;
import javax.swing.table.*;
class java1417 extends JPanel {
  private JTable tabla;
  private JScrollPane panelScroll;
  private String titColumna[];
  private String datoColumna[][];
  
  public java1417() {
    setLayout( new BorderLayout() );
    // Creamos las columnas y las cargamos con los datos que van a
    // aparecer en la pantalla
    CreaColumnas();
    CargaDatos();
    // Creamos una instancia del componente Swing
    tabla = new JTable( datoColumna,titColumna );
    // Aqu� se configuran algunos de los par�metros que permite 
    // variar la JTable
    tabla.setShowHorizontalLines( true );
    tabla.setRowSelectionAllowed( true );
    tabla.setColumnSelectionAllowed( true );
    // Cambiamos el color de la zona seleccionada (rojo/blanco)
    tabla.setSelectionForeground( Color.white );
    tabla.setSelectionBackground( Color.red );
    // Incorporamos la tabla a un panel que incorpora ya una barra
    // de desplazamiento, para que la visibilidad de la tabla sea
    // autom�tica
    panelScroll = new JScrollPane( tabla );
    add( panelScroll, BorderLayout.CENTER );
  }
  
  
  // Creamos las etiquetas que sirven de t�tulo a cada una de
  // las columnas de la tabla
  public void CreaColumnas() {
    titColumna = new String[9];
    
    for( int i=0; i < 9; i++ ) {
      titColumna[i] = "Col: "+i;
    }
  }
    //public void CreaFilas() {
    // titFila = new String[9];
    
    //for( int i=0; i < 9; i++ ) {
     // titFila[i] = "Fila: "+i;
    
  
  // Creamos los datos para cada uno de los elementos de la tabla
  public void CargaDatos() {
    datoColumna = new String[9][9];
    
    for( int iY=0; iY < 9; iY++ ) {
      for( int iX=0; iX < 9; iX++ ) {
	datoColumna[iY][iX] = "" + iX + "," + iY;
      }
    }
  }
  
  
  public static void main( String args[] ) {
    JFrame ventana = new JFrame( "Tutorial de Java, Swing" );
    /*
    ventana.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent evt ){
	System.exit( 0 );
      }
    } );*/
    
    ventana.getContentPane().add( new java1417(),BorderLayout.CENTER );
    ventana.setSize( 300,180 );
    
    ventana.setVisible( true );
  }
}