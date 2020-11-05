package robot;

public abstract class Robot implements RobotInterface{
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

    protected void move(int dI, int dJ){
        coordI += dI;
        coordJ += dJ;
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

    public void setCoordI(int coordI) {
        this.coordI = coordI;
    }

    public void setCoordJ(int coordJ) {
        this.coordJ = coordJ;
    }
}
