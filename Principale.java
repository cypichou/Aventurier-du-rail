package ProjetAR;
import java.util.Scanner;

public class Principale {
    
    public static void main(String[] args) {

     //________________________________________________\\ INITIALISATION // ____________________________________________________\\ 


        int[] cartes = { 3 , 4 , 5 , 2 , 4, 1, 3, 2, 6}; // Blanc, Mauve, Vert, Bleu, Marron, Rouge, Noir, Jaune, Locomotive
        //la declaration des joueurs
        Joueur kevin = new Joueur("ParisBrest", 23, cartes, 3, 0 );
        /**
        
        *Joueur clitorine = new Joueur("LondresParis", 23, cartes, 3, 0);
        *Joueur kunegonde = new Joueur("BerlinsStockom", 23, cartes, 3, 0);
        */

        Chemins[] obj = new Chemins[4]; // création du tableau des chemins
        for(int i=0;i<obj.length;i++){
                    obj[i] =  new Chemins(); // création des chemins
        }

        init(obj);

     //________________________________________________\\ JEU // ____________________________________________________\\ 

        
        poseWagon(obj, kevin); // va demander au joueur quel chemin veut il prendre, si il ne peut pas il va falloir en sortir et proposer les cartes ou les missions, si il peut la fct enleve le nbr de cartes et de wagons au joueur et ajoute ses points
        //                               la fonction va de pair avec tireCartes et tireMissions
        
    }       

    public static void poseWagon(Chemins[] Obj, Joueur e) {
        
        int Choix = quelChemins(Obj); // index de du chemin choisi par le joueur, en cas de pose de wagon

        int indiceCouleur = 0;

        if (Obj[quelChemins(Obj)].isStatut() == false){
            System.out.println("ce chemin est occupé, voulez-vous placer une gare? -> oui ->non ");
            System.out.print("->");
 
        }else{

            if(Obj[Choix].getTaille() > e.getWagons() ){
                    System.out.print("tu n'as pas assez de wagons");
                    indiceCouleur = indiceCouleur(Obj[Choix]);
                } 
                
                else if(e.getCarte(indiceCouleur) >= Obj[Choix].taille) {
                    Obj[Choix].statut = false;
                    // retirer le nbr de cartes
                    // augmenter les points
                    // verfi missions
                }
        }
        
    }

    public static int indiceCouleur(Chemins c) {
        if(c.getCouleur().equals("banc")){
            return 1;
        }
        if(c.getCouleur().equals("mauve")){
            return 2;
        }
        if(c.getCouleur().equals("vert")){
            return 3;
        }
        if(c.getCouleur().equals("bleu")){
            return 4;
        }
        if(c.getCouleur().equals("marron")){
            return 5;
        }
        if(c.getCouleur().equals("rouge")){
            return 6;
        }
        if(c.getCouleur().equals("noir")){
            return 7;
        }
        if(c.getCouleur().equals("jaune")){
            return 8;
        }
        // if(c.getCouleur().equals("locomotive")){
        //     return 9;
        // }
        return 9;
    }
    public static void init(Chemins[] Obj) {
        Obj[0].setext1("Londres"); // ParisLondres
        Obj[0].setext2("Paris");
        Obj[0].setCouleur("rouge");
        Obj[0].setStatut(true);
        Obj[0].setTunnel(false);
        Obj[0].setTaille(2);

        Obj[1].setext1("Paris"); // ParisBerlin
        Obj[1].setCouleur("marron");
        Obj[1].setext2("Berlin");
        Obj[1].setStatut(true);
        Obj[1].setTaille(5);
        Obj[1].setTunnel(true);

        Obj[2].setext1("Paris"); //ParisSAntander
        Obj[2].setCouleur("noir");
        Obj[2].setext2("Santander");
        Obj[2].setStatut(true);
        Obj[2].setTaille(4);
        Obj[2].setTunnel(false);
        
        Obj[3].setCouleur("noir");  // Obj[3]
        Obj[3].setStatut(true);      
        Obj[3].setTaille(2);       
        Obj[3].setTunnel(true);        
        Obj[3].setext1("Oslo");        
        Obj[3].setext2("Kopenague");
    }
    public static int quelChemins(Chemins Obj[]) { // fonction qui retourne l'indice (du le tableau obj) du chemin voulu par le joueur
    // faire attention si pas de chemin retourne -1
        int longuobj = Obj.length;
        Scanner slct = new Scanner(System.in);
        
        System.out.print("quel est votre point de départ? "); 
         
        String choix1 = slct.next();
        
        for(int i=0; i<longuobj;i++){ // boucle qui ne sert qu'a l'affiche des destinations possibles.
                                        // avec un affichage graphique elle ne sera peut être plus tres utile
            
                if (Obj[i].getext2().equals(choix1)){ 
                        System.out.print("-> ");
                        System.out.println(Obj[i].getext1());
                    }
                if (Obj[i].getext1().equals(choix1)){ 
                    System.out.print("-> ");
                    System.out.println(Obj[i].getext2());     
                }
        }
        
        System.out.print("Voici les arrivées possibles, laquelle souhaitez vous? ");
        
        String choix2 = slct.next();

        for(int i=0; i<longuobj;i++){ // boucle qui ne sert qu'a l'affiche des destinations possibles.
                                        // avec un affichage graphique elle ne sera peut être plus tres utile
            
                if (Obj[i].getext2().equals(choix2) && Obj[i].getext1().equals(choix1)||
                    Obj[i].getext2().equals(choix1) && Obj[i].getext1().equals(choix2)){
                        return i;
                } 
        }


        return -1;
    }
}
