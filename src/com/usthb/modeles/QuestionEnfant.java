package com.usthb.modeles;

import java.io.Serializable;

public class QuestionEnfant extends Question implements Serializable{

    public QuestionEnfant(String num,String libellé,String image,String réponse,int niveau){
      super(num,libellé,image,réponse,niveau);
    } 

}