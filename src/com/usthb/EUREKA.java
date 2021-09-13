package com.usthb;
//Les imports habituels
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import com.usthb.modeles.*;
import com.usthb.modeles.Button;

import java.util.*;
import java.io.*;
import java.time.*;


public class EUREKA extends JFrame{

//les déclarations
Container contenu;
private HashMap <Integer,Joueur> table = new HashMap<Integer,Joueur>();
private HashSet <ThèmeJeu> set=new HashSet<ThèmeJeu>();

//cntrl pour ajouter un controle en cas d'erreur
private Controle cntrl;

//font pour personnaliser les textes et les titres
private Font font=new Font("Tahoma", Font.BOLD, 18);
private Font policeTitle = new Font("Verdana", Font.BOLD, 100);
private Font policeSubTitle = new Font("Verdana", Font.BOLD, 70);
//les zones de texte 
private JTextArea txt=new JTextArea("");

private JLabel labelTitle = new JLabel("🅔🅤🅡🅔🅚🅐");

private JLabel labelSignUp=new JLabel("🅂🄸🄶🄽 🅄🄿");
private JLabel labelLogIn=new JLabel("🄻🄾🄶 🄸🄽");

private JTextField tf1 = new JTextField();
private JTextField tf2 = new JTextField();
private JTextField tf31 = new JTextField();
private JTextField tf32 = new JTextField();
private JTextField tf33 = new JTextField();
private JTextField tf4 = new JTextField();

//labels
private JLabel tf1JLabel=new JLabel("Nom");
private JLabel tf2JLabel=new JLabel("Prénom");
private JLabel tf3JLabel=new JLabel("Date-naiss(jour/mois/année)");
private JLabel tf4JLabel=new JLabel("Mot_de_passse");  


private JButton b1 = new JButton("Sign up");
private  JButton b2 = new JButton("Log in");

//déclarer et personnaliser les boutons principaux
private Button btn1 = new Button("✔️ Sign up", "bouton.jpg", 70, 50);
private Button btn2 = new Button("✔️ Log in", "bouton.jpg", 80, 50);
private Button btn3 = new Button("☺️ Players", "bouton.jpg", 80, 50);
private Button btn4 = new Button("❓ About", "bouton.jpg", 90, 50);
private Button btn5 = new Button("❌ Quit", "bouton.jpg", 90, 50);
private Button btn6 = new Button("☰ Menu", "bouton.jpg", 80, 50);
private Button btn7 = new Button("✔️Best Score", "bouton.jpg", 40, 50);


private Color c=new ColorUIResource(177,231, 255);
private Color ColorTxt=new ColorUIResource(0,27, 86);
private Color ColorTitle=new ColorUIResource(53,194,255);

public EUREKA() {
  //inisialiser le fichier des questions
  //Initialisation();
  //  charger la structure ArrayList des joueurs 
  try {
    FileInputStream f = new FileInputStream(new File("joueurs.txt"));
    ObjectInputStream o = new ObjectInputStream(f);
    // Lecture des objets
    Joueur j;
    while ((j = (Joueur) o.readObject()) != null) {
      table.put(j.getNum(), j);
      j.setNb(j.getNum()+1);
    }
    o.close();
    f.close();
  } catch (FileNotFoundException e) {
    System.out.println("File not found");
  } catch (IOException e) {
    System.out.println("Error initializing stream");
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  }

   // charger  la structure HashMap HashMap des qst et HashSet des thèmes
   try {
    FileInputStream f = new FileInputStream(new File("questions.txt"));
    ObjectInputStream o = new ObjectInputStream(f);

    // Lecture des objets
    for (ThèmeJeu th:ThèmeJeu.values()) {
    ArrayList <Question> liste=new ArrayList<Question>();
      for(int i=0;i<20;i++){
        liste.add((Question) o.readObject());
      }
      
       th.setmListe(liste);
       set.add(th);
    }

    o.close();
    f.close();
  } catch (FileNotFoundException e) {
    System.out.println("File not found");
  } catch (IOException e) {
    System.out.println("Error initializing stream");
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  }


  // initialiser notre fenetre
  // on Définit la taille de notre fenêtre : 900 pixels de large et 1000 pixels de hauteur
  this.setSize(1500, 1600);
  // on Définit un titre pour notre fenêtre
  this.setTitle("EUREKA");
  // Nous demandons à notre objet de se positionner au centre
  this.setLocationRelativeTo(null);
  // Termine le processus lorsqu'on clique sur la croix rouge
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
// 1: personnaliser la fenetre principale
  this.setContentPane(new Panneau(1));

  contenu = this.getContentPane();
  // la rendre visible
  this.setVisible(true);
  contenu.setLayout(null);
  
  // on affiche le menu principale de notre jeu
  menu();

  // btn1 permet de s'inscrire
  btn1.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent arg0) {
      //1:afficher les composants graphiques nécessaires à l'inscription
      Add(1);
    }
  });

  // le bouton btn1 permet de s'inscrire
  b1.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent arg0) {
      if(Inscription(table)){
        //2:afficher les composants graphiques nécessaires à la connexion
        Add(2);
      }
    }
  });


  // btn2 permet d'afficher des champs de saisie pour se connecter
  btn2.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent arg0) {
      //2:afficher les composants graphiques nécessaires à la connexion
      Add(2);
   
    }
  });

