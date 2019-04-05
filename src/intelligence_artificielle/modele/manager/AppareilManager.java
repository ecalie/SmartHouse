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
        // un appareil a été allumé
        ThreadSlave threadSlave = new ThreadSlave(appareil, this);
        if (!threads.containsKey(piece)) {
            threads.put(piece, new ArrayList<>());
        }
        threads.get(piece).add(threadSlave);

        threadSlave.start();
    }

    public void stopper(Piece piece) {
        if (threads.containsKey(piece)) {
            for (ThreadSlave thread : threads.get(piece)) {
                thread.destroy();
            }
            threads.remove(piece);
        }
    }

    public void terminer(ThreadSlave thread) {
        for (Piece p : threads.keySet())
            threads.get(p).remove(thread);
    }
}

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