package com.usthb.modeles;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Controle extends JFrame {

    Container contenu;
    private String chaine;
  

    public Controle(String chaine){
        //on Définit la taille de notre fenêtre : 900 pixels de large et 1000 pixels de haut
    this.setSize(400,250);
    //on Définit un titre pour notre fenêtre
    this.setTitle("Controle");
     //Nous demandons à notre objet de se positionner au centre
    this.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);     
    //On prévient notre JFrame que notre JPanel sera son content pane
    this.setContentPane(new Panneau(1));               
    contenu = this.getContentPane();
    contenu.setLayout(null);
    this.setVisible(true);

    // Insérer le texte récupéré
    this.chaine=chaine;
    JLabel label=new JLabel(this.chaine);
    contenu.add(label);
    label.setBounds(5,10,500,80);
    Font police = new Font("Tahoma", Font.ITALIC,25);
    label.setFont(police);
    label.setForeground(Color.WHITE);


    //insérer le bouton 
    Button btn = new Button("", "boutton.png", 60, 30);
    contenu.add(btn);
    btn.setBounds(300, 120, 84, 80);

//le bouton permet de fermer notre fenetre "Controle"
    btn.addActionListener(new ActionListener() {
     public void actionPerformed(final ActionEvent arg0) {
          hide();
     }
    });
}   

} 
