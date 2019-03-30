package intelligence_artificielle.vue;

import javax.swing.*;
import java.awt.*;

public class FenetreLogging extends JFrame {
    private static FenetreLogging instance;
    private static JTextArea loggingCapteurs;
    private static JTextArea loggingAppareils;

    public static FenetreLogging getInstance() {
        if (instance == null)
            instance = new FenetreLogging();
        return instance;
    }

    private FenetreLogging() {
        super("Logging");
        this.setLayout(new BorderLayout());
        loggingCapteurs = new JTextArea(20,25);
        loggingCapteurs.setBackground(Color.GRAY);
        this.add(new JScrollPane(loggingCapteurs), BorderLayout.EAST);

        loggingAppareils = new JTextArea(20,25);
        loggingAppareils.setBackground(Color.GRAY);
        this.add(new JScrollPane(loggingAppareils), BorderLayout.WEST);

        this.pack();
        this.setVisible(true);
        this.setLocation(500,0);
    }

    public static void ajouterLoggingCapteur(String texte) {
        if (instance == null)
            instance = new FenetreLogging();

        loggingCapteurs.setText(loggingCapteurs.getText() + "\n" + texte);
    }

    public static void ajouterLoggingAction(String texte) {
        if (instance == null)
            instance = new FenetreLogging();

        loggingAppareils.setText(loggingAppareils.getText() + "\n" + texte);
    }
}