//b2 permet de réaliser une connexion s'il il n'y a aucune erreure.
  b2.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent arg0) {
      // on initialise un nouveau objet de type joueur
      Joueur j = Se_onnecter(table);
      if(set!=null && j!=null){
        //afficher le menu pour le retour à la fenetre
        menu();
        Play pl = new Play(j, set);
        pl.setVisible(true);
      }
      

    }
  });

  // btn4 permet d'afficher les informations a propos
  btn4.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent arg0) {
      Supprimer();
      contenu.add(txt);
      txt.setFont(font);
      txt.setBackground(ColorTxt);
      txt.setText("Version eclipse: 2019-12 \n"+
      "réalisé par Dahmani Meriem \n"+
      "la date de développement :  mars 2020 -> 31 mai 2020");
      txt.setForeground(Color.white);
      txt.setBounds(0, 0, 1500, 1600);
    }
  });

  // bm5 permet de quitter le programme
  btn5.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent arg0) {
      int i = 0;
      //remplir le fichier des joueurs avant de quitter le jeu
      try {
        FileOutputStream fi = new FileOutputStream(new File("joueurs.txt"));
        ObjectOutputStream oi = new ObjectOutputStream(fi);

        while (i < table.size()) {
          Joueur j = table.get(i);
          oi.writeObject(j);
          
          i++;
        }
        oi.close();
        fi.close();
} catch (FileNotFoundException e) {System.out.println("File not found");} 
catch (IOException e) {System.out.println("Error initializing stream");}
      System.exit(0);

    }
  });

  //btn3 permet d'afficher la liste des joueurs
  btn3.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent arg0) {
      Supprimer();
      AfficherInfosJoueursInscrits();
    }
  });

  // btn6 permet d'afficher le menu principal
  btn6.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent arg0) {
      menu();

    }
  });

  //btn7 permet d'afficher le meilleur joueur qui a le plus de pts
  btn7.addActionListener(new ActionListener() {
    public void actionPerformed(final ActionEvent arg0) {
      Joueur max;
     if(table.size()>0){
        max=table.get(0);
      //parcourir la table pour trouver le meuilleur score   
  int i = 1;
  while (i< table.size()) {
    Joueur j = table.get(i);
    if (j.getTotalScore()>max.getTotalScore()) {
      max=j;
    }
    i++;
  }
  cntrl=new Controle("meilleur joueur est "+max.getPrénom()+"("+max.getTotalScore()+"pts )");

}
else{
  cntrl=new Controle("aucun joueur n'est inscrit");
}
    
 
  }
  });
}


//la méthode inscription du joueur
public boolean Inscription(HashMap<Integer, Joueur> table) {
  //vérifier si tous les champs sont champs sont remplis
  if((tf1.getText()).equals("") || (tf2.getText()).equals("") || (tf4.getText()).equals("")){
  //si l'un des champs est vide
   cntrl=new Controle("certains champs sont vides ☹!!");
  }
  else{
try{
  // saisir la date de naissance
  Date d = new Date(Integer.parseInt(tf33.getText()),Integer.parseInt(tf32.getText()),Integer.parseInt(tf31.getText()));
  LocalDate.of(Integer.parseInt(tf33.getText()),Integer.parseInt(tf32.getText()) ,Integer.parseInt(tf31.getText()));
  

  //calculer l'age du  joueur
  LocalDate l = LocalDate.now();
  int age = l.getYear() - d.getYear();

  
  //si le joueur existe déjà
  if(chercherJoueur(table)!=null){
   cntrl=new Controle("le joueur existe déjà ☹!!");
  }

  //sinon on ajoute le nouveau joueur
  else{
    //créer un joueur enfant ou un joueur adulte selon l'age calculé
  if (age < 18) {
    Enfant j = new Enfant(tf1.getText(), tf2.getText(), d, tf4.getText(),null,0);
    table.put(j.getNum(), j);
  } else {
    Adulte j = new Adulte(tf1.getText(), tf2.getText(), d, tf4.getText(),null,0);
    table.put(j.getNum(), j);
  }
  return true;
  //afficher l'erreur ds la fenetre controle
  }}catch (NumberFormatException e) {cntrl=new Controle("la date est invalide ☹!!");} 
  catch (DateTimeException e) {cntrl=new Controle("la date est invalide ☹!!");}}

return false;
}


