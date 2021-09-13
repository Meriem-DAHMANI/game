package com.usthb.modeles;

import java.io.Serializable;

public class QuestionAdulte extends Question implements Serializable{
   
   public QuestionAdulte(String num,String libellé,String image,String réponse,int niveau){
     super(num,libellé,image,réponse,niveau);
   }
}
