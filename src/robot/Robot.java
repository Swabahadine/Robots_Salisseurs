package robot;

import monde.Monde;

public abstract class Robot {
    private int coordI;
    private int coordJ;
    private int numeroSerie;
    protected static int globalNumeroSerie = 0;

    public Robot() {
        numeroSerie = globalNumeroSerie++;
    }

    public Robot(int coordI, int coordJ) {
        this();
        this.coordI = coordI;
        this.coordJ = coordJ;
    }

    // méthodes abstraites:
    public abstract void move(Monde m);
    public abstract void action(Monde m);

    /**
     * Pour logger le deplacement d'un robot
     * @param dI
     * @param dJ
     */
    private void loggerMove(int dI, int dJ){
        String log = String.format("%s a fait une translation de (%d,%d):", toString(), dI, dJ);
        System.out.println(log);
        if (dI > 0) {
            log = String.format("il s'est deplace de %d fois vers le BAS", dI);
            System.out.print(log);
        }
        else {
            log = String.format("il s'est deplace de %d fois vers le HAUT", Math.abs(dI));
            System.out.print(log);
        }
        if (dJ > 0) {
            log = String.format(" et %d fois vers la DROITE", dJ);
            System.out.println(log);
        }
        else {
            log = String.format(" et de %d fois vers la GAUCHE", Math.abs(dJ));
            System.out.println(log);
        }
    }

    protected void move(int dI, int dJ){
        coordI += dI;
        coordJ += dJ;
        loggerMove(dI, dJ);
    }

    protected void moveToBottom(){
        this.move(1, 0);
    }

    protected void moveToTop(){
        this.move(-1, 0);
    }

    protected void moveToRight(){
        this.move(0, 1);
    }

    protected void moveToLeft(){
        this.move(0, -1);
    }

    public int getCoordI() {
        return coordI;
    }

    public int getCoordJ() {
        return coordJ;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }
}
