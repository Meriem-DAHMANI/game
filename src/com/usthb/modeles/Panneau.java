package com.usthb.modeles;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Panneau extends JPanel{
  private int numFenetre;

  public Panneau(int numFenetre){
       this.numFenetre=numFenetre;   
  }

  public void paintComponent(Graphics g){
    
    try {
      Image im;
      switch(numFenetre){
       case 1: im = ImageIO.read(new File("fenetre.png"));
         break;
       case 2: im = ImageIO.read(new File("score.jpg")); 
       
       default: im = ImageIO.read(new File("score.jpg"));
      }

      
      //super.paintComponent(g);
      g.drawImage(im, 0, 0, this);
      this.setVisible(true);
      
    } catch (IOException e) {
      e.printStackTrace();
      
    }  
    
  }

}



 


 
