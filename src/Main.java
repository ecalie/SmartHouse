import intelligence_artificielle.modele.Habitant;
import modelisation.modele.element.*;
import modelisation.modele.element.utilisable.*;
import modelisation.modele.element.deuxEtats.*;
import modelisation.modele.Maison;
import modelisation.modele.Piece;
import modelisation.vue.DessinMaison;

public class Main {

    public static void main(String[] args) {
        Maison maison = new Maison();

        Piece chambre = new Piece(0, 0, 200, 100, "chambre",160,50);
        Piece pieceDeBain = new Piece(200, 0, 150, 65, "salle de bain",100,50);
        Piece wc = new Piece(250, 65, 100, 35, "wc",40,18);
        Piece couloir = new Piece(200, 65, 50, 235, "couloir",25,120);
        Piece salon = new Piece(0, 100, 200, 200, "salon",50,50);
        Piece cuisine = new Piece(250, 100, 100, 200, "cuisine",50,145);

        maison.setEntree(salon);

        maison.ajouterSalle(chambre);
        maison.ajouterSalle(pieceDeBain);
        maison.ajouterSalle(wc);
        maison.ajouterSalle(couloir);
        maison.ajouterSalle(salon);
        maison.ajouterSalle(cuisine);

        chambre.ajouter(new Lit(75, 10, 50, 70, Orientation.Nord));
        chambre.ajouter(new Meuble(35, 7, 20, 20));
        chambre.ajouter(new Meuble(145, 7, 20, 20));
        chambre.ajouter(new Mur(0, 0, 200, 0));
        chambre.ajouter(new Mur(0, 0, 0, 100));
        chambre.ajouter(new Mur(199, 0, 0, 100));
        chambre.ajouter(new Mur(0, 99, 200, 0));
        chambre.ajouter(new Porte(200, 97, 20, Orientation.Ouest));

        salon.ajouter(new Table(110, 40, 60, 60));
        salon.ajouter(new Chaise(130, 10, 20, 20, Orientation.Sud));
        salon.ajouter(new Chaise(80, 60, 18, 20, Orientation.Est));
        salon.ajouter(new Chaise(130, 110, 20, 18, Orientation.Nord));
        salon.ajouter(new Chaise(179, 60, 20, 20, Orientation.Ouest));
        Canape canape = new Canape(60, 120, 27, 74, Orientation.Ouest);
        salon.ajouter(canape);
        salon.ajouter(new Television(8, 140, 27, 34, Orientation.Est));
        salon.ajouter(new Mur(0,0,0,200));
        salon.ajouter(new Mur(0,199,200,0));
        salon.ajouter(new Porte(0,2,20,Orientation.Est));

        cuisine.ajouter(new Meuble(0,30,30,100));
        cuisine.ajouter(new Meuble(0,160,30,40));
        cuisine.ajouter(new Meuble(30,170,30,30));
        cuisine.ajouter(new Meuble(60,170,40,30));
        PlaqueCuisson plaqueCuisson = new PlaqueCuisson(0,130,30,30);
        cuisine.ajouter(plaqueCuisson);
        cuisine.ajouter(new Mur(0,199,100,0));
        cuisine.ajouter(new Mur(99,0,0,200));

        pieceDeBain.ajouter(new Baignoire(5,5,100,30,Orientation.Sud));
        pieceDeBain.ajouter(new Meuble(120,35,30,30));
        pieceDeBain.ajouter(new Mur(0,0,150,0));
        pieceDeBain.ajouter(new Mur(149,0,0,65));
        pieceDeBain.ajouter(new Mur(0,64,150,0));
        pieceDeBain.ajouter(new Porte(1,65,20,Orientation.Nord));

        wc.ajouter(new Toilette(65,5,25,25, Orientation.Ouest));
        wc.ajouter(new Mur(0,0,0,35));
        wc.ajouter(new Mur(99,0,0,35));
        wc.ajouter(new Mur(0,34,100,0));
        wc.ajouter(new Porte(0,32,20,Orientation.Nord));

        couloir.ajouter(new Mur(0,234,50,0));


        Habitant habitant = new Habitant(maison);
        DessinMaison dessinMaison = new DessinMaison(maison, habitant);
        habitant.ajouterObserver(dessinMaison);

        habitant.allumer(plaqueCuisson);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        habitant.eteindre(plaqueCuisson);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        habitant.utiliser(canape, 5000);
    }
}
