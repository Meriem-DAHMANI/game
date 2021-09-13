package com.usthb.modeles;

import java.io.Serializable;
import java.util.*;

import com.usthb.Play;

public abstract class Joueur implements Serializable{

	//déclaration des attributs
	protected static int nb=0;//le numéro séquentiel automatique
	protected  int num;
	protected String nom,prénom,mot_de_passe;
	protected int Dernier_niveau;
	protected ArrayList <PartieJeu> liste=new ArrayList<PartieJeu>();
    protected Date dateNaissance;

	
	
	//la méthode qui retourne le score total depuis l’inscription du joueur
	public int getTotalScore(){
	int nb=0;
	if(this.liste!=null){
		for(int i=0;i<liste.size();i++){
			PartieJeu pr=liste.get(i);
			nb=nb+pr.getmScore();
		}
 	}
	
		return nb;
	}

//la méthode abstraite
abstract ArrayList<Question> getQuestions(String thème);

  //la méthode Jouer
public void Jouer(Play sc,String thème,int i){
	//récupérer la liste des qsts 
  ArrayList <Question> qst=this.getQuestions(thème);

  //lancer une nouvelle partie
  PartieJeu prt=new PartieJeu(ThèmeJeu.getThèmeJeu(thème),qst.get(i).getNuméro(),qst.get(i).getNBPoints());
  sc.play(prt,this,qst.get(i));
}

//getters and setters 
public void setNb(int nb){
	 this.nb=nb;
}

	
	public int getNum() {
		return num;
	}


	

	public String getNom() {
		return nom;
	}

	public String getPrénom() {
		return prénom;
	}



	public void setmNom(String Nom) {
		this.nom = Nom;
	}


	


	public String getMot_de_passe() {
		return mot_de_passe;
	}

	

	public int getDernier_niveau() {
		return Dernier_niveau;
	}


	public void setDernier_niveau(int Dernier_niveau) {
		this.Dernier_niveau = Dernier_niveau;
	}


	public ArrayList<PartieJeu> getListe() {
		return liste;
	}


	public void setListe(ArrayList<PartieJeu> liste) {
		this.liste = liste;
	}


		

}