//la méthode se connecter
Joueur Se_onnecter(HashMap<Integer, Joueur> table) {
  //vérifier si tous les champs sont champs sont remplis
  if((tf1.getText()).equals("") || (tf4.getText()).equals("")){
    //s'il y'au moin un champ vide
     cntrl=new Controle("certains champs sont vides ☹!!");
    return null;
  }
  else{
    if(chercherJoueur(table)==null){
      //si on n'a pas trouvé le joueur
      cntrl=new Controle("le joueur n'existe pas ☹!!");
     }
  }
 
  return chercherJoueur(table);
}


//la méthode qui cherche le joueur ds la table 
Joueur chercherJoueur(HashMap<Integer, Joueur> table){
  //parcourir la table pour trouver le joueur qui veut se connecter 
  int i = 0;
  while (i< table.size()) {
    Joueur j = table.get(i);
    if (j.getNom().equals(tf1.getText()) && j.getMot_de_passe().equals(tf4.getText())) {
      return j;
    }
    i++;
  }
  return null;

}

//la méthode Initialisation qui permet d’initialiser le fichier avec des thèmes et des questions  
public void Initialisation() {

Scanner sc=new Scanner(System.in);
try {
FileOutputStream fileQst = new FileOutputStream(new File("FileQuestion.txt"));
ObjectOutputStream oq = new ObjectOutputStream(fileQst);

for (ThèmeJeu th:ThèmeJeu.values()) {

//saisir des questions adult    
for (int j = 1; j <= 10; j++) {

System.out.println("donnez une question : "); 
String qst = sc.nextLine();

System.out.println("Donnez une image :");
String img =sc.nextLine();

System.out.println("donnez une réponse");
String rep =sc.nextLine();

 QuestionAdulte qa = new QuestionAdulte((th.getmLibellé().substring(0, 3)).toUpperCase() + j, qst, img, rep, j);
 //écrire la qst ds le fichier
 oq.writeObject(qa);
}

//saisir des questions enfant
for (int j = 1; j <= 10; j++) {
 System.out.println("donnez une question : "); 
 String qst = sc.nextLine();

 System.out.println("Donnez une image :");
 String img = sc.nextLine();

System.out.println("donnez une réponse");
String rep =sc.nextLine();

QuestionEnfant qe = new QuestionEnfant((th.getmLibellé().substring(0, 3)).toUpperCase() + j, qst, img, rep, j);
//écrire la qst ds le fichier
 oq.writeObject(qe);
}
}

fileQst.close();
oq.close(); 

} catch (FileNotFoundException e) {
System.out.println("File not found");
} catch (IOException e) {
System.out.println("Error initializing stream");
}
}

// la methode supprimer qui supprime tous les contenants et inisialise la fenetre 
public void Supprimer() {
  btn1.setBounds(0, 0, 0, 0);
  btn2.setBounds(0, 0, 0, 0);
  btn3.setBounds(0, 0, 0, 0);
  btn4.setBounds(0, 0, 0, 0);
  btn5.setBounds(0, 0, 0, 0);
  btn7.setBounds(0,0,0,0);
  b1.setBounds(0, 0, 0, 0);
  b2.setBounds(0, 0, 0, 0);
  labelTitle.setBounds(0, 0, 0, 0);
  labelSignUp.setBounds(0, 0, 0, 0);
  labelLogIn.setBounds(0, 0, 0, 0);
  tf1.setBounds(0, 0, 0, 0);  tf1.setText("");
  tf2.setBounds(0, 0, 0, 0);  tf2.setText("");
  tf31.setBounds(0, 0, 0, 0); tf31.setText("");
  tf32.setBounds(0, 0, 0, 0); tf32.setText("");
  tf33.setBounds(0, 0, 0, 0); tf33.setText("");
  tf4.setBounds(0, 0, 0, 0);  tf4.setText("");
  txt.setBounds(0,0,0,0);
  tf1JLabel.setBounds(0,0,0,0);
  tf2JLabel.setBounds(0,0,0,0);
  tf3JLabel.setBounds(0,0,0,0);
  tf4JLabel.setBounds(0,0,0,0);
  txt.setText("");
}


