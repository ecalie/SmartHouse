package intelligence_artificielle.vue;

import javax.swing.*;
import java.awt.*;

public class FenetreLogging extends JFrame {
    private static FenetreLogging instance;
    private static JTextArea loggingCapteurs;

    private FenetreLogging() {
        super("Logging");
        loggingCapteurs = new JTextArea(40, 25);
        loggingCapteurs.setBackground(Color.GRAY);
        this.add(new JScrollPane(loggingCapteurs));

        this.pack();
        this.setVisible(true);
        this.setLocation(500, 100);
    }

    /**
     * Initialiser la fenêtre.
     */
    public static void initialiser() {
        if (instance == null)
            instance = new FenetreLogging();
    }

    /**
     * Ajouter une action de l'habitant.
     *
     * @param texte Description de cette action
     */
    public static void ajouterLoggingCapteur(String texte) {
        if (instance == null)
            instance = new FenetreLogging();

        loggingCapteurs.setText(loggingCapteurs.getText() + "\n" + texte);
    }
}
