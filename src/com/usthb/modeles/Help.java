package com.usthb.modeles;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



public class Help extends JFrame{
    Container contenu;

    JTextArea txt1=new JTextArea("\n HELP:\n\n"+
  "     Le but du jeu est simple : deviner toute les lettres qui doivent composer un mot, éventuellement \n" +
   "  avec un nombre limité de tentatives et des thèmes fixés à l'avance.A chaque fois que le joueur  \n"+ 
  "   devine  une lettre, celle-ci est affichée.\n"+                      
  "    Dans le cas contraire, le dessin d'un pendu se met à apparaître…\n");

  JLabel label=new JLabel("");
  Button btn = new Button("", "boutton.png", 60, 40);

  public Help(){

    //on Définit la taille de notre fenêtre : 900 pixels de large et 1000 pixels de haut
    this.setSize(900,700);
    //on Définit un titre pour notre fenêtre
    this.setTitle("HELP");
     //Nous demandons à notre objet de se positionner au centre
    this.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     //Instanciation d'un objet JPanel
     JPanel pan = new JPanel();
     //Définition de sa couleur de fond
     pan.setBackground(Color.WHITE);        
     //On prévient notre JFrame que notre JPanel sera son content pane
     this.setContentPane(pan);               
    //la rendre visible   
    this.setVisible(true);
    contenu=this.getContentPane();
    contenu.setLayout(null); 

   
   // Insérer le texte
   contenu.add(txt1);
    txt1.setBounds(0, 0, 900, 150);
    Font police = new Font("Tahoma", Font.BOLD, 16);
    txt1.setFont(police);

  //insérer l'image
    contenu.add(label);
    ImageIcon img = new ImageIcon("pendu.png");
    label.setIcon(img);
    label.setBounds(0, 150, 980, 420);

    //insérer le bouton
    contenu.add(btn);
    btn.setBounds(800, 580, 84, 80);
    


  //le bouton permet de fermer notre fenetre "help"
    btn.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent arg0) {
          hide();
        }
      });

  }
  

}