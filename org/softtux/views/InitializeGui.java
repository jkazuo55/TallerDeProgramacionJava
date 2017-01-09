/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.softtux.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author chavita
 */
public class InitializeGui extends JFrame {
    
    private JLabel labelIMG;
    private ImageIcon image;
    private JPanel panel;
    
    public InitializeGui(){
        super("SoftTux");
        setGui();
    }
    
    private void setGui(){
        panel = new JPanel();
        labelIMG = new JLabel();
        image = new ImageIcon("/home/chavita/taller_progra/banner_v2.jpg");
        labelIMG.setIcon(image);
        panel.add(labelIMG, BorderLayout.CENTER);
        setContentPane(panel); 
        setSize(new Dimension(960,319));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setUndecorated(true);
    }
    
    public static void main(String args[]){
        InitializeGui init = new InitializeGui();
        //LoginView login = new LoginView();
        PrincipalView principal = new PrincipalView();
        init.show(true);
        try{
            Thread.currentThread().sleep(3000);
        }catch(Exception e){
        
        }
        init.show(false);
        principal.show(true);
        
    }
}
