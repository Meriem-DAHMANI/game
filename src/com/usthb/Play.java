package com.usthb;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.util.*;
import java.awt.event.*;
import com.usthb.dessin.*;
import com.usthb.modeles.*;
import com.usthb.modeles.Button;

public class Play extends JFrame {
  public static Container contenu;
  Play pl = this;

  // les déclarations
  private ArrayList<PartieJeu> listParties = new ArrayList<PartieJeu>();

  //les zones de texte et les labels
  private JTextField t1 = new JTextField();
  private JTextField t2 = new JTextField();
  private String word;
  private JLabel label1 = new JLabel("typed character");
  private JLabel label2 = new JLabel("current answer");
  private JLabel label3 = new JLabel("");
  private JLabel label4 = new JLabel("");

  private JMenuBar menuBar = new JMenuBar();
  private JMenu menu = new JMenu("Partie");

//items du menu de la partie
  private JMenuItem item0 = new JMenuItem("My score");
  private JMenuItem item1 = new JMenuItem("My total score");
  private JMenuItem item2 = new JMenuItem("Help");
  private JMenuItem item3 = new JMenuItem("Quit");

//les boutons du menu principal
  private Button b1 = new Button("✗ HISTOIRE", "bouton.jpg", 40, 50);
  private Button b2 = new Button("✗ GÉOGRAPHIE", "bouton.jpg", 20, 50);
  private Button b3 = new Button("✗ SANTÉ", "bouton.jpg", 70, 50);
  private Button b4 = new Button("✗CULTUREGÉNÉRALE", "bouton.jpg", 00, 50);
  private Button b5 = new Button("✗ ISLAM", "bouton.jpg", 70, 50);

//les 2 boutons de la partie
  private JButton bt1 = new JButton("Continue");
  private JButton bt2 = new JButton("Quit");
//cntrl pour ajouter un controle en cas d'erreur
  private Controle cntrl;
//font pour personnaliser le texte
  private Font font = new Font("Tahoma", Font.BOLD, 15);

  private Color c=new ColorUIResource(177,231, 255);
//Potence pour afficher le dessin de pendu
  private Potence pt = new Potence();
//pour avoir le score cumulé du joueur durant sa dernière connexion
  private int ScoreCourant=0;


  private  int num = 0;// i représente le numéro de la qst ds ArrayList
  private int b = 500;//y du boton btn

  public Play(Joueur j, HashSet<ThèmeJeu> set) {
    this.setSize(1490, 1000);
    this.setTitle("EUREKA");
    this.setVisible(true);
    // Nous demandons à notre objet de se positionner au centre
    this.setLocationRelativeTo(null);
    // this.setContentPane(new Panneau());
    this.setVisible(true);
    this.setContentPane(new Panneau(2));
    contenu = this.getContentPane();
    contenu.setLayout(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    // On initialise nos menus
    this.menu.add(item0);
    this.menu.add(item1);
    this.menu.add(item2);
    this.menu.add(item3);

    // Ajout d'un séparateur
    this.menu.addSeparator();

    this.menuBar.add(menu);
    this.setJMenuBar(menuBar);

    // si le joueur a déjà réalisé des parties , on récupère le dernier niveau atteint
    if (j.getListe() != null) {
    	
    	     //si le dernier niveau est 5 ,on 
    	      if(j.getDernier_niveau()==5){
    	        num=0;
    	      }
    	      else{
    	       num=j.getDernier_niveau()*2;
    	      }
    }

    //afficher les 5 boutons principaux
    menu();
    // on commence la partie
    // si l'utilisateur a choisi le premier thème de la liste
    b1.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
      
        j.Jouer(pl, "HISTOIRE", num);

      }
    });
   
    // si l'utilisateur a choisi le 2 ème thème de la liste
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        j.Jouer(pl, "GÉOGRAPHIE", num);

      }
    });
    // si l'utilisateur a choisi le 3 ème thème de la liste
    b3.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        j.Jouer(pl, "SANTÉ", num);
      }
    });
    // si l'utilisateur a choisi le 4 ème thème de la liste
    b4.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        j.Jouer(pl, "CULTUREGÉNÉRALE", num);

      }
    });
    // si l'utilisateur a choisi le 5 ème thème de la liste
    b5.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        j.Jouer(pl, "ISLAM", num);

      }
    });

    // bt1 permet d'afficher les thèmes
    bt1.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        menu();
      }
    });

    // bt2 permet de fermer la fenetre de la partie
    bt2.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        hide();

      }
    });


    // aficher le score courant du joueur
    item0.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        cntrl = new Controle("  My score   =  " + getScoreCourant(j));
      }
    });

    // aficher le score totale du joueur
    item1.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        cntrl = new Controle("My total score  =  " + j.getTotalScore());
      }
    });

    // afficher l'aide
    item2.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        Help h = new Help();
        h.setVisible(true);
      }
    });

    // item3 permet de fermer la fenetre de la partie
    item3.addActionListener(new ActionListener() {
      public void actionPerformed(final ActionEvent arg0) {
        hide();
      }
    });
  }

  // la méthode qui retourne le score d'un joueur
  int getScoreCourant(Joueur j) {
    return ScoreCourant;
  }

