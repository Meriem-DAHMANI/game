package com.usthb.modeles;
import java.util.*;
public class Adulte extends Joueur {
   
public Adulte(String nom,String pnom,Date DateNaissance,String mot_de_passe,ArrayList <PartieJeu> liste,int dernier_niveau){
		super.nom=nom;
		super.prénom=pnom;
		super.dateNaissance=DateNaissance;
   super.mot_de_passe=mot_de_passe;	
   super.liste=liste;
   super.Dernier_niveau=dernier_niveau;
   super.num=nb;
   nb++;
}

   

ArrayList<Question> getQuestions(String thème){
ArrayList <Question> qst=new ArrayList<Question>();
//parcourir les thèmes de l'application pour trouver le thème correspondant
for (ThèmeJeu th:ThèmeJeu.values()) {
if(th.getmLibellé().compareTo(thème)==0){ 
ArrayList <Question> liste=th.getmListe();
for(int j=0;j<liste.size();j++){
Question q=liste.get(j);
if(q  instanceof QuestionAdulte) qst.add(q);
}
}   
}
return qst;
}

//la méthode toString
// @Override
public String toString() {
return "Adulte[num=" + num + ", nom=" + nom + ", prénom=" + prénom + ", mot_de_passe=" + mot_de_passe
     + ", dateNaissance=" + dateNaissance.getDate()+'/'+dateNaissance.getMonth()+'/'+dateNaissance.getYear() + ", Dernier_niveau=" + Dernier_niveau+ ", TotalScore()=" + getTotalScore()+ "]";
}



}
