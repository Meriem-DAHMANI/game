package com.usthb.modeles;
import java.io.Serializable;

public class Question implements Serializable {

 //déclaration des attributs  
   protected String numéro,libellé,image,réponse;
   protected int niveau;
   


//le constructeur 
public Question(String numéro,String libellé,String image,String réponse,int niveau) {
this.numéro=numéro;
 this.libellé=libellé;
 this.image=image;
 this.réponse=réponse;
 this.niveau=niveau;

}


//obtenir le thème correspondant
public ThèmeJeu getThème(){
    String thème="";
    
   switch(numéro.substring(0,3))
   {
   case "HIS": thème="HISTOIRE"; 
    break;
   case "GÉO": thème="GÉOGRAPHIE";
    break; 
   case "SAN": thème="SANTÉ";
    break;
   case "CUL": thème="CULTURÉGENÉRALE"; 
    break;
   case "ISL": thème="ISLAM"; 	
    break;
   }
   return ThèmeJeu.getThèmeJeu(thème);
   }


           
   
//la méthode qui retourne le nbre de points associé à la question 
   public int getNBPoints(){
   int nbPoint=0; //nbPoint représente le nombre de points obtenus
   ThèmeJeu th=getThème();
   switch(niveau)
   {
   case 1: nbPoint=5*th.getmCoefficient(); 
    break;
   case 2: nbPoint=10*th.getmCoefficient();
    break; 
   case 3: nbPoint=18*th.getmCoefficient();
    break;
   case 4: nbPoint=28*th.getmCoefficient(); 
    break;
   case 5: nbPoint=40*th.getmCoefficient(); 	
    break;
   }
   return nbPoint;
   }

//getters 
   public String getLibellé() {
       return libellé;
   }

   public String getNuméro() {
       return numéro;
   }

   public String getImage() {
       return image;
   }

   public String getRéponse() {
       return réponse;
   }
   
   public int getNiveau() {
       return niveau;
   }
   
   
}
