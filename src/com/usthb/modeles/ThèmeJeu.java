package com.usthb.modeles;

import java.util.ArrayList;
import java.io.Serializable;
public enum ThèmeJeu implements Serializable{

HISTOIRE("HISTOIRE",1),GÉOGRAPHIE("GÉOGRAPHIE",2), SANTÉ("SANTÉ",3), CULTUREGÉNÉRALE("CULTUREGÉNÉRALE",4), ISLAM("ISLAM",5);


//déclaration des attributs   
 private String libellé;
 private int coefficient;
 private ArrayList <Question> mListe;

 //le constructeur 
 ThèmeJeu(String libellé,int coefficient){
    this.libellé=libellé;
    this.coefficient=coefficient;
   }
 

 //getters and setters 
  
public String getmLibellé() {
	return libellé;
}


public int getmCoefficient() {
    return this.coefficient;
}


public ArrayList<Question> getmListe() {
    return mListe;
}

public void setmListe(final ArrayList<Question> mListe) {
	this.mListe = mListe;
}


// une méthode qui retourne le thème correspondant au libellé

public static ThèmeJeu getThèmeJeu(String Thème){
   ThèmeJeu th=null;
    switch(Thème)
    {
    case "HISTOIRE": th=HISTOIRE; 
     break;
    case "GÉOGRAPHIE": th=GÉOGRAPHIE;
     break; 
    case "SANTÉ": th=SANTÉ;
     break;
    case "CULTURÉGENÉRALE": th=CULTUREGÉNÉRALE; 
     break;
    case "ISLAM": th=ISLAM ; 	
     break;
    }
    return th;
    }
}
