import intelligence_artificielle.modele.capteur.CapteurPassage;
import intelligence_artificielle.modele.capteur.CapteurUtilisation;
import intelligence_artificielle.modele.manager.ManagerGeneral;
import intelligence_artificielle.vue.FenetreLogging;
import simulation.modele.*;
import simulation.modele.element.*;
import simulation.modele.element.deuxEtats.AppareilDeuxEtats;
import simulation.modele.element.deuxEtats.PlaqueCuisson;
import simulation.modele.element.deuxEtats.Television;
import simulation.modele.element.utilisable.*;
import simulation.vue.DessinHorloge;
import simulation.vue.DessinMaison;
import simulation.vue.DessinThermostat;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Maison maison = new Maison();

        Piece chambre = new Piece(0, 0, 200, 100, "chambre", 160, 50);
        Piece salleDeBain = new Piece(200, 0, 150, 65, "salle de bain", 100, 50);
        Piece wc = new Piece(250, 65, 100, 35, "wc", 40, 18);
        Piece couloir = new Piece(200, 65, 50, 235, "couloir", 25, 120);
        Piece salon = new Piece(0, 100, 200, 200, "salon", 50, 50);
        Piece cuisine = new Piece(250, 100, 100, 200, "cuisine", 50, 145);

        maison.setEntree(salon);

        HashMap<Point, Piece> connexions = new HashMap<>();
        connexions.put(new Point(200, 87), couloir);
        chambre.setConnexions(connexions);

        connexions = new HashMap<>();
        connexions.put(new Point(11, 65), couloir);
        salleDeBain.setConnexions(connexions);

        connexions = new HashMap<>();
        connexions.put(new Point(5, 22), couloir);
        wc.setConnexions(connexions);

        connexions = new HashMap<>();
        connexions.put(new Point(0, 22), chambre);
        connexions.put(new Point(11, 0), salleDeBain);
        connexions.put(new Point(50, 22), wc);
        connexions.put(new Point(0, 195), salon);
        connexions.put(new Point(50, 50), cuisine);
        couloir.setConnexions(connexions);

        connexions = new HashMap<>();
        connexions.put(new Point(200, 160), couloir);
        connexions.put(new Point(0, 11), null);
        salon.setConnexions(connexions);

        connexions = new HashMap<>();
        connexions.put(new Point(0, 15), couloir);
        cuisine.setConnexions(connexions);

        maison.ajouterCapteur(new CapteurPassage(salon, null));
        maison.ajouterCapteur(new CapteurPassage(salon, couloir));
        maison.ajouterCapteur(new CapteurPassage(cuisine, couloir));
        maison.ajouterCapteur(new CapteurPassage(wc, couloir));
        maison.ajouterCapteur(new CapteurPassage(salleDeBain, couloir));
        maison.ajouterCapteur(new CapteurPassage(chambre, couloir));

        maison.ajouterSalle(chambre);
        maison.ajouterSalle(salleDeBain);
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
        salon.ajouter(new Canape(60, 120, 27, 74, Orientation.Ouest));
        salon.ajouter(new Television(8, 140, 27, 34, Orientation.Est));
        salon.ajouter(new Mur(0, 0, 0, 200));
        salon.ajouter(new Mur(0, 199, 200, 0));
        salon.ajouter(new Porte(0, 2, 20, Orientation.Est));

        cuisine.ajouter(new Meuble(0, 30, 30, 100));
        cuisine.ajouter(new Meuble(0, 160, 30, 40));
        cuisine.ajouter(new Meuble(30, 170, 30, 30));
        cuisine.ajouter(new Meuble(60, 170, 40, 30));
        cuisine.ajouter(new PlaqueCuisson(0, 130, 30, 30));
        cuisine.ajouter(new Mur(0, 199, 100, 0));
        cuisine.ajouter(new Mur(99, 0, 0, 200));

        salleDeBain.ajouter(new Baignoire(5, 5, 100, 30, Orientation.Sud));
        salleDeBain.ajouter(new Meuble(120, 35, 30, 30));
        salleDeBain.ajouter(new Mur(0, 0, 150, 0));
        salleDeBain.ajouter(new Mur(149, 0, 0, 65));
        salleDeBain.ajouter(new Mur(0, 64, 150, 0));
        salleDeBain.ajouter(new Porte(1, 65, 20, Orientation.Nord));

        wc.ajouter(new Toilette(65, 5, 25, 25, Orientation.Ouest));
        wc.ajouter(new Mur(0, 0, 0, 35));
        wc.ajouter(new Mur(99, 0, 0, 35));
        wc.ajouter(new Mur(0, 34, 100, 0));
        wc.ajouter(new Porte(0, 32, 20, Orientation.Nord));

        couloir.ajouter(new Mur(0, 234, 50, 0));

        for (Piece p : maison.getPieces()) {
            for (Element e : p.getElements()) {
                if (e instanceof Utilisable || e instanceof AppareilDeuxEtats)
                    e.setCapteur(new CapteurUtilisation(e, p));
            }
        }

        ManagerGeneral.getInstance().setMaison(maison);
        Habitant habitant = new Habitant(maison);

        DessinMaison dessinMaison = new DessinMaison(maison, habitant);

        new Thread(Horloge.getInstance()).start();
        Horloge.getInstance().ajouterObserver(new DessinHorloge());

        new DessinThermostat(maison.getThermostat());

        FenetreLogging.initialiser();

        Horloge.getInstance().ajouterObserver(dessinMaison);
        Horloge.getInstance().ajouterObserver(ManagerGeneral.getInstance());

        habitant.ajouterObserver(dessinMaison);
    }
}
