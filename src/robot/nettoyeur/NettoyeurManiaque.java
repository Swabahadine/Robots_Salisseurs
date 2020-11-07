package robot.nettoyeur;

import monde.Monde;
import robot.Robot;

public class NettoyeurManiaque extends Nettoyeur {
    public NettoyeurManiaque(int coordI, int coordJ) {
        super(coordI, coordJ);
    }
    
    @Override
    public void move(Monde m) {
        int DIMENSION = m.getDimension();
        double procheDistance = DIMENSION * DIMENSION;
        int iProche = 0;
        int jProche = 0;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (m.numberOfPapierGrasInCase(i, j) > 0) {
                    double distance = calculDistance(i, j);
                    if (distance < procheDistance) {
                        procheDistance = distance;
                        iProche = i - this.getCoordI();
                        jProche = j - this.getCoordJ();
                    }
                }
            }
        }
        move(iProche, jProche);
    }

    /**
     * Calcul de la distance entre 2 coordonnées d'une matrice orthonormée:
     * les coordonnés courants et des coordonnés donnés en params
     * @param i
     * @param j
     * @return la distance (l'hypothénus)
     */
    private double calculDistance(int i, int j) {
        int segmentX = (Math.abs(j - this.getCoordJ()));
        int segmentY = (Math.abs(i - this.getCoordI()));
        double hypothenus = Math.sqrt(
                Math.pow(segmentX, 2) + Math.pow(segmentY, 2)
        );
        return hypothenus;
    }

    @Override
    public String toString() {
        return "M" + getNumeroSerie();
    }
}
