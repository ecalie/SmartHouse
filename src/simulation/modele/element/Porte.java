package simulation.modele.element;

public class Porte extends Element {

    private Orientation sensOuverture;

    public Porte(int x, int y, int taille, Orientation sensOuverture) {
        super(x, y, taille, taille);
        this.sensOuverture = sensOuverture;
    }

    public Orientation getSensOuverture() {
        return sensOuverture;
    }
}
