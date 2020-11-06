package robot.pollueur;

import monde.Monde;
import robot.Robot;
import robot.RobotInterface;
import utils.Utiles;

public class RobotIdiot extends Robot {
    private final double probabilite = 20;
    private final int LEFT = 0;
    private final int TOP = 1;
    private final int RIGHT = 2;
    private final int BOTTOM = 3;

    public RobotIdiot(int coordI, int coordJ) {
        super(coordI, coordJ);
    }

    @Override
    public void move(Monde m) {
        int coordI = this.getCoordI();
        int coordJ = this.getCoordJ();

        int choixDeplacement = Utiles.getRandomNumberInRange(0, 3);
        switch (choixDeplacement){
            case LEFT:
                if (m.isMoveToLeftPossible(coordI, coordJ)){
                    moveToLeft();
                }
                else {
                    moveToRight();
                }
                break;
            case TOP:
                if (m.isMoveToTopPossible(coordI, coordJ)){
                    moveToTop();
                }
                else {
                    moveToBottom();
                }
                break;
            case RIGHT:
                if (m.isMoveToRightPossible(coordI, coordJ)){
                    moveToRight();
                }
                else {
                    moveToLeft();
                }
                break;
            case BOTTOM:
                if (m.isMoveToBottomPossible(coordI, coordJ)){
                    moveToBottom();
                }
                else {
                    moveToTop();
                }
                break;
        }
    }

    @Override
    public void action(Monde m) {
        int r = Utiles.getRandomNumberInRange(0, 100);
        if (r <= probabilite) {
            m.putPapier(getCoordI(), getCoordJ());
            System.out.println(this.toString() + " a DÉPOSÉ un pipier gras sur la case ");
        }
    }

    @Override
    public String toString() {
        return "I" + getNumeroSerie();
    }
}