//la méthode qui permet d'afficher tous les joueurs inscrits
public void AfficherInfosJoueursInscrits() {
  contenu.add(txt);
  txt.setFont(font);
  txt.setForeground(Color.white);
  txt.setBackground(ColorTxt);
  txt.append("La liste des joueurs :" +"\n\n");
  txt.setBounds(0, 0, 1500, 1600);
  //parcourir le hashmap et afficher tous les joueurs
  int i = 0;
  while (i < table.size()) {
    Joueur j = table.get(i);
    txt.append(j.toString()+"\n");    
    i++;  
}
}

//la méthode qui permet d'initialiser la fenetre et afficher le menu principal
public void menu(){
//initialiser la fenetre
Supprimer();
//ajouter les boutons principaux
contenu.add(btn1);
contenu.add(btn2);
contenu.add(btn3);
contenu.add(btn4);
contenu.add(btn5); 
contenu.add(btn6);
contenu.add(btn7);

// positionner les boutons principaux
btn1.setBounds(200, 200, 300, 85);
btn2.setBounds(200, 330, 300, 85);
btn3.setBounds(1000, 200, 300, 85);
btn4.setBounds(1000, 330, 300, 85);
btn5.setBounds(600, 670, 300, 85);
btn6.setBounds(600, 800, 300, 85);
btn7.setBounds(600,540,300,85);

//Définir et personnaliser un titre pour notre jeu
contenu.add(labelTitle);
labelTitle.setFont(policeTitle); 
labelTitle.setForeground(ColorTitle);
labelTitle.setBounds(450, 50, 600, 100); 

}



//la méthode qui ajout des  champs de saisie(on l'utilise pour factoriser le code)
public void Add(int nb){
Supprimer();
//ajouter les  composants graphiques communs entre l'inscripton et la connexion
contenu.add(tf1);  
contenu.add(tf4); 

contenu.add(tf1JLabel);
contenu.add(tf4JLabel); 
//positionner ses composants graphiques
tf1.setBounds(600, 150, 300, 50); 
tf1JLabel.setBounds(500, 150, 300, 50);

//personnaliser ces composants graphiques
tf1JLabel.setFont(font); 
tf1.setBackground(c);
tf4.setBackground(c);  

tf1JLabel.setForeground(Color.white);
tf4JLabel.setFont(font); 
tf4JLabel.setForeground(Color.white);



//cas sign in
if(nb==1){
      //on ajoute un titre
      contenu.add(labelSignUp);

//Ajouter des composants graphiques nécessaires à l'inscription
      contenu.add(tf2);
      contenu.add(tf31);
      contenu.add(tf32);
      contenu.add(tf33);
      contenu.add(tf2JLabel); 
      contenu.add(tf3JLabel); 
  
      contenu.add(b1);

//positionner les composants graphiques
      tf2.setBounds(600, 300, 300, 50);   
      tf31.setBounds(550, 450, 100, 50); 
      tf32.setBounds(700, 450, 100, 50);  
      tf33.setBounds(850, 450, 100, 50);  
      tf4.setBounds(600,600,300,50);

      tf2JLabel.setBounds(500, 300, 300, 50);
      tf3JLabel.setBounds(250, 450, 300, 50);
      tf4JLabel.setBounds(440, 600, 300, 50);   
      
      labelSignUp.setBounds(500, 20, 700, 100);
     
      b1.setBounds(600, 700, 300, 50);

//personnaliser les composants graphiques
      tf2JLabel.setFont(font);
      tf2JLabel.setForeground(Color.white);
      tf3JLabel.setFont(font);
      tf3JLabel.setForeground(Color.white);
    
      tf2.setBackground(c);
      tf31.setBackground(c);
      tf32.setBackground(c);
      tf33.setBackground(c);
      tf4.setBackground(c);

      labelSignUp.setFont(policeSubTitle);
      labelSignUp.setForeground(ColorTitle);      
}
//cas log in 
else{
//Ajouter des composants graphiques nécessaires à la connexion
  contenu.add(labelLogIn);
  contenu.add(b2);
//positionner les composants graphiques
  tf4.setBounds(600, 300, 300, 50);
  tf4JLabel.setBounds(440, 300, 300, 50);
  
  b2.setBounds(600, 600, 300, 50);
  labelLogIn.setBounds(550, 20, 600, 100);

//personnaliser les composants graphiques
  labelLogIn.setFont(policeSubTitle);
  labelLogIn.setForeground(ColorTitle);

}

}



public static void main(final String[] args) {
    EUREKA erk=new EUREKA();
   
} 

}



