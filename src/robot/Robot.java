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

    protected void move(int dI, int dJ){
        //Log avant déplacement
        String log = String.format("%s (%d,%d) a fait une translation de (%d,%d):\n",toString(), getCoordI(), getCoordJ(), dI, dJ);

        coordI += dI;
        coordJ += dJ;

        // Log après déplacement
        log += String.format("il s'est deplace sur la case (%d,%d)",getCoordI(), getCoordJ());
        System.out.println(log);
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
