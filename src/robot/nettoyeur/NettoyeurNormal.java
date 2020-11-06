package robot.nettoyeur;

import monde.Monde;
import robot.Robot;

public class NettoyeurNormal extends Robot {
    private final int LEFT = -1;
    private final int RIGHT = 1;
    private final int TOP = 1;
    private final int BOTTOM = -1;
    private int dx = RIGHT;
    private int dy = BOTTOM;
    public NettoyeurNormal(int coordI, int coordJ) {
        super(coordI, coordJ);
    }

    @Override
    public void move(Monde m) {
        if (dx == RIGHT) {
            if (m.isMoveToRightPossible(this.getCoordI(), this.getCoordJ())){
                this.moveToRight();
            }
            else moveVertical(m, LEFT);
        }
        else {
            if (m.isMoveToLeftPossible(this.getCoordI(), this.getCoordJ())){
                this.moveToLeft();
            }
            else {
                moveVertical(m, RIGHT);
            }
        }

    }

    private void moveVertical(Monde m, int right) {
        if(dy == BOTTOM){
            dx = right;
            if (m.isMoveToBottomPossible(this.getCoordI(), this.getCoordJ())){
                this.moveToBottom();
            }
            else {
                dy = TOP;
                move(m);
            }
        }
        // dy == TOP
        else {
            dx = right;
            if (m.isMoveToTopPossible(this.getCoordI(), this.getCoordJ())){
                this.moveToTop();
            }
            else {
                dy = BOTTOM;
                move(m);
            }
        }
    }

    @Override
    public void action(Monde m) {
        boolean isRemoved = m.removePapier(this.getCoordI(), this.getCoordJ());
        if (isRemoved){
            System.out.println(this.toString() + " a RETIRÉ un pipier gras de la case");
        }
    }

    @Override
    public String toString() {
        return "N" + getNumeroSerie();
    }
}
