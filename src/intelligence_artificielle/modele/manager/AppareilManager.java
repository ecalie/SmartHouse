package intelligence_artificielle.modele.manager;

import simulation.modele.Constante;
import simulation.modele.Piece;
import simulation.modele.element.deuxEtats.AppareilDeuxEtats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppareilManager {

    private HashMap<Piece, List<ThreadSlave>> threads;

    public AppareilManager() {
        this.threads = new HashMap<>();
    }

    public void traiterAppareil(AppareilDeuxEtats appareil, Piece piece) {
        // un appareil est allumée et l'habitan vient de sortir de la pièce
        // démarrer un thre pour l'appareil
        ThreadSlave threadSlave = new ThreadSlave(appareil, this);

        // ajouter ce thread à la map des threads
        if (!threads.containsKey(piece)) {
            threads.put(piece, new ArrayList<>());
        }
        threads.get(piece).add(threadSlave);

        // démarrer le thread
        threadSlave.start();
    }

    public void stopper(Piece piece) {
        // la personne est revenu dans la pièce
        if (threads.containsKey(piece)) {
            for (ThreadSlave thread : threads.get(piece)) {
                thread.stop();
            }
            threads.remove(piece);
        }
    }

    public void terminer(ThreadSlave thread) {
        // le compte à rebourd est terminé
        for (Piece p : threads.keySet())
            threads.get(p).remove(thread);
    }
}

/**
 * Lancer un chrnonomètre avant d'éteindre les appareils.
 */
class ThreadSlave extends Thread {
    private AppareilDeuxEtats appareil;
    private AppareilManager manager;

    public ThreadSlave(AppareilDeuxEtats appareil, AppareilManager manager) {
        this.appareil = appareil;
        this.manager = manager;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Constante.tempsEteindre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        appareil.eteindre();
        manager.terminer(this);
    }
}