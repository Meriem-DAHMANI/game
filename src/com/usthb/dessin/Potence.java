package com.usthb.dessin;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;

public class Potence extends Component{
//déclaration des attributs
private int état=0;
private Boolean trouvé=false;
private Dimension dimension;

 
  public void incrémentEtat(){
   this.état+=1;
  }

  public void paint (Graphics g)
  {
  // Le dessin s'adapte à l'espace attribué
  dimension = getSize(); // de Component
  g.clearRect(0,0, dimension.width-1, dimension.height-1);
  g.drawRect(0,0, dimension.width-1, dimension.height-1);
  //effacer
  //tracer le cadre
  // s'adapter à l'espace du composant
  int taille = 12*(dimension.width/120);
  if (taille <8)
  taille = 8;
  g.setFont (new Font("TimesRoman", Font.PLAIN, taille));
  if (état >= 1) g.drawLine(l(30), h(120), l(90), h(120));
  if (état >= 2) g.drawLine(l(30), h(120), l(30), h(40));
  if (état >= 3) g.drawLine(l(60), h(120), l(30), h(90));
  if (état >= 4) g.drawLine(l(30), h(40), l(80), h(40));
  if (état >= 5) g.drawLine(l(30), h(60), l(50), h(40));
  if (état >= 6) g.drawLine(l(70), h(40), l(70), h(60));
  if (état >= 7) g.drawOval(l(65), h(60), l(10), h(10)); // tête
  if (état >= 8)
  {
  g.drawLine(l(70), h(70), l(70), h(85)); // corps
  g.drawLine(l(70), h(70), l(65), h(75)); // corps
  g.drawLine(l(70), h(70), l(75), h(75)); // corps
  g.drawLine(l(70), h(85), l(65), h(95)); // corps
  g.drawLine(l(70), h(85), l(75), h(95)); // corps
  }
  if (trouvé) g.drawString("Bravo! vous avez trouvé", l(10), h(150));
  else if (état == 8) g.drawString("Vous êtes pendu !", l(10), h(150));
  else if (état == 7)
  g.drawString("Reste un coup à jouer !", l(10), h(150));
  else // (etat >=0 && etat <7)
  g.drawString("Reste "+(8-état)+"coups à jouer", l(10), h(150));
  
}
  // Mise à l'échelle en largeur de v
  int l (int v)
  {
  double k = Math.min(dimension.width/140., dimension.height/160);
  return (int)(v*k);
  }
  // Mise à l'échelle en hauteur de v
  int h (int v)
  {
  double k = Math.min(dimension.width/140., dimension.height/160);
  return (int)(v*k);
  }

 public void Repaint(Graphics g){
  incrémentEtat(); 
 } 

//getters et setters 

 public int getÉtat() {
	return état;
}

public void setÉtat(int mEtat) {
	this.état = mEtat;
}

public Boolean getTrouvé() {
	return trouvé;
}

public void setTrouvé(Boolean mTrouve) {
	this.trouvé = mTrouve;
} 
 
  
}



 
