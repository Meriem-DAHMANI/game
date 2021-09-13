package com.usthb.modeles;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;

public class Button extends JButton{
    private  String txt;
    private  Image img;
    private int x;
    private int y;
   
    public Button(String txt,String img,int x,int y) {
        this.txt = txt;
        ImageIcon icone = new ImageIcon(img);
        this.img = icone.getImage();
        this.x=x;
        this.y=y;
     
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
         Graphics g2 = (Graphics2D) g;//FreeSans
         Font f1 = new Font("Verdana", Font.PLAIN, 30);
        g2.setFont(f1);
        g2.setColor(Color.black);
        
        g2.drawImage(img, 0, 0, this);
        g2.drawString(this.txt, x, y);
        
    }  
}