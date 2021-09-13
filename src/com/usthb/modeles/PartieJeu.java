package com.usthb.modeles;
import java.io.Serializable;

public class PartieJeu implements Serializable {

    //déclaration des attributs 
    private static int Numéro=0;
    private ThèmeJeu Thème;
    private String Numero_qst;
    private StringBuffer Rpns_crnt;
    private int Score;
    
   
    //le constructeur 
    PartieJeu(ThèmeJeu thème,String numero_qst,int score){
        this.Thème=thème;
        this.Numero_qst=numero_qst;
        this.Score=score;
        Numéro+=1; 
    }
    
    //la méthode qui vérifie si lecaractère c appartient à la réponse de la qst courante et le remplacer
    public StringBuffer checkCaractère(String c,String rep) {
      //remplacer toute les occurrences de c dans la réponce courante

    while(rep.indexOf(c)!=-1){
     this.Rpns_crnt.replace(rep.indexOf(c), rep.indexOf(c)+1, c);
     rep=rep.substring(0,rep.indexOf(c))+"#"+rep.substring(rep.indexOf(c)+1,rep.length());
            
  }
      
        return Rpns_crnt;
    }


   //getters et setters 

	public ThèmeJeu getmTheme() {
		return Thème;
	}


	public void setmTheme(ThèmeJeu Thème) {
		this.Thème = Thème;
	}


	public StringBuffer getmRpns_crnt() {
		return Rpns_crnt;
	}


	public void setmRpns_crnt(StringBuffer mRpns_crnt) {
		this.Rpns_crnt = mRpns_crnt;
	}


	public int getmScore() {
		return Score;
	}



	public void setmScore(int mScore) {
		this.Score = mScore;
	}




	
    
    


}