//// la methode supprimer qui supprime tous les contenants et inisialise la fenetre de la partie
 public void supprimer(){
  b1.setBounds(0, 0, 0, 0);
  b2.setBounds(0, 0, 0, 0);
  b3.setBounds(0, 0, 0, 0);
  b4.setBounds(0, 0, 0, 0);
  b5.setBounds(0, 0, 0, 0);
  label1.setBounds(0, 0, 0, 0);
  label2.setBounds(0, 0, 0, 0);
  pt.setSize(0, 0);
  label3.setBounds(0, 0, 0, 0);
  label4.setBounds(0, 0, 0, 0);
  t1.setBounds(0, 0, 0, 0);
  t2.setBounds(0, 0, 0, 0);
  t1.setText("");
  t2.setText("");
  bt1.setBounds(0, 0, 0, 0);
  bt2.setBounds(0, 0, 0, 0);
 } 

  // la méthode play , pour lancer une seule partie
public void play(PartieJeu prt, Joueur j, Question q) {
 //initialiser la fenetre de la partie 
 supprimer();
// Ajouter des composants graphiques nécessaires à la partie
contenu.add(label1);
contenu.add(label2);
contenu.add(label3);
contenu.add(label4);

contenu.add(t1);
contenu.add(t2);
Button btn=new Button("➤","", 15, 35);
contenu.add(btn);

//positionner les composants graphiques
label3.setBounds(700,20,800,50); 
label4.setBounds(750,100,500,350); 
label1.setBounds(300,500,200,50);
t1.setBounds(500,500,200,50);
label2.setBounds(300,600,200,50);
t2.setBounds(500,600,200,50);       
btn.setBounds(800,b,50,50);
b+=1; //changer la position du bouton pour la prochaine qst

//personnaliser les composants graphiques 
t1.setBackground(c);
t2.setBackground(c);

label1.setFont(font);
label1.setForeground(Color.WHITE);
label2.setFont(font);
label2.setForeground(Color.WHITE);

label3.setText(q.getLibellé());
label3.setFont(font);
label3.setForeground(Color.WHITE);
System.out.println(q.getRéponse());

ImageIcon img=new ImageIcon(q.getImage());
label4.setIcon(img);


//réinitialiser la réponse en cours 
StringBuffer sb=new StringBuffer();       
for(int i=0;i<q.getRéponse().length();i++){
  sb.append("*");
} 
prt.setmRpns_crnt(sb);
t2.setText((prt.getmRpns_crnt()).toString());
       
//initialiser la potence
pt.setÉtat(0);
pt.setTrouvé(false);
//personnaliser et afficher la potence au début           
contenu.add(pt); 
pt.setBackground(Color.black);
pt.setSize(550,400);

      
//commencer la partie       
btn.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent arg0){     
//supprimer l'ancienne potence          
pt.setSize(0,0);
word=t2.getText();
if(t1.getText().length()!=1) {
  Controle cntrl = new Controle("Saisissez un caractère ☹!");
  //cntrl.setChaine("Saisissez un caractère ☹!");
  cntrl.setVisible(true);
  }

else {
  t2.setText((prt.checkCaractère(t1.getText(),q.getRéponse())).toString());
}
 
//si la réponse est fausse
if(word.equals(t2.getText())==true){  
if(pt.getÉtat()<8){ //s'il reste encore des coups 
 pt.incrémentEtat();  

 if(pt.getÉtat()==8){//s'il ne reste plus de coups 
 //initialiser la prohaine qst
  if(num%2==0) num++;
  else num--;
//partie perdue
  btn.setBounds(0, 0, 0, 0);  
  pt.setTrouvé(false);
  //donner un choix au joueur de quitter ou continuer 
  contenu.add(bt1); 
  contenu.add(bt2);
  bt1.setBounds(200,765,300,50);
  bt2.setBounds(750,765,300,50);
}
}
}
//Sinon si la réponse est juste
else{
 if((t2.getText()).equals(q.getRéponse())==true){//la réponse est complète
//partie gagnée
btn.setBounds(0, 0, 0, 0);  
pt.setTrouvé(true);
ScoreCourant+=q.getNBPoints();
prt.setmScore(q.getNBPoints());
listParties.add(prt);
j.setListe(listParties);
j.setDernier_niveau(q.getNiveau());
//initialiser la prohaine qst
if(q.getNiveau()<5){
if(num%2==0) num+=2;
else num++;
}
else {
cntrl = new Controle("Vous avez gagné le jeu "+j.getPrénom()+"🙃!!");  
num=0;//pour recommencer dès le permier niveau
}

//donner un choix au joueur de quitter ou continuer 
contenu.add(bt1); 
contenu.add(bt2);
bt1.setBounds(200,765,300,50);
bt2.setBounds(750,765,300,50);
}
}
//réinitialiser la zone de saisi            
t1.setText("");
//afficher la potence           

pt.setSize(550,400);
contenu.add(pt); 
}        
});
}


//aficher les 5 bouttons principaux
public void menu(){
supprimer();
  // ajouter les boutons principaux
    contenu.add(b1);
    contenu.add(b2);
    contenu.add(b3);
    contenu.add(b4);
    contenu.add(b5);

  //positionner les boutons principaux
    b1.setBounds(545, 85, 300, 85);
    b2.setBounds(545, 255, 300, 85);
    b3.setBounds(545, 425, 300, 85);
    b4.setBounds(545, 595, 300, 85);
    b5.setBounds(545, 765, 300, 85);
}


}


