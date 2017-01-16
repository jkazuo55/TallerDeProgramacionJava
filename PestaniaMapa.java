import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.table.*;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Image;

public class PestaniaMapa{
    public  JPanel panelGeneral;
    private JPanel panelIzquierda;
    private JPanel panelDerecha;

    private JPanel panelDerSup;
    private JPanel panelDerInf;

    private JPanel panelDerInfIsq;
    private JPanel panelDerInfDer;

    private JPanel panelRelacion;
    private JPanel panelPesoDistancias;
    private JPanel panelPesoFujoEmigrantes;

    private JLabel labelTituloIzq;
    private JLabel labelTituloDerSup;
    private JLabel labelTituloDerInfDer;
    private JLabel labelTituloDerInfIzq;

    private JButton btnActualizar;
    private ImageIcon image;

    VistaGrafo matrizRelacion;
    VistaGrafo matrizDistancias;
    VistaGrafo matrizFlujoEmi;

    private Controlador control;

    public PestaniaMapa(){ 
        inicializarRegistroEmigrante();
    }        
    private void inicializarRegistroEmigrante(){

        // listaPersonaEmigrante = new Lista<Emigrante>(); 
        // deser_gen = new DeserializableGenerico<Lista>(fileName);        
        panelGeneral = new JPanel();

        matrizRelacion = new VistaGrafo();
        matrizDistancias = new VistaGrafo();
        matrizFlujoEmi = new VistaGrafo();

        panelIzquierda = new JPanel();
        panelDerecha = new JPanel();
        
        panelDerSup = new JPanel();
        panelDerInf =   new JPanel();
        // panelDerPie =      new JPanel();

        panelDerInfIsq = new JPanel();
        panelDerInfDer = new JPanel();

        labelTituloIzq = new JLabel();
        labelTituloDerSup = new JLabel();
        labelTituloDerInfDer = new JLabel();
        labelTituloDerInfIzq = new JLabel();

        btnActualizar = new JButton();

        // labelTituloIzq.setText("REPRESENTACION GRAFICA DEL GRAFO");
        labelTituloDerSup.setText("MATRIZ DE ADYACENCIA");
        labelTituloDerInfIzq.setText("MATRIZ CON PESOS DISTANCIAS");        
        labelTituloDerInfDer.setText("FLUJO DE EMIGRANTES");

        btnActualizar.setText("ACTULIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActulizarActionPerformed(evt);
            }
        });
        Image imagen= new ImageIcon("/imagenes/Bolivia.png").getImage().getScaledInstance(570,650,Image.SCALE_DEFAULT);

        labelTituloIzq.setIcon(new ImageIcon(imagen));

        labelTituloIzq.setMaximumSize(new Dimension(500, 600));
        labelTituloIzq.setMinimumSize(new Dimension(500, 600));
        labelTituloIzq.setPreferredSize(new Dimension(500, 600));

        panelIzquierda.setLayout(new BoxLayout(panelIzquierda,BoxLayout.Y_AXIS));
        panelIzquierda.add(labelTituloIzq);

        panelIzquierda.setMaximumSize(new Dimension(500, 600));
        panelIzquierda.setMinimumSize(new Dimension(500, 600));
        panelIzquierda.setPreferredSize(new Dimension(500, 600));

        panelDerSup.setLayout(new BoxLayout(panelDerSup,BoxLayout.Y_AXIS));
        panelDerSup.add(labelTituloDerSup);
        panelDerSup.add(matrizRelacion.panelGeneral);

        panelDerInfDer.setLayout(new BoxLayout(panelDerInfDer,BoxLayout.Y_AXIS));
        panelDerInfDer.add(labelTituloDerInfDer);
        panelDerInfDer.add(matrizDistancias.panelGeneral);

        panelDerInfIsq.setLayout(new BoxLayout(panelDerInfIsq,BoxLayout.Y_AXIS));
        panelDerInfIsq.add(labelTituloDerInfIzq);
        panelDerInfIsq.add(matrizFlujoEmi.panelGeneral);

        panelDerInf.setLayout(new BoxLayout(panelDerInf,BoxLayout.X_AXIS));
        panelDerInf.add(panelDerInfDer);
        panelDerInf.add(panelDerInfIsq);

        panelDerecha.setLayout(new BoxLayout(panelDerecha,BoxLayout.Y_AXIS));
        panelDerecha.add(panelDerSup);
        panelDerecha.add(panelDerInf);
        panelDerecha.add(btnActualizar);

        panelGeneral.setLayout(new BoxLayout(panelGeneral,BoxLayout.X_AXIS));
        panelGeneral.add(panelIzquierda);
        panelGeneral.add(panelDerecha);

    }
    public void llenarMatrizRelacion(){
        Integer a;
        Object[][]aux = control.matrizAdyacencia();
        for (int i=1;i<aux.length;i++) {
            for (int j=1;j<aux[i].length;j++) {
                a=(Integer) aux[i][j];               
                if (i==1&&j==1) {
                    matrizRelacion.lab11.setText(a.toString());     
                }else if (i==1&&j==2) {
                    matrizRelacion.lab12.setText(a.toString());     
                }else if (i==1&&j==3) {
                    matrizRelacion.lab13.setText(a.toString());     
                }else if (i==1&&j==4) {
                    matrizRelacion.lab14.setText(a.toString());     
                }else if (i==1&&j==5) {
                    matrizRelacion.lab15.setText(a.toString());     
                }else if (i==1&&j==6) {
                    matrizRelacion.lab16.setText(a.toString());     
                }else if (i==1&&j==7) {
                    matrizRelacion.lab17.setText(a.toString());     
                }else if (i==1&&j==8) {
                    matrizRelacion.lab18.setText(a.toString());     
                }else if (i==1&&j==9) {
                    matrizRelacion.lab19.setText(a.toString());     
                }
                else if (i==2&&j==1) {
                    matrizRelacion.lab21.setText(a.toString());   
                }else if (i==2&&j==2) {
                    matrizRelacion.lab22.setText(a.toString());   
                }else if (i==2&&j==3) {
                    matrizRelacion.lab23.setText(a.toString());   
                }else if (i==2&&j==4) {
                    matrizRelacion.lab24.setText(a.toString());   
                }else if (i==2&&j==5) {
                    matrizRelacion.lab25.setText(a.toString());   
                }else if (i==2&&j==6) {
                    matrizRelacion.lab26.setText(a.toString());   
                }else if (i==2&&j==7) {
                    matrizRelacion.lab27.setText(a.toString());   
                }else if (i==2&&j==8) {
                    matrizRelacion.lab28.setText(a.toString());   
                }else if (i==2&&j==9) {
                    matrizRelacion.lab29.setText(a.toString());   
                }
                else if (i==3&&j==1) {
                    matrizRelacion.lab31.setText(a.toString());   
                }else if (i==3&&j==2) {
                    matrizRelacion.lab32.setText(a.toString());   
                }else if (i==3&&j==3) {
                    matrizRelacion.lab33.setText(a.toString());   
                }else if (i==3&&j==4) {
                    matrizRelacion.lab34.setText(a.toString());   
                }else if (i==3&&j==5) {
                    matrizRelacion.lab35.setText(a.toString());   
                }else if (i==3&&j==6) {
                    matrizRelacion.lab36.setText(a.toString());   
                }else if (i==3&&j==7) {
                    matrizRelacion.lab37.setText(a.toString());   
                }else if (i==3&&j==8) {
                    matrizRelacion.lab38.setText(a.toString());   
                }else if (i==3&&j==9) {
                    matrizRelacion.lab39.setText(a.toString());   
                }
                else if (i==4&&j==1) {
                    matrizRelacion.lab41.setText(a.toString());   
                }else if (i==4&&j==2) {
                    matrizRelacion.lab42.setText(a.toString());   
                }else if (i==4&&j==3) {
                    matrizRelacion.lab43.setText(a.toString());   
                }else if (i==4&&j==4) {
                    matrizRelacion.lab44.setText(a.toString());   
                }else if (i==4&&j==5) {
                    matrizRelacion.lab45.setText(a.toString());   
                }else if (i==4&&j==6) {
                    matrizRelacion.lab46.setText(a.toString());   
                }else if (i==4&&j==7) {
                    matrizRelacion.lab47.setText(a.toString());   
                }else if (i==4&&j==8) {
                    matrizRelacion.lab48.setText(a.toString());   
                }else if (i==4&&j==9) {
                    matrizRelacion.lab49.setText(a.toString());   
                }
                else if (i==5&&j==1) {
                    matrizRelacion.lab51.setText(a.toString());   
                }else if (i==5&&j==2) {
                    matrizRelacion.lab52.setText(a.toString());   
                }else if (i==5&&j==3) {
                    matrizRelacion.lab53.setText(a.toString());   
                }else if (i==5&&j==4) {
                    matrizRelacion.lab54.setText(a.toString());   
                }else if (i==5&&j==5) {
                    matrizRelacion.lab55.setText(a.toString());   
                }else if (i==5&&j==6) {
                    matrizRelacion.lab56.setText(a.toString());   
                }else if (i==5&&j==7) {
                    matrizRelacion.lab57.setText(a.toString());   
                }else if (i==5&&j==8) {
                    matrizRelacion.lab58.setText(a.toString());   
                }else if (i==5&&j==9) {
                    matrizRelacion.lab59.setText(a.toString());   
                }
                else if (i==6&&j==1) {
                    matrizRelacion.lab61.setText(a.toString());   
                }else if (i==6&&j==2) {
                    matrizRelacion.lab62.setText(a.toString());   
                }else if (i==6&&j==3) {
                    matrizRelacion.lab63.setText(a.toString());   
                }else if (i==6&&j==4) {
                    matrizRelacion.lab64.setText(a.toString());   
                }else if (i==6&&j==5) {
                    matrizRelacion.lab65.setText(a.toString());   
                }else if (i==6&&j==6) {
                    matrizRelacion.lab66.setText(a.toString());   
                }else if (i==6&&j==7) {
                    matrizRelacion.lab67.setText(a.toString());   
                }else if (i==6&&j==8) {
                    matrizRelacion.lab68.setText(a.toString());   
                }else if (i==6&&j==9) {
                    matrizRelacion.lab69.setText(a.toString());   
                }
                else if (i==7&&j==1) {
                    matrizRelacion.lab71.setText(a.toString());   
                }else if (i==7&&j==2) {
                    matrizRelacion.lab72.setText(a.toString());   
                }else if (i==7&&j==3) {
                    matrizRelacion.lab73.setText(a.toString());   
                }else if (i==7&&j==4) {
                    matrizRelacion.lab74.setText(a.toString());   
                }else if (i==7&&j==5) {
                    matrizRelacion.lab75.setText(a.toString());   
                }else if (i==7&&j==6) {
                    matrizRelacion.lab76.setText(a.toString());   
                }else if (i==7&&j==7) {
                    matrizRelacion.lab77.setText(a.toString());   
                }else if (i==7&&j==8) {
                    matrizRelacion.lab78.setText(a.toString());   
                }else if (i==7&&j==9) {
                    matrizRelacion.lab79.setText(a.toString());   
                }
                else if (i==8&&j==1) {
                    matrizRelacion.lab81.setText(a.toString());   
                }else if (i==8&&j==2) {
                    matrizRelacion.lab82.setText(a.toString());   
                }else if (i==8&&j==3) {
                    matrizRelacion.lab83.setText(a.toString());   
                }else if (i==8&&j==4) {
                    matrizRelacion.lab84.setText(a.toString());   
                }else if (i==8&&j==5) {
                    matrizRelacion.lab85.setText(a.toString());   
                }else if (i==8&&j==6) {
                    matrizRelacion.lab86.setText(a.toString());   
                }else if (i==8&&j==7) {
                    matrizRelacion.lab87.setText(a.toString());   
                }else if (i==8&&j==8) {
                    matrizRelacion.lab88.setText(a.toString());   
                }else if (i==8&&j==9) {
                    matrizRelacion.lab89.setText(a.toString());   
                }
                else if (i==9&&j==1) {
                    matrizRelacion.lab91.setText(a.toString());   
                }else if (i==9&&j==2) {
                    matrizRelacion.lab92.setText(a.toString());   
                }else if (i==9&&j==3) {
                    matrizRelacion.lab93.setText(a.toString());   
                }else if (i==9&&j==4) {
                    matrizRelacion.lab94.setText(a.toString());   
                }else if (i==9&&j==5) {
                    matrizRelacion.lab95.setText(a.toString());   
                }else if (i==9&&j==6) {
                    matrizRelacion.lab96.setText(a.toString());   
                }else if (i==9&&j==7) {
                    matrizRelacion.lab97.setText(a.toString());   
                }else if (i==9&&j==8) {
                    matrizRelacion.lab98.setText(a.toString());   
                }else if (i==9&&j==9) {
                    matrizRelacion.lab99.setText(a.toString());   
                }
            }
        }
    }
    public void llenarMatrizDistancias(){
        int i=1;
        Lista<Arista> aux=control.pesoDistancias();
        for (Arista obj:aux ) {
            if (i==1) {
                System.out.println("terminal "+obj.getPeso());
                matrizDistancias.lab12.setText(Integer.toString(obj.getPeso()));
            }else if(i==2){
                matrizDistancias.lab14.setText(Integer.toString(obj.getPeso()));
            }else if(i==3){
                matrizDistancias.lab16.setText(Integer.toString(obj.getPeso()));
            }else if(i==4){
                matrizDistancias.lab21.setText(Integer.toString(obj.getPeso()));
            }else if(i==5){
                matrizDistancias.lab23.setText(Integer.toString(obj.getPeso()));
            }else if(i==6){
                matrizDistancias.lab32.setText(Integer.toString(obj.getPeso()));
            }else if(i==7){
                matrizDistancias.lab35.setText(Integer.toString(obj.getPeso()));
            }else if(i==8){
                matrizDistancias.lab41.setText(Integer.toString(obj.getPeso()));
            }else if(i==9){
                matrizDistancias.lab45.setText(Integer.toString(obj.getPeso()));
            }else if(i==10){
                matrizDistancias.lab46.setText(Integer.toString(obj.getPeso()));
            }else if(i==11){
                matrizDistancias.lab48.setText(Integer.toString(obj.getPeso()));
            }else if(i==12){
                matrizDistancias.lab53.setText(Integer.toString(obj.getPeso()));
            }else if(i==13){
                matrizDistancias.lab54.setText(Integer.toString(obj.getPeso()));
            }else if(i==14){
                matrizDistancias.lab58.setText(Integer.toString(obj.getPeso()));
            }else if(i==15){
                matrizDistancias.lab61.setText(Integer.toString(obj.getPeso()));
            }else if(i==16){
                matrizDistancias.lab64.setText(Integer.toString(obj.getPeso()));
            }else if(i==17){
                matrizDistancias.lab67.setText(Integer.toString(obj.getPeso()));
            }else if(i==18){
                matrizDistancias.lab76.setText(Integer.toString(obj.getPeso()));
            }else if(i==19){
                matrizDistancias.lab79.setText(Integer.toString(obj.getPeso()));
            }else if(i==20){
                matrizDistancias.lab84.setText(Integer.toString(obj.getPeso()));
            }else if(i==21){
                matrizDistancias.lab85.setText(Integer.toString(obj.getPeso()));
            }else if(i==22){
                matrizDistancias.lab89.setText(Integer.toString(obj.getPeso()));
            }else if(i==23){
                matrizDistancias.lab97.setText(Integer.toString(obj.getPeso()));
            }else if(i==24){
                matrizDistancias.lab98.setText(Integer.toString(obj.getPeso()));
            }

            i++;
        }
    }

    public void llenarMatrizFlujoEmi(){
        matrizFlujoEmi.lab11.setText(Integer.toString(control.flujoEmigrantes("la paz","la paz")));
        matrizFlujoEmi.lab12.setText(Integer.toString(control.flujoEmigrantes("la paz","pando")));
        matrizFlujoEmi.lab13.setText(Integer.toString(control.flujoEmigrantes("la paz","beni")));
        matrizFlujoEmi.lab14.setText(Integer.toString(control.flujoEmigrantes("la paz","cochabamba")));
        matrizFlujoEmi.lab15.setText(Integer.toString(control.flujoEmigrantes("la paz","santa cruz")));
        matrizFlujoEmi.lab16.setText(Integer.toString(control.flujoEmigrantes("la paz","oruro")));
        matrizFlujoEmi.lab17.setText(Integer.toString(control.flujoEmigrantes("la paz","potosi")));
        matrizFlujoEmi.lab18.setText(Integer.toString(control.flujoEmigrantes("la paz","chuquisaca")));
        matrizFlujoEmi.lab19.setText(Integer.toString(control.flujoEmigrantes("la paz","tarija")));

        matrizFlujoEmi.lab21.setText(Integer.toString(control.flujoEmigrantes("pando","la paz")));
        matrizFlujoEmi.lab22.setText(Integer.toString(control.flujoEmigrantes("pando","pando")));
        matrizFlujoEmi.lab23.setText(Integer.toString(control.flujoEmigrantes("pando","beni")));
        matrizFlujoEmi.lab24.setText(Integer.toString(control.flujoEmigrantes("pando","cochabamba")));
        matrizFlujoEmi.lab25.setText(Integer.toString(control.flujoEmigrantes("pando","santa cruz")));
        matrizFlujoEmi.lab26.setText(Integer.toString(control.flujoEmigrantes("pando","oruro")));
        matrizFlujoEmi.lab27.setText(Integer.toString(control.flujoEmigrantes("pando","potosi")));
        matrizFlujoEmi.lab28.setText(Integer.toString(control.flujoEmigrantes("pando","chuquisaca")));
        matrizFlujoEmi.lab29.setText(Integer.toString(control.flujoEmigrantes("pando","tarija")));

        matrizFlujoEmi.lab31.setText(Integer.toString(control.flujoEmigrantes("beni","la paz")));
        matrizFlujoEmi.lab32.setText(Integer.toString(control.flujoEmigrantes("beni","pando")));
        matrizFlujoEmi.lab33.setText(Integer.toString(control.flujoEmigrantes("beni","beni")));
        matrizFlujoEmi.lab34.setText(Integer.toString(control.flujoEmigrantes("beni","cochabamba")));
        matrizFlujoEmi.lab35.setText(Integer.toString(control.flujoEmigrantes("beni","santa cruz")));
        matrizFlujoEmi.lab36.setText(Integer.toString(control.flujoEmigrantes("beni","oruro")));
        matrizFlujoEmi.lab37.setText(Integer.toString(control.flujoEmigrantes("beni","potosi")));
        matrizFlujoEmi.lab38.setText(Integer.toString(control.flujoEmigrantes("beni","chuquisaca")));
        matrizFlujoEmi.lab39.setText(Integer.toString(control.flujoEmigrantes("beni","tarija")));

        matrizFlujoEmi.lab41.setText(Integer.toString(control.flujoEmigrantes("cochabamba","la paz")));
        matrizFlujoEmi.lab42.setText(Integer.toString(control.flujoEmigrantes("cochabamba","pando")));
        matrizFlujoEmi.lab43.setText(Integer.toString(control.flujoEmigrantes("cochabamba","beni")));
        matrizFlujoEmi.lab44.setText(Integer.toString(control.flujoEmigrantes("cochabamba","cochabamba")));
        matrizFlujoEmi.lab45.setText(Integer.toString(control.flujoEmigrantes("cochabamba","santa cruz")));
        matrizFlujoEmi.lab46.setText(Integer.toString(control.flujoEmigrantes("cochabamba","oruro")));
        matrizFlujoEmi.lab47.setText(Integer.toString(control.flujoEmigrantes("cochabamba","potosi")));
        matrizFlujoEmi.lab48.setText(Integer.toString(control.flujoEmigrantes("cochabamba","chuquisaca")));
        matrizFlujoEmi.lab49.setText(Integer.toString(control.flujoEmigrantes("cochabamba","tarija")));

        matrizFlujoEmi.lab51.setText(Integer.toString(control.flujoEmigrantes("santa cruz","la paz")));
        matrizFlujoEmi.lab52.setText(Integer.toString(control.flujoEmigrantes("santa cruz","pando")));
        matrizFlujoEmi.lab53.setText(Integer.toString(control.flujoEmigrantes("santa cruz","beni")));
        matrizFlujoEmi.lab54.setText(Integer.toString(control.flujoEmigrantes("santa cruz","cochabamba")));
        matrizFlujoEmi.lab55.setText(Integer.toString(control.flujoEmigrantes("santa cruz","santa cruz")));
        matrizFlujoEmi.lab56.setText(Integer.toString(control.flujoEmigrantes("santa cruz","oruro")));
        matrizFlujoEmi.lab57.setText(Integer.toString(control.flujoEmigrantes("santa cruz","potosi")));
        matrizFlujoEmi.lab58.setText(Integer.toString(control.flujoEmigrantes("santa cruz","chuquisaca")));
        matrizFlujoEmi.lab59.setText(Integer.toString(control.flujoEmigrantes("santa cruz","tarija")));

        matrizFlujoEmi.lab61.setText(Integer.toString(control.flujoEmigrantes("oruro","la paz")));
        matrizFlujoEmi.lab62.setText(Integer.toString(control.flujoEmigrantes("oruro","pando")));
        matrizFlujoEmi.lab63.setText(Integer.toString(control.flujoEmigrantes("oruro","beni")));
        matrizFlujoEmi.lab64.setText(Integer.toString(control.flujoEmigrantes("oruro","cochabamba")));
        matrizFlujoEmi.lab65.setText(Integer.toString(control.flujoEmigrantes("oruro","santa cruz")));
        matrizFlujoEmi.lab66.setText(Integer.toString(control.flujoEmigrantes("oruro","oruro")));
        matrizFlujoEmi.lab67.setText(Integer.toString(control.flujoEmigrantes("oruro","potosi")));
        matrizFlujoEmi.lab68.setText(Integer.toString(control.flujoEmigrantes("oruro","chuquisaca")));
        matrizFlujoEmi.lab69.setText(Integer.toString(control.flujoEmigrantes("oruro","tarija")));

        matrizFlujoEmi.lab71.setText(Integer.toString(control.flujoEmigrantes("potosi","la paz")));
        matrizFlujoEmi.lab72.setText(Integer.toString(control.flujoEmigrantes("potosi","pando")));
        matrizFlujoEmi.lab73.setText(Integer.toString(control.flujoEmigrantes("potosi","beni")));
        matrizFlujoEmi.lab74.setText(Integer.toString(control.flujoEmigrantes("potosi","cochabamba")));
        matrizFlujoEmi.lab75.setText(Integer.toString(control.flujoEmigrantes("potosi","santa cruz")));
        matrizFlujoEmi.lab76.setText(Integer.toString(control.flujoEmigrantes("potosi","oruro")));
        matrizFlujoEmi.lab77.setText(Integer.toString(control.flujoEmigrantes("potosi","potosi")));
        matrizFlujoEmi.lab78.setText(Integer.toString(control.flujoEmigrantes("potosi","chuquisaca")));
        matrizFlujoEmi.lab79.setText(Integer.toString(control.flujoEmigrantes("potosi","tarija")));

        matrizFlujoEmi.lab81.setText(Integer.toString(control.flujoEmigrantes("chuquisaca","la paz")));
        matrizFlujoEmi.lab82.setText(Integer.toString(control.flujoEmigrantes("chuquisaca","pando")));
        matrizFlujoEmi.lab83.setText(Integer.toString(control.flujoEmigrantes("chuquisaca","beni")));
        matrizFlujoEmi.lab84.setText(Integer.toString(control.flujoEmigrantes("chuquisaca","cochabamba")));
        matrizFlujoEmi.lab85.setText(Integer.toString(control.flujoEmigrantes("chuquisaca","santa cruz")));
        matrizFlujoEmi.lab86.setText(Integer.toString(control.flujoEmigrantes("chuquisaca","oruro")));
        matrizFlujoEmi.lab87.setText(Integer.toString(control.flujoEmigrantes("chuquisaca","potosi")));
        matrizFlujoEmi.lab88.setText(Integer.toString(control.flujoEmigrantes("chuquisaca","chuquisaca")));
        matrizFlujoEmi.lab89.setText(Integer.toString(control.flujoEmigrantes("chuquisaca","tarija")));

        matrizFlujoEmi.lab91.setText(Integer.toString(control.flujoEmigrantes("tarija","la paz")));
        matrizFlujoEmi.lab92.setText(Integer.toString(control.flujoEmigrantes("tarija","pando")));
        matrizFlujoEmi.lab93.setText(Integer.toString(control.flujoEmigrantes("tarija","beni")));
        matrizFlujoEmi.lab94.setText(Integer.toString(control.flujoEmigrantes("tarija","cochabamba")));
        matrizFlujoEmi.lab95.setText(Integer.toString(control.flujoEmigrantes("tarija","santa cruz")));
        matrizFlujoEmi.lab96.setText(Integer.toString(control.flujoEmigrantes("tarija","oruro")));
        matrizFlujoEmi.lab97.setText(Integer.toString(control.flujoEmigrantes("tarija","potosi")));
        matrizFlujoEmi.lab98.setText(Integer.toString(control.flujoEmigrantes("tarija","chuquisaca")));
        matrizFlujoEmi.lab99.setText(Integer.toString(control.flujoEmigrantes("tarija","tarija")));
    }

    public void setControlador(Controlador control) {
        this.control=control;
    }

    private void botonActulizarActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("botonActulizar");
        llenarMatrizRelacion();
        llenarMatrizDistancias();
        llenarMatrizFlujoEmi();
    }

}